package calculadoracientifica.Enums;

public enum Unidades {

    quilometroQuadrado("Quilômetro quadrado", "km²", "Área"),
    hectare("Hectare ou hectômetro quadrado", "ha", "Área"),
    are("Are ou decâmetro quadrado", "dam²", "Área"),
    metroQuadrado("Metro quadrado", "m²", "Área"),
    decimetroQuadrado("Decímetro quadrado", "dm²", "Área"),
    centimetroQuadrado("Centímetro quadrado", "cm²", "Área"),
    milimetroQuadrado("Milímetro quadrado", "mm²", "Área"),
    milhaQuadrada("Milha quadrada", "mi²", "Área"),
    leguaQuadrada("Légua quadrada", "lea²", "Área"),
    megaJoule("Megajoule", "MJ", "Energia"),
    quiloJoule("Quilojoule", "KJ", "Energia"),
    joule("Joule", "J", "Energia"),
    kCaloria("Quilocaloria", "kcal", "Energia"),
    caloria("Caloria", "cal", "Energia"),
    quiloWattHora("Quilowatt-hora", "kWh", "Energia"),
    wattHora("Watt-hora", "Wh", "Energia"),
    Termia("Termia", "th", "Energia"),
    Frigoria("Frigoria", "fg", "Energia"),
    toneladaPetroleo("Tonelada equivalente de petróleo", "tep", "Energia"),
    toneladaCarvao("Tonelada equivalente de carvão", "tec", "Energia"),
    btu("Unidade térmica britânica", "BTU", "Energia"),
    eletronVolt("Elétron-volt", "eV", "Energia"),
    megaGrama("Megagrama ou tonelada", "t", "Massa"),
    quiloGrama("Quilograma", "kg", "Massa"),
    grama("Grama", "g", "Massa"),
    miliGrama("Miligrama", "mg", "Massa"),
    libra("Libra", "lb", "Massa"),
    quilate("Quilate", "ct", "Massa"),
    quilometro("Quilômetro", "km", "Medida"),
    hectometro("Hectômetro", "hm", "Medida"),
    decametro("Decâmetro", "dam", "Medida"),
    metro("Metro", "m", "Medida"),
    decimetro("Decímetro", "dm", "Medida"),
    centimetro("Centímetro", "cm", "Medida"),
    milimetro("Milimetro", "mm", "Medida"),
    milha("Milha", "mi", "Medida"),
    anoLuz("Ano-luz", "ly", "Medida"),
    kelvin("Kelvin", "K", "Temperatura"),
    grauCelsius("Grau Celsius", "°C", "Temperatura"),
    grauFarenheit("Grau Farenheit", "°F", "Temperatura"),
    grauNewton("Grau Newton", "°N", "Temperatura"),
    milenio("Milênio", "Milênio", "Tempo"),
    seculo("Século", "Século", "Tempo"),
    decada("Década", "Década", "Tempo"),
    ano("Ano", "Ano", "Tempo"),
    mes("Mês", "Mês", "Tempo"),
    semana("Semana", "Semana", "Tempo"),
    dia("Dia", "Dia", "Tempo"),
    hora("Hora", "h", "Tempo"),
    minuto("Minuto", "min", "Tempo"),
    segundo("Segundo", "s", "Tempo"),
    quilometroCubico("Quilômetro cúbico", "km³", "Volume"),
    hectometroCubico("Hectômetro cúbico", "hm³", "Volume"),
    decametroCubico("Decâmetro cúbico", "dam³", "Volume"),
    metroCubico("Metro cúbico", "m³", "Volume"),
    decimetroCubico("Decímetro cúbico", "dm³", "Volume"),
    centimetroCubico("Centímetro cúbico", "cm³", "Volume"),
    milimetroCubico("Milímetro cúbico", "mm³", "Volume"),
    quiloLitro("Quilolitro", "kL", "Volume"),
    hectoLitro("Hectolitro", "hL", "Volume"),
    decaLitro("Decalitro", "daL", "Volume"),
    litro("Litro", "L", "Volume"),
    deciLitro("Decilitro", "dL", "Volume"),
    centiLitro("Centilitro", "cL", "Volume"),
    miliLitro("Mililitro", "mL", "Volume"),
    barrilEstadunidense("Barril estadunidense", "bbl(US)", "Volume"),
    barrilImperial("Barril britânico", "bbl(UK)", "Volume"),
    galaoEstadunidense("Galão estadunidense", "gal(US)", "Volume"),
    galaoImperial("Galão britânico", "gal(UK)", "Volume");

    private Unidades(String descricao, String simbolo, String tipo) {
        this.descricao = descricao;
        this.simbolo = simbolo;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return this.simbolo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getTipo() {
        return this.tipo;
    }

    private final String descricao;
    private final String simbolo;
    private final String tipo;
}
