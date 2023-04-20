use bbdd;
insert into usuario (nombre_usuario,contrasena,alias) values
('Cbarrios',md5(12345),'AliasKaren'),
('Despinosa',md5(12345),'AliasDaniel'),
('Rgutierrez',md5(12345),'AliasRa'),
('Adiez',md5(12345),'TerciodeMarte'),
('Amartinez',md5(12345),'AliasAmartinez');

insert into persona(id_usuario,nombre,apellido1,apellido2,dni,curso,fecha_naci,profesor,email) values
((select id_usuario from usuario where nombre_usuario='Cbarrios'),'Carmen','Barrios','Fernández','12345678T',1,20000419,0,'123@asd.es'),
((select id_usuario from usuario where nombre_usuario='Despinosa'),'Daniel','Espinosa','García','98765432F',2,19830409,0,'987@asd.es'),
((select id_usuario from usuario where nombre_usuario='Rgutierrez'),'Ramiro','Gutierrez','Valverde','23456789F',3,20001213,0,'234@asd.es'),
((select id_usuario from usuario where nombre_usuario='Adiez'),'Albano','Díez','Paulino','87654321Z',4,20000818,0,'876@asd.es'),
((select id_usuario from usuario where nombre_usuario='Amartinez'),'Andrés','Martínez','González','45678932L',0,19950507,1,'amg456@gmail.com');


insert into reto (nombre_reto,nivel) values
('Calcula25',1),
('Calcula25',2),
('Calcula25',3),
('Calcula25',4);








