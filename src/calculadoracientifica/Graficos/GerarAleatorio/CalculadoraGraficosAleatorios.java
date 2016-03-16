package calculadoracientifica.Graficos.GerarAleatorio;

import calculadoracientifica.Graficos.CalculadoraGraficos;
import java.util.ArrayList;

public class CalculadoraGraficosAleatorios extends CalculadoraGraficos{
    
    public CalculadoraGraficosAleatorios(){
        this.sinaisConstrutor = new ArrayList<>();
        this.numerosConstrutor = new ArrayList<>();
        this.posicoesX = new ArrayList<>();
    }
    
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
    
    
    
    private ArrayList<String> sinaisConstrutor;
    private ArrayList<Double> numerosConstrutor;
    private ArrayList<Integer> posicoesX;
    private String equacao;
}
