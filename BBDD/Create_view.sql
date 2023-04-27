use BBDD;
create view view_info_alumnos as select nombre_usuario,alias,nombre,apellido1,apellido2,dni,email,curso,fecha_naci 
from usuario inner join persona using(id_usuario) where profesor=0;