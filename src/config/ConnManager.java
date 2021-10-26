package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnManager {
  private static ConnManager instance;

  private ConnManager(){}

  public static ConnManager getInstance(){
    if(instance == null){
      instance = new ConnManager();
    }
    return instance;
  }
  
  public Connection getConn(){
    Connection conn = null;
    Credentials c = Credentials.getInstance();

    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
            
        conn =
        DriverManager.getConnection("jdbc:mysql://localhost:3306/health_track?" +
                                    "user=" +
                                    c.getDBUser() +
                                    "&password=" +
                                    c.getDBPassword());
     
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
