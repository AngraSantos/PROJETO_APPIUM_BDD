# language: pt
#coding:utf-8

Funcionalidade: Cadastrar cliente no aplicativo AdvantageDEMO

Contexto: 
Dado que cliente esteja no aplicativo
E clica em login
E em seguida clica em criar novo usuario

@CadastroComSucesso
Esquema do Cenario:
Quando preencher o cadastro "<Username>", "<email>" , "<senha>" , "<ConfirmarSenha>" , "<primeiroNome>" , "<ultimoNome>" , "<telefone>" , "<Pais>" , "<estado>" , "<endereco>" , "<cidade>" , "<CEP>"" 
E clicar no botao de registrar
Entao o cadastro estara efetuado com sucesso "<Username>"

Exemplos:
	| Username 	  	 | email                       | senha    | ConfirmarSenha | primeiroNome | ultimoNome | telefone       | Pais   | estado    | endereco             | cidade    | CEP       |
	| Angrhugyut | angra.santos@hotmail.com.br | Angra123 | Angra123       | Angra			  | Santos     | (11)97051-0060 | Brazil | Sao Paulo | Rua Tres Marias, 123 | Sao Paulo | 01010-200 |

@SenhaDigitadaIncorretamente
Esquema do Cenario:
Quando preencher o cadastro com falha "<Username>", "<email>" , "<senha>" , "<ConfirmarSenha>" , "<primeiroNome>" , "<ultimoNome>" , "<telefone>" , "<Pais>" , "<estado>" , "<endereco>" , "<cidade>" , "<CEP>""
Entao ao preencher ira aparecer que foi preenchido o senha de forma errada

Exemplos: 
	| Username 		 | email                       | senha    | ConfirmarSenha | primeiroNome | ultimoNome | telefone       | Pais   | estado    | endereco             | cidade    | CEP       |
	|	AngraSantos	 | angra.santos@hotmail.com.br | angra123 | angra123       | Angra			  | Santos     | (11)97051-0060 | Brazil | Sao Paulo | Rua Tres Marias, 123 | Sao Paulo | 01010-200 |