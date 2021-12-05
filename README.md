# Desafio técnico GetNet

Esta projeto tem como objetivo atender ao desafio técnico solicitado pela empresa GetNet e disponibiliza uma API de cadastro de usuários.

# Requisitos

Para executar o projeto, será necessário instalar os seguintes programas:

 - [**OpenJDK-11-Jdk**] (#https://www.oracle.com/java/technologies/downloads/#java11)
 - [**IDE IntelliJ**] para desenvolvimento do projeto (#https://www.jetbrains.com/idea/download/#section=linux)
 - [**Maven**] para realizar o build do projeto Java (#https://maven.apache.org/install.html)
 
### Construção do projeto

+ Para realizar o Build do projeto, realizar o comando abaixo na pasta /GetNet/UserGetNet:
  
  + |` mvn clean install `|
  
  O comando irá baixar todas as dependências do projeto e criar um diretório target com os artefatos construídos, que incluem o arquivo jar do projeto. Além  disso, serão executados os testes unitários, e se algum falhar, o Maven exibirá essa informação no console.
 	

### Instruções para rodar a api
 
 + Pelo terminal, acessar a pasta GetNet/UserGetNet/target e digitar o seguinte comando:
 
    + |` java -jar UserGetNet-0.0.1-SNAPSHOT.jar `|
 		
 + Será disponibilizado a porta 8080 para a Api, que pode ser acessada pelo Navegador através do endereço:
 	
    + |` localhost:8080/ `|
  
### Publicação
  
+ A Api está publicada em Cloud AWS; Através da url abaixo é possível verificar seu funcionamento:
  
  + |` http://ec2-54-211-213-172.compute-1.amazonaws.com:8080/swagger-ui/index.html#/Usu%C3%A1rios%20Getnet `|
  
# Recursos disponíveis para acesso via API:

  | Método | Descrição |
  | --- | --- |
  | `POST` | `Cadastro de Usuários` |
  |` GET `| `Consulta de usuários por Id` |
  |` GET `| `Listagem de usuários` |
  |` GET `| `Filtro de pesquisa de usuários por nome.` |
  |` PUT `| `Atualização cadastral de usuários` |


## Cadastro de Usuários [POST /Users]

O password deve seguir os parâmetros conforme listado no início deste documento.

+ Request (JSON)
  
  + Body
  
      {
          "name": "string",
          "password": "string",
          "email": "string"
      }
      
+ Response 200 (OK)

## Consulta de Usuários por Id [GET /Users/{id}]

+ Request (application/json)

+ Response 200 (application/json)

    + Body
  
      {
          "Id": "1",
          "name": "String",
          "password": "String",
          "email": "String"
      }
+ Response 404 (application/json)

    Quando o registro não for encontrado.

## Listagem de Usuários [GET /Users]

+ Request (application/json)

+ Response 200 (application/json)

    + Body
  
      [{
          "Id": "1",
          "name": "String",
          "password": "String",
          "email": "String"
      }]

## Filtro de pesquisa de usuários por nome [GET /Users/filter/{name}]

+ Request (application/json)

+ Response 200 (application/json)

    + Body
  
      [{
          "Id": "1",
          "name": "String",
          "password": "String",
          "email": "String"
      }]

## Editar (update) [PUT /Users/{id}]

+ Request (application/json)

    + Body

          [{
              "name": "String",
              "password": "String",
              "email": "String"
          }]

+ Response 200 (application/json)

    + Body
  
          [{
              "Id": "1",
              "name": "String",
              "password": "String",
              "email": "String"
          }]


## Respostas das requisições

| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success).|
| `404` | Registro pesquisado não encontrado (Not found).|
 
 
# Desenho da API (OAS)

+ O arquivo referente ao desenho da API está disponível na pasta:
  
  + |` /GetNet/UserGetNet/UsersGetNet_OAS.yaml `|

# Collection Postman

+ O arquivo JSON para importação no Postman está disponível na pasta:
  
  + |` /GetNet/UserGetNet/Users GetNet.postman_collection.json `|

# Dockerfile/Docker compose

+ Os arquivos Dockerfile e Docker-Compose estão disposíveis nos seguintes caminhos:
  
  + |` /GetNet/UserGetNet/Dockerfile `|
  + |` /GetNet/UserGetNet/docker-compose.yml `|

# API em Cloud (AWS)
  
Esta API está disponível na AWS através do endereço abaixo:
  
  + |` http://ec2-54-211-213-172.compute-1.amazonaws.com:8080/swagger-ui/ `|
