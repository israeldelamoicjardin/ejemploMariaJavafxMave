create table if not exists DNI
(
    DNI       int         not null,
    Nombre    varchar(20) null,
    Apellidos varchar(20) null
    );

insert into DNI.DNI (DNI, Nombre, Apellidos)
values ("1","Juan","Perez"),
       ("2","Perico","GNZ."),
       ("3","Andres","RDGZ."),
       ("4","Ines","GCIA."),
       ("5","Alberto","Mateos");
