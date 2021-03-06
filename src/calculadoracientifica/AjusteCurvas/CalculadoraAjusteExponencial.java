package calculadoracientifica.AjusteCurvas;

import java.util.ArrayList;

public class CalculadoraAjusteExponencial extends CalculadoraMinimosQuadrados {

    public CalculadoraAjusteExponencial() {
        this.n = 0;
        this.sX = 0;
        this.sY = 0;
        this.sX2 = 0;
        this.sXY = 0;
    }

    public CalculadoraAjusteExponencial(ArrayList<Double> x, ArrayList<Double> y) {
        this.n = x.size();
        for (int i = 0; i < n; i++) {
            this.sX += x.get(i);
            this.sY += Math.log(y.get(i));
            this.sX2 += Math.pow(x.get(i), 2);
            this.sXY += x.get(i) * Math.log(y.get(i));
        }
    }

    public CalculadoraAjusteExponencial(CalculadoraAjusteExponencial c1) {
        this.n = c1.n;
        this.sX = c1.sX;
        this.sY = c1.sY;
        this.sX2 = c1.sX2;
        this.sXY = c1.sXY;
    }

    @Override
    public double[] MinimosQuadradosAjuste() {
        double[][] incognitas;
        incognitas = new double[2][2];
        incognitas[0][0] = n;
        incognitas[0][1] = sX;
        incognitas[1][0] = sX;
        incognitas[1][1] = sX2;

        double[] resultados;
        resultados = new double[2];
        resultados[0] = sY;
        resultados[1] = sXY;

        resultados = escalonarMatriz(incognitas, resultados);

        resultados[0] = Math.exp(resultados[0]);

        return resultados;
    }

    @Override
    public String toString() {
        return "Número de elementos: " + n;
    }

    private int n;
    private double sX, sY, sX2, sXY;
}
