package calculadoracientifica.Aritmetica;

import java.util.ArrayList;

public class CalculadoraAritmetica extends CalculadoraPrimitiva{
    
    public CalculadoraAritmetica(){
        CalculadoraAritmetica.radianos = true;
        this.contParenteses = 0;
    }
    
    public CalculadoraAritmetica(boolean radianos){
        CalculadoraAritmetica.radianos = radianos;
        this.contParenteses = 0;
    }
    
    public CalculadoraAritmetica(CalculadoraAritmetica c1){
        this.contParenteses = c1.contParenteses;
    }
    
    public static void mudarStatus(String nome){
        if("radianos".equals(nome)&&radianos==false)
            radianos = true;
        else if("graus".equals(nome)&&radianos)
            radianos = false;
    }
    
    @Override
    public double interpretador(ArrayList<Double> numeros, ArrayList<String> sinais){
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
                    prioridades.add(i, Prioridades.soma.getPrioridade()+(prioridadesParenteses.get(i)*3));
                    break;
                case "%":
                case "*":
                case "/":
                    prioridades.add(i, Prioridades.multiplicacao.getPrioridade()+(prioridadesParenteses.get(i)*3));
                    break;
                case "^":
                    prioridades.add(i, Prioridades.potencia.getPrioridade()+(prioridadesParenteses.get(i)*3));
                    break;
                case "sqrt":
                case "log":
                case "ln":
                case "sen":
                case "cos":
                case "tg":
                    prioridades.add(i, Prioridades.trigonometricaRaizLog.getPrioridade()+(prioridadesParenteses.get(i)*3));
                    break;
            }  
        }
        posicoesRemoverSinais.clear();
        int size = sinais.size();
        if(!sinais.isEmpty()){
            do{
                int maior = maiorIndice(prioridades);
                numeros = operacao(numeros,sinais,prioridades,maior);
                size--;
            }while(size>=1);
        }
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
                        numeros.remove(indexUsado);
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
    
    private int contParenteses;
    private static boolean radianos;
    
}
