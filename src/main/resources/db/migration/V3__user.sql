CREATE TABLE "user"
(
    id bigint NOT NULL,
    name character varying(100) COLLATE pg_catalog."default",
    "lastName" character varying(100) COLLATE pg_catalog."default",
    mail character varying(100) COLLATE pg_catalog."default",
    password character varying(100) COLLATE pg_catalog."default",
    phone bigint,
    address character varying(200) COLLATE pg_catalog."default",
    "cityId" bigint,
    CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT "user-city" FOREIGN KEY ("cityId")
    REFERENCES city (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);