package calculadoracientifica.ModeloNumero.Unidades;

import calculadoracientifica.ModeloNumero.NumeroPrimitivo;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("EqualsAndHashcode")
public class NumeroEnergia extends NumeroPrimitivo implements Comparable {

    public NumeroEnergia() {
        super(0.0);
        this.unidadeEnergia = UNIDADE_ENERGIA_SI;
    }

    public NumeroEnergia(final String unidadeEnergia) {
        super(0.0);
        if (unidadesAceitas.contains(unidadeEnergia)) {
            this.unidadeEnergia = unidadeEnergia;
        } else {
            this.unidadeEnergia = UNIDADE_ENERGIA_SI;
        }
    }

    public NumeroEnergia(NumeroEnergia n1) {
        super(n1.valor);
        this.unidadeEnergia = n1.unidadeEnergia;
    }

    public NumeroEnergia(double valor, final String unidadeEnergia) {
        super(valor);
        if (unidadesAceitas.contains(unidadeEnergia)) {
            this.unidadeEnergia = unidadeEnergia;
        } else {
            this.unidadeEnergia = UNIDADE_ENERGIA_SI;
        }
    }

    public String getUnidade() {
        return this.unidadeEnergia;
    }

    @Override
    public int compareTo(Object o) {
        NumeroEnergia n1 = (NumeroEnergia) o;
        if (n1.unidadeEnergia.equals(this.unidadeEnergia)) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return this.getSinal() + Math.abs(this.valor) + this.unidadeEnergia;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof NumeroArea) {
            NumeroEnergia n1 = (NumeroEnergia) o;
            if (n1.negativo && !this.negativo) {
                return false;
            } else if (!n1.unidadeEnergia.equals(this.unidadeEnergia)) {
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

    private final static String UNIDADE_ENERGIA_SI = "J";
    private static ArrayList<String> unidadesAceitas = new ArrayList<>(Arrays.asList("MJ", "KJ", "J", "kcal", "cal", "kWh", "Wh", "th", "fg", "tep", "tec", "BTU", "eV"));
    private final String unidadeEnergia;
}
