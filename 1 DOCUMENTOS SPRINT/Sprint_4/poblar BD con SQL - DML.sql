use inventario_equipos;

#Poblar tabla estado_usuario
insert into estado_usuario values ('0','Inactivo');
insert into estado_usuario values ('1','Activo');

#Poblar tabla tipo_usuario
insert into tipo_usuario values ('0','Administrador');
insert into tipo_usuario values ('1','Bodeguero');
insert into tipo_usuario values ('2','Técnico');
insert into tipo_usuario values ('3','Trabajador');

#Poblar tabla estado_equipo
insert into estado_equipo values ('0','Nuevo');
insert into estado_equipo values ('1','Bueno');
insert into estado_equipo values ('2','Dañado');
insert into estado_equipo values ('3','Dado de baja');

#Poblar tabla tipo_equipo
insert into tipo_equipo values ('0','Escritorio');
insert into tipo_equipo values ('1','Portátil');
insert into tipo_equipo values ('2','Todo en Uno');
insert into tipo_equipo values ('3','Servidor');

#Poblar tabla estado_periferico
insert into estado_periferico values ('0','Nuevo');
insert into estado_periferico values ('1','Bueno');
insert into estado_periferico values ('2','Dañado');
insert into estado_periferico values ('3','Dado de baja');

#Poblar tabla tipo_periferico
insert into tipo_periferico values ('0','Monitor');
insert into tipo_periferico values ('1','Teclado');
insert into tipo_periferico values ('2','Mouse');
insert into tipo_periferico values ('3','Diadema');
insert into tipo_periferico values ('4','Parlante');
insert into tipo_periferico values ('5','Otro');

#Poblar tabla usuario
Insert into usuario values ('1', 'Usuario Administrador', 'admin', 'admin1234', 'admin@admin.com','0', '1');
Insert into usuario values ('2', 'Pedro Lopez', 'plopez', 'navidad2021', 'pedrito_lopez@hotmail.com','2', '1');
Insert into usuario values ('3', 'Juan Ramirez', 'jramirez', '1988quindio', 'juanramirez@gmail.com','3', '1');
Insert into usuario values ('4', 'José Perez', 'jperez', 'lospollitosdicen', 'jose@yahoo.com','1', '1');
Insert into usuario values ('5', 'Luis Rodrigez', 'lrodri', 'qwerty', 'lucho_rodriguez@outlook.com','3', '1');
Insert into usuario values ('6', 'Pablo Gutierrez', 'pgutier', 'cestlavie', 'pablo_guty@gmail.com','3', '0');

#Poblar la tabla equipo
Insert into equipo values ('1', 'MLX28JTL9123', 'Lenovo', 'ThinkPad X1 CARBON', '1', '1');
Insert into equipo values ('2', '1SRT20241JZC', 'Asus', 'VivoBook X413EA', '1', '0');
Insert into equipo values ('3', 'MPS295KHVE', 'Lenovo', 'ThinkCentre M73', '0', '0');
Insert into equipo values ('4', '9SRTXHMQ192', 'HP', 'Pavilion 15-eh0002la', '1', '1');
#Poblar la tabla periferico
Insert into periferico values ('1', '6729325292', 'Genius', 'DX-120', '2', '1');
Insert into periferico values ('2', 'MSW843HKP', 'Lenovo', 'z470', '1', '0');
Insert into periferico values ('3', 'JHSPI296GQW', 'Lenovo', 'L22e-20', '0', '0');

#Poblar la tabla mov_equipo
Insert into mov_equipo values ('1', '2021-04-21', '2021-08-31', '1', '5');
Insert into mov_equipo values ('2', '2021-02-22', '', '2', '2');
Insert into mov_equipo values ('3', '2021-11-10', '', '3', '3');
Insert into mov_equipo values ('4', '2020-06-03', '2021-09-16', '4', '4');

#Poblar la tabla mov_periferico
Insert into mov_periferico values ('1', '2021-11-10', '', '1', '3');
Insert into mov_periferico values ('2', '2021-11-10', '', '2', '3');
Insert into mov_periferico values ('3', '2021-11-10', '', '3', '3');
