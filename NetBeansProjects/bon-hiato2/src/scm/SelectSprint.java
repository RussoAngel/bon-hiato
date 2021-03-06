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

/**
 *
 * @author yonay
 */
public class SelectSprint extends javax.swing.JFrame {

    /**
     * Creates new form VisualizarSprint
     */
    private String proj;
    BD bd = new BD();
    Connection connection = bd.conexion();
    
    
    List<String> sprint = new ArrayList<>();
    private String developer;
    public SelectSprint() {
        initComponents();
    }
    
    public SelectSprint(String project,String dev){
        proj=project;
        developer=dev;
        initComponents();
        selecSprintLab.setText("<Html> Proyecto: "+proj+"<br> Ventana: Sprints</Html>");
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from sprint");
            
            while(rs.next()){
                System.out.println(rs.getString("project"));
                System.out.println(proj);
                if(rs.getString("project").equals(proj)){
                    sprint.add(rs.getString("name"));
                }
            }
            if(sprint.size()>0){
                String[] mylist = new String[sprint.size()];
                mylist = sprint.toArray(mylist);
                sprintsListSelecSprint.setListData(mylist);
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

        selecSprintLab = new javax.swing.JLabel();
        viewSelecSprint = new javax.swing.JButton();
        canSelecSprint = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        sprintsListSelecSprint = new javax.swing.JList<>();
        addTaskSelecSprint = new javax.swing.JButton();
        remSelecSprint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bon-Hiato");
        setPreferredSize(new java.awt.Dimension(400, 400));
        setResizable(false);

        selecSprintLab.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        selecSprintLab.setText("Project-Sprints");

        viewSelecSprint.setText("Visualizar");
        viewSelecSprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSelecSprintActionPerformed(evt);
            }
        });

        canSelecSprint.setText("Cancelar");
        canSelecSprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canSelecSprintActionPerformed(evt);
            }
        });

        scroll.setViewportView(sprintsListSelecSprint);

        addTaskSelecSprint.setText("Añadir tarea");
        addTaskSelecSprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskSelecSprintActionPerformed(evt);
            }
        });

        remSelecSprint.setText("Eliminar Sprint");
        remSelecSprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remSelecSprintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(selecSprintLab, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(remSelecSprint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viewSelecSprint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addTaskSelecSprint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(canSelecSprint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(selecSprintLab)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(viewSelecSprint)
                        .addGap(5, 5, 5)
                        .addComponent(addTaskSelecSprint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remSelecSprint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(canSelecSprint))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void canSelecSprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canSelecSprintActionPerformed
        // TODO add your handling code here:
        Gestion gestion = new Gestion(proj,developer);
        gestion.setLocationRelativeTo(null);
        gestion.setVisible(true);
        dispose();
    }//GEN-LAST:event_canSelecSprintActionPerformed

    private void viewSelecSprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSelecSprintActionPerformed
        // TODO add your handling code here:
        String sprints = sprintsListSelecSprint.getSelectedValue();
        if(sprints == null){
            JOptionPane.showMessageDialog(null, "Seleccione un sprint.");
        }else{
            Visualizar visualizar = new Visualizar(proj,sprints,developer);
            visualizar.setLocationRelativeTo(null);
            visualizar.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_viewSelecSprintActionPerformed

    private void addTaskSelecSprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTaskSelecSprintActionPerformed
        // TODO add your handling code here:
        String selec = sprintsListSelecSprint.getSelectedValue();
        if(selec == null){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un sprint para añadir tareas.");
        }else{
            AddTaskIntoSprint addTask = new AddTaskIntoSprint(proj,selec,developer);
            addTask.setLocationRelativeTo(null);
            addTask.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_addTaskSelecSprintActionPerformed

    private void remSelecSprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remSelecSprintActionPerformed
        // TODO add your handling code here:
        if(sprintsListSelecSprint.getSelectedValue() == null){
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un sprint para borrar.");
        }else{
            int respuesta=JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres eliminar este sprint?");
            if(respuesta==0){
                try{
                    String query = " DELETE FROM sprint WHERE name = ?";

                    PreparedStatement preparedStmt = connection.prepareStatement(query);
                    preparedStmt.setString(1, sprintsListSelecSprint.getSelectedValue());
                    preparedStmt.execute();
                }catch(SQLException | HeadlessException e){
                    JOptionPane.showMessageDialog(null, e);
                }
                SelectSprint select = new SelectSprint(proj,developer);
                select.setLocationRelativeTo(null);
                select.setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_remSelecSprintActionPerformed

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
            java.util.logging.Logger.getLogger(SelectSprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectSprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectSprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectSprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectSprint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTaskSelecSprint;
    private javax.swing.JButton canSelecSprint;
    private javax.swing.JButton remSelecSprint;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JLabel selecSprintLab;
    private javax.swing.JList<String> sprintsListSelecSprint;
    private javax.swing.JButton viewSelecSprint;
    // End of variables declaration//GEN-END:variables
}
