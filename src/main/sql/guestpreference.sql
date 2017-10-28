-- Table: public."GuestPreference"

-- DROP TABLE public."GuestPreference";

CREATE TABLE public."GuestPreference"
(
    id bigint NOT NULL DEFAULT nextval('"GuestInterest_id_seq"'::regclass),
    user_id bigint NOT NULL,
    offercategory_id bigint NOT NULL,
    CONSTRAINT "GuestPreference_pkey" PRIMARY KEY (id),
    CONSTRAINT guestpreference_user_id_offercategory_id_key UNIQUE (user_id, offercategory_id),
    CONSTRAINT guestpreference_offercategory_fkey FOREIGN KEY (offercategory_id)
        REFERENCES public."OfferCategory" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT guestpreference_user_fkey FOREIGN KEY (user_id)
        REFERENCES public."User" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."GuestPreference"
    OWNER to postgres;
COMMENT ON TABLE public."GuestPreference"
    IS 'Preferences of touristic guest or user of this application';