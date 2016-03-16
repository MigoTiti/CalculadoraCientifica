package calculadoracientifica.Aritmetica.Integral;

import calculadoracientifica.Graficos.CalculadoraGraficos;
import java.util.ArrayList;

public class CalculadoraIntegral extends CalculadoraGraficos{
    
    public CalculadoraIntegral(){}
    
    public static void mudarPrecisao(double P){
        if(P>2)
            CalculadoraIntegral.iteracoes = P;
    }
    
    public double integral(double limS, double limI, ArrayList<Double> numeros, ArrayList<String> sinais, ArrayList<Integer> posicoes){
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();
        ArrayList<Integer> k = new ArrayList<>();
        ArrayList<Double> numeros2;
        ArrayList<String> sinais2;
        ArrayList<Integer> posicoes2;
        
        double delta = divisao(subtracao(limS,limI),iteracoes);
        
        for(double i=limI;i<=limS;i+=delta){
            numeros2 = new ArrayList<>(numeros);
            sinais2 = new ArrayList<>(sinais);
            posicoes2 = new ArrayList<>(posicoes);
            x.add(i);
            y.add(interpretadorIntermediario(i,posicoes2,numeros2,sinais2));
        }
        
        k.add(0, 1);
        
        for(int i=0;i<x.size()-1;i++){
            if(i % 2==0)
                k.add(i, 2);
            else
                k.add(i, 4);
        }
        
        k.add(x.size()-1,1);
        
        for(int i=0;i<y.size();i++){
            double resultadoParcial = y.get(i)*k.get(i);
            y.remove(i);
            y.add(i, resultadoParcial);
        }
        
        double somatorio = 0;
        
        for (Double y1 : y) {
            somatorio += y1;
        }
        
        double resultadoIntegral = (delta/3)*somatorio;
        
        return resultadoIntegral;
    }
    
    private static double iteracoes = 10;
}
