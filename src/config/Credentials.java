package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Credentials {
  private static Credentials instance = null;
  
  private Properties p = null;
  private InputStream is = null;


  private Credentials(){
    setCredentials();
  }

  public static Credentials getInstance(){
    if(instance == null){
        instance = new Credentials();
    }
    return instance;
  }

  public void setCredentials(){
    try {
      p = new Properties();

      is = new FileInputStream("resources/config.properties");

      p.load(is);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String getDBUser(){
    return p.getProperty("db_user");
  }
  
  public String getDBPassword(){
    return p.getProperty("db_password");
  }
}
