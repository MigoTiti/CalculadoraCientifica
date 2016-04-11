package calculadoracientifica.Interfaces;

import calculadoracientifica.Aritmetica.CalculadoraAritmetica;
import calculadoracientifica.ModeloNumero.NumeroPrimitivo;

public interface ConversaoNumeros {

    NumeroPrimitivo converterNumero(CalculadoraAritmetica calculadora, NumeroPrimitivo numero);
}
