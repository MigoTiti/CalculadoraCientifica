package calculadoracientifica.Aritmetica.Derivada;

import calculadoracientifica.Graficos.CalculadoraPontos;
import java.util.ArrayList;

public class CalculadoraDerivada extends CalculadoraPontos{
    
    public CalculadoraDerivada(){
        super(true);
    }
    
    public CalculadoraDerivada(boolean radianos){
        super(radianos);
    }
    
    public CalculadoraDerivada(CalculadoraDerivada c1){
        super(c1.radianos);
    }
    
    public double derivada(double x, ArrayList<Double> numeros, ArrayList<String> sinais, ArrayList<Integer> posicoes){
        ArrayList<Double> numeros1 = new ArrayList<>(numeros);
        ArrayList<String> sinais1 = new ArrayList<>(sinais);
        ArrayList<Integer> posicoes1 = new ArrayList<>(posicoes);
        
        double fxh = interpretadorIntermediario(x+h,posicoes1,numeros1,sinais1);
        double fx = interpretadorIntermediario(x,posicoes,numeros,sinais);
        
        double derivada = (fxh-fx)/h;
        
        return derivada;
    }
    
    private static final double h = 1e-10;
}
