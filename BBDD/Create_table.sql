create database if not exists BBDD;
use BBDD;

create table if not exists usuario (
id_usuario int(7) unsigned auto_increment not null,
nombre_usuario varchar(45) not null unique,
contrasena varchar(100) not null,
alias varchar (15) not null unique,
primary key (id_usuario)
);

create table if not exists persona (
id_usuario int(7) unsigned not null,
nombre varchar(45) not null,
apellido1 varchar(45) not null,
apellido2 varchar(45),
dni char(9) not null unique,
email varchar(60) not null unique,
curso enum('1','2','3','4'),
fecha_naci date,
profesor boolean not null,
primary key (id_usuario),
constraint fk_usuario_persona foreign key (id_usuario) references usuario(id_usuario) on delete restrict on update cascade
);


create table if not exists reto (
id_reto int(7) unsigned auto_increment not null,
nombre_reto varchar(45) not null,
nivel enum('1','2','3','4'),
primary key (id_reto)
);

create table if not exists calculo (
idpartida int(7) unsigned auto_increment not null,
jugador int(7) unsigned zerofill not null,
reto int(7) unsigned zerofill not null,
fecha_hora datetime,
puntos int(8) unsigned not null,
tiempo_partida time,
tipo enum ('25', '50', '75', '100') not null,
primary key (idpartida),
constraint fk_calculo_usuario foreign key (jugador) references usuario(id_usuario) on delete restrict on update cascade,
constraint fk_calculo_reto foreign key (reto) references reto (id_reto) on delete restrict on update cascade
);


create table if not exists ajuste (
id_ajuste int(7) unsigned auto_increment not null,
usuario int(7) unsigned zerofill not null,
tamaño enum('1','2','3') default '2',
idioma enum('Espanol','Ingles') default 'Espanol',
sonido boolean not null,
primary key (id_ajuste),
constraint fk_ajuste_usuario foreign key (id_ajuste) references usuario(id_usuario) on delete restrict on update cascade
);


