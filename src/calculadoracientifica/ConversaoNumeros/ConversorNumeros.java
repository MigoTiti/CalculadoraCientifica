package calculadoracientifica.ConversaoNumeros;

import calculadoracientifica.Aritmetica.CalculadoraAritmetica;
import calculadoracientifica.Enums.Unidades;
import calculadoracientifica.Interfaces.ConversaoNumeros;
import calculadoracientifica.ModeloNumero.NumeroPrimitivo;
import calculadoracientifica.ModeloNumero.Unidades.NumeroArea;
import calculadoracientifica.ModeloNumero.Unidades.NumeroEnergia;
import calculadoracientifica.ModeloNumero.Unidades.NumeroMassa;
import calculadoracientifica.ModeloNumero.Unidades.NumeroMedida;
import calculadoracientifica.ModeloNumero.Unidades.NumeroTemperatura;
import calculadoracientifica.ModeloNumero.Unidades.NumeroTempo;
import calculadoracientifica.ModeloNumero.Unidades.NumeroVolume;
import java.util.ArrayList;
import java.util.Arrays;

public class ConversorNumeros implements ConversaoNumeros {

    public ConversorNumeros() { this.simboloFinal = ""; }

    public ConversorNumeros(String simboloFinal) {
        boolean sucesso = false;
        for (Unidades unidade : Unidades.values()) {
            if (unidade.toString().equals(simboloFinal)) {
                this.simboloFinal = simboloFinal;
                sucesso = true;
            }
        }
        if (!sucesso)
            this.simboloFinal = "";
    }

    public ConversorNumeros(ConversorNumeros c1) { this.simboloFinal = c1.simboloFinal; }

    @Override
    public NumeroPrimitivo converterNumero(CalculadoraAritmetica calculadora, NumeroPrimitivo numero) {

        NumeroPrimitivo numeroFinal;

        if (numero instanceof NumeroArea) {
            NumeroArea aux = new NumeroArea(simboloFinal);
            NumeroArea aux2 = (NumeroArea) numero;

            if (aux2.compareTo(aux) == 1)
                numeroFinal = new NumeroArea(aux2);
            else
                numeroFinal = converterArea(calculadora, aux2);
        } else if (numero instanceof NumeroEnergia) {
            NumeroEnergia aux = new NumeroEnergia(simboloFinal);
            NumeroEnergia aux2 = (NumeroEnergia) numero;

            if (aux2.compareTo(aux) == 1)
                numeroFinal = new NumeroEnergia(aux2);
            else
                numeroFinal = converterEnergia(calculadora, aux2);
        } else if (numero instanceof NumeroMassa) {
            NumeroMassa aux = new NumeroMassa(simboloFinal);
            NumeroMassa aux2 = (NumeroMassa) numero;

            if (aux2.compareTo(aux) == 1)
                numeroFinal = new NumeroMassa(aux2);
            else
                numeroFinal = converterMassa(calculadora, aux2);
        } else if (numero instanceof NumeroMedida) {
            NumeroMedida aux = new NumeroMedida(simboloFinal);
            NumeroMedida aux2 = (NumeroMedida) numero;

            if (aux2.compareTo(aux) == 1)
                numeroFinal = new NumeroMedida(aux2);
            else
                numeroFinal = converterMedida(calculadora, aux2);
        } else if (numero instanceof NumeroTemperatura) {
            NumeroTemperatura aux = new NumeroTemperatura(simboloFinal);
            NumeroTemperatura aux2 = (NumeroTemperatura) numero;

            if (aux2.compareTo(aux) == 1)
                numeroFinal = new NumeroTemperatura(aux2);
            else
                numeroFinal = converterTemperatura(calculadora, aux2);
        } else if (numero instanceof NumeroTempo) {
            NumeroTempo aux = new NumeroTempo(simboloFinal);
            NumeroTempo aux2 = (NumeroTempo) numero;

            if (aux2.compareTo(aux) == 1)
                numeroFinal = new NumeroTempo(aux2);
            else
                numeroFinal = converterTempo(calculadora, aux2);
        } else if (numero instanceof NumeroVolume) {
            NumeroVolume aux = new NumeroVolume(simboloFinal);
            NumeroVolume aux2 = (NumeroVolume) numero;

            if (aux2.compareTo(aux) == 1)
                numeroFinal = new NumeroVolume(aux2);
            else
                numeroFinal = converterVolume(calculadora, aux2);
        } else
            return null;

        return numeroFinal;
    }

    //CONVERSÃO DE VOLUME
    private NumeroVolume converterVolume(CalculadoraAritmetica calculadora, NumeroVolume numeroInicial) {
        double numeroFinal = calcularVolume(calculadora, numeroInicial.getNumero(), numeroInicial.getUnidade());
        return new NumeroVolume(numeroFinal, simboloFinal);
    }

    private double calcularVolume(CalculadoraAritmetica calculadora, double numeroInicial, String simboloInicial) {
        double numeroFinal;
        if (!simboloInicial.equals("m³")) {
            numeroFinal = xParaMetroC(calculadora, numeroInicial, simboloInicial);

            if (simboloFinal.equals("m³")) {
                return numeroFinal;
            } else {
                numeroFinal = MetroCParaY(calculadora, numeroFinal);
                return numeroFinal;
            }
        } else {
            numeroFinal = MetroCParaY(calculadora, numeroInicial);
            return numeroFinal;
        }
    }

    private double xParaMetroC(CalculadoraAritmetica calculadora, double numeroInicial, String simboloInicial) {
        double numeroFinal = 0;
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> sinais = new ArrayList<>();
        numeros.add(numeroInicial);
        sinais.add("*");
        switch (simboloInicial) {
            case "km³":
                numeros.add(1e9);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "hm³":
                numeros.add(1e6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "dam³":
                numeros.add(1e3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "dm³":
                numeros.add(1e-3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "cm³":
                numeros.add(1e-6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "mm³":
                numeros.add(1e-9);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "kL":
                numeros.add(1.0);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "hL":
                numeros.add(0.1);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "daL":
                numeros.add(0.01);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "L":
                numeros.add(0.001);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "dL":
                numeros.add(0.0001);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "cL":
                numeros.add(0.00001);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "mL":
                numeros.add(0.000001);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "bbl(US)":
                numeros.add(1.192e-1);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "bbl(UK)":
                numeros.add(1.636e-1);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "gal(US)":
                numeros.add(0.00378541);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "gal(UK)":
                numeros.add(0.00454609);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
        }
        return numeroFinal;
    }

    private double MetroCParaY(CalculadoraAritmetica calculadora, double numeroInicial) {
        double numeroFinal = 0;
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> sinais = new ArrayList<>();
        numeros.add(numeroInicial);
        sinais.add("*");
        switch (simboloFinal) {
            case "km³":
                numeros.add(1e-9);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "hm³":
                numeros.add(1e-6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "dam³":
                numeros.add(1e-3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "dm³":
                numeros.add(1e3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "cm³":
                numeros.add(1e6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "mm³":
                numeros.add(1e9);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "kL":
                numeros.add(1.0);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "hL":
                numeros.add(1e1);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "daL":
                numeros.add(1e2);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "L":
                numeros.add(1e3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "dL":
                numeros.add(1e4);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "cL":
                numeros.add(1e5);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "mL":
                numeros.add(1e6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "bbl(US)":
                numeros.add(8.386);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "bbl(UK)":
                numeros.add(6.11);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "gal(US)":
                numeros.add(264.172);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "gal(UK)":
                numeros.add(219.969);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
        }
        return numeroFinal;
    }
    //FIM DA CONVERSÃO DE VOLUME

    //CONVERSÃO DE TEMPO
    private NumeroTempo converterTempo(CalculadoraAritmetica calculadora, NumeroTempo numeroInicial) {
        double numeroFinal = calcularTempo(calculadora, numeroInicial.getNumero(), numeroInicial.getUnidade());
        return new NumeroTempo(numeroFinal, simboloFinal);
    }

    private double calcularTempo(CalculadoraAritmetica calculadora, double numeroInicial, String simboloInicial) {
        double numeroFinal;
        if (!simboloInicial.equals("s")) {
            numeroFinal = xParaSegundo(calculadora, numeroInicial, simboloInicial);

            if (simboloFinal.equals("s")) {
                return numeroFinal;
            } else {
                numeroFinal = segundoParaY(calculadora, numeroFinal);
                return numeroFinal;
            }
        } else {
            numeroFinal = segundoParaY(calculadora, numeroInicial);
            return numeroFinal;
        }
    }

    private double xParaSegundo(CalculadoraAritmetica calculadora, double numeroInicial, String simboloInicial) {
        double numeroFinal = 0;
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> sinais = new ArrayList<>();
        numeros.add(numeroInicial);
        sinais.add("*");
        switch (simboloInicial) {
            case "Milênio":
                numeros.add(3.156e10);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "Século":
                numeros.add(3.156e9);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "Década":
                numeros.add(3.156e8);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "Ano":
                numeros.add(3.156e7);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "Mês":
                numeros.add(2.629e6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "Semana":
                numeros.add(86400.0 * 7);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "Dia":
                numeros.add(86400.0);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "h":
                numeros.add(3.6e3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "min":
                numeros.add(6e1);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
        }
        return numeroFinal;
    }

    private double segundoParaY(CalculadoraAritmetica calculadora, double numeroInicial) {
        double numeroFinal = 0;
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> sinais = new ArrayList<>();
        numeros.add(numeroInicial);
        sinais.add("*");
        switch (simboloFinal) {
            case "Milênio":
                numeros.add(3.171e-11);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "Século":
                numeros.add(3.171e-10);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "Década":
                numeros.add(3.171e-9);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "Ano":
                numeros.add(3.171e-8);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "Mês":
                numeros.add(3.8052e-7);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "Semana":
                numeros.add(1.6534e-6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "Dia":
                numeros.add(1.1574e-5);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "h":
                numeros.add(2.77778e-4);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "min":
                numeros.add(1.6666666666666666666666666666666666667e-2);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
        }
        return numeroFinal;
    }
    //FIM DA CONVERSÃO DE TEMPO

    //CONVERSÃO DE TEMPERATURA
    private NumeroTemperatura converterTemperatura(CalculadoraAritmetica calculadora, NumeroTemperatura numeroInicial) {
        double numeroFinal = calcularTemperatura(calculadora, numeroInicial.getNumero(), numeroInicial.getUnidade());
        return new NumeroTemperatura(numeroFinal, simboloFinal);
    }

    private double calcularTemperatura(CalculadoraAritmetica calculadora, double numeroInicial, String simboloInicial) {
        double numeroFinal;
        if (!simboloInicial.equals("K")) {
            numeroFinal = xParaKelvin(calculadora, numeroInicial, simboloInicial);

            if (simboloFinal.equals("K"))
                return numeroFinal;
            else {
                numeroFinal = kelvinParaY(calculadora, numeroFinal);
                return numeroFinal;
            }
        } else {
            numeroFinal = kelvinParaY(calculadora, numeroInicial);
            return numeroFinal;
        }
    }

    private double xParaKelvin(CalculadoraAritmetica calculadora, double numeroInicial, String simboloInicial) {
        double numeroFinal = 0;
        ArrayList<Double> numeros;
        ArrayList<String> sinais;
        switch (simboloInicial) {
            case "°C":
                sinais = new ArrayList<>(Arrays.asList("+"));
                numeros = new ArrayList<>(Arrays.asList(numeroInicial,273.15));
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "°F":
                sinais = new ArrayList<>(Arrays.asList("(","-",")","/","+"));
                numeros = new ArrayList<>(Arrays.asList(numeroInicial,32.0,1.8,273.15));
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "°N":
                sinais = new ArrayList<>(Arrays.asList("*","(","/",")","+"));
                numeros = new ArrayList<>(Arrays.asList(numeroInicial,100.0,33.0,273.15));
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
        }
        return numeroFinal;
    }

    private double kelvinParaY(CalculadoraAritmetica calculadora, double numeroInicial) {
        double numeroFinal = 0;
        ArrayList<Double> numeros;
        ArrayList<String> sinais;
        switch (simboloFinal) {
            case "°C":
                sinais = new ArrayList<>(Arrays.asList("-"));
                numeros = new ArrayList<>(Arrays.asList(numeroInicial,273.15));
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "°F":
                sinais = new ArrayList<>(Arrays.asList("(","-",")","*","+"));
                numeros = new ArrayList<>(Arrays.asList(numeroInicial,273.15,1.8,32.0));
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "°N":
                sinais = new ArrayList<>(Arrays.asList("(","-",")","*","(","/",")"));
                numeros = new ArrayList<>(Arrays.asList(numeroInicial,273.15,33.0,100.0));
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
        }
        return numeroFinal;
    }
    //FIM DA CONVERSÃO DE TEMPERATURA

    //CONVERSÃO DE MEDIDA
    private NumeroMedida converterMedida(CalculadoraAritmetica calculadora, NumeroMedida numeroInicial) {
        double numeroFinal = calcularMedida(calculadora, numeroInicial.getNumero(), numeroInicial.getUnidade());
        return new NumeroMedida(numeroFinal, simboloFinal);
    }

    private double calcularMedida(CalculadoraAritmetica calculadora, double numeroInicial, String simboloInicial) {
        double numeroFinal;
        if (!simboloInicial.equals("m")) {
            numeroFinal = xParaMetro(calculadora, numeroInicial, simboloInicial);

            if (simboloFinal.equals("m")) {
                return numeroFinal;
            } else {
                numeroFinal = metroParaY(calculadora, numeroFinal);
                return numeroFinal;
            }
        } else {
            numeroFinal = metroParaY(calculadora, numeroInicial);
            return numeroFinal;
        }
    }

    private double xParaMetro(CalculadoraAritmetica calculadora, double numeroInicial, String simboloInicial) {
        double numeroFinal = 0;
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> sinais = new ArrayList<>();
        numeros.add(numeroInicial);
        sinais.add("*");
        switch (simboloInicial) {
            case "km":
                numeros.add(1e3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "hm":
                numeros.add(1e2);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "dam":
                numeros.add(10.0);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "dm":
                numeros.add(1e-1);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "cm":
                numeros.add(1e-2);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "mm":
                numeros.add(1e-3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "mi":
                numeros.add(1.609e3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "ly":
                numeros.add(9.460730e15);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
        }
        return numeroFinal;
    }

    private double metroParaY(CalculadoraAritmetica calculadora, double numeroInicial) {
        double numeroFinal = 0;
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> sinais = new ArrayList<>();
        numeros.add(numeroInicial);
        sinais.add("*");
        switch (simboloFinal) {
            case "km":
                numeros.add(1e-3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "hm":
                numeros.add(1e-2);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "dam":
                numeros.add(1e-1);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "dm":
                numeros.add(1e1);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "cm":
                numeros.add(1e2);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "mm":
                numeros.add(1e3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "mi":
                numeros.add(6.213e-4);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "ly":
                numeros.add(1.057e-16);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
        }
        return numeroFinal;
    }
    //FIM CONVERSÃO DE MEDIDA

    //CONVERSÃO DE MASSA
    private NumeroMassa converterMassa(CalculadoraAritmetica calculadora, NumeroMassa numeroInicial) {
        double numeroFinal = calcularMassa(calculadora, numeroInicial.getNumero(), numeroInicial.getUnidade());
        return new NumeroMassa(numeroFinal, simboloFinal);
    }

    private double calcularMassa(CalculadoraAritmetica calculadora, double numeroInicial, String simboloInicial) {
        double numeroFinal;
        if (!simboloInicial.equals("g")) {
            numeroFinal = xParaGrama(calculadora, numeroInicial, simboloInicial);

            if (simboloFinal.equals("g")) {
                return numeroFinal;
            } else {
                numeroFinal = gramaParaY(calculadora, numeroFinal);
                return numeroFinal;
            }
        } else {
            numeroFinal = gramaParaY(calculadora, numeroInicial);
            return numeroFinal;
        }
    }

    private double xParaGrama(CalculadoraAritmetica calculadora, double numeroInicial, String simboloInicial) {
        double numeroFinal = 0;
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> sinais = new ArrayList<>();
        numeros.add(numeroInicial);
        sinais.add("*");
        switch (simboloInicial) {
            case "t":
                numeros.add(1e6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "kg":
                numeros.add(1e3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "mg":
                numeros.add(1e-3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "lb":
                numeros.add(453.59237);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "ct":
                numeros.add(2e-1);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
        }
        return numeroFinal;
    }

    private double gramaParaY(CalculadoraAritmetica calculadora, double numeroInicial) {
        double numeroFinal = 0;
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> sinais = new ArrayList<>();
        numeros.add(numeroInicial);
        sinais.add("*");
        switch (simboloFinal) {
            case "t":
                numeros.add(1e-6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "kg":
                numeros.add(1e-3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "mg":
                numeros.add(1e3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "lb":
                numeros.add(2.204e-3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "ct":
                numeros.add(5.0);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
        }
        return numeroFinal;
    }
    //FIM CONVERSÃO DE MASSA

    //CONVERSÃO DE ENERGIA
    private NumeroEnergia converterEnergia(CalculadoraAritmetica calculadora, NumeroEnergia numeroInicial) {
        double numeroFinal = calcularEnergia(calculadora, numeroInicial.getNumero(), numeroInicial.getUnidade());
        return new NumeroEnergia(numeroFinal, simboloFinal);
    }

    private double calcularEnergia(CalculadoraAritmetica calculadora, double numeroInicial, String simboloInicial) {
        double numeroFinal;
        if (!simboloInicial.equals("J")) {
            numeroFinal = xParaJoule(calculadora, numeroInicial, simboloInicial);

            if (simboloFinal.equals("J")) {
                return numeroFinal;
            } else {
                numeroFinal = jouleParaY(calculadora, numeroFinal);
                return numeroFinal;
            }
        } else {
            numeroFinal = jouleParaY(calculadora, numeroInicial);
            return numeroFinal;
        }
    }

    private double xParaJoule(CalculadoraAritmetica calculadora, double numeroInicial, String simboloInicial) {
        double numeroFinal = 0;
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> sinais = new ArrayList<>();
        numeros.add(numeroInicial);
        sinais.add("*");
        switch (simboloInicial) {
            case "MJ":
                numeros.add(1e6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "KJ":
                numeros.add(1e3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "cal":
                numeros.add(4.1868);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "kcal":
                numeros.add(4.1868e4);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "kWh":
                numeros.add(3.6e6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "Wh":
                numeros.add(3.6e3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "th":
                numeros.add(4.1868e6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "fg":
                numeros.add(1.551e4);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "tep":
                numeros.add(4.2e10);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "tec":
                numeros.add(2.9e10);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "BTU":
                numeros.add(1055.1);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "eV":
                numeros.add(1.6e-19);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
        }
        return numeroFinal;
    }

    private double jouleParaY(CalculadoraAritmetica calculadora, double numeroInicial) {
        double numeroFinal = 0;
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> sinais = new ArrayList<>();
        numeros.add(numeroInicial);
        sinais.add("*");
        switch (simboloFinal) {
            case "MJ":
                numeros.add(1e-6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "KJ":
                numeros.add(1e-3);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "cal":
                numeros.add(2.388e-1);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "kcal":
                numeros.add(2.388e-4);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "kWh":
                numeros.add(2.7e-7);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "Wh":
                numeros.add(2.7e-4);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "th":
                numeros.add(2.39e-7);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "fg":
                numeros.add(6.447e-5);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "tep":
                numeros.add(2.3e-11);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "tec":
                numeros.add(3.4e-11);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "BTU":
                numeros.add(0.000947);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "eV":
                numeros.add(6.2e18);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
        }
        return numeroFinal;
    }
    //FIM CONVERSÃO DE ENERGIA

    //CONVERSÃO DE ÁREA
    private NumeroArea converterArea(CalculadoraAritmetica calculadora, NumeroArea numeroInicial) {
        double numeroFinal = calcularArea(calculadora, numeroInicial.getNumero(), numeroInicial.getUnidade());
        return new NumeroArea(numeroFinal, simboloFinal);
    }

    private double calcularArea(CalculadoraAritmetica calculadora, double numeroInicial, String simboloInicial) {
        double numeroFinal;
        if (!simboloInicial.equals("m²")) {
            numeroFinal = xParaMetroQ(calculadora, numeroInicial, simboloInicial);

            if (simboloFinal.equals("m²")) {
                return numeroFinal;
            } else {
                numeroFinal = metroQParaY(calculadora, numeroFinal);
                return numeroFinal;
            }
        } else {
            numeroFinal = metroQParaY(calculadora, numeroInicial);
            return numeroFinal;
        }
    }

    private double xParaMetroQ(CalculadoraAritmetica calculadora, double numeroInicial, String simboloInicial) {
        double numeroFinal = 0;
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> sinais = new ArrayList<>();
        numeros.add(numeroInicial);
        sinais.add("*");
        switch (simboloInicial) {
            case "km²":
                numeros.add(1e6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "ha":
                numeros.add(1e4);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "dam²":
                numeros.add(1e2);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "dm²":
                numeros.add(1e-2);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "cm²":
                numeros.add(1e-4);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "mm²":
                numeros.add(1e-6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "mi²":
                numeros.add(2.589998e6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "lea²":
                numeros.add(2.332e7);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
        }
        return numeroFinal;
    }

    private double metroQParaY(CalculadoraAritmetica calculadora, double numeroInicial) {
        double numeroFinal = 0;
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<String> sinais = new ArrayList<>();
        numeros.add(numeroInicial);
        sinais.add("*");
        switch (simboloFinal) {
            case "km²":
                numeros.add(1e-6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "ha":
                numeros.add(1e-4);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "dam²":
                numeros.add(1e-2);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "dm²":
                numeros.add(1e2);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "cm²":
                numeros.add(1e4);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "mm²":
                numeros.add(1e6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "mi²":
                numeros.add(3, 86e-7);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
            case "lea²":
                numeros.add(3.432e-6);
                numeroFinal = calculadora.interpretador(numeros, sinais);
                break;
        }
        return numeroFinal;
    }
    //FIM CONVERSÃO DE ÁREA

    @Override
    public String toString() {
        for (Unidades unidade : Unidades.values()) {
            if (unidade.toString().equals(simboloFinal)) {
                return "Convertendo um número do tipo: " + unidade.getTipo();
            }
        }
        return "";
    }

    private String simboloFinal;
}
