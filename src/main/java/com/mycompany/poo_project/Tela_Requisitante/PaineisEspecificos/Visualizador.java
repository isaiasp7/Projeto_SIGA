/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.poo_project.Tela_Requisitante.PaineisEspecificos;

import DAO.ProdutoDAO;
import Model.Produto;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Isaias
 */
public class Visualizador extends javax.swing.JPanel {

    ProdutoDAO produto = new ProdutoDAO();
    List<Produto> lista = new ArrayList<>();

    /**
     * Creates new form Visualizador1
     */
    public Visualizador() {
        initComponents();
        jInputSearch.setText("Search....");
         jInputSearch.setForeground(new Color(124, 124, 124));
        this.renderizandoDados();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplica o centralizador a todas as colunas
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jInputSearch = new javax.swing.JTextField();
        AdicionarCar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(872, 659));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "ID Fornecedor"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setDoubleBuffered(true);
        jTable1.setRequestFocusEnabled(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jInputSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jInputSearchFocusGained(evt);
            }
        });
        jInputSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInputSearchActionPerformed(evt);
            }
        });
        jInputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jInputSearchKeyReleased(evt);
            }
        });

        AdicionarCar.setText("Adicionar ao carrinho");
        AdicionarCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarCarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Produtos Disponiveis");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(AdicionarCar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jInputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(270, 270, 270))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdicionarCar)
                    .addComponent(jInputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void renderizandoDados() {
        long id;
        String nome;
        long id_f;
        //int quant;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        lista = produto.readProduto();
        for (Produto prod1 : lista) {
            id = prod1.getId();
            nome = prod1.getNome();
            id_f = prod1.getId_fornecedor();
            //quant = prod1.getQuantDisponivel();
            model.addRow(new Object[]{id, nome, id_f});

        }
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        //JOptionPane.s
    }//GEN-LAST:event_jTable1MouseClicked

    private void jInputSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInputSearchActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jInputSearchActionPerformed

    private void jInputSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jInputSearchKeyReleased
        // TODO add your handling code here:
        ProdutoDAO prod = new ProdutoDAO();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String pesquisa = jInputSearch.getText();
        List<Produto> resultados = new ArrayList<>();
        if (pesquisa.isBlank()) {
            model.setRowCount(0);
            this.renderizandoDados();
        } else {
            model.setRowCount(0);
            if (pesquisa.matches("[1-9][0-9]*")) {
                resultados = prod.searchID(lista, pesquisa);
            } else if (pesquisa.matches("[A-Za-z]+")) {
                resultados = prod.searchNome(lista, pesquisa);
            } else {

                JOptionPane.showMessageDialog(null, "Nenhum dado com esse identificador");
                jInputSearch.setText("");
                this.renderizandoDados();
            }
        }
        if (resultados.size() > -1) {
            for (Produto p : resultados) {
                model.addRow(new Object[]{p.getId(), p.getNome(), p.getId_fornecedor(), p.getQuantDisponivel()});
            }
        }

    }//GEN-LAST:event_jInputSearchKeyReleased

    private void AdicionarCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarCarActionPerformed
        // TODO add your handling code here:
        //Carrinho.setLista( jTable1.getSelectedRow().);
        Integer linha = jTable1.getSelectedRow();
        System.out.println(" linha = "+linha);
        if (linha!=-1) {
              Produto p = new Produto(
                    Integer.parseInt(jTable1.getValueAt(linha, 0).toString()),
                    jTable1.getValueAt(linha, 1).toString(),
                    Integer.parseInt(jTable1.getValueAt(linha, 2).toString())
            );
            
            
            new Carrinho().setListaID(p.getId());
            System.out.println("add ao carrinho : "+p.getId());
           
        }else{
           JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada",
                    "alerta", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }//GEN-LAST:event_AdicionarCarActionPerformed

    private void jInputSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jInputSearchFocusGained
        // TODO add your handling code here:
         jInputSearch.setText("");
         jInputSearch.setForeground(Color.BLACK);
    }//GEN-LAST:event_jInputSearchFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarCar;
    private javax.swing.JTextField jInputSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
