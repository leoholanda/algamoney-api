CREATE TABLE IF NOT EXISTS pessoa (
    codigo bigserial NOT NULL, 
    nome VARCHAR(50) NOT NULL,
    ativo boolean,
    logradouro VARCHAR(100),
    numero VARCHAR(5),
    complemento VARCHAR(40),
    bairro VARCHAR(40),
    cep VARCHAR(9),
    cidade VARCHAR(30),
    estado VARCHAR(2),
    primary key(codigo)
);
