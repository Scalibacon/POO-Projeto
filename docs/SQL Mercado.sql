create database mercadopoo
use mercadopoo

create table funcionario(
	cpf char(11) not null,
	nome varchar(50) not null,
	senha varchar(50) not null,
	rua varchar(50),
	numero int,
	bairro varchar(50),
	cidade varchar(50),
	estado varchar(50),
	cep char(8),
	telefone varchar(11),
	privilegio int default(0),
	primary key (cpf)
)

create table produto(
	codigo_barras varchar(50) not null,
	nome varchar(50) not null,
	categoria int not null default(0),
	preco decimal(7,2) not null check(preco > 0),
	qtde_estoque int not null check(qtde_estoque >= 0),
	descricao varchar(max),
	primary key (codigo_barras)
)

create table venda(
	id int identity(1,1) not null,
	data datetime not null,
	situacao int not null default(1),
	total decimal(7,2) not null check(total > 0),
	funcionario_cpf char(11) not null,
	primary key (id),
	foreign key (funcionario_cpf) references funcionario(cpf)
)

create table itemvenda(
	venda_id int not null,
	produto_codigo_barras varchar(50) not null,
	qtde_produto int not null default(1) check(qtde_produto > 0),
	subtotal decimal(7,2) not null,
	primary key (venda_id, produto_codigo_barras),
	foreign key (venda_id) references venda(id),
	foreign key (produto_codigo_barras) references produto(codigo_barras)
)

create table alteracaoestoque(
	id int identity(1,1) not null,
	data datetime not null, 
	tipo int not null default(1),
	quantidade int not null check(quantidade > 0),
	funcionario_cpf char(11) not null,
	produto_codigo_barras varchar(50) not null,
	primary key (id),
	foreign key (funcionario_cpf) references funcionario(cpf),
	foreign key (produto_codigo_barras) references produto(codigo_barras)
)



