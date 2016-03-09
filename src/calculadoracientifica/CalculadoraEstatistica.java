package calculadoracientifica;

import java.util.ArrayList;
import java.util.Collections;

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
    
    public double mediana(ArrayList<Double> elementos){
        double mediana = 0;
        int n = elementos.size(), n1 = (n-1)/2, n2 = n1+1;        
        Collections.sort(elementos);
        if(n % 2 == 0)
            mediana = (elementos.get(n1)+elementos.get(n2))/2;
        else
            mediana = (elementos.get(n1));
        return mediana;
    }
 
    
}
