create database siga_bd;
use siga_bd;

create table empresa (
	id_empresa int primary key,
    nome_empresa varchar(150) not null,
    tipo_empresa enum('requisitante', 'fornecedor') not null,
    email varchar(100),
    CNPJ varchar(20) not null,
    senha varchar(10) not null
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
    cargo varchar(100) not null,
    email varchar(100),
    id_empresa_fk int,
	senha varchar(10),
     constraint fk_funcionario_empresa
		foreign key(id_empresa_fk) references empresa(id_empresa)
         on delete set null
);

create table pedido (
	id_pedido int primary key,
    id_requisitante int not null,
    id_funcionario int not null,
    data_pedido date not null,
    status enum('Empacotando', 'Enviado','Entregue') not null,
    total_pedido int not null,
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

INSERT INTO empresa VALUES
(1, 'Alpha Supplies', 'fornecedor', 'contato@alpha.com', '12.345.678/0001-11', 'alpha123'),
(2, 'Beta Logistics', 'requisitante', 'logistica@beta.com', '98.765.432/0001-99', 'beta321'),
(3, 'Gama Tools', 'fornecedor', 'vendas@gama.com', '11.222.333/0001-00', 'gama456'),
(4, 'Delta Tech', 'requisitante', 'ti@delta.com', '44.555.666/0001-22', 'delta789'),
(5, 'Epsilon Parts', 'fornecedor', 'suporte@epsilon.com', '77.888.999/0001-33', 'eps12345');
INSERT INTO produto VALUES
(101, 'Teclado USB', 1, 150, 120),
(102, 'Mouse Óptico', 3, 200, 60),
(103, 'Monitor 24"', 1, 80, 800),
(104, 'Fonte ATX 500W', 5, 120, 230),
(105, 'HD SSD 240GB', 3, 95, 290);
INSERT INTO funcionario VALUES
(201, 'Lucas Mendes', 'Almoxarife', 'lucas@beta.com', 2, 'lucas123'),
(202, 'Ana Souza', 'TI', 'ana@delta.com', 4, 'ana456'),
(203, 'Marcos Lima', 'Compras', 'marcos@beta.com', 2, 'marc789'),
(204, 'Patrícia Silva', 'Gestão', 'patricia@delta.com', 4, 'patr123'),
(205, 'Fernanda Dias', 'Recebimento', 'fernanda@beta.com', 2, 'fern000');
INSERT INTO pedido VALUES
(301, 2, 201, '2025-07-01', 'Empacotando', 500),
(302, 4, 202, '2025-07-03', 'Enviado', 980),
(303, 2, 203, '2025-07-04', 'Entregue', 180),
(304, 4, 204, '2025-07-05', 'Enviado', 370),
(305, 2, 205, '2025-07-06', 'Empacotando', 240);
INSERT INTO itensPedido VALUES
(301, 101, 2),
(301, 102, 5),
(302, 103, 1),
(303, 105, 2),
(304, 104, 1);





