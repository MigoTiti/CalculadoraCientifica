package calculadoracientifica.ModeloNumero.Unidades;

import calculadoracientifica.ModeloNumero.NumeroPrimitivo;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("EqualsAndHashcode")
public class NumeroMassa extends NumeroPrimitivo implements Comparable{
    
    public NumeroMassa(){
        super(0.0);
        this.unidadeMassa = UNIDADE_MASSA_SI;
    }
    
    public NumeroMassa(final String unidadeMassa){
        super(0.0);
        if(unidadesAceitas.contains(unidadeMassa))
            this.unidadeMassa = unidadeMassa;
        else
            this.unidadeMassa = UNIDADE_MASSA_SI;
    }
    
    public NumeroMassa(NumeroMassa n1){
        super(n1.valor);
        this.unidadeMassa = n1.unidadeMassa;
    }    
    
    public NumeroMassa(double valor, final String unidadeMassa){
        if(valor<0)
            this.valor = 0.0;
        else
            this.valor = valor;
        
        if(unidadesAceitas.contains(unidadeMassa))
            this.unidadeMassa = unidadeMassa;
        else
            this.unidadeMassa = UNIDADE_MASSA_SI;
    }
    
    public String getUnidade(){
        return this.unidadeMassa;
    }
    
    @Override
    public int compareTo(Object o){
        NumeroMassa n1 = (NumeroMassa)o;
        if(n1.unidadeMassa.equals(this.unidadeMassa))
            return 1;
        else
            return 0;
    }
    
    @Override
    public String toString(){
        return this.getSinal()+Math.abs(this.valor)+this.unidadeMassa;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof NumeroArea){
            NumeroMassa n1 = (NumeroMassa)o;
            if(n1.negativo&&!this.negativo)
                return false;
            else if(!n1.unidadeMassa.equals(this.unidadeMassa))
                return false;
            else return n1.valor == this.valor;
        }else
            return false;
    }
    
    public static void adicionarUnidade(final String unidade){
        if(!unidadesAceitas.contains(unidade))
            unidadesAceitas.add(unidade);
    }
    
    private final static String UNIDADE_MASSA_SI = "g";
    private static ArrayList<String> unidadesAceitas = new ArrayList<>(Arrays.asList("t","kg","g","mg","lb","ct"));
    private final String unidadeMassa;
}
