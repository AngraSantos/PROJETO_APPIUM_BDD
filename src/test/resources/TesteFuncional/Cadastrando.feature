# language: pt

Funcionalidade: Cadastrar cliente no aplicativo AdvantageDEMO

Contexto: 
Dado que cliente esteja no aplicativo
E clica em login
E em seguida clica em criar novo usuario

@CadastroComSucesso
Cenario:
Quando preencher o cadastro
E clicar no botao de registrar
Entao o cadastro estara efetuado com sucesso

@CadastroComFalhaNaQuantidadeDeCaracteresNoEstado
Cenario:
Quando preencher o pais
Entao ao preencher o estado ira contar a quantidade de caracteres excedido
