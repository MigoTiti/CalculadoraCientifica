package calculadoracientifica.Aritmetica;

import java.util.ArrayList;

abstract class CalculadoraPrimitiva extends MetodosPrimitivos{
    
    public CalculadoraPrimitiva(){}
    
    abstract double interpretador(ArrayList<Double> numeros, ArrayList<String> sinais);
    
    protected enum Prioridades{
        SOMA(1),
        MULTIPLICACAO(2),
        POTENCIA(3),
        TRIGONOMETRICARAIZLOG(4);

        private final int valor;
        
        private Prioridades(int valor){
            this.valor = valor;
        }
        
        public int getPrioridade(){
            return valor;
        }
    }
}
