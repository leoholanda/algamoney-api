CREATE TABLE IF NOT EXISTS categoria (
    codigo bigserial NOT NULL, 
    nome VARCHAR(50) NOT NULL, 
    primary key(codigo)
);

INSERT INTO categoria (nome) values ('Lazer');
INSERT INTO categoria (nome) values ('Alimentação');
INSERT INTO categoria (nome) values ('Supermercado');
INSERT INTO categoria (nome) values ('Farmácia');
INSERT INTO categoria (nome) values ('Outros');
