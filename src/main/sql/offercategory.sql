-- Table: public."OfferCategory"

-- DROP TABLE public."OfferCategory";

CREATE TABLE public."OfferCategory"
(
    id bigint NOT NULL DEFAULT nextval('"OfferCategory_id_seq"'::regclass),
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    parent_offercategory_id bigint NOT NULL,
    CONSTRAINT "OfferCategory_pkey" PRIMARY KEY (id),
    CONSTRAINT offercategory_name_parentoffercategory_id_key UNIQUE (name, parent_offercategory_id),
    CONSTRAINT offercategory_offercategory_fkey FOREIGN KEY (parent_offercategory_id)
        REFERENCES public."OfferCategory" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."OfferCategory"
    OWNER to postgres;
COMMENT ON TABLE public."OfferCategory"
    IS 'Categories of service offerings';