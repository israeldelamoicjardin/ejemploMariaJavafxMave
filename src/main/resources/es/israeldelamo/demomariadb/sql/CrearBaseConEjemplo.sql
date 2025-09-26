create table if not exists DNI
(
    DNI       int         not null,
    Nombre    varchar(20) null,
    Apellidos varchar(20) null
    );

insert into DNI.DNI (DNI, Nombre, Apellidos)
values ("100","Israel","De Lamo"),
       ("99","Alberto","García");
