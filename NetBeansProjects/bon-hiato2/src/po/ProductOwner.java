package po;

import bon.BD;
import bon.Login;
import developer.Developer;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yonay
 */
public class ProductOwner extends javax.swing.JFrame {

    /**
     * Creates new form ProductOwner
     */
    BD bd = new BD();
    Connection connection = bd.conexion();
    private String develop;
    public ProductOwner() {
        initComponents();
    }
    public ProductOwner(String deve){
        initComponents();
        develop=deve;
        jLabel1.setText("<Html>Logueado como: <br>"+develop+"</Html>");
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from projects");
            while(rs.next()){
                projectProductOwner.add(rs.getString("name"));
            }
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

        productOwnerSelector = new javax.swing.JLabel();
        logoutProductOwner = new javax.swing.JButton();
        projectProductOwner = new java.awt.Choice();
        selectProductOwner = new javax.swing.JButton();
        newProductOwner = new javax.swing.JButton();
        remProductOwner = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bon-Hiato");

        productOwnerSelector.setText("Bon Hiato-Project Selection");

        logoutProductOwner.setText("Log Out");
        logoutProductOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutProductOwnerActionPerformed(evt);
            }
        });

        selectProductOwner.setText("Seleccionar Proyecto");
        selectProductOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectProductOwnerActionPerformed(evt);
            }
        });

        newProductOwner.setText("Crear Proyecto");
        newProductOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProductOwnerActionPerformed(evt);
            }
        });

        remProductOwner.setText("Borrar Proyecto");
        remProductOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remProductOwnerActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(logoutProductOwner)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(remProductOwner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newProductOwner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectProductOwner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(projectProductOwner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productOwnerSelector))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutProductOwner)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(productOwnerSelector)
                .addGap(30, 30, 30)
                .addComponent(projectProductOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(selectProductOwner)
                .addGap(18, 18, 18)
                .addComponent(newProductOwner)
                .addGap(18, 18, 18)
                .addComponent(remProductOwner)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectProductOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectProductOwnerActionPerformed
        // TODO add your handling code here:
        String choice=projectProductOwner.getSelectedItem();
        ProductBacklog productBacklog = new ProductBacklog(choice,develop); 
        productBacklog.setLocationRelativeTo(null);
        productBacklog.setVisible(true);
        dispose();
    }//GEN-LAST:event_selectProductOwnerActionPerformed

    private void newProductOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProductOwnerActionPerformed
        // TODO add your handling code here:
        CreateProject createProject = new CreateProject(develop);
        createProject.setLocationRelativeTo(null);
        createProject.setVisible(true);
        dispose();
    }//GEN-LAST:event_newProductOwnerActionPerformed

    private void logoutProductOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutProductOwnerActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutProductOwnerActionPerformed

    private void remProductOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remProductOwnerActionPerformed
        // TODO add your handling code here:
        int respuesta=JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres eliminar esta tarea?");
        if(respuesta==0){
            try{
                String query = " DELETE FROM projects WHERE name = ?";

                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, projectProductOwner.getSelectedItem());
                preparedStmt.execute();
            }catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null, e);
            }
            ProductOwner productOwner = new ProductOwner(develop);
            productOwner.setLocationRelativeTo(null);
            productOwner.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_remProductOwnerActionPerformed

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
            java.util.logging.Logger.getLogger(ProductOwner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductOwner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductOwner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductOwner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductOwner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutProductOwner;
    private javax.swing.JButton newProductOwner;
    private javax.swing.JLabel productOwnerSelector;
    private java.awt.Choice projectProductOwner;
    private javax.swing.JButton remProductOwner;
    private javax.swing.JButton selectProductOwner;
    // End of variables declaration//GEN-END:variables
}
