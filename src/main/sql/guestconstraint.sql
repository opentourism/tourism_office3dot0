-- Table: public."GuestConstraint"

-- DROP TABLE public."GuestConstraint";

CREATE TABLE public."GuestConstraint"
(
    id bigserial,
    user_id bigint NOT NULL,
    offerconstraint_type_id integer NOT NULL,
    CONSTRAINT "GuestContraint_pkey" PRIMARY KEY (id),
    CONSTRAINT guestconstraint_user_id_offerconstraint_type_id_key UNIQUE (user_id, offerconstraint_type_id),
    CONSTRAINT guestconstraint_offerconstrainttype_fkey FOREIGN KEY (offerconstraint_type_id)
        REFERENCES public."OfferConstraintType" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT guestconstraint_user_fkey FOREIGN KEY (user_id)
        REFERENCES public."User" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."GuestConstraint"
    OWNER to postgres;
COMMENT ON TABLE public."GuestConstraint"
    IS 'Constraints of a touristic guest or user of this application. It refers to OfferConstraintType entity.';