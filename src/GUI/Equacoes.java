package GUI;

import calculadoracientifica.AjusteCurvas.CalculadoraAjusteLinear;
import calculadoracientifica.Equacoes.CalculadoraEquacoes;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class Equacoes extends javax.swing.JFrame {

    public Equacoes(int decimais) {
        initComponents();

        this.x1SDV.requestFocusInWindow();

        this.decimais = decimais;
        String aux = "#.";
        for (int i = 1; i <= decimais; i++) {
            aux += "#";
        }

        this.formatador = new DecimalFormat(aux);
        this.formatador.setDecimalSeparatorAlwaysShown(false);

        this.resultadoESG.setEnabled(false);
        this.resultadoSDV.setEnabled(false);
        this.resultadoSTV.setEnabled(false);

        this.limparSTV.setEnabled(false);
        this.limparESG.setEnabled(false);
        this.limparSDV.setEnabled(false);

        this.numero1SDV = x1SDV.getDocument();
        this.numero2SDV = x2SDV.getDocument();
        this.numero3SDV = y1SDV.getDocument();
        this.numero4SDV = y2SDV.getDocument();
        this.numero5SDV = resultado1SDV.getDocument();
        this.numero6SDV = resultado2SDV.getDocument();

        this.numero1SDV.addDocumentListener(new ControladorBotaoSDV(limparSDV, resultadoSDV));
        this.numero2SDV.addDocumentListener(new ControladorBotaoSDV(limparSDV, resultadoSDV));
        this.numero3SDV.addDocumentListener(new ControladorBotaoSDV(limparSDV, resultadoSDV));
        this.numero4SDV.addDocumentListener(new ControladorBotaoSDV(limparSDV, resultadoSDV));
        this.numero5SDV.addDocumentListener(new ControladorBotaoSDV(limparSDV, resultadoSDV));
        this.numero6SDV.addDocumentListener(new ControladorBotaoSDV(limparSDV, resultadoSDV));

        this.numero1STV = x1STV.getDocument();
        this.numero2STV = x2STV.getDocument();
        this.numero3STV = x3STV.getDocument();
        this.numero4STV = y1STV.getDocument();
        this.numero5STV = y2STV.getDocument();
        this.numero6STV = y3STV.getDocument();
        this.numero7STV = z1STV.getDocument();
        this.numero8STV = z2STV.getDocument();
        this.numero9STV = z3STV.getDocument();
        this.numero10STV = resultado1STV.getDocument();
        this.numero11STV = resultado2STV.getDocument();
        this.numero12STV = resultado3STV.getDocument();

        this.numero1STV.addDocumentListener(new ControladorBotaoSTV(limparSTV, resultadoSTV));
        this.numero2STV.addDocumentListener(new ControladorBotaoSTV(limparSTV, resultadoSTV));
        this.numero3STV.addDocumentListener(new ControladorBotaoSTV(limparSTV, resultadoSTV));
        this.numero4STV.addDocumentListener(new ControladorBotaoSTV(limparSTV, resultadoSTV));
        this.numero5STV.addDocumentListener(new ControladorBotaoSTV(limparSTV, resultadoSTV));
        this.numero6STV.addDocumentListener(new ControladorBotaoSTV(limparSTV, resultadoSTV));
        this.numero7STV.addDocumentListener(new ControladorBotaoSTV(limparSTV, resultadoSTV));
        this.numero8STV.addDocumentListener(new ControladorBotaoSTV(limparSTV, resultadoSTV));
        this.numero9STV.addDocumentListener(new ControladorBotaoSTV(limparSTV, resultadoSTV));
        this.numero10STV.addDocumentListener(new ControladorBotaoSTV(limparSTV, resultadoSTV));
        this.numero11STV.addDocumentListener(new ControladorBotaoSTV(limparSTV, resultadoSTV));
        this.numero12STV.addDocumentListener(new ControladorBotaoSTV(limparSTV, resultadoSTV));

        this.numero1ESG = aTexto.getDocument();
        this.numero2ESG = bTexto.getDocument();
        this.numero3ESG = cTexto.getDocument();

        this.numero1ESG.addDocumentListener(new ControladorBotaoESG(limparESG, resultadoESG));
        this.numero2ESG.addDocumentListener(new ControladorBotaoESG(limparESG, resultadoESG));
        this.numero3ESG.addDocumentListener(new ControladorBotaoESG(limparESG, resultadoESG));
    }

    class ControladorBotaoSDV implements DocumentListener {

        JButton limparBotao;
        JButton resultadoBotao;

        ControladorBotaoSDV(JButton button, JButton button2) {
            this.limparBotao = button;
            this.resultadoBotao = button2;
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
                Equacoes.camposCheiosSDV--;
                if (Equacoes.camposCheiosSDV == 0 && limparBotao.isEnabled()) {
                    limparBotao.setEnabled(false);
                }
                if (Equacoes.camposCheiosSDV < 6 && resultadoBotao.isEnabled()) {
                    resultadoBotao.setEnabled(false);
                }
                if (!estadoPassadoVazio) {
                    estadoPassadoVazio = true;
                }
            } else if (e.getDocument().getLength() > 0) {
                if (estadoPassadoVazio) {
                    Equacoes.camposCheiosSDV++;
                    estadoPassadoVazio = false;
                }
                if (Equacoes.camposCheiosSDV > 0 && !limparBotao.isEnabled()) {
                    limparBotao.setEnabled(true);
                }
                if (Equacoes.camposCheiosSDV == 6 && !resultadoBotao.isEnabled()) {
                    resultadoBotao.setEnabled(true);
                }
            }
        }
        private boolean estadoPassadoVazio;
    }

    class ControladorBotaoSTV implements DocumentListener {

        JButton limparBotao;
        JButton resultadoBotao;

        ControladorBotaoSTV(JButton button, JButton button2) {
            this.limparBotao = button;
            this.resultadoBotao = button2;
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
                Equacoes.camposCheiosSTV--;
                if (Equacoes.camposCheiosSTV == 0 && limparBotao.isEnabled()) {
                    limparBotao.setEnabled(false);
                }
                if (Equacoes.camposCheiosSTV < 12 && resultadoBotao.isEnabled()) {
                    resultadoBotao.setEnabled(false);
                }
                if (!estadoPassadoVazio) {
                    estadoPassadoVazio = true;
                }
            } else if (e.getDocument().getLength() > 0) {
                if (estadoPassadoVazio) {
                    Equacoes.camposCheiosSTV++;
                    estadoPassadoVazio = false;
                }
                if (Equacoes.camposCheiosSTV > 0 && !limparBotao.isEnabled()) {
                    limparBotao.setEnabled(true);
                }
                if (Equacoes.camposCheiosSTV == 12 && !resultadoBotao.isEnabled()) {
                    resultadoBotao.setEnabled(true);
                }
            }
        }
        private boolean estadoPassadoVazio;
    }

    class ControladorBotaoESG implements DocumentListener {

        JButton limparBotao;
        JButton resultadoBotao;

        ControladorBotaoESG(JButton button, JButton button2) {
            this.limparBotao = button;
            this.resultadoBotao = button2;
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
                Equacoes.camposCheiosESG--;
                if (Equacoes.camposCheiosESG == 0 && limparBotao.isEnabled()) {
                    limparBotao.setEnabled(false);
                }
                if (Equacoes.camposCheiosESG < 3 && resultadoBotao.isEnabled()) {
                    resultadoBotao.setEnabled(false);
                }
                if (!estadoPassadoVazio) {
                    estadoPassadoVazio = true;
                }
            } else if (e.getDocument().getLength() > 0) {
                if (estadoPassadoVazio) {
                    Equacoes.camposCheiosESG++;
                    estadoPassadoVazio = false;
                }
                if (Equacoes.camposCheiosESG > 0 && !limparBotao.isEnabled()) {
                    limparBotao.setEnabled(true);
                }
                if (Equacoes.camposCheiosESG == 3 && !resultadoBotao.isEnabled()) {
                    resultadoBotao.setEnabled(true);
                }
            }
        }
        private boolean estadoPassadoVazio;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        painelEquacoes = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        limparSDV = new javax.swing.JButton();
        resultadoSDV = new javax.swing.JButton();
        voltarSDV = new javax.swing.JButton();
        x1SDV = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        y1SDV = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        y2SDV = new javax.swing.JTextField();
        x2SDV = new javax.swing.JTextField();
        resultado1SDV = new javax.swing.JTextField();
        resultado2SDV = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        xFinalSDV = new javax.swing.JTextField();
        yFinalSDV = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        x1STV = new javax.swing.JTextField();
        x2STV = new javax.swing.JTextField();
        x3STV = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        y1STV = new javax.swing.JTextField();
        y2STV = new javax.swing.JTextField();
        y3STV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        z1STV = new javax.swing.JTextField();
        z2STV = new javax.swing.JTextField();
        z3STV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        resultado1STV = new javax.swing.JTextField();
        resultado2STV = new javax.swing.JTextField();
        resultado3STV = new javax.swing.JTextField();
        voltarSTV = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        xFinalSTV = new javax.swing.JTextField();
        yFinalSTV = new javax.swing.JTextField();
        zFinalSTV = new javax.swing.JTextField();
        resultadoSTV = new javax.swing.JButton();
        limparSTV = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        aTexto = new javax.swing.JTextField();
        cTexto = new javax.swing.JTextField();
        bTexto = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        a = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        b = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        c = new javax.swing.JTextField();
        voltarESG = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        delta = new javax.swing.JTextField();
        raiz1 = new javax.swing.JTextField();
        raiz2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        limparESG = new javax.swing.JButton();
        resultadoESG = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField7.setText("jTextField7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Equações");
        setResizable(false);

        limparSDV.setText("LIMPAR");
        limparSDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparSDVMouseClicked(evt);
            }
        });

        resultadoSDV.setText("=");
        resultadoSDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultadoSDVMouseClicked(evt);
            }
        });

        voltarSDV.setText("VOLTAR");
        voltarSDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarSDVMouseClicked(evt);
            }
        });

        jLabel25.setText("x");

        jLabel26.setText("y");

        jLabel27.setText("y");

        jLabel28.setText("x");

        jLabel29.setText("=");

        jLabel30.setText("=");

        jLabel31.setText("x= ");

        xFinalSDV.setEditable(false);

        yFinalSDV.setEditable(false);

        jLabel32.setText("y= ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(y2SDV, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(x1SDV, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(x2SDV, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(y1SDV, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel30))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(resultado2SDV, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                    .addComponent(resultado1SDV)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel31)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(xFinalSDV))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel32)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(yFinalSDV, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 175, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(voltarSDV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resultadoSDV))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(limparSDV)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(x1SDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(y1SDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(x2SDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(y2SDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(resultado1SDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(resultado2SDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(xFinalSDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(yFinalSDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(limparSDV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultadoSDV)
                    .addComponent(voltarSDV))
                .addContainerGap())
        );

        painelEquacoes.addTab("SISTEMA DE DUAS VARIÁVEIS", jPanel1);

        jLabel1.setText("x");

        jLabel2.setText("x");

        jLabel3.setText("x");

        jLabel4.setText("y");

        jLabel5.setText("y");

        jLabel6.setText("y");

        jLabel7.setText("z");

        jLabel8.setText("z");

        jLabel9.setText("z");

        jLabel10.setText("=");

        jLabel11.setText("=");

        jLabel12.setText("=");

        voltarSTV.setText("VOLTAR");
        voltarSTV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarSTVMouseClicked(evt);
            }
        });

        jLabel13.setText("x= ");

        jLabel14.setText("y= ");

        jLabel15.setText("z= ");

        xFinalSTV.setEditable(false);

        yFinalSTV.setEditable(false);

        zFinalSTV.setEditable(false);

        resultadoSTV.setText("=");
        resultadoSTV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultadoSTVMouseClicked(evt);
            }
        });

        limparSTV.setText("LIMPAR");
        limparSTV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparSTVMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(x3STV, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(y3STV))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(y2STV, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(x1STV, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                    .addComponent(x2STV))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(y1STV)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(z3STV, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(z2STV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(z1STV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(resultado3STV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(resultado2STV, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(resultado1STV, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(107, 107, 107))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(voltarSTV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resultadoSTV)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yFinalSTV, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zFinalSTV, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xFinalSTV)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(limparSTV)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(x1STV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(y1STV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(z1STV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(resultado1STV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(x2STV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(y2STV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(z2STV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(resultado2STV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(x3STV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(y3STV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(z3STV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(resultado3STV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(xFinalSTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(yFinalSTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(zFinalSTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(limparSTV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voltarSTV)
                    .addComponent(resultadoSTV))
                .addContainerGap())
        );

        painelEquacoes.addTab("SISTEMA DE TRÊS VARIÁVEIS", jPanel3);

        jLabel16.setText("x²");

        jLabel17.setText("x");

        jLabel18.setText("= 0");

        jLabel19.setText("a");

        a.setEditable(false);

        jLabel20.setText("b");

        b.setEditable(false);

        jLabel21.setText("c");

        c.setEditable(false);

        voltarESG.setText("VOLTAR");
        voltarESG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarESGMouseClicked(evt);
            }
        });

        jLabel22.setText("Delta");

        delta.setEditable(false);

        raiz1.setEditable(false);

        raiz2.setEditable(false);

        jLabel23.setText("Raiz 1");

        jLabel24.setText("Raiz 2");

        limparESG.setText("LIMPAR");
        limparESG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparESGMouseClicked(evt);
            }
        });

        resultadoESG.setText("=");
        resultadoESG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultadoESGMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(limparESG))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(aTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)
                                    .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel22)
                                        .addComponent(jLabel23)
                                        .addComponent(delta)
                                        .addComponent(raiz1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel24)
                                    .addComponent(raiz2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 138, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(voltarESG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resultadoESG)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(aTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(raiz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(raiz2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(limparESG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultadoESG)
                    .addComponent(voltarESG))
                .addContainerGap())
        );

        painelEquacoes.addTab("EQUAÇÃO DE SEGUNDO GRAU", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelEquacoes)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelEquacoes, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void voltarSTVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarSTVMouseClicked
        dispose();
        TelaInicial escolha = new TelaInicial(decimais);
        escolha.setVisible(true);
    }//GEN-LAST:event_voltarSTVMouseClicked

    private void resultadoSTVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultadoSTVMouseClicked
        if (resultadoSTV.isEnabled()) {
            double[] resultadosParciais = new double[3];
            double[][] coeficientes = new double[3][3];
            boolean sucesso;
            try {
                auxiliarNumero = x1STV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                coeficientes[0][0] = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = x2STV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                coeficientes[1][0] = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = x3STV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                coeficientes[2][0] = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = y1STV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                coeficientes[0][1] = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = y2STV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                coeficientes[1][1] = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = y3STV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                coeficientes[2][1] = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = z1STV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                coeficientes[0][2] = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = z2STV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                coeficientes[1][2] = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = z3STV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                coeficientes[2][2] = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = resultado1STV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                resultadosParciais[0] = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = resultado2STV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                resultadosParciais[1] = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = resultado3STV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                resultadosParciais[2] = Double.parseDouble(auxiliarNumero);

                sucesso = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Apenas números!");
                sucesso = false;
            }

            if (sucesso) {
                CalculadoraAjusteLinear sistemas = new CalculadoraAjusteLinear();
                double[] resultados = sistemas.escalonarMatriz(coeficientes, resultadosParciais);

                String xFormatado = formatador.format(resultados[0]);
                xFinalSTV.setText(xFormatado);

                String yFormatado = formatador.format(resultados[1]);
                yFinalSTV.setText(yFormatado);

                String zFormatado = formatador.format(resultados[2]);
                zFinalSTV.setText(zFormatado);
            }
        }
    }//GEN-LAST:event_resultadoSTVMouseClicked

    private void limparSTVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparSTVMouseClicked
        if (limparSTV.isEnabled()) {
            xFinalSTV.setText("");
            yFinalSTV.setText("");
            zFinalSTV.setText("");
            x1STV.setText("");
            x2STV.setText("");
            x3STV.setText("");
            y1STV.setText("");
            y2STV.setText("");
            y3STV.setText("");
            z1STV.setText("");
            z2STV.setText("");
            z3STV.setText("");
            resultado1STV.setText("");
            resultado2STV.setText("");
            resultado3STV.setText("");
        }
    }//GEN-LAST:event_limparSTVMouseClicked

    private void limparESGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparESGMouseClicked
        if (limparESG.isEnabled()) {
            a.setText("");
            b.setText("");
            c.setText("");
            delta.setText("");
            raiz1.setText("");
            raiz2.setText("");
            aTexto.setText("");
            bTexto.setText("");
            cTexto.setText("");
            aTexto.requestFocusInWindow();
        }
    }//GEN-LAST:event_limparESGMouseClicked

    private void resultadoESGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultadoESGMouseClicked
        if (resultadoESG.isEnabled()) {
            double aValor = 0;
            double bValor = 0;
            double cValor = 0;
            boolean sucesso;
            try {
                auxiliarNumero = aTexto.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                aValor = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = bTexto.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                bValor = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = cTexto.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                cValor = Double.parseDouble(auxiliarNumero);

                sucesso = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Apenas números!");
                sucesso = false;
            }

            if (sucesso) {
                CalculadoraEquacoes equacoes = new CalculadoraEquacoes(aValor, bValor, cValor);
                String aFormatado = formatador.format(aValor);
                String bFormatado = formatador.format(bValor);
                String cFormatado = formatador.format(cValor);
                String deltaFormatado = formatador.format(equacoes.delta(aValor, bValor, cValor));

                a.setText(aFormatado);
                b.setText(bFormatado);
                c.setText(cFormatado);
                delta.setText(deltaFormatado);

                ArrayList<String> solucoes = equacoes.equacaoSegundoGrau();

                double raiz1Valor, raiz2Valor;
                String raiz1Formatada, raiz2Formatada;
                if (!"Não existe raiz real.".equals(solucoes.get(0)) && !"Apenas uma raiz real.".equals(solucoes.get(0))) {
                    raiz1Valor = Double.parseDouble(solucoes.get(0));
                    raiz1Formatada = formatador.format(raiz1Valor);
                    raiz1.setText(raiz1Formatada);
                } else {
                    raiz1.setText(solucoes.get(0));
                }

                if (!"Não existe raiz real.".equals(solucoes.get(1)) && !"Apenas uma raiz real.".equals(solucoes.get(1))) {
                    raiz2Valor = Double.parseDouble(solucoes.get(1));
                    raiz2Formatada = formatador.format(raiz2Valor);
                    raiz2.setText(raiz2Formatada);
                } else {
                    raiz2.setText(solucoes.get(1));
                }
            }
        }
    }//GEN-LAST:event_resultadoESGMouseClicked

    private void limparSDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparSDVMouseClicked
        if (limparSDV.isEnabled()) {
            xFinalSDV.setText("");
            yFinalSDV.setText("");
            x1SDV.setText("");
            x2SDV.setText("");
            y1SDV.setText("");
            y2SDV.setText("");
            resultado1SDV.setText("");
            resultado2SDV.setText("");
        }
    }//GEN-LAST:event_limparSDVMouseClicked

    private void resultadoSDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultadoSDVMouseClicked
        if (resultadoSDV.isEnabled()) {
            double[][] coeficientes = new double[3][3];
            double[] resultadosParciais = new double[2];
            boolean sucesso;
            try {
                auxiliarNumero = x1SDV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                coeficientes[0][0] = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = x2SDV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                coeficientes[1][0] = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = y1SDV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                coeficientes[0][1] = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = y2SDV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                coeficientes[1][1] = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = resultado1SDV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                resultadosParciais[0] = Double.parseDouble(auxiliarNumero);

                auxiliarNumero = resultado2SDV.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                resultadosParciais[1] = Double.parseDouble(auxiliarNumero);

                sucesso = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Apenas números!");
                sucesso = false;
            }

            if (sucesso) {
                CalculadoraAjusteLinear sistemas = new CalculadoraAjusteLinear();
                double[] resultados = sistemas.escalonarMatriz(coeficientes, resultadosParciais);

                String xFormatado = formatador.format(resultados[0]);
                xFinalSDV.setText(xFormatado);

                String yFormatado = formatador.format(resultados[1]);
                yFinalSDV.setText(yFormatado);
            }
        }
    }//GEN-LAST:event_resultadoSDVMouseClicked

    private void voltarSDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarSDVMouseClicked
        dispose();
        TelaInicial escolha = new TelaInicial(decimais);
        escolha.setVisible(true);
    }//GEN-LAST:event_voltarSDVMouseClicked

    private void voltarESGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarESGMouseClicked
        dispose();
        TelaInicial escolha = new TelaInicial(decimais);
        escolha.setVisible(true);
    }//GEN-LAST:event_voltarESGMouseClicked

    private final Document numero1SDV;
    private final Document numero2SDV;
    private final Document numero3SDV;
    private final Document numero4SDV;
    private final Document numero5SDV;
    private final Document numero6SDV;

    private final Document numero1STV;
    private final Document numero2STV;
    private final Document numero3STV;
    private final Document numero4STV;
    private final Document numero5STV;
    private final Document numero6STV;
    private final Document numero7STV;
    private final Document numero8STV;
    private final Document numero9STV;
    private final Document numero10STV;
    private final Document numero11STV;
    private final Document numero12STV;

    private final Document numero1ESG;
    private final Document numero2ESG;
    private final Document numero3ESG;

    public static int camposCheiosSDV = 0;
    public static int camposCheiosSTV = 0;
    public static int camposCheiosESG = 0;

    private String auxiliarNumero;

    private final int decimais;
    private final DecimalFormat formatador;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JTextField aTexto;
    private javax.swing.JTextField b;
    private javax.swing.JTextField bTexto;
    private javax.swing.JTextField c;
    private javax.swing.JTextField cTexto;
    private javax.swing.JTextField delta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JButton limparESG;
    private javax.swing.JButton limparSDV;
    private javax.swing.JButton limparSTV;
    private javax.swing.JTabbedPane painelEquacoes;
    private javax.swing.JTextField raiz1;
    private javax.swing.JTextField raiz2;
    private javax.swing.JTextField resultado1SDV;
    private javax.swing.JTextField resultado1STV;
    private javax.swing.JTextField resultado2SDV;
    private javax.swing.JTextField resultado2STV;
    private javax.swing.JTextField resultado3STV;
    private javax.swing.JButton resultadoESG;
    private javax.swing.JButton resultadoSDV;
    private javax.swing.JButton resultadoSTV;
    private javax.swing.JButton voltarESG;
    private javax.swing.JButton voltarSDV;
    private javax.swing.JButton voltarSTV;
    private javax.swing.JTextField x1SDV;
    private javax.swing.JTextField x1STV;
    private javax.swing.JTextField x2SDV;
    private javax.swing.JTextField x2STV;
    private javax.swing.JTextField x3STV;
    private javax.swing.JTextField xFinalSDV;
    private javax.swing.JTextField xFinalSTV;
    private javax.swing.JTextField y1SDV;
    private javax.swing.JTextField y1STV;
    private javax.swing.JTextField y2SDV;
    private javax.swing.JTextField y2STV;
    private javax.swing.JTextField y3STV;
    private javax.swing.JTextField yFinalSDV;
    private javax.swing.JTextField yFinalSTV;
    private javax.swing.JTextField z1STV;
    private javax.swing.JTextField z2STV;
    private javax.swing.JTextField z3STV;
    private javax.swing.JTextField zFinalSTV;
    // End of variables declaration//GEN-END:variables
}
