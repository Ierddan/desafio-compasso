# Desafio Compasso

Api de cadastro de clientes e cidades

## Execução

Utilizado Mysql como db. Porta padrão, schema - world.

spring.datasource.url = jdbc:mysql://localhost:3306/world?useTimezone=true&serverTimezone=UTC

Ajustar username e password de acordo com ambiente.

spring.datasource.username = root
spring.datasource.password = root

##Apoio

* Query para verificar clientes e suas respectivas cidades:

SELECT ct.id,
       ct.full_name,
	     ct.birth_date,
       ct.age,
       ct.genre,
       c.name as city,
       c.state
from world.client ct
INNER JOIN world.city c
	ON c.id = ct.city_id
  
* Pacote de requisições com exemplos realizados no postman.

Desafio-Compasso.postman_collection.json


