-- Table: public."OfferConstraintType"

-- DROP TABLE public."OfferConstraintType";

CREATE TABLE public."OfferConstraintType"
(
    id serial,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    offerconstrainttypecategory_id integer NOT NULL,
    CONSTRAINT "OfferConstraintType_pkey" PRIMARY KEY (id),
    CONSTRAINT offerconstrainttype_name_key UNIQUE (name),
    CONSTRAINT offerconstrainttypecategory_id_fkey FOREIGN KEY (offerconstrainttypecategory_id)
        REFERENCES public."OfferConstraintTypeCategory" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."OfferConstraintType"
    OWNER to postgres;
COMMENT ON TABLE public."OfferConstraintType"
    IS 'Definition of types of constraints';