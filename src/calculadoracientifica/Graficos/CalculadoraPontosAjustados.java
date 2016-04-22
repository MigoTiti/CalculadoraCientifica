package calculadoracientifica.Graficos;

import GUI.GraficosAjustados;
import calculadoracientifica.Aritmetica.CalculadoraAritmetica;
import calculadoracientifica.Interfaces.AjustesGraficos;
import java.util.ArrayList;

public class CalculadoraPontosAjustados extends CalculadoraAritmetica implements AjustesGraficos {

    public CalculadoraPontosAjustados(boolean radianos) {
        super(radianos);
        this.sinaisConstrutor = new ArrayList<>();
        this.numerosConstrutor = new ArrayList<>();
        this.posicoesX = new ArrayList<>();
    }

    public CalculadoraPontosAjustados(String equacao) {
        super(false);
        equacao += "!";

        if (equacao.contains(",")) {
            equacao = equacao.replaceAll("\\,", ".");
        }

        this.equacao = equacao;
        this.sinaisConstrutor = new ArrayList<>();
        this.numerosConstrutor = new ArrayList<>();
        this.posicoesX = new ArrayList<>();
    }

    public CalculadoraPontosAjustados(CalculadoraPontosAjustados c1) {
        super(c1.radianos);
        this.equacao = c1.equacao;
        this.sinaisConstrutor = c1.sinaisConstrutor;
        this.numerosConstrutor = c1.numerosConstrutor;
        this.posicoesX = c1.posicoesX;
    }

    public double interpretadorIntermediario(double x, ArrayList<Integer> posicoes, ArrayList<Double> numeros, ArrayList<String> sinais) {
        int index = numeros.size() + posicoes.size();
        if (posicoes.size() > 0) {
            do {
                for (int i = 0; i < index; i++) {
                    if (Math.abs(posicoes.get(0)) == i) {
                        if (posicoes.get(0) < 0) {
                            numeros.add(i, -x);
                        } else {
                            numeros.add(i, x);
                        }
                        posicoes.remove(0);
                        break;
                    }
                }
            } while (posicoes.size() > 0);
        }
        double y = interpretador(numeros, sinais);
        return y;
    }

    @Override
    public void interpretadorStrings() {
        @SuppressWarnings("ReplaceStringBufferByString")

        StringBuilder equacaoInteira = new StringBuilder(equacao);
        boolean exp = false;
        if (equacao.contains("e"))
            exp = true;

        boolean anteriorNumero = false;
        boolean primeiroChar = true;
        int contadorNumero = 0;

        do {
            EXTERNO:
            for (int i = 0; i < equacaoInteira.length(); i++) {
                String atual = String.valueOf(equacaoInteira.charAt(i));

                switch (atual) {
                    case "-":
                        if (primeiroChar) {
                            if (i > 0) {
                                numerosConstrutor.add(Double.valueOf(equacaoInteira.substring(0, i)));
                                equacaoInteira.delete(0, i);
                                contadorNumero++;
                                anteriorNumero = true;
                                primeiroChar = false;
                                break EXTERNO;
                            }
                        } else {
                            if (i > 0) {
                                numerosConstrutor.add(Double.valueOf(equacaoInteira.substring(0, i)));
                                equacaoInteira.delete(0, i);
                                contadorNumero++;
                                anteriorNumero = true;
                                primeiroChar = false;
                                break EXTERNO;
                            } else {
                                sinaisConstrutor.add(atual);
                                equacaoInteira.deleteCharAt(i);
                                anteriorNumero = false;
                                break EXTERNO;
                            }
                        }
                    case "+":
                    case "*":
                    case "/":
                    case "^":
                        if (i > 0) {
                            numerosConstrutor.add(Double.valueOf(equacaoInteira.substring(0, i)));
                            sinaisConstrutor.add(atual);
                            equacaoInteira.delete(0, i + 1);
                            contadorNumero++;
                            anteriorNumero = true;
                            primeiroChar = false;
                            break EXTERNO;
                        } else {
                            sinaisConstrutor.add(atual);
                            equacaoInteira.deleteCharAt(i);
                            anteriorNumero = false;
                            primeiroChar = false;
                            break EXTERNO;
                        }
                    case "x":
                        if (anteriorNumero) {
                            numerosConstrutor.add(Double.valueOf(equacaoInteira.substring(0, i)));
                            sinaisConstrutor.add("*");
                            posicoesX.add(++contadorNumero);
                            equacaoInteira.delete(0, i + 1);
                            anteriorNumero = false;
                            primeiroChar = false;
                            break EXTERNO;
                        } else {
                            posicoesX.add(contadorNumero++);
                            anteriorNumero = false;
                            equacaoInteira.deleteCharAt(i);
                            primeiroChar = false;
                            break EXTERNO;
                        }
                    case "!":
                        if (equacaoInteira.length() == 1) {
                            equacaoInteira.deleteCharAt(i);
                            break;
                        } else {
                            numerosConstrutor.add(Double.valueOf(equacaoInteira.substring(0, i)));
                            equacaoInteira.delete(0, i + 1);
                            break;
                        }
                    case "e":
                        if (anteriorNumero) {
                            numerosConstrutor.add(Double.valueOf(equacaoInteira.substring(0, i)));
                            sinaisConstrutor.add("*");
                            numerosConstrutor.add(Math.E);
                            equacaoInteira.delete(0, i + 1);
                            contadorNumero++;
                            primeiroChar = false;
                            break EXTERNO;
                        }
                        break;
                    default:
                        anteriorNumero = true;
                        break;
                }
            }
        } while (equacaoInteira.length() > 0);
        if (exp) {
            sinaisConstrutor.add(2, "(");
            sinaisConstrutor.add(4, ")");
        }
    }

    @Override
    public void criarPontosAjustados(ArrayList<Double> x, ArrayList<Double> yOriginal) {
        ArrayList<Double> y = new ArrayList<>();
        ArrayList<Integer> xPosicoes2;
        ArrayList<Double> operadoresAuxiliar2;
        ArrayList<String> sinais2;

        for (int i = 0; i <= x.size() - 1; i++) {
            xPosicoes2 = new ArrayList<>(posicoesX);
            operadoresAuxiliar2 = new ArrayList<>(numerosConstrutor);
            sinais2 = new ArrayList<>(sinaisConstrutor);
            y.add(interpretadorIntermediario(x.get(i), xPosicoes2, operadoresAuxiliar2, sinais2));
        }

        plotarGraficoAjustado = new GraficosAjustados(x, y, yOriginal);
        plotarGraficoAjustado.criarGrafico();
        plotarGraficoAjustado.setVisible(true);
    }

    @Override
    public String toString() { return equacao; }

    private GraficosAjustados plotarGraficoAjustado;
    private ArrayList<String> sinaisConstrutor;
    private ArrayList<Double> numerosConstrutor;
    private ArrayList<Integer> posicoesX;
    private String equacao;
}
