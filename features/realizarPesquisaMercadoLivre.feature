#language:pt
@teste
Funcionalidade: realizar pesquisa no site Mercado Livre

  Contexto: 
    Dado que tenha acessado o site Mercado Livre
    E que tenha realizado pesquisa na pagina inicial do Mercado Livre
      | itemPesquisado |
      | Ipad Air 2   |

  @ID00001
  Cenario: Realizar uma pesquisa no site do mercado livre e imprimir somente titulo e valor dos CINCO primeiros resultados
    Quando pesquisa retorna resultados esperados na pagina de pesquisa Mercado Livre
    Entao sera evidenciado os cinco primeiros resultados na pagina de pequisas Mercado Livre
  #@ID00002
  #Cenario: Realizar uma pesquisa no site do mercado livre que contenha paginacao, tirar um print do penultimo anuncio da segunda pagina
    #Quando pesquisa retorna resultados esperados na pagina de pesquisa Mercado Livre
    #E acessar a segunda pagina de resultados
    #Entao sera evidenciado o penultimo anuncio da pagina de pequisas Mercado Livre
