package calculadoracientifica.Equacoes;

import java.util.ArrayList;

public class CalculadoraEquacoes {
    
    public CalculadoraEquacoes(){}
    
    public double delta(double a, double b, double c){
        return Math.pow(b, 2) - (4*a*c);
    }
    
    public ArrayList<String> equacaoSegundoGrau(double a, double b, double c){
        double delta = delta(a,b,c);
        ArrayList<String> raizes = new ArrayList<>();
        if(delta==0.0){
            double raiz = ((-b)/(2*a));
            raizes.add(Double.toString(raiz));
            raizes.add("Apenas uma raiz real.");
        }else if(delta>0.0){
            double raiz1 = (((-b)+Math.sqrt(delta))/(2*a));
            double raiz2 = (((-b)-Math.sqrt(delta))/(2*a));
            raizes.add(Double.toString(raiz1));
            raizes.add(Double.toString(raiz2));
        }else
            raizes.add("Não existe raiz real.");
            raizes.add("Não existe raiz real.");
        return raizes;
    }
    
}
