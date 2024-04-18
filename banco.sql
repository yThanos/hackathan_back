CREATE TABLE Usuarios (
    UsuarioId INT PRIMARY KEY AUTO_INCREMENT,
    NomeCompleto VARCHAR(60),
    UsuarioApelido VARCHAR(30) UNIQUE,
    UsuarioEmail VARCHAR(60) UNIQUE,
    UsuarioSenha VARCHAR(60),
    UsuarioNascimento DATE,
    UsuarioCidade VARCHAR(60),
    UsuarioEstado VARCHAR(2),
    QtdPontos INT,
    IdentOrigemEtnica VARCHAR(30),
    IdentGenero VARCHAR(30),
    IdentFiliacaoReligiosa VARCHAR(30)
)

CREATE TABLE Obras (
    CodReferencia VARCHAR(30) PRIMARY KEY,
    Tipo VARCHAR(30),
    Nome VARCHAR(60),
    LocalCriacao VARCHAR(60),
    DataCriacao DATE,
    Descricao TEXT,
    MarcadoresSociaisDeDiferenca TEXT
)
