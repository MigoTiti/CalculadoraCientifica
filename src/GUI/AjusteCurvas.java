package GUI;

import calculadoracientifica.Interfaces.OperacoesPrimitivas;
import calculadoracientifica.AjusteCurvas.CalculadoraAjusteExponencial;
import calculadoracientifica.AjusteCurvas.CalculadoraAjusteLinear;
import calculadoracientifica.AjusteCurvas.CalculadoraAjustePotencial;
import calculadoracientifica.AjusteCurvas.CalculadoraAjusteQuadratico;
import calculadoracientifica.Graficos.CurvasAjustadas.CalculadoraGraficosAjustados;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

public class AjusteCurvas extends javax.swing.JFrame implements OperacoesPrimitivas{

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
        this.plotarPotencial.setEnabled(false);
        this.removerPonto.setEnabled(false);
        this.ajustar.setEnabled(false);
        this.limparTudo.setEnabled(false);
        this.adicionarPonto.setEnabled(false);
        this.xPonto.addActionListener(action);
        this.yPonto.addActionListener(action);
        this.x = new ArrayList<>();
        this.y = new ArrayList<>();
        
        this.vazio = "";
        this.contadorPontos = 0;
        this.xPonto.requestFocusInWindow();
        
        this.exponencial = new CalculadoraAjusteExponencial();
        this.linear = new CalculadoraAjusteLinear();
        this.quadratico = new CalculadoraAjusteQuadratico();
        this.potencial = new CalculadoraAjustePotencial();
        
        this.equacaoLinear = new StringBuilder();
        this.equacaoExp = new StringBuilder();
        this.equacaoQuadratica = new StringBuilder();
        this.equacaoPotencial = new StringBuilder();
        
        this.numero1 = xPonto.getDocument();
        this.numero2 = yPonto.getDocument();
        
        this.numero1.addDocumentListener(new ControladorBotao(limparTudo));
        this.numero2.addDocumentListener(new ControladorBotao(limparTudo));
    }

    class ControladorBotao implements DocumentListener {
        JButton limparTudo;

        ControladorBotao(JButton button) {
            this.limparTudo = button;
            this.estadoPassadoVazio = true;
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            disableIfEmpty(e);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            disableIfEmpty(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            disableIfEmpty(e);
        }

        public void disableIfEmpty(DocumentEvent e) {
            if(e.getDocument().getLength() == 0){
                AjusteCurvas.camposCheios--;
                if(AjusteCurvas.camposCheios==0 && limparTudo.isEnabled())
                    limparTudo.setEnabled(false);
                if(AjusteCurvas.camposCheios<2 && adicionarPonto.isEnabled())
                    adicionarPonto.setEnabled(false);
                if(!estadoPassadoVazio)
                    estadoPassadoVazio = true;
            }else if(e.getDocument().getLength() > 0){
                if(estadoPassadoVazio){
                    AjusteCurvas.camposCheios++;
                    estadoPassadoVazio = false;
                }
                if(AjusteCurvas.camposCheios>0 && !limparTudo.isEnabled())
                    limparTudo.setEnabled(true);
                if(AjusteCurvas.camposCheios==2 && !adicionarPonto.isEnabled())
                    adicionarPonto.setEnabled(true);
            }   
        }
        private boolean estadoPassadoVazio;
    }
    
    Action action = new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e){
            if(!"".equals(xPonto.getText())&&!"".equals(yPonto.getText())){
                boolean sucesso;

                try{
                    auxiliarNumero = xPonto.getText();
                    if(auxiliarNumero.contains(","))
                        auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                    xValor = Double.parseDouble(auxiliarNumero);

                    auxiliarNumero = yPonto.getText();
                    if(auxiliarNumero.contains(","))
                        auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                    yValor = Double.parseDouble(auxiliarNumero);
                    sucesso = true;
                }
                catch(NumberFormatException e2){
                    JOptionPane.showMessageDialog(null, "Apenas números!");
                    sucesso = false;
                }

                if(sucesso){
                    x.add(xValor);
                    y.add(yValor);

                    String xFormatado, yFormatado;
                    xFormatado = formatador.format(xValor);
                    yFormatado = formatador.format(yValor);

                    pontos.addRow(new Object[]{xFormatado,yFormatado});

                    xPonto.setText(vazio);
                    yPonto.setText(vazio);

                    if(ajustar.isEnabled()==false && x.size()>1)
                        ajustar.setEnabled(true);
                    if(removerPonto.isEnabled()==false)
                        removerPonto.setEnabled(true);
                    if(limparTudo.isEnabled()==false)
                        limparTudo.setEnabled(true);

                    xPonto.requestFocusInWindow();
                    contadorPontos++;
                }

            }else
                xPonto.requestFocusInWindow();
        }
    };
    
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
        jLabel7 = new javax.swing.JLabel();
        equacaoPotencialExpressao = new javax.swing.JTextField();
        plotarPotencial = new javax.swing.JButton();

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
        setTitle("Ajuste de curvas");
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
        plotarLinear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plotarLinearMouseClicked(evt);
            }
        });

        plotarQuadratica.setText("PLOTAR GRÁFICO");
        plotarQuadratica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plotarQuadraticaMouseClicked(evt);
            }
        });

        plotarExp.setText("PLOTAR GRÁFICO");
        plotarExp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plotarExpMouseClicked(evt);
            }
        });

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

        jLabel7.setText("AJUSTE POTENCIAL");

        equacaoPotencialExpressao.setEditable(false);

        plotarPotencial.setText("PLOTAR GRÁFICO");
        plotarPotencial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plotarPotencialMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(voltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removerPonto))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(plotarPotencial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(equacaoExpExpressao)
                        .addComponent(plotarLinear, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(plotarQuadratica, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(plotarExp, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(equacaoPotencialExpressao, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(limparTudo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ajustar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(voltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removerPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(equacaoPotencialExpressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plotarPotencial)
                        .addGap(26, 26, 26)
                        .addComponent(limparTudo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ajustar)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseClicked
        voltar();
    }//GEN-LAST:event_voltarMouseClicked

    private void adicionarPontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adicionarPontoMouseClicked
        if(!"".equals(xPonto.getText())&&!"".equals(yPonto.getText())){
            boolean sucesso;
        
            try{
                auxiliarNumero = xPonto.getText();
                if(auxiliarNumero.contains(","))
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                xValor = Double.parseDouble(auxiliarNumero);
                
                auxiliarNumero = yPonto.getText();
                if(auxiliarNumero.contains(","))
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                yValor = Double.parseDouble(auxiliarNumero);
                sucesso = true;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Apenas números!");
                sucesso = false;
            }
            
            if(sucesso){
                x.add(xValor);
                y.add(yValor);

                String xFormatado, yFormatado;
                xFormatado = formatador.format(xValor);
                yFormatado = formatador.format(yValor);

                pontos.addRow(new Object[]{xFormatado,yFormatado});

                xPonto.setText(vazio);
                yPonto.setText(vazio);

                if(ajustar.isEnabled()==false && x.size()>1)
                    ajustar.setEnabled(true);
                if(removerPonto.isEnabled()==false)
                    removerPonto.setEnabled(true);
                if(limparTudo.isEnabled()==false)
                    limparTudo.setEnabled(true);

                xPonto.requestFocusInWindow();
                contadorPontos++;
            }
            
        }else
            xPonto.requestFocusInWindow();
    }//GEN-LAST:event_adicionarPontoMouseClicked

    private void removerPontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerPontoMouseClicked
        int index = tabelaPontos.getSelectedRow();
        x.remove(index);
        y.remove(index);
        pontos.removeRow(index);
        contadorPontos--;
        
        if(contadorPontos==0)
            removerPonto.setEnabled(false);
        
        if(contadorPontos<2){
            ajustar.setEnabled(false);
            plotarLinear.setEnabled(false);
            plotarQuadratica.setEnabled(false);
            plotarExp.setEnabled(false);
            plotarPotencial.setEnabled(false);
        }
    }//GEN-LAST:event_removerPontoMouseClicked

    private void ajustarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajustarMouseClicked
        obterResposta();
    }//GEN-LAST:event_ajustarMouseClicked

    private void limparTudoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparTudoMouseClicked
        if(limparTudo.isEnabled())
            limpar();
    }//GEN-LAST:event_limparTudoMouseClicked

    private void plotarLinearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plotarLinearMouseClicked
        if(plotarLinear.isEnabled()){
            CalculadoraGraficosAjustados graficoLinear = new CalculadoraGraficosAjustados(equacaoLinearString);
            graficoLinear.interpretadorStrings();
            graficoLinear.criarPontosAjustados(x,y);
        }
    }//GEN-LAST:event_plotarLinearMouseClicked

    private void plotarExpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plotarExpMouseClicked
        if(plotarExp.isEnabled()){
            CalculadoraGraficosAjustados graficoExp = new CalculadoraGraficosAjustados(equacaoExpStringExibir);
            graficoExp.interpretadorStrings();
            graficoExp.criarPontosAjustados(x,y);
        }
    }//GEN-LAST:event_plotarExpMouseClicked

    private void plotarQuadraticaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plotarQuadraticaMouseClicked
        if(plotarQuadratica.isEnabled()){
            CalculadoraGraficosAjustados graficoQuadratico = new CalculadoraGraficosAjustados(equacaoQuadraticaString);
            graficoQuadratico.interpretadorStrings();
            graficoQuadratico.criarPontosAjustados(x,y);
        }
    }//GEN-LAST:event_plotarQuadraticaMouseClicked

    private void plotarPotencialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plotarPotencialMouseClicked
        if(plotarPotencial.isEnabled()){
            CalculadoraGraficosAjustados graficoPotencial = new CalculadoraGraficosAjustados(equacaoPotencialStringExibir);
            graficoPotencial.interpretadorStrings();
            graficoPotencial.criarPontosAjustados(x,y);
        }
    }//GEN-LAST:event_plotarPotencialMouseClicked

    @Override
    public void limpar() {
        x.clear();
        y.clear();
        equacaoLinear.setLength(0);
        equacaoQuadratica.setLength(0);
        equacaoExp.setLength(0);
        equacaoPotencial.setLength(0);
        contadorPontos = 0;
        
        int colunas = pontos.getRowCount();
        for(int i=colunas-1;i>=0;i--)
            pontos.removeRow(i);
        
        removerPonto.setEnabled(false);
        ajustar.setEnabled(false);
        limparTudo.setEnabled(false);
        
        plotarLinear.setEnabled(false);
        plotarExp.setEnabled(false);
        plotarQuadratica.setEnabled(false);
        plotarPotencial.setEnabled(false);
        
        xPonto.setText(vazio);
        yPonto.setText(vazio);
        equacaoLinearExpressao.setText(vazio);
        equacaoExpExpressao.setText(vazio);
        equacaoQuadraticaExpressao.setText(vazio);
        equacaoPotencialExpressao.setText(vazio);
    }

    @Override
    public void voltar() {
        dispose();
        TelaInicial escolha = new TelaInicial();
        escolha.setVisible(true);
    }

    @Override
    public void obterResposta() {
        if(x.size()>1 && ajustar.isEnabled()){
        double[] coeficientesLineares;
        coeficientesLineares = linear.MinimosQuadradosAjuste(x, y);
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
        
        equacaoLinearStringExibir = equacaoLinear.toString();
        equacaoLinearExpressao.setText(equacaoLinearStringExibir);
        
        plotarLinear.setEnabled(true);
        
        for(int i=equacaoLinear.length()-1;i>0;i--){
            if(equacaoLinear.charAt(i)==' ')
                equacaoLinear.deleteCharAt(i);
        }
        
        equacaoLinearString = equacaoLinear.toString();
        
        double[] coeficientesQuadraticos;
        coeficientesQuadraticos = quadratico.MinimosQuadradosAjuste(x, y);
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
                        equacaoQuadratica.append(" - ").append(cQuadraticoFormatado);
                    else
                        equacaoQuadratica.append(" + ").append(cQuadraticoFormatado);
                }
                
                break;
            case "0":
            case "-0":
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
                    equacaoQuadratica.append(aQuadraticoFormatado).append("x^2");
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
        
        equacaoQuadraticaStringExibir = equacaoQuadratica.toString();
        equacaoQuadraticaExpressao.setText(equacaoQuadraticaStringExibir);
        plotarQuadratica.setEnabled(true);
        
        for(int i=equacaoQuadratica.length()-1;i>0;i--){
            if(equacaoQuadratica.charAt(i)==' ')
                equacaoQuadratica.deleteCharAt(i);
        }
        
        equacaoQuadraticaString = equacaoQuadratica.toString();
        
        double[] coeficientesExp;
        coeficientesExp = exponencial.MinimosQuadradosAjuste(x, y);
        String aExpFormatado = formatador.format(coeficientesExp[0]);
        String bExpFormatado = formatador.format(coeficientesExp[1]);
        equacaoExp.append(aExpFormatado).append("e^").append(bExpFormatado).append("x");
        equacaoExpStringExibir = equacaoExp.toString();
        equacaoExpExpressao.setText(equacaoExpStringExibir);
        plotarExp.setEnabled(true);
        
        double[] coeficientesPotencial;
        coeficientesPotencial = potencial.MinimosQuadradosAjuste(x, y);
        String aPotencialFormatado = formatador.format(coeficientesPotencial[0]);
        String bPotencialFormatado = formatador.format(coeficientesPotencial[1]);
        equacaoPotencial.append(aPotencialFormatado).append("x^").append(bPotencialFormatado);
        equacaoPotencialStringExibir = equacaoPotencial.toString();
        equacaoPotencialExpressao.setText(equacaoPotencialStringExibir);
        plotarPotencial.setEnabled(true);
        }
    }
    
    private int contadorPontos;
    private ArrayList<Double> x;
    private ArrayList<Double> y;
    private DefaultTableModel pontos;
    private StringBuilder equacaoLinear;
    private StringBuilder equacaoExp;
    private StringBuilder equacaoQuadratica;
    private StringBuilder equacaoPotencial;
    
    private double xValor;
    private double yValor;
    
    private String equacaoLinearString;
    private String equacaoQuadraticaString;
    
    private String auxiliarNumero;
    
    private String equacaoLinearStringExibir;
    private String equacaoExpStringExibir;
    private String equacaoPotencialStringExibir;
    private String equacaoQuadraticaStringExibir;
    
    private final Document numero1;
    private final Document numero2;
    
    public static int camposCheios = 0;
    
    private final String vazio;
    private final DecimalFormat formatador;
    private final CalculadoraAjusteQuadratico quadratico;
    private final CalculadoraAjusteExponencial exponencial;
    private final CalculadoraAjusteLinear linear;
    private final CalculadoraAjustePotencial potencial;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarPonto;
    private javax.swing.JButton ajustar;
    private javax.swing.JTextField equacaoExpExpressao;
    private javax.swing.JTextField equacaoLinearExpressao;
    private javax.swing.JTextField equacaoPotencialExpressao;
    private javax.swing.JTextField equacaoQuadraticaExpressao;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton limparTudo;
    private javax.swing.JButton plotarExp;
    private javax.swing.JButton plotarLinear;
    private javax.swing.JButton plotarPotencial;
    private javax.swing.JButton plotarQuadratica;
    private javax.swing.JButton removerPonto;
    private javax.swing.JTable tabelaElementos;
    private javax.swing.JTable tabelaPontos;
    private javax.swing.JButton voltar;
    private javax.swing.JTextField xPonto;
    private javax.swing.JTextField yPonto;
    // End of variables declaration//GEN-END:variables

}
