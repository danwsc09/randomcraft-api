drop table if exists sc_abilities cascade;
drop table if exists sc_match_data cascade;
drop table if exists sc_matches cascade;
drop table if exists sc_players cascade;
drop sequence if exists sc_abilities_SEQ;
drop sequence if exists sc_match_data_SEQ;
drop sequence if exists sc_matches_SEQ;
drop sequence if exists sc_players_SEQ;

--
-- PostgreSQL database dump
--

-- Dumped from database version 14.9
-- Dumped by pg_dump version 14.9

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

SET default_tablespace = '';

SET default_table_access_method = heap;

SET timezone TO 'Asia/Seoul';

--
-- Name: sc_abilities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sc_abilities (
    created_at timestamp(6) with time zone default now(),
    id bigint PRIMARY KEY,
    last_played timestamp(6) with time zone default NULL,
    loss_count bigint,
    updated_at timestamp(6) with time zone default NULL,
    win_count bigint,
    description text,
    test_date timestamp(6) with time zone default NULL,
    name character varying(255)
);


ALTER TABLE public.sc_abilities OWNER TO postgres;


--
-- Name: sc_match_data; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sc_match_data (
    location integer,
    ability_id bigint NOT NULL,
    created_at timestamp(6) with time zone default now(),
    id bigint PRIMARY KEY,
    match_id bigint,
    player_id bigint NOT NULL,
    updated_at timestamp(6) with time zone default NULL,
    race character varying(255),
    result character varying(255),
    CONSTRAINT sc_match_data_race_check CHECK (((race)::text = ANY ((ARRAY['ZERG'::character varying, 'PROTOSS'::character varying, 'TERRAN'::character varying])::text[]))),
    CONSTRAINT sc_match_data_result_check CHECK (((result)::text = ANY ((ARRAY['WIN'::character varying, 'LOSS'::character varying])::text[])))
);


ALTER TABLE public.sc_match_data OWNER TO postgres;

--
-- Name: sc_matches; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sc_matches (
    best_of integer,
    game_number integer,
    created_at timestamp(6) with time zone  default now(),
    id bigint PRIMARY KEY,
    played_on timestamp(6) with time zone default NULL,
    updated_at timestamp(6) with time zone default NULL,
    status character varying(255),
    summary text,
    vods text,
    CONSTRAINT sc_matches_status_check CHECK (((status)::text = ANY ((ARRAY['SUBMITTED'::character varying, 'APPROVED'::character varying, 'REJECTED'::character varying])::text[])))
);


ALTER TABLE public.sc_matches OWNER TO postgres;

--
-- Name: sc_players; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sc_players (
    created_at timestamp(6) with time zone default now(),
    id bigint PRIMARY KEY,
    last_played timestamp(6) with time zone default NULL,
    loss_count bigint,
    updated_at timestamp(6) with time zone default NULL,
    win_count bigint,
    afreeca_name character varying(255),
    in_game_name character varying(255),
    name character varying(255),
    race character varying(255),
    youtube_name character varying(255),
    CONSTRAINT sc_players_race_check CHECK (((race)::text = ANY ((ARRAY['ZERG'::character varying, 'PROTOSS'::character varying, 'TERRAN'::character varying])::text[])))
);


ALTER TABLE public.sc_players OWNER TO postgres;

--
-- Name: sc_match_data fkccxpojmecjj9lchgxt16anoxd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sc_match_data
    ADD CONSTRAINT fkccxpojmecjj9lchgxt16anoxd FOREIGN KEY (player_id) REFERENCES public.sc_players(id);


--
-- Name: sc_match_data fkfo6rrf7j8n5yikru6p6x7rd6m; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sc_match_data
    ADD CONSTRAINT fkfo6rrf7j8n5yikru6p6x7rd6m FOREIGN KEY (match_id) REFERENCES public.sc_matches(id);


--
-- Name: sc_match_data fkmc6egkdlhlgfp3wd80qlcb2r2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sc_match_data
    ADD CONSTRAINT fkmc6egkdlhlgfp3wd80qlcb2r2 FOREIGN KEY (ability_id) REFERENCES public.sc_abilities(id);


--
-- PostgreSQL database dump complete
--

