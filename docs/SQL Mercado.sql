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

insert into funcionario(cpf, nome, senha, rua, numero, bairro, cidade, estado, cep, telefone, privilegio)
	values('12312312312', 'Matheus F. Nascimento', 'b3ddbc502e307665f346cbd6e52cc10d', 'Rua1', 123, 'Itaquera', 'São Paulo',
						'SP', 08240660, '11981116773', 2)

insert into funcionario(cpf, nome, senha, rua, numero, bairro, cidade, estado, cep, telefone, privilegio)
	values('32132132132', 'Evandson S. Cruz', 'c4df13cad905bbff4cfd811606745cd8', 'Rua2', 321, 'Itaqua', 'São Paulo',
						'SP', 32132132, '11321321321', 0)

create table produto(
	codigo_barras varchar(50) not null,
	nome varchar(50) not null,
	categoria int not null default(0),
	preco decimal(7,2) not null check(preco > 0),
	qtde_estoque int not null,
	descricao varchar(max),
	primary key (codigo_barras)
)

insert into produto(codigo_barras, nome, categoria, preco, qtde_estoque, descricao) 
values('0001', 'Arroz Prato Fino 10kg', 5, 15.99, 50, 'Soltinho igual o Veigar do Scalibacon')

insert into produto(codigo_barras, nome, categoria, preco, qtde_estoque, descricao) 
values('0002', 'Papel Alumínio 10m', 8, 7.50, 50, 'Platinado e resistente')

insert into produto(codigo_barras, nome, categoria, preco, qtde_estoque, descricao) 
values('0003', 'Max Steel Boxeador', 12, 24.99, 34, 'Criado pra dar muitos socos nos Elementors')

insert into produto(codigo_barras, nome, categoria, preco, qtde_estoque, descricao) 
values('0004', 'Queijo Mussarela', 5, 26.95, 50, 'Gostoso e bem amarelinho')

insert into produto(codigo_barras, nome, categoria, preco, qtde_estoque, descricao) 
values('0005', 'Papel Higiênico Neve 12', 4, 13.99, 38, 'Bem macio, perfeito pra dar aquela garibada nos glúteos')

create table venda(
	id int identity(1,1) not null,
	dataCompra datetime not null,
	situacao int not null default(0),
	total decimal(7,2) not null check(total > 0),
	funcionario_cpf char(11) not null,
	primary key (id),
	foreign key (funcionario_cpf) references funcionario(cpf)
)

insert into venda(dataCompra, situacao, total, funcionario_cpf)
values('2019/05/15', 0, 105, 12312312312)

select v.id, v.dataCompra, v.situacao, v.total, f.nome
from venda v
inner join funcionario f
on v.funcionario_cpf = f.cpf

create table itemvenda(
	venda_id int not null,
	produto_codigo_barras varchar(50) not null,
	qtde_produto int not null default(1) check(qtde_produto > 0),
	subtotal decimal(7,2) not null,
	primary key (venda_id, produto_codigo_barras),
	foreign key (venda_id) references venda(id),
	foreign key (produto_codigo_barras) references produto(codigo_barras)
)

insert into itemvenda(venda_id, produto_codigo_barras, qtde_produto, subtotal) 
	values (1, '0003', 3, 12)
	insert into itemvenda(venda_id, produto_codigo_barras, qtde_produto, subtotal) 
	values (6, '0006', 1, 13)

SELECT iv.produto_codigo_barras, iv.qtde_produto, iv.subtotal, p.nome 
					FROM itemvenda iv INNER JOIN produto p 
					ON iv.produto_codigo_barras = p.codigo_barras 
					WHERE iv.venda_id = 1

create table alteracaoestoque(
	id int identity(1,1) not null,
	data_alter datetime not null, 
	tipo int not null default(1),
	quantidade int not null check(quantidade > 0),
	funcionario_cpf char(11) not null,
	produto_codigo_barras varchar(50) not null,
	descricao varchar(255),
	primary key (id),
	foreign key (funcionario_cpf) references funcionario(cpf),
	foreign key (produto_codigo_barras) references produto(codigo_barras)
)

insert into alteracaoestoque(data_alter, tipo, quantidade, funcionario_cpf, produto_codigo_barras, descricao)
	values(getdate(), 0, 25, '12312312312', '0003', null)

select ae.data_alter, ae.tipo, ae.quantidade, f.nome, p.nome
from alteracaoestoque ae
inner join funcionario f
on ae.funcionario_cpf = f.cpf
inner join produto p
on ae.produto_codigo_barras = p.codigo_barras

select * from produto
select * from venda
select * from itemvenda
select * from alteracaoestoque


SET DATEFORMAT ymd; 
select top 5 p.codigo_barras, p.nome, count(v.id) as vezes_comprado, sum(iv.qtde_produto) as qtde_comprada
from produto p
inner join itemvenda iv
on p.codigo_barras = iv.produto_codigo_barras
inner join venda v
on iv.venda_id = v.id
where v.dataCompra between '2019/05/10' and '2019/05/15' 
group by p.codigo_barras, p.nome
order by qtde_comprada asc, p.nome asc