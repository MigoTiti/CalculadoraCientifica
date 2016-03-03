package calculadoracientifica;

import java.util.ArrayList;

public class Calculadora 
{
    
    public Calculadora(){}
    
    public ArrayList<String> converter(String equacao){
        ArrayList<String> equacaoFinal = new ArrayList<>();
        for(int i=0;i<equacao.length();i++){
            
            equacaoFinal.add();
        }
        return equacaoFinal;
    }
    
    public double interpretador(String equacao)
    {
        ArrayList equacaoFinal;
        equacaoFinal = converter(equacao);
        
        int c = 0;
        for(int i=0;i<equacaoFinal.size();i++){
            if(equacaoFinal.get(i)=="(")
                do{
                    
                }while(equacaoFinal.get(i)!=")");
        }
        
        return 2.0;
    }
    
    public void integral()
    {
        
    }
    
}
