# Projeto Ecoleta -  conectando para uma vida sustentável #

Tecnologia: Spring Boot + Spring Security (Autenticação e Autorização) + Java + MySQL

Objetivo:

 Desenvolver uma solução tecnológica para promover a sustentabilidade ambiental 
por meio do recolhimento eficiente de materiais recicláveis, organização de 
cooperativas de catadores e reintegração de materiais tratados à cadeia produtiva 
como matéria-prima.

Descrição do Projeto:

 O projeto visa criar uma plataforma digital integrada que conecta diferentes agentes 
do ciclo de reciclagem:

1. Coleta Inteligente: Aplicativo para mapear pontos de descarte de materiais 
recicláveis e otimizar a logística de recolhimento por catadores ou cooperativas.
2. Gestão de Cooperativas: Ferramentas para organização e gerenciamento 
de cooperativas de catadores, com controle de entrada/saída de materiais, 
produtividade, pagamentos e treinamentos.
3. Tratamento e Classificação: Registro e monitoramento do processo de triagem 
e tratamento do material coletado, com padronização para reutilização 
industrial.
4. Marketplace Verde: Disponibilização dos materiais tratados em uma 
plataforma online, onde indústrias podem adquirir insumos reciclados para suas 
linhas de produção.

Resultados Esperados:

1. Geração de renda para catadores e fortalecimento das cooperativas
2. Redução do descarte incorreto de resíduos sólidos
3. Estímulo à economia circular e ao consumo consciente nas indústrias
4. Aumento da taxa de reciclagem e reaproveitamento de materiais no Brasil


### Diagrama de Classes ###
```mermaid
classDiagram

    class Pessoa {
        - long id_usuario
        - String cpfCnpj
        - String nome
        - String email
        - String senha
        - String logradouro
        - String numero
        - String complemento
        - String bairro
        - String cidade
        - String telefone
        - String pontoReferencia
        - String cep
        - Enum tipoPessoa
    }

    class Colaborador{

    }

    class Cooperativa{
        
    }

    class Usuario{
        
    }

    class Industria{
        
    }



    class Veiculo {
        - long id_veiculo
        - String placa
        - String modelo
        - String marca
        - String ano_modelo
    }

    class Material {
        - long id_material
        - String descricao
        - Float valor_kg
        - Float kg_disponivel
    }

    class Coleta {
        - long id_coleta
        - Date data_solicitacao
        - Date data_coleta
        - DateTime horario_coleta
        - Colaborador colaborador
        - Usuario usuario
        - Veiculo veiculo
        - Cooperativa cooperativa
        - Enum status
    }

    class Venda {
        - long id_venda
        - Date data_venda
        - Industria industria
        - Colaborador colaborador
        - Veiculo veiculo
        - Float quantidade_kg
        - Enum status
        - Date data_entrega
        - Float valor_total
    }

   %% Relacionamentos


%% Coleta -> Pessoa (usuário, colaborador, cooperativa)
Coleta "N" -- * "1" Pessoa : usuario
Coleta "N" -- * "1" Pessoa : colaborador
Coleta "N" -- * "1" Pessoa : cooperativa

%% Coleta -> Veiculo
Coleta "N" -- * "1" Veiculo : utiliza

%% Coleta -> Material
Coleta "N" -- * "1" Material : coleta

%% Venda -> Material
Venda "N" -- * "1" Material : contém

%% Venda -> Veiculo
Venda "N" -- * "1" Veiculo : entrega via

%% Venda -> Pessoa (industria)
Venda "N" -- * "1" Pessoa : vendida para

Pessoa <|-- Colaborador
Pessoa <|-- Industria
Pessoa <|-- Cooperativa
Pessoa <|-- Usuario
```
