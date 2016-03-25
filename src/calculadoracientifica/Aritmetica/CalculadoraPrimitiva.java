package calculadoracientifica.Aritmetica;

import java.util.ArrayList;

abstract class CalculadoraPrimitiva extends MetodosPrimitivos{
    
    public CalculadoraPrimitiva(){}
    
    abstract double interpretador(ArrayList<Double> numeros, ArrayList<String> sinais);
    
    protected enum Prioridades{
        soma(1),
        multiplicacao(2),
        potencia(3),
        trigonometricaRaizLog(4);

        private final int valor;
        
        private Prioridades(int valor){
            this.valor = valor;
        }
        
        public int getPrioridade(){
            return valor;
        }
    }
}
