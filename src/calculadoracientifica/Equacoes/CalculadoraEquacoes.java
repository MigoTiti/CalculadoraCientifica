package calculadoracientifica.Equacoes;

import calculadoracientifica.Aritmetica.Calculadora;
import java.util.ArrayList;

public class CalculadoraEquacoes extends Calculadora{
    
    public CalculadoraEquacoes(){}
    
    public double delta(double a, double b, double c){
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> sinais = new ArrayList<>();
        numeros.add(b); numeros.add(2.0); numeros.add(4.0); numeros.add(a); numeros.add(c);
        sinais.add("^"); sinais.add("-"); sinais.add("("); sinais.add("*"); sinais.add("*"); sinais.add(")");
        return interpretador(numeros,sinais);
    }
    
    public ArrayList<String> equacaoSegundoGrau(double a, double b, double c){
        double delta = delta(a,b,c);
        ArrayList<String> raizes = new ArrayList<>();
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> sinais = new ArrayList<>();
        if(delta==0.0){
            numeros.add(-b); numeros.add(2.0); numeros.add(a);
            sinais.add("/"); sinais.add("("); sinais.add("*"); sinais.add(")");
            double raiz = interpretador(numeros,sinais);
            raizes.add(Double.toString(raiz));
            raizes.add("Apenas uma raiz real.");
        }else if(delta>0.0){
            numeros.add(-b); numeros.add(delta); numeros.add(2.0); numeros.add(a);
            sinais.add("("); sinais.add("+"); sinais.add("sqrt"); sinais.add("(");sinais.add(")"); sinais.add(")"); sinais.add("/"); sinais.add("("); sinais.add("*"); sinais.add(")");
            double raiz1 = interpretador(numeros,sinais);
            numeros.clear();
            sinais.clear();
            numeros.add(-b); numeros.add(delta); numeros.add(2.0); numeros.add(a);
            sinais.add("("); sinais.add("-"); sinais.add("sqrt"); sinais.add("(");sinais.add(")"); sinais.add(")"); sinais.add("/"); sinais.add("("); sinais.add("*"); sinais.add(")");
            double raiz2 = interpretador(numeros,sinais);
            raizes.add(Double.toString(raiz1));
            raizes.add(Double.toString(raiz2));
        }else
            raizes.add("Não existe raiz real.");
            raizes.add("Não existe raiz real.");
        return raizes;
    } 
}
