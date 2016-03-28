package calculadoracientifica.Graficos;

import calculadoracientifica.Aritmetica.CalculadoraAritmetica;
import java.util.ArrayList;

public class CalculadoraPontos extends CalculadoraAritmetica{
    
    public CalculadoraPontos(){
        super(true);
    }
    
    public CalculadoraPontos(boolean radianos){
        super(radianos);
    }
    
    public CalculadoraPontos(CalculadoraPontos c1){
        super(c1.radianos);
    }
    
    public double interpretadorIntermediario(double x, ArrayList<Integer> posicoes, ArrayList<Double> numeros, ArrayList<String> sinais){
        int index = numeros.size()+posicoes.size();
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
    
}
