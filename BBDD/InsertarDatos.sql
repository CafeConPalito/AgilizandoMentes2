use bbdd;
insert into persona(nombre,apellido1,apellido2,dni,curso,fecha_naci,profesor,email) values
('Carmen','Barrios','Fernández','12345678T',1,20000419,0,'123@asd.es'),
('Daniel','Espinosa','García','98765432F',2,19830409,0,'987@asd.es'),
('Ramiro','Gutierrez','Valverde','23456789F',3,20001213,0,'234@asd.es'),
('Albano','Díez','Paulino','87654321Z',4,20000818,0,'876@asd.es'),
('Andrés','Martínez','González','45678932L',0,19950507,1,'amg456@gmail.com');

insert into usuario (id_usuario,nombre_usuario,contrasena,alias) values
((select id_persona from persona where dni='12345678T'),'Cbarrios',md5(12345),'AliasKaren'),
((select id_persona from persona where dni='98765432F'),'Despinosa',md5(12345),'AliasDaniel'),
((select id_persona from persona where dni='23456789F'),'Rgutierrez',md5(12345),'AliasRa'),
((select id_persona from persona where dni='87654321Z'),'Adiez',md5(12345),'TerciodeMarte'),
((select id_persona from persona where dni='45678932L'),'Amartinez',md5(12345),'AliasAmartinez');

insert into reto (nombre_reto,nivel) values
('Calcula25',1),
('Calcula25',2),
('Calcula25',3),
('Calcula25',4);








