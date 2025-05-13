CREATE TABLE buy
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    "userId" bigint NOT NULL,
    date timestamp with time zone NOT NULL,
    address character varying(50) COLLATE pg_catalog."default",
    datePay timestamp with time zone NOT NULL,
                       "buyStateId" bigint NOT NULL,
                       CONSTRAINT buy_pkey PRIMARY KEY (id),
    CONSTRAINT buy_state FOREIGN KEY ("buyStateId")
    REFERENCES buy_state (id) MATCH SIMPLE
                   ON UPDATE NO ACTION
                   ON DELETE NO ACTION,
    CONSTRAINT buy_user FOREIGN KEY ("userId")
    REFERENCES "user" (id) MATCH SIMPLE
                   ON UPDATE NO ACTION
                   ON DELETE NO ACTION
);