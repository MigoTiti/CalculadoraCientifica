package GUI;

import calculadoracientifica.Aritmetica.CalculadoraAritmetica;
import calculadoracientifica.Aritmetica.Derivada.CalculadoraDerivada;
import calculadoracientifica.Aritmetica.Integral.CalculadoraIntegral;
import calculadoracientifica.Enums.Constantes;
import calculadoracientifica.Interfaces.OperacoesPrimitivas;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Aritmetica extends javax.swing.JFrame implements OperacoesPrimitivas {

    public Aritmetica(int decimais) {
        initComponents();
        //Geral       
        this.calculadora = new CalculadoraAritmetica();
        //StringBuilder      
        this.equacao = new StringBuilder();
        //ArrayLists       
        this.operadores = new ArrayList<>();
        this.sinais = new ArrayList<>();
        //Formatador

        this.decimais = decimais;
        String aux = "#.";
        for (int i = 1; i <= decimais; i++) {
            aux += "#";
        }
        //aux+="E0";

        this.formatador = new DecimalFormat(aux);

        //Booleanas        
        this.fimOperacao = false;
        this.permitirSinal = false;
        this.parentesesInterno = false;
        //Contador        
        this.parentesesContador = 0;
        //Comandos
        this.limparEquacao.setEnabled(false);
        this.resposta.setEnabled(false);
        this.igual.setEnabled(false);
        this.formatador.setDecimalSeparatorAlwaysShown(false);
        this.caixaEquacao.requestFocusInWindow();

        this.calculadoraDerivada = new CalculadoraDerivada();

        this.modoIntegral = "numerica";
        this.numerica.setSelected(true);
        this.xPosicoesIntDer = new ArrayList<>();
        this.calculadoraIntegral = new CalculadoraIntegral();
        this.sinaisIntDer = new ArrayList<>();
        this.operadoresIntDer = new ArrayList<>();
        this.equacaoIntDer = new StringBuilder();
        this.parentesesIntDer = false;
        this.sinalIntDer = false;
        this.contadorParentesesIntDer = 0;
        this.radianos.setSelected(true);
        this.sinalIntDer = false;
        this.xAnteriorIntDer = false;
        this.posicaoIntDer = 0;
        this.operadoresAuxiliar = new ArrayList<>();
        this.vazio = "";
    }

    class ConstantesEscolha extends JFrame {

        public ConstantesEscolha() {
            iniciarFrame();
            caixaEscolha.setSelectedItem(null);
            nomeTexto.setEditable(false);
            valorTexto.setEditable(false);
            caixaEscolha.addItemListener((ItemEvent e) -> {
                constanteAtual = (Constantes) caixaEscolha.getSelectedItem();
                nomeTexto.setText(constanteAtual.getNome());
                valorTexto.setText(Double.toString(constanteAtual.getValor()));
            });
        }

        private void evento() {
            equacao.append(constanteAtual.toString());
            operadores.add(constanteAtual.getValor());
            caixaResposta.setText(equacao.toString());
            permitirSinal = true;
            caixaResposta.requestFocusInWindow();
            if (!limparEquacao.isEnabled()) {
                limparEquacao.setEnabled(true);
            }
        }

        private void iniciarFrame() {

            caixaEscolha = new javax.swing.JComboBox();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            nomeTexto = new javax.swing.JTextField();
            valorTexto = new javax.swing.JTextField();
            okBotao = new javax.swing.JButton();
            cancelarBotao = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setResizable(false);

            caixaEscolha.setModel(new DefaultComboBoxModel(Constantes.values()));

            jLabel1.setText("ESCOLHA A CONSTANTE");

            jLabel2.setText("NOME");

            jLabel3.setText("VALOR");

            okBotao.setText("OK");

            cancelarBotao.setText("CANCELAR");
            cancelarBotao.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cancelarBotaoMouseClicked(evt);
                }
            });

            okBotao.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    okBotaoMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(valorTexto)
                                    .addComponent(nomeTexto)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(caixaEscolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel1)
                                                    .addComponent(jLabel3))
                                            .addGap(0, 0, Short.MAX_VALUE)))
                            .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(okBotao)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cancelarBotao)
                            .addContainerGap(57, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(caixaEscolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nomeTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(valorTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(okBotao)
                                    .addComponent(cancelarBotao))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
            setLocationRelativeTo(null);
            setResizable(false);
            setVisible(true);
        }

        private void cancelarBotaoMouseClicked(java.awt.event.MouseEvent evt) {
            Aritmetica.this.setVisible(true);
            dispose();
        }

        private void okBotaoMouseClicked(java.awt.event.MouseEvent evt) {
            evento();
            Aritmetica.this.setVisible(true);
            dispose();
        }

        Constantes constanteAtual;
        private javax.swing.JComboBox caixaEscolha;
        private javax.swing.JButton cancelarBotao;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JTextField nomeTexto;
        private javax.swing.JButton okBotao;
        private javax.swing.JTextField valorTexto;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        caixaResposta = new javax.swing.JTextField();
        caixaEquacao = new javax.swing.JTextField();
        mais = new javax.swing.JButton();
        menos = new javax.swing.JButton();
        multiplicacao = new javax.swing.JButton();
        divisao = new javax.swing.JButton();
        mod = new javax.swing.JButton();
        piBotao = new javax.swing.JButton();
        seno = new javax.swing.JButton();
        cosseno = new javax.swing.JButton();
        tangente = new javax.swing.JButton();
        integral = new javax.swing.JButton();
        derivada = new javax.swing.JButton();
        quadrado = new javax.swing.JButton();
        elevadoY = new javax.swing.JButton();
        raiz = new javax.swing.JButton();
        eElevadoX = new javax.swing.JButton();
        logNeperiano = new javax.swing.JButton();
        igual = new javax.swing.JButton();
        resposta = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        abreParentese = new javax.swing.JButton();
        fechaParenteses = new javax.swing.JButton();
        xCubo = new javax.swing.JButton();
        logX = new javax.swing.JButton();
        limparEquacao = new javax.swing.JButton();
        graus = new javax.swing.JRadioButton();
        radianos = new javax.swing.JRadioButton();
        area = new javax.swing.JRadioButton();
        numerica = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        constantesBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aritmetica");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(491, 331));
        setResizable(false);
        setSize(new java.awt.Dimension(491, 331));

        caixaResposta.setEditable(false);
        caixaResposta.setFocusable(false);

        caixaEquacao.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        mais.setText("+");
        mais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maisMouseClicked(evt);
            }
        });

        menos.setText("-");
        menos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menosMouseClicked(evt);
            }
        });

        multiplicacao.setText("*");
        multiplicacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                multiplicacaoMouseClicked(evt);
            }
        });

        divisao.setText("/");
        divisao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                divisaoMouseClicked(evt);
            }
        });

        mod.setText("MOD");
        mod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modMouseClicked(evt);
            }
        });

        piBotao.setText("PI");
        piBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                piBotaoMouseClicked(evt);
            }
        });

        seno.setText("SEN(X)");
        seno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                senoMouseClicked(evt);
            }
        });

        cosseno.setText("COS(X)");
        cosseno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cossenoMouseClicked(evt);
            }
        });

        tangente.setText("TG(X)");
        tangente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tangenteMouseClicked(evt);
            }
        });

        integral.setText("INTEGRAL");
        integral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                integralMouseClicked(evt);
            }
        });

        derivada.setText("DERIVADA");
        derivada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                derivadaMouseClicked(evt);
            }
        });

        quadrado.setText("X²");
        quadrado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quadradoMouseClicked(evt);
            }
        });

        elevadoY.setText("X^Y");
        elevadoY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                elevadoYMouseClicked(evt);
            }
        });

        raiz.setText("SQRT(X)");
        raiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                raizMouseClicked(evt);
            }
        });

        eElevadoX.setText("e^X");
        eElevadoX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eElevadoXMouseClicked(evt);
            }
        });

        logNeperiano.setText("LN(X)");
        logNeperiano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logNeperianoMouseClicked(evt);
            }
        });

        igual.setText("=");
        igual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                igualMouseClicked(evt);
            }
        });

        resposta.setText("RESPOSTA");
        resposta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                respostaMouseClicked(evt);
            }
        });

        voltar.setText("VOLTAR");
        voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarMouseClicked(evt);
            }
        });

        abreParentese.setText("(");
        abreParentese.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abreParenteseMouseClicked(evt);
            }
        });

        fechaParenteses.setText(")");
        fechaParenteses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaParentesesMouseClicked(evt);
            }
        });

        xCubo.setText("X³");
        xCubo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xCuboMouseClicked(evt);
            }
        });

        logX.setText("LOG(X)");
        logX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logXMouseClicked(evt);
            }
        });

        limparEquacao.setText("LIMPAR");
        limparEquacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparEquacaoMouseClicked(evt);
            }
        });

        buttonGroup1.add(graus);
        graus.setText("GRAUS");
        graus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grausMouseClicked(evt);
            }
        });

        buttonGroup1.add(radianos);
        radianos.setText("RADIANOS");
        radianos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radianosMouseClicked(evt);
            }
        });

        buttonGroup2.add(area);
        area.setText("ÁREA");
        area.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                areaMouseClicked(evt);
            }
        });

        buttonGroup2.add(numerica);
        numerica.setText("NUMÉRICA");
        numerica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                numericaMouseClicked(evt);
            }
        });

        jLabel1.setText("TIPO DE INTEGRAL");

        constantesBotao.setText("CONSTANTES");
        constantesBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                constantesBotaoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(caixaResposta)
                    .addComponent(caixaEquacao)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(voltar)
                        .addGap(77, 77, 77)
                        .addComponent(constantesBotao)
                        .addGap(77, 77, 77)
                        .addComponent(resposta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(igual))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(piBotao)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(seno)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cosseno)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tangente))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(eElevadoX)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(logNeperiano)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(logX)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(abreParentese)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fechaParenteses)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radianos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(graus))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mais)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(menos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(multiplicacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(divisao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mod))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(quadrado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xCubo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(elevadoY)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(raiz)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(limparEquacao, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(49, 49, 49)
                                    .addComponent(derivada))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addComponent(integral))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(numerica)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(area)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(9, 9, 9)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(caixaEquacao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(caixaResposta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(graus)
                            .addComponent(radianos))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mais)
                            .addComponent(menos)
                            .addComponent(multiplicacao)
                            .addComponent(divisao)
                            .addComponent(mod))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seno)
                            .addComponent(cosseno)
                            .addComponent(tangente)
                            .addComponent(piBotao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quadrado)
                            .addComponent(elevadoY)
                            .addComponent(raiz)
                            .addComponent(xCubo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logNeperiano)
                            .addComponent(abreParentese)
                            .addComponent(fechaParenteses)
                            .addComponent(eElevadoX)
                            .addComponent(logX)
                            .addComponent(limparEquacao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(voltar)
                            .addComponent(resposta)
                            .addComponent(igual)
                            .addComponent(constantesBotao)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(area)
                            .addComponent(numerica))
                        .addGap(5, 5, 5)
                        .addComponent(integral)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(derivada)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void eventoPrimitivo(String sinal) {
        caixaEquacao.requestFocusInWindow();
        boolean sucesso = false;
        if (permitirSinal == false) {
            try {
                auxiliarNumero = caixaEquacao.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                operador = Double.parseDouble(auxiliarNumero);
                sucesso = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Apenas números!");
                auxiliarNumero = null;
                sucesso = false;
            }

            if (sucesso) {
                operadores.add(operador);
                caixaEquacao.setText(vazio);
                operadorFormatado = formatador.format(operador);
                equacao.append(operadorFormatado).append(sinal);
                sinais.add(sinal);
            }
        } else if (permitirSinal) {
            equacao.append(sinal);
            sinais.add(sinal);
            permitirSinal = false;
            sucesso = true;
        }

        if (sucesso) {
            caixaResposta.setText(equacao.toString());
            if (!igual.isEnabled()) {
                igual.setEnabled(true);
            }
            if (!limparEquacao.isEnabled()) {
                limparEquacao.setEnabled(true);
            }
        }
    }

    private void eventoTRL(String sinal, String sinalExibido) {
        caixaEquacao.requestFocusInWindow();
        equacao.append(sinalExibido).append("(");
        sinais.add(sinal);
        sinais.add("(");

        if (fimOperacao) {
            caixaResposta.setText(vazio);
            fimOperacao = false;
        }

        caixaResposta.setText(equacao.toString());
        parentesesContador++;

        if (parentesesInterno == false) {
            parentesesInterno = true;
        }

        if (!igual.isEnabled()) {
            igual.setEnabled(true);
        }
        if (!limparEquacao.isEnabled()) {
            limparEquacao.setEnabled(true);
        }
    }

    private void eventoConstante(double constante, String nome) {
        caixaEquacao.requestFocusInWindow();
        operadorFormatado = formatador.format(constante);
        if ("Resultado".equals(nome)) {
            equacao.append(operadorFormatado);
        } else {
            equacao.append(nome);
        }
        operadores.add(constante);

        if (fimOperacao) {
            caixaResposta.setText(vazio);
            fimOperacao = false;
        }

        caixaResposta.setText(equacao.toString());
        permitirSinal = true;

        if (!limparEquacao.isEnabled()) {
            limparEquacao.setEnabled(true);
        }
    }

    private void maisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maisMouseClicked
        eventoPrimitivo("+");
    }//GEN-LAST:event_maisMouseClicked

    private void menosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menosMouseClicked
        eventoPrimitivo("-");
    }//GEN-LAST:event_menosMouseClicked

    private void multiplicacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multiplicacaoMouseClicked
        eventoPrimitivo("*");
    }//GEN-LAST:event_multiplicacaoMouseClicked

    private void divisaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_divisaoMouseClicked
        eventoPrimitivo("/");
    }//GEN-LAST:event_divisaoMouseClicked

    private void modMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modMouseClicked
        eventoPrimitivo("%");
    }//GEN-LAST:event_modMouseClicked

    private void piBotaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piBotaoMouseClicked
        if (!permitirSinal) {
            eventoConstante(Math.PI, "PI");
        } else {
            JOptionPane.showMessageDialog(null, "Não é possível inserir um número nesse momento");
        }
    }//GEN-LAST:event_piBotaoMouseClicked

    private void senoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_senoMouseClicked
        eventoTRL("sen", "seno");
    }//GEN-LAST:event_senoMouseClicked

    private void abreParenteseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abreParenteseMouseClicked
        caixaEquacao.requestFocusInWindow();
        if (!permitirSinal) {
            equacao.append("(");
            sinais.add("(");
            caixaResposta.setText(equacao.toString());
            parentesesContador++;
            if (parentesesInterno == false) {
                parentesesInterno = true;
            }
        }
    }//GEN-LAST:event_abreParenteseMouseClicked

    private void fechaParentesesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaParentesesMouseClicked
        caixaEquacao.requestFocusInWindow();
        boolean sucesso;
        if (permitirSinal == false && parentesesInterno) {
            if (")".equals(sinais.get(sinais.size() - 1))) {
                equacao.append(")");
                sinais.add(")");
                parentesesContador--;
                caixaResposta.setText(equacao.toString());
                permitirSinal = true;
            } else {
                try {
                    auxiliarNumero = caixaEquacao.getText();
                    if (auxiliarNumero.contains(",")) {
                        auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                    }
                    operador = Double.parseDouble(auxiliarNumero);
                    sucesso = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Apenas números!");
                    auxiliarNumero = null;
                    sucesso = false;
                }
                if (sucesso) {
                    operadores.add(operador);
                    caixaEquacao.setText(vazio);
                    equacao.append(formatador.format(operador)).append(")");
                    sinais.add(")");
                    parentesesContador--;
                    caixaResposta.setText(equacao.toString());
                    permitirSinal = true;
                }
            }
        } else if (permitirSinal && parentesesInterno) {
            equacao.append(")");
            sinais.add(")");
            parentesesContador--;
            caixaResposta.setText(equacao.toString());
        }

        if (0 >= parentesesContador) {
            parentesesInterno = false;
        }

        if (igual.isEnabled() == false) {
            igual.setEnabled(true);
        }
    }//GEN-LAST:event_fechaParentesesMouseClicked

    private void cossenoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cossenoMouseClicked
        eventoTRL("cos", "cosseno");
    }//GEN-LAST:event_cossenoMouseClicked

    private void tangenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tangenteMouseClicked
        eventoTRL("tg", "tangente");
    }//GEN-LAST:event_tangenteMouseClicked

    private void raizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_raizMouseClicked
        eventoTRL("sqrt", "raiz");
    }//GEN-LAST:event_raizMouseClicked

    private void quadradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quadradoMouseClicked
        caixaEquacao.requestFocusInWindow();
        boolean sucesso;
        if (permitirSinal == false) {
            try {
                auxiliarNumero = caixaEquacao.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                operador = Double.parseDouble(auxiliarNumero);
                sucesso = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Apenas números!");
                auxiliarNumero = null;
                sucesso = false;
            }
            if (sucesso) {
                operadores.add(operador);
                caixaEquacao.setText(vazio);
                operadorFormatado = formatador.format(operador);
                equacao.append(operadorFormatado).append("^2");
                sinais.add("^");
                operadores.add(2.0);
            }
        } else if (permitirSinal) {
            equacao.append("^2");
            sinais.add("^");
            operadores.add(2.0);
        }

        permitirSinal = true;
        caixaResposta.setText(equacao.toString());

        if (igual.isEnabled() == false) {
            igual.setEnabled(true);
        }
    }//GEN-LAST:event_quadradoMouseClicked

    private void elevadoYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_elevadoYMouseClicked
        caixaEquacao.requestFocusInWindow();
        boolean sucesso;
        if (permitirSinal == false) {
            try {
                auxiliarNumero = caixaEquacao.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                operador = Double.parseDouble(auxiliarNumero);
                sucesso = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Apenas números!");
                auxiliarNumero = null;
                sucesso = false;
            }
            if (sucesso) {
                operadores.add(operador);
                caixaEquacao.setText(vazio);
                operadorFormatado = formatador.format(operador);
                equacao.append(operadorFormatado).append("^").append("(");
                sinais.add("(");
                sinais.add("^");
            }
        } else if (permitirSinal) {
            equacao.append("^").append("(");
            sinais.add("(");
            sinais.add("^");
            permitirSinal = false;
        }

        parentesesContador++;

        if (parentesesInterno == false) {
            parentesesInterno = true;
        }
        caixaResposta.setText(equacao.toString());

        if (igual.isEnabled() == false) {
            igual.setEnabled(true);
        }
    }//GEN-LAST:event_elevadoYMouseClicked

    private void eElevadoXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eElevadoXMouseClicked
        caixaEquacao.requestFocusInWindow();
        equacao.append("e^").append("(");
        operadores.add(Math.E);
        sinais.add("^");
        sinais.add("(");
        caixaResposta.setText(equacao.toString());

        parentesesContador++;

        if (parentesesInterno == false) {
            parentesesInterno = true;
        }
        if (permitirSinal) {
            permitirSinal = false;
        }

        caixaResposta.setText(equacao.toString());

        if (igual.isEnabled() == false) {
            igual.setEnabled(true);
        }
    }//GEN-LAST:event_eElevadoXMouseClicked

    private void xCuboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xCuboMouseClicked
        caixaEquacao.requestFocusInWindow();
        boolean sucesso;
        if (permitirSinal == false) {
            try {
                auxiliarNumero = caixaEquacao.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                operador = Double.parseDouble(auxiliarNumero);
                sucesso = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Apenas números!");
                auxiliarNumero = null;
                sucesso = false;
            }
            if (sucesso) {
                operadores.add(operador);
                caixaEquacao.setText(vazio);
                operadorFormatado = formatador.format(operador);
                equacao.append(operadorFormatado).append("^3");
                sinais.add("^");
                operadores.add(3.0);
            }
        } else if (permitirSinal) {
            equacao.append("^3");
            sinais.add("^");
            operadores.add(3.0);
        }

        permitirSinal = true;
        caixaResposta.setText(equacao.toString());

        if (igual.isEnabled() == false) {
            igual.setEnabled(true);
        }
    }//GEN-LAST:event_xCuboMouseClicked

    private void logNeperianoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logNeperianoMouseClicked
        eventoTRL("ln", "ln");
    }//GEN-LAST:event_logNeperianoMouseClicked

    private void logXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logXMouseClicked
        eventoTRL("log", "log");
    }//GEN-LAST:event_logXMouseClicked

    private void integralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_integralMouseClicked
        boolean concluido = digitarEquacaoIntegral();
        if (concluido) {
            equacao.append(resultado);
            operadores.add(resultado);
            caixaEquacao.requestFocusInWindow();
            caixaResposta.setText(formatador.format(Double.parseDouble(equacao.toString())));
            permitirSinal = true;
            if (!limparEquacao.isEnabled()) {
                limparEquacao.setEnabled(true);
            }
        }
    }//GEN-LAST:event_integralMouseClicked

    private void limparEquacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparEquacaoMouseClicked
        limpar();
    }//GEN-LAST:event_limparEquacaoMouseClicked

    private void respostaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_respostaMouseClicked
        if (resposta.isEnabled() && resultado != 0 && !permitirSinal) {
            eventoConstante(resultado, "Resultado");
        } else {
            JOptionPane.showMessageDialog(null, "Não é possível inserir um número nesse momento");
        }
    }//GEN-LAST:event_respostaMouseClicked

    private void igualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igualMouseClicked
        if (igual.isEnabled()) {
            obterResposta();
        }
    }//GEN-LAST:event_igualMouseClicked

    private void voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseClicked
        voltar();
    }//GEN-LAST:event_voltarMouseClicked

    private void grausMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grausMouseClicked
        if (graus.isSelected()) {
            calculadora.mudarStatus("graus");
        }
    }//GEN-LAST:event_grausMouseClicked

    private void radianosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radianosMouseClicked
        if (radianos.isSelected()) {
            calculadora.mudarStatus("radianos");
        }
    }//GEN-LAST:event_radianosMouseClicked

    private void derivadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_derivadaMouseClicked
        boolean concluido = digitarEquacaoDerivada();
        if (concluido) {
            equacao.append(resultado);
            operadores.add(resultado);
            caixaEquacao.requestFocusInWindow();
            caixaResposta.setText(formatador.format(Double.parseDouble(equacao.toString())));
            permitirSinal = true;
            if (!limparEquacao.isEnabled()) {
                limparEquacao.setEnabled(true);
            }
        }
    }//GEN-LAST:event_derivadaMouseClicked

    private void numericaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numericaMouseClicked
        if (numerica.isSelected()) {
            modoIntegral = "numerica";
        }
    }//GEN-LAST:event_numericaMouseClicked

    private void areaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_areaMouseClicked
        if (area.isSelected()) {
            modoIntegral = "area";
        }
    }//GEN-LAST:event_areaMouseClicked

    private void constantesBotaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_constantesBotaoMouseClicked
        if (!permitirSinal) {
            new ConstantesEscolha();
            Aritmetica.this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Não é possível inserir um número nesse momento");
        }
    }//GEN-LAST:event_constantesBotaoMouseClicked

    public boolean digitarEquacaoIntegral() {
        JTextField limiteSuperiorTexto = new JTextField(vazio);
        limiteSuperiorTexto.addAncestorListener(new AuxiliarFoco());
        JTextField limiteInferiorTexto = new JTextField(vazio);
        JTextField equacaoDigitar = new JTextField(vazio);
        JTextField equacaoLer = new JTextField(vazio);

        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean sucessoParse = false;
                boolean sucesso = false;
                String atual = equacaoDigitar.getText();
                if (("+".equals(atual) || "-".equals(atual) || "*".equals(atual) || "/".equals(atual) || "^".equals(atual)) && (!sinalIntDer || xAnteriorIntDer)) {
                    sinaisIntDer.add(atual);
                    sinalIntDer = true;
                    sucesso = true;
                    posicaoIntDer--;
                    if (xAnteriorIntDer) {
                        xAnteriorIntDer = false;
                    }
                } else if ("(".equals(atual) && sinalIntDer) {
                    sinaisIntDer.add(atual);
                    if (parentesesIntDer == false) {
                        parentesesIntDer = true;
                    }
                    contadorParentesesIntDer++;
                    posicaoIntDer--;
                    sucesso = true;
                } else if ("ln".equals(atual) || "sqrt".equals(atual) || "sen".equals(atual) || "cos".equals(atual) || "tg".equals(atual) || "log".equals(atual)) {
                    sinaisIntDer.add(atual);
                    sinalIntDer = true;
                    sinaisIntDer.add("(");
                    posicaoIntDer--;
                    atual = atual.concat("(");
                    if (parentesesIntDer == false) {
                        parentesesIntDer = true;
                    }
                    contadorParentesesIntDer++;
                    sucesso = true;
                } else if (parentesesIntDer && ")".equals(atual)) {
                    sinaisIntDer.add(atual);
                    contadorParentesesIntDer--;
                    if (contadorParentesesIntDer <= 0) {
                        parentesesIntDer = false;
                    }
                    if (sinalIntDer) {
                        sinalIntDer = false;
                    }
                    sucesso = true;
                } else if ((!")".equals(atual)) && (!"+".equals(atual)) && (!"-".equals(atual)) && (!"/".equals(atual)) && (!"*".equals(atual)) && (!"^".equals(atual)) && (!"(".equals(atual)) && (!"x".equals(atual)) && (!"-x".equals(atual))) {
                    if (null != atual) {
                        switch (atual) {
                            case "PI":
                            case "Pi":
                            case "pi":
                            case "pI":
                                operadoresIntDer.add(Double.toString(Math.PI));
                                sucessoParse = true;
                                break;
                            case "E":
                            case "e":
                                operadoresIntDer.add(Double.toString(Math.E));
                                sucessoParse = true;
                                break;
                            default:
                                try {
                                    if (atual.contains(",")) {
                                        atual = atual.replaceAll("\\,", ".");
                                    }
                                    Double.parseDouble(atual);
                                    sucessoParse = true;
                                } catch (NumberFormatException e2) {
                                    JOptionPane.showMessageDialog(null, "Apenas números!");
                                    sucessoParse = false;
                                }
                                if (sucessoParse) {
                                    operadoresIntDer.add(atual);
                                }
                                break;
                        }
                    }
                    if (sucessoParse) {
                        if (sinalIntDer) {
                            sinalIntDer = false;
                        }
                        sucesso = true;
                    }
                } else if ((("x".equals(atual) || "X".equals(atual)) && sinalIntDer && xAnteriorIntDer == false) || (("x".equals(atual) || ("X".equals(atual))) && "".equals(equacaoLer.getText()))) {
                    xAnteriorIntDer = true;
                    xPosicoesIntDer.add(posicaoIntDer);
                    sucesso = true;
                } else if ((("-x".equals(atual) || "-X".equals(atual)) && sinalIntDer && xAnteriorIntDer == false) || (("-x".equals(atual) || ("-X".equals(atual))) && "".equals(equacaoLer.getText()))) {
                    xAnteriorIntDer = true;
                    xPosicoesIntDer.add(-posicaoIntDer);
                    sucesso = true;
                }

                if (sucesso) {
                    equacaoIntDer.append(atual);
                    posicaoIntDer++;
                }

                equacaoDigitar.setText(vazio);
                equacaoLer.setText(equacaoIntDer.toString());
            }
        };

        equacaoDigitar.addActionListener(action);

        double limS, limI;

        JPanel integralPainel = new JPanel(new GridLayout(0, 1));
        integralPainel.add(new JLabel("Limite superior: "));
        integralPainel.add(limiteSuperiorTexto);
        integralPainel.add(new JLabel("Limite inferior: "));
        integralPainel.add(limiteInferiorTexto);
        integralPainel.add(new JLabel("Função: "));
        integralPainel.add(equacaoDigitar);

        integralPainel.add(equacaoLer);
        equacaoLer.setEditable(false);

        int result = JOptionPane.showConfirmDialog(null, integralPainel, "Integral", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            limS = Double.parseDouble(limiteSuperiorTexto.getText());
            limI = Double.parseDouble(limiteInferiorTexto.getText());
            if (limS == limI) {
                resultado = 0;
                return true;
            }

            for (String operador2 : operadoresIntDer) {
                operadoresAuxiliar.add(Double.parseDouble(operador2));
            }

            operadoresIntDer.clear();

            switch (modoIntegral) {
                case "area":
                    resultado = calculadoraIntegral.integralAdaptativaArea(limS, limI, operadoresAuxiliar, sinaisIntDer, xPosicoesIntDer);
                    break;
                case "numerica":
                    resultado = calculadoraIntegral.integralAdaptativaNumerica(limS, limI, operadoresAuxiliar, sinaisIntDer, xPosicoesIntDer);
                    break;
            }

            operadoresIntDer.clear();
            sinaisIntDer.clear();
            equacaoIntDer.setLength(0);
            parentesesIntDer = false;
            sinalIntDer = false;
            xAnteriorIntDer = false;
            contadorParentesesIntDer = 0;
            posicaoIntDer = 0;
            xPosicoesIntDer.clear();
            operadoresAuxiliar.clear();
            return true;
        } else {
            operadoresIntDer.clear();
            sinaisIntDer.clear();
            equacaoIntDer.setLength(0);
            parentesesIntDer = false;
            sinalIntDer = false;
            xAnteriorIntDer = false;
            contadorParentesesIntDer = 0;
            xPosicoesIntDer.clear();
            operadoresAuxiliar.clear();
            return false;
        }
    }

    public boolean digitarEquacaoDerivada() {
        JTextField x = new JTextField(vazio);
        x.addAncestorListener(new AuxiliarFoco());
        JTextField equacaoDigitar = new JTextField(vazio);
        JTextField equacaoLer = new JTextField(vazio);

        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean sucessoParse = false;
                boolean sucesso = false;
                String atual = equacaoDigitar.getText();
                if (("+".equals(atual) || "-".equals(atual) || "*".equals(atual) || "/".equals(atual) || "^".equals(atual)) && (!sinalIntDer || xAnteriorIntDer)) {
                    sinaisIntDer.add(atual);
                    sinalIntDer = true;
                    sucesso = true;
                    posicaoIntDer--;
                    if (xAnteriorIntDer) {
                        xAnteriorIntDer = false;
                    }
                } else if ("(".equals(atual) && sinalIntDer) {
                    sinaisIntDer.add(atual);
                    if (parentesesIntDer == false) {
                        parentesesIntDer = true;
                    }
                    contadorParentesesIntDer++;
                    posicaoIntDer--;
                    sucesso = true;
                } else if ("ln".equals(atual) || "sqrt".equals(atual) || "sen".equals(atual) || "cos".equals(atual) || "tg".equals(atual) || "log".equals(atual)) {
                    sinaisIntDer.add(atual);
                    sinaisIntDer.add("(");
                    sinalIntDer = true;
                    posicaoIntDer--;
                    atual = atual.concat("(");
                    if (parentesesIntDer == false) {
                        parentesesIntDer = true;
                    }
                    contadorParentesesIntDer++;
                    sucesso = true;
                } else if (parentesesIntDer && ")".equals(atual)) {
                    sinaisIntDer.add(atual);
                    contadorParentesesIntDer--;
                    if (contadorParentesesIntDer <= 0) {
                        parentesesIntDer = false;
                    }
                    if (sinalIntDer) {
                        sinalIntDer = false;
                    }
                    sucesso = true;
                } else if ((!")".equals(atual)) && (!"+".equals(atual)) && (!"-".equals(atual)) && (!"/".equals(atual)) && (!"*".equals(atual)) && (!"^".equals(atual)) && (!"(".equals(atual)) && (!"x".equals(atual)) && (!"-x".equals(atual))) {
                    if (null != atual) {
                        switch (atual) {
                            case "PI":
                            case "Pi":
                            case "pi":
                            case "pI":
                                operadoresIntDer.add(Double.toString(Math.PI));
                                sucessoParse = true;
                                break;
                            case "E":
                            case "e":
                                operadoresIntDer.add(Double.toString(Math.E));
                                sucessoParse = true;
                                break;
                            default:
                                try {
                                    if (atual.contains(",")) {
                                        atual = atual.replaceAll("\\,", ".");
                                    }
                                    sucessoParse = true;
                                } catch (NumberFormatException e2) {
                                    JOptionPane.showMessageDialog(null, "Apenas números!");
                                    sucessoParse = false;
                                }
                                if (sucessoParse) {
                                    operadoresIntDer.add(atual);
                                }
                                break;
                        }
                    }
                    if (sucessoParse) {
                        if (sinalIntDer) {
                            sinalIntDer = false;
                        }
                        sucesso = true;
                    }
                } else if (("x".equals(atual) && sinalIntDer && xAnteriorIntDer == false) || ("x".equals(atual) && "".equals(equacaoLer.getText()))) {
                    xAnteriorIntDer = true;
                    xPosicoesIntDer.add(posicaoIntDer);
                    sucesso = true;
                } else if (("-x".equals(atual) && sinalIntDer && xAnteriorIntDer == false) || ("-x".equals(atual) && "".equals(equacaoLer.getText()))) {
                    xAnteriorIntDer = true;
                    xPosicoesIntDer.add(-posicaoIntDer);
                    sucesso = true;
                }

                if (sucesso) {
                    equacaoIntDer.append(atual);
                    posicaoIntDer++;
                }

                equacaoDigitar.setText(vazio);
                equacaoLer.setText(equacaoIntDer.toString());
            }
        };

        equacaoDigitar.addActionListener(action);

        double xValor;

        JPanel DerivadaPainel = new JPanel(new GridLayout(0, 1));
        DerivadaPainel.add(new JLabel("Valor do x: "));
        DerivadaPainel.add(x);
        DerivadaPainel.add(new JLabel("Função: "));
        DerivadaPainel.add(equacaoDigitar);

        DerivadaPainel.add(equacaoLer);
        equacaoLer.setEditable(false);

        int result = JOptionPane.showConfirmDialog(null, DerivadaPainel, "Integral", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            xValor = Double.parseDouble(x.getText());
            for (String operador2 : operadoresIntDer) {
                operadoresAuxiliar.add(Double.parseDouble(operador2));
            }
            operadoresIntDer.clear();
            resultado = calculadoraDerivada.derivada(xValor, operadoresAuxiliar, sinaisIntDer, xPosicoesIntDer);
            operadoresIntDer.clear();
            sinaisIntDer.clear();
            equacaoIntDer.setLength(0);
            parentesesIntDer = false;
            sinalIntDer = false;
            xAnteriorIntDer = false;
            contadorParentesesIntDer = 0;
            posicaoIntDer = 0;
            xPosicoesIntDer.clear();
            operadoresAuxiliar.clear();
            return true;
        } else {
            operadoresIntDer.clear();
            sinaisIntDer.clear();
            equacaoIntDer.setLength(0);
            parentesesIntDer = false;
            sinalIntDer = false;
            xAnteriorIntDer = false;
            contadorParentesesIntDer = 0;
            xPosicoesIntDer.clear();
            operadoresAuxiliar.clear();
            return false;
        }
    }

    @Override
    public void limpar() {
        caixaEquacao.setText(vazio);
        caixaResposta.setText(vazio);
        equacao.setLength(0);
        operadores.clear();
        sinais.clear();
        permitirSinal = false;
        parentesesContador = 0;
        parentesesInterno = false;
        caixaEquacao.requestFocusInWindow();
        if (igual.isEnabled()) {
            igual.setEnabled(false);
        }
        if (resposta.isEnabled()) {
            resposta.setEnabled(false);
        }
        limparEquacao.setEnabled(false);
        resultado = 0;
    }

    @Override
    public void voltar() {
        dispose();
        TelaInicial escolha = new TelaInicial(decimais);
        escolha.setVisible(true);
    }

    @Override
    public void obterResposta() {
        boolean sucesso;
        if (permitirSinal == false) {
            try {
                auxiliarNumero = caixaEquacao.getText();
                if (auxiliarNumero.contains(",")) {
                    auxiliarNumero = auxiliarNumero.replaceAll("\\,", ".");
                }
                operador = Double.parseDouble(auxiliarNumero);
                sucesso = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Apenas números!");
                auxiliarNumero = null;
                sucesso = false;
            }
            if (sucesso) {
                operadores.add(operador);
                caixaEquacao.setText(vazio);
                equacao.append(operador);
            }
        } else {
            caixaEquacao.setText(vazio);
        }

        resultado = calculadora.interpretador(operadores, sinais);
        if (resultado < 1 && resultado > 0) {
            String aux = formatador.toPattern();
            aux = aux.replaceAll("0", "");
            aux += "E0";
            formatador = new DecimalFormat(aux);
            operadorFormatado = formatador.format(resultado);
            aux = aux.substring(0, aux.length() - 3);
            formatador = new DecimalFormat(aux);
        } else {
            operadorFormatado = formatador.format(resultado);
        }
        caixaResposta.setText(operadorFormatado);

        if (!resposta.isEnabled()) {
            resposta.setEnabled(true);
        }

        if (!fimOperacao) {
            fimOperacao = true;
        }

        equacao.setLength(0);
        operadores.clear();
        sinais.clear();
        permitirSinal = false;
        parentesesContador = 0;
        parentesesInterno = false;
        caixaEquacao.requestFocusInWindow();
    }

    //Integral
    private String modoIntegral;
    private int contadorParentesesIntDer;
    private boolean sinalIntDer;
    private boolean parentesesIntDer;
    private boolean xAnteriorIntDer;
    private int posicaoIntDer;
    private ArrayList<Integer> xPosicoesIntDer;
    private StringBuilder equacaoIntDer;
    private ArrayList<Double> operadoresAuxiliar;
    private ArrayList<String> operadoresIntDer;
    private ArrayList<String> sinaisIntDer;

    private String auxiliarNumero;

    //Geral
    private final int decimais;
    private String operadorFormatado;
    private final String vazio;

    private DecimalFormat formatador;

    private boolean permitirSinal;
    private boolean parentesesInterno;
    private boolean fimOperacao;

    private int parentesesContador;

    private ArrayList<String> sinais;
    private ArrayList<Double> operadores;

    private double resultado;
    private double operador;

    private StringBuilder equacao;

    //Composição
    private final CalculadoraDerivada calculadoraDerivada;
    private final CalculadoraIntegral calculadoraIntegral;
    private final CalculadoraAritmetica calculadora;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abreParentese;
    private javax.swing.JRadioButton area;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField caixaEquacao;
    private javax.swing.JTextField caixaResposta;
    private javax.swing.JButton constantesBotao;
    private javax.swing.JButton cosseno;
    private javax.swing.JButton derivada;
    private javax.swing.JButton divisao;
    private javax.swing.JButton eElevadoX;
    private javax.swing.JButton elevadoY;
    private javax.swing.JButton fechaParenteses;
    private javax.swing.JRadioButton graus;
    private javax.swing.JButton igual;
    private javax.swing.JButton integral;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton limparEquacao;
    private javax.swing.JButton logNeperiano;
    private javax.swing.JButton logX;
    private javax.swing.JButton mais;
    private javax.swing.JButton menos;
    private javax.swing.JButton mod;
    private javax.swing.JButton multiplicacao;
    private javax.swing.JRadioButton numerica;
    private javax.swing.JButton piBotao;
    private javax.swing.JButton quadrado;
    private javax.swing.JRadioButton radianos;
    private javax.swing.JButton raiz;
    private javax.swing.JButton resposta;
    private javax.swing.JButton seno;
    private javax.swing.JButton tangente;
    private javax.swing.JButton voltar;
    private javax.swing.JButton xCubo;
    // End of variables declaration//GEN-END:variables
}
