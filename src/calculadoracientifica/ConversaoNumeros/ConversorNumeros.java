package calculadoracientifica.ConversaoNumeros;

import calculadoracientifica.Aritmetica.CalculadoraAritmetica;
import calculadoracientifica.Interfaces.ConversaoNumeros;
import calculadoracientifica.ModeloNumero.Unidades.NumeroArea;

public class ConversorNumeros implements ConversaoNumeros{
    
    public ConversorNumeros(){}
    
    @Override
    public Object converterNumero(CalculadoraAritmetica calculadora, Object numero, String simboloFinal){
        
        Object numeroFinal = new Object();
        
        if(numero instanceof NumeroArea){
            numeroFinal = converterArea(calculadora,(NumeroArea)numero,simboloFinal);
        }else{
            
        }
            
        return numeroFinal;
    }
    
    private NumeroArea converterArea(CalculadoraAritmetica calculadora, NumeroArea numeroInicial, String simboloFinal){
        
        return new NumeroArea(0,"");
    }
    
}
