-- Documentación BBDD

-- Apartado de View

-- Vista Resto_Div, contiene la información necesaria para actualizar la información presentada a los alumnos en el Juego Resto de una división entera
Create view view_resto_div_tablas as select alias, time_to_sec(tiempo_partida)  as tiempo_partida, aciertos, fecha_hora,nivel,id_usuario from resto_div inner join usuario on id_usuario = jugador inner join reto on id_reto=reto;
-- Contraparte
Drop view view_resto_div_tablas;


-- vista euclides, contiene la información necesaria para actualizar la información presentada a los alumnos en el Juego Euclides
Create view view_euclides_tablas as select alias, time_to_sec(tiempo_partida) as tiempo_partida, aciertos, fecha_hora,nivel,id_usuario from euclides inner join usuario on id_usuario = jugador inner join reto on id_reto=reto;
-- Contraparte
Drop view view_euclides_tablas;


-- vista calculo, contiene la información necesaria para actualizar la información presentada a los alumnos en el Juego Calculo
Create view view_calculo_tablas as select alias, time_to_sec(tiempo_partida) as tiempo_partida, aciertos, fecha_hora,nivel,id_usuario from calculo inner join usuario on id_usuario = jugador inner join reto on id_reto=reto;
-- Contraparte
Drop view view_calculo_tablas;


-- VistaEstadisticas RestoDiv, genera las estadísticas de los jugadores agrupando por nivel y jugador en función del juego
create view estadisticas_resto_div as select jugador,reto,nivel,count(*) as partidas,sum(aciertos) as totalaciertos, truncate(((sum(aciertos)*5) / (count(*)*5)),2) as mediaAciertos , nombre, apellido1,apellido2
from resto_div inner join reto on id_reto = reto inner join persona on jugador = id_usuario group by jugador,reto order by jugador;
-- Contraparte
Drop view estadisticas_resto_div;


-- VistaEstadisticas Euclides, genera las estadísticas de los jugadores agrupando por nivel y jugador en función del juego
create view estadisticas_euclides as select jugador,reto,nivel,count(*) as partidas,sum(aciertos) as totalaciertos, truncate(((sum(aciertos)*5) / (count(*)*5)),2) as mediaAciertos , nombre, apellido1,apellido2
from euclides inner join reto on id_reto = reto inner join persona on jugador = id_usuario group by jugador,reto order by jugador;
-- Contraparte
Drop view estadisticas_euclides;


-- VistaEstadisticas Calculo, genera las estadísticas de los jugadores agrupando por nivel y jugador en función del juego
create view estadisticas_calculo as select jugador,reto,nivel,count(*) as partidas,sum(aciertos) as totalaciertos, truncate(((sum(aciertos)*25) / (count(*)*25)),2) as mediaAciertos , nombre, apellido1,apellido2
from calculo inner join reto on id_reto = reto inner join persona on jugador = id_usuario group by jugador,reto order by jugador;
-- Contraparte
Drop view estadisticas_calculo;


-- Vista Info Alumnos
create view view_info_alumnos as select nombre_usuario,alias,nombre,apellido1,apellido2,dni,email,curso,fecha_naci 
from usuario inner join persona using(id_usuario) where profesor=0;
-- Contraparte
Drop view view_info_alumnos;


-- Apartado Insert

-- Inserta un usuario nuevo a la tabla Usuario
insert into usuario (nombre_usuario,contrasena,alias) values
('Cbarrios',md5(12345),'AliasKaren');
-- Contraparte
delete from usuario where nombre_usuario = 'Cbarrios';


-- Inserta los datos personales del Usuario en la tabla Persona
insert into persona(id_usuario,nombre,apellido1,apellido2,dni,curso,fecha_naci,profesor,email) values
((select id_usuario from usuario where nombre_usuario='Cbarrios'),'Carmen','Barrios','Fernández','12345678T',1,20000419,0,'123@asd.es');
-- Contraparte
delete from persona where id_usuario = (select id_usuario from usuario where nombre_usuario='Cbarrios');


-- Guarda para cada usuario los ajustes de la aplicación en la tabla Ajustes 
insert into ajuste (usuario,sonido) values
((select id_usuario from usuario where nombre_usuario='Cbarrios'),0);
-- Contraparte
delete from ajuste where usuario = (select id_usuario from usuario where nombre_usuario='Cbarrios');


-- Añade los nombres del Reto (juego) y su nivel correspondiente
insert into reto (nombre_reto,nivel) values
('calculo',1);
-- Contraparte
delete from reto where nombre_reto = 'calculo' and nivel = 1;


-- Datos generados aleatoriamente para la tabla calculo.
insert into calculo(jugador,reto,fecha_hora,aciertos,tiempo_partida) values
((select id_usuario from usuario where nombre_usuario='Cbarrios'),(select id_reto from reto inner join persona on nivel = curso inner join usuario using (id_usuario) 
where nombre_reto = 'calculo' and nombre_usuario = 'Cbarrios'),'2023-03-23 15:09:30',17,sec_to_time(131));
-- Contraparte
delete from calculo where jugador = (select id_usuario from usuario where nombre_usuario='Cbarrios') and fecha_hora = '2023-03-23 15:09:30';


-- Datos generados aleatoriamente para la tabla restodiv.
insert into resto_div(jugador,reto,fecha_hora,aciertos,tiempo_partida) values
((select id_usuario from usuario where nombre_usuario='Cbarrios'),(select id_reto from reto inner join persona on nivel = curso inner join usuario using (id_usuario)
 where nombre_reto = 'resto_div' and nombre_usuario = 'Cbarrios'),'2023-01-07 18:02:03',4,sec_to_time(34));
 -- Contraparte
delete from resto_div where jugador = (select id_usuario from usuario where nombre_usuario='Cbarrios') and fecha_hora = '2023-01-07 18:02:03';


-- Datos generados aleatoriamente para la tabla restodiv.
insert into euclides(jugador,reto,fecha_hora,aciertos,tiempo_partida) values
((select id_usuario from usuario where nombre_usuario='Cbarrios'),(select id_reto from reto inner join persona on nivel = curso inner join usuario using (id_usuario)
 where nombre_reto = 'resto_div' and nombre_usuario = 'Cbarrios'),'2023-01-07 18:02:03',4,sec_to_time(34));
 -- Contraparte
delete from euclides where jugador = (select id_usuario from usuario where nombre_usuario='Cbarrios') and fecha_hora = '2023-01-07 18:02:03';


-- Sentencias dentro del proyecto, en el Paquete BBDD

--  Clase MetodosAjustesBBDD 

-- Metodo guardarAjustes
update ajuste set tamaño = 2 ,idioma= 'Espanol',sonido=0 where usuario= (select id_usuario from usuario where nombre_usuario='Cbarrios');

-- Metodo cargarAjustes
select tamaño,idioma,sonido from ajuste where usuario = 1;


-- Clase MetodosAlumnoBBDD 

-- Metodo selectAlumnos, devuelve un ArrayList, se utiliza para obtener toda la información de lo alumnos y mostrarlo en el apartado del profesor.
-- En función de lo que el usuario introduce en la aplicación se modifican los parámetros
select nombre_usuario,alias,nombre,apellido1,apellido2,dni,email,curso,fecha_naci from view_info_alumnos 
where nombre_usuario like '%%' and alias like '%%' and nombre like '%%' and apellido1 like '%%' and apellido2 like '%%' and dni like '%%' and email like '%%' and curso like '%%';


-- Clase MetodosCalsificacionBBDD 

--  Metodo selectClasificacion,
/* Devuelve un ArrayList, se utiliza para obtener toda la información de lo alumnos relativa a las estadisticas y
mostrarlo en el apartado del profesor.
Recibe como parámetro el nombre del juego y en función de lo que el usuario introduce en la aplicación se modifican los parámetros*/
-- Select utilizado en la aplicacion
/* String select = "select nivel,partidas,totalaciertos,mediaAciertos,nombre,apellido1,apellido2 from estadisticas_"+juego+" 
where nombre like ? and apellido1 like ? and apellido2 like ? and nivel like ?"; */
select nivel,partidas,totalaciertos,mediaAciertos,nombre,apellido1,apellido2 from estadisticas_calculo 
where nombre like '%%' and apellido1 like '%%' and apellido2 like '%%' and nivel like '%%';


-- Clase MetodosJuegoBBDD
-- Esta clase es utilizada por todos los juegos para buscar e insertar datos en la BBDD
-- Como el Id del usuario se almacena en un objeto con a información del usuario no es necesario realizar Select complejos para obtener esta información

-- Método insertResultado
/* se utilizan dos Selects uno para buscar la id del Reto y otro para realizar el Insert en la tabla
Recibe como parámetro el nombre del Juego y el Nivel y devuelve un ArrayList
Select dentro de la aplicación:
String select = "select id_reto from reto where nombre_reto = ? and nivel = ?";
String insert = "insert into " + nombreJuego + "(jugador,reto,aciertos,tiempo_partida) values (?,?,?,sec_to_time(?))"; */
select id_reto from reto where nombre_reto = 'euclides' and nivel = 3;
insert into euclides(jugador,reto,aciertos,tiempo_partida) values ((select id_usuario from usuario where nombre_usuario='Cbarrios'),(select id_reto from reto where nombre_reto = 'euclides' and nivel = 3),4,sec_to_time(65));

-- Método selectJugadorUltimasPartidas
/* Busca en la BBDD las ultimas 5 partidas de el jugador en el nivel seleccionado
Recibe como parámetro el nombre del Juego y el Nivel
Select dentro de la aplicación:
String select = "select alias, tiempo_partida, aciertos, fecha_hora from view_" + nombreJuego + "_tablas where id_usuario = ? and  nivel = ? order by fecha_hora desc limit 5";*/
select alias, tiempo_partida, aciertos, fecha_hora from view_calculo_tablas where id_usuario = (select id_usuario from usuario where nombre_usuario='Cbarrios') and  nivel = 1 order by fecha_hora desc limit 5;

-- Método selectJugadorMejoresPartidas
/* Busca en la BBDD las mejores 5 partidas del jugador y las ordena de mejor a peor 1º por puntos luego por tiempo dependiendo del nivel seleccionado.
Recibe como parámetro el nombre del Juego y el Nivel y devuelve un ArrayList
Select dentro de la aplicación:
String select = "select alias, tiempo_partida, aciertos, fecha_hora from view_" + nombreJuego + "_tablas where id_usuario = ?  and nivel = ? order by aciertos desc, tiempo_partida asc limit 5";*/
select alias, tiempo_partida, aciertos, fecha_hora from view_resto_div_tablas where id_usuario = (select id_usuario from usuario where nombre_usuario='Cbarrios') and nivel = 1 order by aciertos desc, tiempo_partida asc limit 5;

-- Método selectClasificacion
/* Busca en la BBDD las 5 mejores puntuaciones de todos los jugadores en el nivel seleccionado por el Usuario
Recibe como parámetro el nombre del Juego y el Nivel y devuelve un ArrayList
Select dentro de la aplicación:
String select = "select alias, tiempo_partida, aciertos, fecha_hora from view_"+nombreJuego+"_tablas where nivel = ?  order by aciertos desc, tiempo_partida asc limit 5;*/
select alias, tiempo_partida, aciertos, fecha_hora from view_resto_div_tablas where nivel = 2  order by aciertos desc, tiempo_partida asc limit 5;

-- Método totalPartidas
/* Obtiene de la BBDD el total de partidas del Jugador en ese nivel
Recibe como parámetro el nombre del Juego y el Nivel
Select dentro de la aplicación:
String select = "SELECT partidas FROM estadisticas_" +nombreJuego+ " where jugador = ? and nivel = ?";*/
SELECT partidas FROM estadisticas_calculo where jugador = (select id_usuario from usuario where nombre_usuario='Cbarrios') and nivel = 1;

-- Método mediaAciertos
/* Obtiene de la BBDD la media de aciertos del Jugador en ese nivel
Recibe como parámetro el nombre del Juego y el Nivel
Select dentro de la aplicación:
"SELECT mediaAciertos FROM estadisticas_" + nombreJuego + " where jugador = ? and nivel = ?";*/
SELECT mediaAciertos FROM estadisticas_calculo where jugador = (select id_usuario from usuario where nombre_usuario='Cbarrios') and nivel = 4;


-- Clase MetodosRegistro

-- Método comprobarDNI
/* Comprueba si el DNI contiene 8 numeros y Una letra mayuscula, pasado desde el registro y que no existe en la BBDD
Devuelve un Booleano 
Select dentro de la aplicación:
"String selectDNI = "select dni from persona where dni = ?";*/
select dni from persona where dni = '12345678T';

-- Método comprobrarEmail
/* Comprueba si el Email tiene los parametros correctos (caracteres + "@" +dominio + "." ), pasado desde el registro y que no existe en la BBDD 
Devuelve un Booleano
Select dentro de la aplicación:
"String selectEmail = "select email from persona where email = ?";*/
select email from persona where email = '123@asd.es';

-- Método comprobrarAlias
/* Comprueba si el alias no esta vacio, pasado desde el registro y que no existe en la BBDD:
Devuelve un Booleano
Select dentro de la aplicación:
String selectAlias = "select alias from usuario where alias = ?";*/
select alias from usuario where alias = 'AliasDaniel';

-- Método comprobarNombreUsuario
/* Comprueba que el nombre de usuario no esta vacio, pasado desde el registro y que no existe en la BBDD
Devuelve un Booleano
Select dentro de la aplicación:
String selectNombreUsuario = "select nombre_usuario from usuario where nombre_usuario = ?";*/
select nombre_usuario from usuario where nombre_usuario = 'Despinosa';

-- Método registrarUsuario
/* Compuesto de un Select para saber el Id-usuario al registrarlo y 3 Inserts para añadir la información del usuario en todas las tablas necesarias para el registro
String select = "select id_usuario from usuario where nombre_usuario = ?";
String insert1 = "insert into usuario(nombre_usuario,contrasena,alias) values (?,md5(?),?)";
String insert2 = "insert into persona(id_usuario,nombre,apellido1,apellido2,dni,email,curso,fecha_naci,profesor) values (?,?,?,?,?,?,?,?,?)";
String insert3 = "insert into ajuste(usuario,tamaño,idioma,sonido) values (?,?,?,?)";;
Para añadir el usuario se realizaria en el siguiente orden:*/
insert into usuario(nombre_usuario,contrasena,alias) values ('AlumnoPrueba',md5(12345),'AliasAlumPrueba');
select id_usuario from usuario where nombre_usuario = 'AlumnoPrueba';
insert into persona(id_usuario,nombre,apellido1,apellido2,dni,email,curso,fecha_naci,profesor) values 
((select id_usuario from usuario where nombre_usuario = 'AlumnoPrueba'),'nombrePru','apellidoPru','Apellido2Prue','12345678X','email@prueba.es',1,20230503,0);
insert into ajuste(usuario,tamaño,idioma,sonido) values ((select id_usuario from usuario where nombre_usuario = 'AlumnoPrueba'),2,'Espanol',0);


-- Clase MetodosUpdateBBDD

-- metodo updatePassword
/* Metodo para actualizar la contraseña del usuario en la BBDD
Select dentro de la aplicación:
String insert1 = "update usuario set contrasena=md5(?) where id_usuario=" + Usuario.getIdUsuario(); */
SET @IDUSUARIO = (select id_usuario from usuario where nombre_usuario = 'AlumnoPrueba');
update usuario set contrasena=md5('password') where id_usuario=@IDUSUARIO;

-- metodo updateAlias
/* Metodo para actualizar la contraseña del usuario en la BBDD
Select dentro de la aplicación:
String insert1 = "update usuario set alias=? where id_usuario=" + Usuario.getIdUsuario();*/
update usuario set alias='Pepito' where id_usuario = @IDUSUARIO;

-- metodo updateApellido1
/* Metodo para actualizar el primer apellido del usuario
Select dentro de la aplicación:
String insert1 = "update persona set apellido1=? where id_usuario=" + Usuario.getIdUsuario();*/
update persona set apellido1='CambioApellido' where (select id_usuario from usuario where nombre_usuario = 'AlumnoPrueba');

-- metodo updateApellido2
/* Metodo para actualizar el segundo apellido del usuario
Select dentro de la aplicación:
String insert1 = "update persona set apellido2=? where id_usuario=" + Usuario.getIdUsuario();*/
update persona set apellido2='CambioApellido2' where (select id_usuario from usuario where nombre_usuario = 'AlumnoPrueba');

-- metodo updateEmail
/* Metodo para actualizar el email del usuario
Select dentro de la aplicación:
String insert1 = "update persona set email=? where id_usuario=" + Usuario.getIdUsuario();*/
update persona set email='pruebacorreo@email.es' where id_usuario=(select id_usuario from usuario where nombre_usuario = 'AlumnoPrueba');
