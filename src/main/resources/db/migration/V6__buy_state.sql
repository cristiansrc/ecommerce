CREATE TABLE buy_state
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT buy_state_pkey PRIMARY KEY (id)
);

INSERT INTO buy_state (name) VALUES ('En carro de compras');
INSERT INTO buy_state (name) VALUES ('Pagado');
INSERT INTO buy_state (name) VALUES ('Enviado');
INSERT INTO buy_state (name) VALUES ('Entregado');
INSERT INTO buy_state (name) VALUES ('Cancelado');