package calculadoracientifica.Aritmetica;

import java.util.ArrayList;
import calculadoracientifica.Interfaces.MetodosPrimitivos;

abstract class CalculadoraPrimitiva implements MetodosPrimitivos {

    public CalculadoraPrimitiva() {}

    abstract double interpretador(ArrayList<Double> numeros, ArrayList<String> sinais);

    @Override
    public double soma(double a, double b) {
        return a + b;
    }
    
    @Override
    public double subtracao(double a, double b) {
        return a - b;
    }

    @Override
    public double divisao(double a, double b) {
        return a / b;
    }

    @Override
    public double multiplicacao(double a, double b) {
        return a * b;
    }

    @Override
    public double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }

    @Override
    public double raizQuadrada(double a) {
        return Math.sqrt(a);
    }

    @Override
    public double resto(double dividendo, double divisor) {
        return dividendo % divisor;
    }

    @Override
    public double log10(double a) {
        return Math.log10(a);
    }

    @Override
    public double logNatural(double a) {
        return Math.log(a);
    }

    @Override
    public double seno(double a) {
        return Math.sin(a);
    }

    @Override
    public double cosseno(double a) {
        return Math.cos(a);
    }

    @Override
    public double tangente(double a) {
        return Math.tan(a);
    }

    protected enum Prioridades {

        SOMA(1),
        MULTIPLICACAO(2),
        POTENCIA(3),
        TRIGONOMETRICARAIZLOG(4);

        private final int valor;

        private Prioridades(int valor) {
            this.valor = valor;
        }

        public int getPrioridade() {
            return valor;
        }
    }
}
