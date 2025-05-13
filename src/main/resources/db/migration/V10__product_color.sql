CREATE TABLE product_color
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying(20) COLLATE pg_catalog."default",
    hex character varying(15) COLLATE pg_catalog."default",
    CONSTRAINT product_color_pkey PRIMARY KEY (id)
);