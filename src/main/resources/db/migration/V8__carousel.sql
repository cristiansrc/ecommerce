CREATE TABLE carousel
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    green character varying(50) COLLATE pg_catalog."default" NOT NULL,
    black character varying(50) COLLATE pg_catalog."default" NOT NULL,
    image text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT carousel_pkey PRIMARY KEY (id)
);