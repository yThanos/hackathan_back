CREATE TABLE ITEM (
    COD_REFERENCIA VARCHAR(255) PRIMARY KEY,
    ID_ITEM INTEGER,
    TIPO_ITEM VARCHAR(20)
)

CREATE TABLE USUARIO (
    ID_USUARIO SERIAL PRIMARY KEY,
    NOME VARCHAR(60),
    APELIDO VARCHAR(30),
    EMAIL VARCHAR(60),
    SENHA VARCHAR(60),
    DATA_NASCIMENTO DATE,
    ESTADO VARCHAR(2),
    CIDADE VARCHAR(60),
    QTD_PONTOS INTEGER,
    ETNIA VARCHAR(60),
    GENERO VARCHAR(60),
    RELIGIAO VARCHAR(60),
    IS_ADMIN BOOLEAN
)

CREATE TABLE SUBMISSAO (
    ID_SUBMISSAO SERIAL PRIMARY KEY,
    ID_ITEM INTEGER,
    ID_USUARIO INTEGER,
    DATA_SUBMISSAO TIMESTAMP,
    TITULO VARCHAR(60),
    DATAS VARCHAR(60),
    CONTENT TEXT,
    APROVADA BOOLEAN,
    FOREIGN KEY (ID_ITEM) REFERENCES ITEM(ID_ITEM),
    FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO)
)

CREATE TABLE PONTOS_ACESSO (
    ID_PONTOS_ACESSO SERIAL PRIMARY KEY,
    DESCR_PONTO VARCHAR(60),
    INDICE_PONTO INTEGER
)

CREATE TABLE PONTOS_ACESSO_SUBMISSAO (
    ID_PONTOS_ACESSO_SUBMISSAO SERIAL PRIMARY KEY,
    ID_PONTOS_ACESSO INTEGER,
    ID_SUBMISSAO INTEGER,
    FOREIGN KEY (ID_PONTOS_ACESSO) REFERENCES PONTOS_ACESSO(ID_PONTOS_ACESSO),
    FOREIGN KEY (ID_SUBMISSAO) REFERENCES SUBMISSAO(ID_SUBMISSAO)
)