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
    private double valorProduto;
    private int quantidadeTotalProd;
    private int quantDesejadaProd;
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
        if (ids.size()>0) {
             for (long l : ids) {
            Produto p = prod.requestID(l);
            this.setListaCarrinho(new ProdutoDTO(p));
            this.quantidadeTotalProd = p.getQuantDisponivel();
            this.valorProduto = p.getValor();
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

    private void reescreveValores() {
        jTable2.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE && !atualizandoLinha) {
                atualizandoLinha = true;

                int row = e.getFirstRow();
                int colunaAlterada = e.getColumn();

                // Só reage quando a coluna "Quantidade Desejada" for alterada
                if (colunaAlterada == 4) {
                    try {
                        // Pega os valores da linha
                        int idProduto = (int) jTable2.getValueAt(row, 0);
                        quantDesejadaProd = Integer.parseInt(jTable2.getValueAt(row, 4).toString());
                        

                        // Validação
                        if (quantDesejadaProd < 0 || quantDesejadaProd > quantidadeTotalProd) {
                            JOptionPane.showMessageDialog(null, "Quantidade desejada inválida.");
                            jTable2.setValueAt(0, row, 4);
                            atualizandoLinha = false;
                            return;
                        }

                        // Atualiza "Quantidade Disponível"
                        int novaDisponivel = quantidadeTotalProd - quantDesejadaProd;
                        jTable2.setValueAt(novaDisponivel, row, 3);

                        // Atualiza "Valor"
                        double novoValor = valorProduto * quantDesejadaProd;
                        jTable2.setValueAt(novoValor, row, 5);
                        //atualiza valores da listaCarrinho
                        for (ProdutoDTO produto : listaCarrinho) {
                            if (produto.getProd().getId() == idProduto) {
                                produto.setQuantidadeDesejada(quantDesejadaProd);
                                produto.getProd().setQuantDisponivel(novaDisponivel);
                                break;
                            }
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Erro ao processar os valores.");
                    }

                }

                atualizandoLinha = false;
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

        setMinimumSize(new java.awt.Dimension(872, 557));
        setPreferredSize(new java.awt.Dimension(848, 659));

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

        jButton1.setText("Fazer Pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
        jLabel1.setText("Carrinho de compras");

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
                .addGap(267, 267, 267)
                .addComponent(jLabel1)
                .addContainerGap(273, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jInputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jInputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //1 criar pedido 
        //2 relacionar itenspedido com pedido
        //3 atualizar o qunatidade disponivel de produtos com o uso de produtoDTO

        //percorre tabela para somar o total do pedido
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

        

    }//GEN-LAST:event_jButton1ActionPerformed


    private void jInputSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jInputSearchKeyReleased
        // TODO add your handling code here:
        ProdutoDAO prod = new ProdutoDAO();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        String pesquisa = jInputSearch.getText();
        List<Produto> resultados = new ArrayList<>();
        if (pesquisa.isBlank()) {
            model.setRowCount(0);
            this.renderizandoDados();
        } else {
            model.setRowCount(0);
            if (pesquisa.matches("[1-9][0-9]*")) {
                resultados = prod.searchIDdto(listaCarrinho, pesquisa);
            } else if (pesquisa.matches("[A-Za-z]+")) {
                resultados = prod.searchNomedto(listaCarrinho, pesquisa);
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
        jInputSearch.setForeground(Color.BLACK);
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
