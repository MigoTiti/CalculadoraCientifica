package calculadoracientifica.Estatistica;

import calculadoracientifica.Aritmetica.CalculadoraAritmetica;
import java.util.ArrayList;
import java.util.Collections;

public class CalculadoraEstatistica extends CalculadoraAritmetica {

    public CalculadoraEstatistica() {
        super(true);
        this.elementos = new ArrayList<>();
    }

    public CalculadoraEstatistica(ArrayList<Double> elementos) {
        super(true);
        this.elementos = elementos;
    }

    public CalculadoraEstatistica(CalculadoraEstatistica c1) {
        super(c1.radianos);
        this.elementos = c1.elementos;
    }

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
        int n = elementos.size(), n1 = (n - 1) / 2, n2 = n1 + 1;
        Collections.sort(elementos);
        if (n % 2 == 0) {
            mediana = divisao(soma(elementos.get(n1), elementos.get(n2)), 2);
        } else {
            mediana = (elementos.get(n1));
        }
        return mediana;
    }

    public String moda() {

        ArrayList<Double> elementosUnicos;
        elementosUnicos = eliminarRepeticao();

        ArrayList<Double> ocorrencias;
        ocorrencias = new ArrayList<>(elementosUnicos);

        for (int i = 0; i < ocorrencias.size(); i++) {
            ocorrencias.remove(i);
            ocorrencias.add(i, 1.0);
        }

        boolean sucesso = false;
        int iteracoes = 0;
        int tamanho2 = 0;
        do {
            for (int i = tamanho2; i < elementosUnicos.size(); i++) {
                if (sucesso) {
                    sucesso = false;
                    break;
                }
                double x = elementos.get(i);
                for (int j = tamanho2 + 1; j < elementos.size(); j++) {
                    double n = elementos.get(j);
                    if (n == x) {
                        double ocorrencia = ocorrencias.get(i);
                        ocorrencias.remove(i);
                        ocorrencias.add(i, ocorrencia + 1);
                        sucesso = true;
                    }
                }
            }
            tamanho2++;
            iteracoes++;
        } while (iteracoes < elementos.size());

        int contador = 0;
        double moda = 0;
        double maior = Collections.max(ocorrencias);
        for (int i = 0; i < ocorrencias.size(); i++) {
            if (ocorrencias.get(i).equals(maior)) {
                moda = elementos.get(i);
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
        for (Double elemento : elementos) {
            double desvio = subtracao(elemento, media);
            desvios.add(desvio);
        }
        return desvios;
    }

    public double coeficienteVariacao() {
        return multiplicacao(100, (divisao(desvioPadrao(), media())));
    }

    private ArrayList<Double> eliminarRepeticao() {
        ArrayList<Double> elementosUnicos = new ArrayList<>();
        elementosUnicos.add(elementos.get(0));
        for (Double auxiliar : elementos) {
            if (!elementosUnicos.contains(auxiliar)) {
                elementosUnicos.add(auxiliar);
            }
        }
        return elementosUnicos;
    }

    @Override
    public String toString() {
        if (elementos.size() > 0) {
            String aux = "Elementos: " + Double.toString(elementos.get(0));
            if (elementos.size() > 1) {
                for (Double elemento : elementos) {
                    aux += ", " + Double.toString(elemento);
                }
            }
            return aux;
        } else {
            return "Sem elementos.";
        }
    }

    private ArrayList<Double> elementos;
}
