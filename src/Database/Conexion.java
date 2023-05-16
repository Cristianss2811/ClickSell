/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

//import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;


/**
 *
 * @author crist
 */
public class Conexion {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver", URL = "jdbc:mysql://localhost:3306/", DB = "PAPELERIAYOLIS", USER = "root", PASSWORD = "FieBEJjZY5>Q";
    public Connection cadena;
    public static Conexion instancia;
    

    private Conexion() {
        this.cadena = null;
    }

    public Connection Conectar() {
        try {
            Class.forName(DRIVER);
            this.cadena = DriverManager.getConnection(URL + DB, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
        return this.cadena;
    }

    public void Desconectar() {
        try {
            this.cadena.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Conexion getInstance()
    {
        if(instancia==null)
            instancia = new Conexion();
        return instancia;
    }
}
