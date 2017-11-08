-- Database: digitaltouristoffice

-- DROP DATABASE digitaltouristoffice;

CREATE DATABASE digitaltouristoffice 
    WITH 
    TEMPLATE = template1
    OWNER = postgres
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE digitaltouristoffice
    IS 'Open Tourism Data Hackdays 2017 Project Digital Tourist Office DB';

GRANT TEMPORARY, CONNECT ON DATABASE digitaltouristoffice TO PUBLIC;

GRANT ALL ON DATABASE digitaltouristoffice TO postgres;

-- run this in PostgreSQL psql interactive terminal 
-- \ir user.sql
-- \ir userrole.sql
-- \ir userrolemap.sql
-- \ir location.sql
-- \ir provider.sql
-- \ir offerconstrainttypecategory.sql
-- \ir offerconstrainttype.sql
-- \ir offercategory.sql
-- \ir offer.sql
-- \ir offerconstraint.sql
-- \ir guestpreference.sql
-- \ir guestconstraint.sql
-- \ir event.sql

