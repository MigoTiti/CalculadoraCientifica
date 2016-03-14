package calculadoracientifica.Aritmetica;

abstract class MetodosPrimitivos {
    
    public double soma(double a, double b){
        return a+b;
    }
            
    public double subtracao(double a, double b){
        return a-b;
    }
    
    public double divisao(double a, double b){
        return a/b;
    }
    
    public double multiplicacao(double a, double b){
        return a*b;
    }
    
    public double potencia(double base, double expoente){
        return Math.pow(base, expoente);
    }
    
    public double raizQuadrada(double a){
        return Math.sqrt(a);
    }
    
    public double resto(double dividendo, double divisor){
        return dividendo % divisor;
    }
    
    public double log10(double a){
        return Math.log10(a);
    }
    
    public double logNatural(double a){
        return Math.log(a);
    }
    
    public double seno(double a){
        return Math.sin(a);
    }
    
    public double cosseno(double a){
        return Math.cos(a);
    }
    
    public double tangente(double a){
        return Math.tan(a);
    }
}
