package calculadoracientifica.Aritmetica.Integral;

import calculadoracientifica.Graficos.CalculadoraGraficos;
import java.util.ArrayList;

public class CalculadoraIntegral extends CalculadoraGraficos{
    
    public CalculadoraIntegral(){}
    
    public static void mudarPrecisao(double P){
        if(P<1)
            CalculadoraIntegral.TOL = P;
    }
    
    public double integralAdaptativaNumerica(double limS, double limI, ArrayList<Double> numeros, ArrayList<String> sinais, ArrayList<Integer> posicoes){
         double c = (limS+limI)/2, h = limS - limI;
         double ya, yb, yc, s;

         ya = interpretadorIntermediario(limI,new ArrayList<>(posicoes),new ArrayList<>(numeros),new ArrayList<>(sinais));
         yc = interpretadorIntermediario(c,new ArrayList<>(posicoes),new ArrayList<>(numeros),new ArrayList<>(sinais));
         yb = interpretadorIntermediario(limS,new ArrayList<>(posicoes),new ArrayList<>(numeros),new ArrayList<>(sinais));
         s = (h/6)*(ya + 4*yc + yb);
         
         return metodoSimpson(limS,limI,s,ya,yb,yc,numeros,sinais,posicoes,TOL);  
    }
    
    public double integralAdaptativaArea(double limS, double limI, ArrayList<Double> numeros, ArrayList<String> sinais, ArrayList<Integer> posicoes){

        double ya, yb, yc, yAtual, yAnterior, s, integral = 0, delta = TOL, xInferior = limI+delta, xSuperior, c, h;
        ArrayList<Double> limites = new ArrayList<>(), integraisParciais = new ArrayList<>();
        limites.add(limI);
        
        for(double n = xInferior;n<=limS-delta;n+=delta){
            yAnterior = interpretadorIntermediario(n-delta,new ArrayList<>(posicoes),new ArrayList<>(numeros),new ArrayList<>(sinais));
            yAtual = interpretadorIntermediario(n,new ArrayList<>(posicoes),new ArrayList<>(numeros),new ArrayList<>(sinais));
            if((yAtual<0&&yAnterior>=0)||(yAtual>0&&yAnterior<=0))
                limites.add(n);
        }
        limites.add(limS);
        
        while(limites.size()>1){
            xInferior = limites.get(limites.size()-2);
            xSuperior = limites.get(limites.size()-1);
            h = xSuperior - xInferior;
            c = (xInferior+xSuperior)/2;
            ya = interpretadorIntermediario(xInferior,new ArrayList<>(posicoes),new ArrayList<>(numeros),new ArrayList<>(sinais));
            yc = interpretadorIntermediario(c,new ArrayList<>(posicoes),new ArrayList<>(numeros),new ArrayList<>(sinais));
            yb = interpretadorIntermediario(xSuperior,new ArrayList<>(posicoes),new ArrayList<>(numeros),new ArrayList<>(sinais));
            s = (h/6)*(ya + 4*yc + yb);
            integraisParciais.add((metodoSimpson(xSuperior,xInferior,s,ya,yb,yc,numeros,sinais,posicoes,TOL)));
            limites.remove(limites.size()-1);
        }
        
        for(Double integralParcial : integraisParciais){
            integral+=integralParcial;
        }

        return integral;
    }
    
    private double metodoSimpson(double limS, double limI, double s, double ya, double yb, double yc, ArrayList<Double> numeros, ArrayList<String> sinais, ArrayList<Integer> posicoes, double epsilon){
        double c = (limS+limI)/2, h = limS - limI;
        double d = (limI+c)/2, e = (c+limS)/2;
        
        double yd = interpretadorIntermediario(d,new ArrayList<>(posicoes),new ArrayList<>(numeros),new ArrayList<>(sinais));
        double ye = interpretadorIntermediario(e,new ArrayList<>(posicoes),new ArrayList<>(numeros),new ArrayList<>(sinais));
        
        double sEsquerda = (h/12)*(ya + 4*yd + yc);
        double sDireita = (h/12)*(yc + 4*ye + yb);
        
        double s2 = sEsquerda+sDireita;
        
        if(Math.abs((s2-s))<=15*epsilon)
            return Math.abs(s2 + (s2-s)/15);
        return metodoSimpson(limI,c,sEsquerda,ya,yc,yd,numeros,sinais,posicoes,TOL/2)+metodoSimpson(c,limS,sDireita,yc,yb,ye,numeros,sinais,posicoes,TOL/2);
    }
    
    private static double TOL = 1e-5;
}
