package calculadoracientifica.ModeloNumero.Unidades;

import calculadoracientifica.ModeloNumero.NumeroPrimitivo;

public class NumeroTempo extends NumeroPrimitivo{
    
    public NumeroTempo(double valor, final String unidadeTempo){
        super(valor);
        this.unidadeTempo = unidadeTempo;
    }
    
    public String getUnidade(){
        return this.unidadeTempo;
    }
    
    @Override
    public String toString(){
        return this.getSinal()+Math.abs(this.valor)+this.unidadeTempo;
    }
    
    private final String unidadeTempo;
}
