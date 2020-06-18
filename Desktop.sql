CREATE DATABASE projeto_web;
USE projeto_web;
CREATE TABLE clientes(
	cpf VARCHAR(14) PRIMARY KEY,
    nome VARCHAR(40) NOT NULL,
    nascimento DATE
);

select * from clientes;