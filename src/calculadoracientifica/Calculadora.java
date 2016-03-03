package calculadoracientifica;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Calculadora 
{
    
    public Calculadora()
    {
        operandos = new ArrayList(1);
    }
    
    public void integral()
    {
        
    }
    
    public void lerValor()
    {
        double x = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor: "));
        operandos.add(x);
    }
    
    
    
    private List operandos; 
}
