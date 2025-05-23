CREATE TABLE product
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default" NOT NULL,
    gender character varying(20) COLLATE pg_catalog."default" NOT NULL,
    price bigint NOT NULL,
    "categoryId" bigint NOT NULL,
    CONSTRAINT product_pkey PRIMARY KEY (id),
    CONSTRAINT "product-category" FOREIGN KEY ("categoryId")
        REFERENCES category (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)