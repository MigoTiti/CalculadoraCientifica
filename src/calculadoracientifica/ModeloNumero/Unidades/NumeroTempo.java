package calculadoracientifica.ModeloNumero.Unidades;

import calculadoracientifica.ModeloNumero.NumeroPrimitivo;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("EqualsAndHashcode")
public class NumeroTempo extends NumeroPrimitivo implements Comparable{
    
    public NumeroTempo(){
        super(0.0);
        this.unidadeTempo = UNIDADE_TEMPO_SI;
    }
    
    public NumeroTempo(final String unidadeTempo){
        super(0.0);
        if(unidadesAceitas.contains(unidadeTempo))
            this.unidadeTempo = unidadeTempo;
        else
            this.unidadeTempo = UNIDADE_TEMPO_SI;
    }
    
    public NumeroTempo(NumeroTempo n1){
        super(n1.valor);
        this.unidadeTempo = n1.unidadeTempo;
    }    
    
    public NumeroTempo(double valor, final String unidadeTempo){
        super(valor);
        if(unidadesAceitas.contains(unidadeTempo))
            this.unidadeTempo = unidadeTempo;
        else
            this.unidadeTempo = UNIDADE_TEMPO_SI;
    }
    
    public String getUnidade(){
        return this.unidadeTempo;
    }
    
    @Override
    public int compareTo(Object o){
        NumeroTempo n1 = (NumeroTempo)o;
        if(n1.unidadeTempo.equals(this.unidadeTempo))
            return 1;
        else
            return 0;
    }
    
    @Override
    public String toString(){
        return this.getSinal()+Math.abs(this.valor)+this.unidadeTempo;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof NumeroArea){
            NumeroTempo n1 = (NumeroTempo)o;
            if(n1.negativo&&!this.negativo)
                return false;
            else if(!n1.unidadeTempo.equals(this.unidadeTempo))
                return false;
            else return n1.valor == this.valor;
        }else
            return false;
    }
    
    public static void adicionarUnidade(final String unidade){
        if(!unidadesAceitas.contains(unidade))
            unidadesAceitas.add(unidade);
    }
    
    private final static String UNIDADE_TEMPO_SI = "K";
    private static ArrayList<String> unidadesAceitas = new ArrayList<>(Arrays.asList("Milênio","Século","Década","Ano","Mês","Semana","Dia","h","min","s"));
    private final String unidadeTempo;
}
