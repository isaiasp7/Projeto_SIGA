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
    preco INT NOT NULL,
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
(1, 'TechFornece Ltda', 'fornecedor', 'OrgTechForneceLtda241937@gmail.com', '12345678000101'),
(2, 'Alimentos Bons S/A', 'fornecedor', 'OrgAlimentosBonsSA857104@gmail.com', '23456789000102'),
(3, 'Construreq LTDA', 'requisitante', 'OrgConstrureqLTDA769311@gmail.com', '34567890000103'),
(4, 'Oficina Requintada', 'requisitante', 'OrgOficinaRequintada322510@gmail.com', '45678900000104'),
(5, 'ServFácil Forn', 'fornecedor', 'OrgServFácilForn617288@gmail.com', '56789000000105');

INSERT INTO produto VALUES
(1, 'Parafuso 12mm', 1, 500),
(2, 'Cimento CP-II', 2, 300),
(3, 'Furadeira Bosch', 5, 150),
(4, 'Tinta Acrílica 18L', 1, 200),
(5, 'Chave de Fenda', 5, 100);
INSERT INTO funcionario VALUES
(1, 'João Martins', 'Engenheiro Civil', 'EmpregJoãoMartins782041@gmail.com', 3),
(2, 'Ana Clara', 'Compradora', 'EmpregAnaClara324507@gmail.com', 4),
(3, 'Carlos Silva', 'Técnico de Obras', 'EmpregCarlosSilva915622@gmail.com', 3),
(4, 'Maria Souza', 'Gerente de Suprimentos', 'EmpregMariaSouza431005@gmail.com', 4),
(5, 'Pedro Lopes', 'Auxiliar de Compras', 'EmpregPedroLopes628390@gmail.com', 3);


INSERT INTO pedido VALUES
(1, 3, 1),
(2, 4, 2),
(3, 3, 5),
(4, 4, 4),
(5, 3, 3);
INSERT INTO itensPedido VALUES
(1, 1, 100),
(1, 2, 50),
(2, 3, 2),
(3, 4, 5),
(4, 5, 10);


