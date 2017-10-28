-- Table: public."Event"

-- DROP TABLE public."Event";

CREATE TABLE public."Event"
(
    id bigint NOT NULL DEFAULT nextval('"Event_id_seq"'::regclass),
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    start_date timestamp with time zone NOT NULL,
    end_date timestamp with time zone NOT NULL,
    parent_event_id bigint,
    description character varying(1000) COLLATE pg_catalog."default",
    provider_id bigint NOT NULL,
    venue character varying(50) COLLATE pg_catalog."default",
    location_id bigint,
    url character varying(1024) COLLATE pg_catalog."default",
    CONSTRAINT "Event_pkey" PRIMARY KEY (id),
    CONSTRAINT event_name_start_date_provider_id_key UNIQUE (parent_event_id, start_date, name),
    CONSTRAINT event_event_fkey FOREIGN KEY (parent_event_id)
        REFERENCES public."Event" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT event_location_fkey FOREIGN KEY (location_id)
        REFERENCES public."Location" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT event_provider_fkey FOREIGN KEY (provider_id)
        REFERENCES public."Provider" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Event"
    OWNER to postgres;
COMMENT ON TABLE public."Event"
    IS 'Events with a touristic value';