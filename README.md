**HACKATHON GRAAC**
========================================================================

Parabens!!!

Sua equipe esta participando do Hackathon beneficiente para a Graac!


Foi disponibilizado um ambiente de desenvolvimento onde o acesso deverá ser 
realizado através da VPN.


**Seus dados de acesso são:**

    IP:         172.31.14.252
    USUÁRIO:    ubuntu
    SENHA:      N9sdhpi2Dhn2
    
    Para acesso externo à sua API desenvolvida, utilize o endereço: http://13.52.219.65



Você possui permissão de root (Administrador), para isso execute:

**$** sudo su -



Voce pode desenvolver utilizando os recursos abaixo:
========================================================================
- PHP 7.2.24
- Java 8 (OpenJDK 1.8.0)
- NodeJS v8.10.0
- Python 3.6.9
  > Obs.: Utilizar o comando "pip3"
- Python 2.7.15+
  > Utilizar o comando "pip"
- Docker / Docker Compose
- Maven

Banco de dados
========================================================================
Como acessar o client do Postgres:

    $ sudo -i -u postgres
    $ psql

Como acessar o client do MySQL:

    $ mysql -u root -p
    SENHA: N9sdhpi2Dhn2
    Acesso Web: http://<IP_AMBIENTE>/phpmyadmin/

Como acessar o client do mongodb:

    $ mongo --eval 'db.runCommand({ connectionStatus: 1 })'

Como acessar o Elasticsearch:

    $ curl -u elastic:changeme -XGET 'http://localhost:9200/'
    Usuário: elastic     Senha: changeme


##############################################################################
    API  GRAACC-MAILING

 Foi pensado para dar mais agilidade, praticidade e portabilidade as formas de doação via pagamentos ao GRAACC. A ideia é disponibilizar em veículos de mídia em espaços de grande circulação um QR Code que após lido por eletrôncios portáteis, redirecione para página Web onde os usários podrão conhecer melhor o GRAACC, contribuir e se engajar sendo um doador mensal.

 A API faz uso de uma tabela de banco de dados simples que armazena informações de usuário e email, que podem ser usador posteriormente para mailing.

 Executar script de banco de dados disponível em Configs/graacc-mailing/BD_GRAACC.sql.

 Diretório da api /graacc-mailing

Abaixo documento Swaaguer 
 

    *swagger: '2.0'
    info:
    description: API que permite efetua uma requisição para salvar usuário e e-mail
    version: 1.0.0
    title: Salva e-mails e usuários
    license:
    name: Apache 2.0
    url: http://www.apache.org/licenses/LICENSE-2.0.html
    # tags are used for organizing operations
    tags:
    - name: admins
    description: Secured Admin-only calls
    - name: developers
    description: Operations available to regular developers
    paths:
      /app/api/mailing:
    post:
      tags:
      - admins
      summary: adiciona um usuário
      operationId: mailing
      description: Adiciona um usuário e email disponibilizando para ferramentas de mailing
      consumes:
      - application/json
      produces:
      - application/json
      parameters:
      - in: body
        name: MailingUser
        description: Inventory item to add
        schema:
          $ref: '#/definitions/MailingUser'
      responses:
        201:
          description: Dados inseridos com sucesso
        400:
          description: Ocorreu algum erro ao salvar os dados.
        409:
          description: Ocorreu algum erro ao salvar os dados.  
        
        definitions:
          MailingUser:
          type: object
          required:
        - nome
        - email
        properties:
        nome:
            type: string
            example: Jão de Souza
        email:
            type: string
            example: usermail@mail.com
            schemes:
        - https*


##############################################################################



