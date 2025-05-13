CREATE TABLE department
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT department_pkey PRIMARY KEY (id)
);

insert into department (name) values ('AMAZONAS');
insert into department (name) values ('ANTIOQUIA');
insert into department (name) values ('ARAUCA');
insert into department (name) values ('ARCHIPIELAGO DE SAN ANDRES');
insert into department (name) values ('ATLÁNTICO');
insert into department (name) values ('BOGOTÁ D.C.');
insert into department (name) values ('BOLIVAR');
insert into department (name) values ('BOYACÁ');
insert into department (name) values ('CALDAS');
insert into department (name) values ('CAQUETA');
insert into department (name) values ('CASANARE');
insert into department (name) values ('CAUCA');
insert into department (name) values ('CESAR');
insert into department (name) values ('CHOCO');
insert into department (name) values ('CORDOBA');
insert into department (name) values ('CUNDINAMARCA');
insert into department (name) values ('GUAINIA');
insert into department (name) values ('GUAVIARE');
insert into department (name) values ('HUILA');
insert into department (name) values ('LA GUAJIRA');
insert into department (name) values ('MAGDALENA');
insert into department (name) values ('META');
insert into department (name) values ('NARIÑO');
insert into department (name) values ('NORTE DE SANTANDER');
insert into department (name) values ('PUTUMAYO');
insert into department (name) values ('QUINDIO');
insert into department (name) values ('RISARALDA');
insert into department (name) values ('SANTANDER');
insert into department (name) values ('SUCRE');
insert into department (name) values ('TOLIMA');
insert into department (name) values ('VALLE DEL CAUCA');
insert into department (name) values ('VAUPES');
insert into department (name) values ('VICHADA');