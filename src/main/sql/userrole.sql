-- Table: public."UserRole"

-- DROP TABLE public."UserRole";

CREATE TABLE public."UserRole"
(
    id serial,
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    description character varying(500) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "UserRole_pkey" PRIMARY KEY (id),
    CONSTRAINT userrole_name_key UNIQUE (name)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."UserRole"
    OWNER to postgres;
COMMENT ON TABLE public."UserRole"
    IS 'Available roles for the application';