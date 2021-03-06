import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import config.ConnManager;
import models.RegistroDados;
import repositories.DadosDao;


public class App {

    public static void main(String[] args) throws Exception {
        
        DadosDao dadosDao = new DadosDao();
            
        dadosDao.insert(new RegistroDados(76f, 1.8f));
        dadosDao.insert(new RegistroDados(75f, 1.8f));
        dadosDao.insert(new RegistroDados(75f, 1.8f));
        dadosDao.insert(new RegistroDados(76f, 1.8f));

        List<RegistroDados> todosDados = dadosDao.getAll();

        Object[] arrayDados = todosDados.toArray();

        for(int i = 0; i < arrayDados.length; i++){
            System.out.println(arrayDados[i].toString());
        }

        System.out.println("uma query só: ");

        dadosDao.update(1, new RegistroDados(74f, 1.8f));

        RegistroDados registro = dadosDao.get(1);

        System.out.println(registro);

        dadosDao.delete(2);

        RegistroDados registroDeletado = dadosDao.get(2);

        System.out.println(registroDeletado);

        truncate();
    }

    public static void truncate (){
       try {
        Connection conn = ConnManager.getInstance().getConn();
        
        Statement stm = conn.createStatement();

        stm.executeUpdate("TRUNCATE TABLE T_DADOS");

        System.out.println("truncate ok");
       } catch(SQLException e) {
        System.out.println(e);
        e.getStackTrace();
       } catch (Exception e){
        e.printStackTrace();
    }
    }
}
