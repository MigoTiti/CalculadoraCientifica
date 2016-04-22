package calculadoracientifica.Aritmetica;

import java.util.ArrayList;
import java.util.Collections;

public class CalculadoraAritmetica extends CalculadoraPrimitiva {

    public CalculadoraAritmetica() {
        this.radianos = true;
    }

    public CalculadoraAritmetica(boolean radianos) {
        this.radianos = radianos;
    }

    public CalculadoraAritmetica(CalculadoraAritmetica c1) {
        this.radianos = c1.radianos;
    }

    public void mudarStatus(String nome) {
        if ("radianos".equals(nome) && !radianos) 
            radianos = true;
        else if ("graus".equals(nome) && radianos) 
            radianos = false;
    }

    @Override
    public double interpretador(ArrayList<Double> numeros, ArrayList<String> sinais) {
        String sinal;
        int contParenteses = 0;

        ArrayList<Integer> prioridadesParenteses = new ArrayList<>(sinais.size());

        while(prioridadesParenteses.size() < sinais.size()) prioridadesParenteses.add(0);
        
        for (int i = sinais.size()-1; i >= 0; i--) {
            sinal = sinais.get(i);
            switch (sinal) {
                case ")":
                    ++contParenteses;
                    sinais.remove(i);
                    prioridadesParenteses.remove(i);
                    break;
                case "(":
                    --contParenteses;
                    sinais.remove(i);
                    prioridadesParenteses.remove(i);
                    break;
                default:
                    prioridadesParenteses.remove(i);
                    prioridadesParenteses.add(i, contParenteses);
            }
        }
        
        ArrayList<Integer> prioridades = new ArrayList<>(sinais.size()); 
        
        for (int i = 0; i < sinais.size(); i++) {
            sinal = sinais.get(i);
            switch (sinal) {
                case "+":
                case "-":
                    prioridades.add(Prioridades.SOMA.getPrioridade() + (prioridadesParenteses.get(i) * 4));
                    break;
                case "%":
                case "*":
                case "/":
                    prioridades.add(Prioridades.MULTIPLICACAO.getPrioridade() + (prioridadesParenteses.get(i) * 4));
                    break;
                case "^":
                    prioridades.add(Prioridades.POTENCIA.getPrioridade() + (prioridadesParenteses.get(i) * 4));
                    break;
                case "sqrt":
                case "log":
                case "ln":
                case "sen":
                case "cos":
                case "tg":
                    prioridades.add(Prioridades.TRIGONOMETRICARAIZLOG.getPrioridade() + (prioridadesParenteses.get(i) * 4));
                    break;
            }
        }
        
        prioridadesParenteses.clear();
        
        do {
            numeros = operacao(numeros, sinais, prioridades, Collections.max(prioridades));
        } while (sinais.size() > 0);
        
        return numeros.get(0);
    }

    protected ArrayList<Double> operacaoDupla(ArrayList<Double> numeros, String sinal, int i) {
        double auxiliar;
        switch (sinal) {
            case "+":
                auxiliar = soma(numeros.get(i), numeros.get(i + 1));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "-":
                auxiliar = subtracao(numeros.get(i), numeros.get(i + 1));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "*":
                auxiliar = multiplicacao(numeros.get(i), numeros.get(i + 1));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "/":
                auxiliar = divisao(numeros.get(i), numeros.get(i + 1));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "^":
                auxiliar = potencia(numeros.get(i), numeros.get(i + 1));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "%":
                auxiliar = resto(numeros.get(i), numeros.get(i + 1));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
        }
        return numeros;
    }

    protected ArrayList<Double> operacaoUnica(ArrayList<Double> numeros, String sinal, int i) {
        double auxiliar;
        switch (sinal) {
            case "sqrt":
                auxiliar = raizQuadrada(numeros.get(i));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "log":
                auxiliar = log10(numeros.get(i));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "ln":
                auxiliar = logNatural(numeros.get(i));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "sen":
                if (radianos)
                    auxiliar = seno(numeros.get(i));
                else
                    auxiliar = seno(Math.toRadians(numeros.get(i)));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "cos":
                if (radianos) 
                    auxiliar = cosseno(numeros.get(i));
                else 
                    auxiliar = cosseno(Math.toRadians(numeros.get(i)));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "tg":
                if (radianos)
                    auxiliar = tangente(numeros.get(i));
                else
                    auxiliar = tangente(Math.toRadians(numeros.get(i)));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
        }
        return numeros;
    }

    protected ArrayList<Double> operacao(ArrayList<Double> numeros, ArrayList<String> sinais, ArrayList<Integer> prioridades, int maior) {
        String sinal;
        int nUnicos = 0;
        for (int i = 0; i < sinais.size(); i++) {
            if (prioridades.get(i) == maior) {
                sinal = sinais.get(i);
                for (int j = 0; j < i; j++) {
                    if (("sqrt".equals(sinais.get(j)) || "sen".equals(sinais.get(j)) 
                      || "cos".equals(sinais.get(j)) || "tg".equals(sinais.get(j)) 
                      || "log".equals(sinais.get(j)) || "ln".equals(sinais.get(j)))) {
                        nUnicos++;
                    }
                }
                if ("+".equals(sinal) || "%".equals(sinal) || "-".equals(sinal) 
                 || "*".equals(sinal) || "/".equals(sinal) || "^".equals(sinal)) {
                    operacaoDupla(numeros, sinal, i - nUnicos);
                    numeros.remove(i - (nUnicos - 1));
                    sinais.remove(i);
                    prioridades.remove(i);
                    return numeros;
                } else {
                    operacaoUnica(numeros, sinal, i - nUnicos);
                    sinais.remove(i);
                    prioridades.remove(i);
                    return numeros;
                }
            }
        }
        return numeros;
    }

    @Override
    public String toString() {
        if (radianos) {
            return "Usando radianos";
        } else {
            return "Usando graus";
        }
    }

    protected boolean radianos;

}
