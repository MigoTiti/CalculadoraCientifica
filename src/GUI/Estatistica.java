package GUI;

import calculadoracientifica.CalculadoraEstatistica;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class Estatistica extends javax.swing.JFrame {

    public Estatistica() {
        initComponents();
        adicionarValor.requestFocusInWindow();
        formato.setDecimalSeparatorAlwaysShown(false);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        voltar = new javax.swing.JButton();
        igual = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        label1 = new java.awt.Label();
        adicionarValor = new javax.swing.JTextField();
        adicionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        media = new javax.swing.JTextField();
        mediana = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaElementos = new javax.swing.JList<String>();
        removerElemento = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        coeficienteVariacao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        moda = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        variancia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        desvioPadrao = new javax.swing.JTextField();

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);

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

        label1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label1.setText("ELEMENTOS");

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

        listaElementos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaElementos.setToolTipText("");
        jScrollPane1.setViewportView(listaElementos);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(removerElemento, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(limpar))
                            .addComponent(igual, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adicionarValor)
                                    .addComponent(adicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(coeficienteVariacao, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(variancia, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(desvioPadrao, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(moda, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(mediana, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(media, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adicionarValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adicionar)
                        .addGap(6, 6, 6)
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
                        .addComponent(coeficienteVariacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(limpar))
                            .addComponent(removerElemento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(igual))
                    .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseClicked
        dispose();
        TelaInicial escolha = new TelaInicial();
        escolha.setVisible(true);
    }//GEN-LAST:event_voltarMouseClicked

    private void adicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adicionarMouseClicked
        double elemento = Double.parseDouble(adicionarValor.getText());
        String elementoFormatado = formato.format(elemento);
        operadores.add(elemento);
        elementos.addElement(elementoFormatado); 
        listaElementos.setModel(elementos);        
        adicionarValor.setText("");
        adicionarValor.requestFocusInWindow();
    }//GEN-LAST:event_adicionarMouseClicked

    private void igualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igualMouseClicked
        double mediaValor = estatistica.media(operadores);
        String mediaFormatada = formato.format(mediaValor);
        media.setText(mediaFormatada);
        
        double medianaValor = estatistica.mediana(operadores);
        String medianaFormatada = formato.format(medianaValor);
        mediana.setText(medianaFormatada);
        
        String modaValor = estatistica.moda(operadores);
        if("Não existe moda.".equals(modaValor))
            moda.setText(modaValor);
        else{
            double modaValorNumero = Double.parseDouble(modaValor);
            moda.setText(formato.format(modaValorNumero));
        }
        
        double varianciaValor = estatistica.variancia(operadores);
        String varianciaFormatada = formato.format(varianciaValor);
        variancia.setText(varianciaFormatada);
        
        double desvioPadraoValor = estatistica.desvioPadrao(operadores);
        String desvioPadraoFormatado = formato.format(desvioPadraoValor);
        desvioPadrao.setText(desvioPadraoFormatado);
        
        double coeficienteVariacaoValor = estatistica.coeficienteVariacao(operadores);
        String coeficienteVariacaoFormatado = formato.format(coeficienteVariacaoValor);
        coeficienteVariacaoFormatado.concat("%");
        coeficienteVariacao.setText(coeficienteVariacaoFormatado);
        
        operadores.clear();
    }//GEN-LAST:event_igualMouseClicked

    private void removerElementoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerElementoMouseClicked
        int index = listaElementos.getSelectedIndex();
        operadores.remove(index);        
        elementos.removeElement(listaElementos.getSelectedValue()); 
    }//GEN-LAST:event_removerElementoMouseClicked

    private void limparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparMouseClicked
        media.setText("");
        mediana.setText("");
        moda.setText("");
        variancia.setText("");
        desvioPadrao.setText("");
        coeficienteVariacao.setText("");
        elementos.removeAllElements();
        operadores.clear();
    }//GEN-LAST:event_limparMouseClicked
    
    private final DecimalFormat formato = new DecimalFormat();
    
    @SuppressWarnings("FieldMayBeFinal")
    private DefaultListModel elementos = new DefaultListModel();
    
    private final CalculadoraEstatistica estatistica = new CalculadoraEstatistica();
    
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<Double> operadores = new ArrayList<>();
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
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private javax.swing.JButton limpar;
    private javax.swing.JList<String> listaElementos;
    private javax.swing.JTextField media;
    private javax.swing.JTextField mediana;
    private javax.swing.JTextField moda;
    private javax.swing.JButton removerElemento;
    private javax.swing.JTextField variancia;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
