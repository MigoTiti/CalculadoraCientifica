package GUI;

import calculadoracientifica.ajusteCurvas.CalculadoraAjusteExponencial;
import calculadoracientifica.ajusteCurvas.CalculadoraAjusteLinear;
import calculadoracientifica.ajusteCurvas.CalculadoraAjusteQuadratico;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class AjusteCurvas extends javax.swing.JFrame {

    public AjusteCurvas() {
        initComponents();
        this.formatador = new DecimalFormat();
        this.formatador.setDecimalSeparatorAlwaysShown(false);
        
        this.pontos = new DefaultTableModel();
        this.pontos.addColumn("x");
        this.pontos.addColumn("y");
        
        this.tabelaPontos.setModel(pontos);
        this.plotarLinear.setEnabled(false);
        this.plotarQuadratica.setEnabled(false);
        this.plotarExp.setEnabled(false);
        this.removerPonto.setEnabled(false);
        this.ajustar.setEnabled(false);
        this.limparTudo.setEnabled(false);
        this.x = new ArrayList<>();
        this.y = new ArrayList<>();
        
        this.vazio = "";
        this.contadorPontos = 0;
        this.xPonto.requestFocusInWindow();
        
        this.exponencial = new CalculadoraAjusteExponencial();
        this.linear = new CalculadoraAjusteLinear();
        this.quadratico = new CalculadoraAjusteQuadratico();
        
        this.equacaoLinear = new StringBuilder();
        this.equacaoExp = new StringBuilder();
        this.equacaoQuadratica = new StringBuilder();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaElementos = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaPontos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        voltar = new javax.swing.JButton();
        xPonto = new javax.swing.JTextField();
        yPonto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        adicionarPonto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        equacaoLinearExpressao = new javax.swing.JTextField();
        equacaoQuadraticaExpressao = new javax.swing.JTextField();
        equacaoExpExpressao = new javax.swing.JTextField();
        plotarLinear = new javax.swing.JButton();
        plotarQuadratica = new javax.swing.JButton();
        plotarExp = new javax.swing.JButton();
        ajustar = new javax.swing.JButton();
        limparTudo = new javax.swing.JButton();
        removerPonto = new javax.swing.JButton();

        tabelaElementos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaElementos.setColumnSelectionAllowed(true);
        tabelaElementos.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tabelaElementos);

        jButton6.setText("jButton6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tabelaPontos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaPontos.setColumnSelectionAllowed(true);
        tabelaPontos.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tabelaPontos);

        jLabel1.setText("PONTOS");

        voltar.setText("VOLTAR");
        voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarMouseClicked(evt);
            }
        });

        jLabel2.setText("x");

        jLabel3.setText("y");

        adicionarPonto.setText("ADICIONAR PONTO");
        adicionarPonto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adicionarPontoMouseClicked(evt);
            }
        });

        jLabel4.setText("AJUSTE LINEAR");

        jLabel5.setText("AJUSTE QUADRÁTICO");

        jLabel6.setText("AJUSTE EXPONENCIAL");

        equacaoLinearExpressao.setEditable(false);

        equacaoQuadraticaExpressao.setEditable(false);
        equacaoQuadraticaExpressao.setFocusable(false);

        equacaoExpExpressao.setEditable(false);
        equacaoExpExpressao.setFocusable(false);

        plotarLinear.setText("PLOTAR GRÁFICO");

        plotarQuadratica.setText("PLOTAR GRÁFICO");

        plotarExp.setText("PLOTAR GRÁFICO");

        ajustar.setText("AJUSTAR");
        ajustar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajustarMouseClicked(evt);
            }
        });

        limparTudo.setText("LIMPAR TUDO");
        limparTudo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparTudoMouseClicked(evt);
            }
        });

        removerPonto.setText("REMOVER");
        removerPonto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removerPontoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(voltar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removerPonto))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(xPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(yPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(58, 58, 58)
                            .addComponent(jLabel3)
                            .addGap(28, 28, 28))
                        .addComponent(adicionarPonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(equacaoLinearExpressao, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(equacaoQuadraticaExpressao)
                        .addComponent(equacaoExpExpressao))
                    .addComponent(plotarLinear, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(plotarQuadratica, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(plotarExp, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(limparTudo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ajustar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(xPonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yPonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adicionarPonto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(equacaoLinearExpressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plotarLinear)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(equacaoQuadraticaExpressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plotarQuadratica)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(equacaoExpExpressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plotarExp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(limparTudo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ajustar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(voltar, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(removerPonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseClicked
        dispose();
        TelaInicial escolha = new TelaInicial();
        escolha.setVisible(true);
    }//GEN-LAST:event_voltarMouseClicked

    private void adicionarPontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adicionarPontoMouseClicked
        double xValor = Double.parseDouble(xPonto.getText());
        double yValor = Double.parseDouble(yPonto.getText());
        x.add(xValor);
        y.add(yValor);
        
        String xFormatado, yFormatado;
        xFormatado = formatador.format(xValor);
        yFormatado = formatador.format(yValor);
        
        pontos.addRow(new Object[]{xFormatado,yFormatado});
        
        xPonto.setText(vazio);
        yPonto.setText(vazio);
        
        if(ajustar.isEnabled()==false)
            ajustar.setEnabled(true);
        if(removerPonto.isEnabled()==false)
            removerPonto.setEnabled(true);
        if(limparTudo.isEnabled()==false)
            limparTudo.setEnabled(true);
        
        xPonto.requestFocusInWindow();
        contadorPontos++;
    }//GEN-LAST:event_adicionarPontoMouseClicked

    private void removerPontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerPontoMouseClicked
        int index = tabelaPontos.getSelectedRow();
        x.remove(index);
        y.remove(index);
        pontos.removeRow(index);
        contadorPontos--;
        if(contadorPontos==0){
            ajustar.setEnabled(false);
            removerPonto.setEnabled(false);
        }
    }//GEN-LAST:event_removerPontoMouseClicked

    private void ajustarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajustarMouseClicked
        double[] coeficientesLineares;
        coeficientesLineares = linear.ajuste(x, y);
        String aLinearFormatado = formatador.format(coeficientesLineares[0]);
        String bLinearFormatado = formatador.format(coeficientesLineares[1]);
        
        switch (aLinearFormatado) {
            case "1":
                equacaoLinear.append("x");
                if(!"0".equals(bLinearFormatado))
                    equacaoLinear.append(" + ").append(bLinearFormatado);
                break;
            case "0":
                equacaoLinear.append(bLinearFormatado);
                break;
            default:
                equacaoLinear.append(aLinearFormatado).append("x");
                if(!"0".equals(bLinearFormatado))
                    equacaoLinear.append(" + ").append(bLinearFormatado);
                break;
        }
        
        equacaoLinearExpressao.setText(equacaoLinear.toString());
        plotarLinear.setEnabled(true);
        
        double[] coeficientesQuadraticos;
        coeficientesQuadraticos = quadratico.ajuste(x, y);
        boolean aQuadraticoNegativo = false;
        boolean bQuadraticoNegativo = false;
        boolean cQuadraticoNegativo = false;
        
        if(coeficientesQuadraticos[2]<0)
            aQuadraticoNegativo = true;
        if(coeficientesQuadraticos[1]<0)
            bQuadraticoNegativo = true;
        if(coeficientesQuadraticos[0]<0)
            cQuadraticoNegativo = true;
        
        String aQuadraticoFormatado = formatador.format(coeficientesQuadraticos[2]);
        String bQuadraticoFormatado = formatador.format(coeficientesQuadraticos[1]);
        String cQuadraticoFormatado = formatador.format(coeficientesQuadraticos[0]);
        
        switch (aQuadraticoFormatado) {
            case "1":
                if(aQuadraticoNegativo)
                    equacaoQuadratica.append("-x^2");
                else
                    equacaoQuadratica.append("x^2");
                
                if(!"0".equals(bQuadraticoFormatado)){
                    if(bQuadraticoNegativo){  
                        if("1".equals(bQuadraticoFormatado))
                            equacaoQuadratica.append(" - x");
                        else
                            equacaoQuadratica.append(" - ").append(bQuadraticoFormatado).append("x");
                    }else{
                        if("1".equals(bQuadraticoFormatado))
                            equacaoQuadratica.append(" + x");
                        else
                            equacaoQuadratica.append(" + ").append(bQuadraticoFormatado).append("x");
                    }
                }
                
                if(!"0".equals(cQuadraticoFormatado)){
                    if(cQuadraticoNegativo)
                        equacaoQuadratica.append(" - ").append(cQuadraticoFormatado);
                    else
                        equacaoQuadratica.append(" + ").append(cQuadraticoFormatado);
                }
                
                break;
            case "0":
                if(!"0".equals(bQuadraticoFormatado)){
                    if(bQuadraticoNegativo){  
                        if("1".equals(bQuadraticoFormatado))
                            equacaoQuadratica.append("-x");
                        else
                            equacaoQuadratica.append(bQuadraticoFormatado).append("x");
                    }else{
                        if("1".equals(bQuadraticoFormatado))
                            equacaoQuadratica.append("x");
                        else
                            equacaoQuadratica.append(bQuadraticoFormatado).append("x");
                    }
                }
                
                if(!"0".equals(cQuadraticoFormatado)){
                    if(cQuadraticoNegativo)
                        equacaoQuadratica.append(" ").append(cQuadraticoFormatado);
                    else
                        equacaoQuadratica.append(" + ").append(cQuadraticoFormatado);
                }
                
                break;
            default:
                if(aQuadraticoNegativo)
                    equacaoQuadratica.append("-").append(aQuadraticoFormatado).append("x^2");
                else
                    equacaoQuadratica.append(aQuadraticoFormatado).append("x^2");
                
                if(!"0".equals(bQuadraticoFormatado)){
                    if(bQuadraticoNegativo){  
                        if("1".equals(bQuadraticoFormatado))
                            equacaoQuadratica.append(" - x");
                        else
                            equacaoQuadratica.append(" ").append(bQuadraticoFormatado).append("x");
                    }else{
                        if("1".equals(bQuadraticoFormatado))
                            equacaoQuadratica.append(" + x");
                        else
                            equacaoQuadratica.append(" + ").append(bQuadraticoFormatado).append("x");
                    }
                }
                
                if(!"0".equals(cQuadraticoFormatado)){
                    if(cQuadraticoNegativo)
                        equacaoQuadratica.append(" ").append(cQuadraticoFormatado);
                    else
                        equacaoQuadratica.append(" + ").append(cQuadraticoFormatado);
                }
                break;
        }
        
        equacaoQuadraticaExpressao.setText(equacaoQuadratica.toString());
        plotarQuadratica.setEnabled(true);
        
        double[] coeficientesExp;
        coeficientesExp = exponencial.ajuste(x, y);
        String aExpFormatado = formatador.format(coeficientesExp[0]);
        String bExpFormatado = formatador.format(coeficientesExp[1]);
        equacaoExp.append(aExpFormatado).append("e^").append(bExpFormatado);
        equacaoExpExpressao.setText(equacaoExp.toString());
        plotarExp.setEnabled(true);
    }//GEN-LAST:event_ajustarMouseClicked

    private void limparTudoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparTudoMouseClicked
        x.clear();
        y.clear();
        equacaoLinear.setLength(0);
        equacaoQuadratica.setLength(0);
        equacaoExp.setLength(0);
        contadorPontos = 0;
        
        int colunas = pontos.getRowCount();
        for(int i=colunas-1;i>=0;i--)
            pontos.removeRow(i);
        
        equacaoLinearExpressao.setText(vazio);
        equacaoExpExpressao.setText(vazio);
        equacaoQuadraticaExpressao.setText(vazio);
    }//GEN-LAST:event_limparTudoMouseClicked

    private int contadorPontos;
    private ArrayList<Double> x;
    private ArrayList<Double> y;
    private DefaultTableModel pontos;
    private StringBuilder equacaoLinear;
    private StringBuilder equacaoExp;
    private StringBuilder equacaoQuadratica;
    
    private final String vazio;
    private final DecimalFormat formatador;
    private final CalculadoraAjusteQuadratico quadratico;
    private final CalculadoraAjusteExponencial exponencial;
    private final CalculadoraAjusteLinear linear;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarPonto;
    private javax.swing.JButton ajustar;
    private javax.swing.JTextField equacaoExpExpressao;
    private javax.swing.JTextField equacaoLinearExpressao;
    private javax.swing.JTextField equacaoQuadraticaExpressao;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton limparTudo;
    private javax.swing.JButton plotarExp;
    private javax.swing.JButton plotarLinear;
    private javax.swing.JButton plotarQuadratica;
    private javax.swing.JButton removerPonto;
    private javax.swing.JTable tabelaElementos;
    private javax.swing.JTable tabelaPontos;
    private javax.swing.JButton voltar;
    private javax.swing.JTextField xPonto;
    private javax.swing.JTextField yPonto;
    // End of variables declaration//GEN-END:variables
}
