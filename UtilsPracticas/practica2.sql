DROP TABLE IF EXISTS categoria;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS catalogo;
DROP TABLE IF EXISTS CATEGORIA_CATALOGO;

CREATE TABLE CATEGORIA (
codigo INT not null AUTO_INCREMENT,
nombre VARCHAR(30) not null,
PRIMARY KEY (codigo)
);

CREATE TABLE USUARIO (
usuario VARCHAR(64) not null,
clave VARCHAR(64) not null,
email VARCHAR(64),
nif VARCHAR(9),
nombre VARCHAR(128),
PRIMARY KEY (usuario)
);

CREATE TABLE CATALOGO (
nombre VARCHAR(30) not null,
fecha DATETIME,
web VARCHAR(60),
url VARCHAR(256),
cod_categoria INT,
usuario VARCHAR(64),
PRIMARY KEY (nombre),
FOREIGN KEY (usuario)
REFERENCES USUARIO(usuario)
);

CREATE TABLE CATEGORIA_CATALOGO (
cod_categoria INT not null,
nom_catalogo VARCHAR(30) not null,
PRIMARY KEY (cod_categoria, nom_catalogo),
FOREIGN KEY (cod_categoria)
REFERENCES CATEGORIA(codigo),
FOREIGN KEY (nom_catalogo)
REFERENCES CATALOGO(nombre)
);

