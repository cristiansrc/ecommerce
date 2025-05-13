CREATE TABLE product_characteristics
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    price double precision NOT NULL,
    stock bigint NOT NULL,
    "colorId" bigint NOT NULL,
    "sizeId" bigint NOT NULL,
    "productId" bigint NOT NULL,
    CONSTRAINT size_pkey PRIMARY KEY (id),
    CONSTRAINT "product_characteristics_colorId_sizeId_productId_key" UNIQUE ("colorId", "sizeId", "productId"),
    CONSTRAINT product FOREIGN KEY ("productId")
        REFERENCES product (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT product_color FOREIGN KEY ("colorId")
        REFERENCES product_color (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT product_size FOREIGN KEY ("sizeId")
        REFERENCES product_size (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);