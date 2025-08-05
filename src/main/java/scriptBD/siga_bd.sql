create database siga_bd;
use siga_bd;

create table empresa (
	id_empresa int primary key,
    nome_empresa varchar(150) not null,
  tipo_empresa enum('Requisitante', 'Fornecedor') not null,
    email varchar(100),
    CNPJ char(14) not null unique,
    senha varchar(15) not null
);

CREATE TABLE produto (
    id_prod INT PRIMARY KEY,
    nome_prod VARCHAR(100) NOT NULL,
    id_fornecedor_fk INT NOT NULL,
    quant_disponivel INT NOT NULL,
   preco DOUBLE NOT NULL,
    CONSTRAINT fk_produto_empresa
        FOREIGN KEY (id_fornecedor_fk)
        REFERENCES empresa(id_empresa)
        ON DELETE CASCADE
);



create table funcionario (
	id_func int primary key,
    nome_func varchar(100) not null,
   cargo enum('Funcionario', 'Gerente') not null,
    email varchar(100),
	senha varchar(15) not null,
   CPF char(11) not null unique
);

create table pedido (
	id_pedido int primary key,
    id_requisitante int not null,
    id_funcionario int,
    data_pedido date not null,
 status enum('Pendente','Recusado','Aprovado','Empacotando', 'Enviado','Entregue') not null,
   total_pedido decimal(7,2) not null,
    constraint fk_pedido_empresa
		foreign key (id_requisitante) references empresa (id_empresa)
        on delete cascade,
	constraint fk_pedido_funcionario 
		foreign key (id_funcionario) references funcionario (id_func)
        on delete cascade
   
	
);


create table itensPedido (
	idPedido_fk int not null,
    idProduto_fk int not null,
    quantidade int not null,
    primary key (idPedido_fk, idProduto_fk),
    
    constraint fk_itensPedido_produto
		foreign key (idProduto_fk) references produto (id_prod)
		on delete cascade,
	constraint fk_itensPedido_pedido
		foreign key (idPedido_fk) references pedido (id_pedido)
		on delete cascade
);


-- Fornecedores
INSERT INTO empresa (id_empresa, nome_empresa, tipo_empresa, email, CNPJ, senha) VALUES
(1, 'Mega Fornecimentos Ltda', 'Fornecedor', 'contato@megafornecimentos.com', '12345678000101', 'senha123'),
(2, 'Distribuidora Comercial SA', 'Fornecedor', 'vendas@distribuidoracomercial.com', '12345678000102', 'senha123'),
(3, 'Atacadão dos Produtos', 'Fornecedor', 'atendimento@atacadaoprodutos.com', '12345678000103', 'senha123'),
(4, 'Indústria ABC Ltda', 'Fornecedor', 'industriaabc@abc.com', '12345678000104', 'senha123'),
(5, 'Fornecedora Nacional', 'Fornecedor', 'contato@fornecedoranacional.com', '12345678000105', 'senha123');

-- Requisitantes
INSERT INTO empresa (id_empresa, nome_empresa, tipo_empresa, email, CNPJ, senha) VALUES
(6, 'Comércio e Varejo Ltda', 'Requisitante', 'compras@varejo.com', '12345678000106', 'senha123'),
(7, 'Supermercados Bom Preço', 'Requisitante', 'suporte@bompreco.com', '12345678000107', 'senha123'),
(8, 'Lojas Renner SA', 'Requisitante', 'compras@renner.com', '12345678000108', 'senha123'),
(9, 'Restaurante Sabor Caseiro', 'Requisitante', 'contato@saborcaseiro.com', '12345678000109', 'senha123'),
(10, 'Hotel Luxo e Conforto', 'Requisitante', 'almoxarifado@luxoeconforto.com', '12345678000110', 'senha123');

INSERT INTO produto (id_prod, nome_prod, id_fornecedor_fk, quant_disponivel, preco) VALUES
(1, 'Notebook Dell i7', 1, 50, 4500.00),
(2, 'Mouse sem fio', 1, 200, 89.90),
(3, 'Teclado mecânico', 2, 150, 249.90),
(4, 'Monitor 24 polegadas', 2, 80, 899.00),
(5, 'Cadeira ergonômica', 3, 120, 1250.00),
(6, 'Mesa para escritório', 3, 60, 850.00),
(7, 'Ar condicionado 12.000 BTUs', 4, 30, 2199.00),
(8, 'Ventilador de teto', 4, 180, 199.90),
(9, 'Luminária de mesa LED', 5, 250, 79.90),
(10, 'Filtro de água', 5, 300, 129.00);

INSERT INTO funcionario (id_func, nome_func, cargo, email, senha, CPF) VALUES
(1, 'João Silva', 'Gerente', 'joao.silva@empresa.com', 'senha123', '12345678901'),
(2, 'Maria Santos', 'Funcionario', 'maria.santos@empresa.com', 'senha123', '12345678902'),
(3, 'Carlos Oliveira', 'Funcionario', 'carlos.oliveira@empresa.com', 'senha123', '12345678903'),
(4, 'Ana Pereira', 'Gerente', 'ana.pereira@empresa.com', 'senha123', '12345678904'),
(5, 'Pedro Costa', 'Funcionario', 'pedro.costa@empresa.com', 'senha123', '12345678905'),
(6, 'Juliana Almeida', 'Funcionario', 'juliana.almeida@empresa.com', 'senha123', '12345678906'),
(7, 'Marcos Souza', 'Gerente', 'marcos.souza@empresa.com', 'senha123', '12345678907'),
(8, 'Fernanda Lima', 'Funcionario', 'fernanda.lima@empresa.com', 'senha123', '12345678908'),
(9, 'Ricardo Gomes', 'Funcionario', 'ricardo.gomes@empresa.com', 'senha123', '12345678909'),
(10, 'Patrícia Rocha', 'Gerente', 'patricia.rocha@empresa.com', 'senha123', '12345678910');

INSERT INTO pedido (id_pedido, id_requisitante, id_funcionario, data_pedido, status, total_pedido) VALUES
(1, 6, 2, '2023-01-15', 'Entregue', 4590.00),
(2, 7, 3, '2023-01-18', 'Enviado', 249.90),
(3, 8, 5, '2023-02-05', 'Aprovado', 2100.00),
(4, 9, 6, '2023-02-10', 'Pendente', 129.00),
(5, 10, 8, '2023-02-15', 'Empacotando', 899.00),
(6, 6, 2, '2023-02-20', 'Recusado', 179.80),
(7, 7, 3, '2023-03-01', 'Entregue', 2199.00),
(8, 8, 5, '2023-03-05', 'Enviado', 1250.00),
(9, 9, 6, '2023-03-10', 'Aprovado', 850.00),
(10, 10, 8, '2023-03-15', 'Pendente', 399.80);

INSERT INTO itensPedido (idPedido_fk, idProduto_fk, quantidade) VALUES
(1, 1, 1),
(1, 2, 1),
(2, 3, 1),
(3, 7, 1),
(4, 10, 1),
(5, 4, 1),
(6, 2, 2),
(7, 7, 1),
(8, 5, 1),
(9, 6, 1),
(10, 2, 1),
(10, 9, 2);




