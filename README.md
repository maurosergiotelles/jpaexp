criar nova classe - alt + insert
atualizar dependencias do maven - ctrl + shift + o
alterar o nome de uma classe - shift + F6
limpar os imports - ctrl + alt + o

Docker MySql

docker pull mysql:8.0.35-oracle

`docker run --name jpaexp -e MYSQL_ROOT_PASSWORD=123 -e MYSQL_DATABASE=jpa-exp -d -p 33060:3306 mysql:8.0.35-oracle --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci`



MySQL consulta

https://www.dagmartimler.com/utf-8-encoding-in-a-mysql-database/

mysql -u root -p <db-name>
select * from Produto;

SELECT @@character_set_database, @@collation_database;
show variables like 'char%';
