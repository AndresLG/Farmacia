package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import lombok.Data;

@Data
public class Conexion {

    public  Connection cn;

    public void Conectar() throws Exception {
        InputStream inputstream =
                Conexion.class.getClassLoader().getResourceAsStream("propiedades/properties.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputstream);
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String pwd = properties.getProperty("pwd");
            Class.forName(driver);
            cn = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return cn;
    }

    public void Desconectar() throws Exception {
        try {
            if (cn != null) {
                    cn.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
