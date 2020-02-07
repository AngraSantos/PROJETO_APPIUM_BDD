# language: pt

Funcionalidade: Busca pela home

Contexto:
Dado cliente esta no aplicativo da AdvantageDEMO

@SelecionouUmProdutoComSucesso
Cenario:
Quando deve selecionar um produto na tela inicial
E pode escolher um produto
Entao aparecerar o produto que foi escolhido


@SelecionouUmProdutoComFalha
Cenario:
Quando fizer o cadastro
E selecionar o categoria de produto desejado
E escolher o produto
Quando escolher a quantidade 
E incluir no carrinho 
Entao tera uma quantidade divergente do solicitado

