package calculadoracientifica.ajusteCurvas;

import java.awt.Color;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficosAjustados extends javax.swing.JFrame {

    public GraficosAjustados(ArrayList<Double> xAjustado, ArrayList<Double> yAjustado) {
        initComponents();
        this.x = xAjustado;
        this.y = yAjustado;
        this.vazio = "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        areaGrafico = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout areaGraficoLayout = new javax.swing.GroupLayout(areaGrafico);
        areaGrafico.setLayout(areaGraficoLayout);
        areaGraficoLayout.setHorizontalGroup(
            areaGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );
        areaGraficoLayout.setVerticalGroup(
            areaGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
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
    }// </editor-fold>//GEN-END:initComponents
    
    public void criarGrafico() {
            XYDataset dataset;
            dataset = criarPontos();

            JFreeChart chart = ChartFactory.createXYLineChart(vazio, "x", "y", dataset);
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

    private XYDataset criarPontos() {

        int tamanho = x.size();
        XYSeries s1 = new XYSeries(vazio);
        for (int i=0;i<tamanho;i++){
            s1.add(x.get(i), y.get(i));
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
    }
    
    private ArrayList<Double> x;
    private ArrayList<Double> y;
    private final String vazio;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaGrafico;
    // End of variables declaration//GEN-END:variables
}
