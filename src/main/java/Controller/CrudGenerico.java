
package Controller;

import Model.Funcionario;
import Model.Produto;
import Model.Requisitante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;

/**
 *
 * @author Isaias
 */

public abstract class CrudGenerico {
    private Connection conexao = ConexaoSingleton.getInstancia().getConexao();
    

    public <T> boolean create(T obj, String tabela) {
    Field[] fields = obj.getClass().getDeclaredFields();
    String sql = new String();
    StringJoiner colunas = new StringJoiner(", ");
    StringJoiner valores = new StringJoiner(", ");

    for (Field f : fields) {
        colunas.add(f.getName());
        valores.add("?");
    }
        switch (tabela) {
            case "Fornecedor":
            case "Requisitante":
            case "Pedido":
            case "Produto":
                         sql="INSERT INTO " + tabela + " (" + colunas + ") VALUES (" + valores + ")";
                break;
            default:
                throw new IllegalArgumentException("Tabela inválida!");
        }

    
    try (PreparedStatement ps = conexao.prepareStatement(sql)) {
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            ps.setObject(i + 1, fields[i].get(obj)); // JDBC faz o escape
        }
        int linhas = ps.executeUpdate();
        return linhas == 1;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}


    public <T> boolean update(String tabela, T obj, int id, String nomeCampoID) {
        Field[] fields = obj.getClass().getDeclaredFields();
    List<String> colunas = new ArrayList<>();
     List<String> valores = new ArrayList<>();

    for (Field f : fields) {
        colunas.add(f.getName());
        valores.add("?");
    }
        StringBuilder sql = new StringBuilder();
         switch (tabela) {
            case "Fornecedor":
            case "Requisitante":
            case "Pedido":
            case "Produto":
                        sql.append("UPDATE " + tabela + " SET ");
                        for (int cont1 = 0; cont1 < colunas.size(); cont1++) {
                           
                                sql.append(colunas.get(cont1)).append("=").append(valores.get(cont1));//faz a linha coluna = ?,...                          
                                if (cont1 < colunas.size() - 1) {
        sql.append(", "); // adiciona vírgula só se não for o último
    }
                            
                }
                        sql.append(" WHERE "+nomeCampoID+" = ?");
                break;
            default:
                 throw new IllegalArgumentException("Tabela inválida!");
        }
        
         try( PreparedStatement ps = conexao.prepareStatement(sql.toString())) {
               for (int i = 0; i < fields.length; i++) {//esse for é para substituir ? pelo valor
            fields[i].setAccessible(true);
            ps.setObject(i + 1, fields[i].get(obj)); // JDBC faz o escape
        }
               ps.setInt(fields.length+1, id);
             return ps.executeUpdate() > 0;
        } catch (Exception e) {
             System.out.println("============================================");
             System.out.println("Erro : "+e);
        }
         return false;
       

    }

    public boolean delete(String tabela, String nomeCampoID, int id) {
        StringBuilder sql = new StringBuilder();
        List<String> tabelasValidas = List.of("Fornecedor", "Requisitante", "Pedido", "Produto");

        if (tabelasValidas.contains(tabela)) {
            sql.append("DELETE FROM " + tabela + " WHERE "+nomeCampoID+" =  ?");
        } else {
            throw new IllegalArgumentException("Tabela inválida!");
        }                        
        try (PreparedStatement ps = conexao.prepareStatement(sql.toString())){
            ;
            ps.setInt(1, id);
            System.out.println("===============================================");
            System.out.println("Dado removido do banco");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro : " + e);

        }
        return false;

    }

    public <T> List<T> readAll(String tabela, MontadorReadAll<T> montador) {//<T> → indica que esse método é genérico, e List<T> é o que será retornado
        List<T> lista = new ArrayList<>();
        List<String> tabelasValidas = List.of("Fornecedor", "Requisitante", "Pedido", "Produto");
         String sql;
        if (tabelasValidas.contains(tabela)) {
            sql = "SELECT * FROM "+tabela ;
        } else {
            throw new IllegalArgumentException("Tabela inválida!");
        }
        

        try {
            PreparedStatement script = conexao.prepareStatement(sql);
            ResultSet rs = script.executeQuery();

            while (rs.next()) {
                T obj = montador.montar(rs);
                lista.add(obj);
            }

            rs.close();
            script.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
   public <T> T searchID(List<T> lista, String nomeCampoId, long id) {
    for (T item : lista) {
        try {
            Field campo = item.getClass().getDeclaredField(nomeCampoId);
            campo.setAccessible(true);
            Object valor = campo.get(item);

            if (valor instanceof Long && ((Long) valor).longValue() == id) {
                return item;
            } else if (valor instanceof Integer && ((Integer) valor).longValue() == id) {
                return item;
            } else if (valor instanceof Long && valor.equals(id)) {
                return item;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return null;
}
    /*public <T> T requestID(String id) {
        
    }*/
   
 


   

}
