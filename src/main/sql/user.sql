-- Table: public."User"

-- DROP TABLE public."User";

CREATE TABLE public."User"
(
    id bigint NOT NULL DEFAULT nextval('"User_id_seq"'::regclass),
    lastname character varying(100) COLLATE pg_catalog."default" NOT NULL,
    firstname character varying(100) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password_hash character varying(1024) COLLATE pg_catalog."default",
    CONSTRAINT "User_pkey" PRIMARY KEY (id),
    CONSTRAINT user_email_key UNIQUE (email)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."User"
    OWNER to postgres;
COMMENT ON TABLE public."User"
    IS 'User or Tourist or Guest.
A guest is an authenticated user of this application.';