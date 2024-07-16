criar nova classe - alt + insert
atualizar dependencias do maven - ctrl + shift + o
alterar o nome de uma classe - shift + F6
limpar os imports - ctrl + alt + o

Docker MySql

docker pull mysql:8.0.35-oracle

docker run --name jpaexp -e MYSQL_ROOT_PASSWORD=123 -e MYSQL_DATABASE=jpa-exp -d -p 33060:3306 mysql:8.0.35-oracle



MySQL consulta

mysql -u root -p <db-name>
select * from Produto;
