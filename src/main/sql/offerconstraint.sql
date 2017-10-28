-- Table: public."OfferConstraint"

-- DROP TABLE public."OfferConstraint";

CREATE TABLE public."OfferConstraint"
(
    id bigint NOT NULL DEFAULT nextval('"OfferConstraint_id_seq"'::regclass),
    offerconstrainttype_id bigint NOT NULL,
    offer_id bigint NOT NULL,
    CONSTRAINT "OfferConstraint_pkey" PRIMARY KEY (id),
    CONSTRAINT offerconstraint_offerconstrainttype_id_offer_id_key UNIQUE (offerconstrainttype_id, offer_id),
    CONSTRAINT offerconstraint_offer_fkey FOREIGN KEY (offer_id)
        REFERENCES public."Offer" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT offerconstraint_offerconstrainttype_fkey FOREIGN KEY (offerconstrainttype_id)
        REFERENCES public."OfferConstraintType" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."OfferConstraint"
    OWNER to postgres;
COMMENT ON TABLE public."OfferConstraint"
    IS 'Constraint which a particular service offering fulfills.';