--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

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
-- Name: uuid-ossp; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;


--
-- Name: EXTENSION "uuid-ossp"; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: floor; Type: TABLE; Schema: public; Owner: anthonytabbal
--

CREATE TABLE public.floor (
    floor_id character varying NOT NULL,
    floor_number integer,
    maximum_spots integer
);


ALTER TABLE public.floor OWNER TO atabbal;

--
-- Name: spot; Type: TABLE; Schema: public; Owner: anthonytabbal
--

CREATE TABLE public.spot (
    spot_id character varying NOT NULL,
    floor_id character varying NOT NULL,
    spot_type character varying,
    availability boolean
);


ALTER TABLE public.spot OWNER TO atabbal;

--
-- Name: ticket; Type: TABLE; Schema: public; Owner: anthonytabbal
--

CREATE TABLE public.ticket (
    ticket_id character varying NOT NULL,
    spot_id character varying,
    entrance_timestamp timestamp without time zone,
    exit_timestamp timestamp without time zone,
    cost numeric
);


ALTER TABLE public.ticket OWNER TO atabbal;

--
-- Data for Name: floor; Type: TABLE DATA; Schema: public; Owner: anthonytabbal
--

COPY public.floor (floor_id, floor_number, maximum_spots) FROM stdin;
bf5b5f2e-702e-45e2-bad0-84607828cb1f	1	30
993240cd-1e41-40e4-baad-2ab6e09b8764	2	40
7c9a8362-4b8b-4f2c-bb93-89eceaef059b	3	30
05e309f3-c809-4fba-ad8a-5f12851eb452	4	35
d66d2e00-a221-4325-b28c-1450bd2f358e	5	41
5f4e8bba-d608-44e6-833c-9dbbc673ea5e	6	15
\.


--
-- Data for Name: spot; Type: TABLE DATA; Schema: public; Owner: anthonytabbal
--

COPY public.spot (spot_id, floor_id, spot_type, availability) FROM stdin;
d2d91e9a-dc0d-4703-b645-208ea5edbbc5	bf5b5f2e-702e-45e2-bad0-84607828cb1f	Large	t
c4a8b7d5-c3d4-436e-9bed-f59ea6204df1	bf5b5f2e-702e-45e2-bad0-84607828cb1f	Compact	t
6f9d356f-9317-473f-b1c9-a7ccc42b68ce	bf5b5f2e-702e-45e2-bad0-84607828cb1f	Handicapped	t
da9f6abf-a769-4674-914e-6f5f5574d5af	bf5b5f2e-702e-45e2-bad0-84607828cb1f	Motorcycle	t
4eeed0ab-e9c5-4a49-85d6-925145835f0e	bf5b5f2e-702e-45e2-bad0-84607828cb1f	Large	t
a84991f3-aa02-4bc4-aa60-bb8ad2c227fe	bf5b5f2e-702e-45e2-bad0-84607828cb1f	Large	t
dae898fc-8764-47e1-99a6-78e51453cabf	bf5b5f2e-702e-45e2-bad0-84607828cb1f	Motorcycle	t
3a57b063-6487-40d3-8bda-18af8a85ad02	bf5b5f2e-702e-45e2-bad0-84607828cb1f	Compact	t
133872ec-2dbe-417b-a54e-301e8909dd84	993240cd-1e41-40e4-baad-2ab6e09b8764	Compact	t
7b7b10a2-ba7e-4a5f-95b5-da66c5e812b8	993240cd-1e41-40e4-baad-2ab6e09b8764	Compact	t
bb0b0428-5077-464f-b7bb-78533bd4975d	993240cd-1e41-40e4-baad-2ab6e09b8764	Compact	t
7e3358e0-6a30-47ab-b762-0ec821afd9ea	993240cd-1e41-40e4-baad-2ab6e09b8764	Compact	t
bed76e01-b91e-4a9a-a79d-a34b1be3d9ef	993240cd-1e41-40e4-baad-2ab6e09b8764	Large	t
e7d01f15-d70a-4ee6-82d2-979a3eec5daa	993240cd-1e41-40e4-baad-2ab6e09b8764	Large	t
655a2b3e-02bd-4321-8b91-0052c6eefe17	993240cd-1e41-40e4-baad-2ab6e09b8764	Motorcycle	t
fd7056b3-5b8c-4cb4-96a4-4f93cfd6e7ad	993240cd-1e41-40e4-baad-2ab6e09b8764	Handicapped	t
\.


--
-- Data for Name: ticket; Type: TABLE DATA; Schema: public; Owner: anthonytabbal
--

COPY public.ticket (ticket_id, spot_id, entrance_timestamp, exit_timestamp, cost) FROM stdin;
6b187e94-d346-4f53-aef7-0eca1ccfb56d	d2d91e9a-dc0d-4703-b645-208ea5edbbc5	2022-09-03 19:38:49.990823	\N	\N
95914fa7-e12b-4613-9fae-c4a89d603db0	d2d91e9a-dc0d-4703-b645-208ea5edbbc5	2022-09-03 13:57:09.046	2022-09-03 19:43:35.560439	16.0
3e3407ac-85b1-46b5-bd9c-c0d5eef7fc13	d2d91e9a-dc0d-4703-b645-208ea5edbbc5	2022-09-03 21:39:32.70247	\N	\N
\.


--
-- Name: floor floor_pk; Type: CONSTRAINT; Schema: public; Owner: anthonytabbal
--

ALTER TABLE ONLY public.floor
    ADD CONSTRAINT floor_pk PRIMARY KEY (floor_id);


--
-- Name: spot spot_pk; Type: CONSTRAINT; Schema: public; Owner: anthonytabbal
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT spot_pk PRIMARY KEY (spot_id);


--
-- Name: ticket ticket_pk; Type: CONSTRAINT; Schema: public; Owner: anthonytabbal
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_pk PRIMARY KEY (ticket_id);


--
-- Name: spot spot_fk; Type: FK CONSTRAINT; Schema: public; Owner: anthonytabbal
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT spot_fk FOREIGN KEY (floor_id) REFERENCES public.floor(floor_id);


--
-- Name: ticket ticket_fk; Type: FK CONSTRAINT; Schema: public; Owner: anthonytabbal
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_fk FOREIGN KEY (spot_id) REFERENCES public.spot(spot_id);


--
-- Name: TABLE floor; Type: ACL; Schema: public; Owner: anthonytabbal
--

GRANT ALL ON TABLE public.floor TO atabbal;


--
-- Name: TABLE spot; Type: ACL; Schema: public; Owner: anthonytabbal
--

GRANT ALL ON TABLE public.spot TO atabbal;


--
-- Name: TABLE ticket; Type: ACL; Schema: public; Owner: anthonytabbal
--

GRANT ALL ON TABLE public.ticket TO atabbal;


--
-- PostgreSQL database dump complete
--

