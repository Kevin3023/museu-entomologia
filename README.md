# API do museu de entomologia da UFRA - Universidade Federal Rural da Amazônia
> Listagem, pesquisa, cadastro e edição de insetos

Este projeto utiliza um banco de dados postgresql para armazenar as informações dos insetos, tal como espécie, filo, ordem, classe, tipos de perna e etc.
Assim como também fornece a função de CRUD para cada uma das classes existentes no projeto (espécie, filo, etc.)

## Documentação
Ao rodar o projeto acesse http://localhost:8080/swagger-ui.html para obter a documentação da API


## Exemplo de uso

* Visualizar curiosidades de diversas espécies cadastradas no banco de dados

* Pesquisar insetos por nome

* Cadastrar novos insetos e características morfológicas

* Atualizar insetos ou características morfológicas

* Deletar insetos ou características existentes


## Ambiente de Desenvolvimento

Para rodar este projeto localmente é necessário:
1. Intellij, STS ou qualquer outra IDE que rode projetos Spring Boot
2. Postman, navegador web ou qualquer outra ferramenta REST Client para visualizar ou testar as rotas existentes na API
3. JDK 11 instalado

Faça clone deste repositório na pasta de sua preferência, depois abra o projeto utilziando a sua IDE. Modifique o arquivo arquivo application.properties mudando a linha 4 para spring.profiles.active=test e em seguida inicie o projeto

Exemplo de rota:
http://localhost:8080/filos

## Arquivos importantes

No caminho src/main/java/com/ufra/edu/museu/resources
estão localizados os arquivos nos quais contem as rotas de cada uma das classes existentes no banco de dados do museu, tanto para as opções de CRUD, como para as consultas personalizadas

Este projeto usa uma arquiterura Resources, Services e Repository

As configurações do banco de dados local e também do host da API do banco estão no arquivo application.properties

No caminho src/main/resources está o arquivo application.properties. Nele é possível escolher em qual ambiente você deseja rodar o projeto (test, dev ou prod). Para modificar o ambiente, basta mudar o valor depois do sinal de igual em spring.profiles.active=prod

O ambiente de prod irá rodar o projeto com o banco de dados da nuvem. 

Já o ambiente de dev irá rodar o projeto com um banco de dados postgresql local (É necessário criar um banco de dados local no postgresql com o nome de schema museu)

Já no ambiente de test. A API ira criar um banco de dados em memória (banco h2) que pode ser acessado em http://localhost:8080/h2-console e irá gerar automaticamente as tabelas e as relações no banco de dados.

## Meta

Kevin Gomes - kevin.gomes2309@gmail.com

