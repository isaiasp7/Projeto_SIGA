create database siga_bd;
use siga_bd;

create table empresa (
	id_empresa int primary key,
    nome_empresa varchar(150) not null,
    tipo_empresa enum('requisitante', 'fornecedor') not null,
    email varchar(100),
    CNPJ varchar(20) not null
);


create table produto (
	id_prod int primary key,
    nome_prod varchar(100) not null,
    id_fornecedor int,
    quant_disponivel int not null,
    
    constraint fk_produto_empresa
		foreign key (id_fornecedor) references empresa (id_empresa)
        on delete set null
);

create table funcionario (
	id_func int primary key,
    nome_func varchar(100) not null,
    cargo varchar(100) not null,
    email varchar(100),
    id_empresa_fk int,
     constraint fk_funcionario_empresa
		foreign key(id_empresa_fk) references empresa(id_empresa)
         on delete set null
);

create table pedido (
	id_pedido int primary key,
    id_requisitante int not null,
    id_funcionario int not null,
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

