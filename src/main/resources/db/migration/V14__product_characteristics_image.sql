CREATE TABLE product_characteristics_image
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    image text COLLATE pg_catalog."default" NOT NULL,
    "productCharacteristicsId" bigint NOT NULL,
    CONSTRAINT product_image_pkeys PRIMARY KEY (id),
    CONSTRAINT productc_characteristics_image FOREIGN KEY ("productCharacteristicsId")
    REFERENCES product_characteristics (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID
);