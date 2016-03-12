package calculadoracientifica.Graficos;

import calculadoracientifica.Aritmetica.Calculadora;
import java.util.ArrayList;

public class CalculadoraGraficos extends Calculadora{
    
    public CalculadoraGraficos(){}
    
    public double interpretadorIntermediario(double x, ArrayList<Integer> posicoes, ArrayList<Double> numeros, ArrayList<String> sinais){
        int index = numeros.size()+posicoes.size();
        if(posicoes.size()>0){
            do{
                for(int i=0;i<index;i++){
                    if(posicoes.get(0)==i){
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
