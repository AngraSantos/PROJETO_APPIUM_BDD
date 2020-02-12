# language: pt
#coding:utf-8

Funcionalidade: Busca pela home

Contexto:
Dado que cliente esta no aplicativo da AdvantageDEMO

@BuscaDeProdutoComSucesso
Cenario: 
Quando selecionar uma categoria na tela inicial
E clica no produto
Entao ira aparecer o produto que foi escolhido

@FalhaPorQuantidadeNoCarrinhoDivergente
Esquema do Cenario:
E clicar no botao do menu
Quando clicar no botao do Login
E fazer o login "<username>" , "<senha>" 
E selecionar o categoria de produto desejado
E escolher o produto 
E escolher a quantidade 
E incluir no carrinho 
Entao tera uma quantidade divergente do solicitado

Exemplos: 

	| username    |	senha   	|
	| Angra123    | Angra123  |