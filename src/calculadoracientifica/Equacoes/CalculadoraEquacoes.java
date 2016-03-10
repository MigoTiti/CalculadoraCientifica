package calculadoracientifica.Equacoes;

import java.util.ArrayList;

public class CalculadoraEquacoes {
    
    public CalculadoraEquacoes(){}
    
    public double[] escalonarMatriz(double[][] incognitas, double[] resultados){
        int N  = resultados.length;

        for (int p = 0; p < N; p++){

            int max = p;
            for (int i = p + 1; i < N; i++) {
                if (Math.abs(incognitas[i][p]) > Math.abs(incognitas[max][p])){
                    max = i;
                }
            }
            
            double[] temp = incognitas[p]; 
            incognitas[p] = incognitas[max]; 
            incognitas[max] = temp;
            
            double t = resultados[p]; 
            resultados[p] = resultados[max]; 
            resultados[max] = t;

            for (int i = p + 1; i < N; i++){
                double alfa = incognitas[i][p] / incognitas[p][p];
                resultados[i] -= alfa * resultados[p];
                for (int j = p; j < N; j++) {
                    incognitas[i][j] -= alfa * incognitas[p][j];
                }
            }
        }

        double[] resultado = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double soma = 0.0;
            for (int j = i + 1; j < N; j++) {
                soma += incognitas[i][j] * resultado[j];
            }
            resultado[i] = (resultados[i] - soma) / incognitas[i][i];
        }
        return resultado;
    }
    
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
