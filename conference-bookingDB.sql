PGDMP     :    
                z            conference_booking    12.6    12.6     6           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            7           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            8           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            9           1262    26486    conference_booking    DATABASE     �   CREATE DATABASE conference_booking WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
 "   DROP DATABASE conference_booking;
                postgres    false                        2615    26497 "   "db/migration/R_update_events.sql"    SCHEMA     6   CREATE SCHEMA """db/migration/R_update_events.sql""";
 4   DROP SCHEMA """db/migration/R_update_events.sql""";
                postgres    false            �            1259    26498    flyway_schema_history    TABLE     �  CREATE TABLE """db/migration/R_update_events.sql""".flyway_schema_history (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);
 I   DROP TABLE """db/migration/R_update_events.sql""".flyway_schema_history;
    "   "db/migration/R_update_events.sql"         heap    postgres    false    8            �            1259    26642    day_week    TABLE     L   CREATE TABLE public.day_week (
    id bigint NOT NULL,
    day_week date
);
    DROP TABLE public.day_week;
       public         heap    postgres    false            �            1259    26579    events    TABLE     �   CREATE TABLE public.events (
    id bigint NOT NULL,
    amount_people integer NOT NULL,
    date_finish timestamp without time zone,
    date_start timestamp without time zone,
    name character varying(255),
    status character varying(255)
);
    DROP TABLE public.events;
       public         heap    postgres    false            �            1259    26487    flyway_schema_history    TABLE     �  CREATE TABLE public.flyway_schema_history (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);
 )   DROP TABLE public.flyway_schema_history;
       public         heap    postgres    false            �            1259    26577    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    26614    persistent_logins    TABLE     �   CREATE TABLE public.persistent_logins (
    username character varying(64) NOT NULL,
    series character varying(64) NOT NULL,
    token character varying(64) NOT NULL,
    last_used timestamp without time zone NOT NULL
);
 %   DROP TABLE public.persistent_logins;
       public         heap    postgres    false            �            1259    26619    users    TABLE       CREATE TABLE public.users (
    id bigint NOT NULL,
    first_name character varying(255),
    hash_password character varying(255),
    last_name character varying(255),
    login character varying(255),
    role character varying(255),
    state character varying(255)
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    26600    users_events    TABLE     b   CREATE TABLE public.users_events (
    users_id bigint NOT NULL,
    events_id bigint NOT NULL
);
     DROP TABLE public.users_events;
       public         heap    postgres    false            -          0    26498    flyway_schema_history 
   TABLE DATA           �   COPY """db/migration/R_update_events.sql""".flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
 "   "db/migration/R_update_events.sql"          postgres    false    204   �'       3          0    26642    day_week 
   TABLE DATA           0   COPY public.day_week (id, day_week) FROM stdin;
    public          postgres    false    210   n(       /          0    26579    events 
   TABLE DATA           Z   COPY public.events (id, amount_people, date_finish, date_start, name, status) FROM stdin;
    public          postgres    false    206   �(       ,          0    26487    flyway_schema_history 
   TABLE DATA           �   COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
    public          postgres    false    203   *       1          0    26614    persistent_logins 
   TABLE DATA           O   COPY public.persistent_logins (username, series, token, last_used) FROM stdin;
    public          postgres    false    208   V+       2          0    26619    users 
   TABLE DATA           ]   COPY public.users (id, first_name, hash_password, last_name, login, role, state) FROM stdin;
    public          postgres    false    209   �+       0          0    26600    users_events 
   TABLE DATA           ;   COPY public.users_events (users_id, events_id) FROM stdin;
    public          postgres    false    207   �,       :           0    0    hibernate_sequence    SEQUENCE SET     B   SELECT pg_catalog.setval('public.hibernate_sequence', 152, true);
          public          postgres    false    205            �
           2606    26531 .   flyway_schema_history flyway_schema_history_pk 
   CONSTRAINT     �   ALTER TABLE ONLY """db/migration/R_update_events.sql""".flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);
 x   ALTER TABLE ONLY """db/migration/R_update_events.sql""".flyway_schema_history DROP CONSTRAINT flyway_schema_history_pk;
    "   "db/migration/R_update_events.sql"            postgres    false    204            �
           2606    26646    day_week day_week_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.day_week
    ADD CONSTRAINT day_week_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.day_week DROP CONSTRAINT day_week_pkey;
       public            postgres    false    210            �
           2606    26586    events events_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.events
    ADD CONSTRAINT events_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.events DROP CONSTRAINT events_pkey;
       public            postgres    false    206            �
           2606    26495 .   flyway_schema_history flyway_schema_history_pk 
   CONSTRAINT     x   ALTER TABLE ONLY public.flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);
 X   ALTER TABLE ONLY public.flyway_schema_history DROP CONSTRAINT flyway_schema_history_pk;
       public            postgres    false    203            �
           2606    26618 (   persistent_logins persistent_logins_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.persistent_logins
    ADD CONSTRAINT persistent_logins_pkey PRIMARY KEY (series);
 R   ALTER TABLE ONLY public.persistent_logins DROP CONSTRAINT persistent_logins_pkey;
       public            postgres    false    208            �
           2606    26626    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    209            �
           1259    26540    flyway_schema_history_s_idx    INDEX     �   CREATE INDEX flyway_schema_history_s_idx ON """db/migration/R_update_events.sql""".flyway_schema_history USING btree (success);
 O   DROP INDEX """db/migration/R_update_events.sql""".flyway_schema_history_s_idx;
    "   "db/migration/R_update_events.sql"            postgres    false    204            �
           1259    26496    flyway_schema_history_s_idx    INDEX     `   CREATE INDEX flyway_schema_history_s_idx ON public.flyway_schema_history USING btree (success);
 /   DROP INDEX public.flyway_schema_history_s_idx;
       public            postgres    false    203            �
           2606    26603 (   users_events fk56qu3rya56tll071qq9emrfwn    FK CONSTRAINT     �   ALTER TABLE ONLY public.users_events
    ADD CONSTRAINT fk56qu3rya56tll071qq9emrfwn FOREIGN KEY (events_id) REFERENCES public.events(id);
 R   ALTER TABLE ONLY public.users_events DROP CONSTRAINT fk56qu3rya56tll071qq9emrfwn;
       public          postgres    false    2725    207    206            �
           2606    26627 (   users_events fk7ycpyp61jrg0dxos7vfd30t1h    FK CONSTRAINT     �   ALTER TABLE ONLY public.users_events
    ADD CONSTRAINT fk7ycpyp61jrg0dxos7vfd30t1h FOREIGN KEY (users_id) REFERENCES public.users(id);
 R   ALTER TABLE ONLY public.users_events DROP CONSTRAINT fk7ycpyp61jrg0dxos7vfd30t1h;
       public          postgres    false    209    2729    207            -   {   x���=
�0 ����@���K�3���� \D[=�Bg�o��=��˹ס��78vp,eòah�<	���Hay�~}������Č�'% ��䏟t�dQ�׮��&MS�o?��6q6!      3      x�3�4202�50�52����� =�      /   v  x�m��N�0D��W��x�Nl��P	�ʁ�\��!$��R���i�7�r��ػ�8-@�D\�j�.���{���6���T(��ޮw�}� u(s(�C�i��Q�B�z�K�R�E�1��8hCa| s�4\��DܟO�cS�6�i	�+j�gn�Ǜl�/�C��C�"}��8�A��l?D����,��i����{�D�h���8(�L2Gxc#^.�.\5��ßX?���w��$�8#�n�\|p����L+f�é#L�n&�M�"n)n�餸gq�K�/sD��N��:�@�����ǾlD
^��fCQ뷀)�M����i��Z����u�s�����P�q1F2xj���k1�`9����$�
��2˲��      ,   (  x���MN�@�s�\ #�Ό�	�XU�*�� Z����!]QX�n����l��-|����O���2���܏�:�a��_a a��")��r�f`dP���X.��Q	H`�t���ڀ�S,(�MĤR�l
O�������4�8�ӱMϹ5'�K�jj+�hP�Xy���u��,�S�VFcӶ���F㋶�jm�������|en:Q<���G�,���$���{�bX8��,�D�'��ϗ>[O�X]AA,{��ͧkj�K�R�ff�Ԟ��t{n����>9b���]��UB�      1   \   x�KL�����
(�L�r��LN3�4L*��L���L2ɫt-H,I573�v�3r+OJ���Y(YXZ�Z�Xs��qqq �
�      2   �   x�3�0��֋6]쾰�S�(Q��H�Ų�[?ӭ�����R�(33<�8E/�/$�%;2=X�8�4��-� *=�\���լ�ͫdҾ��^��YZ�Z��������e��YT\�������&4-�4;�$81����'�(��<?5�0#Q/�27ī2Ҭ(?�(��#8�3ͬ�+��(��'nN"�tt���Y���� l�J.      0   )   x�3�4�2�4�� ���9�42�2�445����� o�~     