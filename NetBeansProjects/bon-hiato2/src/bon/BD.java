/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bon;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Statement;

/**
 *
 * @author yonay
 */

public class BD {
    Connection conect =null;
    public Connection conexion(){
        
        try {
            Class.forName("org.sqlite.JDBC");
            String filePath = new File("").getAbsolutePath();
            conect=DriverManager.getConnection("jdbc:sqlite:"+filePath+"\\DBBonHiato.db");
            return conect;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en conectar la base de datos"+e);
        }
        return null;
    }
}
