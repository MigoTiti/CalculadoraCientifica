package calculadoracientifica.ModeloNumero.Unidades;

import calculadoracientifica.ModeloNumero.NumeroPrimitivo;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("EqualsAndHashcode")
public class NumeroTemperatura extends NumeroPrimitivo implements Comparable {

    public NumeroTemperatura() {
        super(0.0);
        this.unidadeTemperatura = UNIDADE_TEMPERATURA_SI;
    }

    public NumeroTemperatura(final String unidadeTemperatura) {
        super(0.0);
        if (unidadesAceitas.contains(unidadeTemperatura)) {
            this.unidadeTemperatura = unidadeTemperatura;
        } else {
            this.unidadeTemperatura = UNIDADE_TEMPERATURA_SI;
        }
    }

    public NumeroTemperatura(NumeroTemperatura n1) {
        super(n1.valor);
        this.unidadeTemperatura = n1.unidadeTemperatura;
    }

    public NumeroTemperatura(double valor, final String unidadeTemperatura) {
        if (unidadesAceitas.contains(unidadeTemperatura)) {
            this.unidadeTemperatura = unidadeTemperatura;
        } else {
            this.unidadeTemperatura = UNIDADE_TEMPERATURA_SI;
        }

        if (unidadeTemperatura.equals("K") && valor < 0) {
            this.valor = 0;
        } else if (unidadeTemperatura.equals("°C") && valor < -273.15) {
            this.valor = -273.15;
        } else if (unidadeTemperatura.equals("°F") && valor < -459.67) {
            this.valor = -459.67;
        } else if (unidadeTemperatura.equals("°N") && valor < -90.1395) {
            this.valor = -90.1395;
        } else {
            this.valor = valor;
        }

    }

    public String getUnidade() {
        return this.unidadeTemperatura;
    }

    @Override
    public int compareTo(Object o) {
        NumeroTemperatura n1 = (NumeroTemperatura) o;
        if (n1.unidadeTemperatura.equals(this.unidadeTemperatura)) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return this.getSinal() + Math.abs(this.valor) + this.unidadeTemperatura;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof NumeroArea) {
            NumeroTemperatura n1 = (NumeroTemperatura) o;
            if (n1.negativo && !this.negativo) {
                return false;
            } else if (!n1.unidadeTemperatura.equals(this.unidadeTemperatura)) {
                return false;
            } else {
                return n1.valor == this.valor;
            }
        } else {
            return false;
        }
    }

    public static void adicionarUnidade(final String unidade) {
        if (!unidadesAceitas.contains(unidade)) {
            unidadesAceitas.add(unidade);
        }
    }

    private final static String UNIDADE_TEMPERATURA_SI = "K";
    private static ArrayList<String> unidadesAceitas = new ArrayList<>(Arrays.asList("K", "°C", "°F", "°N"));
    private final String unidadeTemperatura;
}
