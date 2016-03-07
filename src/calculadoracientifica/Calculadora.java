package calculadoracientifica;

import java.util.ArrayList;

public class Calculadora 
{
    
    public Calculadora(){}
    
    
    public double interpretador(ArrayList<Double> numeros, ArrayList<String> sinais)
    {
        int contParenteses = 0;
        double auxiliar;
        String sinal;
        
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
                
        ArrayList<Integer> prioridades = new ArrayList<>();
        ArrayList<Integer> prioridadesParenteses = new ArrayList<>();
        ArrayList<Integer> posicoesRemoverSinais2 = new ArrayList<>();
        
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
                        prioridades.add(i, prioridadeSoma+prioridadesParenteses.get(i));
                    break;
                case "*":
                case "/":
                        prioridades.add(i, prioridadeMultiplicacao+prioridadesParenteses.get(i));
                    break;
                case "e^":
                case "^2":
                case "^3":
                case "^":
                case "sqrt":
                case "log":
                case "ln":
                case "sen":
                case "cos":
                case "tg":
                        prioridades.add(i, prioridadePotencia+prioridadesParenteses.get(i));
                    break;
            }  
        }
        
        //ArrayList<Integer> posicoesRemoverSinais2 = new ArrayList<>();
        
        //for(int i=0;i<sinais.size();i++){
        //    if(prioridades.get(i) == 0){
                //prioridades.remove(i);
        //        posicoesRemoverSinais2.add(i);
                //i--;
        //    }
        //}
        
        //for(int i=posicoesRemoverSinais2.size()-1;i>0;i--){
        //    int remover = posicoesRemoverSinais2.get(i);
        //    sinais.remove(remover);
        //    prioridades.remove(remover);
            //i--;
        //}
        
        posicoesRemoverSinais2.clear();
        
        int maior = maiorIndice(prioridades);
        int posicoesRemoverNumeros = 0, posicoesRemoverSinais = 0, sucessoPrioridade = 0;
        boolean sucesso = false, operacaoUnica = false, deletarSinal = false;
        
        
        do{
            int i;
            for(i=0;i<sinais.size();i++){
                if(prioridades.get(i)==maior && sucesso==false && sucessoPrioridade==0){
                    sinal = sinais.get(i);
                    if(null!=sinal)switch(sinal){
                        case "+":
                            auxiliar = numeros.get(i)+numeros.get(i+1);
                            numeros.remove(i);
                            numeros.add(i, auxiliar);
                            posicoesRemoverNumeros = i+1;
                            if(deletarSinal==false){
                                posicoesRemoverSinais = i;
                                deletarSinal = true;
                            }
                            sucesso = true;
                            operacaoUnica = false;
                            sucessoPrioridade++;
                            break;
                        case "-":
                            auxiliar = numeros.get(i)-numeros.get(i+1);
                            numeros.remove(i);
                            numeros.add(i, auxiliar);
                            posicoesRemoverNumeros = i+1;
                            if(deletarSinal==false){
                                posicoesRemoverSinais = i;
                                deletarSinal = true;
                            }
                            sucesso = true;
                            operacaoUnica = false;
                            sucessoPrioridade++;
                            break;
                        case "*":
                            auxiliar = numeros.get(i)*numeros.get(i+1);
                            numeros.remove(i);
                            numeros.add(i, auxiliar);
                            posicoesRemoverNumeros = i+1;
                            if(deletarSinal==false){
                                posicoesRemoverSinais = i;
                                deletarSinal = true;
                            }
                            sucesso = true;
                            operacaoUnica = false;
                            sucessoPrioridade++;
                            break;
                        case "/":
                            auxiliar = numeros.get(i)/numeros.get(i+1);
                            numeros.remove(i);
                            numeros.add(i, auxiliar);
                            posicoesRemoverNumeros = i+1;
                            if(deletarSinal==false){
                                posicoesRemoverSinais = i;
                                deletarSinal = true;
                            }
                            sucesso = true;
                            operacaoUnica = false;
                            sucessoPrioridade++;
                            break;
                        case "e^":
                            auxiliar = Math.pow(Math.E, numeros.get(i));
                            numeros.remove(i);
                            numeros.add(i, auxiliar);
                            if(deletarSinal==false){
                                posicoesRemoverSinais = i;
                                deletarSinal = true;
                            }
                            sucesso = true;
                            operacaoUnica = true;
                            sucessoPrioridade++;
                            break;
                        case "^2":
                            auxiliar = Math.pow(numeros.get(i), 2);
                            numeros.remove(i);
                            numeros.add(i, auxiliar);
                            if(deletarSinal==false){
                                posicoesRemoverSinais = i;
                                deletarSinal = true;
                            }
                            sucesso = true;
                            operacaoUnica = true;
                            sucessoPrioridade++;
                            break;
                        case "^3":
                            auxiliar = Math.pow(numeros.get(i), 2);
                            numeros.remove(i);
                            numeros.add(i, auxiliar);
                            if(deletarSinal==false){
                                posicoesRemoverSinais = i;
                                deletarSinal = true;
                            }
                            sucesso = true;
                            operacaoUnica = true;
                            sucessoPrioridade++;
                            break;
                        case "^":
                            auxiliar = Math.pow(numeros.get(i), numeros.get(i+1));
                            numeros.remove(i);
                            numeros.add(i, auxiliar);
                            posicoesRemoverNumeros = i+1;
                            if(deletarSinal==false){
                                posicoesRemoverSinais = i;
                                deletarSinal = true;
                            }
                            sucesso = true;
                            operacaoUnica = false;
                            sucessoPrioridade++;
                            break;
                        case "sqrt":
                            auxiliar = Math.sqrt(numeros.get(i));
                            numeros.remove(i);
                            numeros.add(i, auxiliar);
                            if(deletarSinal==false){
                                posicoesRemoverSinais = i;
                                deletarSinal = true;
                            }
                            sucesso = true;
                            operacaoUnica = true;
                            sucessoPrioridade++;
                            break;
                        case "log":
                            auxiliar = Math.log10(numeros.get(i));
                            numeros.remove(i);
                            numeros.add(i, auxiliar);
                            if(deletarSinal==false){
                                posicoesRemoverSinais = i;
                                deletarSinal = true;
                            }
                            sucesso = true;
                            operacaoUnica = true;
                            sucessoPrioridade++;
                            break;
                        case "ln":
                            auxiliar = Math.log(numeros.get(i));
                            numeros.remove(i);
                            numeros.add(i, auxiliar);
                            if(deletarSinal==false){
                                posicoesRemoverSinais = i;
                                deletarSinal = true;
                            }
                            sucesso = true;
                            operacaoUnica = true;
                            sucessoPrioridade++;
                            break;
                        case "sen":
                            auxiliar = Math.sin(numeros.get(i));
                            numeros.remove(i);
                            numeros.add(i, auxiliar);
                            if(deletarSinal==false){
                                posicoesRemoverSinais = i;
                                deletarSinal = true;
                            }
                            sucesso = true;
                            operacaoUnica = true;
                            sucessoPrioridade++;
                            break;
                        case "cos":
                            auxiliar = Math.cos(numeros.get(i));
                            numeros.remove(i);
                            numeros.add(i, auxiliar);
                            if(deletarSinal==false){
                                posicoesRemoverSinais = i;
                                deletarSinal = true;
                            }
                            sucesso = true;
                            operacaoUnica = true;
                            sucessoPrioridade++;
                            break;
                        case "tg":
                            auxiliar = Math.tan(numeros.get(i));
                            numeros.remove(i);
                            numeros.add(i, auxiliar);
                            if(deletarSinal==false){
                                posicoesRemoverSinais = i;
                                deletarSinal = true;
                            }
                            sucesso = true;
                            operacaoUnica = true;
                            sucessoPrioridade++;
                            break;
                    }
                }
                }
                    if(sucessoPrioridade==1){
                        prioridades.remove(i);
                        prioridades.add(i, 0);
                        sucessoPrioridade = 0;
                    }
            
            
            if(sucesso){
                if(numeros.size()>1 && operacaoUnica == false)
                    numeros.remove(posicoesRemoverNumeros);
                sinais.remove(posicoesRemoverSinais);
                sucesso = false;
            }
            
            maior = maiorIndice(prioridades);
        }while(maior>0);
        //teste(prioridades,sinais);
            
        return numeros.get(0);
    }
    
    private int maiorIndice(ArrayList<Integer> prioridades){
       int maior = prioridades.get(0);
       
       for(Integer prioridade : prioridades){
           if(prioridade >= maior)
               maior = prioridade;
       }
       
       return maior;
    }
    
    public double integral(double limS, double limI, ArrayList<String> numeros, ArrayList<String> sinais)
    {
        boolean parenteses = false;
        int contParenteses = 0;
        
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        ArrayList<Double> numerosIntegral = new ArrayList<>();
        ArrayList<Integer> prioridades = new ArrayList<>();
        ArrayList<Integer> posicoes = new ArrayList<>();
        
        for(int i=0;i<numeros.size();i++){
            String numero = numeros.get(i);
            
            if(numero.contains("x")){
                posicoes.add(i);
                
                @SuppressWarnings("ReplaceStringBufferByString")
                StringBuilder numeroF = new StringBuilder(numero);
                int j = numeroF.indexOf("x");
                numeroF.deleteCharAt(j);
                
                numero = numeroF.toString();
                
                if(numero.isEmpty())
                    numerosIntegral.add(1.0);
                else{
                    double numeroX = Double.parseDouble(numero);
                    numerosIntegral.add(numeroX);
                }
            }else
                numerosIntegral.add(Double.parseDouble(numeros.get(i)));
        }
        
        for(int i=0;i<sinais.size();i++){
            String sinal = sinais.get(i);
            if(null!=sinal)switch (sinal) {
                case "+":
                case "-":
                    if(parenteses)
                        prioridades.add(i, prioridadeSoma+contParenteses+prioridadeParenteses-1);
                    else
                        prioridades.add(i, prioridadeSoma);
                    break;
                case "*":
                case "/":
                    if(parenteses)
                        prioridades.add(i, prioridadeMultiplicacao+contParenteses+prioridadeParenteses-1);
                    else
                        prioridades.add(i, prioridadeMultiplicacao);
                    break;
                case "^":
                case "sqrt":
                case "log":
                case "ln":
                case "sen":
                case "cos":
                case "tg":
                    if(parenteses)
                        prioridades.add(i, prioridadePotencia+contParenteses+prioridadeParenteses-1);
                    else
                        prioridades.add(i, prioridadePotencia);
                    break;
                case "(":
                    prioridades.add(i, 0);
                    contParenteses++;
                    if(parenteses == false)
                        parenteses = true;
                    break;
                case ")":
                    prioridades.add(i, 0);
                    contParenteses--;
                    if(contParenteses<=0)
                        parenteses = false;
                    break;
            }
                
            
        }
        
        return 0;
    }
    
    private static int prioridadeParenteses = 3;
    private static int prioridadePotencia = 3;
    private static int prioridadeMultiplicacao = 2;
    private static int prioridadeSoma = 1;
    
    private void teste(ArrayList<Integer> prioridades, ArrayList<String> sinais){
        sinais.stream().forEach((sinais2) -> {
            System.out.print(" "+sinais2+" ");
        });
        
        System.out.print("\n");
        
        prioridades.stream().forEach((prioridade) -> {
            System.out.print(" "+prioridade+" ");
        });
    }
}
