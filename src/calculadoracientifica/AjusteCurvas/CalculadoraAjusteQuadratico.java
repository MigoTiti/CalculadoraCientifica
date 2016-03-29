package calculadoracientifica.AjusteCurvas;

import java.util.ArrayList;

public class CalculadoraAjusteQuadratico extends CalculadoraMinimosQuadrados{
    
    public CalculadoraAjusteQuadratico(){
        this.n = 0;
        this.sX = 0;
        this.sY = 0;
        this.sX2 = 0;
        this.sX3 = 0;
        this.sX4 = 0;
        this.sXY = 0;
        this.sX2Y = 0;
        
    }
    
    public CalculadoraAjusteQuadratico(ArrayList<Double> x, ArrayList<Double> y){
        this.n = x.size();
        for(int i = 0;i<n;i++){
            this.sX+=x.get(i);
            this.sY+=y.get(i);
            this.sX2+=Math.pow(x.get(i), 2);
            this.sX3+=Math.pow(x.get(i), 3);
            this.sX4+=Math.pow(x.get(i), 4);
            this.sXY+=x.get(i)*y.get(i);
            this.sX2Y+=Math.pow(x.get(i),2)*y.get(i);
        }
    }
    
    public CalculadoraAjusteQuadratico(CalculadoraAjusteQuadratico c1){
        this.n = c1.n;
        this.sX = c1.sX;
        this.sY = c1.sY;
        this.sX2 = c1.sX2;
        this.sX3 = c1.sX3;
        this.sX4 = c1.sX4;
        this.sXY = c1.sXY;
        this.sX2Y = c1.sX2Y;
    }

    @Override
    public double[] MinimosQuadradosAjuste() {
     
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
    
    @Override
    public String toString(){
        return "Número de elementos: "+n;
    }
    
    private int n;
    private double sX, sY, sX2, sX3, sX4, sX2Y, sXY;
}
