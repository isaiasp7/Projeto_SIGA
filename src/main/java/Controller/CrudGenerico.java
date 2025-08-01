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
import java.lang.reflect.InvocationTargetException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        sql = "INSERT INTO " + tabela + " (" + colunas + ") VALUES (" + valores + ")";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                ps.setObject(i + 1, fields[i].get(obj)); // JDBC faz o escape
            }
            ;
            return ps.executeUpdate() > 0; // retorna true se pelo menos 1 linha foi inserida

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public <T> boolean update(String tabela, T obj, int id, String nomeCampoID) {
        Field[] fields = obj.getClass().getDeclaredFields();
        List<String> colunas = new ArrayList<>();
        List<String> valores = new ArrayList<>();

        List<Field> camposValidos = new ArrayList<>();

        for (Field f : fields) {
            try {
                f.setAccessible(true);
                if (!f.getName().equals(nomeCampoID) && !f.getName().equals("lista_pedido")) {
                    Object value = f.get(obj);
                    if (value != null && !value.toString().isEmpty()) {
                        colunas.add(f.getName());
                        valores.add("?");
                        camposValidos.add(f);
                    }

                }

            } catch (IllegalAccessException | IllegalArgumentException e) {
                System.out.println("ERRO update laco: " + e);
                break;
            }
        }

        System.out.println("colunas {");
        for (String coluna : colunas) {
            System.out.println(coluna);
        }
        System.out.println("}");

        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE " + tabela + " SET ");
        for (int cont1 = 0; cont1 < colunas.size(); cont1++) {

            sql.append(colunas.get(cont1)).append("=").append(valores.get(cont1));//faz a linha coluna = ?,...                          
            if (cont1 < colunas.size() - 1) {
                sql.append(", "); // adiciona vírgula só se não for o último
            }

        }
        sql.append(" WHERE " + nomeCampoID + " = ?");

        try (PreparedStatement ps = conexao.prepareStatement(sql.toString())) {
            for (int i = 0; i < camposValidos.size(); i++) {
                camposValidos.get(i).setAccessible(true);
                ps.setObject(i + 1, camposValidos.get(i).get(obj)); // JDBC index starts at 1
            }

// último parâmetro: o ID (WHERE cláusula)
            ps.setObject(camposValidos.size() + 1, id);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("============================================");
            System.out.println("Erro update: " + e);
        }
        return false;

    }

    public boolean delete(String tabela, String nomeCampoID, int id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM " + tabela + " WHERE " + nomeCampoID + " =  ?");

        try (PreparedStatement ps = conexao.prepareStatement(sql.toString())) {
            ps.setInt(1, id);
            ps.execute();
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

        try (PreparedStatement script = conexao.prepareStatement(sql)) {
            try (ResultSet rs = script.executeQuery()) {
                System.out.println("===========================");
                System.out.println("requisição feita");
                while (rs.next()) {
                    T obj = montador.montar(rs);

                    lista.add(obj);
                }
            }
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

    public <T> T requestById(String tableName, String idColumn, Integer id, MontadorReadAll<T> montador) {
        String sql = "SELECT * FROM " + tableName + " WHERE " + idColumn + "= ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return montador.montar(rs); // usa a função montadora
                } else {
                    return null; // ou lançar exceção
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
