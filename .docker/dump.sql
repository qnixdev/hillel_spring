--
-- PostgreSQL database dump
--
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: hillel
--
CREATE SCHEMA public;
ALTER SCHEMA public OWNER TO hillel;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: hillel
--
COMMENT ON SCHEMA public IS 'standard public schema';
SET default_tablespace = '';
SET default_table_access_method = heap;

--
-- Name: person; Type: TABLE; Schema: public; Owner: hillel
--
CREATE TABLE public.person (
    id INTEGER NOT NULL,
    name VARCHAR(63) NOT NULL,
    PRIMARY KEY(id)
);

--
-- Name: animal; Type: TABLE; Schema: public; Owner: hillel
--
CREATE TABLE public.animal (
    id INTEGER NOT NULL,
    name VARCHAR(63) NOT NULL,
    person_id INTEGER DEFAULT NULL,
    PRIMARY KEY(id)
);
CREATE INDEX IDX_225858D0396DF84D ON public.animal (person_id);
ALTER TABLE public.animal ADD CONSTRAINT FK_225858D0396DF84D FOREIGN KEY (person_id) REFERENCES public.person (id) NOT DEFERRABLE INITIALLY IMMEDIATE;

--
-- Name: user; Type: TABLE; Schema: public; Owner: hillel
--
CREATE TABLE public.user (
    id INTEGER NOT NULL,
    email VARCHAR(63) NOT NULL,
    password VARCHAR(63) NOT NULL,
    first_name VARCHAR(255) DEFAULT NULL,
    last_name VARCHAR(255) DEFAULT NULL,
    created_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT NULL,
    PRIMARY KEY(id)
);
CREATE UNIQUE INDEX UNIQ_8D93D649E7927C74 ON public.user (email);
