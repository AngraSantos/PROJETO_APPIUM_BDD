# language: pt

Funcionalidade: Cadastro de cliente

Contexto:
Dado cliente esta no aplicativo da AdvantageDEMO
E clicar no menu
E clicar em criar novo usuario

@cadastroValido
Cenario: 
Quando preencher cadastro completo
E clicar em registrar
Entao cadastro efetuado com sucesso

@cadastroInvalido
Cenario: 
Quando preencher dados da conta
E preencher dados pessoais
Quando preencher o pais escolhido
E preencher o estado
Entao  aparecera a quantidade de caracteres incorreta