package calculadoracientifica;

import java.util.ArrayList;

public class Calculadora 
{
    
    public Calculadora(){}
    
    
    public double interpretador(ArrayList<Double> numeros, ArrayList<String> sinais)
    {
        
        return 2.0;
    }
    
    public double integral(double limS, double limI, ArrayList<String> numeros, ArrayList<String> sinais)
    {
        int contParenteses = 0;
        int potRaiz = 3;
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        ArrayList<Double> numerosIntegral = new ArrayList<>();
        ArrayList<Integer> posicoes = new ArrayList<>();
        ArrayList<String> prioridade = new ArrayList<>();
        for(int i=0;i<numeros.size();i++){
            String numero = numeros.get(i);
            
            if(numero.contains("x")){
                prioridade.add("x");
                posicoes.add(i);
                
                @SuppressWarnings("ReplaceStringBufferByString")
                StringBuilder numeroF = new StringBuilder(numero);
                int j = numeroF.indexOf("x");
                numeroF.deleteCharAt(j);
                
                numero = numeroF.toString();
                
                double numeroX = Double.parseDouble(numero);
                numerosIntegral.add(numeroX);
            }else
                numerosIntegral.add(Double.parseDouble(numeros.get(i)));
        }
        
        
        
        return 0;
    }
    
}
