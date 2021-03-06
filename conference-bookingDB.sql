PGDMP          !                z            conference_booking    12.6    12.6     /           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            0           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            1           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            2           1262    26486    conference_booking    DATABASE     ?   CREATE DATABASE conference_booking WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
 "   DROP DATABASE conference_booking;
                postgres    false                        2615    26497 "   "db/migration/R_update_events.sql"    SCHEMA     6   CREATE SCHEMA """db/migration/R_update_events.sql""";
 4   DROP SCHEMA """db/migration/R_update_events.sql""";
                postgres    false            ?            1259    26498    flyway_schema_history    TABLE     ?  CREATE TABLE """db/migration/R_update_events.sql""".flyway_schema_history (
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
    "   "db/migration/R_update_events.sql"         heap    postgres    false    8            ?            1259    26579    events    TABLE     ?   CREATE TABLE public.events (
    id bigint NOT NULL,
    amount_people integer NOT NULL,
    date_finish timestamp without time zone,
    date_start timestamp without time zone,
    name character varying(255),
    status character varying(255)
);
    DROP TABLE public.events;
       public         heap    postgres    false            ?            1259    26487    flyway_schema_history    TABLE     ?  CREATE TABLE public.flyway_schema_history (
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
       public         heap    postgres    false            ?            1259    26577    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?            1259    26614    persistent_logins    TABLE     ?   CREATE TABLE public.persistent_logins (
    username character varying(64) NOT NULL,
    series character varying(64) NOT NULL,
    token character varying(64) NOT NULL,
    last_used timestamp without time zone NOT NULL
);
 %   DROP TABLE public.persistent_logins;
       public         heap    postgres    false            ?            1259    26619    users    TABLE       CREATE TABLE public.users (
    id bigint NOT NULL,
    first_name character varying(255),
    hash_password character varying(255),
    last_name character varying(255),
    login character varying(255),
    role character varying(255),
    state character varying(255)
);
    DROP TABLE public.users;
       public         heap    postgres    false            ?            1259    26600    users_events    TABLE     b   CREATE TABLE public.users_events (
    users_id bigint NOT NULL,
    events_id bigint NOT NULL
);
     DROP TABLE public.users_events;
       public         heap    postgres    false            '          0    26498    flyway_schema_history 
   TABLE DATA           ?   COPY """db/migration/R_update_events.sql""".flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
 "   "db/migration/R_update_events.sql"          postgres    false    204   %       )          0    26579    events 
   TABLE DATA           Z   COPY public.events (id, amount_people, date_finish, date_start, name, status) FROM stdin;
    public          postgres    false    206   ?%       &          0    26487    flyway_schema_history 
   TABLE DATA           ?   COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
    public          postgres    false    203   r'       +          0    26614    persistent_logins 
   TABLE DATA           O   COPY public.persistent_logins (username, series, token, last_used) FROM stdin;
    public          postgres    false    208   ?(       ,          0    26619    users 
   TABLE DATA           ]   COPY public.users (id, first_name, hash_password, last_name, login, role, state) FROM stdin;
    public          postgres    false    209   ?(       *          0    26600    users_events 
   TABLE DATA           ;   COPY public.users_events (users_id, events_id) FROM stdin;
    public          postgres    false    207   ?)       3           0    0    hibernate_sequence    SEQUENCE SET     B   SELECT pg_catalog.setval('public.hibernate_sequence', 157, true);
          public          postgres    false    205            ?
           2606    26531 .   flyway_schema_history flyway_schema_history_pk 
   CONSTRAINT     ?   ALTER TABLE ONLY """db/migration/R_update_events.sql""".flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);
 x   ALTER TABLE ONLY """db/migration/R_update_events.sql""".flyway_schema_history DROP CONSTRAINT flyway_schema_history_pk;
    "   "db/migration/R_update_events.sql"            postgres    false    204            ?
           2606    26586    events events_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.events
    ADD CONSTRAINT events_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.events DROP CONSTRAINT events_pkey;
       public            postgres    false    206            ?
           2606    26495 .   flyway_schema_history flyway_schema_history_pk 
   CONSTRAINT     x   ALTER TABLE ONLY public.flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);
 X   ALTER TABLE ONLY public.flyway_schema_history DROP CONSTRAINT flyway_schema_history_pk;
       public            postgres    false    203            ?
           2606    26618 (   persistent_logins persistent_logins_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.persistent_logins
    ADD CONSTRAINT persistent_logins_pkey PRIMARY KEY (series);
 R   ALTER TABLE ONLY public.persistent_logins DROP CONSTRAINT persistent_logins_pkey;
       public            postgres    false    208            ?
           2606    26626    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    209            ?
           1259    26540    flyway_schema_history_s_idx    INDEX     ?   CREATE INDEX flyway_schema_history_s_idx ON """db/migration/R_update_events.sql""".flyway_schema_history USING btree (success);
 O   DROP INDEX """db/migration/R_update_events.sql""".flyway_schema_history_s_idx;
    "   "db/migration/R_update_events.sql"            postgres    false    204            ?
           1259    26496    flyway_schema_history_s_idx    INDEX     `   CREATE INDEX flyway_schema_history_s_idx ON public.flyway_schema_history USING btree (success);
 /   DROP INDEX public.flyway_schema_history_s_idx;
       public            postgres    false    203            ?
           2606    26603 (   users_events fk56qu3rya56tll071qq9emrfwn    FK CONSTRAINT     ?   ALTER TABLE ONLY public.users_events
    ADD CONSTRAINT fk56qu3rya56tll071qq9emrfwn FOREIGN KEY (events_id) REFERENCES public.events(id);
 R   ALTER TABLE ONLY public.users_events DROP CONSTRAINT fk56qu3rya56tll071qq9emrfwn;
       public          postgres    false    2721    206    207            ?
           2606    26627 (   users_events fk7ycpyp61jrg0dxos7vfd30t1h    FK CONSTRAINT     ?   ALTER TABLE ONLY public.users_events
    ADD CONSTRAINT fk7ycpyp61jrg0dxos7vfd30t1h FOREIGN KEY (users_id) REFERENCES public.users(id);
 R   ALTER TABLE ONLY public.users_events DROP CONSTRAINT fk7ycpyp61jrg0dxos7vfd30t1h;
       public          postgres    false    209    207    2725            '   {   x???=
?0 ????@???K?3???? \D[=?Bg?o??=??˹ס???78vp,eòah?<	???Hay?~}??????Č?'% ??䏟t?dQ?׮??&MS?o???6q6!      )   ?  x?m??N?0E??W??x???l*AYP????>R???IlO?J^]?ܱg??E4???	??J 
??4?F?=n?J??by9[-??8??[?	?`?V??ëOY4?{x?_? ?"???C??????,!y???d??@?b?h?????p??y????Ͱ?s????=?|?/h4ܛ??e???V???8????nt?w??????pyf?
j?????J?K?p1a&??h??o?,?*?wk?[?S=?㹃??????????N?ĕ¸j?3?~3=?2?2OJÑ5??yA???Ӭc5R?0f??lL?Oc6?'Q?=?,???2'?Grj?ҵ??????E{؍E? &c??$??#??"!Ya?Gy{?V+?}]?z??Q>?r¼c?1?i݉^߾˯?*^??B"ڼ???-?f'???A|???y????]F8      &   :  x??ӽN1?9???3??	??*?*8? Zz?O??DYJ?d??????as????e????c????]xǵ8??8???(?&??????a?? 20??Es!???9,?\? ~?: ??
pc	%?ʦ???ajnu?G?Gǵ:??in ?Fx?c?Z????!U???z??'?????X?,m?,I?,?? [?"E zvu??A?rn<-?=2??K?XO???{??P(G3?)??#?çs??G+Z[`d??????5????'.?3?&؎???n. ????q??y???T\
YTs?z?????u?F??      +      x?????? ? ?      ,   ?   x?3??0??֋6]쾰?S?(Q??H?Ų?[?ӭ?????R?(33<?8E/?/$?%;2=X?8?4??-? *=?\???լ?ͫdҾ??^??YZ?Z????????e???YT\???????&4-?4;?$81????'?(??<?5?0#Q/?27ī2Ҭ(??(??#8?3ͬ?+??(??'nN"?tt????Y???? l?J.      *   2   x???  ?7ƤE4???s|.'KA?? ?ܷ?i?? K?>??!e?     