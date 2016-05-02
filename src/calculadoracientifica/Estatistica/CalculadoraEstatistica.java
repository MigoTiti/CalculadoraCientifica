package calculadoracientifica.Estatistica;

import calculadoracientifica.Aritmetica.CalculadoraAritmetica;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;

public class CalculadoraEstatistica extends CalculadoraAritmetica {

    public CalculadoraEstatistica() { this.elementos = new ArrayList<>(); }

    public CalculadoraEstatistica(ArrayList<Double> elementos) { this.elementos = elementos; }

    public CalculadoraEstatistica(CalculadoraEstatistica c1) { this.elementos = c1.elementos; }

    public double media() {
        double somatorio = 0, media;
        int n = elementos.size();
        for (int i = 0; i < n; i++) {
            somatorio = soma(somatorio, elementos.get(i));
        }
        media = divisao(somatorio, n);
        return media;
    }

    public double mediana() {
        double mediana;
        int n = elementos.size(), n1 = (int)divisao(subtracao(n,1.0),2), n2 = (int)soma(n1,1); //n1 = (n-1)/2, n2 = n1 + 1
        Collections.sort(elementos);
        if (resto(n,2) == 0) {
            mediana = divisao(soma(elementos.get(n1), elementos.get(n2)), 2);
        } else {
            mediana = (elementos.get(n1));
        }
        return mediana;
    }

    public String moda() {

        HashMap<Double, Integer> ocorrencias = new HashMap<>();
        
        elementos.stream()
            .forEach((Double elemento) -> {
            ocorrencias.put(elemento, null);
        });
        
        Iterator<Entry<Double,Integer>> iteradorMapa = ocorrencias.entrySet().iterator();
        
        while(iteradorMapa.hasNext()){
            Map.Entry aux = iteradorMapa.next();
            int ocorrenciasN = 0;
            ocorrenciasN = elementos.stream()
                    .filter((elemento1) -> (Objects.equals(elemento1, aux.getKey())))
                    .map((Double anonimo) -> 1)
                    .reduce(ocorrenciasN, Integer::sum);
            ocorrencias.put((Double)aux.getKey(), ocorrenciasN);
        }

        Comparator<Entry<Double, Integer>> maiorValor = 
           (entrada1, entrada2) -> entrada1.getValue().compareTo(
            entrada2.getValue());
        
        Optional<Entry<Double, Integer>> maxValue = ocorrencias.entrySet()
            .stream()
            .max(maiorValor);
        
        int contador = 0;
        double moda = 0.0;
        
        iteradorMapa = ocorrencias.entrySet().iterator();
        
        while(iteradorMapa.hasNext()){
            Map.Entry aux = iteradorMapa.next();
            if((int)aux.getValue()==(int)maxValue.get().getValue()){
                moda = (double)aux.getKey();
                contador++;
            }
        }
        
        if (contador > 1) {
            return "Não existe moda.";
        } else {
            return (Double.toString(moda));
        }
    }

    public double variancia() {

        double media = media();
        double somatoria = 0;
        for (Double elemento : elementos) {
            double expressao = subtracao(elemento, media);
            expressao = potencia(expressao, 2);
            somatoria = soma(somatoria, expressao);
        }

        double variancia = divisao(somatoria, elementos.size());
        return variancia;
    }

    public double desvioPadrao() {
        return raizQuadrada(variancia());
    }

    public ArrayList<Double> desvios() {
        ArrayList<Double> desvios = new ArrayList<>();
        double media = media();
        elementos.stream().map((elemento) -> subtracao(elemento, media)).forEach((desvio) -> {
            desvios.add(desvio);
        });
        return desvios;
    }

    public double coeficienteVariacao() { return multiplicacao(100, (divisao(desvioPadrao(), media()))); }
    
    @Override
    public String toString() {
        if (elementos.size() > 0) {
            String aux = "Elementos: " + Double.toString(elementos.get(0));
            if (elementos.size() > 1) {
                aux = elementos
                        .stream()
                        .map((elemento) -> ", " + Double.toString(elemento))
                        .reduce(aux, String::concat);
            }
            return aux;
        } else {
            return "Sem elementos.";
        }
    }

    private ArrayList<Double> elementos;
}
