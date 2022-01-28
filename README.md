# Blog do Éde - Backend

Esse repositório é uma implementação de API REST utilizando o MySQL e o Spring Boot para o projeto de Blog Pessoal do Bootcamp Generation.

## Especificações

- Spring Boot 2.6.2
- OpenJDK 17
- Maven 3.8.1
- MySQL Server 8.0.27

## Modelagem

A modelagem do banco de dados foi feita como parte dos exercócios de MySQL do Bootcamp e está documentada [neste repositório](https://github.com/oieusouoede/generation-bootcamp-mysql), mas basicamente possui três tabelas seguindo um modelo simples de rede social. As tabelas são tb_tema, tb_postagem e tb_usuario, conforme o diagrama abaixo:

![DER blogdoede](https://github.com/oieusouoede/generation-bootcamp-mysql/blob/main/Blog%20Pessoal/DER%20db_blogdoede.png "DER Blogdoede")

## Arquitetura

Esse projeto segue o padrão MVC e está distribuído em pacotes conforme a imagem abaixo:

![Camadas do projeto](/docs/screenshots/packages.png)

- *Controller:* Contém as classes referentes aos endpoints das três entidades. Os endopoints em UsuarioController são pra cadastro e login de usuários. Os de TemaController e PostagemController só são acessíveis com autenticação.

- *Model*: Contém o mapeamento das entidades mais a classe UserLogin que será reimplementada no futuro como DTO.

- *Repository*: É a camada de Interfaces Repository do Spring Data JPA, com alguns métodos customizados.

- *Security*: Camada de configurações do Spring Security pra trabalhar com a parte de autenticação e autorização de usuários.

- *Service*: Camada de serviços, contém atualmente só UsuarioService com os métodos pra cadastro e login de usuário. Esses métodos fazem a parte de criptografia da senha, validação de login e token de sessão.

## Rodando

    1. Abrir o git e clonar este repositório pra sua máquina:

    `git clone https://github.com/oieusouoede/generation-blogpessoal`

    2. Importar o projeto no Eclipse ou IntelliJ (chegar compatibilidade no caso do IntelliJ)
   
    Como o projeto é pra fins de estudo, o arquivo de configuração do banco de dados está com usuário e senha 'root'. Eventualmente eu vou trocar, mas tenha em mente que sua configuração pode ser diferente.

    3. Rodar a aplicação a partir da classe principal.

## Endpoints

    Se der tudo certo a api vai estar disponível na url https:localhost:8080 e os endpoints vão poder ser acessados pelo Postman, Rested ou ferramenta similar. 

    Em:
    `/user/cadastrar` e `/user/login` é possível enviar uma POST request pra, respectivamente, o cadastro e autenticação de usuário.

    O restante dos endpoints só são acessíveis com autenticação. São eles:

    - Postagens
 
    `/posts` : Recebe requisições POST, pra inserção e PUT pra atualização de postagens.
    `/posts/all` : Recebe requisição GET e retorna todas as postagens.
    `/posts/{id}` : Recebe requisições GET e DELETE passando um id como parâmetro pra fazer busca por id ou deletar uma postagem com base no id.
    `/posts/titulo/{titulo}` : Recebe requisições GET passando uma string "titulo" como parâmetro, reliza busca de postagens com base no título.

    - Temas

    `/tema` : Recebe requisições POST, pra inserção e PUT pra atualização de tema.
    `/tema/all` : Recebe requisição GET e retorna todos os temas.
    `/tema/{id}` : Recebe requisições GET e DELETE passando um id como parâmetro pra fazer busca por id ou deletar um tema com base no id.
    `/tema/desc/{desc}` : Recebe requisições GET passando uma string "desc" como parâmetro, reliza busca de temas com base na descrição.

Por enquanto é só

Éde.


