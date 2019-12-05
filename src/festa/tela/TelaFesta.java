/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festa.tela;

import festa.Usuario;
import festa.dao.ClienteDAO;
import festa.dao.FestaDAO;
import festa.dao.TemaDAO;
import festa.entidade.Cliente;
import festa.entidade.Festa;
import festa.entidade.Tema;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class TelaFesta extends javax.swing.JFrame {

    DefaultTableModel modelo;
    DefaultTableModel modelo1;
    DefaultTableModel modelo2;
    Usuario user;
    Festa festa;

    /**
     * Creates new form TelaFesta
     */
    public TelaFesta(Usuario user) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        modelo = (DefaultTableModel) jTable1.getModel();

        jFrame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jFrame1.setLocationRelativeTo(null);
        modelo1 = (DefaultTableModel) jTable2.getModel();

        jFrame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jFrame2.setLocationRelativeTo(null);
        modelo2 = (DefaultTableModel) jTable3.getModel();

        jFrame3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jFrame3.setLocationRelativeTo(null);

        setTitle("Listar festas");
        this.user = user;

        if (!user.isCadastrarFesta()) {
            jButton5.setVisible(false);
            jButton6.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jTextField8 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jFrame2 = new javax.swing.JFrame();
        jTextField9 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jFrame3 = new javax.swing.JFrame();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();

        jFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jFrame1.getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 280, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jFrame1.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 37, 280, 275));

        jFrame2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jFrame2.getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 280, -1));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Tema", "Nome Tema"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        jFrame2.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 37, 280, 275));

        jFrame3.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane5.setViewportView(jTextArea2);

        jFrame3.getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 480, -1));

        jLabel8.setText("Insira seu comentário:");
        jFrame3.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton9.setText("Confirmar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jFrame3.getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        jButton10.setText("Cancelar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jFrame3.getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        jButton1.setText("  Limpar   ");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setText("  Sair   ");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jLabel1.setText("Nº Festa");

        jLabel2.setText("Valor da Festa");

        jLabel3.setText("Cliente");

        jTextField3.setEditable(false);

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.setAutoscrolls(false);
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        jButton3.setText("🔍");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Tema");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setEditable(false);

        jButton4.setText("🔍");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        jLabel5.setText("Cidade");

        jLabel6.setText("Endereço");

        jLabel7.setText("Data da Festa");

        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextArea1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jLabel10.setText("Comentário:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Aberto", "Pago", "Entregue", "Fechado", "Cancelado" }));

        jLabel11.setText("Status");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Festa", "Cliente", "Tema", "Data", "Valor", "Status"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton5.setText("Cadastrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Editar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Consulta Geral");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Consultar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Matutino");

        jCheckBox2.setText("Vespertino");

        jCheckBox3.setText("Noturno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(258, 258, 258)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10))
                            .addComponent(jScrollPane1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox2)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jCheckBox3))))
                        .addGap(0, 54, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // BOTAO LIMPAR
        modelo.setNumRows(0);
        limparCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // BOTAO SAIR
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
        // CAMPO CPF
        if (jFormattedTextField1.getText().length() != 14) {
            jTextField3.setText("");
        } else {
            ClienteDAO dao = new ClienteDAO();
            Cliente cliente = dao.getClienteCpf(jFormattedTextField1.getText());
            jTextField3.setText(cliente.getNome());
        }
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // BOTAO BUSCAR CLIENTE
        jFrame1.setSize(316, 358);
        jFrame1.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
        // CAMPO TEMA
        if (jTextField4.getText().isEmpty()) {
            jTextField5.setText("");
        } else {
            TemaDAO dao = new TemaDAO();
            Tema tema = dao.getTema(Integer.parseInt(jTextField4.getText()));

            jTextField5.setText(tema.getNome());

        }
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        // BOTAO BUSCAR TEMA
        jFrame2.setSize(316, 358);
        jFrame2.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        // BOTAO CADASTRAR
        try {
            String valor = jTextField2.getText(); //VALOR DA FESTA
            String cpf = jFormattedTextField1.getText(); // CPF CLIENTE
            String numeroTema = jTextField4.getText(); // NUMERO TEMA
            String data = jFormattedTextField2.getText().trim(); // DATA FESTA

            if (jTextField1.getText().isEmpty()) {
                ClienteDAO cdao = new ClienteDAO();
                TemaDAO tdao = new TemaDAO();
                if (validar()) {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date datas = format.parse(jFormattedTextField2.getText());
                    Festa festa = new Festa();
                    festa.set(Double.parseDouble(valor),
                            cdao.getClienteCpf(cpf),
                            tdao.getTema(Integer.parseInt(numeroTema)),
                            (String) jComboBox1.getSelectedItem(),
                            jTextField6.getText(),
                            jTextField7.getText(),
                            new java.sql.Date(datas.getTime()),
                            jCheckBox1.isSelected(),
                            jCheckBox2.isSelected(),
                            jCheckBox3.isSelected(),
                            1,
                            jTextArea1.getText());
                    FestaDAO fdao = new FestaDAO();
                    fdao.adicionarFesta(festa);
                    limparCampos();
                    JOptionPane.showMessageDialog(null, "Festa adicionado com sucesso");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível cadastrar cliente, campo ID preenchido");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        // BOTAO EDITAR
        try {
            String idFesta = jTextField1.getText(); //ID DA FESTA
            String valor = jTextField2.getText(); //VALOR DA FESTA
            String cpf = jFormattedTextField1.getText(); // CPF CLIENTE
            String numeroTema = jTextField4.getText(); // NUMERO TEMA
            String data = jFormattedTextField2.getText().trim(); // DATA FESTA

            if (!idFesta.isEmpty()) {

                if (festa.getStatus() < 4) {
                    ClienteDAO cdao = new ClienteDAO();
                    TemaDAO tdao = new TemaDAO();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date datas = format.parse(jFormattedTextField2.getText());
                    if (validar() && validarStatus()) {
                        festa.set(Double.parseDouble(valor),
                                cdao.getClienteCpf(cpf),
                                tdao.getTema(Integer.parseInt(numeroTema)),
                                (String) jComboBox1.getSelectedItem(),
                                jTextField6.getText(),
                                jTextField7.getText(),
                                new java.sql.Date(datas.getTime()),
                                jCheckBox1.isSelected(),
                                jCheckBox2.isSelected(),
                                jCheckBox3.isSelected(),
                                jComboBox2.getSelectedIndex(),
                                jTextArea1.getText());
                        FestaDAO fdao = new FestaDAO();
                        fdao.alterarFesta(festa);
                        limparCampos();
                        JOptionPane.showMessageDialog(null, "Festa alterada com sucesso");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Festa já finalizada, não é possível alterar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Necessário selecionar uma linha");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        // BOTAO CONSULTA GERAL
        if (!jTextField1.getText().isEmpty()) {
            new TelaConsulta(festa).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Necessário selecionar uma linha");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        // BOTAO CONSULTAR
        try {
            ArrayList<Festa> festas = new ArrayList<>();
            FestaDAO dao = new FestaDAO();
            modelo.setNumRows(0);
            String idFesta = jTextField1.getText();
            String cpf = jFormattedTextField1.getText();
            String status = (String) jComboBox2.getSelectedItem();
            if (!idFesta.isEmpty()) {
                //this.festa = dao.getFesta(Integer.parseInt(idFesta));
                //festas.add(festa);
            } else if (cpf.trim().length() == 14 || !status.equals("-")) {
                //festas = dao.consultarFestas(cpf, status);
            } else {
                festas = dao.listarFestas();
            }
            festas = dao.listarFestas();
            for (Festa lfesta : festas) {
                Object[] dados = {lfesta.getIdFesta(), lfesta.getCliente().getNome(),
                    lfesta.getTema().getNome(), lfesta.getDataFesta(), lfesta.getValor(),
                    jComboBox2.getItemAt(lfesta.getStatus())};
                modelo.addRow(dados);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            int idFesta = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            FestaDAO dao = new FestaDAO();
            festa = dao.getFesta(idFesta);

            jTextField1.setText(String.valueOf(festa.getIdFesta())); //NUMERO DA FESTA
            jTextField2.setText(String.valueOf(festa.getValor())); //VALOR DA FESTA
            jFormattedTextField1.setText(festa.getCliente().getCpf()); // CPF CLIENTE
            jTextField3.setText(festa.getCliente().getNome()); //NOME CLIENTE
            jTextField4.setText(String.valueOf(festa.getTema().getIdTema())); // NUMERO TEMA
            jTextField5.setText(festa.getTema().getNome()); // NOME TEMA
            jComboBox1.setSelectedItem(festa.getEstado()); // ESTADO
            jTextField6.setText(festa.getCidade()); // CIDADE
            jTextField7.setText(festa.getLogradouro()); //LOGRADOURO
            jFormattedTextField2.setText(String.valueOf(festa.getDataFesta())); //DATA FESTA
            jCheckBox1.setSelected(festa.isMatutino());// MATUTINO
            jCheckBox2.setSelected(festa.isVespertino()); // VESPERTINO
            jCheckBox3.setSelected(festa.isNoturno());// NOTURNO
            jComboBox2.setSelectedItem(jComboBox2.getItemAt(festa.getStatus()));// STATUS
            jTextArea1.setText(festa.getComentario()); //DESCRICAO
            jTextField1.setEditable(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
        ClienteDAO dao = new ClienteDAO();
        ArrayList<Cliente> clientes = dao.consultarClientes(jTextField8.getText());
        for (Cliente cliente : clientes) {
            Object[] dados = {cliente.getCpf(), cliente.getNome()};
            modelo1.addRow(dados);
        }
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        jFormattedTextField1.setText((String) jTable2.getValueAt(jTable2.getSelectedRow(), 0));
        jTextField3.setText((String) jTable2.getValueAt(jTable2.getSelectedRow(), 1));
        jTextField8.setText("");
        modelo1.setNumRows(0);
        jFrame1.dispose();
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
        TemaDAO dao = new TemaDAO();
        ArrayList<Tema> temas = dao.consultarTemas(jTextField9.getText());
        for (Tema tema : temas) {
            Object[] dados = {tema.getIdTema(), tema.getNome()};
            modelo2.addRow(dados);
        }
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        jTextField4.setText("" + jTable3.getValueAt(jTable3.getSelectedRow(), 0));
        jTextField5.setText((String) jTable3.getValueAt(jTable3.getSelectedRow(), 1));
        jTextField9.setText("");
        modelo2.setNumRows(0);
        jFrame2.dispose();
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTextArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseClicked
        // TODO add your handling code here:
        jFrame3.setSize(520, 220);
        jFrame3.setVisible(true);
    }//GEN-LAST:event_jTextArea1MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        jTextArea1.setText(jTextArea1.getText() + user.getNome() + " - ID: " + user.getIdUsuario()
                + ":\n" + jTextArea2.getText() + "\n\n");
        jTextArea2.setText("");
        jFrame3.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        jFrame3.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void limparCampos() {
        jTextField1.setText(""); //NUMERO DA FESTA
        jTextField2.setText(""); //VALOR DA FESTA
        jFormattedTextField1.setValue(null); // CPF CLIENTE
        jTextField3.setText(""); //NOME CLIENTE
        jTextField4.setText(""); // NUMERO TEMA
        jTextField5.setText(""); // NOME TEMA
        jComboBox1.setSelectedItem("-"); // ESTADO
        jTextField6.setText(""); // CIDADE
        jTextField7.setText(""); //LOGRADOURO
        jFormattedTextField2.setValue(null); //DATA FESTA
        jCheckBox1.setSelected(false);// MATUTINO
        jCheckBox2.setSelected(false); // VESPERTINO
        jCheckBox3.setSelected(false);// NOTURNO
        jComboBox2.setSelectedItem("-"); // STATUS
        jTextArea1.setText(""); //DESCRICAO
        jTextField1.setEditable(true);
    }

    private boolean validar() {
        boolean result = true;
        if (jTextField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencher o campo 'Valor'");
            result = false;
        } else if (jTextField3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencher o campo 'CPF'");
            result = false;
        } else if (jTextField5.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencher o campo 'Nº do tema'");
            result = false;
        } else if (jFormattedTextField2.getText().trim().length() != 10) {
            JOptionPane.showMessageDialog(null, "Preencher o campo 'data'");
            result = false;
        } else if (jComboBox2.getSelectedItem().equals("-")) {
            JOptionPane.showMessageDialog(null, "Selecionar o status da festa");
            result = false;
        } else if (!jCheckBox1.isSelected() && !jCheckBox2.isSelected() && !jCheckBox3.isSelected()) {
            JOptionPane.showMessageDialog(null, "Preencher pelo menos um dos turnos da festa");
            result = false;
        }
        return result;
    }

    private boolean validarStatus() {
        int combo = jComboBox2.getSelectedIndex();
        if (festa.getStatus() == (combo)) {
            return true;
        } else {
            if (combo == 5) {
                jTextArea1.setText(jTextArea1.getText() + user.getNome() + "- ID: " + user.getIdUsuario()
                        + ":\n--- Festa Cancelada ----");
                return true;
            } else {
                if (festa.getStatus() == (combo - 1)) {
                    switch (combo) {
                        case 2:
                            jTextArea1.setText(jTextArea1.getText() + user.getNome() + " - ID: " + user.getIdUsuario()
                                    + ":\n--- Feito Pagamento ----\n\n");
                            break;

                        case 3:
                            jTextArea1.setText(jTextArea1.getText() + user.getNome() + " - ID: " + user.getIdUsuario()
                                    + ":\n--- Feito Entrega ----\n\n");
                            break;

                        case 4:
                            jTextArea1.setText(jTextArea1.getText() + user.getNome() + " - ID: " + user.getIdUsuario()
                                    + ":\n--- Finalizado Festa ----");
                            break;
                    }
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Programação de status inválida");
                    return false;
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
