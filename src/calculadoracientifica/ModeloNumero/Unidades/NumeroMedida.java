package calculadoracientifica.ModeloNumero.Unidades;

import calculadoracientifica.ModeloNumero.NumeroPrimitivo;

public class NumeroMedida extends NumeroPrimitivo{
    
    public NumeroMedida(double valor, final String unidadeMedida){
        super(valor);
        this.unidadeMedida = unidadeMedida;
    }
    
    public String getUnidade(){
        return this.unidadeMedida;
    }
    
    @Override
    public String toString(){
        return this.getSinal()+Math.abs(this.valor)+this.unidadeMedida;
    }
    
    private final String unidadeMedida;
}
