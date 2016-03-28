package calculadoracientifica.ModeloNumero.Unidades;

import calculadoracientifica.ModeloNumero.NumeroPrimitivo;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("EqualsAndHashcode")
public class NumeroVolume extends NumeroPrimitivo implements Comparable{
    
    public NumeroVolume(){
        super(0.0);
        this.unidadeVolume = UNIDADE_VOLUME_SI;
    }
    
    public NumeroVolume(final String unidadeVolume){
        super(0.0);
        if(unidadesAceitas.contains(unidadeVolume))
            this.unidadeVolume = unidadeVolume;
        else
            this.unidadeVolume = UNIDADE_VOLUME_SI;
    }
    
    public NumeroVolume(NumeroVolume n1){
        super(n1.valor);
        this.unidadeVolume = n1.unidadeVolume;
    }    
    
    public NumeroVolume(double valor, final String unidadeVolume){
        if(unidadesAceitas.contains(unidadeVolume))
            this.unidadeVolume = unidadeVolume;
        else
            this.unidadeVolume = UNIDADE_VOLUME_SI;
    }
    
    public String getUnidade(){
        return this.unidadeVolume;
    }
    
    @Override
    public int compareTo(Object o){
        NumeroVolume n1 = (NumeroVolume)o;
        if(n1.unidadeVolume.equals(this.unidadeVolume))
            return 1;
        else
            return 0;
    }
    
    @Override
    public String toString(){
        return this.getSinal()+Math.abs(this.valor)+this.unidadeVolume;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof NumeroArea){
            NumeroVolume n1 = (NumeroVolume)o;
            if(n1.negativo&&!this.negativo)
                return false;
            else if(!n1.unidadeVolume.equals(this.unidadeVolume))
                return false;
            else return n1.valor == this.valor;
        }else
            return false;
    }
    
    public static void adicionarUnidade(final String unidade){
        if(!unidadesAceitas.contains(unidade))
            unidadesAceitas.add(unidade);
    }
    
    private final static String UNIDADE_VOLUME_SI = "m³";
    private static ArrayList<String> unidadesAceitas = new ArrayList<>(Arrays.asList("km³","hm³","dam³","m³","dm³","cm³","mm³","kL","hL","daL","L","dL","cL","mL","bbl(US)","bbl(UK)","gal(US)","gal(UK)"));    
    private final String unidadeVolume;
}
