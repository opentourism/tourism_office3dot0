-- Table: public."UserRoleMap"

-- DROP TABLE public."UserRoleMap";

CREATE TABLE public."UserRoleMap"
(
    id bigserial,
    user_id bigint NOT NULL,
    userrole_id integer NOT NULL,
    CONSTRAINT "UserRoleMap_pkey" PRIMARY KEY (id),
    CONSTRAINT userrolemap_key UNIQUE (user_id, userrole_id),
    CONSTRAINT userrolemap_user_fkey FOREIGN KEY (user_id)
        REFERENCES public."User" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT userrolemap_userrole_fkey FOREIGN KEY (userrole_id)
        REFERENCES public."UserRole" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."UserRoleMap"
    OWNER to postgres;

GRANT ALL ON TABLE public."UserRoleMap" TO postgres;

GRANT ALL ON TABLE public."UserRoleMap" TO stefan WITH GRANT OPTION;

COMMENT ON TABLE public."UserRoleMap"
    IS 'Assignment of roles to users';