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

/**
 *
 * @author Isaias
 */
public abstract class ConexaoBd {

    private Connection conexao;
    private String url = "jdbc:MySQL://localhost:3306/projeto";
    private String user = "root";
    private String pass = "root12345";
    Class<?> reflexion;

    public ConexaoBd() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, user, pass);
            /*
               PreparedStatement stmt = conexao.prepareStatement(script sql);
            ResultSet rs = stmt.executeQuery();
             */
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }

    public boolean create(Object obj, String entidade) {
        reflexion = obj.getClass();
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(entidade).append(" SET ");

        try {
            Field[] fields = reflexion.getDeclaredFields();

            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);

                sql.append(field.getName()).append(" = ");//pega o nome do atributo

                Object valor = field.get(obj);//pega o valor do atributo ^

                if (valor instanceof String) {
                    sql.append("'").append(valor).append("'");
                } else {
                    sql.append(valor);
                }

                if (i < fields.length - 1) {
                    sql.append(", ");
                }
            }

            System.out.println(sql.toString());
            Statement exeSql = conexao.prepareStatement(sql.toString());
            return true;
        } catch (IllegalAccessException | SQLException e) {
            System.out.println("Erro : " + e);

            return false;
        }
    }

    public <T> boolean update(String tipo, T obj, int id, String nomeCampoID) {
        reflexion = obj.getClass();
        HashMap<String, Integer> requisição_id = new HashMap<>();
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE " + tipo + " SET");
        try {

            Field[] fields = reflexion.getDeclaredFields();

            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);

                sql.append(field.getName()).append(" = ");

                Object valor = field.get(obj);

                if (valor instanceof String) {
                    sql.append("'").append(valor).append("'");
                } else {
                    sql.append(valor);
                }

                if (i < fields.length - 1) {
                    sql.append(", ");
                }
            }
            sql.append("WHERE " + nomeCampoID + " = ?");
            System.out.println(sql.toString());
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setInt(1, id);
            int retorno = stmt.executeUpdate();//retorna as linhas atualizadas
            System.out.println("===============================================");
            System.out.println("Retorno do metodo de atualização : " + retorno);
            return true;
        } catch (IllegalAccessException | SQLException e) {
            System.out.println("Erro : " + e);
            
        }
        return false;
    }

    public boolean delete(String tipo, String nomeCampoID, int id) {
        String sql = "DELETE FROM " + tipo + " WHERE codigo = " + nomeCampoID;
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
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
        String sql = "SELECT * FROM " + tabela;

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

   

}
