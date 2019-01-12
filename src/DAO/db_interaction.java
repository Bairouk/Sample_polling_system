package DAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class db_interaction {

    static String url="jdbc:mysql://localhost:8889/poll";
    static Connection conn;
    static Statement st;

    public static Connection connection(){

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            //etablir la connection
            conn = DriverManager.getConnection(url,"root","");

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;

    }


    public static void connect()
    {
        //chargement du pilot
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //etablir la connection
            conn = DriverManager.getConnection(url,"root","");
            //preparation d instruction
            st = conn.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
