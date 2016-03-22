package calculadoracientifica.Aritmetica.Integral;

import calculadoracientifica.Graficos.CalculadoraGraficos;
import java.util.ArrayList;

public class CalculadoraIntegral extends CalculadoraGraficos{
    
    public CalculadoraIntegral(){}
    
    public static void mudarPrecisao(double P){
        if(P>2)
            CalculadoraIntegral.iteracoes = P;
    }
    
    public double integral(double limS, double limI, ArrayList<Double> numeros, ArrayList<String> sinais, ArrayList<Integer> posicoes){
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();
        ArrayList<Integer> k = new ArrayList<>();
        ArrayList<Double> numeros2;
        ArrayList<String> sinais2;
        ArrayList<Integer> posicoes2;
        
        double delta = divisao(subtracao(limS,limI),iteracoes);
        
        for(double i=limI;i<=limS;i+=delta){
            numeros2 = new ArrayList<>(numeros);
            sinais2 = new ArrayList<>(sinais);
            posicoes2 = new ArrayList<>(posicoes);
            x.add(i);
            y.add(interpretadorIntermediario(i,posicoes2,numeros2,sinais2));
        }
        
        k.add(0, 1);
        
        for(int i=0;i<x.size()-1;i++){
            if(i % 2==0)
                k.add(i, 2);
            else
                k.add(i, 4);
        }
        
        k.add(x.size()-1,1);
        
        for(int i=0;i<y.size();i++){
            double resultadoParcial = y.get(i)*k.get(i);
            y.remove(i);
            y.add(i, resultadoParcial);
        }
        
        double somatorio = 0;
        
        for (Double y1 : y) {
            somatorio += y1;
        }
        
        double resultadoIntegral = (delta/3)*somatorio;
        
        return resultadoIntegral;
    }
    
    public double integralAdaptativa(double limS, double limI, ArrayList<Double> numeros, ArrayList<String> sinais, ArrayList<Integer> posicoes){

        
        double c = (limS+limI)/2, h = limS - limI;
        double ya, yb, yc, s;
        if(h<=tolTeste){
            ya = interpretadorIntermediario(limI,new ArrayList<>(posicoes),new ArrayList<>(numeros),new ArrayList<>(sinais));
            yc = interpretadorIntermediario(c,new ArrayList<>(posicoes),new ArrayList<>(numeros),new ArrayList<>(sinais));
            yb = interpretadorIntermediario(limS,new ArrayList<>(posicoes),new ArrayList<>(numeros),new ArrayList<>(sinais));
            s = (h/6)*(ya + 4*yc + yb);
            return auxSimpson(limS,limI,s,ya,yb,yc,numeros,sinais,posicoes,tol);
        }else
            return integralAdaptativa(limS,c,new ArrayList<>(numeros),new ArrayList<>(sinais),new ArrayList<>(posicoes))+integralAdaptativa(c,limI,new ArrayList<>(numeros),new ArrayList<>(sinais),new ArrayList<>(posicoes));
        
    }
    
    private double auxSimpson(double limS, double limI, double s, double ya, double yb, double yc, ArrayList<Double> numeros, ArrayList<String> sinais, ArrayList<Integer> posicoes, double epsilon){
        double c = (limS+limI)/2, h = limS - limI;
        double d = (limI+c)/2, e = (c+limS)/2;
        
        double yd = interpretadorIntermediario(d,new ArrayList<>(posicoes),new ArrayList<>(numeros),new ArrayList<>(sinais));
        double ye = interpretadorIntermediario(e,new ArrayList<>(posicoes),new ArrayList<>(numeros),new ArrayList<>(sinais));
        
        double sEsquerda = (h/12)*(ya + 4*yd + yc);
        double sDireita = (h/12)*(yc + 4*ye + yb);
        
        double s2 = sEsquerda+sDireita;
        
        if(Math.abs((s2-s))<=15*epsilon)
            return s2 + (s2-s)/15;
        return auxSimpson(limI,c,sEsquerda,ya,yc,yd,numeros,sinais,posicoes,tol/2)+auxSimpson(c,limS,sDireita,yc,yb,ye,numeros,sinais,posicoes,tol/2);
    }
    
    private static double iteracoes = 6;
    private static final double tolTeste = 1;
    private static final double tol = 0.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001;
}
