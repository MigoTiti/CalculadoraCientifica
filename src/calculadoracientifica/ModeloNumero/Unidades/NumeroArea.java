package calculadoracientifica.ModeloNumero.Unidades;

import calculadoracientifica.ModeloNumero.NumeroPrimitivo;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("EqualsAndHashcode")
public class NumeroArea extends NumeroPrimitivo implements Comparable{
    
    public NumeroArea(){
        super(0.0);
        this.unidadeArea = UNIDADE_AREA_SI;
    }
    
    public NumeroArea(final String unidadeArea){
        super(0.0);
        if(unidadesAceitas.contains(unidadeArea))
            this.unidadeArea = unidadeArea;
        else
            this.unidadeArea = UNIDADE_AREA_SI;
    }
    
    public NumeroArea(double valor, final String unidadeArea){
        if(valor<0)
            this.valor = 0.0;
        else
            this.valor = valor;
        
        if(unidadesAceitas.contains(unidadeArea))
            this.unidadeArea = unidadeArea;
        else
            this.unidadeArea = UNIDADE_AREA_SI;
    }
    
    public NumeroArea(final NumeroArea n1){
        super(n1.valor);
        this.unidadeArea = n1.unidadeArea;
    }
    
    public String getUnidade(){
        return this.unidadeArea;
    }
    
    @Override
    public int compareTo(Object o){
        NumeroArea n1 = (NumeroArea)o;
        if(n1.unidadeArea.equals(this.unidadeArea))
            return 1;
        else
            return 0;
    }
    
    @Override
    public String toString(){
        return this.getSinal()+Math.abs(this.valor)+this.unidadeArea;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof NumeroArea){
            NumeroArea n1 = (NumeroArea)o;
            if(n1.negativo&&!this.negativo)
                return false;
            else if(!n1.unidadeArea.equals(this.unidadeArea))
                return false;
            else return n1.valor == this.valor;
        }else
            return false;
    }
    
    public static void adicionarUnidade(final String unidade){
        if(!unidadesAceitas.contains(unidade))
            unidadesAceitas.add(unidade);
    }
    
    private static ArrayList<String> unidadesAceitas = new ArrayList<>(Arrays.asList("km²","ha","dam²","m²","dm²","cm²","mm²","mi²","lea²"));
    private final static String UNIDADE_AREA_SI = "m²";
    private final String unidadeArea;
}
