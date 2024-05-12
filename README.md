# Framework
Esse repositório tem como principal objetivo guardar os códigos das aulas práticas da disciplina para aprimorar suas habilidades em vários tópicos, desenvolvendo a implementação de API com controle de autenticação e autorização, também com mecanismos de mensageria. Além de conhecer sobre o uso de cache, recursos de balanceamento de APIs, processo de falha e exceções em APIs e o consumo de APIs externas dentre outros conceitos.

## 📚 Organização desse repositório

As pastas ```FrameBlog``` e ```Service-Registry/Service-Registry``` são o código implementado na disciplina e cada commit indica quando (e qual) foi a prática realizada.
Na raiz, temos o diagrama de entidade e relacionamento do projeto construído que tem a intenção de ser um mini blog, temos a versão inicial e a versão 1 que foi para acrescentar um atributo.

## 💻 Projeto da Disciplina

O projeto da disciplina tem a intenção de criar uma estrutura de mini-blog onde existem usuários administradores ou usuários comuns. Uma postagem poderá ter vários comentários e tags. Um usuário poderá ter várias postagens e também vários comentários. Dentre outros pequenos detalhes. Abaixo temos o diagrama de entidade-relacionamento do projeto para melhor entendimento da estrutura - foi explicado em aula.
> Clique na imagem para visualizar em tamanho original.

<img src="https://github.com/FaculdadeDescomplica/Framework/blob/main/Frameblog-v1.drawio.png" width=50% height=50%>

### ℹ️ Pré-requisitos

No módulo 1, são apresentadas todas as necessidades de ambiente de desenvolvimento.
Nesse projeto, utilizamos o `Java 17` no sistema operacional Windows 10/11.
Como IDE, foi utilizado o IntelliJ Community e o navegador utilizado foi o Google Chrome.
Para banco de dados, utilizamos o MySQL Server e o MySQL Workbench (Módulo 5).
Além disso, é possível testar suas requisições pela ferramenta Postman. A instalação do Postman Desktop é **opcional**, pois você pode utilizar no navegador.

**Importante destacar:** essa é a documentação Módulo 5 citada em aula - [MySQL Workbench Community Downloads](https://dev.mysql.com/downloads/workbench/) e [MySQL Community Server Downloads](https://dev.mysql.com/downloads/mysql/). A senha do My Sql é determinada na configuração!

**Importante destacar:** no Service-Registry, é necessário tirar a versão da dependência.

### 📫 Contribuindo para o projeto
<!---Se você foi aluno dessa disciplina e deseja contribuir com ajustes e/ou funcionalidades entre em contato com o responsável da sua aula e considere a criação de um arquivo CONTRIBUTING.md separado--->
Para contribuir, siga estas etapas:

1. Bifurque este repositório.
2. Crie um branch: `git checkout -b <seu_nome_nome_funcionalidade>`.
3. Faça suas alterações e confirme-as: `git commit -m '<mensagem_commit>'`
4. Envie para o branch original: `git push origin <nome_do_projeto> / <local>`
5. Crie a solicitação de pull.

Como alternativa, consulte a documentação do GitHub em [como criar uma solicitação pull](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request).
    
