CREATE TABLE product_image
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    image text COLLATE pg_catalog."default" NOT NULL,
    "productId" bigint NOT NULL,
    major bigint NOT NULL DEFAULT 1,
    CONSTRAINT product_image_pkey PRIMARY KEY (id),
    CONSTRAINT image_product FOREIGN KEY ("productId")
    REFERENCES product (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);
