drop database spaceimt;
create database spaceimt;
use spaceimt;
CREATE TABLE usuario (
    idUsuario INTEGER PRIMARY KEY AUTO_INCREMENT,
    senha VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    nickname VARCHAR(30) UNIQUE NOT NULL,
    tipo BOOL DEFAULT FALSE,
    numeroFase INTEGER DEFAULT 0
);
insert into usuario (senha, email, nickname, tipo) values ('123', 'adm@maua.br', 'adm',true);
CREATE TABLE conquista (
    idConquista INTEGER PRIMARY KEY AUTO_INCREMENT,
    dadoConquista INTEGER NOT NULL,
    tipoConquista BOOL NOT NULL,
    tituloConquista VARCHAR(50) NOT NULL,
    descricaoConquista VARCHAR(50) NOT NULL
);
CREATE TABLE questao (
    idQuestao INTEGER PRIMARY KEY AUTO_INCREMENT,
    alt1 VARCHAR(50) DEFAULT 'Sem alternativa 1',
    alt2 VARCHAR(50) DEFAULT 'Sem alternativa 2',
    alt3 VARCHAR(50) DEFAULT 'Sem alternativa 3',
    altCorreta VARCHAR(50) DEFAULT 'Sem alternativa correta',
    pergunta VARCHAR(50) DEFAULT 'Sem pergunta',
    dificuldade INTEGER DEFAULT 0
);
CREATE TABLE usuarioConquista (
    idUsuario INTEGER NOT NULL AUTO_INCREMENT,
    idConquista INTEGER NOT NULL,
    FOREIGN KEY (idUsuario)
        REFERENCES usuario (idUsuario),
    FOREIGN KEY (idConquista)
        REFERENCES conquista (idConquista),
    PRIMARY KEY (idUsuario , idConquista)
);