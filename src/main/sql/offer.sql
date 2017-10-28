-- Table: public."Offer"

-- DROP TABLE public."Offer";

CREATE TABLE public."Offer"
(
    id bigserial PRIMARY KEY,
    name character varying(150) COLLATE pg_catalog."default",
    description character varying(1024) COLLATE pg_catalog."default",
    provider_id bigint NOT NULL REFERENCES public."Provider" (id),
    url character varying(1024) COLLATE pg_catalog."default",
    location_id bigint REFERENCES public."Location" (id),
    start_date timestamp with time zone,
    end_date timestamp with time zone,
    offercategory_id bigint NOT NULL REFERENCES public."OfferCategory" (id),
    CONSTRAINT offer_name_provider_id_key UNIQUE (provider_id, name)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Offer"
    OWNER to postgres;