package calculadoracientifica.Graficos;

import calculadoracientifica.Aritmetica.CalculadoraAritmetica;
import java.util.ArrayList;

public class CalculadoraGraficos extends CalculadoraAritmetica{
    
    public CalculadoraGraficos(){
        this.index = 0;
    }
    
    public CalculadoraGraficos(int index){
        this.index = index;
    }
    
    public CalculadoraGraficos(CalculadoraGraficos c1){
        this.index = c1.index;
    }
    
    public double interpretadorIntermediario(double x, ArrayList<Integer> posicoes, ArrayList<Double> numeros, ArrayList<String> sinais){
        index = numeros.size()+posicoes.size();
        if(posicoes.size()>0){
            do{
                for(int i=0;i<index;i++){
                    if(Math.abs(posicoes.get(0))==i){
                        if(posicoes.get(0)<0)
                            numeros.add(i, -x);
                        else
                            numeros.add(i, x);
                        posicoes.remove(0);
                        break;
                    }
                }
            }while(posicoes.size()>0);
        }
        double y = interpretador(numeros,sinais);
        return y;
    }
    
    protected int index;
}
