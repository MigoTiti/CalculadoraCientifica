package calculadoracientifica.Interfaces;

import calculadoracientifica.Aritmetica.CalculadoraAritmetica;

public interface ConversaoNumeros{
    Object converterNumero(CalculadoraAritmetica calculadora, Object numero, String simboloFinal);
}
