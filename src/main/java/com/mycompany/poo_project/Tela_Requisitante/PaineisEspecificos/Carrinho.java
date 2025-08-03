/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.poo_project.Tela_Requisitante.PaineisEspecificos;

import DAO.PedidoDAO;
import DAO.ProdutoDAO;
import DAO.itensPedidoDAO;
import DTO.ProdutoDTO;
import Login.RequisitanteLogin;
import Model.Pedido;
import Model.Produto;
import Model.itensPedido;
import java.awt.Color;

import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Isaias
 */
public class Carrinho extends javax.swing.JPanel {

    private ProdutoDAO prod = new ProdutoDAO();
    private double valorTotalCal;//usado para calcular os valores de cada produto
    public static List<Integer> ids = new ArrayList<>();//public, pois é usado dentro de Visualização para receber os id dos pedidos
    private List<ProdutoDTO> listaCarrinho = new ArrayList<>();//o retorno dos ids requisitados estão aqui em listaCarrinho 

    /**
     * Creates new form Carrinho1
     */
    public Carrinho() {

        initComponents();
        jInputSearch.setText("Search....");
        jInputSearch.setForeground(new Color(124, 124, 124));
        this.renderizandoDados();
        this.reescreveValores();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplica o centralizador a todas as colunas
        for (int i = 0; i < jTable2.getColumnCount(); i++) {
            jTable2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTable2.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

    }

    public void setListaCarrinho(ProdutoDTO p) {
       
        this.listaCarrinho.add(p);
    }

    public static void setListaID(int id) {
        ids.add(id);
    }

    public List<Integer> getIds() {
        return ids;
    }

    private void renderizandoDados() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        listaCarrinho.clear();
        if (ids.size() > 0) {
            for (Integer l : ids) {
                Produto p = prod.requestIdProduto(l);
                this.setListaCarrinho(new ProdutoDTO(p));
                //this.quantidadeTotalProd = p.getQuantDisponivel();
                //this.valorProduto = p.getValor();
                //System.out.println("A quantidade disponivel do produto(" + p.getNome() + ") é : " + p.getQuantDisponivel());
                model.addRow(new Object[]{p.getId(), p.getNome(), p.getId_fornecedor(), p.getQuantDisponivel(), 0, p.getValor()});

            }
        }

    }

    private void renderizandoDados(List<ProdutoDTO> prod) {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for (ProdutoDTO p : prod) {
            model.addRow(new Object[]{p.getProd().getId(), p.getProd().getNome(), p.getProd().getId_fornecedor(), p.getProd().getQuantDisponivel(), 0, p.getProd().getValor()});

        }

    }

    /*private void renderizandoDados(Produto p) {//usado para mudar o valor do pedido
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.addRow(new Object[]{p.getId(), p.getNome(), p.getId_fornecedor(), p.getQuantDisponivel(), 0, p.getValor()});
        System.out.println("");

    }*/
    private boolean atualizandoLinha = false;

private void reescreveValores() {//me responsabilizo por 60% desse metodo
    int[] quantTotalAntigas = new int[listaCarrinho.size()];
    double[] valorProdutos = new double[listaCarrinho.size()];
    for (int cont = 0; cont < listaCarrinho.size(); cont++) {
        quantTotalAntigas[cont] = listaCarrinho.get(cont).getProd().getQuantDisponivel();
        valorProdutos[cont] = listaCarrinho.get(cont).getProd().getValor();
    }

    jTable2.getModel().addTableModelListener(e -> {
        if (e.getType() == TableModelEvent.UPDATE && !atualizandoLinha) {
            try {
                atualizandoLinha = true;
                int row = e.getFirstRow();
                int column = e.getColumn();
                
                // Verifica se é a coluna de quantidade desejada
                if (column != 4) return; // assumindo que a coluna de quantidade é a 2

                Integer quantDesejada = (Integer) jTable2.getValueAt(row, column);
                System.out.println("valor alterado:" + quantDesejada);
                
                if (quantDesejada > 0) {
                    ProdutoDTO produtoDTO = listaCarrinho.get(row); // A linha corresponde ao índice
                    Produto p = produtoDTO.getProd();
                    
                    // Calcula a diferença em relação ao valor anterior
                    int diferenca = quantDesejada - produtoDTO.getQuantidadeDesejada();
                    
                    if (p.getQuantDisponivel() - diferenca < 0) {
                        JOptionPane.showMessageDialog(null, "Quantidade indisponível em estoque.");
                        jTable2.setValueAt(produtoDTO.getQuantidadeDesejada(), row, column);
                        return;
                    }
                    
                    p.setQuantDisponivel(p.getQuantDisponivel() - diferenca);
                    //p.setValor();
                    
                    jTable2.setValueAt(p.getValor() * quantDesejada / Math.max(1, produtoDTO.getQuantidadeDesejada()), row, column + 1);//essas IA são o bixo
                    jTable2.setValueAt(p.getQuantDisponivel(), row, column - 1);
                    produtoDTO.setQuantidadeDesejada(quantDesejada);
                } else {
                    JOptionPane.showMessageDialog(null, "Os valores precisam ser maiores que 0\n e não conter caracteres especiais.");
                    jTable2.setValueAt(0, row, column);
                    jTable2.setValueAt(quantTotalAntigas[row], row, column - 1);
                    jTable2.setValueAt(valorProdutos[row], row, column + 1);
                    
                }
            } finally {
                atualizandoLinha = false;
            }
        }
    });
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jInputSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(7, 23, 57));
        setMinimumSize(new java.awt.Dimension(872, 557));
        setPreferredSize(new java.awt.Dimension(825, 659));

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "ID Fornecedor", "Quantidade Disponivel", "Quantidade Desejada", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Fazer Pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jInputSearch.setBackground(new java.awt.Color(0, 0, 0));
        jInputSearch.setForeground(new java.awt.Color(255, 255, 255));
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Carrinho de compras");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Delete um produto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jInputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(304, 304, 304)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jInputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(jButton1)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean validaCamposUpdate() {
        // boolean listaAtualizada = false;//verifica se todos os valores desejado estão realmente alterados
        for (ProdutoDTO produtoDTO : listaCarrinho) {
            if (produtoDTO.getQuantidadeDesejada() <= 0) {
                return false;
            }
        }
        return true;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //1 criar pedido 
        //2 relacionar itenspedido com pedido
        //3 atualizar o qunatidade disponivel de produtos com o uso de produtoDTO

        //percorre tabela para somar o total do pedido
        if (validaCamposUpdate()) {
            int totalRows = jTable2.getRowCount();
            for (int i = 0; i < totalRows; i++) {
                valorTotalCal += Double.parseDouble(jTable2.getValueAt(i, 5).toString());

            }
            System.out.println("total a ser pago no pedido = " + valorTotalCal);

            Pedido pedido = new Pedido(RequisitanteLogin.getId(), listaCarrinho, valorTotalCal);

            new PedidoDAO().createPedido(pedido);
            System.out.println("criou pedido no banco");
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), "Pedido feito (Identificador do pedido : " + pedido.getId_pedido() + ")");
            //s

            for (ProdutoDTO produtoDTO : listaCarrinho) {
                new itensPedidoDAO().createItensPedido(new itensPedido(pedido.getId_pedido(), produtoDTO.getProd().getId(), produtoDTO.getQuantidadeDesejada()));
            }
            System.out.println("itens pedido criado no banco");
            //3

            for (ProdutoDTO produtoDTO : listaCarrinho) {//ainda não funciona
                System.out.println(listaCarrinho);
                new ProdutoDAO().updateProduto(produtoDTO.getProd(), produtoDTO.getProd().getId());
            }
            System.out.println("dados de produtos atualizado no banco");
        } else {
            JOptionPane.showMessageDialog(null, "nenhum campo de quantidade desejada pode ser 0",
                    "alert", JOptionPane.ERROR_MESSAGE);
        }

          DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        ids.clear();
    }//GEN-LAST:event_jButton1ActionPerformed


    private void jInputSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jInputSearchKeyReleased
        // TODO add your handling code here:
        //  ProdutoDAO prod = new ProdutoDAO();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        String pesquisa = jInputSearch.getText();
       
        List<ProdutoDTO> resultados = new ArrayList<>();
        if (pesquisa.isBlank()) {
            model.setRowCount(0);
            this.renderizandoDados();
        } else {
            model.setRowCount(0);
            if (pesquisa.matches("[1-9][0-9]*")) {
                resultados = prod.searchIDdto(listaCarrinho, pesquisa);
            } else if (pesquisa.matches("[A-Za-z]+")) {
                resultados = prod.searchNomedto(listaCarrinho, pesquisa.toLowerCase());
               
            } else {

                JOptionPane.showMessageDialog(null, "Nenhum dado com esse identificador");
                jInputSearch.setText("");
                this.renderizandoDados();
            }
        }
        if (!resultados.isEmpty()) {
            System.out.println("renderizando");
            for (ProdutoDTO p : resultados) {
                 System.out.println(resultados.size());
                model.addRow(new Object[]{p.getProd().getId(), p.getProd().getNome(), p.getProd().getId_fornecedor(), p.getProd().getQuantDisponivel(),0,p.getProd().getValor()});
            }
        }
    }//GEN-LAST:event_jInputSearchKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String[] idDelete = JOptionPane.showInputDialog("Digite o id do produto:").split(",");
        for (int cont = 0; cont < listaCarrinho.size(); cont++) {
            for (String prodId : idDelete) {
                System.out.print("ID = ");
                System.out.println(prodId);

                if (listaCarrinho.get(cont).getProd().getId().equals(Integer.parseInt(prodId)) && ids.get(cont).equals(Integer.parseInt(prodId))) {
                    listaCarrinho.remove(cont);
                    ids.remove(cont);
                }
            }
        }

        this.renderizandoDados(listaCarrinho);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jInputSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInputSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jInputSearchActionPerformed

    private void jInputSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jInputSearchFocusGained
        // TODO add your handling code here:
        jInputSearch.setText("");
        jInputSearch.setForeground(Color.WHITE);
    }//GEN-LAST:event_jInputSearchFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField jInputSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

}
