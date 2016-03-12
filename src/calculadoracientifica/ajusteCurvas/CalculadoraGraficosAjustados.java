package calculadoracientifica.ajusteCurvas;

import calculadoracientifica.Graficos.CalculadoraGraficos;
import java.util.ArrayList;

public class CalculadoraGraficosAjustados extends CalculadoraGraficos{
    
    public CalculadoraGraficosAjustados(double limiteInferior, double limiteSuperior, String equacao){
        this.vazio = "";
        this.equacao = equacao;
    }
    
    public void interpretadorStrings(){
        
    }
    
    private String equacao;
    private final String vazio;
}
