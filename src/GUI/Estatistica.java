package GUI;

import calculadoracientifica.Estatistica.CalculadoraEstatistica;
import calculadoracientifica.Interfaces.OperacoesPrimitivas;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Estatistica extends javax.swing.JFrame implements OperacoesPrimitivas{

    public Estatistica() {
        initComponents();
        this.adicionarValor.requestFocusInWindow();
        
        this.formatador = new DecimalFormat();
        this.formatador.setDecimalSeparatorAlwaysShown(false);
        
        this.elementos = new DefaultTableModel();
        this.elementos.addColumn("Elemento");
        this.tabelaElementos.setModel(elementos);
        
        this.operadores = new ArrayList<>();
        this.vazio = "";
        this.desvioCriado = false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        voltar = new javax.swing.JButton();
        igual = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        adicionarValor = new javax.swing.JTextField();
        adicionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        media = new javax.swing.JTextField();
        mediana = new javax.swing.JTextField();
        removerElemento = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        coeficienteVariacao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        moda = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        variancia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        desvioPadrao = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaElementos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setResizable(false);

        voltar.setText("VOLTAR");
        voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarMouseClicked(evt);
            }
        });

        igual.setText("=");
        igual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                igualMouseClicked(evt);
            }
        });

        limpar.setText("LIMPAR");
        limpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparMouseClicked(evt);
            }
        });

        adicionar.setText("ADICIONAR");
        adicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adicionarMouseClicked(evt);
            }
        });

        jLabel1.setText("MÉDIA");

        jLabel2.setText("MEDIANA");

        media.setEditable(false);
        media.setFocusable(false);

        mediana.setEditable(false);
        mediana.setFocusable(false);

        removerElemento.setText("REMOVER");
        removerElemento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removerElementoMouseClicked(evt);
            }
        });

        jLabel3.setText("DESVIO PADRÃO");

        coeficienteVariacao.setEditable(false);

        jLabel4.setText("MODA");

        moda.setEditable(false);

        jLabel5.setText("VARIÂNCIA");

        variancia.setEditable(false);

        jLabel6.setText("COEFICIENTE DE VARIAÇÃO");

        desvioPadrao.setEditable(false);

        tabelaElementos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaElementos.setColumnSelectionAllowed(true);
        tabelaElementos.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tabelaElementos);
        tabelaElementos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel7.setText("ELEMENTO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(voltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removerElemento))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(limpar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(igual, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(adicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(coeficienteVariacao)
                            .addComponent(variancia)
                            .addComponent(desvioPadrao)
                            .addComponent(moda)
                            .addComponent(mediana)
                            .addComponent(adicionarValor)
                            .addComponent(media))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(voltar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(removerElemento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adicionarValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adicionar)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(media, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(mediana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(moda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desvioPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(variancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coeficienteVariacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(igual)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseClicked
        voltar();
    }//GEN-LAST:event_voltarMouseClicked

    private void adicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adicionarMouseClicked
        double elemento = Double.parseDouble(adicionarValor.getText());
        String elementoFormatado = formatador.format(elemento);
        operadores.add(elemento);
        elementos.addRow(new Object[]{elementoFormatado});        
        adicionarValor.setText(vazio);
        adicionarValor.requestFocusInWindow();
    }//GEN-LAST:event_adicionarMouseClicked

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void igualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igualMouseClicked
        obterResposta();
    }//GEN-LAST:event_igualMouseClicked

    private void removerElementoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerElementoMouseClicked
        int index = tabelaElementos.getSelectedRow();
        operadores.remove(index);        
        elementos.removeRow(index); 
    }//GEN-LAST:event_removerElementoMouseClicked

    private void limparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparMouseClicked
        limpar();
    }//GEN-LAST:event_limparMouseClicked
    
    @Override
    public void limpar() {
        media.setText(vazio);
        mediana.setText(vazio);
        moda.setText(vazio);
        variancia.setText(vazio);
        desvioPadrao.setText(vazio);
        coeficienteVariacao.setText(vazio);
        
        int colunas = elementos.getRowCount();
        for(int i=colunas-1;i>=0;i--)
            elementos.removeRow(i);
       
        operadores.clear();
    }

    @Override
    public void voltar() {
        dispose();
        TelaInicial escolha = new TelaInicial();
        escolha.setVisible(true); 
    }

    @Override
    public void obterResposta() {
        if(desvioCriado==false){
        elementos.addColumn("Desvio");
        desvioCriado = true;
        }
        
        double mediaValor = CalculadoraEstatistica.media(operadores);
        String mediaFormatada = formatador.format(mediaValor);
        media.setText(mediaFormatada);
        
        double medianaValor = CalculadoraEstatistica.mediana(operadores);
        String medianaFormatada = formatador.format(medianaValor);
        mediana.setText(medianaFormatada);
        
        String modaValor = CalculadoraEstatistica.moda(operadores);
        if("Não existe moda.".equals(modaValor))
            moda.setText(modaValor);
        else{
            double modaValorNumero = Double.parseDouble(modaValor);
            moda.setText(formatador.format(modaValorNumero));
        }
        
        double varianciaValor = CalculadoraEstatistica.variancia(operadores);
        String varianciaFormatada = formatador.format(varianciaValor);
        variancia.setText(varianciaFormatada);
        
        double desvioPadraoValor = CalculadoraEstatistica.desvioPadrao(operadores);
        String desvioPadraoFormatado = formatador.format(desvioPadraoValor);
        desvioPadrao.setText(desvioPadraoFormatado);
        
        double coeficienteVariacaoValor = CalculadoraEstatistica.coeficienteVariacao(operadores);
        String coeficienteVariacaoFormatado = formatador.format(coeficienteVariacaoValor);
        coeficienteVariacaoFormatado+="%";
        coeficienteVariacao.setText(coeficienteVariacaoFormatado);
        
        ArrayList<Double> desvios = CalculadoraEstatistica.desvios(operadores);
        int colunas = elementos.getRowCount();
        for(int i=colunas-1;i>=0;i--)
            elementos.removeRow(i);
        
        for(int i=0;i<operadores.size();i++){
            double elemento = operadores.get(i);
            String elementoFormatado = formatador.format(elemento);
            
            double desvio = desvios.get(i);
            String desvioFormatado = formatador.format(desvio);
            elementos.addRow(new Object[]{elementoFormatado, desvioFormatado});
        }
        
    }
    
    
    private DefaultTableModel elementos;
    private boolean desvioCriado;
    private ArrayList<Double> operadores;
    
    private final DecimalFormat formatador;
    private final String vazio;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JTextField adicionarValor;
    private javax.swing.JTextField coeficienteVariacao;
    private javax.swing.JTextField desvioPadrao;
    private javax.swing.JButton igual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton limpar;
    private javax.swing.JTextField media;
    private javax.swing.JTextField mediana;
    private javax.swing.JTextField moda;
    private javax.swing.JButton removerElemento;
    private javax.swing.JTable tabelaElementos;
    private javax.swing.JTextField variancia;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
