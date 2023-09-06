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

INSERT INTO pessoa(codigo, nome, ativo, logradouro, numero, bairro, cep, cidade, estado) VALUES(1, 'James Rodrigues', true, 'Av Brasil', 100, 'Tubalina', '77.400-12', 'Porto Alegre', 'RS');
INSERT INTO pessoa(codigo, nome, ativo, logradouro, numero, bairro, cep, cidade, estado) VALUES(2, 'Joana Dark', true, 'Rua Rocha', 321, 'Centro', '77.430-00', 'Porto Alegre', 'RS');