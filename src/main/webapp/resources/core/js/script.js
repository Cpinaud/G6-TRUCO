const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/spring/partidaBrocker'
});


stompClient.debug = function(str) {
    console.log(str)
};

stompClient.onConnect = (frame) => {
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/messages', (m) => {
        console.log("Contenido --------------")
        console.log(JSON.parse(m.body));
        let imageUrl = JSON.parse(m.body).content;

        // Encuentra la imagen en el documento o crea una nueva
        let imgElement = document.getElementById("imageElementId");
        if (!imgElement) {
            imgElement = document.createElement("img");
            imgElement.id = "imageElementId";
        }

        // Establece el atributo src de la imagen
        imgElement.src = imageUrl;


        console.log("Usuario que envio = " + JSON.parse(m.body).usuario);

        if(!JSON.parse(m.body).usuario){
            // Agrega la imagen al div deseado
            const div_tirada_jugador1 = document.getElementById("tirada_jugador2");
            div_tirada_jugador1.appendChild(imgElement);
        }


    });
};

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};

stompClient.activate();


function moveImage(imageNumber, idUsuario) {


    // Obtén la imagen que se hizo clic
    var sourceImg = document.querySelector("#sourceDiv" + imageNumber + " img");

    // Obtén el elemento de destino
    var destinationDiv = document.getElementById("destinationDiv");

    // Crea una copia de la imagen
    var clonedImg = sourceImg.cloneNode(true);

    // Limpia el contenido actual del elemento de destino
    destinationDiv.innerHTML = "";


    const imageUrl = sourceImg.getAttribute("src");
    stompClient.publish({
        destination: "/app/chat",
        body: JSON.stringify({message: imageUrl, usuarioId: idUsuario})
    });

    // Agrega la imagen clonada al elemento de destino
    destinationDiv.appendChild(clonedImg);

}

