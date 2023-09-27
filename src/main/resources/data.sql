CREATE TABLE if not exists  Palo
(
    id INT PRIMARY KEY auto_increment,
    palo VARCHAR(20)
);


CREATE TABLE if not exists Carta
(
    id INT PRIMARY KEY auto_increment,
    nro	INT,
    palo INT,
    valor INT,
    imagen	VARCHAR(512),
    FOREIGN KEY (palo) REFERENCES Palo(id)
);

-- Insertar los palos
INSERT INTO Palo (palo) VALUES ('oro');
INSERT INTO Palo (palo) VALUES ('espada');
INSERT INTO Palo (palo) VALUES ('copa');
INSERT INTO Palo (palo) VALUES ('basto');

-- Insertar las cartas del palo "oro"
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (1, 1, 8, 'oro1.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (2, 1, 9, 'oro2.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (3, 1, 10, 'oro3.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (4, 1, 1, 'oro4.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (5, 1, 2, 'oro5.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (6, 1, 3, 'oro6.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (7, 1, 11, 'oro7.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (10, 1, 5, 'oro10.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (11, 1, 6, 'oro11.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (12, 1, 7, 'oro12.png');

-- Insertar las cartas del palo "espada"
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (1, 2, 14, 'espada1.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (2, 2, 9, 'espada2.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (3, 2, 10, 'espada3.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (4, 2, 1, 'espada4.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (5, 2, 2, 'espada5.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (6, 2, 3, 'espada6.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (7, 2, 12, 'espada7.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (10, 2, 5, 'espada10.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (11, 2, 6, 'espada11.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (12, 2, 7, 'espada12.png');

-- Insertar las cartas del palo "copa"
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (1, 3, 8, 'copa1.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (2, 3, 9, 'copa2.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (3, 3, 10, 'copa3.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (4, 3, 1, 'copa4.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (5, 3, 2, 'copa5.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (6, 3, 3, 'copa6.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (7, 3, 4, 'copa7.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (10, 3, 5, 'copa10.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (11, 3, 6, 'copa11.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (12, 3, 7, 'copa12.png');

-- Insertar las cartas del palo "basto"
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (1, 4, 13, 'basto1.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (2, 4, 9, 'basto2.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (3, 4, 10, 'basto3.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (4, 4, 1, 'basto4.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (5, 4, 2, 'basto5.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (6, 4, 3, 'basto6.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (7, 4, 4, 'basto7.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (10, 4, 5, 'basto10.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (11, 4, 6, 'basto11.png');
INSERT INTO Carta (nro, palo, valor, imagen) VALUES (12, 4, 7, 'basto12.png');

