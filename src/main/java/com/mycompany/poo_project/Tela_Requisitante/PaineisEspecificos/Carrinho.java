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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
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
    private double valorTotal;
    private int quantidadeProd;
    public static List<Long> ids = new ArrayList<>();//public, pois é usado dentro de Visualização para receber os id dos pedidos
    private List<Produto> listaCarrinho = new ArrayList<>();//o retorno dos ids requisitados estão aqui em listaCarrinho 

    /**
     * Creates new form Carrinho1
     */
    public Carrinho() {
        
        initComponents();
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

    public void setListaCarrinho(Produto p) {
        this.listaCarrinho.add(p);
    }

    public static void setListaID(long id) {
        ids.add(id);
    }

    private void renderizandoDados() {

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        for (long l : ids) {
            Produto p = prod.requestID(l);
            this.setListaCarrinho(p);
            this.quantidadeProd = p.getQuantDisponivel();
            this.valorTotal = p.getValor();
            model.addRow(new Object[]{p.getId(), p.getNome(), p.getId_fornecedor(), p.getQuantDisponivel(), 0, p.getValor()});
            System.out.println("");
        }

    }

    /*private void renderizandoDados(List<Produto> prod) {
        for (Produto p : prod) {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.addRow(new Object[]{p.getId(), p.getNome(), p.getId_fornecedor(), p.getQuantDisponivel(), 0, p.getValor()});
            System.out.println("");

        }

    }

    private void renderizandoDados(Produto p) {//usado para mudar o valor do pedido
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
                    
                    int quantDesejada = Integer.parseInt(jTable2.getValueAt(row, 4).toString());

                    // Validação
                    if (quantDesejada < 0 || quantDesejada > quantidadeProd) {
                        JOptionPane.showMessageDialog(null, "Quantidade desejada inválida.");
                        jTable2.setValueAt(0, row, 4);
                        atualizandoLinha = false;
                        return;
                    }

                    // Atualiza "Quantidade Disponível"
                    int novaDisponivel = quantidadeProd - quantDesejada;
                    jTable2.setValueAt(novaDisponivel, row, 3);

                    // Atualiza "Valor"
                    double novoValor = valorTotal * quantDesejada;
                    jTable2.setValueAt(novoValor, row, 5);

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

        jInputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jInputSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(374, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jInputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jInputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PedidoDAO pediDAO = new PedidoDAO();
        HashMap<Integer, ProdutoDTO> lista_pedido = new HashMap<>();
        itensPedidoDAO ip = new itensPedidoDAO();
        Pedido pedido = new Pedido();
        for (int i = 0; i < listaCarrinho.size(); i++) {
            for (Produto p : listaCarrinho) {
            lista_pedido.put(pedido.getId_pedido(), new ProdutoDTO(p.getId(), Integer.parseInt(jTable2.getValueAt(i, 4).toString()),Double.parseDouble(jTable2.getValueAt(i, 5).toString())));
        }
        }
        
        ip.createItensPedido(lista_pedido);
        System.out.println("ItensPedido criado");
        System.out.println("id de quem fez login = " + RequisitanteLogin.getId());
        pedido.setId_requisitante(RequisitanteLogin.getId());
pedido.setLista_pedido(lista_pedido);//preciso gerenciar como o funcionario vai entrar nessa jogada
        System.out.println("criado pedido no banco");
        //percorre tabela para somar o total do pedido
         int totalRows = jTable2.getRowCount();
         for (int i = 0; i < totalRows; i++) {
             valorTotal+=Integer.parseInt(jTable2.getValueAt(5, i).toString());
            
        }
        pediDAO.createPedido(pedido,valorTotalCal);


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
                resultados = prod.searchID(listaCarrinho, pesquisa);
            } else if (pesquisa.matches("[A-Za-z]+")) {
                resultados = prod.searchNome(listaCarrinho, pesquisa);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jInputSearch;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
