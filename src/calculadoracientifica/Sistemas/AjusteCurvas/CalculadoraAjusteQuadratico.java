package calculadoracientifica.Sistemas.AjusteCurvas;

import calculadoracientifica.Interfaces.MinimosQuadrados;
import calculadoracientifica.Sistemas.CalculadoraSistemas;
import java.util.ArrayList;

public class CalculadoraAjusteQuadratico extends CalculadoraSistemas implements MinimosQuadrados{
    
    public CalculadoraAjusteQuadratico(){}

    @Override
    public double[] MinimosQuadradosAjuste(ArrayList<Double> x, ArrayList<Double> y) {
        int n = x.size();
        double sX = 0, sY = 0, sX2 = 0, sX3 = 0, sX4 = 0, sX2Y = 0, sXY = 0;
        for(int i = 0;i<n;i++){
            sX+=x.get(i);
            sY+=y.get(i);
            sX2+=Math.pow(x.get(i), 2);
            sX3+=Math.pow(x.get(i), 3);
            sX4+=Math.pow(x.get(i), 4);
            sXY+=x.get(i)*y.get(i);
            sX2Y+=Math.pow(x.get(i),2)*y.get(i);
        }
        
        double[][] incognitas;
        incognitas = new double[3][3];
        incognitas[0][0] = n;
        incognitas[0][1] = sX;
        incognitas[0][2] = sX2;
        
        incognitas[1][0] = sX;
        incognitas[1][1] = sX2;
        incognitas[1][2] = sX3;
        
        incognitas[2][0] = sX2;
        incognitas[2][1] = sX3;
        incognitas[2][2] = sX4;
        
        double[] resultados;
        resultados = new double[3];
        resultados[0] = sY;
        resultados[1] = sXY;
        resultados[2] = sX2Y;
        
        resultados = escalonarMatriz(incognitas,resultados);
        
        return resultados;
    }   
}
