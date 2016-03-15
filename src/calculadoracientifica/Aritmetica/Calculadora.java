package calculadoracientifica.Aritmetica;

import java.util.ArrayList;

public class Calculadora extends MetodosPrimitivos{
    
    public Calculadora(){}
    
    public static void mudarStatus(String nome){
        if("radianos".equals(nome)&&radianos==false)
            radianos = true;
        else if("graus".equals(nome)&&radianos)
            radianos = false;
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

        return numeros.get(0);
    } 
    
    protected ArrayList<Double> operacaoDupla(ArrayList<Double> numeros, String sinal, int i){
        double auxiliar;
        switch(sinal){
            case "+":
                auxiliar = soma(numeros.get(i),numeros.get(i+1));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "-":
                auxiliar = subtracao(numeros.get(i),numeros.get(i+1));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "*":
                auxiliar = multiplicacao(numeros.get(i),numeros.get(i+1));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "/":
                auxiliar = divisao(numeros.get(i),numeros.get(i+1));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "^":
                auxiliar = potencia(numeros.get(i),numeros.get(i+1));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "%":
                auxiliar = resto(numeros.get(i),numeros.get(i+1));
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
                auxiliar = raizQuadrada(numeros.get(i));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "log":
                auxiliar = log10(numeros.get(i));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "ln":
                auxiliar = logNatural(numeros.get(i));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "sen":
                if(radianos)
                    auxiliar = seno(numeros.get(i));
                else
                    auxiliar = seno(Math.toRadians(numeros.get(i)));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "cos":
                if(radianos)
                    auxiliar = cosseno(numeros.get(i));
                else
                    auxiliar = cosseno(Math.toRadians(numeros.get(i)));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
            case "tg":
                if(radianos)
                    auxiliar = tangente(numeros.get(i));
                else
                    auxiliar = tangente(Math.toRadians(numeros.get(i)));
                numeros.remove(i);
                numeros.add(i, auxiliar);
                break;
        }
        return numeros;
    }
    
    protected ArrayList<Double> operacao(ArrayList<Double> numeros, ArrayList<String> sinais, ArrayList<Integer> prioridades, int maior){
        int indexUsado = 0;
        String sinal;
        boolean sucesso = false, operacaoUnica = false, op2 = false;
        
            for(int i=0;i<numeros.size();i++){
                if(prioridades.get(i)==maior && sucesso==false){
                    sinal = sinais.get(i);
                    if("+".equals(sinal)||"%".equals(sinal)||"-".equals(sinal)||"*".equals(sinal)||"/".equals(sinal)||"^".equals(sinal)){
                        if(sinais.size()>1 && i>0 && ("sqrt".equals(sinais.get(i-1))||"sen".equals(sinais.get(i-1))||"cos".equals(sinais.get(i-1))||"tg".equals(sinais.get(i-1))||"log".equals(sinais.get(i-1))||"ln".equals(sinais.get(i-1)))){
                            operacaoDupla(numeros,sinal,i-1);
                            op2 = true;
                        }
                        else
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
                if(numeros.size()>1 && operacaoUnica == false){
                    if(op2)
                        numeros.remove(indexUsado-1);
                    else
                        numeros.remove(indexUsado+1);
                }
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
    
    private static boolean radianos = true;
    public static final int PRIORIDADE_PARENTESES = 3;
    public static final int PRIORIDADE_POTENCIA = 3;
    public static final int PRIORIDADE_MULTIPLICACAO = 2;
    public static final int PRIORIDADE_SOMA = 1;
    
}
