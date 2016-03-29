package calculadoracientifica.ModeloNumero.Unidades;

import calculadoracientifica.ModeloNumero.NumeroPrimitivo;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("EqualsAndHashcode")
public class NumeroMedida extends NumeroPrimitivo implements Comparable{
    
    public NumeroMedida(){
        super(0.0);
        this.unidadeMedida = UNIDADE_MEDIDA_SI;
    }
    
    public NumeroMedida(final String unidadeMedida){
        super(0.0);
        if(unidadesAceitas.contains(unidadeMedida))
            this.unidadeMedida = unidadeMedida;
        else
            this.unidadeMedida = UNIDADE_MEDIDA_SI;
    }
    
    public NumeroMedida(NumeroMedida n1){
        super(n1.valor);
        this.unidadeMedida = n1.unidadeMedida;
    }    
    
    public NumeroMedida(double valor, final String unidadeMedida){
        if(valor<0)
            this.valor = 0.0;
        else
            this.valor = valor;
        
        if(unidadesAceitas.contains(unidadeMedida))
            this.unidadeMedida = unidadeMedida;
        else
            this.unidadeMedida = UNIDADE_MEDIDA_SI;
    }
    
    public String getUnidade(){
        return this.unidadeMedida;
    }
    
    @Override
    public int compareTo(Object o){
        NumeroMedida n1 = (NumeroMedida)o;
        if(n1.unidadeMedida.equals(this.unidadeMedida))
            return 1;
        else
            return 0;
    }
    
    @Override
    public String toString(){
        return this.getSinal()+Math.abs(this.valor)+this.unidadeMedida;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof NumeroArea){
            NumeroMedida n1 = (NumeroMedida)o;
            if(n1.negativo&&!this.negativo)
                return false;
            else if(!n1.unidadeMedida.equals(this.unidadeMedida))
                return false;
            else return n1.valor == this.valor;
        }else
            return false;
    }
    
    public static void adicionarUnidade(final String unidade){
        if(!unidadesAceitas.contains(unidade))
            unidadesAceitas.add(unidade);
    }
    
    private final static String UNIDADE_MEDIDA_SI = "m";
    private static ArrayList<String> unidadesAceitas = new ArrayList<>(Arrays.asList("km","hm","dam","m","dm","cm","mm","mi","ly"));
    private final String unidadeMedida;
}
