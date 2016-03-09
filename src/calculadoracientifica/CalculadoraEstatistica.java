package calculadoracientifica;

import java.util.ArrayList;

public class CalculadoraEstatistica {
    
    public CalculadoraEstatistica(){}
    
    public double media(ArrayList<Double> elementos){
        double soma = 0, media;
        int n = elementos.size();
        for(int i = 0;i<n;i++){
            soma = soma + elementos.get(i);
        }
        media = soma/n;
        return media;
    }
 
}
