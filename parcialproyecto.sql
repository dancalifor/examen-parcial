PGDMP     %    !                {            parcialproyecto #   14.9 (Ubuntu 14.9-0ubuntu0.22.04.1) #   14.9 (Ubuntu 14.9-0ubuntu0.22.04.1) !    f           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            g           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            h           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            i           1262    16754    parcialproyecto    DATABASE     d   CREATE DATABASE parcialproyecto WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'es_PY.UTF-8';
    DROP DATABASE parcialproyecto;
                prueba    false            �            1259    16796    ciudad    TABLE     �   CREATE TABLE public.ciudad (
    id integer NOT NULL,
    ciudad character varying(30) NOT NULL,
    departamento character varying(30) NOT NULL,
    postal integer NOT NULL
);
    DROP TABLE public.ciudad;
       public         heap    prueba    false            �            1259    16795    ciudad_id_seq    SEQUENCE     �   CREATE SEQUENCE public.ciudad_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.ciudad_id_seq;
       public          prueba    false    215            j           0    0    ciudad_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.ciudad_id_seq OWNED BY public.ciudad.id;
          public          prueba    false    214            �            1259    16766    cliente    TABLE     �   CREATE TABLE public.cliente (
    idpersona integer,
    fechaingreso date,
    calificacion character varying(30),
    estado character varying(30),
    id integer NOT NULL
);
    DROP TABLE public.cliente;
       public         heap    prueba    false            �            1259    16806    cliente_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cliente_id_seq;
       public          prueba    false    210            k           0    0    cliente_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;
          public          prueba    false    216            �            1259    16773    cuentas    TABLE     w  CREATE TABLE public.cuentas (
    id integer NOT NULL,
    idcliente integer,
    nrocuenta character varying(30),
    fechaalta date,
    tipocuenta character varying(30),
    estado character varying(30),
    saldo real,
    nrocontrato character varying(30),
    costomantenimiento real,
    promedioacreditacion character varying(30),
    moneda character varying(30)
);
    DROP TABLE public.cuentas;
       public         heap    prueba    false            �            1259    16772    cuentas_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cuentas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cuentas_id_seq;
       public          prueba    false    212            l           0    0    cuentas_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.cuentas_id_seq OWNED BY public.cuentas.id;
          public          prueba    false    211            �            1259    16779    movimientos    TABLE     $  CREATE TABLE public.movimientos (
    idmovimiento integer NOT NULL,
    idcuenta integer,
    fechamovimiento date,
    tipomovimiento character varying,
    saldoanterior real,
    saldoactual real,
    montomovimiento real,
    cuentaorigen real,
    cuentadestino real,
    canal real
);
    DROP TABLE public.movimientos;
       public         heap    prueba    false            �            1259    16813    persona_id_seq    SEQUENCE     w   CREATE SEQUENCE public.persona_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.persona_id_seq;
       public          prueba    false            �            1259    16760    persona    TABLE     �  CREATE TABLE public.persona (
    id integer DEFAULT nextval('public.persona_id_seq'::regclass) NOT NULL,
    idciudad integer,
    nombre character varying(30),
    apellido character varying(30),
    tipodocumento character varying(30),
    nrodocumento character varying(30),
    direccion character varying(100),
    email character varying(100),
    celular character varying(30),
    estado character varying(30)
);
    DROP TABLE public.persona;
       public         heap    prueba    false    217            �           2604    16799 	   ciudad id    DEFAULT     f   ALTER TABLE ONLY public.ciudad ALTER COLUMN id SET DEFAULT nextval('public.ciudad_id_seq'::regclass);
 8   ALTER TABLE public.ciudad ALTER COLUMN id DROP DEFAULT;
       public          prueba    false    214    215    215            �           2604    16807 
   cliente id    DEFAULT     h   ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);
 9   ALTER TABLE public.cliente ALTER COLUMN id DROP DEFAULT;
       public          prueba    false    216    210            �           2604    16776 
   cuentas id    DEFAULT     h   ALTER TABLE ONLY public.cuentas ALTER COLUMN id SET DEFAULT nextval('public.cuentas_id_seq'::regclass);
 9   ALTER TABLE public.cuentas ALTER COLUMN id DROP DEFAULT;
       public          prueba    false    211    212    212            a          0    16796    ciudad 
   TABLE DATA           B   COPY public.ciudad (id, ciudad, departamento, postal) FROM stdin;
    public          prueba    false    215   _%       \          0    16766    cliente 
   TABLE DATA           T   COPY public.cliente (idpersona, fechaingreso, calificacion, estado, id) FROM stdin;
    public          prueba    false    210   �%       ^          0    16773    cuentas 
   TABLE DATA           �   COPY public.cuentas (id, idcliente, nrocuenta, fechaalta, tipocuenta, estado, saldo, nrocontrato, costomantenimiento, promedioacreditacion, moneda) FROM stdin;
    public          prueba    false    212   �%       _          0    16779    movimientos 
   TABLE DATA           �   COPY public.movimientos (idmovimiento, idcuenta, fechamovimiento, tipomovimiento, saldoanterior, saldoactual, montomovimiento, cuentaorigen, cuentadestino, canal) FROM stdin;
    public          prueba    false    213   A&       [          0    16760    persona 
   TABLE DATA           �   COPY public.persona (id, idciudad, nombre, apellido, tipodocumento, nrodocumento, direccion, email, celular, estado) FROM stdin;
    public          prueba    false    209   ^&       m           0    0    ciudad_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.ciudad_id_seq', 9, true);
          public          prueba    false    214            n           0    0    cliente_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.cliente_id_seq', 4, true);
          public          prueba    false    216            o           0    0    cuentas_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.cuentas_id_seq', 3, true);
          public          prueba    false    211            p           0    0    persona_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.persona_id_seq', 1, true);
          public          prueba    false    217            �           2606    16801    ciudad ciudad_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT ciudad_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.ciudad DROP CONSTRAINT ciudad_pkey;
       public            prueba    false    215            �           2606    16812    cliente cliente_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            prueba    false    210            �           2606    16778    cuentas cuentas_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cuentas
    ADD CONSTRAINT cuentas_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cuentas DROP CONSTRAINT cuentas_pkey;
       public            prueba    false    212            �           2606    16785    movimientos movimientos_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT movimientos_pkey PRIMARY KEY (idmovimiento);
 F   ALTER TABLE ONLY public.movimientos DROP CONSTRAINT movimientos_pkey;
       public            prueba    false    213            �           2606    16764    persona persona_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_pkey;
       public            prueba    false    209            a   @   x�3��)-,M�tv�	r��433�2�"f�Ěӳ$�4�4.jdnb�e�]���%v�=... ��'�      \   1   x�3�4202�5��52�42�tL.�,��4�2�.a�K���	W� }��      ^   A   x�3�42�4426153�4202�5��52�t��+IL����KL.�,���CF\Fd�3&S_� ��)�      _      x������ � �      [      x�3�41��Ê�b���� |��     