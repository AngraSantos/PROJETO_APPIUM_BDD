# language: pt

Funcionalidade: Busca pela home

Contexto:
Dado que cliente esta no aplicativo da AdvantageDEMO

@BuscaDeProdutoComSucesso
Cenario:
Quando selecionar uma categoria na tela inicial
Entao  ao selecionar um produto ira aparecer o que foi escolhido

@BuscaDeProdutoComFalhaPorQuantidadeNoCarrinhoDivergente
Cenario:
Quando fazer o login
E selecionar o categoria de produto desejado
E escolher o produto
E escolher a quantidade 
E incluir no carrinho 
Entao tera uma quantidade divergente do solicitado