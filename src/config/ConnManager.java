package config;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManager {
  private static ConnManager instance;

  private ConnManager(){}

  public static ConnManager getInstance(){
    if(instance == null){
      instance = new ConnManager();
    }
    return instance;
  }
  
  public Connection getConn() throws Exception{
    Connection conn = null;

    Properties p = new Properties();

    InputStream is = new FileInputStream("resources/config.properties");
    
    p.load(is);

    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
            
        conn =
        DriverManager.getConnection("jdbc:mysql://localhost:3306/health_track?" +
                                    "user=" +
                                    p.getProperty("db_user") +
                                    "&password=" +
                                    p.getProperty("db_password"));
     
    } catch(SQLException e) {
      System.out.println(e);
      e.printStackTrace();
    } catch(ClassNotFoundException e){
      System.out.println(e);
      e.printStackTrace();
    }
    return conn;
  }
}
