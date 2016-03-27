package GUI;

public class TelaInicial extends javax.swing.JFrame {

    public TelaInicial(int decimais){
        initComponents();
        this.decimais = decimais;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new java.awt.Label();
        aritmetica = new java.awt.Button();
        estatistica = new java.awt.Button();
        equacoes = new java.awt.Button();
        graficos = new java.awt.Button();
        ajuste = new java.awt.Button();
        conversaoNumeros = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Titi Calculator 2016");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(491, 331));
        setResizable(false);
        setSize(new java.awt.Dimension(491, 331));

        titulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titulo.setText("TITI CALCULATOR 2016");

        aritmetica.setLabel("Aritmética");
        aritmetica.setName("Aritmética"); // NOI18N
        aritmetica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aritmeticaMouseClicked(evt);
            }
        });

        estatistica.setLabel("Estatística");
        estatistica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estatisticaMouseClicked(evt);
            }
        });

        equacoes.setLabel("Equações");
        equacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equacoesMouseClicked(evt);
            }
        });

        graficos.setLabel("Gráficos");
        graficos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                graficosMouseClicked(evt);
            }
        });

        ajuste.setLabel("Ajuste de curvas");
        ajuste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajusteMouseClicked(evt);
            }
        });

        conversaoNumeros.setLabel("Conversão de unidades");
        conversaoNumeros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conversaoNumerosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ajuste, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aritmetica, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(equacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estatistica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(graficos, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(conversaoNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(estatistica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aritmetica, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(graficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(equacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ajuste, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(conversaoNumeros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aritmeticaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aritmeticaMouseClicked
        aritmeticaFrame = new Aritmetica(decimais);
        aritmeticaFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_aritmeticaMouseClicked

    private void estatisticaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estatisticaMouseClicked
        estatisticaFrame = new Estatistica(decimais);
        estatisticaFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_estatisticaMouseClicked

    private void equacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equacoesMouseClicked
        equacoesFrame = new Equacoes(decimais);
        equacoesFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_equacoesMouseClicked

    private void graficosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graficosMouseClicked
        graficosFrame = new Graficos(decimais);
        graficosFrame.setVisible(true);
        graficosFrame.criarGrafico();
        dispose();
    }//GEN-LAST:event_graficosMouseClicked

    private void ajusteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajusteMouseClicked
        ajustesFrame = new AjusteCurvas(decimais);
        ajustesFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_ajusteMouseClicked

    private void conversaoNumerosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conversaoNumerosMouseClicked
        conversaoUnidadesFrame = new ConversaoNumeros(decimais);
        conversaoUnidadesFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_conversaoNumerosMouseClicked

    private final int decimais;
    private Aritmetica aritmeticaFrame;
    private Equacoes equacoesFrame;
    private Estatistica estatisticaFrame;
    private Graficos graficosFrame;
    private AjusteCurvas ajustesFrame;
    private ConversaoNumeros conversaoUnidadesFrame;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button ajuste;
    private java.awt.Button aritmetica;
    private java.awt.Button conversaoNumeros;
    private java.awt.Button equacoes;
    private java.awt.Button estatistica;
    private java.awt.Button graficos;
    private java.awt.Label titulo;
    // End of variables declaration//GEN-END:variables
}
