create database inventario_equipos;
use inventario_equipos;

# crear tabla estado_usuario
create table estado_usuario(
codigo_estado_usu varchar(15) not null,
desc_estado_usu varchar(30) not null,
constraint estado_usuario_pk primary key(codigo_estado_usu));

# crear tabla tipo_usuario
create table tipo_usuario(
codigo_tipo_usu varchar(15) not null,
desc_tipo_usu varchar(30) not null,
constraint tipo_usuario_pk primary key(codigo_tipo_usu));

# crear tabla estado_equipo
create table estado_equipo(
codigo_estado_equi varchar(15) not null,
desc_estado_equi varchar(30) not null,
constraint estado_equipo_pk primary key(codigo_estado_equi));

# crear tabla tipo_equipo
create table tipo_equipo(
codigo_tipo_equi varchar(15) not null,
desc_tipo_equi varchar(30) not null,
constraint tipo_equipo_pk primary key(codigo_tipo_equi));

# crear tabla estado_periferico
create table estado_periferico(
codigo_estado_per varchar(15) not null,
desc_estado_per varchar(30) not null,
constraint estado_periferico_pk primary key(codigo_estado_per));

# crear tabla tipo_periferico
create table tipo_periferico(
codigo_tipo_per varchar(15) not null,
desc_tipo_per varchar(30) not null,
constraint tipo_periferico_pk primary key(codigo_tipo_per));

# crear tabla usuario
create table usuario(
codigo_usu int(15) not null,
nombre_usu varchar(50) not null,
usuario varchar(25) not null,
password varchar(25) not null,
email varchar(25) not null,
codigo_tipo_usu varchar(15) not null,
codigo_estado_usu varchar(15) not null,
constraint usuario_pk primary key(codigo_usu),
constraint usuario_codigo_tipo_usu_fk foreign key(codigo_tipo_usu) references tipo_usuario(codigo_tipo_usu),
constraint usuario_codigo_estado_usu_fk foreign key(codigo_estado_usu) references estado_usuario(codigo_estado_usu));

# crear tabla equipo
create table equipo(
codigo_equi varchar(15) not null,
serial_equi varchar(50) not null,
marca_equi varchar(50) not null,
modelo_equi varchar(50) not null,
codigo_tipo_equi varchar(15) not null,
codigo_estado_equi varchar(15) not null,
constraint equipo_pk primary key(codigo_equi),
constraint equipo_codigo_tipo_equi_fk foreign key(codigo_tipo_equi) references tipo_equipo(codigo_tipo_equi),
constraint equipo_codigo_estado_equi_fk foreign key(codigo_estado_equi) references estado_equipo(codigo_estado_equi));

# crear tabla periferico
create table periferico(
codigo_per varchar(15) not null,
serial_per varchar(50) not null,
marca_per varchar(50) not null,
modelo_per varchar(50) not null,
codigo_tipo_per varchar(15) not null,
codigo_estado_per varchar(15) not null,
constraint periferico_pk primary key(codigo_per),
constraint periferico_codigo_tipo_per_fk foreign key(codigo_tipo_per) references tipo_periferico(codigo_tipo_per),
constraint periferico_codigo_estado_per_fk foreign key(codigo_estado_per) references estado_periferico(codigo_estado_per));

# crear tabla mov_equipo
create table mov_equipo(
codigo_mov_equi varchar(15) not null,
fecha_inicial date not null,
fecha_final date null,
codigo_equi varchar(15) not null,
codigo_usu varchar(15) not null,
constraint mov_equipo_pk primary key(codigo_mov_equi),
constraint mov_equipo_codigo_equi_fk foreign key(codigo_equi) references equipo(codigo_equi),
constraint mov_equipo_codigo_usu_fk foreign key(codigo_usu) references usuario(codigo_usu));

# crear tabla mov_periferico
create table mov_periferico(
codigo_mov_per varchar(15) not null,
fecha_inicial date not null,
fecha_final date null,
codigo_per varchar(15) not null,
codigo_usu varchar(15) not null,
constraint mov_periferico_pk primary key(codigo_mov_per),
constraint mov_periferico_codigo_per_fk foreign key(codigo_per) references periferico(codigo_per),
constraint mov_periferico_codigo_usu_fk foreign key(codigo_usu) references usuario(codigo_usu));