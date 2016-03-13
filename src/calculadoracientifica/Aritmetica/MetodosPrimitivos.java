package calculadoracientifica.Aritmetica;

import java.util.ArrayList;

abstract class MetodosPrimitivos {
    
    abstract double interpretador(ArrayList<Double> numeros, ArrayList<String> sinais);
    
    abstract ArrayList<Double> operacaoDupla(ArrayList<Double> numeros, String sinal, int i);
    
    abstract ArrayList<Double> operacaoUnica(ArrayList<Double> numeros, String sinal, int i);
    
    abstract ArrayList<Double> operacao(ArrayList<Double> numeros, ArrayList<String> sinais, ArrayList<Integer> prioridades, int maior);
    
    abstract int maiorIndice(ArrayList<Integer> prioridades);
}
