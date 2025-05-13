CREATE TABLE buy_product_characteristics
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    price double precision NOT NULL,
    items bigint NOT NULL,
    color character varying(20) COLLATE pg_catalog."default" NOT NULL,
    size character varying(20) COLLATE pg_catalog."default" NOT NULL,
    "colorHexa" character varying(20) COLLATE pg_catalog."default" NOT NULL,
    image text COLLATE pg_catalog."default" NOT NULL,
    "buyProductId" bigint NOT NULL,
    CONSTRAINT buy_product_characteristics_pkey PRIMARY KEY (id),
    CONSTRAINT buy_product_characteristics FOREIGN KEY ("buyProductId")
    REFERENCES buy_product (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);