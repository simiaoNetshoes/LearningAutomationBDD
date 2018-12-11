@teste
Funcionalidade: realizar gerenciamento cadastral de funcionarios 
		
  Contexto: 
    Dado que tenha acessado o sistema
    E que tenha realizado login com as credencias
    |login|senha|
    |xxxxx|xxxxx|
    
  @ID01
  Cenario: Realizar Inclusao de funcionario no sistema        
  Quando realizar inclusão de funcionario na tela de  gerenciamento de funcionarios do sistema
  |nome|endereço|cidade|idade|quantidade de filhos|CPF|
  |    |        |      |     |                    |   |
  Entao a pagina de inclusao retorna matricula gerada com sucesso 
  
  @ID02
  Cenario: Realizar Alteração de funcionario no sistema        
  Quando realizar pesquisa de funcionario na tela de gerenciamento de funcionarios do sistema
  |matricula|
  |    			|
  E realizar a acao de Alteracao Cadastral para o funcionario
  |nome|endereço|cidade|idade|quantidade de filhos|CPF|
  |    |        |      |     |                    |   |
  Entao a pagina de Alteracao Cadastral retorna alteracao realizada com sucesso

  @ID03
  Cenario: Realizar Exclusão de funcionario no sistema        
  Quando realizar pesquisa de funcionario na tela de gerenciamento de funcionarios do sistema
  |matricula|
  |    			|
  E realizar a acao de Exclusao para o funcionario
  E realizar pesquisa de funcionario na tela de gerenciamento de funcionarios do sistema
  |matricula|
  |    			|
  Entao a pagina de gerenciamento de funcionarios nao retorna um funcionario no sistema
  
  
