package calculadoracientifica.Aritmetica;

import java.util.ArrayList;

public class CalculadoraIntegral extends Calculadora{
    
    public CalculadoraIntegral(){}
    
    public double integral(double limS, double limI, ArrayList<String> numeros, ArrayList<String> sinais)
    {
        boolean parenteses = false;
        int contParenteses = 0;
        
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        ArrayList<Double> numerosIntegral = new ArrayList<>();
        ArrayList<Integer> posicoes = new ArrayList<>();
        ArrayList<Integer> prioridades = new ArrayList<>();
        
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
                        prioridades.add(i, PRIORIDADE_SOMA+contParenteses+PRIORIDADE_PARENTESES-1);
                    else
                        prioridades.add(i, PRIORIDADE_SOMA);
                    break;
                case "*":
                case "/":
                    if(parenteses)
                        prioridades.add(i, PRIORIDADE_MULTIPLICACAO+contParenteses+PRIORIDADE_PARENTESES-1);
                    else
                        prioridades.add(i, PRIORIDADE_MULTIPLICACAO);
                    break;
                case "^":
                case "sqrt":
                case "log":
                case "ln":
                case "sen":
                case "cos":
                case "tg":
                    if(parenteses)
                        prioridades.add(i, PRIORIDADE_POTENCIA+contParenteses+PRIORIDADE_PARENTESES-1);
                    else
                        prioridades.add(i, PRIORIDADE_POTENCIA);
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
}
