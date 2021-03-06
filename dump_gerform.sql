PGDMP             
    	        y            gerform    12.3    12.3 V    {           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            |           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            }           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ~           1262    16855    gerform    DATABASE     �   CREATE DATABASE gerform WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE gerform;
                postgres    false            �            1255    16856 )   show_material(character varying, boolean)    FUNCTION     �  CREATE FUNCTION public.show_material(criterio character varying, ativo boolean) RETURNS TABLE(id integer, descricao character varying, precokg numeric, status character varying, tipo_material character varying, razao_social character varying)
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
       public          postgres    false            �            1255    16857 -   show_propriedades(character varying, boolean)    FUNCTION     �  CREATE FUNCTION public.show_propriedades(criterio character varying, ativo boolean) RETURNS TABLE(id integer, descricao character varying, umidade numeric, gordura numeric, proteina numeric, email character varying, status character varying)
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
       public          postgres    false            �            1255    16858    status_propriedades()    FUNCTION     �   CREATE FUNCTION public.status_propriedades() RETURNS trigger
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
       public          postgres    false            �            1259    16859 	   auditoria    TABLE     �   CREATE TABLE public.auditoria (
    id integer NOT NULL,
    usuario_id integer NOT NULL,
    tabela character varying(255) NOT NULL,
    data timestamp without time zone NOT NULL,
    acao character varying(255) NOT NULL
);
    DROP TABLE public.auditoria;
       public         heap    postgres    false            �            1259    16865    auditoria_id_seq    SEQUENCE     �   CREATE SEQUENCE public.auditoria_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.auditoria_id_seq;
       public          postgres    false    202                       0    0    auditoria_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.auditoria_id_seq OWNED BY public.auditoria.id;
          public          postgres    false    203            �            1259    16867 
   formulacao    TABLE     �   CREATE TABLE public.formulacao (
    produto_id integer NOT NULL,
    data timestamp without time zone,
    ver integer NOT NULL,
    custo_elaborado numeric(9,2) NOT NULL,
    usuario_id integer NOT NULL,
    id integer NOT NULL
);
    DROP TABLE public.formulacao;
       public         heap    postgres    false            �            1259    24713    formulacao_id_seq    SEQUENCE     �   CREATE SEQUENCE public.formulacao_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.formulacao_id_seq;
       public          postgres    false    204            �           0    0    formulacao_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.formulacao_id_seq OWNED BY public.formulacao.id;
          public          postgres    false    222            �            1259    16870 
   fornecedor    TABLE       CREATE TABLE public.fornecedor (
    id integer NOT NULL,
    razao_social character varying(255) NOT NULL,
    cnpj character varying(18) NOT NULL,
    telefone character varying(15) NOT NULL,
    endereco character varying(255) NOT NULL,
    status character varying(255) NOT NULL
);
    DROP TABLE public.fornecedor;
       public         heap    postgres    false            �            1259    16876    fornecedor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.fornecedor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.fornecedor_id_seq;
       public          postgres    false    205            �           0    0    fornecedor_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.fornecedor_id_seq OWNED BY public.fornecedor.id;
          public          postgres    false    206            �            1259    16878    item_formulacao    TABLE     �  CREATE TABLE public.item_formulacao (
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
       public         heap    postgres    false            �            1259    16881    item_formulacao_id_seq    SEQUENCE     �   CREATE SEQUENCE public.item_formulacao_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.item_formulacao_id_seq;
       public          postgres    false    207            �           0    0    item_formulacao_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.item_formulacao_id_seq OWNED BY public.item_formulacao.id;
          public          postgres    false    208            �            1259    16883    material    TABLE     .  CREATE TABLE public.material (
    id integer NOT NULL,
    descricao character varying(2555) NOT NULL,
    precokg numeric(9,2) NOT NULL,
    tipo_material_id integer NOT NULL,
    fornecedor_id integer NOT NULL,
    status character varying(10) NOT NULL,
    tempropriedades character(1) NOT NULL
);
    DROP TABLE public.material;
       public         heap    postgres    false            �            1259    16889    material_id_seq    SEQUENCE     �   CREATE SEQUENCE public.material_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.material_id_seq;
       public          postgres    false    209            �           0    0    material_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.material_id_seq OWNED BY public.material.id;
          public          postgres    false    210            �            1259    16891    produto    TABLE     �   CREATE TABLE public.produto (
    id integer NOT NULL,
    descricao character varying(255) NOT NULL,
    tipo_produto_id integer NOT NULL,
    tem_formulacao character varying(1) NOT NULL,
    status character varying(10) NOT NULL
);
    DROP TABLE public.produto;
       public         heap    postgres    false            �            1259    16894    produto_id_seq    SEQUENCE     �   CREATE SEQUENCE public.produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.produto_id_seq;
       public          postgres    false    211            �           0    0    produto_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id;
          public          postgres    false    212            �            1259    16896    propriedades_material    TABLE     �   CREATE TABLE public.propriedades_material (
    id integer NOT NULL,
    usuario_id integer NOT NULL,
    material_id integer NOT NULL,
    umidade numeric(9,2),
    gordura numeric(9,2),
    proteina numeric(9,2),
    status character varying(255)
);
 )   DROP TABLE public.propriedades_material;
       public         heap    postgres    false            �            1259    16899    propriedades_material_id_seq    SEQUENCE     �   CREATE SEQUENCE public.propriedades_material_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.propriedades_material_id_seq;
       public          postgres    false    213            �           0    0    propriedades_material_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.propriedades_material_id_seq OWNED BY public.propriedades_material.id;
          public          postgres    false    214            �            1259    16901    tipo_material    TABLE     �   CREATE TABLE public.tipo_material (
    id integer NOT NULL,
    descricao character varying(255) NOT NULL,
    status character varying(255) NOT NULL
);
 !   DROP TABLE public.tipo_material;
       public         heap    postgres    false            �            1259    16907    tipo_material_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_material_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.tipo_material_id_seq;
       public          postgres    false    215            �           0    0    tipo_material_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.tipo_material_id_seq OWNED BY public.tipo_material.id;
          public          postgres    false    216            �            1259    16909    tipo_produto    TABLE     d   CREATE TABLE public.tipo_produto (
    id integer NOT NULL,
    descricao character varying(255)
);
     DROP TABLE public.tipo_produto;
       public         heap    postgres    false            �            1259    16912    tipo_produto_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.tipo_produto_id_seq;
       public          postgres    false    217            �           0    0    tipo_produto_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.tipo_produto_id_seq OWNED BY public.tipo_produto.id;
          public          postgres    false    218            �            1259    16914    usuario    TABLE     �   CREATE TABLE public.usuario (
    id integer NOT NULL,
    email character varying(255) NOT NULL,
    permissao character varying(255) NOT NULL,
    senha character varying(255) NOT NULL,
    status character varying(255)
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    16920    usuario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.usuario_id_seq;
       public          postgres    false    219            �           0    0    usuario_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;
          public          postgres    false    220            �            1259    16922    vw_auditoria    VIEW     �   CREATE VIEW public.vw_auditoria AS
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
       public          postgres    false    202    202    202    202    219    219    202            �
           2604    16926    auditoria id    DEFAULT     l   ALTER TABLE ONLY public.auditoria ALTER COLUMN id SET DEFAULT nextval('public.auditoria_id_seq'::regclass);
 ;   ALTER TABLE public.auditoria ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202            �
           2604    24715    formulacao id    DEFAULT     n   ALTER TABLE ONLY public.formulacao ALTER COLUMN id SET DEFAULT nextval('public.formulacao_id_seq'::regclass);
 <   ALTER TABLE public.formulacao ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    204            �
           2604    16927    fornecedor id    DEFAULT     n   ALTER TABLE ONLY public.fornecedor ALTER COLUMN id SET DEFAULT nextval('public.fornecedor_id_seq'::regclass);
 <   ALTER TABLE public.fornecedor ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    205            �
           2604    16928    item_formulacao id    DEFAULT     x   ALTER TABLE ONLY public.item_formulacao ALTER COLUMN id SET DEFAULT nextval('public.item_formulacao_id_seq'::regclass);
 A   ALTER TABLE public.item_formulacao ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    208    207            �
           2604    16929    material id    DEFAULT     j   ALTER TABLE ONLY public.material ALTER COLUMN id SET DEFAULT nextval('public.material_id_seq'::regclass);
 :   ALTER TABLE public.material ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    209            �
           2604    16930 
   produto id    DEFAULT     h   ALTER TABLE ONLY public.produto ALTER COLUMN id SET DEFAULT nextval('public.produto_id_seq'::regclass);
 9   ALTER TABLE public.produto ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    211            �
           2604    16931    propriedades_material id    DEFAULT     �   ALTER TABLE ONLY public.propriedades_material ALTER COLUMN id SET DEFAULT nextval('public.propriedades_material_id_seq'::regclass);
 G   ALTER TABLE public.propriedades_material ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    213            �
           2604    16932    tipo_material id    DEFAULT     t   ALTER TABLE ONLY public.tipo_material ALTER COLUMN id SET DEFAULT nextval('public.tipo_material_id_seq'::regclass);
 ?   ALTER TABLE public.tipo_material ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215            �
           2604    16933    tipo_produto id    DEFAULT     r   ALTER TABLE ONLY public.tipo_produto ALTER COLUMN id SET DEFAULT nextval('public.tipo_produto_id_seq'::regclass);
 >   ALTER TABLE public.tipo_produto ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217            �
           2604    16934 
   usuario id    DEFAULT     h   ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);
 9   ALTER TABLE public.usuario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    219            e          0    16859 	   auditoria 
   TABLE DATA           G   COPY public.auditoria (id, usuario_id, tabela, data, acao) FROM stdin;
    public          postgres    false    202   Hn       g          0    16867 
   formulacao 
   TABLE DATA           \   COPY public.formulacao (produto_id, data, ver, custo_elaborado, usuario_id, id) FROM stdin;
    public          postgres    false    204   ��       h          0    16870 
   fornecedor 
   TABLE DATA           X   COPY public.fornecedor (id, razao_social, cnpj, telefone, endereco, status) FROM stdin;
    public          postgres    false    205   �       j          0    16878    item_formulacao 
   TABLE DATA           �   COPY public.item_formulacao (id, percentual, kg, precokg, precokgprod, umidade, gordura, proteina, material_id, formulacao_produto_id, formulacao_ver) FROM stdin;
    public          postgres    false    207   �       l          0    16883    material 
   TABLE DATA           t   COPY public.material (id, descricao, precokg, tipo_material_id, fornecedor_id, status, tempropriedades) FROM stdin;
    public          postgres    false    209   �       n          0    16891    produto 
   TABLE DATA           Y   COPY public.produto (id, descricao, tipo_produto_id, tem_formulacao, status) FROM stdin;
    public          postgres    false    211   �       p          0    16896    propriedades_material 
   TABLE DATA           p   COPY public.propriedades_material (id, usuario_id, material_id, umidade, gordura, proteina, status) FROM stdin;
    public          postgres    false    213   ��       r          0    16901    tipo_material 
   TABLE DATA           >   COPY public.tipo_material (id, descricao, status) FROM stdin;
    public          postgres    false    215   s�       t          0    16909    tipo_produto 
   TABLE DATA           5   COPY public.tipo_produto (id, descricao) FROM stdin;
    public          postgres    false    217   ��       v          0    16914    usuario 
   TABLE DATA           F   COPY public.usuario (id, email, permissao, senha, status) FROM stdin;
    public          postgres    false    219   �       �           0    0    auditoria_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.auditoria_id_seq', 639, true);
          public          postgres    false    203            �           0    0    formulacao_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.formulacao_id_seq', 20, true);
          public          postgres    false    222            �           0    0    fornecedor_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.fornecedor_id_seq', 6, true);
          public          postgres    false    206            �           0    0    item_formulacao_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.item_formulacao_id_seq', 196, true);
          public          postgres    false    208            �           0    0    material_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.material_id_seq', 28, true);
          public          postgres    false    210            �           0    0    produto_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.produto_id_seq', 8, true);
          public          postgres    false    212            �           0    0    propriedades_material_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.propriedades_material_id_seq', 19, true);
          public          postgres    false    214            �           0    0    tipo_material_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.tipo_material_id_seq', 2, true);
          public          postgres    false    216            �           0    0    tipo_produto_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.tipo_produto_id_seq', 2, true);
          public          postgres    false    218            �           0    0    usuario_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usuario_id_seq', 55, true);
          public          postgres    false    220            �
           2606    16936    auditoria auditoria_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.auditoria
    ADD CONSTRAINT auditoria_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.auditoria DROP CONSTRAINT auditoria_pkey;
       public            postgres    false    202            �
           2606    16940    fornecedor fornecedor_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT fornecedor_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT fornecedor_pkey;
       public            postgres    false    205            �
           2606    16942 $   item_formulacao item_formulacao_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.item_formulacao
    ADD CONSTRAINT item_formulacao_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.item_formulacao DROP CONSTRAINT item_formulacao_pkey;
       public            postgres    false    207            �
           2606    16944    material material_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.material
    ADD CONSTRAINT material_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.material DROP CONSTRAINT material_pkey;
       public            postgres    false    209            �
           2606    16946    produto produto_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_pkey;
       public            postgres    false    211            �
           2606    16948 0   propriedades_material propriedades_material_pkey 
   CONSTRAINT     {   ALTER TABLE ONLY public.propriedades_material
    ADD CONSTRAINT propriedades_material_pkey PRIMARY KEY (id, material_id);
 Z   ALTER TABLE ONLY public.propriedades_material DROP CONSTRAINT propriedades_material_pkey;
       public            postgres    false    213    213            �
           2606    16950     tipo_material tipo_material_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tipo_material
    ADD CONSTRAINT tipo_material_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.tipo_material DROP CONSTRAINT tipo_material_pkey;
       public            postgres    false    215            �
           2606    16952    tipo_produto tipo_produto_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tipo_produto
    ADD CONSTRAINT tipo_produto_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.tipo_produto DROP CONSTRAINT tipo_produto_pkey;
       public            postgres    false    217            �
           2606    16954    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    219            �
           2620    16955 %   material status_propriedades_material    TRIGGER     �   CREATE TRIGGER status_propriedades_material AFTER UPDATE ON public.material FOR EACH ROW EXECUTE FUNCTION public.status_propriedades();
 >   DROP TRIGGER status_propriedades_material ON public.material;
       public          postgres    false    209    225            �
           2606    16956 !   formulacao fk_formulacao_produto1    FK CONSTRAINT     �   ALTER TABLE ONLY public.formulacao
    ADD CONSTRAINT fk_formulacao_produto1 FOREIGN KEY (produto_id) REFERENCES public.produto(id);
 K   ALTER TABLE ONLY public.formulacao DROP CONSTRAINT fk_formulacao_produto1;
       public          postgres    false    2772    204    211            �
           2606    16961     formulacao fk_formulacao_usuario    FK CONSTRAINT     �   ALTER TABLE ONLY public.formulacao
    ADD CONSTRAINT fk_formulacao_usuario FOREIGN KEY (usuario_id) REFERENCES public.usuario(id);
 J   ALTER TABLE ONLY public.formulacao DROP CONSTRAINT fk_formulacao_usuario;
       public          postgres    false    219    204    2780            �
           2606    16971 ,   item_formulacao fk_item_formulacao_material1    FK CONSTRAINT     �   ALTER TABLE ONLY public.item_formulacao
    ADD CONSTRAINT fk_item_formulacao_material1 FOREIGN KEY (material_id) REFERENCES public.material(id);
 V   ALTER TABLE ONLY public.item_formulacao DROP CONSTRAINT fk_item_formulacao_material1;
       public          postgres    false    2770    209    207            �
           2606    16976     material fk_material_fornecedor1    FK CONSTRAINT     �   ALTER TABLE ONLY public.material
    ADD CONSTRAINT fk_material_fornecedor1 FOREIGN KEY (fornecedor_id) REFERENCES public.fornecedor(id);
 J   ALTER TABLE ONLY public.material DROP CONSTRAINT fk_material_fornecedor1;
       public          postgres    false    209    205    2766            �
           2606    16981 #   material fk_material_tipo_material1    FK CONSTRAINT     �   ALTER TABLE ONLY public.material
    ADD CONSTRAINT fk_material_tipo_material1 FOREIGN KEY (tipo_material_id) REFERENCES public.tipo_material(id);
 M   ALTER TABLE ONLY public.material DROP CONSTRAINT fk_material_tipo_material1;
       public          postgres    false    209    2776    215            �
           2606    16986     produto fk_produto_tipo_produto1    FK CONSTRAINT     �   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT fk_produto_tipo_produto1 FOREIGN KEY (tipo_produto_id) REFERENCES public.tipo_produto(id);
 J   ALTER TABLE ONLY public.produto DROP CONSTRAINT fk_produto_tipo_produto1;
       public          postgres    false    2778    217    211            �
           2606    16991 8   propriedades_material fk_propriedades_material_material1    FK CONSTRAINT     �   ALTER TABLE ONLY public.propriedades_material
    ADD CONSTRAINT fk_propriedades_material_material1 FOREIGN KEY (material_id) REFERENCES public.material(id);
 b   ALTER TABLE ONLY public.propriedades_material DROP CONSTRAINT fk_propriedades_material_material1;
       public          postgres    false    213    2770    209            �
           2606    16996 7   propriedades_material fk_propriedades_material_usuario1    FK CONSTRAINT     �   ALTER TABLE ONLY public.propriedades_material
    ADD CONSTRAINT fk_propriedades_material_usuario1 FOREIGN KEY (usuario_id) REFERENCES public.usuario(id);
 a   ALTER TABLE ONLY public.propriedades_material DROP CONSTRAINT fk_propriedades_material_usuario1;
       public          postgres    false    2780    219    213            e      x�����)�Ə����̟�FZi�p�VZE��(�t��N���6�M�0_�o}T=`̃����}����w �گ)��+�+����������o���_���+�+������O�W,W������n}��R����,.����5�dݑ�K�X_Ю��M6�����8��i�j��������N4�h�r�D�2	����
AѭNm��W*q��JM6ի�������ۧ�q��d�	����o��%�V1��+�W$m�gEO2␅�Y?������k};O5b�+���lx�qKi$\�fW O5�����j�������?�,�@��=������
i�pȇ��+ԫa���W+y<����+�+�߿������?>���㗯�I#�؛�b;��<��-�o�Ԗ}m{�t̯D�t�0�<�cGn8j�H���w�X�|ɔ�0uQ�y�br�8�t���Q�8�@���<i�f�r[����/~���㇏����m��w���曶���s��������R�N��;���D��|���L?@�=Z����򃜯��W���mC��r~��jC��X�y�����"^/�<o�J��Qv�0�4x� θ�� �h�N�洝�<P��_��90�C�	�#�l:��P(4֯����Θ�p���ݘ����t����9X� (�������Ҥ����l���_�d���F%R����N��fNw�����$�Q��U`6����VW�k��N��RGq"E��0ΏUv�����Q�QI̚��We��M�E�f7�Ec1�˜p���d.�W/�TO-�\("�:�Z=��kW-�C{jENx�MP=�"OщڪjUO-B�$�yNJ�S�P
�*EQO-�+4�S���<��I1�5��V��N��=GA�բ�N�,Z���K�p5�O��u���wm�Z q�u6�yj�̱_��n��W�q�ybI��&�[yb���ʊzbQ^�s#}���'pt���h��<��ޒt%�<��!}+�X��
$+�I���KE=�&���ReY��O����ɳa�Zu_+Ne�g��T�(^U�ݗ�ӌL�U��/GAZ�j��T�9]Jw_*B����<��4_ta<�/b�#���^��b:4{�'�I��."c�#V�VJ�(O�$�V�ZO�z�q��Ѹu35���;菉BWv+�`�3d5�"���3n�?%����],�������o��Ů�g��+
S�Z�5#��4?҄��XLl��d볌�Ue�;�^��g���0���a�R�h_o�!�{1�&Z�~��p�EF�	8�V���++�P!�0H�]����Õh��jxÙ�0�������+g�-[3Ї�\��G��o�4�z.Y3��:[�O�|����)}��qP�����]��\#�O�X��FL���R֝�'�
F�t�ڬ�9�"�`cd�.�gN�z���T���w���5���}�BFkq=�E�v�$��EΩ(�\9&W?�����:��A?��`��c>��yH��ћM�[Z��/�w%���/�����`w�E�<���C��������i'����<�C�ȥ�v�(K�8W���,b���"�-n�jA�̙��$�H�wL1���8�>eyF�@�O��(���F�~tգ�&K�����8�jʤ�z%�M�����#��O`�m����o�����W�n<	�����Z&7�xU�u����`A�[�G�Mn#�[Pfo�\��7a����5Nn6� `	��9�Y٧&��:�ّa$�j��	ϼ�b"B��>��R��IW���(K�/�����)˶�-�=����"�-G���5��tP��8�m�>-����
�4V�j��P��E<-��W>Mc�u��ў.��)�&�e�O�fQfRjo�o��Q���+<m%AD�T{�(�6���<m&�c��i�4Rn��;�1h?:)��&�`��,)}Z)7;��JS�~ۧ�bl�[L���bl��.ٻ�4���ʺ��N1T<�`����blg=�m�Y\��ֆ�l7+�v����T�����}����l�a��r4v+[�wh�R��w+[��h~�N�Ɗ���eX�����݀�&'�tV���Q���b,�o��i�(�25��i�℡n^?�c9���f���6|~z�l��Oc��.��]x+7+���b
�Ɗ��H�z�E^�s5A��>KV��AL.]�³f�X�~h���TYY���Y�blb##t{�������z���F��~�gŊ��s��|3_7�Sx�̞����"���X_7�x�K�s�Y�bl)��;� J����f �d��$[��%�E+�F^?��;�nV�"�O;�n�oԩ��*���R��Sm�c��v��(�NMh�f;�nV���͞*�Jq\�t�%*�JX����7��Ɏ��5݃�wbl����
xz'�v��tUb�����߿���o64�M�bO�pY��f�"����B��5�%ɗ��n���+��׆����o�t�M��v�wa�O����K����4N��J�l�2{��NL�?�(�ވ�$$��p�Ik�"<�J��|�,�m�'�WoZ�ܳ�DaN�ò���q�,���X������f<L�-�{�l�N�G�����پ���9��c���x�E�>ۗ1#�{�������f��Yo�0)X�����l�+Me��gՉ�2��u�r��qZ!�u����p�%�^𳵻OK���4���g
����bgB�x:)7�y���"��I1��^�U�>�ei�������r�ȕH����I����ԡ���2XYR{��tE�x��n�7�N�͒va� ���r�l�����I,o�����׍�.��Ҿ�uRnǶ�j�uRn���r�f�n�������&���{w��\�:�uR�%��P��7�y	����r�b@%�S�����tI)��hG�{[�/�=4/�N�^�>�Q��.���?м�x�*Z��z+Nq�;�;�A��ڶ�ak�ܰ��.����٬�g�R�:��h�G)�v��پ��1rE����Q���J�0�g�7x�sk�s�Y�н�f�s��bk�����5�M��M�8Hՠ��)5%���EӴu`<ΉDk�QRNQ������:F㏲��n�Q����<�	�È��;-�H� ���a���a���ǤxPu��zd�U'_��|OU��e"�a����'�Lގă��_��x�u�}��� ��b\�(��O+�v�َ��os�c����`9iIv'��?�JQK���7nf�n�����io���g����q3�6����썛Y�KS��7&8h�8ݦ��o�g�o��p�p��?�ɳ�}�s���t��a��^��)�d�]���<ט+��/����,|]��eG��.Z�e�WJ{GX)#��z�)u��^%,�>�
r���'�:=�ˁ�|�u�e�q�^bQQ�u:�GMA�EX��|�Tq:�?j:������<Zػ?�-�-yJϚ���s:��YQ�n�4&<+Z$U_"�k -|	�c�8R�)��^�e��]�l���&quj[�rT�x�``Q���Z��\'h�[^��/kG%�9��:A��w���4�>|�3��x�D��-N��N|��y��u�&ϥ�vL嬫�iy�kQly~y���.g3=g�*Wv��)�cf���o�Om�b<�Cg[�q�f9�����|4�6��x<,3��E~��8g��~/cJr�-��P�|=�:��-�MS=ꊣ��q=�WvW��}�Q���3H=����d��"%9ה�n�F\$�]+�Ǻ�tO���d�=]QMȴ-��7s���JH����r{CtZ�x���"G��< ����܎T��=�b"����f�,��.c\8� ����DV6�.uPӶH�F�����Խ��8J	������s�h�3���79��m,�>��G-����G5��������<_�Q-ֹ>�·����χ�t�N��y�����|/�N����ᬯ��NRv���my�Y_�q�X`�`�{�[jUB���,p��숼�Hn3x�r�Y�q��x9t��5�)Uy>[�#;�f��I�nSvv� )  $���K�Q��G��s<��s������T&FX���_�mv��畧�o��|k�6��}�Zj��qȎ2�hj����X߁���/��Tx�wݛK�K�bD�?w.�xK��}�}���^oӒO�?��-J���3�����%V��@�w$f�p݉Nry_14P)~�����O�0�l�k3)�)�X�L����aI���2)�ib��u�mݕ]�i�K_��Ϸ�W\>O}�'4>\l}G����E�� ��O��h��Y灷f��T��qҍ͜�s�U�=}�Qc��U�P��ܛgg��8K�Z\��f���%��O��O�\��g�����Go��R� 5��t���G�s��[���5���H�:���Œ���s:e�VƳ���ݖ���O��8��ۻ����βk?-���d<J{�K�|^~c0�q=̕˛��7*X(�'~�K��Q+_M��8���\����X4R��Lׄ�<W_-Y�kB-|/K���".>g����f�$�������Rr=����e��������Ϲ�Xp#K���u�>��U}3��iy�͛����n���I-|Ge��Y5�_��h��J`>�b����&Ήز�m�'�-ne���7ZӒ�4a����f��i�-�!��|iK{|wJy�2���8���q�)9m��\1�5r��,8��X���NE΍�--��(kLrV�Z��,*�˸�G��XT�!"?I�m������;���ec��o�����7e�a����e�۳f�c|���۳f�M �����}ɓ�9˂]��;�Tra��~W5���q3��л��a�mR�̟��ބ����j����K$~`kj\�õK����JA��6{�U:v#���(��`�1�-qZ�
v����R��*�a��:��`K>�c���-u�MN����Wx.�����ɷj�!;�x���9�O�>���"��mb�]G9"��9������GZ�燳�r^�Xp�W�{���!&W�o5����Ѽg������Q;�d^;�ϯX���U�gi��٤u���oX��l�~�r���'WJp�b/��n���?+�gV���|����dK	�g3���t�d=3�Gne����7��-��<��L�̨�W��e>ޭ���Z4>���,���*r��H	y~��xr����	�!+��ڀ����G�܉�,��}!ԄsY��E���B� e�&��P˵�n5�§E������Э��<}��s�s����UN�X�����d]��HM�YA�a1��9d�/��y\�V�Z�x�o�8
��.ge�\�a�SX��
��;�rV�s�a�T�����5Q_���r��7?�YZ��B3��dGM~���dGM~��E�.j�[�(��E	ϗ5�\C4��O�\�,j�<R������_�b`=�;���[���|��Y���3�bY��Q�����VF�RX��ɉ�|[�vVW�n��xr�ߥ@�úVy+���5��FY��sn����YKxr���.���;�;��_�,���Ӓ⵳����Ro����<���
��J���-c޲����}+�)�ix��ne^��+up��Gpc\n����F7+iN�ֆm5���䆥l�ݦO��kg���������y��N�V��Qm���TE�➳�x��+�I8y�e�Q\�I��
r��R�P�Γ�i\��'���y������Z�*ڿux�8�8n��Ų)��,�����d�2N6ɝt]Oח�mG���������HY���a�涣���&|��g��5T�����ݜ��,��VZ��w��v���l��@es��Dy�r���l.;RV�Ŧ%�esّ�8&n{5O�$��?)���ɖ�ß��y��М���q�0esh.��()�C3z�X��S�>R��͡9e吒]@^6uM�����l�d=��=s��(�Cs���M��mG�6���w�t�r���bS�4X�ۙxEh����v&>v1�a��#e�y�^0P6�M6�!Z8V6�)�r�^�P6�)+�M���澣��q�+X�{�ml�����;x���+�˿)��p��ل����dc��i��v�l�T���]�߿�7_e�P      g   S   x��̱�0D�:7�:;21���s��@c!�����h��n���Z�f♀`��u�B��L�#�)���
ʊK ��!�      h   %  x�u��N�0�g�)�Rc|�/�JHtF�XȢ��cW�o�;o��mBC�������OQ3~���,�n�3H�X�
SI����]zɕ�%%���d�5}���q��GMt;_0��㇇�ߎ_��y�,,M���JhI�L���"G*'����:�T|W(�!�s���%Մ�n0Ӡ��O3"��x��W����yI�K]�I�������e��iX��'��r�I���y�۽�HsL��B��UV]�yg�C̼O(��\�}s��K� "0e�Z�}�#�2^e����4S�qQ?��?      j   �   x���ˑ� D�r0*�E��Ǳ��T�f.��P����c��~�����l�\� @������6-ߚ���b��c��	��g$A6`��mn�~U�F���+wfy����~8Ek��S��Փ��
P$�L
�:߹4%���B9`|f������߼�r�U�$���O�n@��ZYb�WXu3d�YD�u����_�
ro>E�����e�      l   �  x�eS�n�@<7_� ����J"KƲ�=�e&�D0C����aO�
���`�x�������������~�G� �=��
j/�	OJ���!�uU[�N�	�>�����f(�%[�﹖��,C�����눭����%u�]��ZN ��Auآ��+9������3j��$�S����(/&ר{�O_�pRd���PVn��n��!
b�c��_��� \�d6��H�(meʃh�'�S,x1T�_dF����(+�q���J{$ܠݟ�`欣�^�^BGH�|��2gy�qs#�\Ë�*y�
�I����P�_�i>���ݒbZ��7n���О��.���c+ p�N��e�<�xŜq	��.��х��k�o
��`J�~����Ð��2��p��+�V���)F,����W�vK��pĈF+��~c7^�J�0]�li����n7��D�����w�y���#}      n   �   x�3����K/�<�<Q!%U!9�(/U!���ڼDNC�`Nǒ̲|.#$UΉ9�IE�� y?��1g P�4�$���Ʉӱ "���)6C��7173/#f)B�)�o~PojN"���Ȧ*��![i�����Z����V��&���� >L�      p   �   x�uһN�0���a��I�td�������Ӌ�����~�$n������X��Ro?��ߛ�����5sN��>D�G��6񻶥6vn-�
���Ks:���%ƅ�CUj)��ē�'ƁG��cy�d}���Oq�T�9;�7�H����X��2�y?_$�������A��N�kw��=豚�]Y�G�L���������1hS�3^�m�V�oe      r   2   x�3��M,9��(3Q!�(37�ӱ$�,�ˈ�9?/%375�$*���� �M=      t   "   x�3�t��KO�IL��2�J-N+��c���� ��]      v   �  x��Vˎ�0<7%v��-s��Vs�KOl�����1���o����h'�E!UQ]�]�NX���6� gm��u��%�rĶ�q�v��w�o�X�(�!�����ͨ>�����h�<6A����I����C4��
���IP���Xw�&(�Q�v%.�kj�_jR��F�j���;+x���?���H�/!\�tғ)��=���f�[�%�L� 2�x��؞~6��^oA�@�;�6ڨ3��jr�Lϭ��Ku�QO��Ч����+��O��0ފn���6�ހQ�P@s�NVLԁL]���im=Q<�I�� � %��t��|*^C�NxH�~ҟ�XHnSi��=��/=�\���x����j����K���&r�G�j��D�ov��$�.�H6=p��>�F����[֮Y���Ng���+�5��tҫ�b��Q4ׂ�bRe������LmoV����8��/�w��fMW�Gk��
���f�
��ŀ     