insert into produto (nome, preco, descricao) values ('Kindle', 499.0, 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into produto (nome, preco, descricao) values ('Câmera GoPro Hero 7', 1400.0, 'Desempenho 2x melhor.');

insert into cliente (nome, sexo) values ('Juracy', 'FEMININO');
insert into cliente (nome, sexo) values ('Mauro', 'MASCULINO');
insert into cliente (nome, sexo) values ('Beatriz', 'FEMININO');
insert into cliente (nome, sexo) values ('Heitor', 'MASCULINO');

insert into pedido (cliente_id, data_criacao, total, status) values (1, sysdate(), 100.0, 'AGUARDANDO');

insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 5.0, 2);

insert into categoria(nome) values ('Eletronicos');