package calculadoracientifica;

import GUI.TelaInicial;
import javax.swing.JOptionPane;

public class CalculadoraCientifica{
    
    public static void main(String[] args){ 
        boolean sucessoEscolha = false;
        int casasD = 0;
        
        do{
            String texto;
            texto = JOptionPane.showInputDialog("Digite o número máximo de casas decimais a serem usadas: ");
            
            if(texto == null)
                break;
            
            try{
                casasD = Integer.parseInt(texto);
                sucessoEscolha = true;
            }
            catch(NumberFormatException e2){
                JOptionPane.showMessageDialog(null, "Apenas números inteiros!");
            }
        }while(!sucessoEscolha);
        
        if(sucessoEscolha){
            calculadoraInicio = new TelaInicial(casasD);
            calculadoraInicio.setVisible(true);
        }
    }
    
    
    
    private static TelaInicial calculadoraInicio;
    
}
