
package mack.br.lab_dao.persistencia;
import mack.br.lab_dao.entidades.contas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class contasDaoMySQL implements contasDAO {
    private String createSQL = "INSERT INTO contas VALUES (?,?)";
    private String readSQL = "SELECT * FROM contas";
    private String updateSQL = "UPDATE contas SET saldo=? WHERE idconta = ?";
    private String deleteSQL = "DELETE FROM contas WHERE idconta=?";
    
    private final MySQLConnection mysql = new MySQLConnection();
    
    @Override
    public boolean create (contas conta){
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(createSQL);
            
            stm.setString(1, conta.getIdconta());
            stm.setInt(2, conta.getSaldo());
            
            
            int registros= stm.executeUpdate();
            
            return registros> 0? true : false;
            
        }catch(final SQLException ex){
            System.out.println("Falha de conexão com a base de dados");
            ex.printStackTrace();
        }catch(final Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                conexao.close();
            }catch(final Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    @Override
    public List<contas> read(){
        Connection conexao = mysql.getConnection();
        List<contas> conta = new ArrayList(); 
        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                contas contaU = new contas();
                contaU.setIdconta(rs.getString("idconta"));
                contaU.setSaldo(rs.getInt("saldo"));
                conta.add(contaU);
            }
            return conta;
        }catch(final SQLException ex){
            System.out.println("Falha de conexão com a base de dados");
            ex.printStackTrace();
        }catch(final Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                conexao.close();
            }catch(final Exception ex){
                ex.printStackTrace();
            }
        }
        return conta;
    }
    
    @Override
    public boolean update (contas conta){
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(updateSQL);
            
            stm.setInt(1, conta.getSaldo());
            stm.setString(2, conta.getIdconta());
            
            int registros = stm.executeUpdate();
            return registros > 0? true: false;
            
        }catch(final SQLException ex){
            System.out.println("Falha de conexão com a base de dados");
            ex.printStackTrace();
        }catch (final Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                conexao.close();
            }catch (final Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(contas conta){
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);
            
            stm.setString(1, conta.getIdconta());
            
            int registros = stm.executeUpdate();
            
            return registros > 0? true:false;
        }catch (final SQLException ex){
            System.out.println("Falha de conexão com a base de dados");
            ex.printStackTrace();
        
        }catch(final Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                conexao.close();
            } catch(final Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }
}
