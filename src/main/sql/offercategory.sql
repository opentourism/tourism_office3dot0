-- Table: public."OfferCategory"

-- DROP TABLE public."OfferCategory";

CREATE TABLE public."OfferCategory"
(
    id bigint NOT NULL DEFAULT nextval('"OfferCategory_id_seq"'::regclass),
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    parent_category bigint NOT NULL,
    CONSTRAINT "OfferCategory_pkey" PRIMARY KEY (id),
    CONSTRAINT offercategory_name_parentcategory_key UNIQUE (name, parent_category)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."OfferCategory"
    OWNER to postgres;
COMMENT ON TABLE public."OfferCategory"
    IS 'Categories of service offerings';