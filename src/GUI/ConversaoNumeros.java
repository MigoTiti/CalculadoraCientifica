package GUI;

import calculadoracientifica.Aritmetica.CalculadoraAritmetica;
import calculadoracientifica.ConversaoNumeros.ConversorNumeros;
import calculadoracientifica.Enums.Unidades;
import calculadoracientifica.ModeloNumero.NumeroPrimitivo;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class ConversaoNumeros extends javax.swing.JFrame {

    public ConversaoNumeros(int decimais) {
        initComponents();
        this.numeroFinalTexto.setEditable(false);
        this.descricaoFinalTexto.setEditable(false);
        this.descricaoInicialTexto.setEditable(false);
        this.tipoInicial = "";
        caixaEscolha.setSelectedItem(null);

        caixaEscolha.addItemListener((ItemEvent e) -> {

            if (!tipoInicial.equals(caixaEscolha.getSelectedItem())) {
                String secaoSelecionada = (String) caixaEscolha.getSelectedItem();
                ArrayList<Unidades> unidadesCorrespondentes = new ArrayList<>();
                Unidades[] unidades = Unidades.values();

                for (Unidades unidade : unidades) {
                    if ((unidade.getTipo().equals(secaoSelecionada))) {
                        unidadesCorrespondentes.add(unidade);
                    }
                }

                caixaTiposInicial.setModel(new javax.swing.DefaultComboBoxModel(unidadesCorrespondentes.toArray()));
                caixaTiposInicial.setSelectedItem(null);
                caixaTiposFinal.setSelectedItem(null);
                descricaoInicialTexto.setText("");
                descricaoFinalTexto.setText("");
                numeroFinalTexto.setText("");
                tipoInicial = (String) caixaEscolha.getSelectedItem();
            }
        });

        caixaTiposInicial.setSelectedItem(null);

        caixaTiposInicial.addItemListener((ItemEvent e) -> {
            Unidades constSelecionada = (Unidades) caixaTiposInicial.getSelectedItem();
            if (constSelecionada != null) {
                descricaoInicialTexto.setText(constSelecionada.getDescricao());
                ArrayList<Unidades> unidadesCorrespondentes = new ArrayList<>();
                Unidades[] unidades = Unidades.values();

                for (Unidades unidade : unidades) {
                    if (unidade.getTipo().equals(constSelecionada.getTipo())) {
                        unidadesCorrespondentes.add(unidade);
                    }
                }

                Unidades aux = (Unidades) caixaTiposFinal.getSelectedItem();
                caixaTiposFinal.setModel(new javax.swing.DefaultComboBoxModel(unidadesCorrespondentes.toArray()));

                if (caixaTiposFinal.getSelectedItem() != null) {
                    caixaTiposFinal.setSelectedItem(aux);
                } else {
                    caixaTiposFinal.setSelectedItem(null);
                }

            }
        });

        caixaTiposFinal.addItemListener((ItemEvent e) -> {

            if (caixaTiposFinal.getSelectedItem() != null) {
                Unidades constSelecionada = (Unidades) caixaTiposFinal.getSelectedItem();
                descricaoFinalTexto.setText(constSelecionada.getDescricao());
                numeroFinalTexto.setText("");
            }
        });

        this.decimais = decimais;
        this.numero = numeroInicialTexto.getDocument();
        this.numero.addDocumentListener(new ControladorBotao());

        this.descricao1 = descricaoInicialTexto.getDocument();
        this.descricao1.addDocumentListener(new ControladorBotao());

        this.descricao2 = descricaoFinalTexto.getDocument();
        this.descricao2.addDocumentListener(new ControladorBotao());

        this.resultadoBotao.setEnabled(false);
    }

    class ControladorBotao implements DocumentListener {

        ControladorBotao() {
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
            if (e.getDocument().getLength() == 0) {
                ConversaoNumeros.camposCheios--;
                if (ConversaoNumeros.camposCheios < 3 && resultadoBotao.isEnabled()) {
                    resultadoBotao.setEnabled(false);
                }
                if (!estadoPassadoVazio) {
                    estadoPassadoVazio = true;
                }
            } else if (e.getDocument().getLength() > 0) {
                if (estadoPassadoVazio) {
                    ConversaoNumeros.camposCheios++;
                    estadoPassadoVazio = false;
                }
                if (ConversaoNumeros.camposCheios == 3 && !resultadoBotao.isEnabled() && !"".equals(numeroInicialTexto.getText())) {
                    resultadoBotao.setEnabled(true);
                }
            }
        }
        private boolean estadoPassadoVazio;
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
        jLabel7 = new javax.swing.JLabel();
        caixaEscolha = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        voltar.setText("VOLTAR");
        voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarMouseClicked(evt);
            }
        });

        jLabel1.setText("ESCOLHA O TIPO INICIAL");

        caixaTiposInicial.setModel(new javax.swing.DefaultComboBoxModel());

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

        jLabel7.setText("ESCOLHA A CATEGORIA");

        caixaEscolha.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Área", "Energia", "Massa", "Medida", "Temperatura", "Tempo", "Volume"}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(voltar)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(descricaoInicialTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(numeroInicialTexto)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(caixaTiposInicial, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(numeroFinalTexto)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(resultadoBotao))
                            .addComponent(descricaoFinalTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(caixaTiposFinal, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(caixaEscolha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caixaEscolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(numeroFinalTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        TelaInicial escolha = new TelaInicial(decimais);
        escolha.setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarMouseClicked

    private void resultadoBotaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultadoBotaoMouseClicked
        boolean sucesso = false;
        double valorInicial = 0;
        if (resultadoBotao.isEnabled()) {
            try {
                String valorInicialString;
                valorInicialString = numeroInicialTexto.getText();
                if (valorInicialString.contains(",")) {
                    valorInicialString = valorInicialString.replaceAll("\\,", ".");
                }
                valorInicial = Double.parseDouble(valorInicialString);
                sucesso = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Apenas números!");
            }

            if (sucesso) {
                Unidades aux = (Unidades) caixaTiposInicial.getSelectedItem();
                Unidades aux2 = (Unidades) caixaTiposFinal.getSelectedItem();
                ConversorNumeros conversor = new ConversorNumeros(aux2.toString());
                NumeroPrimitivo numeroInicial;

                switch (aux.getTipo()) {
                    case "Área":
                        numeroInicial = new NumeroArea(valorInicial, aux.toString());
                        break;
                    case "Energia":
                        numeroInicial = new NumeroEnergia(valorInicial, aux.toString());
                        break;
                    case "Massa":
                        numeroInicial = new NumeroMassa(valorInicial, aux.toString());
                        break;
                    case "Medida":
                        numeroInicial = new NumeroMedida(valorInicial, aux.toString());
                        break;
                    case "Temperatura":
                        numeroInicial = new NumeroTemperatura(valorInicial, aux.toString());
                        break;
                    case "Tempo":
                        numeroInicial = new NumeroTempo(valorInicial, aux.toString());
                        break;
                    default:
                        numeroInicial = new NumeroVolume(valorInicial, aux.toString());
                        break;
                }

                NumeroPrimitivo numeroFinal = conversor.converterNumero(new CalculadoraAritmetica(), numeroInicial);
                double numeroFinalValor = 0.0;
                String numeroFinalTextoLer;

                if (numeroFinal instanceof NumeroArea) {
                    NumeroArea auxNumero = (NumeroArea) numeroFinal;
                    numeroFinalValor = auxNumero.getNumero();
                } else if (numeroFinal instanceof NumeroEnergia) {
                    NumeroEnergia auxNumero = (NumeroEnergia) numeroFinal;
                    numeroFinalValor = auxNumero.getNumero();
                } else if (numeroFinal instanceof NumeroMassa) {
                    NumeroMassa auxNumero = (NumeroMassa) numeroFinal;
                    numeroFinalValor = auxNumero.getNumero();
                } else if (numeroFinal instanceof NumeroMedida) {
                    NumeroMedida auxNumero = (NumeroMedida) numeroFinal;
                    numeroFinalValor = auxNumero.getNumero();
                } else if (numeroFinal instanceof NumeroTemperatura) {
                    NumeroTemperatura auxNumero = (NumeroTemperatura) numeroFinal;
                    numeroFinalValor = auxNumero.getNumero();
                } else if (numeroFinal instanceof NumeroTempo) {
                    NumeroTempo auxNumero = (NumeroTempo) numeroFinal;
                    numeroFinalValor = auxNumero.getNumero();
                } else if (numeroFinal instanceof NumeroVolume) {
                    NumeroVolume auxNumero = (NumeroVolume) numeroFinal;
                    numeroFinalValor = auxNumero.getNumero();
                }

                numeroFinalTextoLer = Double.toString(numeroFinalValor);
                if (numeroFinalTextoLer.contains(".")) {
                    numeroFinalTextoLer = numeroFinalTextoLer.replaceAll("\\.", ",");
                }

                numeroFinalTexto.setText(numeroFinalTextoLer);
            }
        }
    }//GEN-LAST:event_resultadoBotaoMouseClicked

    private String tipoInicial;
    private final Document numero;
    private final Document descricao1;
    private final Document descricao2;
    public static int camposCheios = 0;
    private final int decimais;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox caixaEscolha;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField numeroFinalTexto;
    private javax.swing.JTextField numeroInicialTexto;
    private javax.swing.JButton resultadoBotao;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
