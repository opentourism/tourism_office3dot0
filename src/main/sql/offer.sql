-- Table: public."Offer"

-- DROP TABLE public."Offer";

CREATE TABLE public."Offer"
(
    id bigserial,
    name character varying(150) COLLATE pg_catalog."default",
    description character varying(1024) COLLATE pg_catalog."default",
    provider_id bigint NOT NULL,
    url character varying(1024) COLLATE pg_catalog."default",
    location_id bigint,
    start_date timestamp with time zone,
    end_date timestamp with time zone,
    offercategory_id bigint NOT NULL,
    CONSTRAINT "Offer_pkey" PRIMARY KEY (id),
    CONSTRAINT offer_name_provider_id_key UNIQUE (provider_id, name),
    CONSTRAINT "Offer_location_id_fkey" FOREIGN KEY (location_id)
        REFERENCES public."Location" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "Offer_offercategory_id_fkey" FOREIGN KEY (offercategory_id)
        REFERENCES public."OfferCategory" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "Offer_provider_id_fkey" FOREIGN KEY (provider_id)
        REFERENCES public."Provider" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Offer"
    OWNER to postgres;
COMMENT ON TABLE public."Offer"
    IS 'Service offerings either permanent or temporary but no an event';