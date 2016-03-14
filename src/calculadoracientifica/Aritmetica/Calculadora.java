package calculadoracientifica.Aritmetica;

import java.util.ArrayList;

public class Calculadora extends MetodosPrimitivos{
    
    public Calculadora(){
        Calculadora.radianos = true;
    }
    
    public static void mudarStatus(String nome){
        if("radianos".equals(nome)&&radianos==false)
            radianos = true;
    }
    
    public double interpretador(ArrayList<Double> numeros, ArrayList<String> sinais)
    {
        int contParenteses = 0;
        String sinal;
                
        ArrayList<Integer> prioridades = new ArrayList<>();        
        ArrayList<Integer> prioridadesParenteses = new ArrayList<>();
        ArrayList<Integer> posicoesRemoverSinais = new ArrayList<>();
        
        for(int i=0;i<sinais.size();i++){
            sinal = sinais.get(i);
            if(null!=sinal)switch (sinal){
                case "(":
                    prioridadesParenteses.add(i, ++contParenteses);
                    posicoesRemoverSinais.add(i);
                    break;
                case ")":
                    prioridadesParenteses.add(i, --contParenteses);
                     posicoesRemoverSinais.add(i);
                    break;
                default:
                    prioridadesParenteses.add(i, contParenteses);
            }
        }
        
        for(int i=posicoesRemoverSinais.size()-1;i>-1;i--){
            int remover = posicoesRemoverSinais.get(i);
            sinais.remove(remover);
            prioridadesParenteses.remove(remover);
        }
        
        for(int i=0;i<sinais.size();i++){
            sinal = sinais.get(i);
            if(null!=sinal)switch (sinal) {
                case "+":
                case "-":
                    prioridades.add(i, PRIORIDADE_SOMA+(prioridadesParenteses.get(i)*3));
                    break;
                case "%":
                case "*":
                case "/":
                    prioridades.add(i, PRIORIDADE_MULTIPLICACAO+(prioridadesParenteses.get(i)*3));
                    break;
                case "^":
                case "sqrt":
                case "log":
                case "ln":
                case "sen":
                case "cos":
                case "tg":
                    prioridades.add(i, PRIORIDADE_POTENCIA+(prioridadesParenteses.get(i)*3));
                    break;
            }  
        }
        posicoesRemoverSinais.clear();
        do{
            int maior = maiorIndice(prioridades);
            numeros = operacao(numeros,sinais,prioridades,maior);
        }while(numeros.size()>=2);
        if(radianos)
            return numeros.get(0);
        else
            return Math.toDegrees(numeros.get(0));
    } 
    
    protected ArrayList<Double> operacaoDupla(ArrayList<Double> numeros, String sinal, int i){
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
    
    protected ArrayList<Double> operacaoUnica(ArrayList<Double> numeros, String sinal, int i){
        double auxiliar;
        switch(sinal){
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
    
    protected ArrayList<Double> operacao(ArrayList<Double> numeros, ArrayList<String> sinais, ArrayList<Integer> prioridades, int maior){
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
    
    protected int maiorIndice(ArrayList<Integer> prioridades){
       int maior = prioridades.get(0);
       
       for(Integer prioridade : prioridades){
           if(prioridade >= maior)
               maior = prioridade;
       }
       
       return maior;
    }
    
    private static boolean radianos;
    public static final int PRIORIDADE_PARENTESES = 3;
    public static final int PRIORIDADE_POTENCIA = 3;
    public static final int PRIORIDADE_MULTIPLICACAO = 2;
    public static final int PRIORIDADE_SOMA = 1;
    
}
