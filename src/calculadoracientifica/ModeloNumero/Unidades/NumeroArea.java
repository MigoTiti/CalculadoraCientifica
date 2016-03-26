package calculadoracientifica.ModeloNumero.Unidades;

import calculadoracientifica.ModeloNumero.NumeroPrimitivo;

public class NumeroArea extends NumeroPrimitivo{
    
    public NumeroArea(double valor, final String unidadeArea){
        super(valor);
        this.unidadeArea = unidadeArea;
    }
    
    public String getUnidade(){
        return this.unidadeArea;
    }
    
    @Override
    public String toString(){
        return this.getSinal()+Math.abs(this.valor)+this.unidadeArea;
    }
    
    private final String unidadeArea;
}
