package calculadoracientifica.ajusteCurvas;

import calculadoracientifica.Interfaces.MinimosQuadrados;
import calculadoracientifica.Equacoes.CalculadoraSistemas;
import java.util.ArrayList;

public class CalculadoraAjusteLinear extends CalculadoraSistemas implements MinimosQuadrados{
    
    public CalculadoraAjusteLinear(){}
    
    @Override
    public double[] MinimosQuadradosAjuste(ArrayList<Double> x, ArrayList<Double> y){
        int n = x.size();
        double sX = 0, sY = 0, sX2 = 0, sXY = 0;
        for(int i = 0;i<n;i++){
            sX+=x.get(i);
            sY+=y.get(i);
            sX2+=Math.pow(x.get(i), 2);
            sXY+=x.get(i)*y.get(i);
        }
        
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
        
        resultados = escalonarMatriz(incognitas,resultados);
        
        return resultados;
    }
}
