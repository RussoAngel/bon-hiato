/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scm;

import bon.BD;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import po.ProductBacklog;

/**
 *
 * @author yonay
 */
public class SelectTask extends javax.swing.JFrame {

    /**
     * Creates new form UpdateTask
     */
    BD bd = new BD();
    Connection connection = bd.conexion();
    public String proy;
    
    List<String> tareas = new ArrayList<>();
    private String developer2;
    public SelectTask() {
        initComponents();
    }
    public SelectTask(String project,String dev){
        initComponents();
        developer2=dev;
        proy= project;
        titleSelecTask.setText(proy);
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from task");
            
            while(rs.next()){
                
                if(rs.getString("Projects").equals(proy)){
                    tareas.add(rs.getString("name"));
                }
            }
            if(tareas.size()>0){
                String[] mylist = new String[tareas.size()];
                mylist = tareas.toArray(mylist);
                tasksListSelecTask.setListData(mylist);
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

        titleSelecTask = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        tasksListSelecTask = new javax.swing.JList<>();
        updateSelecTask = new javax.swing.JButton();
        canSelecTask = new javax.swing.JButton();
        remSelecTask = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bon-Hiato");
        setPreferredSize(new java.awt.Dimension(300, 300));
        setResizable(false);

        titleSelecTask.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleSelecTask.setText("Proyecto Actual");

        scroll.setViewportView(tasksListSelecTask);

        updateSelecTask.setText("Actualizar Tarea");
        updateSelecTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSelecTaskActionPerformed(evt);
            }
        });

        canSelecTask.setText("Cancelar");
        canSelecTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canSelecTaskActionPerformed(evt);
            }
        });

        remSelecTask.setText("Eliminar Tarea");
        remSelecTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remSelecTaskActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleSelecTask)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateSelecTask, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(remSelecTask, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(canSelecTask, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(titleSelecTask)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(updateSelecTask)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remSelecTask)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(canSelecTask))
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateSelecTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSelecTaskActionPerformed
        // TODO add your handling code here:
        String tasks = tasksListSelecTask.getSelectedValue();
        if(tasks == null){
            JOptionPane.showMessageDialog(null, "Seleccione una tarea.");
        }else{
            UpdateTask updateTask = new UpdateTask(proy,tasks,developer2);
            updateTask.setLocationRelativeTo(null);
            updateTask.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_updateSelecTaskActionPerformed

    private void canSelecTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canSelecTaskActionPerformed
        // TODO add your handling code here:
        Gestion gestion = new Gestion(proy,developer2);
        gestion.setLocationRelativeTo(null);
        gestion.setVisible(true);
        dispose();
    }//GEN-LAST:event_canSelecTaskActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        // TODO add your handling code here:
        
                      
    }//GEN-LAST:event_RemoveActionPerformed

    private void remSelecTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remSelecTaskActionPerformed
        // TODO add your handling code here:
        try{
            String query = " DELETE FROM task WHERE name = ?";
            
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1, tasksListSelecTask.getSelectedValue());
        preparedStmt.execute();
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
        SelectTask select = new SelectTask(proy,developer2);
        select.setLocationRelativeTo(null);
        select.setVisible(true);
        dispose();
    }//GEN-LAST:event_remSelecTaskActionPerformed

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
            java.util.logging.Logger.getLogger(SelectTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectTask().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton canSelecTask;
    private javax.swing.JButton remSelecTask;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JList<String> tasksListSelecTask;
    private javax.swing.JLabel titleSelecTask;
    private javax.swing.JButton updateSelecTask;
    // End of variables declaration//GEN-END:variables
}
