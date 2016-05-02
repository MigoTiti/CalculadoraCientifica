package calculadoracientifica;

import GUI.TelaInicial;
import javax.swing.JOptionPane;

public class CalculadoraCientifica {

    public static void main(String[] args) {
        boolean sucessoEscolha = false;
        int casasD = 0;

        do {
            String texto;
            texto = JOptionPane.showInputDialog("Digite o número máximo de casas decimais a serem usadas: ");

            if (texto == null)
                break;

            try {
                casasD = Integer.parseInt(texto);
                sucessoEscolha = true;
            } catch (NumberFormatException e2) {
                JOptionPane.showMessageDialog(null, "Apenas números inteiros!");
            }
            
            if(casasD<0 && sucessoEscolha){
                JOptionPane.showMessageDialog(null, "Apenas números inteiros positivos!");
                sucessoEscolha = false;
            }
            
            if (sucessoEscolha)
                new TelaInicial(casasD).setVisible(true);
            
        } while (!sucessoEscolha);

    }

}
