package calculadoracientifica.ajusteCurvas;

import GUI.GraficosAjustados;
import calculadoracientifica.Graficos.CalculadoraGraficos;
import calculadoracientifica.Interfaces.AjustesGraficos;
import java.util.ArrayList;

public class CalculadoraGraficosAjustados extends CalculadoraGraficos implements AjustesGraficos{
    
    public CalculadoraGraficosAjustados(String equacao){
        equacao = equacao + "!";
        
        if(equacao.contains(","))
            equacao = equacao.replaceAll("\\,", ".");
        
        this.equacao = equacao;
        this.sinaisConstrutor = new ArrayList<>();
        this.numerosConstrutor = new ArrayList<>();
        this.posicoesX = new ArrayList<>();
    }
    
    @Override
    public void interpretadorStrings(){
        @SuppressWarnings("ReplaceStringBufferByString")
                
        StringBuilder equacaoInteira = new StringBuilder(equacao);
        boolean exp = false;
        if(equacao.contains("e"))
            exp = true;
        boolean anteriorNumero = false;
        boolean anteriorSinal = true;
        int contadorNumero = 0;
        
        do{
            OUTER:
            for (int i = 0; i<equacaoInteira.length(); i++) {
                String atual = String.valueOf(equacaoInteira.charAt(i));
                
                switch (atual) {
                    case "-":
                        if(!(equacaoInteira.charAt(i)=='x')){
                            if(i>0){
                            numerosConstrutor.add(Double.valueOf(equacaoInteira.substring(0, i)));
                            equacaoInteira.delete(0, i);
                            contadorNumero++;
                            anteriorNumero = true;
                            break OUTER;
                            }
                        }else{
                            sinaisConstrutor.add(atual);
                            equacaoInteira.deleteCharAt(i);
                            anteriorNumero = false;
                            break OUTER;
                        }
                        break;    
                    case "+":
                    case "*":
                    case "/":
                    case "^":
                        if (i>0) {
                            numerosConstrutor.add(Double.valueOf(equacaoInteira.substring(0, i)));
                            sinaisConstrutor.add(atual);
                            equacaoInteira.delete(0, i+1);
                            contadorNumero++;
                            anteriorNumero = true;
                            break OUTER;
                        } else {
                            sinaisConstrutor.add(atual);
                            equacaoInteira.deleteCharAt(i);
                            anteriorNumero = false;
                            break OUTER;
                        }
                    case "x":
                        if (anteriorNumero) {
                            numerosConstrutor.add(Double.valueOf(equacaoInteira.substring(0, i)));
                            sinaisConstrutor.add("*");
                            posicoesX.add(++contadorNumero);
                            equacaoInteira.delete(0, i+1);
                            anteriorNumero = false;
                            break OUTER;
                        }else if(anteriorSinal){
                            posicoesX.add(contadorNumero++);
                            anteriorNumero = false;
                            equacaoInteira.deleteCharAt(i);
                            break OUTER;
                        }   
                        break;
                    case "!":
                        if(equacaoInteira.length()==1){
                            equacaoInteira.deleteCharAt(i);
                            break;
                        }else{
                            numerosConstrutor.add(Double.valueOf(equacaoInteira.substring(0, i)));
                            equacaoInteira.delete(0, i+1);
                            break;
                        }
                    case "e":
                        if (anteriorNumero) {
                            numerosConstrutor.add(Double.valueOf(equacaoInteira.substring(0, i)));
                            sinaisConstrutor.add("*");
                            numerosConstrutor.add(Math.E);
                            equacaoInteira.delete(0, i+1);
                            contadorNumero++;
                            break OUTER;
                        }
                        break;
                    default:
                        anteriorNumero = true;
                        break;
                }
            }
        }while(equacaoInteira.length()>0);
        if(exp){
            sinaisConstrutor.add(2, "(");
            sinaisConstrutor.add(4, ")");
        }
    }
    
    @Override
    public void criarPontosAjustados(ArrayList<Double> x, ArrayList<Double> yOriginal){
        ArrayList<Double> y = new ArrayList<>();
        ArrayList<Integer> xPosicoes2;
        ArrayList<Double> operadoresAuxiliar2;
        ArrayList<String> sinais2;
        
        for(int i = 0;i<=x.size()-1;i++){
            xPosicoes2 = new ArrayList<>(posicoesX);
            operadoresAuxiliar2 = new ArrayList<>(numerosConstrutor);
            sinais2 = new ArrayList<>(sinaisConstrutor);
            y.add(interpretadorIntermediario(x.get(i), xPosicoes2, operadoresAuxiliar2, sinais2));
        }
        
        plotarGraficoAjustado = new GraficosAjustados(x,y,yOriginal);
        plotarGraficoAjustado.criarGrafico();
        plotarGraficoAjustado.setVisible(true);
    }
    
    private GraficosAjustados plotarGraficoAjustado;
    private ArrayList<String> sinaisConstrutor;
    private ArrayList<Double> numerosConstrutor;
    private ArrayList<Integer> posicoesX;
    private String equacao;
}
