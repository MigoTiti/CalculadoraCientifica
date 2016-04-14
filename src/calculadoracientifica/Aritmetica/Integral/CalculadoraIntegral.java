package calculadoracientifica.Aritmetica.Integral;

import calculadoracientifica.Graficos.CalculadoraPontosAjustados;
import java.util.ArrayList;

public class CalculadoraIntegral extends CalculadoraPontosAjustados {

    public CalculadoraIntegral() {
        super(true);
    }

    public CalculadoraIntegral(boolean radianos) {
        super(radianos);
    }

    public CalculadoraIntegral(CalculadoraIntegral c1) {
        super(c1.radianos);
    }

    public static void mudarPrecisao(double P) {
        if (P < 1 && P > 0) {
            CalculadoraIntegral.tol = P;
        }
    }

    public double integralAdaptativaNumerica(double limS, double limI, ArrayList<Double> numeros, ArrayList<String> sinais, ArrayList<Integer> posicoes) {
        double c = divisao(soma(limS,limI),2), h = subtracao(limS,limI); //c = (limS + limI)/2, h = limS - limI
        double ya, yb, yc, s;

        ya = interpretadorIntermediario(limI, new ArrayList<>(posicoes), new ArrayList<>(numeros), new ArrayList<>(sinais));
        yc = interpretadorIntermediario(c, new ArrayList<>(posicoes), new ArrayList<>(numeros), new ArrayList<>(sinais));
        yb = interpretadorIntermediario(limS, new ArrayList<>(posicoes), new ArrayList<>(numeros), new ArrayList<>(sinais));
        ArrayList<Double> numerosAux = new ArrayList<>();
        ArrayList<String> sinaisAux = new ArrayList<>();
        numerosAux.add(h); numerosAux.add(6.0); numerosAux.add(ya); numerosAux.add(4.0); numerosAux.add(yc); numerosAux.add(yb);
        sinaisAux.add("("); sinaisAux.add("/"); sinaisAux.add(")"); sinaisAux.add("*"); sinaisAux.add("("); sinaisAux.add("+"); sinaisAux.add("*"); sinaisAux.add("+"); sinaisAux.add(")"); 
        s = interpretador(numerosAux, sinaisAux); //(h / 6) * (ya + 4 * yc + yb)

        return metodoSimpson(limS, limI, s, ya, yb, yc, numeros, sinais, posicoes, tol);
    }

    public double integralAdaptativaArea(double limS, double limI, ArrayList<Double> numeros, ArrayList<String> sinais, ArrayList<Integer> posicoes) {

        double ya, yb, yc, yAtual, yAnterior, s, integral = 0, delta = tol, xInferior = soma(limI,delta), xSuperior, c, h; //xInferior = limI + delta
        ArrayList<Double> limites = new ArrayList<>(), integraisParciais = new ArrayList<>();
        limites.add(limI);

        for (double n = xInferior; n <= limS - delta; n += delta) {
            yAnterior = interpretadorIntermediario(subtracao(n,delta), new ArrayList<>(posicoes), new ArrayList<>(numeros), new ArrayList<>(sinais));
            yAtual = interpretadorIntermediario(n, new ArrayList<>(posicoes), new ArrayList<>(numeros), new ArrayList<>(sinais));
            if ((yAtual < 0 && yAnterior >= 0) || (yAtual > 0 && yAnterior <= 0)) {
                limites.add(n);
            }
        }
        limites.add(limS);

        while (limites.size() > 1) {
            xInferior = limites.get(limites.size() - 2);
            xSuperior = limites.get(limites.size() - 1);
            h = subtracao(xSuperior,xInferior); // h = xSuperior - xInferior
            c = divisao(soma(xInferior,xSuperior),2); // c = (xInferior + xSuperior) / 2;
            ya = interpretadorIntermediario(xInferior, new ArrayList<>(posicoes), new ArrayList<>(numeros), new ArrayList<>(sinais));
            yc = interpretadorIntermediario(c, new ArrayList<>(posicoes), new ArrayList<>(numeros), new ArrayList<>(sinais));
            yb = interpretadorIntermediario(xSuperior, new ArrayList<>(posicoes), new ArrayList<>(numeros), new ArrayList<>(sinais));
            
            ArrayList<Double> numerosAux = new ArrayList<>();
            ArrayList<String> sinaisAux = new ArrayList<>();
            numerosAux.add(h); numerosAux.add(6.0); numerosAux.add(ya); numerosAux.add(4.0); numerosAux.add(yc); numerosAux.add(yb);
            sinaisAux.add("("); sinaisAux.add("/"); sinaisAux.add(")"); sinaisAux.add("*"); sinaisAux.add("("); sinaisAux.add("+"); sinaisAux.add("*"); sinaisAux.add("+"); sinaisAux.add(")"); 
            s = interpretador(numerosAux, sinaisAux); //(h / 6) * (ya + 4 * yc + yb)
            integraisParciais.add((metodoSimpson(xSuperior, xInferior, s, ya, yb, yc, numeros, sinais, posicoes, tol)));
            limites.remove(limites.size() - 1);
        }

        for (Double integralParcial : integraisParciais) {
            integral += integralParcial;
        }

        return integral;
    }

    private double metodoSimpson(double limS, double limI, double s, double ya, double yb, double yc, ArrayList<Double> numeros, ArrayList<String> sinais, ArrayList<Integer> posicoes, double epsilon) {
        double c = divisao(soma(limS,limI),2), h = subtracao(limS,limI); //c = (limS + limI)/2, h = limS - limI
        double d = divisao(soma(limI,c),2), e = divisao(soma(c,limS),2); //d = (limI + c) / 2, e = (c + limS) / 2;

        double yd = interpretadorIntermediario(d, new ArrayList<>(posicoes), new ArrayList<>(numeros), new ArrayList<>(sinais));
        double ye = interpretadorIntermediario(e, new ArrayList<>(posicoes), new ArrayList<>(numeros), new ArrayList<>(sinais));

        ArrayList<Double> numerosAux = new ArrayList<>();
        ArrayList<String> sinaisAux = new ArrayList<>();
        numerosAux.add(h); numerosAux.add(12.0); numerosAux.add(ya); numerosAux.add(4.0); numerosAux.add(yd); numerosAux.add(yc);
        sinaisAux.add("("); sinaisAux.add("/"); sinaisAux.add(")"); sinaisAux.add("*"); sinaisAux.add("("); sinaisAux.add("+"); sinaisAux.add("*"); sinaisAux.add("+"); sinaisAux.add(")");
        double sEsquerda = interpretador(numerosAux, sinaisAux); //(h / 12) * (ya + 4 * yd + yc);
        
        ArrayList<Double> numerosAux2 = new ArrayList<>();
        ArrayList<String> sinaisAux2 = new ArrayList<>();
        numerosAux2.add(h); numerosAux2.add(12.0); numerosAux2.add(yc); numerosAux2.add(4.0); numerosAux2.add(ye); numerosAux2.add(yb);
        sinaisAux2.add("("); sinaisAux2.add("/"); sinaisAux2.add(")"); sinaisAux2.add("*"); sinaisAux2.add("("); sinaisAux2.add("+"); sinaisAux2.add("*"); sinaisAux2.add("+"); sinaisAux2.add(")");
        double sDireita = interpretador(numerosAux2, sinaisAux2); //(h / 12) * (yc + 4 * ye + yb);

        double s2 = soma(sEsquerda,sDireita); // s2 = sEsquerda + sDireita 

        if (Math.abs(subtracao(s2,s)) <= multiplicacao(15,epsilon)) {  //if (Math.abs((s2 - s)) <= 15 * epsilon)
            return Math.abs(divisao(soma(s2,subtracao(s2,s)),15));
        }
        return soma(metodoSimpson(limI, c, sEsquerda, ya, yc, yd, numeros, sinais, posicoes, divisao(tol,2)),metodoSimpson(c, limS, sDireita, yc, yb, ye, numeros, sinais, posicoes, divisao(tol,2)));
    }

    @Override
    public String toString() {
        if (radianos) {
            return "Usando radianos, precisão : " + tol;
        } else {
            return "Usando graus, precisão : " + tol;
        }
    }

    private static double tol = 1e-4;
}
