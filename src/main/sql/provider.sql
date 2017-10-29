-- Table: public."Provider"

-- DROP TABLE public."Provider";

CREATE TABLE public."Provider"
(
    id bigserial,
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    street character varying(100) COLLATE pg_catalog."default",
    zip character varying(10) COLLATE pg_catalog."default",
    town character varying(50) COLLATE pg_catalog."default",
    country_code character varying COLLATE pg_catalog."default",
    location_id bigint,
    url character varying(256) COLLATE pg_catalog."default",
    CONSTRAINT "Provider_pkey" PRIMARY KEY (id),
    CONSTRAINT provider_name_key UNIQUE (name),
    CONSTRAINT provider_location_fkey FOREIGN KEY (location_id)
        REFERENCES public."Location" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Provider"
    OWNER to postgres;
COMMENT ON TABLE public."Provider"
    IS 'Provider of a touristic service';