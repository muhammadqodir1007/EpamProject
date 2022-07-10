CREATE TABLE public.users
(
    id bigserial NOT NULL PRIMARY KEY ,
    username character varying(255) NOT NULL,
    "fullName" character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    "phoneNumber" character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
)
CREATE TABLE public.product
(
    id bigserial NOT NULL PRIMARY KEY ,
    titles character varying(255) NOT NULL,
    textData text NOT NULL,
    description character varying(255) NOT NULL,
    sourcelinkTo character varying(255) NOT NULL,
    photofile bytea[] NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    category_id integer
)
CREATE TABLE public.product
(
    id bigserial NOT NULL PRIMARY KEY ,
    nameOf character varying(255) NOT NULL,
    address text NOT NULL,
    description character varying(255) NOT NULL,
    phoneNumber character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    created_At TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_At TIMESTAMPTZ NOT NULL DEFAULT NOW()
)




CREATE OR REPLACE FUNCTION trigger_set_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = NOW();
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON users
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();

CREATE TABLE public."EmailConfir"
(
    id bigserial NOT NULL,
    email character varying(225) NOT NULL,
    PRIMARY KEY (id)
);