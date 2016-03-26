package calculadoracientifica.Enums;

public enum Constantes{
    
    nEuler("e","Número de Euler",2.7181828459045235360287),
    mProton("mp","Massa do próton",1.6726*1e-27),
    mNeutron("mn","Massa do nêutron",1.6749*1e-27),
    mEletron("me","Massa do elétron",9.1094*1e-31),
    mMuon("mμ","Massa de muon",1.8835*1e-28),
    rBohr("a₀","Raio de Bohr",5.2918*1e-11),
    cPlanck("ћ","Constante de Planck",6.6261*1e-34),
    maNuclear("μN","Magnéton nuclear",5.0508*1e-27),
    maBohr("μB","Magnéton de Bohr",9.2740*1e-24),
    cPlanckRac("ћ","Constante de Planck racionalizada",1.0546*1e-34),
    cEstruturaFina("α","Constante de estrutura fina",7.2974*1e-3),
    rEletronClass("re","Raio de elétron clássico",2.8179*1e-15),
    compOndaCompton("λc","Comprimento de onda de Compton",2.4263*1e-12),
    rGiroProton("γp","Raio giromagnético de próton",267522209.9),
    compOndaComptonProton("λcp","Comprimento de onda de Compton de próton",1.3214*1e-15),
    compOndaComptonNeutron("λcn","Comprimento de onda de Compton de nêutron",1.3196*1e-15),
    cRydberg("R∞","Constante de Rydberg",10973731.57),
    uMassaAt("u","Unidade de massa atômica",1.6605*1e-27),
    moMagneticoProton("μp","Momento magnético de próton",1.4106*1e-26),
    moMagneticoEletron("μe","Momento magnético de elétron",-9.2848*1e-24),
    moMagneticoNeutron("μn","Momento magnético de nêutron",-9.6624*1e-27),
    moMagneticoMuon("μμ","Momento magnético de muon",-4.4904*1e-26),
    cFaraday("F","Constante de Faraday",96485.3399),
    caElementar("e","Carga elementar",1.6022*1e-19),
    cAvogadro("NA","Constante de Avogadro",6.0221*1e23),
    cBoltzmann("k","Constante de Boltzmann",1.3807*1e-23),
    vMolarGasIdeal("Vm","Volume molar de gás ideal",0.022413996),
    cGasMolar("R","Constante de gás molar",8.314472),
    vLuzVacuo("C₀","Velocidade da luz no vácuo",299792458),
    cPrimeiraRadiacao("C₁","Constante de primeira radiação",3.7418*1e-16),
    cSegundaRadiacao("C₂","Constante de segunda radiação",0.014387752),
    cStefanBoltzmann("σ","Constante de Stefan-Boltzmann",5.6704*1e-8),
    cEletrica("ε₀","Constante elétrica",8.8542*1e-12),
    cMagnetica("μ₀","Constante magnética",1.2566*1e-6),
    qFluxoMag("ϕ₀","Quantum de fluxo magnético",2.0678*1e-15),
    aPadraoGravidade("g","Aceleração padrão da gravidade",9.80665),
    qCondutância("G₀","Quantum de condutância",7.7480*1e-5),
    iCaracteristicaVacuo("Z₀","Impedância característica do vácuo",376.7303135),
    cNewtonGrav("G","Constante gravitacional universal",6.67428*1e-11),
    atm("atm","Atmosfera padrão",101325);
    
    private Constantes(String simbolo, String nome, double valor){
        this.simbolo = simbolo;
        this.valor = valor;
        this.nome = nome;
    }
    
    public double getValor(){
        return this.valor;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getSimbolo(){
        return this.simbolo;
    }
    
    @Override
    public String toString(){
        return this.simbolo;
    }
    
    private String simbolo;
    private final double valor;
    private final String nome;
}
