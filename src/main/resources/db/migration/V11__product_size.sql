CREATE TABLE product_size
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying(10) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT product_size_pkey PRIMARY KEY (id)
);

INSERT INTO product_size (name) VALUES ('S');
INSERT INTO product_size (name) VALUES ('M');
INSERT INTO product_size (name) VALUES ('L');
INSERT INTO product_size (name) VALUES ('XL');
INSERT INTO product_size (name) VALUES ('XXL');
INSERT INTO product_size (name) VALUES ('3XL');
INSERT INTO product_size (name) VALUES ('4XL');