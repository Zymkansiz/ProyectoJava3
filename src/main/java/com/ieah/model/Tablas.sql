
create table mueble(idMueble integer primary key auto_increment, nombre varchar (50), tipo varchar(50));

create table tipo(idTipo integer primary key auto_increment, descripcion varchar (80));

create table envio(idEnvio integer primary key auto_increment, costo float);
