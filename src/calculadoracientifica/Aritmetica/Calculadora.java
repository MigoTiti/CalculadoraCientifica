package calculadoracientifica.Aritmetica;

import java.util.ArrayList;

public class Calculadora 
{
    
    public Calculadora(){}
    
    public double interpretador(ArrayList<Double> numeros, ArrayList<String> sinais2)
    {
        int contParenteses = 0;
        String sinal;
        
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
                
        ArrayList<Integer> prioridadesParenteses = new ArrayList<>();
        ArrayList<Integer> posicoesRemoverSinais2 = new ArrayList<>();
        sinais = new ArrayList<>(sinais2);
        sinais2.clear();
        
        for(int i=0;i<sinais.size();i++){
            sinal = sinais.get(i);
            if(null!=sinal)switch (sinal){
                case "(":
                    prioridadesParenteses.add(i, ++contParenteses);
                    posicoesRemoverSinais2.add(i);
                    break;
                case ")":
                    prioridadesParenteses.add(i, --contParenteses);
                     posicoesRemoverSinais2.add(i);
                    break;
                default:
                    prioridadesParenteses.add(i, contParenteses);
            }
        }
        
        for(int i=posicoesRemoverSinais2.size()-1;i>-1;i--){
            int remover = posicoesRemoverSinais2.get(i);
            sinais.remove(remover);
            prioridadesParenteses.remove(remover);
        }
        
        for(int i=0;i<sinais.size();i++){
            sinal = sinais.get(i);
            if(null!=sinal)switch (sinal) {
                case "+":
                case "-":
                    prioridades.add(i, prioridadeSoma+(prioridadesParenteses.get(i)*3));
                    break;
                case "%":
                case "*":
                case "/":
                    prioridades.add(i, prioridadeMultiplicacao+(prioridadesParenteses.get(i)*3));
                    break;
                case "^":
                case "e^":
                case "sqrt":
                case "log":
                case "ln":
                case "sen":
                case "cos":
                case "tg":
                    prioridades.add(i, prioridadePotencia+(prioridadesParenteses.get(i)*3));
                    break;
            }  
        }
        posicoesRemoverSinais2.clear();
        do{
            int maior = maiorIndice(prioridades);
            numeros = operacao(numeros,maior);
        }while(numeros.size()>=2);  
        return numeros.get(0);
    } 
    
    private ArrayList<Double> operacaoDupla(ArrayList<Double> numeros, String sinal, int i){
        double auxiliar;
        switch(sinal){
            case "+":
                auxiliar = numeros.get(i)+numeros.get(i+1);
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "-":
                auxiliar = numeros.get(i)-numeros.get(i+1);
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "*":
                auxiliar = numeros.get(i)*numeros.get(i+1);
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "/":
                auxiliar = numeros.get(i)/numeros.get(i+1);
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "^":
                auxiliar = Math.pow(numeros.get(i), numeros.get(i+1));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "%":
                auxiliar = numeros.get(i)%numeros.get(i+1);
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
        }
        return numeros;
    }
    
    private ArrayList<Double> operacaoUnica(ArrayList<Double> numeros, String sinal, int i){
        double auxiliar;
        switch(sinal){
            case "e^":
                auxiliar = Math.pow(Math.E, numeros.get(i));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "sqrt":
                auxiliar = Math.sqrt(numeros.get(i));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "log":
                auxiliar = Math.log10(numeros.get(i));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "ln":
                auxiliar = Math.log(numeros.get(i));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "sen":
                auxiliar = Math.sin(numeros.get(i));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "cos":
                auxiliar = Math.cos(numeros.get(i));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "tg":
                auxiliar = Math.tan(numeros.get(i));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
        }
        return numeros;
    }
    
    private ArrayList<Double> operacao(ArrayList<Double> numeros, int maior){
        int indexUsado = 0;
        String sinal;
        boolean sucesso = false, operacaoUnica = false;
        
            for(int i=0;i<numeros.size();i++){
                if(prioridades.get(i)==maior && sucesso==false){
                    sinal = sinais.get(i);
                    if("+".equals(sinal)||"%".equals(sinal)||"-".equals(sinal)||"*".equals(sinal)||"/".equals(sinal)||"^".equals(sinal)){
                        operacaoDupla(numeros,sinal,i);
                        operacaoUnica = false;
                        sucesso = true;
                        indexUsado = i;
                    }else{
                        operacaoUnica(numeros,sinal,i);
                        operacaoUnica = true;
                        sucesso = true;
                        indexUsado = i;
                    }  
                }
                if(sucesso)
                    break;
            }
            
            if(sucesso){
                if(numeros.size()>1 && operacaoUnica == false)
                    numeros.remove(indexUsado+1);
                sinais.remove(indexUsado);
                prioridades.remove(indexUsado);
            }
            
    return numeros;
    }
    
    private int maiorIndice(ArrayList<Integer> prioridades){
       int maior = prioridades.get(0);
       
       for(Integer prioridade : prioridades){
           if(prioridade >= maior)
               maior = prioridade;
       }
       
       return maior;
    }
    
    protected static final int prioridadeParenteses = 3;
    protected static final int prioridadePotencia = 3;
    protected static final int prioridadeMultiplicacao = 2;
    protected static final int prioridadeSoma = 1;
    protected static ArrayList<Integer> prioridades = new ArrayList<>();
    protected static ArrayList<String> sinais;
    
}
