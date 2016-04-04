package calculadoracientifica.Equacoes;

import calculadoracientifica.Aritmetica.CalculadoraAritmetica;
import java.util.ArrayList;

public class CalculadoraEquacoes extends CalculadoraAritmetica {

    public CalculadoraEquacoes() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.raizes = new ArrayList<>();
        this.delta = 0;
    }

    public CalculadoraEquacoes(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.raizes = new ArrayList<>();
        this.delta = delta(a, b, c);
    }

    public CalculadoraEquacoes(CalculadoraEquacoes c1) {
        this.a = c1.a;
        this.b = c1.b;
        this.c = c1.c;
        this.delta = c1.delta;
        this.raizes = c1.raizes;
    }

    public double delta(double a, double b, double c) {
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> sinais = new ArrayList<>();
        numeros.add(b);
        numeros.add(2.0);
        numeros.add(4.0);
        numeros.add(a);
        numeros.add(c);
        sinais.add("^");
        sinais.add("-");
        sinais.add("(");
        sinais.add("*");
        sinais.add("*");
        sinais.add(")");
        return interpretador(numeros, sinais);
    }

    public ArrayList<String> equacaoSegundoGrau() {
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> sinais = new ArrayList<>();
        if (delta == 0.0) {
            numeros.add(-b);
            numeros.add(2.0);
            numeros.add(a);
            sinais.add("/");
            sinais.add("(");
            sinais.add("*");
            sinais.add(")");
            double raiz = interpretador(numeros, sinais);
            raizes.add(Double.toString(raiz));
            raizes.add("Apenas uma raiz real.");
        } else if (delta > 0.0) {
            numeros.add(-b);
            numeros.add(delta);
            numeros.add(2.0);
            numeros.add(a);
            sinais.add("(");
            sinais.add("+");
            sinais.add("sqrt");
            sinais.add("(");
            sinais.add(")");
            sinais.add(")");
            sinais.add("/");
            sinais.add("(");
            sinais.add("*");
            sinais.add(")");
            double raiz1 = interpretador(numeros, sinais);
            numeros.clear();
            sinais.clear();
            numeros.add(-b);
            numeros.add(delta);
            numeros.add(2.0);
            numeros.add(a);
            sinais.add("(");
            sinais.add("-");
            sinais.add("sqrt");
            sinais.add("(");
            sinais.add(")");
            sinais.add(")");
            sinais.add("/");
            sinais.add("(");
            sinais.add("*");
            sinais.add(")");
            double raiz2 = interpretador(numeros, sinais);
            raizes.add(Double.toString(raiz1));
            raizes.add(Double.toString(raiz2));
        } else {
            raizes.add("Não existe raiz real.");
        }
        raizes.add("Não existe raiz real.");
        return raizes;
    }

    @Override
    public String toString() {
        if (raizes.get(1).equals("Apenas uma raiz real.")) {
            return raizes.get(0);
        } else if (raizes.get(0).equals("Não existe raiz real.")) {
            return raizes.get(0);
        } else {
            return "x1: " + raizes.get(0) + "\nx2: " + raizes.get(1);
        }
    }

    private double a;
    private double b;
    private double c;
    private ArrayList<String> raizes;
    private double delta;
}
