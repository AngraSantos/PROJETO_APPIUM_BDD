# language: pt

Funcionalidade: Buscar produto pela lupa

Contexto: 
Dado cliente esta no aplicativo da AdvantageDEMO

@BuscaPelaLupaComSucesso
Cenario:  
Quando escrever o nome do item desejado
Entao tera produto encontrado 


@BuscaPelaLupaComFalhaPorProdutoInexistente
Cenario:
Quando escrever o nome do produto que nao existente
Entao chegara na pagina de nao encontrado