# language: pt
#coding:utf-8

Funcionalidade: Buscar produto pela lupa

Contexto: 
Dado cliente esta no aplicativo da AdvantageDEMO

@BuscaPelaLupaComSucesso
Esquema do Cenario:  
Quando escrever o nome do item desejado "<tipoProduto>" 
E seleciona o produto
Entao tera produto encontrado "<nomeProduto>" 

	Exemplos: 

	| tipoProduto |	nomeProduto					 		 |
	|	mouse 			|	HP Z4000 WIRELESS MOUSE	 |

@FalhaPorProdutoInexistente
Esquema do Cenario: 
Quando escrever o nome do produto que nao existente "<produtoIndisponivel>" 
Entao chegara na pagina de produto nao encontrado    

Exemplos: 

	| produtoIndisponivel |	
	|	fone 				  			|