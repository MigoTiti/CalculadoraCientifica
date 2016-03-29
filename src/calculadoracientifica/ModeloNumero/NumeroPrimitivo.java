package calculadoracientifica.ModeloNumero;

public abstract class NumeroPrimitivo {
    
    public NumeroPrimitivo(){
        this.valor = 0;
        this.negativo = false;
    }
    
    public NumeroPrimitivo(double valor){
        this.valor = valor;
        if(valor < 0)
            this.negativo = true;
    }
    
    public double getNumero(){
        return valor;
    }
    
    public char getSinal(){
        if(negativo)
            return '-';
        else
            return '+';
    }
    
    protected boolean negativo;
    protected double valor;
}
