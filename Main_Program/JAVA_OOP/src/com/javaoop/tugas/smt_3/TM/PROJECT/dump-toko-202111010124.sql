--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4
-- Dumped by pg_dump version 12.2

-- Started on 2021-11-01 01:24:10

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'WIN1252';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 10 (class 2615 OID 19090)
-- Name: barang; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA barang;


ALTER SCHEMA barang OWNER TO postgres;

--
-- TOC entry 9 (class 2615 OID 19175)
-- Name: transaksi; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA transaksi;


ALTER SCHEMA transaksi OWNER TO postgres;

--
-- TOC entry 4 (class 2615 OID 19089)
-- Name: users; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA users;


ALTER SCHEMA users OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 212 (class 1259 OID 19152)
-- Name: barang; Type: TABLE; Schema: barang; Owner: postgres
--

CREATE TABLE barang.barang (
    id_barang integer NOT NULL,
    nama_barang text NOT NULL,
    kd_sts_aktif character(1) DEFAULT 1 NOT NULL,
    created_at timestamp without time zone DEFAULT now() NOT NULL,
    updated_at timestamp without time zone DEFAULT now() NOT NULL,
    kode_barang text NOT NULL,
    kode_satuan_barang character(1) NOT NULL
);


ALTER TABLE barang.barang OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 19150)
-- Name: barang_id_barang_seq; Type: SEQUENCE; Schema: barang; Owner: postgres
--

CREATE SEQUENCE barang.barang_id_barang_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE barang.barang_id_barang_seq OWNER TO postgres;

--
-- TOC entry 2946 (class 0 OID 0)
-- Dependencies: 211
-- Name: barang_id_barang_seq; Type: SEQUENCE OWNED BY; Schema: barang; Owner: postgres
--

ALTER SEQUENCE barang.barang_id_barang_seq OWNED BY barang.barang.id_barang;


--
-- TOC entry 216 (class 1259 OID 27403)
-- Name: barang_jual; Type: TABLE; Schema: barang; Owner: postgres
--

CREATE TABLE barang.barang_jual (
    id_barang_jual integer NOT NULL,
    id_barang integer NOT NULL,
    id_person integer NOT NULL,
    harga_jual_satuan money NOT NULL,
    satuan_barang text,
    kd_sts_aktif character(1) DEFAULT 1 NOT NULL,
    created_at timestamp without time zone DEFAULT now() NOT NULL,
    updated_at timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE barang.barang_jual OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 27401)
-- Name: barang_jual_id_barang_jual_seq; Type: SEQUENCE; Schema: barang; Owner: postgres
--

CREATE SEQUENCE barang.barang_jual_id_barang_jual_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE barang.barang_jual_id_barang_jual_seq OWNER TO postgres;

--
-- TOC entry 2947 (class 0 OID 0)
-- Dependencies: 215
-- Name: barang_jual_id_barang_jual_seq; Type: SEQUENCE OWNED BY; Schema: barang; Owner: postgres
--

ALTER SEQUENCE barang.barang_jual_id_barang_jual_seq OWNED BY barang.barang_jual.id_barang_jual;


--
-- TOC entry 214 (class 1259 OID 27295)
-- Name: barang_masuk; Type: TABLE; Schema: barang; Owner: postgres
--

CREATE TABLE barang.barang_masuk (
    id_barang_masuk integer NOT NULL,
    id_barang integer NOT NULL,
    id_person integer NOT NULL,
    jumlah_barang integer NOT NULL,
    harga_satuan money NOT NULL,
    tgl_masuk timestamp without time zone DEFAULT now() NOT NULL,
    kd_sts_aktif character(1) DEFAULT 1 NOT NULL,
    created_at timestamp without time zone DEFAULT now() NOT NULL,
    updated_at timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE barang.barang_masuk OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 27293)
-- Name: barang_masuk_id_barang_masuk_seq; Type: SEQUENCE; Schema: barang; Owner: postgres
--

CREATE SEQUENCE barang.barang_masuk_id_barang_masuk_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE barang.barang_masuk_id_barang_masuk_seq OWNER TO postgres;

--
-- TOC entry 2948 (class 0 OID 0)
-- Dependencies: 213
-- Name: barang_masuk_id_barang_masuk_seq; Type: SEQUENCE OWNED BY; Schema: barang; Owner: postgres
--

ALTER SEQUENCE barang.barang_masuk_id_barang_masuk_seq OWNED BY barang.barang_masuk.id_barang_masuk;


--
-- TOC entry 220 (class 1259 OID 43664)
-- Name: satuan_barang; Type: TABLE; Schema: barang; Owner: postgres
--

CREATE TABLE barang.satuan_barang (
    kode_satuan_barang character(1) NOT NULL,
    satuan_barang text NOT NULL
);


ALTER TABLE barang.satuan_barang OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 35474)
-- Name: list_transaksi_penjualan; Type: TABLE; Schema: transaksi; Owner: postgres
--

CREATE TABLE transaksi.list_transaksi_penjualan (
    id_list_transaksi_penjualan integer NOT NULL,
    id_transaksi_penjualan uuid NOT NULL,
    id_barang_jual integer NOT NULL,
    jumlah_barang integer NOT NULL,
    kd_sts_aktif character(1) DEFAULT 1 NOT NULL,
    created_at timestamp without time zone DEFAULT now() NOT NULL,
    updated_at timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE transaksi.list_transaksi_penjualan OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 35472)
-- Name: list_transaksi_penjualan_id_list_transaksi_penjualan_seq; Type: SEQUENCE; Schema: transaksi; Owner: postgres
--

CREATE SEQUENCE transaksi.list_transaksi_penjualan_id_list_transaksi_penjualan_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE transaksi.list_transaksi_penjualan_id_list_transaksi_penjualan_seq OWNER TO postgres;

--
-- TOC entry 2949 (class 0 OID 0)
-- Dependencies: 217
-- Name: list_transaksi_penjualan_id_list_transaksi_penjualan_seq; Type: SEQUENCE OWNED BY; Schema: transaksi; Owner: postgres
--

ALTER SEQUENCE transaksi.list_transaksi_penjualan_id_list_transaksi_penjualan_seq OWNED BY transaksi.list_transaksi_penjualan.id_list_transaksi_penjualan;


--
-- TOC entry 219 (class 1259 OID 35482)
-- Name: transaksi_penjualan; Type: TABLE; Schema: transaksi; Owner: postgres
--

CREATE TABLE transaksi.transaksi_penjualan (
    id_transaksi_penjualan uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    id_person integer NOT NULL,
    kd_sts_aktif character(1) DEFAULT 1 NOT NULL,
    tgl_transaksi timestamp without time zone DEFAULT now() NOT NULL,
    tgl_updated timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE transaksi.transaksi_penjualan OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 19115)
-- Name: peran; Type: TABLE; Schema: users; Owner: postgres
--

CREATE TABLE users.peran (
    id_peran integer NOT NULL,
    nama_peran text NOT NULL,
    kd_sts_aktif character(1) NOT NULL,
    created_at timestamp without time zone DEFAULT now() NOT NULL,
    updated_at timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE users.peran OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 19113)
-- Name: peran_id_peran_seq; Type: SEQUENCE; Schema: users; Owner: postgres
--

CREATE SEQUENCE users.peran_id_peran_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users.peran_id_peran_seq OWNER TO postgres;

--
-- TOC entry 2950 (class 0 OID 0)
-- Dependencies: 207
-- Name: peran_id_peran_seq; Type: SEQUENCE OWNED BY; Schema: users; Owner: postgres
--

ALTER SEQUENCE users.peran_id_peran_seq OWNED BY users.peran.id_peran;


--
-- TOC entry 210 (class 1259 OID 19126)
-- Name: peran_user; Type: TABLE; Schema: users; Owner: postgres
--

CREATE TABLE users.peran_user (
    id_peran_user integer NOT NULL,
    id_person integer NOT NULL,
    id_peran integer NOT NULL,
    nama_user text NOT NULL,
    password text NOT NULL,
    kd_sts_aktif character(1) DEFAULT 1 NOT NULL,
    created_at timestamp without time zone DEFAULT now() NOT NULL,
    updated_at timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE users.peran_user OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 19124)
-- Name: peran_user_id_peran_user_seq; Type: SEQUENCE; Schema: users; Owner: postgres
--

CREATE SEQUENCE users.peran_user_id_peran_user_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users.peran_user_id_peran_user_seq OWNER TO postgres;

--
-- TOC entry 2951 (class 0 OID 0)
-- Dependencies: 209
-- Name: peran_user_id_peran_user_seq; Type: SEQUENCE OWNED BY; Schema: users; Owner: postgres
--

ALTER SEQUENCE users.peran_user_id_peran_user_seq OWNED BY users.peran_user.id_peran_user;


--
-- TOC entry 206 (class 1259 OID 19104)
-- Name: person; Type: TABLE; Schema: users; Owner: postgres
--

CREATE TABLE users.person (
    id_person integer NOT NULL,
    nama text NOT NULL,
    email text NOT NULL,
    no_hp text NOT NULL,
    alamat text,
    kd_sts_aktif character(1),
    created_at timestamp without time zone DEFAULT now() NOT NULL,
    updated_at timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE users.person OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 19102)
-- Name: person_id_person_seq; Type: SEQUENCE; Schema: users; Owner: postgres
--

CREATE SEQUENCE users.person_id_person_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users.person_id_person_seq OWNER TO postgres;

--
-- TOC entry 2952 (class 0 OID 0)
-- Dependencies: 205
-- Name: person_id_person_seq; Type: SEQUENCE OWNED BY; Schema: users; Owner: postgres
--

ALTER SEQUENCE users.person_id_person_seq OWNED BY users.person.id_person;


--
-- TOC entry 2752 (class 2604 OID 19155)
-- Name: barang id_barang; Type: DEFAULT; Schema: barang; Owner: postgres
--

ALTER TABLE ONLY barang.barang ALTER COLUMN id_barang SET DEFAULT nextval('barang.barang_id_barang_seq'::regclass);


--
-- TOC entry 2761 (class 2604 OID 27406)
-- Name: barang_jual id_barang_jual; Type: DEFAULT; Schema: barang; Owner: postgres
--

ALTER TABLE ONLY barang.barang_jual ALTER COLUMN id_barang_jual SET DEFAULT nextval('barang.barang_jual_id_barang_jual_seq'::regclass);


--
-- TOC entry 2756 (class 2604 OID 27298)
-- Name: barang_masuk id_barang_masuk; Type: DEFAULT; Schema: barang; Owner: postgres
--

ALTER TABLE ONLY barang.barang_masuk ALTER COLUMN id_barang_masuk SET DEFAULT nextval('barang.barang_masuk_id_barang_masuk_seq'::regclass);


--
-- TOC entry 2765 (class 2604 OID 35477)
-- Name: list_transaksi_penjualan id_list_transaksi_penjualan; Type: DEFAULT; Schema: transaksi; Owner: postgres
--

ALTER TABLE ONLY transaksi.list_transaksi_penjualan ALTER COLUMN id_list_transaksi_penjualan SET DEFAULT nextval('transaksi.list_transaksi_penjualan_id_list_transaksi_penjualan_seq'::regclass);


--
-- TOC entry 2745 (class 2604 OID 19118)
-- Name: peran id_peran; Type: DEFAULT; Schema: users; Owner: postgres
--

ALTER TABLE ONLY users.peran ALTER COLUMN id_peran SET DEFAULT nextval('users.peran_id_peran_seq'::regclass);


--
-- TOC entry 2748 (class 2604 OID 19129)
-- Name: peran_user id_peran_user; Type: DEFAULT; Schema: users; Owner: postgres
--

ALTER TABLE ONLY users.peran_user ALTER COLUMN id_peran_user SET DEFAULT nextval('users.peran_user_id_peran_user_seq'::regclass);


--
-- TOC entry 2742 (class 2604 OID 19107)
-- Name: person id_person; Type: DEFAULT; Schema: users; Owner: postgres
--

ALTER TABLE ONLY users.person ALTER COLUMN id_person SET DEFAULT nextval('users.person_id_person_seq'::regclass);


--
-- TOC entry 2932 (class 0 OID 19152)
-- Dependencies: 212
-- Data for Name: barang; Type: TABLE DATA; Schema: barang; Owner: postgres
--

COPY barang.barang (id_barang, nama_barang, kd_sts_aktif, created_at, updated_at, kode_barang, kode_satuan_barang) FROM stdin;
1	Beras	1	2021-10-21 22:09:26.321386	2021-10-21 22:09:26.321386	BRS	1
2	Gula	1	2021-10-21 22:09:45.768709	2021-10-21 22:09:45.768709	GL	1
3	Minyak goreng	1	2021-10-21 22:10:06.421768	2021-10-21 22:10:06.421768	MG	2
\.


--
-- TOC entry 2936 (class 0 OID 27403)
-- Dependencies: 216
-- Data for Name: barang_jual; Type: TABLE DATA; Schema: barang; Owner: postgres
--

COPY barang.barang_jual (id_barang_jual, id_barang, id_person, harga_jual_satuan, satuan_barang, kd_sts_aktif, created_at, updated_at) FROM stdin;
1	1	3	$ 13.500,00	Kg	1	2021-10-21 22:55:24.56303	2021-10-21 22:55:24.56303
2	2	3	$ 17.000,00	Kg	1	2021-10-21 22:56:34.806175	2021-10-21 22:56:34.806175
3	3	3	$ 22.000,00	Liter	1	2021-10-21 22:57:05.441873	2021-10-21 22:57:05.441873
\.


--
-- TOC entry 2934 (class 0 OID 27295)
-- Dependencies: 214
-- Data for Name: barang_masuk; Type: TABLE DATA; Schema: barang; Owner: postgres
--

COPY barang.barang_masuk (id_barang_masuk, id_barang, id_person, jumlah_barang, harga_satuan, tgl_masuk, kd_sts_aktif, created_at, updated_at) FROM stdin;
1	1	2	1000	$ 12.000,00	2021-10-21 22:11:03.813988	1	2021-10-21 22:11:03.813988	2021-10-21 22:11:03.813988
3	3	2	1200	$ 19.000,00	2021-10-21 22:11:49	1	2021-10-21 22:12:54.733513	2021-10-21 22:12:54.733513
2	2	2	750	$ 15.000,00	2021-10-21 22:11:49.483908	1	2021-10-21 22:11:49.483908	2021-10-21 22:11:49.483908
4	2	2	2	$ 14.000,00	2021-10-28 20:52:26.286705	1	2021-10-28 20:52:26.286705	2021-10-28 20:52:26.286705
6	3	2	100	$ 19.000,00	2021-10-28 21:02:04.39996	1	2021-10-28 21:02:04.39996	2021-10-28 21:02:04.39996
7	1	2	30	$ 12.500,00	2021-10-28 21:08:15.949972	1	2021-10-28 21:08:15.949972	2021-10-28 21:08:15.949972
8	2	2	2	$ 15.000,00	2021-10-28 23:55:41.293965	1	2021-10-28 23:55:41.293965	2021-10-28 23:55:41.293965
9	1	2	11	$ 12.000,00	2021-10-29 00:03:53.517663	1	2021-10-29 00:03:53.517663	2021-10-29 00:03:53.517663
10	2	2	5	$ 14.500,00	2021-10-29 00:09:30.791023	1	2021-10-29 00:09:30.791023	2021-10-29 00:09:30.791023
11	2	2	20	$ 13.000,00	2021-10-29 14:59:12.861099	1	2021-10-29 14:59:12.861099	2021-10-29 14:59:12.861099
12	3	2	100	$ 20.000,00	2021-10-30 20:58:36.352093	1	2021-10-30 20:58:36.352093	2021-10-30 20:58:36.352093
13	1	2	20	$ 12.000,00	2021-10-30 21:07:34.262172	1	2021-10-30 21:07:34.262172	2021-10-30 21:07:34.262172
18	1	2	100	$ 12.000,00	2021-11-01 00:53:59.508355	1	2021-11-01 00:53:59.508355	2021-11-01 00:53:59.508355
\.


--
-- TOC entry 2940 (class 0 OID 43664)
-- Dependencies: 220
-- Data for Name: satuan_barang; Type: TABLE DATA; Schema: barang; Owner: postgres
--

COPY barang.satuan_barang (kode_satuan_barang, satuan_barang) FROM stdin;
1	Kilogram
2	Liter
\.


--
-- TOC entry 2938 (class 0 OID 35474)
-- Dependencies: 218
-- Data for Name: list_transaksi_penjualan; Type: TABLE DATA; Schema: transaksi; Owner: postgres
--

COPY transaksi.list_transaksi_penjualan (id_list_transaksi_penjualan, id_transaksi_penjualan, id_barang_jual, jumlah_barang, kd_sts_aktif, created_at, updated_at) FROM stdin;
2	ccd62338-bc10-409f-b46c-bfcf4da9f1c2	1	10	1	2021-10-28 17:09:38.617797	2021-10-28 17:09:38.617797
3	1bf2d845-6cec-4e8c-9d50-bc9ba705294f	2	20	1	2021-10-28 17:11:32.149037	2021-10-28 17:11:32.149037
4	87398f2c-dfca-477b-80db-6c63381bd195	1	20	1	2021-10-28 18:04:15.391995	2021-10-28 18:04:15.391995
5	88b57f89-ba66-4444-b2b7-edb541126881	2	10	1	2021-10-28 18:07:18.262042	2021-10-28 18:07:18.262042
6	88b57f89-ba66-4444-b2b7-edb541126881	2	25	1	2021-10-28 18:07:18.26295	2021-10-28 18:07:18.26295
7	b53a0e99-1736-4b57-95cb-98fd2851eae9	2	30	1	2021-10-28 18:08:43.634387	2021-10-28 18:08:43.634387
8	b53a0e99-1736-4b57-95cb-98fd2851eae9	2	50	1	2021-10-28 18:08:43.634869	2021-10-28 18:08:43.634869
9	b53a0e99-1736-4b57-95cb-98fd2851eae9	3	25	1	2021-10-28 18:08:43.635249	2021-10-28 18:08:43.635249
10	3d5bb2f6-fbe0-41cf-920a-9f8dcb2cb195	1	50	1	2021-10-28 21:18:42.023312	2021-10-28 21:18:42.023312
11	44ce5a36-5fcb-49da-89e4-67faf461a656	1	20	1	2021-10-28 21:34:29.818833	2021-10-28 21:34:29.818833
12	c495029b-65af-4d07-8579-8ae6e153ed92	3	10	1	2021-10-28 22:48:26.374249	2021-10-28 22:48:26.374249
13	c495029b-65af-4d07-8579-8ae6e153ed92	1	20	1	2021-10-28 22:48:26.375074	2021-10-28 22:48:26.375074
14	760e6274-0c9e-4562-b377-3fad042e099f	1	2	1	2021-10-28 22:59:05.754108	2021-10-28 22:59:05.754108
15	760e6274-0c9e-4562-b377-3fad042e099f	3	1	1	2021-10-28 22:59:05.755218	2021-10-28 22:59:05.755218
16	760e6274-0c9e-4562-b377-3fad042e099f	1	1	1	2021-10-28 22:59:05.755578	2021-10-28 22:59:05.755578
17	e33c9b32-b37b-44e6-9730-3c839f486e64	1	1	1	2021-10-28 23:10:55.914572	2021-10-28 23:10:55.914572
18	e33c9b32-b37b-44e6-9730-3c839f486e64	2	1	1	2021-10-28 23:10:55.915685	2021-10-28 23:10:55.915685
19	e33c9b32-b37b-44e6-9730-3c839f486e64	3	1	1	2021-10-28 23:10:55.916088	2021-10-28 23:10:55.916088
20	ba024a41-9dca-47a0-944e-81401e9d844d	1	1	1	2021-10-28 23:12:43.744146	2021-10-28 23:12:43.744146
21	ba024a41-9dca-47a0-944e-81401e9d844d	3	3	1	2021-10-28 23:12:43.744495	2021-10-28 23:12:43.744495
22	ba024a41-9dca-47a0-944e-81401e9d844d	2	2	1	2021-10-28 23:12:43.744948	2021-10-28 23:12:43.744948
23	4d02c5a4-2058-4480-a5a9-5b429a3b134e	1	1	1	2021-10-28 23:17:46.31086	2021-10-28 23:17:46.31086
24	4d02c5a4-2058-4480-a5a9-5b429a3b134e	2	4	1	2021-10-28 23:17:46.311731	2021-10-28 23:17:46.311731
25	4d02c5a4-2058-4480-a5a9-5b429a3b134e	3	5	1	2021-10-28 23:17:46.312178	2021-10-28 23:17:46.312178
26	4a340131-5aa9-4fe5-871a-1f7ca03cb9df	2	10	1	2021-10-28 23:27:29.741993	2021-10-28 23:27:29.741993
27	4a340131-5aa9-4fe5-871a-1f7ca03cb9df	3	5	1	2021-10-28 23:27:29.74277	2021-10-28 23:27:29.74277
28	7b11e5ef-51e0-4d4e-9dad-620259406852	3	100	1	2021-10-28 23:31:20.275977	2021-10-28 23:31:20.275977
29	e9c82e2c-608c-4983-a7d7-921df8aaa483	3	10	1	2021-10-28 23:32:04.44615	2021-10-28 23:32:04.44615
30	b56a8a96-4ad8-4b43-b8b4-9a85c389aec5	2	10	1	2021-10-28 23:34:25.047878	2021-10-28 23:34:25.047878
31	b03e29c6-7cb0-4dff-8340-c3efef15fe39	2	12	1	2021-10-28 23:54:00.151442	2021-10-28 23:54:00.151442
32	b03e29c6-7cb0-4dff-8340-c3efef15fe39	1	15	1	2021-10-28 23:54:00.1522	2021-10-28 23:54:00.1522
33	b03e29c6-7cb0-4dff-8340-c3efef15fe39	3	2	1	2021-10-28 23:54:00.152538	2021-10-28 23:54:00.152538
34	3a1f4f7b-b012-4a18-9975-2e2c7d96b2b8	2	5	1	2021-10-29 14:57:09.298064	2021-10-29 14:57:09.298064
35	ac6bf3a2-c72e-4bb9-886e-8a054468196f	3	38	1	2021-10-29 14:58:05.294676	2021-10-29 14:58:05.294676
36	1945d9d4-db21-4c13-9a42-35629f0f53a9	2	12	1	2021-10-30 20:57:20.363618	2021-10-30 20:57:20.363618
37	1945d9d4-db21-4c13-9a42-35629f0f53a9	1	15	1	2021-10-30 20:57:20.366733	2021-10-30 20:57:20.366733
38	1945d9d4-db21-4c13-9a42-35629f0f53a9	3	10	1	2021-10-30 20:57:20.367045	2021-10-30 20:57:20.367045
\.


--
-- TOC entry 2939 (class 0 OID 35482)
-- Dependencies: 219
-- Data for Name: transaksi_penjualan; Type: TABLE DATA; Schema: transaksi; Owner: postgres
--

COPY transaksi.transaksi_penjualan (id_transaksi_penjualan, id_person, kd_sts_aktif, tgl_transaksi, tgl_updated) FROM stdin;
ccd62338-bc10-409f-b46c-bfcf4da9f1c2	3	1	2021-10-28 17:09:10.64872	2021-10-28 17:09:10.64872
1bf2d845-6cec-4e8c-9d50-bc9ba705294f	3	1	2021-10-28 17:10:56.812986	2021-10-28 17:10:56.812986
87398f2c-dfca-477b-80db-6c63381bd195	3	1	2021-10-28 18:03:13.105658	2021-10-28 18:03:13.105658
88b57f89-ba66-4444-b2b7-edb541126881	3	1	2021-10-28 18:07:18.256167	2021-10-28 18:07:18.256167
b53a0e99-1736-4b57-95cb-98fd2851eae9	3	1	2021-10-28 18:08:43.630186	2021-10-28 18:08:43.630186
3d5bb2f6-fbe0-41cf-920a-9f8dcb2cb195	3	1	2021-10-28 21:18:42.017596	2021-10-28 21:18:42.017596
44ce5a36-5fcb-49da-89e4-67faf461a656	3	1	2021-10-28 21:34:29.811889	2021-10-28 21:34:29.811889
c495029b-65af-4d07-8579-8ae6e153ed92	3	1	2021-10-28 22:48:26.367533	2021-10-28 22:48:26.367533
760e6274-0c9e-4562-b377-3fad042e099f	3	1	2021-10-28 22:59:05.747324	2021-10-28 22:59:05.747324
e33c9b32-b37b-44e6-9730-3c839f486e64	3	1	2021-10-28 23:10:55.906717	2021-10-28 23:10:55.906717
ba024a41-9dca-47a0-944e-81401e9d844d	3	1	2021-10-28 23:12:43.740805	2021-10-28 23:12:43.740805
4d02c5a4-2058-4480-a5a9-5b429a3b134e	3	1	2021-10-28 23:17:46.305446	2021-10-28 23:17:46.305446
4a340131-5aa9-4fe5-871a-1f7ca03cb9df	3	1	2021-10-28 23:27:29.737472	2021-10-28 23:27:29.737472
7b11e5ef-51e0-4d4e-9dad-620259406852	3	1	2021-10-28 23:31:20.270905	2021-10-28 23:31:20.270905
e9c82e2c-608c-4983-a7d7-921df8aaa483	3	1	2021-10-28 23:32:04.444996	2021-10-28 23:32:04.444996
b56a8a96-4ad8-4b43-b8b4-9a85c389aec5	3	1	2021-10-28 23:34:25.043281	2021-10-28 23:34:25.043281
b03e29c6-7cb0-4dff-8340-c3efef15fe39	3	1	2021-10-28 23:54:00.144044	2021-10-28 23:54:00.144044
3a1f4f7b-b012-4a18-9975-2e2c7d96b2b8	3	1	2021-10-29 14:57:09.289918	2021-10-29 14:57:09.289918
ac6bf3a2-c72e-4bb9-886e-8a054468196f	3	1	2021-10-29 14:58:05.292876	2021-10-29 14:58:05.292876
1945d9d4-db21-4c13-9a42-35629f0f53a9	3	1	2021-10-30 20:57:20.353961	2021-10-30 20:57:20.353961
\.


--
-- TOC entry 2928 (class 0 OID 19115)
-- Dependencies: 208
-- Data for Name: peran; Type: TABLE DATA; Schema: users; Owner: postgres
--

COPY users.peran (id_peran, nama_peran, kd_sts_aktif, created_at, updated_at) FROM stdin;
1	Admin	1	2021-10-21 22:03:12.797237	2021-10-21 22:03:12.797237
2	Operator barang masuk	1	2021-10-21 22:03:44.484819	2021-10-21 22:03:44.484819
3	Kasir	1	2021-10-21 22:04:02.930297	2021-10-21 22:04:02.930297
\.


--
-- TOC entry 2930 (class 0 OID 19126)
-- Dependencies: 210
-- Data for Name: peran_user; Type: TABLE DATA; Schema: users; Owner: postgres
--

COPY users.peran_user (id_peran_user, id_person, id_peran, nama_user, password, kd_sts_aktif, created_at, updated_at) FROM stdin;
1	1	1	admin	1234	1	2021-10-21 22:04:43.117971	2021-10-21 22:04:43.117971
2	2	2	budi	1234	1	2021-10-21 22:07:13.492828	2021-10-21 22:07:13.492828
3	3	3	asep	1234	1	2021-10-21 22:07:33.857812	2021-10-21 22:07:33.857812
\.


--
-- TOC entry 2926 (class 0 OID 19104)
-- Dependencies: 206
-- Data for Name: person; Type: TABLE DATA; Schema: users; Owner: postgres
--

COPY users.person (id_person, nama, email, no_hp, alamat, kd_sts_aktif, created_at, updated_at) FROM stdin;
1	Istiyadi	istiyadi.s@gmail.com	0888888888	Jember	1	2021-10-21 22:02:42.834616	2021-10-21 22:02:42.834616
2	Budi	budi@gmail.com	08128282828	Patrang	1	2021-10-21 22:05:46.987907	2021-10-21 22:05:46.987907
3	Asep	asep@gmail.com	08543210100	Sumbersari	1	2021-10-21 22:06:47.361191	2021-10-21 22:06:47.361191
\.


--
-- TOC entry 2953 (class 0 OID 0)
-- Dependencies: 211
-- Name: barang_id_barang_seq; Type: SEQUENCE SET; Schema: barang; Owner: postgres
--

SELECT pg_catalog.setval('barang.barang_id_barang_seq', 3, true);


--
-- TOC entry 2954 (class 0 OID 0)
-- Dependencies: 215
-- Name: barang_jual_id_barang_jual_seq; Type: SEQUENCE SET; Schema: barang; Owner: postgres
--

SELECT pg_catalog.setval('barang.barang_jual_id_barang_jual_seq', 2, true);


--
-- TOC entry 2955 (class 0 OID 0)
-- Dependencies: 213
-- Name: barang_masuk_id_barang_masuk_seq; Type: SEQUENCE SET; Schema: barang; Owner: postgres
--

SELECT pg_catalog.setval('barang.barang_masuk_id_barang_masuk_seq', 18, true);


--
-- TOC entry 2956 (class 0 OID 0)
-- Dependencies: 217
-- Name: list_transaksi_penjualan_id_list_transaksi_penjualan_seq; Type: SEQUENCE SET; Schema: transaksi; Owner: postgres
--

SELECT pg_catalog.setval('transaksi.list_transaksi_penjualan_id_list_transaksi_penjualan_seq', 38, true);


--
-- TOC entry 2957 (class 0 OID 0)
-- Dependencies: 207
-- Name: peran_id_peran_seq; Type: SEQUENCE SET; Schema: users; Owner: postgres
--

SELECT pg_catalog.setval('users.peran_id_peran_seq', 3, true);


--
-- TOC entry 2958 (class 0 OID 0)
-- Dependencies: 209
-- Name: peran_user_id_peran_user_seq; Type: SEQUENCE SET; Schema: users; Owner: postgres
--

SELECT pg_catalog.setval('users.peran_user_id_peran_user_seq', 3, true);


--
-- TOC entry 2959 (class 0 OID 0)
-- Dependencies: 205
-- Name: person_id_person_seq; Type: SEQUENCE SET; Schema: users; Owner: postgres
--

SELECT pg_catalog.setval('users.person_id_person_seq', 3, true);


--
-- TOC entry 2782 (class 2606 OID 27414)
-- Name: barang_jual barang_jual_pk; Type: CONSTRAINT; Schema: barang; Owner: postgres
--

ALTER TABLE ONLY barang.barang_jual
    ADD CONSTRAINT barang_jual_pk PRIMARY KEY (id_barang_jual);


--
-- TOC entry 2780 (class 2606 OID 35504)
-- Name: barang_masuk barang_masuk_pk; Type: CONSTRAINT; Schema: barang; Owner: postgres
--

ALTER TABLE ONLY barang.barang_masuk
    ADD CONSTRAINT barang_masuk_pk PRIMARY KEY (id_barang_masuk);


--
-- TOC entry 2778 (class 2606 OID 19174)
-- Name: barang barang_pk; Type: CONSTRAINT; Schema: barang; Owner: postgres
--

ALTER TABLE ONLY barang.barang
    ADD CONSTRAINT barang_pk PRIMARY KEY (id_barang);


--
-- TOC entry 2788 (class 2606 OID 43671)
-- Name: satuan_barang satuan_barang_pk; Type: CONSTRAINT; Schema: barang; Owner: postgres
--

ALTER TABLE ONLY barang.satuan_barang
    ADD CONSTRAINT satuan_barang_pk PRIMARY KEY (kode_satuan_barang);


--
-- TOC entry 2784 (class 2606 OID 35481)
-- Name: list_transaksi_penjualan list_transaksi_penjualan_pk; Type: CONSTRAINT; Schema: transaksi; Owner: postgres
--

ALTER TABLE ONLY transaksi.list_transaksi_penjualan
    ADD CONSTRAINT list_transaksi_penjualan_pk PRIMARY KEY (id_list_transaksi_penjualan);


--
-- TOC entry 2786 (class 2606 OID 35490)
-- Name: transaksi_penjualan transaksi_penjualan_pk; Type: CONSTRAINT; Schema: transaksi; Owner: postgres
--

ALTER TABLE ONLY transaksi.transaksi_penjualan
    ADD CONSTRAINT transaksi_penjualan_pk PRIMARY KEY (id_transaksi_penjualan);


--
-- TOC entry 2776 (class 2606 OID 19137)
-- Name: peran peran_pk; Type: CONSTRAINT; Schema: users; Owner: postgres
--

ALTER TABLE ONLY users.peran
    ADD CONSTRAINT peran_pk PRIMARY KEY (id_peran);


--
-- TOC entry 2774 (class 2606 OID 19139)
-- Name: person person_pk; Type: CONSTRAINT; Schema: users; Owner: postgres
--

ALTER TABLE ONLY users.person
    ADD CONSTRAINT person_pk PRIMARY KEY (id_person);


--
-- TOC entry 2791 (class 2606 OID 43682)
-- Name: barang barang_fk; Type: FK CONSTRAINT; Schema: barang; Owner: postgres
--

ALTER TABLE ONLY barang.barang
    ADD CONSTRAINT barang_fk FOREIGN KEY (kode_satuan_barang) REFERENCES barang.satuan_barang(kode_satuan_barang);


--
-- TOC entry 2794 (class 2606 OID 27415)
-- Name: barang_jual barang_jual_fk; Type: FK CONSTRAINT; Schema: barang; Owner: postgres
--

ALTER TABLE ONLY barang.barang_jual
    ADD CONSTRAINT barang_jual_fk FOREIGN KEY (id_barang) REFERENCES barang.barang(id_barang);


--
-- TOC entry 2795 (class 2606 OID 27420)
-- Name: barang_jual barang_jual_fk_1; Type: FK CONSTRAINT; Schema: barang; Owner: postgres
--

ALTER TABLE ONLY barang.barang_jual
    ADD CONSTRAINT barang_jual_fk_1 FOREIGN KEY (id_person) REFERENCES users.person(id_person);


--
-- TOC entry 2792 (class 2606 OID 27360)
-- Name: barang_masuk barang_masuk_fk; Type: FK CONSTRAINT; Schema: barang; Owner: postgres
--

ALTER TABLE ONLY barang.barang_masuk
    ADD CONSTRAINT barang_masuk_fk FOREIGN KEY (id_barang) REFERENCES barang.barang(id_barang);


--
-- TOC entry 2793 (class 2606 OID 27365)
-- Name: barang_masuk barang_masuk_fk_1; Type: FK CONSTRAINT; Schema: barang; Owner: postgres
--

ALTER TABLE ONLY barang.barang_masuk
    ADD CONSTRAINT barang_masuk_fk_1 FOREIGN KEY (id_person) REFERENCES users.person(id_person);


--
-- TOC entry 2796 (class 2606 OID 43687)
-- Name: list_transaksi_penjualan list_transaksi_penjualan_fk; Type: FK CONSTRAINT; Schema: transaksi; Owner: postgres
--

ALTER TABLE ONLY transaksi.list_transaksi_penjualan
    ADD CONSTRAINT list_transaksi_penjualan_fk FOREIGN KEY (id_transaksi_penjualan) REFERENCES transaksi.transaksi_penjualan(id_transaksi_penjualan);


--
-- TOC entry 2797 (class 2606 OID 43692)
-- Name: list_transaksi_penjualan list_transaksi_penjualan_fk_2; Type: FK CONSTRAINT; Schema: transaksi; Owner: postgres
--

ALTER TABLE ONLY transaksi.list_transaksi_penjualan
    ADD CONSTRAINT list_transaksi_penjualan_fk_2 FOREIGN KEY (id_barang_jual) REFERENCES barang.barang_jual(id_barang_jual);


--
-- TOC entry 2798 (class 2606 OID 35497)
-- Name: transaksi_penjualan transaksi_penjualan_fk; Type: FK CONSTRAINT; Schema: transaksi; Owner: postgres
--

ALTER TABLE ONLY transaksi.transaksi_penjualan
    ADD CONSTRAINT transaksi_penjualan_fk FOREIGN KEY (id_person) REFERENCES users.person(id_person);


--
-- TOC entry 2789 (class 2606 OID 19140)
-- Name: peran_user peran_user_fk; Type: FK CONSTRAINT; Schema: users; Owner: postgres
--

ALTER TABLE ONLY users.peran_user
    ADD CONSTRAINT peran_user_fk FOREIGN KEY (id_person) REFERENCES users.person(id_person);


--
-- TOC entry 2790 (class 2606 OID 19145)
-- Name: peran_user peran_user_fk_1; Type: FK CONSTRAINT; Schema: users; Owner: postgres
--

ALTER TABLE ONLY users.peran_user
    ADD CONSTRAINT peran_user_fk_1 FOREIGN KEY (id_peran) REFERENCES users.peran(id_peran);


-- Completed on 2021-11-01 01:24:11

--
-- PostgreSQL database dump complete
--

