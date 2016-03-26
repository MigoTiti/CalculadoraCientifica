package calculadoracientifica.ModeloNumero.Unidades;

import calculadoracientifica.ModeloNumero.NumeroPrimitivo;

public class NumeroEnergia extends NumeroPrimitivo{
    
    public NumeroEnergia(double valor, final String unidadeEnergia){
        super(valor);
        this.unidadeEnergia = unidadeEnergia;
    }
    
    public String getUnidade(){
        return this.unidadeEnergia;
    }
    
    @Override
    public String toString(){
        return this.getSinal()+Math.abs(this.valor)+this.unidadeEnergia;
    }
    
    private final String unidadeEnergia;
}
