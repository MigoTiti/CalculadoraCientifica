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
        Aritmetica = new java.awt.Button();
        Estatistica = new java.awt.Button();
        Equacoes = new java.awt.Button();
        Graficos = new java.awt.Button();
        ajuste = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Titi Calculator 2016");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(491, 331));
        setResizable(false);
        setSize(new java.awt.Dimension(491, 331));

        titulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titulo.setText("TITI CALCULATOR 2016");

        Aritmetica.setLabel("Aritmética");
        Aritmetica.setName("Aritmética"); // NOI18N
        Aritmetica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AritmeticaMouseClicked(evt);
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

        ajuste.setLabel("Ajuste de curvas");
        ajuste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajusteMouseClicked(evt);
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
                            .addComponent(Aritmetica, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Equacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Estatistica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Graficos, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(Estatistica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Aritmetica, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Graficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Equacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(ajuste, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AritmeticaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AritmeticaMouseClicked
        aritmetica = new Aritmetica(decimais);
        aritmetica.setVisible(true);
        dispose();
    }//GEN-LAST:event_AritmeticaMouseClicked

    private void EstatisticaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EstatisticaMouseClicked
        estatistica = new Estatistica(decimais);
        estatistica.setVisible(true);
        dispose();
    }//GEN-LAST:event_EstatisticaMouseClicked

    private void EquacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EquacoesMouseClicked
        equacoes = new Equacoes(decimais);
        equacoes.setVisible(true);
        dispose();
    }//GEN-LAST:event_EquacoesMouseClicked

    private void GraficosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GraficosMouseClicked
        graficos = new Graficos(decimais);
        graficos.setVisible(true);
        graficos.criarGrafico();
        dispose();
    }//GEN-LAST:event_GraficosMouseClicked

    private void ajusteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajusteMouseClicked
        ajustes = new AjusteCurvas(decimais);
        ajustes.setVisible(true);
        dispose();
    }//GEN-LAST:event_ajusteMouseClicked

    private final int decimais;
    private Aritmetica aritmetica;
    private Equacoes equacoes;
    private Estatistica estatistica;
    private Graficos graficos;
    private AjusteCurvas ajustes;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Aritmetica;
    private java.awt.Button Equacoes;
    private java.awt.Button Estatistica;
    private java.awt.Button Graficos;
    private java.awt.Button ajuste;
    private java.awt.Label titulo;
    // End of variables declaration//GEN-END:variables
}
