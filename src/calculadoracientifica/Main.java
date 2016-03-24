package calculadoracientifica;

import GUI.TelaInicial;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main 
{
    public static void main(String[] args){ 
        boolean sucessoEscolha = false;
        int casasD = 0, result;
        
        do{
            JPanel painelInicio = new JPanel(new GridLayout(0, 1));
            painelInicio.add(new JLabel("Digite o número máximo de casas decimais a serem usadas: "));
            JTextField decimaisTexto = new JTextField();
            painelInicio.add(decimaisTexto);
            painelInicio.setVisible(true);
            decimaisTexto.requestFocusInWindow();
            result = JOptionPane.showConfirmDialog(null, painelInicio, "Inicio", JOptionPane.OK_CANCEL_OPTION); 
            
            if(result == JOptionPane.CANCEL_OPTION)
                break;
            
            try{
               casasD = Integer.parseInt(decimaisTexto.getText());
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
