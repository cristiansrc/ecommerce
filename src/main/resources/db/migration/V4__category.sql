CREATE TABLE category
(
    id bigint NOT NULL,
    name character varying(50) COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    icon character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT category_pkey PRIMARY KEY (id)
);