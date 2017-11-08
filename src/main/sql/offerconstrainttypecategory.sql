-- Table: public."OfferConstraintTypeCategory"

-- DROP TABLE public."OfferConstraintTypeCategory";

CREATE TABLE public."OfferConstraintTypeCategory"
(
    id serial,
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "OfferConstraintTypeCategory_pkey" PRIMARY KEY (id),
    CONSTRAINT offerconstrainttypecategory_name_key UNIQUE (name)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."OfferConstraintTypeCategory"
    OWNER to postgres;
COMMENT ON TABLE public."OfferConstraintTypeCategory"
    IS 'Category of constraint type';