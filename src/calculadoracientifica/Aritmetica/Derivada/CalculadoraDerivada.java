package calculadoracientifica.Aritmetica.Derivada;

import calculadoracientifica.Graficos.CalculadoraPontosAjustados;
import java.util.ArrayList;

public class CalculadoraDerivada extends CalculadoraPontosAjustados{
    
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
        
        double fxh = interpretadorIntermediario(x+TOL,posicoes1,numeros1,sinais1);
        double fxmh = interpretadorIntermediario(x-TOL,posicoes,numeros,sinais);
        
        double derivada = (fxh-fxmh)/(2*TOL);
        
        return derivada;
    }
    
    @Override
    public String toString(){
        if(radianos)
            return "Usando radianos, precisão : "+TOL;
        else
            return "Usando graus, precisão : "+TOL;
    }
    
    private static final double TOL = 1e-10;
}
