package GUI;

import calculadoracientifica.Calculadora;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Aritmetica extends javax.swing.JFrame {

    public Aritmetica() {
        this.sinaisIntegral = new ArrayList<>();
        this.operadoresIntegral = new ArrayList<>();
        this.equacaoIntegral = new StringBuilder();
        this.equacao = new StringBuilder();
        this.operadores = new ArrayList<>();
        initComponents();
        caixaEquacao.requestFocusInWindow();
        formatador.setDecimalSeparatorAlwaysShown(false);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        limite = new javax.swing.JButton();
        abreParentese = new javax.swing.JButton();
        fechaParenteses = new javax.swing.JButton();
        xCubo = new javax.swing.JButton();
        logX = new javax.swing.JButton();
        limparEquacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(491, 331));
        setResizable(false);
        setSize(new java.awt.Dimension(491, 331));

        caixaResposta.setEditable(false);

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

        limite.setText("LIMITE");

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
                        .addComponent(mais)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(multiplicacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(divisao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(limite))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(voltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resposta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(igual))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(quadrado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xCubo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(elevadoY)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(raiz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(derivada))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(eElevadoX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logNeperiano)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(abreParentese)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaParenteses))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(piBotao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cosseno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tangente)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(integral, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(limparEquacao, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(caixaEquacao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(caixaResposta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mais)
                    .addComponent(menos)
                    .addComponent(multiplicacao)
                    .addComponent(divisao)
                    .addComponent(limite)
                    .addComponent(mod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seno)
                    .addComponent(cosseno)
                    .addComponent(tangente)
                    .addComponent(integral)
                    .addComponent(piBotao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quadrado)
                    .addComponent(elevadoY)
                    .addComponent(raiz)
                    .addComponent(derivada)
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
                    .addComponent(igual))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void eventoPrimitivo(String sinal){
        caixaEquacao.requestFocusInWindow();          
        if(permitirSinal == false){
            operador = Double.parseDouble(caixaEquacao.getText());
            operadores.add(operador);
            caixaEquacao.setText("");
            operadorFormatado = formatador.format(operador);
            equacao.append(operadorFormatado).append(sinal);
            sinais.add(sinal);
        }else if(permitirSinal){
            equacao.append(sinal);
            sinais.add(sinal);
            permitirSinal = false;
        }
        caixaResposta.setText(equacao.toString());
    }
    
    private void eventoTRL(String sinal, String sinalExibido){
        caixaEquacao.requestFocusInWindow();
        equacao.append(sinalExibido).append("(");
        sinais.add(sinal);
        sinais.add("("); 
        caixaResposta.setText(equacao.toString());
        parentesesContador++;
        
        if(parentesesInterno==false)
            parentesesInterno = true;
    }
    
    private void eventoConstante(double constante, String nome){
        caixaEquacao.requestFocusInWindow();
        operadorFormatado = formatador.format(constante);
        if("Resultado".equals(nome))
            equacao.append(operadorFormatado);
        else
            equacao.append(nome);
        operadores.add(constante);
        caixaResposta.setText(equacao.toString());
        permitirSinal = true;
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
        eventoConstante(Math.PI, "PI");
    }//GEN-LAST:event_piBotaoMouseClicked

    private void senoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_senoMouseClicked
        eventoTRL("sen","seno");
    }//GEN-LAST:event_senoMouseClicked

    private void abreParenteseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abreParenteseMouseClicked
        caixaEquacao.requestFocusInWindow();
        if(!permitirSinal){
        equacao.append("(");
        sinais.add("(");
        caixaResposta.setText(equacao.toString());
        parentesesContador++;
        if(parentesesInterno==false)
            parentesesInterno = true;
        }
    }//GEN-LAST:event_abreParenteseMouseClicked

    private void fechaParentesesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaParentesesMouseClicked
        caixaEquacao.requestFocusInWindow();
        if(permitirSinal==false && parentesesInterno){
            if(")".equals(sinais.get(sinais.size()-1))){
                equacao.append(")");
                sinais.add(")");
                parentesesContador--;
                caixaResposta.setText(equacao.toString());
                permitirSinal = true;
            }else{
                operador = Double.parseDouble(caixaEquacao.getText());
                operadores.add(operador);
                caixaEquacao.setText("");
                equacao.append(operador).append(")");
                sinais.add(")");
                parentesesContador--;
                caixaResposta.setText(equacao.toString());
                permitirSinal = true;
            }
        }else if(permitirSinal && parentesesInterno){
            equacao.append(")");
            sinais.add(")");
            parentesesContador--;
            caixaResposta.setText(equacao.toString());
        }

        if(0>=parentesesContador)
            parentesesInterno = false;
    }//GEN-LAST:event_fechaParentesesMouseClicked

    private void cossenoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cossenoMouseClicked
        eventoTRL("cos","cosseno");
    }//GEN-LAST:event_cossenoMouseClicked

    private void tangenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tangenteMouseClicked
        eventoTRL("tg","tangente");
    }//GEN-LAST:event_tangenteMouseClicked

    private void raizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_raizMouseClicked
        eventoTRL("sqrt","raiz");
    }//GEN-LAST:event_raizMouseClicked

    private void quadradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quadradoMouseClicked
        caixaEquacao.requestFocusInWindow();
        if(permitirSinal == false){
            operador = Double.parseDouble(caixaEquacao.getText());
            operadores.add(operador);
            caixaEquacao.setText("");
            equacao.append(operador).append("^2");
            sinais.add("^");
            operadores.add(2.0);
        }else if(permitirSinal){
            equacao.append("^2");
            sinais.add("^");
            operadores.add(2.0);
        }
        
        permitirSinal = true;
        caixaResposta.setText(equacao.toString());
    }//GEN-LAST:event_quadradoMouseClicked

    private void elevadoYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_elevadoYMouseClicked
        caixaEquacao.requestFocusInWindow();
        if(permitirSinal == false){
            operador = Double.parseDouble(caixaEquacao.getText());
            operadores.add(operador);
            caixaEquacao.setText("");
            equacao.append(operador).append("^").append("(");
            sinais.add("(");
            sinais.add("^");
        }else if(permitirSinal){
            equacao.append("^").append("(");
            sinais.add("(");
            sinais.add("^");
            permitirSinal = false;
        }
        
        parentesesContador++;
        
        if(parentesesInterno==false)
            parentesesInterno = true;
        caixaResposta.setText(equacao.toString());
    }//GEN-LAST:event_elevadoYMouseClicked

    private void eElevadoXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eElevadoXMouseClicked
        caixaEquacao.requestFocusInWindow();
        equacao.append("e^").append("(");
        sinais.add("e^");
        sinais.add("("); 
        caixaResposta.setText(equacao.toString());
        
        parentesesContador++;
        
        if(parentesesInterno==false)
            parentesesInterno = true;
        if(permitirSinal)
            permitirSinal = false;
        
        caixaResposta.setText(equacao.toString());
    }//GEN-LAST:event_eElevadoXMouseClicked

    private void xCuboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xCuboMouseClicked
        caixaEquacao.requestFocusInWindow();
        if(permitirSinal == false){
            operador = Double.parseDouble(caixaEquacao.getText());
            operadores.add(operador);
            caixaEquacao.setText("");
            equacao.append(operador).append("^3");
            sinais.add("^");
            operadores.add(3.0);
        }else if(permitirSinal){
            equacao.append("^3");
            sinais.add("^");
            operadores.add(3.0);
        }
        
        permitirSinal = true;
        caixaResposta.setText(equacao.toString());
    }//GEN-LAST:event_xCuboMouseClicked

    private void logNeperianoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logNeperianoMouseClicked
        eventoTRL("ln","ln");
    }//GEN-LAST:event_logNeperianoMouseClicked

    private void logXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logXMouseClicked
        eventoTRL("log","log");
    }//GEN-LAST:event_logXMouseClicked

    private void integralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_integralMouseClicked
        boolean concluido = integralEquacao();
        if(concluido){
            equacao.append(resultado);
            operadores.add(resultado);
            caixaEquacao.requestFocusInWindow(); 
            caixaResposta.setText(equacao.toString());
            permitirSinal = true;
        }
    }//GEN-LAST:event_integralMouseClicked

    private void limparEquacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparEquacaoMouseClicked
        caixaEquacao.setText("");
        caixaResposta.setText("");
        equacao.setLength(0);
        operadores.clear();
        sinais.clear();
        permitirSinal = false;
        parentesesContador = 0;
        parentesesInterno = false;
        caixaEquacao.requestFocusInWindow();
    }//GEN-LAST:event_limparEquacaoMouseClicked

    private void respostaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_respostaMouseClicked
        eventoConstante(resultado, "Resultado");
    }//GEN-LAST:event_respostaMouseClicked

    private void igualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igualMouseClicked
        if(permitirSinal == false){
            operador = Double.parseDouble(caixaEquacao.getText());
            operadores.add(operador);
            caixaEquacao.setText("");
            equacao.append(operador);
        }else
            caixaEquacao.setText(""); 
        
        resultado = calculadora.interpretador(operadores, sinais);
        operadorFormatado = formatador.format(resultado);
        caixaResposta.setText(operadorFormatado);
        
        equacao.setLength(0);
        operadores.clear();
        sinais.clear();
        permitirSinal = false;
        parentesesContador = 0;
        parentesesInterno = false;
        caixaEquacao.requestFocusInWindow();
    }//GEN-LAST:event_igualMouseClicked

    private void voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseClicked
        dispose();
        TelaInicial escolha = new TelaInicial();
        escolha.setVisible(true);
    }//GEN-LAST:event_voltarMouseClicked
        
    private boolean integralEquacao(){
        JTextField field1 = new JTextField("");
        JTextField field2 = new JTextField("");
        JTextField field3 = new JTextField("");
        JTextField field4 = new JTextField("");
        
        Action action = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean sucesso = false;
                String atual = field3.getText();
                if(("+".equals(atual)||"-".equals(atual)||"*".equals(atual)||"/".equals(atual)||"^".equals(atual))&&sinalIntegral==false){
                    sinaisIntegral.add(atual);
                    sinalIntegral = true;
                    sucesso = true;
                }else if("(".equals(atual)&&sinalIntegral){
                    sinaisIntegral.add(atual);
                    if(parentesesIntegral == false)
                        parentesesIntegral = true;
                    contadorParentesesIntegral++;
                    sucesso = true;
                }else if("ln".equals(atual)||"sqrt".equals(atual)||"sen".equals(atual)||"cos".equals(atual)||"tg".equals(atual)||"log".equals(atual)){
                    sinaisIntegral.add(atual);
                    sinaisIntegral.add("(");
                    atual = atual.concat("(");
                    if(parentesesIntegral == false)
                        parentesesIntegral = true;
                    contadorParentesesIntegral++;
                    sucesso = true;
                }else if(parentesesIntegral && ")".equals(atual)){
                    sinaisIntegral.add(atual);
                    contadorParentesesIntegral--;
                    if(contadorParentesesIntegral <= 0)
                        parentesesIntegral = false;
                    if(sinalIntegral)
                        sinalIntegral = false;
                    sucesso = true;
                }else if((!")".equals(atual))&&(!"+".equals(atual))&&(!"-".equals(atual))&&(!"/".equals(atual))&&(!"*".equals(atual))&&(!"^".equals(atual))&&(!"(".equals(atual))){
                    operadoresIntegral.add(atual);
                    if(sinalIntegral)
                        sinalIntegral = false;
                    sucesso = true;
                }
   
                if(sucesso)
                    equacaoIntegral.append(atual);
                
                field3.setText("");
                field4.setText(equacaoIntegral.toString());
            }
        };
        
        field3.addActionListener(action);
        
        double limS, limI;
                
        JPanel integralPainel = new JPanel(new GridLayout(0, 1));
        integralPainel.add(new JLabel("Limite superior: "));
        integralPainel.add(field1);
        integralPainel.add(new JLabel("Limite inferior: "));
        integralPainel.add(field2);
        integralPainel.add(new JLabel("Função: "));
        integralPainel.add(field3);
        
        integralPainel.add(field4);
        field4.setEditable(false);
        
        int result = JOptionPane.showConfirmDialog(null, integralPainel, "Integral", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            limS = Double.parseDouble(field1.getText());
            limI = Double.parseDouble(field2.getText());
            if(limS == limI){
                resultado = 0;
                return true;
            }
            resultado = calculadora.integral(limS,limI,operadoresIntegral,sinaisIntegral);
            operadoresIntegral.clear();
            sinaisIntegral.clear();
            equacaoIntegral.setLength(0);
            parentesesIntegral = false;
            sinalIntegral = false;
            contadorParentesesIntegral = 0;
            return true;
        } else {
            operadoresIntegral.clear();
            sinaisIntegral.clear();
            equacaoIntegral.setLength(0);
            parentesesIntegral = false;
            sinalIntegral = false;
            contadorParentesesIntegral = 0;
            return false;
        }
    }
    
    //Integral
    private int contadorParentesesIntegral = 0;
    private boolean sinalIntegral = false;
    private boolean parentesesIntegral = false;
    @SuppressWarnings("FieldMayBeFinal")
    private StringBuilder equacaoIntegral;
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<String> operadoresIntegral;
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<String> sinaisIntegral;    
    
    //Geral
    String operadorFormatado;
    DecimalFormat formatador = new DecimalFormat();
    private boolean permitirSinal = false;
    private int parentesesContador = 0;
    private boolean parentesesInterno = false;
    
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<String> sinais = new ArrayList<>();
    
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<Double> operadores;
    
    private double resultado;
    private double operador;
    
    @SuppressWarnings("FieldMayBeFinal")
    private StringBuilder equacao;
    
    //Composição
    private final Calculadora calculadora = new Calculadora();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abreParentese;
    private javax.swing.JTextField caixaEquacao;
    private javax.swing.JTextField caixaResposta;
    private javax.swing.JButton cosseno;
    private javax.swing.JButton derivada;
    private javax.swing.JButton divisao;
    private javax.swing.JButton eElevadoX;
    private javax.swing.JButton elevadoY;
    private javax.swing.JButton fechaParenteses;
    private javax.swing.JButton igual;
    private javax.swing.JButton integral;
    private javax.swing.JButton limite;
    private javax.swing.JButton limparEquacao;
    private javax.swing.JButton logNeperiano;
    private javax.swing.JButton logX;
    private javax.swing.JButton mais;
    private javax.swing.JButton menos;
    private javax.swing.JButton mod;
    private javax.swing.JButton multiplicacao;
    private javax.swing.JButton piBotao;
    private javax.swing.JButton quadrado;
    private javax.swing.JButton raiz;
    private javax.swing.JButton resposta;
    private javax.swing.JButton seno;
    private javax.swing.JButton tangente;
    private javax.swing.JButton voltar;
    private javax.swing.JButton xCubo;
    // End of variables declaration//GEN-END:variables
}
