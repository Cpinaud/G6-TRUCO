class Partida {



    constructor() {
        this.jugadores = [];
        this.equipos = [];
        this.rondas = [];
    }

    agregarJugadores(jugador) {
        this.jugadores.push(jugador);
    }

    crearRonda(baraja){
        let ronda = {equipos: equipos, jugadores: jugadores, baraja: baraja}
        rondas.push(ronda);
    }

    validarSiTerminoPartida(){
        for (let i = 0; i < this.equipos; i++) {
            if(this.equipos.puntaje >= 30){
                return true;
            }
        }
        return false;
    }
}