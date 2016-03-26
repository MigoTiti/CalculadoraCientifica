package testeGUI;

import calculadoracientifica.Aritmetica.CalculadoraAritmetica;
import calculadoracientifica.ConversaoNumeros.ConversorNumeros;
import calculadoracientifica.Enums.Unidades;
import calculadoracientifica.ModeloNumero.Unidades.NumeroArea;
import calculadoracientifica.ModeloNumero.Unidades.NumeroEnergia;
import calculadoracientifica.ModeloNumero.Unidades.NumeroMassa;
import calculadoracientifica.ModeloNumero.Unidades.NumeroMedida;
import calculadoracientifica.ModeloNumero.Unidades.NumeroTemperatura;
import calculadoracientifica.ModeloNumero.Unidades.NumeroTempo;
import calculadoracientifica.ModeloNumero.Unidades.NumeroVolume;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConversaoNumeros extends javax.swing.JFrame {

    public ConversaoNumeros(){
        initComponents();
        this.numeroFinalTexto.setEditable(false);
        this.descricaoFinalTexto.setEditable(false);
        this.descricaoInicialTexto.setEditable(false);
        caixaTiposInicial.setSelectedItem(null);
        caixaTiposInicial.addItemListener((ItemEvent e) -> {
            Unidades constSelecionada = (Unidades) caixaTiposInicial.getSelectedItem();
            descricaoInicialTexto.setText(constSelecionada.getDescricao());
            ArrayList<Unidades> unidadesCorrespondentes = new ArrayList<>();
            Unidades[] unidades = Unidades.values();
            
            for (Unidades unidade : unidades) {
                if((unidade.getTipo().equals(constSelecionada.getTipo()))&&!(unidade.getDescricao().equals(constSelecionada.getDescricao())))
                    unidadesCorrespondentes.add(unidade);
            }
            
            if(caixaTiposFinal.getSelectedItem()!=null){
                Unidades aux = (Unidades) caixaTiposFinal.getSelectedItem();
                if(!aux.getTipo().equals(constSelecionada.getTipo())){
                    caixaTiposFinal.setModel(new javax.swing.DefaultComboBoxModel(unidadesCorrespondentes.toArray()));
                    caixaTiposFinal.setSelectedItem(null);
                }else if(aux.getDescricao().equals(constSelecionada.getDescricao()))
                    caixaTiposFinal.setSelectedItem(null);
                    descricaoFinalTexto.setText("");
            }else{
                caixaTiposFinal.setModel(new javax.swing.DefaultComboBoxModel(unidadesCorrespondentes.toArray()));
                caixaTiposFinal.setSelectedItem(null);
            }
        });
        caixaTiposFinal.addItemListener((ItemEvent e) -> {
            
            if(caixaTiposFinal.getSelectedItem()!=null){
                Unidades constSelecionada = (Unidades) caixaTiposFinal.getSelectedItem();
                descricaoFinalTexto.setText(constSelecionada.getDescricao());
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        voltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        caixaTiposInicial = new javax.swing.JComboBox();
        descricaoInicialTexto = new javax.swing.JTextField();
        numeroInicialTexto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        caixaTiposFinal = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        descricaoFinalTexto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        numeroFinalTexto = new javax.swing.JTextField();
        resultadoBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        voltar.setText("VOLTAR");
        voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarMouseClicked(evt);
            }
        });

        jLabel1.setText("ESCOLHA O TIPO INICIAL");

        caixaTiposInicial.setModel(new javax.swing.DefaultComboBoxModel(Unidades.values()));

        jLabel2.setText("DESCRIÇÃO");

        jLabel3.setText("NÚMERO");

        jLabel4.setText("ESCOLHA O TIPO FINAL");

        caixaTiposFinal.setModel(new javax.swing.DefaultComboBoxModel());

        jLabel5.setText("DESCRIÇÃO");

        jLabel6.setText("NÚMERO");

        resultadoBotao.setText("CONVERTER");
        resultadoBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultadoBotaoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(voltar)
                    .addComponent(jLabel1)
                    .addComponent(caixaTiposInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(descricaoInicialTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(numeroInicialTexto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(caixaTiposFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(numeroFinalTexto)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(resultadoBotao))
                    .addComponent(descricaoFinalTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caixaTiposInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caixaTiposFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descricaoInicialTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descricaoFinalTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3)))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(numeroInicialTexto)
                    .addComponent(numeroFinalTexto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voltar)
                    .addComponent(resultadoBotao))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseClicked
        dispose();
    }//GEN-LAST:event_voltarMouseClicked

    private void resultadoBotaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultadoBotaoMouseClicked
        boolean sucesso = false;
        
        try{
            String valorInicialString;
            valorInicialString = numeroInicialTexto.getText();
            if(valorInicialString.contains(","))
                valorInicialString = valorInicialString.replaceAll("\\,", ".");
            Double.parseDouble(valorInicialString);
            sucesso = true;
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Apenas números!");
        }
        
        if(sucesso){
            ConversorNumeros conversor = new ConversorNumeros();
            Unidades aux = (Unidades) caixaTiposInicial.getSelectedItem();
            Unidades aux2 = (Unidades) caixaTiposFinal.getSelectedItem();
            String simboloFinal = aux2.toString();
            Object numeroInicial = new Object();
            
            switch(aux.getTipo()){
                case "Área":
                    numeroInicial = new NumeroArea(Double.parseDouble(numeroInicialTexto.getText()),aux.toString());
                    break;
                case "Energia":
                    numeroInicial = new NumeroEnergia(Double.parseDouble(numeroInicialTexto.getText()),aux.toString());
                    break;
                case "Massa":
                    numeroInicial = new NumeroMassa(Double.parseDouble(numeroInicialTexto.getText()),aux.toString());
                    break;
                case "Medida":
                    numeroInicial = new NumeroMedida(Double.parseDouble(numeroInicialTexto.getText()),aux.toString());
                    break;
                case "Temperatura":
                    numeroInicial = new NumeroTemperatura(Double.parseDouble(numeroInicialTexto.getText()),aux.toString());
                    break;
                case "Tempo":
                    numeroInicial = new NumeroTempo(Double.parseDouble(numeroInicialTexto.getText()),aux.toString());
                    break;
                case "Volume":
                    numeroInicial = new NumeroVolume(Double.parseDouble(numeroInicialTexto.getText()),aux.toString());
                    break;
            }

            Object numeroFinal = conversor.converterNumero(new CalculadoraAritmetica(), numeroInicial, aux2.toString());
        }
    }//GEN-LAST:event_resultadoBotaoMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConversaoNumeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new ConversaoNumeros().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox caixaTiposFinal;
    private javax.swing.JComboBox caixaTiposInicial;
    private javax.swing.JTextField descricaoFinalTexto;
    private javax.swing.JTextField descricaoInicialTexto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField numeroFinalTexto;
    private javax.swing.JTextField numeroInicialTexto;
    private javax.swing.JButton resultadoBotao;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
