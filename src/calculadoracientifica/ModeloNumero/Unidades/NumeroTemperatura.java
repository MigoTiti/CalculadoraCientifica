package calculadoracientifica.ModeloNumero.Unidades;

import calculadoracientifica.ModeloNumero.NumeroPrimitivo;

public class NumeroTemperatura extends NumeroPrimitivo{
    
    public NumeroTemperatura(double valor, final String unidadeTemperatura){
        super(valor);
        this.unidadeTemperatura = unidadeTemperatura;
    }
    
    public String getUnidade(){
        return this.unidadeTemperatura;
    }
    
    @Override
    public String toString(){
        return this.getSinal()+Math.abs(this.valor)+this.unidadeTemperatura;
    }
    
    private final String unidadeTemperatura;
}
