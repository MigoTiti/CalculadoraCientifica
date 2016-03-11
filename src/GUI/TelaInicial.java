package GUI;

public class TelaInicial extends javax.swing.JFrame {

    public TelaInicial()
    {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        Aritmetica = new java.awt.Button();
        Estatistica = new java.awt.Button();
        Equacoes = new java.awt.Button();
        Graficos = new java.awt.Button();
        matrizes = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(491, 331));
        setResizable(false);
        setSize(new java.awt.Dimension(491, 331));

        label1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        label1.setText("TITI CALCULATOR 2016");

        Aritmetica.setLabel("Aritmética");
        Aritmetica.setName("Aritmética"); // NOI18N
        Aritmetica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AritmeticaMouseClicked(evt);
            }
        });
        Aritmetica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AritmeticaActionPerformed(evt);
            }
        });

        Estatistica.setLabel("Estatística");
        Estatistica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EstatisticaMouseClicked(evt);
            }
        });

        Equacoes.setLabel("Equações");
        Equacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EquacoesMouseClicked(evt);
            }
        });

        Graficos.setLabel("Gráficos");
        Graficos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GraficosMouseClicked(evt);
            }
        });
        Graficos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraficosActionPerformed(evt);
            }
        });

        matrizes.setLabel("Matrizes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(matrizes, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Aritmetica, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Equacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Estatistica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Graficos, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Estatistica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Aritmetica, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Graficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Equacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(matrizes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 70, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AritmeticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AritmeticaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AritmeticaActionPerformed

    private void GraficosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraficosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GraficosActionPerformed

    private void AritmeticaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AritmeticaMouseClicked
        dispose();
        Aritmetica aritmetica = new Aritmetica();
        aritmetica.setVisible(true);
    }//GEN-LAST:event_AritmeticaMouseClicked

    private void EstatisticaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EstatisticaMouseClicked
        dispose();
        Estatistica estatistica = new Estatistica();
        estatistica.setVisible(true);
    }//GEN-LAST:event_EstatisticaMouseClicked

    private void EquacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EquacoesMouseClicked
        dispose();
        Equacoes equacoes = new Equacoes();
        equacoes.setVisible(true);
    }//GEN-LAST:event_EquacoesMouseClicked

    private void GraficosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GraficosMouseClicked
        dispose();
        Graficos graficos = new Graficos();
        graficos.setVisible(true);
        graficos.criarGrafico();
    }//GEN-LAST:event_GraficosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Aritmetica;
    private java.awt.Button Equacoes;
    private java.awt.Button Estatistica;
    private java.awt.Button Graficos;
    private java.awt.Label label1;
    private java.awt.Button matrizes;
    // End of variables declaration//GEN-END:variables
}
