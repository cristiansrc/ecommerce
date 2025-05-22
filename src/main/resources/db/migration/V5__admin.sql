CREATE TABLE admin
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    "lastName" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    mail character varying(50) COLLATE pg_catalog."default" NOT NULL,
    password character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT admin_pkey PRIMARY KEY (id)
);

INSERT INTO admin(name, "lastName", mail, password) VALUES ('Cristhiam', 'Reina', 'cristiansrc@gmail.com', '2FM3kO2CQerbYQiJjEaNZA==');