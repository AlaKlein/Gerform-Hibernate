PGDMP     .    (                z            gerform    12.10    14.1 X    ~           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16393    gerform    DATABASE     g   CREATE DATABASE gerform WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE gerform;
                postgres    false            �            1255    16560 )   show_material(character varying, boolean)    FUNCTION     �  CREATE FUNCTION public.show_material(criterio character varying, ativo boolean) RETURNS TABLE(id integer, descricao character varying, precokg numeric, status character varying, tipo_material character varying, razao_social character varying)
    LANGUAGE plpgsql
    AS $$

    BEGIN 
	IF (ativo=true) THEN
        RETURN QUERY
        	SELECT m.id, m.descricao, m.precokg, m.status, t.descricao as tipo_material, a.razao_social
			FROM material m JOIN tipo_material t ON m.tipo_material_id=t.id
			JOIN fornecedor a ON m.fornecedor_id=a.id
			WHERE m.descricao ILIKE '%'||criterio||'%' AND m.status <> 'Excluído'
			ORDER BY m.id;
	ELSE 
		RETURN QUERY
        	SELECT m.id, m.descricao, m.precokg, m.status, t.descricao as tipo_material, a.razao_social
			FROM material m JOIN tipo_material t ON m.tipo_material_id=t.id
			JOIN fornecedor a ON m.fornecedor_id=a.id
			WHERE m.descricao ILIKE '%'||criterio||'%' AND m.status='Ativo'
			ORDER BY m.id;
			
	END IF;

    END;
$$;
 O   DROP FUNCTION public.show_material(criterio character varying, ativo boolean);
       public          postgres    false            �            1255    16559 -   show_propriedades(character varying, boolean)    FUNCTION     �  CREATE FUNCTION public.show_propriedades(criterio character varying, ativo boolean) RETURNS TABLE(id integer, descricao character varying, umidade numeric, gordura numeric, proteina numeric, email character varying, status character varying)
    LANGUAGE plpgsql
    AS $$

    BEGIN 
	IF (ativo=true) THEN
        RETURN QUERY
        SELECT pm.id, m.descricao, pm.umidade, pm.gordura, pm.proteina, u.email, pm.status 
		FROM Propriedades_material pm INNER JOIN Material m ON m.id = pm.material_id 
		INNER JOIN Usuario u ON u.id=pm.usuario_id WHERE m.descricao ILIKE '%'||criterio||'%' 
	 	ORDER BY pm.id;
	ELSE 
		RETURN QUERY
        	SELECT pm.id, m.descricao, pm.umidade, pm.gordura, pm.proteina, u.email, pm.status 
			FROM Propriedades_material pm INNER JOIN Material m ON m.id = pm.material_id 
			INNER JOIN Usuario u ON u.id=pm.usuario_id WHERE m.descricao ILIKE '%'||criterio||'%' 
	 		AND pm.status='Ativo' ORDER BY pm.id;
			
	END IF;

    END;
$$;
 S   DROP FUNCTION public.show_propriedades(criterio character varying, ativo boolean);
       public          postgres    false            �            1255    16561    status_propriedades()    FUNCTION     �   CREATE FUNCTION public.status_propriedades() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
UPDATE propriedades_material
SET status=NEW.status
WHERE material_id=NEW.id;
RETURN NULL;
END;
$$;
 ,   DROP FUNCTION public.status_propriedades();
       public          postgres    false            �            1259    16546 	   auditoria    TABLE     �   CREATE TABLE public.auditoria (
    id integer NOT NULL,
    usuario_id integer NOT NULL,
    tabela character varying(255) NOT NULL,
    data timestamp without time zone NOT NULL,
    acao character varying(255) NOT NULL
);
    DROP TABLE public.auditoria;
       public         heap    postgres    false            �            1259    16544    auditoria_id_seq    SEQUENCE     �   CREATE SEQUENCE public.auditoria_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.auditoria_id_seq;
       public          postgres    false    220            �           0    0    auditoria_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.auditoria_id_seq OWNED BY public.auditoria.id;
          public          postgres    false    219            �            1259    16394 
   formulacao    TABLE     �   CREATE TABLE public.formulacao (
    produto_id integer NOT NULL,
    data timestamp without time zone,
    ver integer NOT NULL,
    custo_elaborado numeric(9,2) NOT NULL,
    usuario_id integer NOT NULL,
    id integer NOT NULL
);
    DROP TABLE public.formulacao;
       public         heap    postgres    false            �            1259    24751    formulacao_id_seq    SEQUENCE     �   CREATE SEQUENCE public.formulacao_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.formulacao_id_seq;
       public          postgres    false    202            �           0    0    formulacao_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.formulacao_id_seq OWNED BY public.formulacao.id;
          public          postgres    false    222            �            1259    16397 
   fornecedor    TABLE       CREATE TABLE public.fornecedor (
    id integer NOT NULL,
    razao_social character varying(255) NOT NULL,
    cnpj character varying(18) NOT NULL,
    telefone character varying(15) NOT NULL,
    endereco character varying(255) NOT NULL,
    status character varying(255) NOT NULL
);
    DROP TABLE public.fornecedor;
       public         heap    postgres    false            �            1259    16403    fornecedor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.fornecedor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.fornecedor_id_seq;
       public          postgres    false    203            �           0    0    fornecedor_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.fornecedor_id_seq OWNED BY public.fornecedor.id;
          public          postgres    false    204            �            1259    16405    item_formulacao    TABLE     �  CREATE TABLE public.item_formulacao (
    id integer NOT NULL,
    percentual numeric(9,2) NOT NULL,
    kg numeric(9,2) NOT NULL,
    precokg numeric(9,2) NOT NULL,
    precokgprod numeric(9,2) NOT NULL,
    umidade numeric(9,2) NOT NULL,
    gordura numeric(9,2) NOT NULL,
    proteina numeric(9,2) NOT NULL,
    material_id integer NOT NULL,
    formulacao_produto_id integer NOT NULL,
    formulacao_ver integer NOT NULL
);
 #   DROP TABLE public.item_formulacao;
       public         heap    postgres    false            �            1259    16408    item_formulacao_id_seq    SEQUENCE     �   CREATE SEQUENCE public.item_formulacao_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.item_formulacao_id_seq;
       public          postgres    false    205            �           0    0    item_formulacao_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.item_formulacao_id_seq OWNED BY public.item_formulacao.id;
          public          postgres    false    206            �            1259    16410    material    TABLE     .  CREATE TABLE public.material (
    id integer NOT NULL,
    descricao character varying(2555) NOT NULL,
    precokg numeric(9,2) NOT NULL,
    tipo_material_id integer NOT NULL,
    fornecedor_id integer NOT NULL,
    status character varying(10) NOT NULL,
    tempropriedades character(1) NOT NULL
);
    DROP TABLE public.material;
       public         heap    postgres    false            �            1259    16416    material_id_seq    SEQUENCE     �   CREATE SEQUENCE public.material_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.material_id_seq;
       public          postgres    false    207            �           0    0    material_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.material_id_seq OWNED BY public.material.id;
          public          postgres    false    208            �            1259    16418    produto    TABLE     �   CREATE TABLE public.produto (
    id integer NOT NULL,
    descricao character varying(255) NOT NULL,
    tipo_produto_id integer NOT NULL,
    tem_formulacao character varying(1) NOT NULL,
    status character varying(10) NOT NULL
);
    DROP TABLE public.produto;
       public         heap    postgres    false            �            1259    16421    produto_id_seq    SEQUENCE     �   CREATE SEQUENCE public.produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.produto_id_seq;
       public          postgres    false    209            �           0    0    produto_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id;
          public          postgres    false    210            �            1259    16423    propriedades_material    TABLE     �   CREATE TABLE public.propriedades_material (
    id integer NOT NULL,
    usuario_id integer NOT NULL,
    material_id integer NOT NULL,
    umidade numeric(9,2),
    gordura numeric(9,2),
    proteina numeric(9,2),
    status character varying(255)
);
 )   DROP TABLE public.propriedades_material;
       public         heap    postgres    false            �            1259    16426    propriedades_material_id_seq    SEQUENCE     �   CREATE SEQUENCE public.propriedades_material_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.propriedades_material_id_seq;
       public          postgres    false    211            �           0    0    propriedades_material_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.propriedades_material_id_seq OWNED BY public.propriedades_material.id;
          public          postgres    false    212            �            1259    16428    tipo_material    TABLE     �   CREATE TABLE public.tipo_material (
    id integer NOT NULL,
    descricao character varying(255) NOT NULL,
    status character varying(255) NOT NULL
);
 !   DROP TABLE public.tipo_material;
       public         heap    postgres    false            �            1259    16434    tipo_material_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_material_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.tipo_material_id_seq;
       public          postgres    false    213            �           0    0    tipo_material_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.tipo_material_id_seq OWNED BY public.tipo_material.id;
          public          postgres    false    214            �            1259    16436    tipo_produto    TABLE     d   CREATE TABLE public.tipo_produto (
    id integer NOT NULL,
    descricao character varying(255)
);
     DROP TABLE public.tipo_produto;
       public         heap    postgres    false            �            1259    16439    tipo_produto_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.tipo_produto_id_seq;
       public          postgres    false    215            �           0    0    tipo_produto_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.tipo_produto_id_seq OWNED BY public.tipo_produto.id;
          public          postgres    false    216            �            1259    16441    usuario    TABLE     �   CREATE TABLE public.usuario (
    id integer NOT NULL,
    email character varying(255) NOT NULL,
    permissao character varying(255) NOT NULL,
    senha character varying(255) NOT NULL,
    status character varying(255)
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    16447    usuario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.usuario_id_seq;
       public          postgres    false    217            �           0    0    usuario_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;
          public          postgres    false    218            �            1259    16555    vw_auditoria    VIEW     �   CREATE VIEW public.vw_auditoria AS
 SELECT a.id,
    u.email,
    a.tabela,
    a.data,
    a.acao
   FROM public.auditoria a,
    public.usuario u
  WHERE (a.usuario_id = u.id)
  ORDER BY a.id;
    DROP VIEW public.vw_auditoria;
       public          postgres    false    217    217    220    220    220    220    220            �
           2604    16549    auditoria id    DEFAULT     l   ALTER TABLE ONLY public.auditoria ALTER COLUMN id SET DEFAULT nextval('public.auditoria_id_seq'::regclass);
 ;   ALTER TABLE public.auditoria ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    219    220            �
           2604    24753    formulacao id    DEFAULT     n   ALTER TABLE ONLY public.formulacao ALTER COLUMN id SET DEFAULT nextval('public.formulacao_id_seq'::regclass);
 <   ALTER TABLE public.formulacao ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    202            �
           2604    16449    fornecedor id    DEFAULT     n   ALTER TABLE ONLY public.fornecedor ALTER COLUMN id SET DEFAULT nextval('public.fornecedor_id_seq'::regclass);
 <   ALTER TABLE public.fornecedor ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    204    203            �
           2604    16450    item_formulacao id    DEFAULT     x   ALTER TABLE ONLY public.item_formulacao ALTER COLUMN id SET DEFAULT nextval('public.item_formulacao_id_seq'::regclass);
 A   ALTER TABLE public.item_formulacao ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    205            �
           2604    16451    material id    DEFAULT     j   ALTER TABLE ONLY public.material ALTER COLUMN id SET DEFAULT nextval('public.material_id_seq'::regclass);
 :   ALTER TABLE public.material ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    208    207            �
           2604    16452 
   produto id    DEFAULT     h   ALTER TABLE ONLY public.produto ALTER COLUMN id SET DEFAULT nextval('public.produto_id_seq'::regclass);
 9   ALTER TABLE public.produto ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    209            �
           2604    16453    propriedades_material id    DEFAULT     �   ALTER TABLE ONLY public.propriedades_material ALTER COLUMN id SET DEFAULT nextval('public.propriedades_material_id_seq'::regclass);
 G   ALTER TABLE public.propriedades_material ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    211            �
           2604    16454    tipo_material id    DEFAULT     t   ALTER TABLE ONLY public.tipo_material ALTER COLUMN id SET DEFAULT nextval('public.tipo_material_id_seq'::regclass);
 ?   ALTER TABLE public.tipo_material ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    213            �
           2604    16455    tipo_produto id    DEFAULT     r   ALTER TABLE ONLY public.tipo_produto ALTER COLUMN id SET DEFAULT nextval('public.tipo_produto_id_seq'::regclass);
 >   ALTER TABLE public.tipo_produto ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215            �
           2604    16456 
   usuario id    DEFAULT     h   ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);
 9   ALTER TABLE public.usuario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217            z          0    16546 	   auditoria 
   TABLE DATA           G   COPY public.auditoria (id, usuario_id, tabela, data, acao) FROM stdin;
    public          postgres    false    220   mq       h          0    16394 
   formulacao 
   TABLE DATA           \   COPY public.formulacao (produto_id, data, ver, custo_elaborado, usuario_id, id) FROM stdin;
    public          postgres    false    202   \�       i          0    16397 
   fornecedor 
   TABLE DATA           X   COPY public.fornecedor (id, razao_social, cnpj, telefone, endereco, status) FROM stdin;
    public          postgres    false    203   ��       k          0    16405    item_formulacao 
   TABLE DATA           �   COPY public.item_formulacao (id, percentual, kg, precokg, precokgprod, umidade, gordura, proteina, material_id, formulacao_produto_id, formulacao_ver) FROM stdin;
    public          postgres    false    205   �       m          0    16410    material 
   TABLE DATA           t   COPY public.material (id, descricao, precokg, tipo_material_id, fornecedor_id, status, tempropriedades) FROM stdin;
    public          postgres    false    207   <�       o          0    16418    produto 
   TABLE DATA           Y   COPY public.produto (id, descricao, tipo_produto_id, tem_formulacao, status) FROM stdin;
    public          postgres    false    209   ݸ       q          0    16423    propriedades_material 
   TABLE DATA           p   COPY public.propriedades_material (id, usuario_id, material_id, umidade, gordura, proteina, status) FROM stdin;
    public          postgres    false    211   ��       s          0    16428    tipo_material 
   TABLE DATA           >   COPY public.tipo_material (id, descricao, status) FROM stdin;
    public          postgres    false    213   2�       u          0    16436    tipo_produto 
   TABLE DATA           5   COPY public.tipo_produto (id, descricao) FROM stdin;
    public          postgres    false    215   t�       w          0    16441    usuario 
   TABLE DATA           F   COPY public.usuario (id, email, permissao, senha, status) FROM stdin;
    public          postgres    false    217   ��       �           0    0    auditoria_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.auditoria_id_seq', 1578, true);
          public          postgres    false    219            �           0    0    formulacao_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.formulacao_id_seq', 139, true);
          public          postgres    false    222            �           0    0    fornecedor_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.fornecedor_id_seq', 16, true);
          public          postgres    false    204            �           0    0    item_formulacao_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.item_formulacao_id_seq', 294, true);
          public          postgres    false    206            �           0    0    material_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.material_id_seq', 51, true);
          public          postgres    false    208            �           0    0    produto_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.produto_id_seq', 22, true);
          public          postgres    false    210            �           0    0    propriedades_material_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.propriedades_material_id_seq', 42, true);
          public          postgres    false    212            �           0    0    tipo_material_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.tipo_material_id_seq', 2, true);
          public          postgres    false    214            �           0    0    tipo_produto_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.tipo_produto_id_seq', 2, true);
          public          postgres    false    216            �           0    0    usuario_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usuario_id_seq', 57, true);
          public          postgres    false    218            �
           2606    16554    auditoria auditoria_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.auditoria
    ADD CONSTRAINT auditoria_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.auditoria DROP CONSTRAINT auditoria_pkey;
       public            postgres    false    220            �
           2606    16458    formulacao formulacao_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.formulacao
    ADD CONSTRAINT formulacao_pkey PRIMARY KEY (produto_id, ver);
 D   ALTER TABLE ONLY public.formulacao DROP CONSTRAINT formulacao_pkey;
       public            postgres    false    202    202            �
           2606    16460    fornecedor fornecedor_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT fornecedor_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT fornecedor_pkey;
       public            postgres    false    203            �
           2606    16462 $   item_formulacao item_formulacao_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.item_formulacao
    ADD CONSTRAINT item_formulacao_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.item_formulacao DROP CONSTRAINT item_formulacao_pkey;
       public            postgres    false    205            �
           2606    16464    material material_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.material
    ADD CONSTRAINT material_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.material DROP CONSTRAINT material_pkey;
       public            postgres    false    207            �
           2606    16466    produto produto_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_pkey;
       public            postgres    false    209            �
           2606    16468 0   propriedades_material propriedades_material_pkey 
   CONSTRAINT     {   ALTER TABLE ONLY public.propriedades_material
    ADD CONSTRAINT propriedades_material_pkey PRIMARY KEY (id, material_id);
 Z   ALTER TABLE ONLY public.propriedades_material DROP CONSTRAINT propriedades_material_pkey;
       public            postgres    false    211    211            �
           2606    16470     tipo_material tipo_material_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tipo_material
    ADD CONSTRAINT tipo_material_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.tipo_material DROP CONSTRAINT tipo_material_pkey;
       public            postgres    false    213            �
           2606    16472    tipo_produto tipo_produto_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tipo_produto
    ADD CONSTRAINT tipo_produto_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.tipo_produto DROP CONSTRAINT tipo_produto_pkey;
       public            postgres    false    215            �
           2606    16474    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    217            �
           2620    16562 %   material status_propriedades_material    TRIGGER     �   CREATE TRIGGER status_propriedades_material AFTER UPDATE ON public.material FOR EACH ROW EXECUTE FUNCTION public.status_propriedades();
 >   DROP TRIGGER status_propriedades_material ON public.material;
       public          postgres    false    207    224            �
           2606    16475 !   formulacao fk_formulacao_produto1    FK CONSTRAINT     �   ALTER TABLE ONLY public.formulacao
    ADD CONSTRAINT fk_formulacao_produto1 FOREIGN KEY (produto_id) REFERENCES public.produto(id);
 K   ALTER TABLE ONLY public.formulacao DROP CONSTRAINT fk_formulacao_produto1;
       public          postgres    false    202    209    2772            �
           2606    16480     formulacao fk_formulacao_usuario    FK CONSTRAINT     �   ALTER TABLE ONLY public.formulacao
    ADD CONSTRAINT fk_formulacao_usuario FOREIGN KEY (usuario_id) REFERENCES public.usuario(id);
 J   ALTER TABLE ONLY public.formulacao DROP CONSTRAINT fk_formulacao_usuario;
       public          postgres    false    2780    202    217            �
           2606    16485 .   item_formulacao fk_item_formulacao_formulacao1    FK CONSTRAINT     �   ALTER TABLE ONLY public.item_formulacao
    ADD CONSTRAINT fk_item_formulacao_formulacao1 FOREIGN KEY (formulacao_produto_id, formulacao_ver) REFERENCES public.formulacao(produto_id, ver);
 X   ALTER TABLE ONLY public.item_formulacao DROP CONSTRAINT fk_item_formulacao_formulacao1;
       public          postgres    false    202    2764    202    205    205            �
           2606    16490 ,   item_formulacao fk_item_formulacao_material1    FK CONSTRAINT     �   ALTER TABLE ONLY public.item_formulacao
    ADD CONSTRAINT fk_item_formulacao_material1 FOREIGN KEY (material_id) REFERENCES public.material(id);
 V   ALTER TABLE ONLY public.item_formulacao DROP CONSTRAINT fk_item_formulacao_material1;
       public          postgres    false    205    2770    207            �
           2606    16495     material fk_material_fornecedor1    FK CONSTRAINT     �   ALTER TABLE ONLY public.material
    ADD CONSTRAINT fk_material_fornecedor1 FOREIGN KEY (fornecedor_id) REFERENCES public.fornecedor(id);
 J   ALTER TABLE ONLY public.material DROP CONSTRAINT fk_material_fornecedor1;
       public          postgres    false    2766    207    203            �
           2606    16500 #   material fk_material_tipo_material1    FK CONSTRAINT     �   ALTER TABLE ONLY public.material
    ADD CONSTRAINT fk_material_tipo_material1 FOREIGN KEY (tipo_material_id) REFERENCES public.tipo_material(id);
 M   ALTER TABLE ONLY public.material DROP CONSTRAINT fk_material_tipo_material1;
       public          postgres    false    213    2776    207            �
           2606    16505     produto fk_produto_tipo_produto1    FK CONSTRAINT     �   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT fk_produto_tipo_produto1 FOREIGN KEY (tipo_produto_id) REFERENCES public.tipo_produto(id);
 J   ALTER TABLE ONLY public.produto DROP CONSTRAINT fk_produto_tipo_produto1;
       public          postgres    false    209    2778    215            �
           2606    16510 8   propriedades_material fk_propriedades_material_material1    FK CONSTRAINT     �   ALTER TABLE ONLY public.propriedades_material
    ADD CONSTRAINT fk_propriedades_material_material1 FOREIGN KEY (material_id) REFERENCES public.material(id);
 b   ALTER TABLE ONLY public.propriedades_material DROP CONSTRAINT fk_propriedades_material_material1;
       public          postgres    false    2770    207    211            �
           2606    16515 7   propriedades_material fk_propriedades_material_usuario1    FK CONSTRAINT     �   ALTER TABLE ONLY public.propriedades_material
    ADD CONSTRAINT fk_propriedades_material_usuario1 FOREIGN KEY (usuario_id) REFERENCES public.usuario(id);
 a   ALTER TABLE ONLY public.propriedades_material DROP CONSTRAINT fk_propriedades_material_usuario1;
       public          postgres    false    217    2780    211            z      x��}ɮ,G��Z�
��6��^���� ��R�����6�f$�]�n��1w�����߿|���RH��0~��X>b�(����?��߿��c��?�]��Q�C�������Ǐ�G��؞��F9>j{zY}����Isnds�5|��̞7�[��S���7r��4>b|R<��"����p�=Z�G�O��@���=��5ń��?j~B`�)'���P���~4%u��?=���?������v�B�u=��_���oJl��G�qɖWV�D�p�O�'3����v�󤶰�#���ɓ���	O�g)$Oj	6W�7`(H���d|�����Mk#��}6�'��-�<!�����#�g�x���3ZтK���G�1<y��~��������o~�]a��9���`��������.3M��ٓc��k�/9�1�=9�Ɏ��WGv帰	h��|d�W�Z����ٕ$�s¥�?�ۅ����<K����zߏ:�0Ή�������|^gk�-(�f�Y��I�v߆������XR�е��3���bImCے�S�1�uft�̵vF>�Z��G�u��s0��Z�#sC����,Ym�ڥk�"π#�5�밬k�e�:�hY�S��,�����t^œV�C�!�jՓ����@��'�k��'��ՓV^g\�%�5P=ie���Y���U`�@������kֵ�����
�A�P⓺z�*����R
?�V�iM�2���
��uŗq�@󄵔� �\��������/�ւ&��=�S=a5T0�]�g5OZ��3p&�U�j`�z�:�nm���>�@��Jk��J��8�m����b���jJ������#�=�k����"�"#����#(�@�����6mں���M�!vݷ5��M=dc��Cv��X�VA|r���]�X���r��j�ӻ�4��sۺ���9|��5mi2g�xy�wP
�pĶ��Ph1�sM�cc+���7�p�FR�æ��r�y0"4�����]�Cr�%~���p��p�X�����pdF�eQ�������&��k���$�#��us�C�12ZM� M���*��� qK.(�'��g�p}~�%�-0lzOKZ9��'������Vv򴄵�Vo�i�j#'('���2�#��5����>�� �P�OO����]/��8�	4o8�rg�:x�B�h-�*6j�ą�'h�E��Y8}]c�\Od	��z��&c=�%ܶ�d.�����A5�f�zb[���H�m�/��K^���ɣ�,i��i�r��!,���iMwa�֩��.�ސ��!��cLo����DĦ'dc�a��J��zb����K	����2,�����K����$?�� �����-�I��v�W���
ZC��
�	�18F���'��Ez���'�����4xR���@i��*\|��>�`bZ/�Q�����@��DÔ������?�.������XP��Z�1�'�	6Ü59��'�m,�����xW�Or[�8QY�O�,��^�6���v��䶰i�W��l�����U��m�y���4v=����<����`MYh���-�29�>�?��ڛ|�}�0v��kALyKn���������!�yP�=�}��0.�u���?{@Jwxe�|v�vIy*�+~��5�!���N���p�堎��^���h-/	��?�A ���2��vˍ��D����!�o3�,�ƒX�̓�ZQ�u�b;x���:��ʿ�N�5��c(�v�+��Å����;}l-��VԂ��3)C\���F�N6��
\l�;3ȅ�<���A-�v���A+ZJz�\Ol�!�X��������Y���2}\�Q�C����yї��;�yr���$
j���A�[֢�ױ{b렙�{%ԓ�� �&3�=�uT�╸^��6�^ZWP�'5�����vh���C�+{fb�Ķ���U?d�� :�ҋ�L�'�����t��F�q��|�0��&X���al��ЅR����]gb�;���\�Ñ@q��Ȳ �~�������c����?��׿��_1�K5�(�Ə+�K���_����h�
���'��sH�:�e7���]�≊�:7�[ꇚ�ٿƗ"!�y�K���s��s� �����O!�� a���,N�� K2�)\'2��,��;��5��(��ē.H�Hp����m�]��ӝ0M;�����j�ME�8�	λ����|�	A�=^���<��Lf�_���YS�.x�g�n�y@�@�	��)����Lm�^��<��1�]�[��y@}ѩ�<\�6�Һ$�`�yB��j�y���$Z�Z�bJ��JXR!�L�y���gK2��!,����"���m{s��qSv�،�%�hRv�XT�+��);b� 5��;8b�R#��q�=�Ad��*�,{r+�Y+��N�z� ��*dʞ�
�-׉Q�fL������M>�8C�/��E*������&�5�[}雅���\l��g�xB���L�e��[�	L��f
/�b�].`)ANkʌ�O��HŔF���5�sM����(�S����ĉ���jʌ��t�ϔc��2�gS~tH�s��y*�-�v~�^�[�ׂm��b�ݐ���qftb�^�}�ZvH���J��O�Ȁqi�)lK��,��c�-}����ن~�Y�y<���6�	���̂5ņXP��^���O�ˬ�1b�������sM�!��)�������ð��lC�	� ��m���AEɶ�	�YH���6��(����d����Ԗd[�}����-}#P��ږ>aLo	�m�� ���C�*}�-�%*;�6��N_0$q��b��C_ư|�'���pFo��On�L� � ��'(:<�l��|���U/t���ǹ�6&{Ւm�������j�k�8��>�?�c�xxBk���O�2c��,�
a_y�/�����	�i�B�\�=.i�R˘�e�O_l�qF���l���B����������K�[�,�����
&�kp�r+	�Ȓ���
埋F?}�-l�O��f�CA��J/��嶮��|Gvr��V�`ze�/���_�&��/7D�+��s}��:�ޗ-�<��b@Kl�s=�u��ס�jg�}gB�ܔo����9�,����R����&.kC&��9zrC,�o�'���4K=�0GOn]ӔPv����=�va�/6����y]_lto�,S�*otaF�}$��@ۓeI�>�^�����q�l�HK:�Jf�GB�G_���}$����s=�L�Zj�^��$!,f�&XOn�j��)R0��m`�qb�4�.���h2���5�o��"!,�H"k[�v��,s�`�]$�*�66,��"AlD=C
���"!,�
�I3t�v�d�GB؆En
�I3�\�=q���v�HE���vfᜱl�H��|��vl	a�,���m	b���R�����V�8R{)a���8R#,�⋄m/	a3f��l'	A+8(��<�N���3�b5e6v��Z7Ev��#;C7C2/���#���ʷ�m	a1����a�H[�j�5�FXHx�(E�����d�'l��B���]�GBXL����v����c=��EvŐ-�GB،�����,�r�}$��hf��m��B�\V�����R�f�H���^���Ͷ�d�D�	�\_l	]�St8�G2v�v֥��v�K��l!�IBXL.�vl'��Y��ӳ�m�8��Me�f�Gr����^�[�}[�>���ҡ�VU-�b��Ģʷ��#9�e��l�ؙȘl�"�}$��� ����6�)sf;I
��$��$����*��%!,��S�����]=��֓[��li[E���[�1���l�I�s&u��v���['jW����	K����v�v��L�_�M�X0I�Sم�m7	aqMf��ζ�d�t�5�r��^��3�ש�`}�A>�2�|�/����S���%9�^g��R��!<Iu�IB؄�l1�I2v���b;I�Wl��IBXLE�C���T     C��
�N�vʁ�w�Ŗ�H�5�b;IK�;���I�؂s&Uw�v�vR�`}���6ٓ\l'	aᰖ��b�HJ;�f�v�
mT�Z�]$�����,��K���=9VPl	a1�Z*\��#!l��?yOj�>����*��d�*����+����cҌ��>�B����`ͤ)�B+a6�Nf)���9x؝�U���Cx�l�H���/
���(xK����ƒ���
۷�H�SZ���Y�j��
,�.��]��7���F��u�_�?d��\nx(uH����2���Wx��x�^���<����xy��@e̖�lS@r�'���U�-%�2��<e��Mty�/p�ʜ��/�<,�+�_�|��f�I,f���(aļ��Zz����*�kJΤ vm��d���4�HR� +�M-�ƨ��N���7�C�7T�A���P�=�*�_�,��rKW�@z*�u"	ߒ��v91���&�j׉'|�
_݉L��\k�D&,�C&�]Ί�+x�!��󊏰���|��:�J��:��/�_'��C�`K7��Ǝ!��KJ��DB�y�H��/�E�F{mM����hD��N|F-p0��޶��d���Eh�`�,�q]��&!��˹�qO�ۉ@�u+֠��fA9���R�C���>�����5&��k�U�zAs�~i���2)�K�&|��r��ks���`���1�7���$"�L�I�^�Łg�^�Ϯ�Q�d>�+8�Y=���`L	��g(R}B��V������!�(�3 !�<ÎAX��E�A�j��&��N�>��Y` ��vaT7[����ٗO��"��+9�
j�UՎ�"�$88'ԋa��6��%Q���#�Pi9�#`+����Y�H-a&Q����|@�
��;�qUcԶ�|���D���W;^J��V�GW;z�k�6��^�ŁC>��{F°��Ʊ�Z��eń�*�[���ƪ�����\�zE��:�x�ÆN��/r�b�x�`(Gj�����Sl�����!���S�^�z<��!˳�o�;����Z�em|�j�{��Gj��m�W�s�O2!�k�=�n1)��^�)a0<��CQ�@�l`W�\��/k;�$P}�xQ�7�Z���_�6r���R�Ջ�$��D*�j�\���"=���-)����$�=븨;G�)���)b��*�Q��H���wǥ�[Nz��rGzQ�D���l]�ͼ�m��^����e>>�=��-e��.E�^| ̡��d��p9�"�/�'	�[�|�)�2Ϗ�SPA5[s���eyy�U�<ɘ�x���A��:��Q��Ux�����$��G$q5S��ـE��]��-w<�0鼆�zF�6��t9�>�̜�mR�pɄ��]O2��p���57y$� �k{gԁ/3�����5�ˁ3~I�#�-{g��P�����֥�.��-v�6;�l�bH��K������T������=�ٹ_����9��\�##9bus����25qܴ�i
�ĿҊ�^�T�N�Bl�<�'����T����� ��NŚ����:
�<*	�����
�N�",�OKȱ٩X���p��٩X�H�!����87�5�D��S��&���Na޵S�榪^�;����E�o ���V<	K�y���L,�b�I�/�v��=Xhv"���p�1�Y�t)��6;��M�"�,c�X�`;kn&D�Q��e\\C�6[;Fl-��M���F�R�I�o��<��� [�5�f�a͝�-�	5[㞛8<G�v�<��������Ú;Oha�1b�a�M3MD��<�el� �N�XOl����l�4;k����\��-c�v�㴡7��b%S��t~_י|�P�[DYp�����P��d�]���<�Q�ᬰ6���E7����f�z���d���ߞ����8s�Mo�;�s�n����b+~[T�5�$� ^�9˷��)�b�q��f8����!�����IU����ml[~ȩ2=��	~z�
���Fq킑�B���c=���H'��<��E^mc�/5R�@}�:pzv��B�H۲`}��FcóOh���fԧyB�XP:�,�k'N�;dj�³=I �
�u�zW�Č�����:���XC%��]*����f�mx�`�ɹ�]>㣎�vہO`�d$N��v�b:��aD�˷�.j	0�L��ٜP~������.�:X8�l��ܜi9���n&֔ ˁԔtϐE� �6)��v���\lEW���9h�/S:��V�N�ձ��uJ\oP ,����ď�N�$�q1N7�%�ݠ �Qu���{n���H[�~1h72��:7Xz�@`��L�DMy����'�����x(�V��1p�P�}�ʳ��6X:f�r��Yˀ�T4�k���Z��ÊD��e��5���ó�)�4@�����O�߳�wpq��˳�)/F���󲪫鞱L1�[���Y�;,�T�{�2��`����Y˄���g.S�+A3Ϯg.c  Uf���F4ȅU��̄]*]��3��e�R��=�9Q�A��ȫ�3��ۨ��6�3�v�D�zb���v��{�2��BQ��ݳ�w��	�VBI3?u�^���yDy_OUˊ�{Fp��0`������H�k��r���\ ,�6ǟ�e4G9���q�@�#	a�djTVmwY�t���9;�E���N��@��Խd���ӚE�wY_G�P��EIz��W7�u�@`�:
ٹF.XD��Ѿ�+�O����NK",�}�~e�0x��`�C.a�Z@G��^�GB3=ST�aG��O@�6]V�!9JB��.!0�p���a��95��a�/���t�C���q:0fyo�Qƥ�~��������snop�$Q>�g�$�,��B>�3~v���y�!Y-+ڞ�?	�V���`�)��W�j��]v@��8��+�ɧ�ϵ�����U��DG	�P���6g�iM���[%6�,X_n�-RZy�Fl�El�m������t	ա�:�������PҰ���0Y���v�*Ë`&�b�W(���`sS]���a����Yy<��_AX亐���+K����'��Y�z_Onys�I���Xg�4�u�!�Q'��Zl��`ޔ���!����p��#�v�� �2�8䒾�];V����w�v ������k	f<R�%.��Kz�	Y��rU�d�s���������\;0oZa+��Z�ˊ�0����r�v a+���>��47ۖ��1��m�Z�aZ��u:��M#pC�K�٣[��wlR�8�[�P��\Vݪ��X���
����3p�JS���6ο�I���jb�R�2L+o��5[����:ô�b�u1���0C�)l�;(U�GSc8X���`�������;��"�|��A�$$0D��f�ԉᵾ�plf��e��<����ᕫ081�L��]c�fxm,^���5e����{^#3\d�p,��9���`�e�>���JJ�y���7;EK��.�D���A+=�6��7�;Xy�^�נ{LL3���ɺ䒟^TjÑ�d��`���o��Y����H���k�i@m0�^G�c����p�*Q������1�}}3YQ΅%�3x^��Yξ��%Iiz��Q�uL/γ_�`�_�L��|?Ϟ8��bƍo�D\��8Ō��:{����;��N���0.�מьw���zz���٫v>�{hd��3�e���GQ�~EC�F�G�T�顩�4�p��2u]�� �i:Ћԃ%��'�M2�7V�|�_+�&�����CG%���7��j %�������OB�Ϻ�������o����:�
g�5���PHx����7��Ťt����C���d������uet5�oL�QJ��i*��N���=M���ߞ���ɢ�׷�	:�<��}{�
�L��/�/�K@���ݗ�iϒ����1|�s��^�c�����b8]X��O����O�&��+5sb��(�x��][��ڹ��M`��K�x�*6����6��י��7��0/���z�5�:�4@Ņ�WY��    ��=���#x'������<f���a慵�%n1��T�n�Rԓ�k�`��&�}1�*�ml��E\`�
�]�]��K]c<$��U�\wu�V�C	�5� ��������fdf�'r�q�Ff��+j�5�T��n�0��jf�1x�����6X������޹~j����3�*��n���S�o7��H�̰�!g��'���#2������l0r�J����c�H�V���l0VϨ��������Ö����
mv�ډ��w���9Y-ch�����7����6:��Љ�gh����u��з�	U8`��oOS�J]5��iBnJ���ߞ�Bi������	U8����5����C|�k�w��]f��]P�;�P����3\hY��ALy��Q��^n'�[������Ӝ�T��^��0�����^I,�5�Ӻ�N!��M������	uY�4R5�N�����0�2�V���Oh�A�V�:��@��fF�6�㮓&顙�����L�E����n�$�;ij�x�m{@E����9�y2� ��p�,2��)#����e$H��мuFx̼U=�c���M5C�[hj���BS��`��n���Jg��N<�
!e�>v�ڄ&�"�R���5Y��@�:�续��	�j:�"9PP�2��h@z�w����euV���b��� ��WjRG�Y2@�ĺ~����H_P�Q�y�θ��CW�s^�c<�<}�O�{�:�52�!a���.� �8��\2���h2�op}e1Y��TRsF��Z`K���)� l���G�4"Z`�"p�ܺ��l��.��F}�ut�bsϔ�kX��G"��'��g�x��Z�E�l�\n0�@Hʅ�����΂�����Ճf��iF0�xPo�Ms�LUO�7�:51#��̹��,r�F3�s���5�i�6
�6S���`���]���h�\�d��Φ� ���$m�����K>��!��Yd�Q��g	p�>�}�'� ����2}���0�fq^�M�M���-R
E�K�� H�����*��),�1ڬ{z@C�]�&� ~Ʀ�w,�kgL����:`N���i�X��7����L�U'��y��Y�E�?B��@P۫�
#������:
��K���媏F��g�IJ����K��6�T��χ�Sڕ��y����`<s�mgd`0��a������&�w6r0��U�F�g��Z��,LcnA��a�a2��Π���(���J�F&���/]�ؗ_�b��V�dP��H�<�J�a�˯b��Tj�������\m*#���м�-�a�c2����{FB&����QW���y����Ed�d2i���w�Ӿɰ~M����I`d; ?L�Q��`JEJz��023	��*���l�T���b�n�q< [����|��+�N�����y��Ey�	��:�ƘΓ�1���ݾ�/DWފzs����JH�$�Z{�#��������?�}�'�g��h�~�ex�c5(�?��"�<�S��,]��=�������o���4����rR�Y��AF]�_����G��2$�(z��}�C0���Cn����JH\�I��_������+�Bxs<�咤/�һc#�U(L��6� ���9>��+0�qXLv:*���/�i�_h�;EO]�s*e����-�	���< ���W��x�w)�]<��t����R!F^��vR��Օf��/0Tx&��z �3�0���)I�+�A���Bn�V����k��=����ٙ�ڱID���������AG��*iɦe|������BcR���ɵ#� hY)<;RhE��u�"�*+k;��j�����:�T/���h۞L;�UK���uEPc�R��T�<��U�L�d�����b�Co�J��p]F��Lɦ���npS�.����CU��M�: +u%��:�@��l�9��_G��:Cy���k׍�y���4�dʿ�J�K�:�0 !U��NPFZ���N	�T�d�4~��E��]5S��ԯ.S[���w��N�8qL'��t�{�).�uA]]KAX���`�����W��Z;��:�q~���Cu��B���X����'�2\�$��d<A/����:`�o��񀎞��\�#�*��|ŷ�֧����mMN;y��
j�����g�f�ׯc'�k���[D��
�&��1�㦢Q�_����	:ש�y����@��\���[/���Į0s,�I10ݞ�����W#�s%l�1�����X*9����N�`�<��q�A	r��|ໂ �8J�4����FM�s|����P�W��#Ǳ>�������<545L��?zw6���F3<�F����H��O�F��d+bv����I'�e#����h��b�����B�����c6HB�&L��+1�w��Rx�6����5K�Kj��B��iFۘ�X�#f��s2����@�����N��B0����j��J;��d�g;����/Y?X�7��,�AiD��V|�J�c�Yg@S^�l��Ҧ
E*g��Н�������_
e[��/:ey��	Oݴ%y7�j��/���~�I����V-�� �;|d��q��� b�u~��>~���3�f����1������$����~^�݉�~�nO$���ͤ��e���阝���k�pHHn��koj>���(�����K/�ڔ���!A�����Y��;x/��C�J�O�6�ż�4܃��K���2����k�cXo������:u�]�.����V" 
}R�o�r�-Fm���e��_�i�:ev��@�!u�ٯ��a�k
ȱ��{�[$��Bl��_sͺ���[3��I߫��T���6�K��Ӥ���ݓE�T;x���9�Q���{3淃ϑ���@�\0y���h ��U�E����6QK֊�x�_��`��*�[u�xq�T�L(��2��mʃi[d>�V^�B�Rd���z<@V��{�W�6���塞Ӯ֧�l��Q��E��2�<fg���lf�Wo��~����I��T�)6�:=��9k�����W���묺���6?�����bJ��W|#�]�2�.R:��R��>^@��a���i�%���_�}B	\x pt���$2`�[�����y�Wt^u��voh[ѳ���v�3�af�:�ڽ�-rRYyի`�&��D��z,�G�C����"�E����~/��bt��]Z���5�0T�����WB}�[�_�3:���n��A�d�<x�ˁ�c��i��utY϶sU��|�Z����r�F�Q=��>�A���7�?A���B����`���Ͽ�Y�����!8�e=7��Lڷ��vB	����r�4��L:���4y}�]����W��暯ܚ5�Ӷ����O��to@K%-��7}�[���)H��;�NL�g��y��lR��ұf�i�X��x���_��m��5�Uk{�8l���<А����|��O��2���5�'���v�,�[���+�|�ʉj}:��ma���^�z�.|ЏP�ӵ^;���w��:MĐϰ�"/�U��������J��ZCs�H��ä_V'�/�oN��]J�x�p�<�_�l�x�_���oI���oZM&��w��:�e����L�-�gCwU��U�4t�wU��Q�\v;r����|�_f��t���/�{����:?�b�&Ý:�������7g��_�ZQ�����*2M'�z�e�`�h�(WKw��OE���Ud�iGrR���`g�$���*�	�"�����1h\�P����0�%��,7*Z�����U�o����_�'aZ�v��f��JT�;'�&t5ox�Q���Te��g���8b�[�~���+Gf߭B?���/�.Es*���qyE]�/��ī��� ���u�+V�\E�ۍ­<�§K�����^3�_�K�������)V���
�X&�3�_���M��i���³)���1��l T��+�.p-CXz���w��:L����*���4 �  �\^�/.��=B����Ȏ���i���e��s11<V�>WZlj#����6�C�]b�Ӌ
�2�e5{z�p*�G��t�|M�ғf�S<cQMv�	�L�m����x�	_��+.�y9˙�!���\DB�����w���UϿ�Z"���t�ZE����=jg&��E���Q���j�o;������S\Y9�#r]�*4��ۡ��Z�pe�,Ĥ'��p�YA��2�?ܿ�FW��n2f2�X3)|-��J����ayh����h��`TQ������lFE��T�:,�vn���OQo�L��R���0�<�ٸ��Ұ�4���ʊ\`��.$;�^�[}s�p�ݰ-h=;�^�d��O5IvF�f�����{�z@�ި�Y�0�\}�R��AYN�ƕx�#LWs�r.+Z'��(_�/A/�J��eE�A�Ժ�^+�R��uD/{`��$�؊�|�����g�w��&�[D��H�� /���H`3t5��J�+D�btk�� �ke0F;E���q������0%� �f��,&=`)�U�T5�t�j��̴`Q�h�1�q]��tNu�&�$R��9:�|���ڨoN�G㵴v�j��V�&5Iɶ+^kM��;��lC3�?\k?-%��.��*	MZ.]0R6�ߒK�e�	�ed��ڎ�6��H�Z�ZSهp�D�̬�l�T=`"Ѳ��� �ͺ���-m�t팍閅v��*y�1ي�k�dүd+2���b��%;U���Wj�*=�?QK�N�Е��e�u-Qa��g�d�?���� [��ŀ]Gxր�+,�-/i��+j5��?ؾ���/�\���(pBTq�K7�IۯW]�Jc�9�2�Q�A����9�2�Q�9E���Y֟XK_ �-|W�V��>�?`�&|PP��'�mR�`�+!��&�`���X�0�<�fWBpFC*J�^�ٕ\�k��������@�l�8�M����ߔ. ��@���#�
1���Ac�p] e�+��`�z������+1ؓ r����$D(��;d�_)o�b�����Ip�����7w�b$�;seuG�tC1�Z�Ǵ3��C�*���������ls��O��E>�3���GU�s�\�5����+�(��9C3�@0t�VM`2Fv=xG$����FYa��2P۫�P�؉��+�A'��-�1#���ykKTբ[��^��1�<`R��� ���p>u��f�w��|+a��
��}v�K5`�0���XzNP�l��g@�$���JZM*�ea5�C7~\<���F�_�*�����F;�(V�;��@2QW<�NH�X-v��u@Qr(�U�O�$#G5�h@}��PP���(���u�bx).���'T�Xl�$�'�p<Y��="���Pl9��x� �9�׹lLP�K��.[��U4�+]��^H�.�o��e�^񀌽���]ҫ�) �6���^�m��v=j�|p�:4 "��l;5 w=�Q7� �����,�y�E��=�X+����s�#�Șr��W��W^��2bp�x�.X�	G?=ݞ^�~["���r�;e�ɼd�0�Dg�v�V�f�7}%6�W�a%{�ė�k��mɞ,2�'&5#�:�����T`G�ӭA
N��b��!0��hZ�� F)f��W�"}gٰ⃕��	\��B��'A(�Ǭ���ٓ`Fꋆ]��I0#�|�|�P��}��P�L�I薊M8���~h��Xl�i'�*v�bN#�r*��@�p���D����r�(q��J��`(}s�=��^*դ��gq�,Yh�YY�����ZWIKX��E�9'x���"��bB}=Ubx����:�t�Ohz컄7ە���9�[��V=�2�]��w�&��"R�����.���Θӻs�����j��@�_1u����ҀԿ�Ĩěޝ�u@J��������n4��4S�QSjk��2̲�*E!�E��f�����\��I�����|q+Ġ��]�?��o�9�+_��j*���s�\)C%�������ЧT܈��x#N���u��2�!�y#C]D�\7]�gj�ڍ���Jnؤ>�T����P��b��z�ຨ����zZ�b=����m�@��eh�^��C��͹y�Щ���ɎW��@���4�J����=�2ʚM%~࠼(��FbI��F5w��_����*�����v��H��K<]��f�\��{��dep����q1"-HR�7���X�v]�뀦<��e��hW��*|L�ȷˇx@�䁮x���{	����=���+ɀ��i@R��ōe�E��,._�PUfYή&G<4��b�3Rw���*�k>#7�&&.vN�0�<w<\�zɹ�tP�˗�|�j@WԚ�������7��������RE��43�x@�c{����Σ�^J� '�7@�F��s�Dy t�P���}?��;Y��]�8@���k�#i����:�w-8+oIGl�w���B��K#���Հ�N���� ��5�ۙ���j=	�P�WVw�F.OR�-�N�6���*� .�/����T�]̘���<�?}1���CI՗�:�k4��� p��'�-��Ĝ8����11>�?�o�*�P��� ���z���u �/� �f�S��d'l��"8�Nu����KQ��d0��Z�:$Yj ���t����d��(���˙� ���V5yaP^x��M�舜#Y�c�.�/�|���q ����^{@�Ůk�E��$�KK*�I�u@U:�C%�:��;���$Հ���M= �2?�25 X��1[�\R �@�����ى 3#돾K��6��c���Q��]�8@'�;j< �����V;0Q7?zDX��nC��OkT���m�����\��������Eknz�е��\5`��������"�	8^� I�� �`T�dD���ਜ਼�Pt�WhDߨ��Y��NRս���Z�����u�>x/_�M���s�رU᯻��)�h���^
�Ԧ�,7���KA$���͢V�����.eP�7�gԀ�����q���5����⊭n��3`�ME���<5 h�T����S�w������J_���БF\MT�H��B	�ٞ���SO�M�R��VGΧI[,
��Ww�c�N
l��c�Ydcͮ߷ʉ녁H���b"e����a�cdņ��'������ֹ��      h   &  x�]�ۍ�0�Ci �Բ�ױ�d7�Z�ć'�CX�_b'�U]ƁC˔( ��O��M��
��������/��'j���-t��R \��6#�J#{=1�w���}F�4^���L]/(ݏI��P��nA ��Xs��8%sI �� r��%��i�z����3�5�(��Bߙq��R{zb�3�����L�ÅyyTIdc����In��v�ο|�V�>6�LX�g"Ѕp'�Ƭ�{2y*�I�S��}o2*a��.&���dʈ^����q�7�ZD�L?��~%�z�      i   {  x�u��n�0Fמ��2���klc���FjԤi'R7�8`�G6L��M�E�}�`^�f`�S�H�}�|�.���+�=<��:\�Ҿ3��d' �J)$��3�i&Y"$���qJ��~����-{�w���~(5�5۝���!��LH�T�L��g�ȼѡw���b�ˡ��_`����>�9Z9��2��g�gn�C���p䮜w�i�-t1-0��hy��/�����+��m_j�RB�$"K'��4A'��m�t�ƴ�������v��o!K�l���]������V�j%�6W�+�@�eDL���� ��	�t���?ٮ1Q�b�d�،g+��$���\5<B
t��ބ��ڴ6ܙV��_�Pح�9c��DV�7�7�0$�'kS<�d|��M�ա��.uxҕ�����= ���Hb���Y�!��L���ㆍv�ZO[��M[��m���+�8�D�O�_��LR-�e��+�F��DT5eع�	;��f�2 )�Dfs����*��UmO>�R���ٍ��䊋DB>��1�	 ���u/L��Λ��B;��"9�%>�D̕�앥q�^��ޝ��Hƅ�
��
�c$�9����Itp.E��Ԙ�r~���D�L��)�3�      k     x���[�� E��`\�������A+�zt�N*@�e���O�K�;
>G���o�eG�v���Ya*z��.g���lt�Ӡ��.���v�>4�|`��'g\j���'v\}�B�ય�חY�V��xB.X ���a��5H�9lܼP \��͂8pr�kvl�Y[xe��V�vs��D7xB/�鄅'�0��a͵Q�L�C�ś�i�1��5}��Q����tu�|]�в�\ٗ��EQ|�)�t3��7%�z��=w}�W�\%.�d)�ᔴH@7�!'�����l�p�4�EN{Lg�$/?�����%e���Em��\?m��V�J��wAW��=k��=P��:jS.�����Ӻ���>�:�TpYC��K��NaK8��l2���ٷ��I�u4G��B:R�ۜ�u �0��W�Jǰ�S��.`���ۄJ�dE�)�t�{NHˉt��hE����\j�r����u��#���Y����/5���p)��3<�x���e�؂�+8�t��Y���2��h���ſ�p1A1#f�#�y�D�u���-쯲�xhO��h�p�Z�S��C����(Y�e㼔
���Z�G�MY7dT�P�|[|�e�Gb8~Vy�n����bѝ��.�8�3q�a���m��7�����������c��K���f��W���K_�A�'bN"uO�(8��F=�A����
"�m�a�df�A@L��`Q�[�[�����#��t]W��ʓ>��K��/Y��m��� ��}�
2;'@[��2o��HO8���{/�~��0Y��eS�m��43P !\p��׾0��Á���S�^z?���:S�Xq�'�Yu��ԘMe=�$xY��^��ŷ�9�T�r�!ռc��;��i���:�^���o횧�1hɺ�<���}����@���i���w�T�k������3h�H�A|�Fe�I��fp�y�y��'R{2�!_��k�QM���a#̓�����cӏ�i���)�i�W��9�.!+����UJ�%      m   �  x�mT=o�0�O����(Q���u� @dq�]����D��� [J�!�)����(ǖ�������;r��[mz�
���$LS��-z�S�&�O�+mJG�#� �
���$\l|��Sl)�Z�VՐ�Q�2��O��m��j�a⧙���^�쳼���D�t� ����)�G������ �a�8�[�S-�(L_���Ph\��V��z���%P\aKݖ��m�ٍj�A�G��MR�I��������S��F���	B�sO�y�b-�#���vF�B�C6��P�;�G�l�7���IO��u{��;��U�R�Nlo�U@vp�R���3w�ŧ��yWO���G�oK4�j@����/np�#�LI:�\�ѱsb�ɐ	,�?��v({�{)���6��x8s���Fd��%��轢��C�I�d�M��Nw;�l�V��fn�tb�R�Q/�to�n�Wp�����ȉ&6�o�F�3�G��dՀ��\x�'�ӍΤ��GFWb(_�(+���?���M�
�e���R�Ӵ{:�\N�>�|�3�T��ú�1�y.h�O�^���m�wߤ���/�Q���;���U �C�o)bXۇ=�A�i|�U@2'�y[� ?{c�;]��˫)Ź㡋�-�������-�i��(5���5��?�0�      o     x�m�Mj�@���)�%��/�C�PC��(��Lqf���}�-�s�ʎ�咝yzz��Yó����+��T��%�o��Eа��6�B኱�CI���!e�����O\@t���K}	�+Y����n��Z���V2S�z�˩���jGo�s�5$�#o�n���K=�w��g�4�4��?�k5m,����5t6��p;4 M�������� v|�K���҉��@tl�	R�D,*�M�-�]����⴯OLאb�%�RF�g^���NկA���T      q   (  x�u��n� Dg�c,ll c��C��]ڥ���IC%P$�<|�� $�ʥ�(����+�|�|L��J",4�jA�VH["M,v�P"���&%u���fДH�Y��:�˙vk8��h�Li	N%m �Ǝ�n�t֝��Qm��� s�������nNGk�Jc�����q�'S����C��M1e��q"�.U��T��4���
�.[|��纑E���/!�Ͷ��)�|��|X�����x 0��_�-����o���	����ߌ���2�u�o|�/���s      s   2   x�3��M,9��(3Q!�(37�ӱ$�,�ˈ�9?/%375�$*���� �M=      u   "   x�3�t��KO�IL��2�J-N+��c���� ��]      w     x���=n�0Fg�0�$;ݜ1S/Ѕ��B�-��\?N�I���&���Hq8��ȇ~
�HY]�(�w��}�1	:��3]�iuY�^��v��Ɩ:�&䢃O����YFey\ǩ��eê0�0��#�V|��@�q�A�H�?XV��#�!��a^\�qr>e`�Cu.hV���I/b�b񸆵��^�tmz��z+>���~�b�|A��A^�[̴��H!��E��G7�2�Ⲏ�'\��e
�c���TQg�,��     