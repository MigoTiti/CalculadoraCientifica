# CalculadoraCientifica
Projeto final de programação II

Obs.: Para executar no NetBeans: adicionar os JARs do JFreeChart no projeto

# Requisitos de implementação para Java

1.	Todas as classes concretas devem vir de interfaces ou classes abstratas. Pelo menos três hierarquias de classes. Uma das hierarquias deve ter três níveis. Exemplo: Personagem >> Ciborgue >> Robocop; Class Arma (interface) >> Beretta93R

2.	Ao menos três interfaces. A terceira interface deve ser uma interface que liga duas hierarquias como no exemplo da interface corredor (Figura 1).

3.	Usar a interface Comparable e sobrescrever o método compareTo em pelo menos uma hierarquia

4.	Sobrescrever equals para de Object

5.	Todas as hierarquias devem ter classes Concretas, e em uma das hierarquias, três classes Concretas relacionadas:  Exemplo Servico >> ServicoStream >> (Netflix, HBOStream, AmazonPrime, NowTv). Em uma pesquisa de 10 segundos:http://www.tomsguide.com/us/pictures-story/620-top-online-streaming-video.html

6.	Sempre usar o super para o máximo de reaproveitamento de código em todas as classes

7.	Atributos static e const static em todas as hierarquias de classe

8.	Método static em todas as hierarquias de classe

9.	Três construtores para todas as classes, sendo um deles o construtor de cópia. Sempre validar os dados em todas as classes

10.	ArrayList na hierarquia principal

11.	ENUM na hierarquia principal

12.	Usar o instanceof no main junto com as classes concretas. Para uma da classe concreta identificada, chamar um método dessa classe e fazer uma ação;

13.	Dividir o projeto em pacotes

14.	Sobrescrever para todas as classes o método toString

15.	Usar a classe Random do pacote java.util (java.util.Random). Nota: deve ser usado conforme o contexto do projeto. Se for usado em um método genérico sem relação com a classe e apenas para cumpri-lo, esse requisito será desconsiderado.

16.	No main o usuário deve fazer entrada via teclado e interagir com a aplicação. Opcional de bônus: pode ser usada a classe JOptionPane do pacote javax.swing. Vejam: showInputDialog e showMessageDialog.
