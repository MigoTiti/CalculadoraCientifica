package calculadoracientifica.ModeloNumero.Unidades;

import calculadoracientifica.ModeloNumero.NumeroPrimitivo;

public class NumeroMassa extends NumeroPrimitivo{
    
    public NumeroMassa(double valor, final String unidadeMassa){
        super(valor);
        this.unidadeMassa = unidadeMassa;
    }
    
    public String getUnidade(){
        return this.unidadeMassa;
    }
    
    @Override
    public String toString(){
        return this.getSinal()+Math.abs(this.valor)+this.unidadeMassa;
    }
    
    private final String unidadeMassa;
}
