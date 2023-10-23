CREATE TABLE public.sc_abilities
(
    created_at  timestamp(6) with time zone,
    id          serial PRIMARY KEY,
    last_played timestamp(6) with time zone,
    loss_count  bigint,
    updated_at  timestamp(6) with time zone,
    win_count   bigint,
    category    character varying(255),
    description text,
    name        character varying(255)
);

CREATE TABLE public.sc_match_data
(
    location   integer,
    ability_id bigint NOT NULL,
    created_at timestamp(6) with time zone,
    id         serial PRIMARY KEY,
    match_id   bigint,
    player_id  bigint NOT NULL,
    updated_at timestamp(6) with time zone,
    race       character varying(255),
    result     character varying(255),
    CONSTRAINT sc_match_data_race_check CHECK (((race)::text = ANY ((ARRAY['ZERG':: character varying, 'PROTOSS':: character varying, 'TERRAN':: character varying])::text[])
) ),
    CONSTRAINT sc_match_data_result_check CHECK (((result)::text = ANY ((ARRAY['WIN'::character varying, 'LOSS'::character varying])::text[])))
);

CREATE TABLE public.sc_matches
(
    best_of     integer,
    game_number integer,
    created_at  timestamp(6) with time zone,
    id          serial PRIMARY KEY,
    played_on   timestamp(6) with time zone,
    updated_at  timestamp(6) with time zone,
    status      character varying(255),
    summary     text,
    vods        text,
    CONSTRAINT sc_matches_status_check CHECK (((status)::text = ANY ((ARRAY['SUBMITTED':: character varying, 'APPROVED':: character varying, 'REJECTED':: character varying])::text[])
) )
);

CREATE TABLE public.sc_players
(
    created_at   timestamp(6) with time zone,
    id           serial PRIMARY KEY,
    last_played  timestamp(6) with time zone,
    loss_count   bigint,
    updated_at   timestamp(6) with time zone,
    win_count    bigint,
    afreeca_name character varying(255),
    in_game_name character varying(255),
    name         character varying(255),
    race         character varying(255),
    youtube_name character varying(255),
    CONSTRAINT sc_players_race_check CHECK (((race)::text = ANY ((ARRAY['ZERG':: character varying, 'PROTOSS':: character varying, 'TERRAN':: character varying])::text[])
) )
);

