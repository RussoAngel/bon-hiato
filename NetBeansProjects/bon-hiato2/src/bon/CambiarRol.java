/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bon;

import developer.Task;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import po.ProductBacklog;

/**
 *
 * @author yonay
 */
public class CambiarRol extends javax.swing.JFrame {

    /**
     * Creates new form CambiarRol
     */
    BD bd = new BD();
    Connection connection = bd.conexion();
    private String develop;
    private String password;
    private String type;
    String[] deve;
    private boolean isSm=false;

    public CambiarRol() {
        initComponents();
    }
    public CambiarRol(String dev){
        develop=dev;
        initComponents();
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from login");
            deve=develop.split(" ");
            
                while(rs.next()){
                    if(rs.getString("name").equals(deve[0])){
                        password=rs.getString("password");
                        type=rs.getString("type");
                    }
                    if(rs.getString("type").equals("scrumMaster")){
                        isSm=true;
                    }
                    
                }
                name.setText(develop);
            
            
        }catch(Exception e){
            System.out.println("Error al acceder a db");
        }
        System.out.println(type);
        System.out.println(password);
        System.out.println(deve[0]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cambiarRolPassToEdit = new javax.swing.JLabel();
        passCambiarRol = new javax.swing.JPasswordField();
        canCambiarRol = new javax.swing.JButton();
        cambiarRolTitle = new javax.swing.JLabel();
        despedirCambiarRol = new javax.swing.JButton();
        degradarCambiarRol = new javax.swing.JButton();
        ascenderCambiarRol = new javax.swing.JButton();
        name = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bon-Hiato");

        cambiarRolPassToEdit.setText("Contraseña admin");

        canCambiarRol.setText("Cancelar");
        canCambiarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canCambiarRolActionPerformed(evt);
            }
        });

        cambiarRolTitle.setText("Cambiar Rol");

        despedirCambiarRol.setText("Despedir");
        despedirCambiarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                despedirCambiarRolActionPerformed(evt);
            }
        });

        degradarCambiarRol.setText("Degradar");
        degradarCambiarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degradarCambiarRolActionPerformed(evt);
            }
        });

        ascenderCambiarRol.setText("Ascender");
        ascenderCambiarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ascenderCambiarRolActionPerformed(evt);
            }
        });

        name.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(cambiarRolPassToEdit)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passCambiarRol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(canCambiarRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(despedirCambiarRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(degradarCambiarRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ascenderCambiarRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cambiarRolTitle)
                                    .addGap(37, 37, 37)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cambiarRolTitle)
                .addGap(16, 16, 16)
                .addComponent(name)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cambiarRolPassToEdit)
                    .addComponent(passCambiarRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(ascenderCambiarRol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(degradarCambiarRol)
                .addGap(12, 12, 12)
                .addComponent(despedirCambiarRol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(canCambiarRol)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void canCambiarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canCambiarRolActionPerformed
        // TODO add your handling code here:
        Personal personal = new Personal();
        personal.setLocationRelativeTo(null);
        personal.setVisible(true);
        dispose();
    }//GEN-LAST:event_canCambiarRolActionPerformed

    private void despedirCambiarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_despedirCambiarRolActionPerformed
        // TODO add your handling code here:
        if(String.valueOf(passCambiarRol.getPassword()).equals("1234")){
            int respuesta=JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres despedir a esta persona?");
            if(respuesta==0){
                      
            
                try{
                    String query = "DELETE FROM login WHERE name = ?";

                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, deve[0]);
                preparedStmt.execute();
                }catch(SQLException | HeadlessException e){
                    JOptionPane.showMessageDialog(null, e);
                }
                Personal pr = new Personal();
                pr.setLocationRelativeTo(null);
                pr.setVisible(true);
                dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Introduzca la contraseña de admin correctamente");
        }
        
    }//GEN-LAST:event_despedirCambiarRolActionPerformed

    private void degradarCambiarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degradarCambiarRolActionPerformed
        // TODO add your handling code here:
        if(String.valueOf(passCambiarRol.getPassword()).equals("1234")){
            if(type.equals("scrumMaster")){
                try {

                    String sql = "UPDATE login set password='"+password+"',type='"
                    +"developer"+"' where name='"
                    +deve[0]+"'";
                PreparedStatement pst=connection.prepareStatement(sql);
                pst.execute();

                } catch (SQLException | HeadlessException e){
                    JOptionPane.showMessageDialog(null, e);
                }
                Personal pr = new Personal();
                pr.setLocationRelativeTo(null);
                pr.setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "No puedes degradar a un developer");
                CambiarRol cambiarRol = new CambiarRol(develop);
                cambiarRol.setLocationRelativeTo(null);
                cambiarRol.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Introduzca la contraseña de admin correctamente");
            CambiarRol cambiarRol = new CambiarRol(develop);
            cambiarRol.setLocationRelativeTo(null);
            cambiarRol.setVisible(true);
        }
    }//GEN-LAST:event_degradarCambiarRolActionPerformed

    private void ascenderCambiarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ascenderCambiarRolActionPerformed
        // TODO add your handling code here:
        System.out.println(type);
        if(String.valueOf(passCambiarRol.getPassword()).equals("1234")){
            if(isSm== true){
                JOptionPane.showMessageDialog(null, "Ya hay un scrumMaster Registrado");
                CambiarRol cambiarRol = new CambiarRol(develop);
                cambiarRol.setLocationRelativeTo(null);
                cambiarRol.setVisible(true);
                dispose();
            }else if(type.equals("developer")){
                try {

                    String sql = "UPDATE login set password='"+password+"',type='"
                    +"scrumMaster"+"' where name='"
                    +deve[0]+"'";
                PreparedStatement pst=connection.prepareStatement(sql);
                pst.execute();

                } catch (SQLException | HeadlessException e){
                    JOptionPane.showMessageDialog(null, e);
                }
                Personal pr = new Personal();
                pr.setLocationRelativeTo(null);
                pr.setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "No puedes ascender a un scrumMaster");
                CambiarRol cambiarRol = new CambiarRol(develop);
                cambiarRol.setLocationRelativeTo(null);
                cambiarRol.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Introduzca la contraseña de admin correctamente");
            CambiarRol cambiarRol = new CambiarRol(develop);
            cambiarRol.setLocationRelativeTo(null);
            cambiarRol.setVisible(true);
        }
    }//GEN-LAST:event_ascenderCambiarRolActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CambiarRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CambiarRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CambiarRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CambiarRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CambiarRol().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ascenderCambiarRol;
    private javax.swing.JLabel cambiarRolPassToEdit;
    private javax.swing.JLabel cambiarRolTitle;
    private javax.swing.JButton canCambiarRol;
    private javax.swing.JButton degradarCambiarRol;
    private javax.swing.JButton despedirCambiarRol;
    private javax.swing.JLabel name;
    private javax.swing.JPasswordField passCambiarRol;
    // End of variables declaration//GEN-END:variables
}
