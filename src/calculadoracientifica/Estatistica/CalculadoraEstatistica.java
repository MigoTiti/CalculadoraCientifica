package calculadoracientifica.Estatistica;

import calculadoracientifica.Aritmetica.Calculadora;
import java.util.ArrayList;
import java.util.Collections;

public class CalculadoraEstatistica extends Calculadora{
    
    public CalculadoraEstatistica(){}
    
    public double media(ArrayList<Double> elementos){
        double somatorio = 0, media;
        int n = elementos.size();
        for(int i = 0;i<n;i++){
            somatorio = soma(somatorio,elementos.get(i));
        }
        media = divisao(somatorio,n);
        return media;
    }
    
    public double mediana(ArrayList<Double> elementos){
        double mediana;
        int n = elementos.size(), n1 = (n-1)/2, n2 = n1+1;        
        Collections.sort(elementos);
        if(n % 2 == 0)
            mediana = divisao(soma(elementos.get(n1),elementos.get(n2)),2);
        else
            mediana = (elementos.get(n1));
        return mediana;
    }
 
    public String moda(ArrayList<Double> elementos){
      
        ArrayList<Double> elementosUnicos;
        elementosUnicos = eliminarRepeticao(elementos);
        
        ArrayList<Double> ocorrencias;
        ocorrencias = new ArrayList<>(elementosUnicos);

        for(int i=0;i<ocorrencias.size();i++){
            ocorrencias.remove(i);
            ocorrencias.add(i, 1.0);
        }
        
        boolean sucesso = false;
        int iteracoes = 0;
        int tamanho2 = 0;
        do{
            for(int i=tamanho2;i<elementosUnicos.size();i++){
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
    
    public double variancia(ArrayList<Double> elementos){

        double media = media(elementos);
        double somatoria = 0;
        for (Double elemento : elementos) {
            double expressao = subtracao(elemento,media);
            expressao = potencia(expressao, 2);
            somatoria = soma(somatoria,expressao);
        }
        
        double variancia = divisao(somatoria,elementos.size());
        return variancia;
    }
    
    public double desvioPadrao(ArrayList<Double> elementos){
        return raizQuadrada(variancia(elementos));
    }
    
    public ArrayList<Double> desvios(ArrayList<Double> elementos){
        ArrayList<Double> desvios = new ArrayList<>();
        double media = media(elementos);
        for (Double elemento : elementos) {
            double desvio = subtracao(elemento,media);
            desvios.add(desvio);
        }
        return desvios;
    }
    
    public double coeficienteVariacao(ArrayList<Double> elementos){
        return multiplicacao(100,(divisao(desvioPadrao(elementos),media(elementos))));
    }
    
    private static ArrayList<Double> eliminarRepeticao(ArrayList<Double> elementos){
        ArrayList<Double> elementosUnicos = new ArrayList<>();
        elementosUnicos.add(elementos.get(0));
        for (Double auxiliar : elementos) {
            if(!elementosUnicos.contains(auxiliar))
                elementosUnicos.add(auxiliar);
        }
        return elementosUnicos;
    }
}
