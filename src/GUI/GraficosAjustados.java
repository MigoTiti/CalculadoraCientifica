package GUI;

import java.awt.Color;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficosAjustados extends javax.swing.JFrame {

    public GraficosAjustados(ArrayList<Double> xAjustado, ArrayList<Double> yAjustado, ArrayList<Double> yOriginal) {
        initComponents();
        this.x = xAjustado;
        this.y = yAjustado;
        this.yOriginal = yOriginal;
        this.vazio = "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        areaGrafico = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gráfico ajustado");
        setResizable(false);

        javax.swing.GroupLayout areaGraficoLayout = new javax.swing.GroupLayout(areaGrafico);
        areaGrafico.setLayout(areaGraficoLayout);
        areaGraficoLayout.setHorizontalGroup(
            areaGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );
        areaGraficoLayout.setVerticalGroup(
            areaGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void criarGrafico() {
        
        XYSeries serieAjustada = criarPontos();
        XYSeries pontosOriginais = criarPontosOriginais();
        
        XYSeriesCollection dadosAjustes = new XYSeriesCollection();
        dadosAjustes.addSeries(serieAjustada);
        dadosAjustes.addSeries(pontosOriginais);

        JFreeChart grafico = criarChart(dadosAjustes);
        ChartPanel telaGrafico = new ChartPanel(grafico);

        tracarGrafico = grafico.getXYPlot();
        
        XYLineAndShapeRenderer renderizador = (XYLineAndShapeRenderer) tracarGrafico.getRenderer();
        
        renderizador.setBaseShapesVisible(true);
        renderizador.setSeriesLinesVisible(1, false);

        tracarGrafico.setBackgroundPaint(Color.lightGray);
        tracarGrafico.setDomainGridlinePaint(Color.white);
        tracarGrafico.setRangeGridlinePaint(Color.white);
        
        tracarGrafico.setRangePannable(true);
        tracarGrafico.setDomainPannable(true);

        telaGrafico.setSize(areaGrafico.getWidth(),areaGrafico.getHeight());
        telaGrafico.setVisible(true);
        telaGrafico.setMouseZoomable(true);
        telaGrafico.setMouseWheelEnabled(true);

        telaGrafico.getChart().removeLegend();

        areaGrafico.removeAll();
        areaGrafico.add(telaGrafico);
        areaGrafico.revalidate();
        areaGrafico.repaint();
        grafico.setBackgroundPaint(Color.WHITE);
            
    }

    private JFreeChart criarChart(final XYDataset dataset){
        JFreeChart grafico = ChartFactory.createXYLineChart(vazio, "x", "y", dataset);
        grafico.setBackgroundPaint(Color.white);
        
        return grafico;
    }
    
    private XYSeries criarPontos() {

        int tamanho = x.size();
        XYSeries serieAjustada = new XYSeries("Ajustado");
        for (int i=0;i<tamanho;i++){
            serieAjustada.add(x.get(i), y.get(i));
        }     
        
        return serieAjustada;
    }
    
    private XYSeries criarPontosOriginais(){
        int tamanho = x.size();
        
        XYSeries pontosOriginais = new XYSeries("Original");
        for (int i=0;i<tamanho;i++){
            pontosOriginais.add(x.get(i), yOriginal.get(i));
        }
        
        return pontosOriginais;
    }
    
    private XYPlot tracarGrafico;
    private ArrayList<Double> x;
    private ArrayList<Double> y;
    private ArrayList<Double> yOriginal;
    private final String vazio;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaGrafico;
    // End of variables declaration//GEN-END:variables
}
