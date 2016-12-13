/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scm;

import bon.BD;
import developer.Identificador;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import javax.swing.JOptionPane;
import java.time.*;
import javax.swing.JTextField;

/**
 *
 * @author yonay
 */
public class CreateSprint extends javax.swing.JFrame {

    /**
     * Creates new form CreateSprint
     */
    BD bd = new BD();
    Connection connection = bd.conexion();
    IdentificadorSprint identificador;
    private int id=0;
    private String proj;
    private String developer2;
    DateFormat df= DateFormat.getDateInstance();
    public CreateSprint() {
        initComponents();
    }
    public CreateSprint(String project,String dev){
        initComponents();
        proj=project;
        developer2=dev;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from sprint");
            while(rs.next()){
                id=Integer.parseInt(rs.getString("id"));
            }
            identificador = new IdentificadorSprint(id);
        }catch(SQLException e){
            System.out.println("no se pudo acceder");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createSprintName = new javax.swing.JLabel();
        createSprintFechaIni = new javax.swing.JLabel();
        accCreateSprint = new javax.swing.JButton();
        canCreateSprint = new javax.swing.JButton();
        nameCreateSprint = new javax.swing.JTextField();
        fechaIniCreateSprint = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scrum master - Crear sprint");

        createSprintName.setText("SprintName");

        createSprintFechaIni.setText("Fecha de inicio");

        accCreateSprint.setText("Crear");
        accCreateSprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accCreateSprintActionPerformed(evt);
            }
        });

        canCreateSprint.setText("Cancelar");
        canCreateSprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canCreateSprintActionPerformed(evt);
            }
        });

        fechaIniCreateSprint.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(canCreateSprint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(accCreateSprint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createSprintFechaIni)
                            .addComponent(createSprintName, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameCreateSprint, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(fechaIniCreateSprint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(createSprintName)
                .addGap(5, 5, 5)
                .addComponent(nameCreateSprint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createSprintFechaIni)
                .addGap(18, 18, 18)
                .addComponent(fechaIniCreateSprint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(accCreateSprint)
                .addGap(18, 18, 18)
                .addComponent(canCreateSprint)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accCreateSprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accCreateSprintActionPerformed
        // TODO add your handling code here:
        String fecha = ((JTextField)fechaIniCreateSprint.getDateEditor().getUiComponent()).getText();
        if(nameCreateSprint.getText().equals("") || fecha.equals("")){
            JOptionPane.showMessageDialog(null, "Se deben rellenar todos los campos.");
        }else{
            try{
                String query = " insert into sprint (id, name, duration, fechaini, fechafin, project)"
                + " values (?, ?, ?, ?, ?, ?)";
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, identificador.getId());
                preparedStmt.setString(2, nameCreateSprint.getText());
                preparedStmt.setInt(3, 0);
                preparedStmt.setString(4,((JTextField)fechaIniCreateSprint.getDateEditor().getUiComponent()).getText());
                preparedStmt.setString(5,"0000-00-00" );
                preparedStmt.setString(6, proj);
                // execute the preparedstatement
                preparedStmt.execute();

            }catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null, e);
            }
            Gestion ges = new Gestion(proj,developer2);
            ges.setLocationRelativeTo(null);
            ges.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_accCreateSprintActionPerformed

    private void canCreateSprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canCreateSprintActionPerformed
        // TODO add your handling code here:
        Gestion ges = new Gestion(proj,developer2);
        ges.setLocationRelativeTo(null);
        ges.setVisible(true);
        dispose();
    }//GEN-LAST:event_canCreateSprintActionPerformed

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
            java.util.logging.Logger.getLogger(CreateSprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateSprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateSprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateSprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateSprint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accCreateSprint;
    private javax.swing.JButton canCreateSprint;
    private javax.swing.JLabel createSprintFechaIni;
    private javax.swing.JLabel createSprintName;
    private com.toedter.calendar.JDateChooser fechaIniCreateSprint;
    private javax.swing.JTextField nameCreateSprint;
    // End of variables declaration//GEN-END:variables
}
