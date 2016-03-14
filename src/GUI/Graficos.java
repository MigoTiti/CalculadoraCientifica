package GUI;

import calculadoracientifica.Graficos.CalculadoraGraficos;
import calculadoracientifica.Interfaces.OperacoesPrimitivas;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graficos extends javax.swing.JFrame implements OperacoesPrimitivas{

    public Graficos() {
        initComponents();
        this.y = new ArrayList<>();
        this.x = new ArrayList<>();
        this.xProximo = false;
        this.equacaoCompleta = false;
        this.posicao = 0;
        this.contadorParenteses = 0;
        this.sinal = false;
        this.parenteses = false;
        this.equacao = new StringBuilder();
        this.xPosicoes = new ArrayList<>();
        this.operadoresAuxiliar = new ArrayList<>();
        this.operadores = new ArrayList<>();
        this.sinais = new ArrayList<>(); 
        this.graficos = new CalculadoraGraficos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        equacaoLer = new javax.swing.JTextField();
        equacaoDigitar = new javax.swing.JButton();
        plotar = new javax.swing.JButton();
        limparTudo = new javax.swing.JButton();
        limparEquacao = new javax.swing.JButton();
        comecoIntervalo = new javax.swing.JTextField();
        fimIntervalo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        xVariando = new javax.swing.JTextField();
        areaGrafico = new javax.swing.JPanel();
        voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        equacaoLer.setEditable(false);

        equacaoDigitar.setText("EQUACAO");
        equacaoDigitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equacaoDigitarMouseClicked(evt);
            }
        });

        plotar.setText("PLOTAR GRÁFICO");
        plotar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plotarMouseClicked(evt);
            }
        });

        limparTudo.setText("LIMPAR TUDO");
        limparTudo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparTudoMouseClicked(evt);
            }
        });

        limparEquacao.setText("LIMPAR EQUAÇÃO");
        limparEquacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparEquacaoMouseClicked(evt);
            }
        });

        jLabel1.setText("a");

        jLabel2.setText("de");

        jLabel3.setText("INTERVALO");

        jLabel4.setText("X VARIANDO");

        javax.swing.GroupLayout areaGraficoLayout = new javax.swing.GroupLayout(areaGrafico);
        areaGrafico.setLayout(areaGraficoLayout);
        areaGraficoLayout.setHorizontalGroup(
            areaGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        areaGraficoLayout.setVerticalGroup(
            areaGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        voltar.setText("VOLTAR");
        voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comecoIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(voltar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(equacaoLer, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(equacaoDigitar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fimIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(limparEquacao, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(plotar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(82, 82, 82)
                                .addComponent(jLabel4))
                            .addComponent(xVariando, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(limparTudo)))
                .addContainerGap())
            .addComponent(areaGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(areaGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(limparTudo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limparEquacao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comecoIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fimIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(xVariando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(equacaoLer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(equacaoDigitar)
                    .addComponent(plotar)
                    .addComponent(voltar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void equacaoDigitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equacaoDigitarMouseClicked
        if(equacaoCompleta==false){
            boolean sucesso = digitarEquacao();
            if(sucesso){
                equacaoLer.setText(equacao.toString());
            }
        }
        else{

        }   
    }//GEN-LAST:event_equacaoDigitarMouseClicked

    private void limparEquacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparEquacaoMouseClicked
        operadoresAuxiliar.clear();
        sinais.clear();
        equacao.setLength(0);
        equacaoLer.setText(VAZIO);
        xPosicoes.clear();
    }//GEN-LAST:event_limparEquacaoMouseClicked

    private void limparTudoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparTudoMouseClicked
        limpar();
    }//GEN-LAST:event_limparTudoMouseClicked

    private void voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseClicked
        voltar();
    }//GEN-LAST:event_voltarMouseClicked

    private void plotarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plotarMouseClicked
        obterResposta();
    }//GEN-LAST:event_plotarMouseClicked

    public void criarGrafico(){
        XYDataset dados;
        dados = criarPontos();
        
        JFreeChart chart = criarChart(dados);
        ChartPanel myChartPanel = new ChartPanel(chart, true);
         
        myChartPanel.setSize(areaGrafico.getWidth(),areaGrafico.getHeight());
        myChartPanel.setVisible(true);
        
        myChartPanel.setMouseZoomable(true);
        
        myChartPanel.getChart().removeLegend();
        
        areaGrafico.removeAll();
        areaGrafico.add(myChartPanel);
        areaGrafico.revalidate();
        areaGrafico.repaint();
        chart.setBackgroundPaint(Color.WHITE);
    }
    
    private JFreeChart criarChart(final XYDataset dados){
        JFreeChart chart = ChartFactory.createXYLineChart(VAZIO, "x", "y", dados);
        chart.setBackgroundPaint(Color.white);
        final XYPlot plot1 = chart.getXYPlot();
        plot1.setBackgroundPaint(Color.lightGray);
        plot1.setDomainGridlinePaint(Color.white);
        plot1.setRangeGridlinePaint(Color.white);
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot1.getRenderer();
        renderer.setBaseShapesVisible(true);
        return chart;
    }
    
    private XYDataset criarPontos() {

        int tamanho = x.size();
        XYSeries s1 = new XYSeries(VAZIO);
        for (int i=0;i<tamanho;i++){
            s1.add(x.get(i), y.get(i));
        }
       
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        
        return dataset;
    }
    
    public boolean digitarEquacao(){
        JTextField equacaoDigitar2 = new JTextField(VAZIO);
        JTextField equacaoLer2 = new JTextField(VAZIO);
        
        Action action = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean sucesso = false;
                String atual = equacaoDigitar2.getText();
                if(("+".equals(atual)||"-".equals(atual)||"*".equals(atual)||"/".equals(atual)||"^".equals(atual))&&(sinal==false||xProximo)){
                    sinais.add(atual);
                    sinal = true;
                    sucesso = true;
                    posicao--;
                    if(xProximo)
                        xProximo = false;
                }else if("(".equals(atual)&&sinal){
                    sinais.add(atual);
                    if(parenteses == false)
                        parenteses = true;
                    contadorParenteses++;
                    posicao--;
                    sucesso = true;
                }else if("ln".equals(atual)||"sqrt".equals(atual)||"sen".equals(atual)||"cos".equals(atual)||"tg".equals(atual)||"log".equals(atual)){
                    sinais.add(atual);
                    sinais.add("(");
                    posicao--;
                    atual = atual.concat("(");
                    if(parenteses == false)
                        parenteses = true;
                    contadorParenteses++;
                    sucesso = true;
                }else if(parenteses && ")".equals(atual)){
                    sinais.add(atual);
                    contadorParenteses--;
                    if(contadorParenteses <= 0)
                        parenteses = false;
                    if(sinal)
                        sinal = false;
                    sucesso = true;
                }else if((!")".equals(atual))&&(!"+".equals(atual))&&(!"-".equals(atual))&&(!"/".equals(atual))&&(!"*".equals(atual))&&(!"^".equals(atual))&&(!"(".equals(atual))&&(!"x".equals(atual))){
                    if(null!=atual)switch (atual) {
                        case "PI":
                        case "Pi":
                        case "pi":
                        case "pI":
                            operadores.add(Double.toString(Math.PI));
                            break;
                        case "E":
                        case "e":
                            operadores.add(Double.toString(Math.E));
                            break;
                        default:
                            operadores.add(atual);
                            break;
                    }
                    if(sinal)
                        sinal = false;
                    sucesso = true;
                }else if("x".equals(atual)&&sinal&&xProximo==false){
                    xProximo = true;
                    xPosicoes.add(posicao);
                    sucesso = true;
                }
   
                if(sucesso){
                    equacao.append(atual);
                    posicao++;
                }
                
                equacaoDigitar2.setText(VAZIO);
                equacaoLer2.setText(equacao.toString());
            }
        };
        
        equacaoDigitar2.addActionListener(action);
                
        JPanel equacaoPainel = new JPanel(new GridLayout(0, 1));
        equacaoPainel.add(new JLabel("Função: "));
        equacaoPainel.add(equacaoDigitar2);
        
        equacaoPainel.add(equacaoLer2);
        equacaoLer2.setEditable(false);
        
        int result = JOptionPane.showConfirmDialog(null, equacaoPainel, "Equação", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            for (String operador : operadores) {
                operadoresAuxiliar.add(Double.parseDouble(operador));
            }
            operadores.clear();
            parenteses = false;
            sinal = false;
            contadorParenteses = 0;
            equacaoCompleta = true;
            xProximo = false;
            return true;
        } else {
            operadores.clear();
            sinais.clear();
            equacao.setLength(0);
            parenteses = false;
            sinal = false;
            contadorParenteses = 0;
            posicao = 0;
            xProximo = false;
            return false;
        }
    }
    
    @Override
    public void limpar() {
        operadoresAuxiliar.clear();
        sinais.clear();
        equacao.setLength(0);
        equacaoLer.setText(VAZIO);
        equacaoCompleta = false;
        xPosicoes.clear();
        comecoIntervalo.setText(VAZIO);
        fimIntervalo.setText(VAZIO);
        xVariando.setText(VAZIO);
        x.clear();
        y.clear();
        criarGrafico();
        posicao = 0;
    }

    @Override
    public void voltar() {
        dispose();
        TelaInicial escolha = new TelaInicial();
        escolha.setVisible(true);
    }

    @Override
    public void obterResposta() {
        double limiteInferior = Double.parseDouble(comecoIntervalo.getText());
        double limiteSuperior = Double.parseDouble(fimIntervalo.getText());
        double delta = Double.parseDouble(xVariando.getText());
        ArrayList<Integer> xPosicoes2;
        ArrayList<Double> operadoresAuxiliar2;
        ArrayList<String> sinais2;
        for(double i = limiteInferior;i<=limiteSuperior;i+=delta){
            xPosicoes2 = new ArrayList<>(xPosicoes);
            operadoresAuxiliar2 = new ArrayList<>(operadoresAuxiliar);
            sinais2 = new ArrayList<>(sinais);
            x.add(i);
            y.add(graficos.interpretadorIntermediario(i, xPosicoes2, operadoresAuxiliar2, sinais2));
        }
        
        criarGrafico();
    }
    
    private ArrayList<Double> y;
    private ArrayList<Double> x;
    private boolean xProximo;
    private boolean equacaoCompleta;
    private int posicao;
    private int contadorParenteses;
    private boolean sinal;
    private boolean parenteses;
    private StringBuilder equacao;
    private ArrayList<Integer> xPosicoes;
    private ArrayList<Double> operadoresAuxiliar;
    private ArrayList<String> operadores;
    private ArrayList<String> sinais;
    private final CalculadoraGraficos graficos;
    
    public static final String VAZIO = "";  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaGrafico;
    private javax.swing.JTextField comecoIntervalo;
    private javax.swing.JButton equacaoDigitar;
    private javax.swing.JTextField equacaoLer;
    private javax.swing.JTextField fimIntervalo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton limparEquacao;
    private javax.swing.JButton limparTudo;
    private javax.swing.JButton plotar;
    private javax.swing.JButton voltar;
    private javax.swing.JTextField xVariando;
    // End of variables declaration//GEN-END:variables
}