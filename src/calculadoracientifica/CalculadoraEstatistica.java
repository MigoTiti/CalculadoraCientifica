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
        double mediana;
        int n = elementos.size(), n1 = (n-1)/2, n2 = n1+1;        
        Collections.sort(elementos);
        if(n % 2 == 0)
            mediana = (elementos.get(n1)+elementos.get(n2))/2;
        else
            mediana = (elementos.get(n1));
        return mediana;
    }
 
    private ArrayList<Double> fatorar(ArrayList<Double> elementos){
        ArrayList<Double> elementosFatorados = new ArrayList<>();
        elementosFatorados.add(elementos.get(0));
        for(int i=0;i<elementos.size();i++){
            Double n = elementos.get(i);
            if(!elementosFatorados.contains(n))
                elementosFatorados.add(n);
        }
        return elementosFatorados;
    }
    
    public String moda(ArrayList<Double> elementos){
      
        ArrayList<Double> elementosComparar;
        elementosComparar = fatorar(elementos);
        
        ArrayList<Double> ocorrencias;
        ocorrencias = new ArrayList<>(elementosComparar);

        for(int i=0;i<ocorrencias.size();i++){
            ocorrencias.remove(i);
            ocorrencias.add(i, 0.0);
        }        
        boolean sucesso = false;
        int iteracoes = 0;
        int tamanho2 = 0;
        do{
            for(int i=tamanho2;i<elementosComparar.size();i++){
                if(sucesso){
                    sucesso = false;
                    break;
                }
                double x = elementos.get(i);
                for(int j=tamanho2+1;j<elementos.size();j++){
                    double n = elementos.get(j);
                    if(n==x){
                        double ocorrencia = ocorrencias.get(i);
                        ocorrencias.remove(i);
                        ocorrencias.add(i,ocorrencia+1);
                        sucesso = true;
                        break;
                    }
                }        
            }
            tamanho2++;
            iteracoes++;
        }while(iteracoes<elementos.size());
        
        int contador = 0;
        double moda = 0;        
        double maior = Collections.max(ocorrencias);
        for(int i=0;i<ocorrencias.size();i++){
            if (ocorrencias.get(i).equals(maior)){
                moda = elementos.get(i);
                contador++;
            }
        }
        
        if(contador>1)
            return "Não existe moda.";
        else
            return (Double.toString(moda));
    }
}
