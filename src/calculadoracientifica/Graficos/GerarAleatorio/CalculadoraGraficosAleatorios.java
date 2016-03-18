package calculadoracientifica.Graficos.GerarAleatorio;

import calculadoracientifica.Graficos.CalculadoraGraficos;
import java.util.ArrayList;
import java.util.Random;

public class CalculadoraGraficosAleatorios extends CalculadoraGraficos{
    
    public CalculadoraGraficosAleatorios(){
        this.sinaisConstrutor = new ArrayList<>();
        this.numerosConstrutor = new ArrayList<>();
        this.posicoesX = new ArrayList<>();
        this.gerador = new Random();
        this.equacao = "";
        this.limInferior = gerador.nextInt(4)+1;
        this.limSuperior = gerador.nextInt(100)+10;
    }
    
    public void interpretadorStrings(){
        @SuppressWarnings("ReplaceStringBufferByString")
                
        StringBuilder equacaoInteira = new StringBuilder(equacao);
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
                            anteriorNumero = false;
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
                    case "s":
                        if(equacaoInteira.charAt(i+1)=='e'&&equacaoInteira.charAt(i+2)=='n'){
                            sinaisConstrutor.add("sen");
                            equacaoInteira.delete(i, i+3);
                            anteriorNumero = false;
                            break OUTER;
                        }
                    case "c":
                        if(equacaoInteira.charAt(i+1)=='o'&&equacaoInteira.charAt(i+2)=='s'){
                            sinaisConstrutor.add("cos");
                            equacaoInteira.delete(i, i+3);
                            anteriorNumero = false;
                            break OUTER;
                        }
                    case "t":
                        if(equacaoInteira.charAt(i+1)=='g'){
                            sinaisConstrutor.add("tg");
                            equacaoInteira.delete(i, i+2);
                            anteriorNumero = false;
                            break OUTER;
                        }
                    case "l":
                        if(equacaoInteira.charAt(i+1)=='o'&&equacaoInteira.charAt(i+2)=='g'){
                            sinaisConstrutor.add("log");
                            equacaoInteira.delete(i, i+3);
                            anteriorNumero = false;
                            break OUTER;
                        }
                    default:
                        anteriorNumero = true;
                        break;
                }
            }
        }while(equacaoInteira.length()>0);
    }
    
    public void gerarPontosAleatorios(String tipo){
        switch(tipo){
            case "linear":
                gerarLinear();
                break;
            case "quadratica":
                gerarQuadratica();
                break;
            case "exponencial":
                gerarExponencial();
                break;
            case "logaritmica":
                gerarLogaritmica();
                break;
            case "trigonometrica":
                gerarTrigonometrica();
                break;
        }
        equacao+="!";
        interpretadorStrings();
    }
    
    public String getEquacao(){
        return equacao;
    }
    
    public ArrayList<String> getSinais(){
        return sinaisConstrutor;
    }
    
    public ArrayList<Double> getNumeros(){
        return numerosConstrutor;
    }
    
    public ArrayList<Integer> getPosicoes(){
        return posicoesX;
    }
    
    public int getLimiteI(){
        return limInferior;
    }
    
    public int getLimiteS(){
        return limSuperior;
    }
    
    public int getDelta(){
        return delta;
    }
    
    private void gerarLinear(){
        int a = gerador.nextInt(20);
        if(a==0)
            a++;
        equacao+= a+"x";
        
        int b = gerador.nextInt(20);
        boolean sinalB;
        if(b!=0){
            sinalB = gerador.nextBoolean();
            if(sinalB){
                equacao+="+"+b;
            }else{
                b = Math.negateExact(b);
                equacao+=b;
            }
        }
    }
    
    private void gerarQuadratica(){
        int a = gerador.nextInt(20);
        if(a==0)
            a++;
        equacao+=a+"x^2";
        
        int b = gerador.nextInt(20);
        boolean sinalB;
        if(b!=0){
            sinalB = gerador.nextBoolean();
            if(sinalB){
                equacao+="+"+b+"x";
            }else{
                b = Math.negateExact(b);
                equacao+=b+"x";
            }
        }
        
        int c = gerador.nextInt(20);
        boolean sinalC;
        if(c!=0){
            sinalC = gerador.nextBoolean();
            if(sinalC){
                equacao+="+"+c;
            }else{
                c = Math.negateExact(c);
                equacao+=c;
            }
        }
    }
    
    private void gerarExponencial(){
        int a = gerador.nextInt(20);
        if(a==0)
            a+=2;
        equacao+=a+"^x";
        
        int b = gerador.nextInt(20);
        boolean sinalB;
        if(b!=0){
            sinalB = gerador.nextBoolean();
            if(sinalB){
                equacao+="+"+b;
            }else{
                b = Math.negateExact(b);
                equacao+=b+"";
            }
        }
    }
    
    private void gerarLogaritmica(){
        int a = gerador.nextInt(20);
        if(a==0)
            a+=2;
        equacao+=a+"+logx";
    }
    
    private void gerarTrigonometrica(){
        int escolha = gerador.nextInt(2)+1;
        switch(escolha){
            case 1:
                equacao+="senx";
                break;
            case 2:
                equacao+="cosx";
                break;
            case 3:
                equacao+="tgx";
                break;
        }
    }
    
    private final int limSuperior;
    private final int limInferior;
    private final int delta = 1;
    private final Random gerador;
    private ArrayList<String> sinaisConstrutor;
    private ArrayList<Double> numerosConstrutor;
    private ArrayList<Integer> posicoesX;
    private String equacao;
}
