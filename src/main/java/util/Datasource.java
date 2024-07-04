package util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datasource {
    private Connection con;
    private String url="jdbc:mysql://localhost:3306/salle de sport";
    private String login="root";
    private String pws="";

    private static Datasource instance;
    private Datasource(){
        try {
            con= DriverManager.getConnection(url,login,pws);
            System.out.println("Connection establi");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
    public static Datasource getInstance() {
        if (instance == null) {
            instance = new Datasource();

        }
        return instance;
    }

    public Connection getCon() {
        return con;
    }
    public void setCon(Connection con) {
        this.con = con;
    }


}
