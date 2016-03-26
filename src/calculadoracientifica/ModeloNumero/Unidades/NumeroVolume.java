package calculadoracientifica.ModeloNumero.Unidades;

import calculadoracientifica.ModeloNumero.NumeroPrimitivo;

public class NumeroVolume extends NumeroPrimitivo{
    
    public NumeroVolume(double valor, final String unidadeVolume){
        super(valor);
        this.unidadeVolume = unidadeVolume;
    }
    
    public String getUnidade(){
        return this.unidadeVolume;
    }
    
    @Override
    public String toString(){
        return this.getSinal()+Math.abs(this.valor)+this.unidadeVolume;
    }
    
    private final String unidadeVolume;
}
