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
public class AddTaskIntoSprint extends javax.swing.JFrame {

    /**
     * Creates new form AddTaskIntoSprint
     */
    private String project;
    private String sprint;
    private String name;
    private String projectTask;
    private String id;
    private String priority;
    private String description;
    private String duration;
    private String state;
    private String hours;
    private String develop;
    private String idSprint;
    private String projectname;

    BD bd = new BD();
    Connection connection = bd.conexion();
    
    List<String> tareas = new ArrayList<>();
    private String developer2;
    public AddTaskIntoSprint() {
        initComponents();
    }
    public AddTaskIntoSprint(String proj,String spr,String dev){
        initComponents();
        project=proj;
        developer2=dev;
        sprint=spr;
        jLabel1.setText("<Html>"+project+" /"+sprint+" /AñadirTarea</Html>");
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from task");
            
            while(rs.next()){
                
                if(rs.getString("sprint").equals("0") && rs.getString("Projects").equals(project)){
                    tareas.add(rs.getString("name"));
                }
            }
            if(tareas.size()>0){
                String[] mylist = new String[tareas.size()];
                mylist = tareas.toArray(mylist);
                taskListAddToSprint.setListData(mylist);
            }
            
        }catch(SQLException e){
            System.out.println("no se pudo acceder");
        }
        
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from sprint");
            
            
            while(rs.next()){
                
                System.out.println(rs.getString("project"));
                if((sprint.equals(rs.getString("name")) && (project.equals(rs.getString("project"))))){
                    idSprint=rs.getString("id");
                }

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

        scroll = new javax.swing.JScrollPane();
        taskListAddToSprint = new javax.swing.JList<>();
        accAddToSprint = new javax.swing.JButton();
        canAddToSprint = new javax.swing.JButton();
        addToSprintTasks = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bon-Hiato");
        setMaximumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(300, 350));
        setResizable(false);

        scroll.setViewportView(taskListAddToSprint);

        accAddToSprint.setText("Añadir");
        accAddToSprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accAddToSprintActionPerformed(evt);
            }
        });

        canAddToSprint.setText("Cancelar");
        canAddToSprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canAddToSprintActionPerformed(evt);
            }
        });

        addToSprintTasks.setText("Seleccionar Tarea");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(canAddToSprint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(accAddToSprint, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addToSprintTasks)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addToSprintTasks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(accAddToSprint)
                        .addGap(18, 18, 18)
                        .addComponent(canAddToSprint))
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accAddToSprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accAddToSprintActionPerformed
        // TODO add your handling code here:
        String selection=taskListAddToSprint.getSelectedValue();
        if(selection == null){
            JOptionPane.showMessageDialog(null, "Seleccione una tarea para añadir al sprint.");
        }else{
            try{
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("select * from task");
                while(rs.next()){
                    if(selection.equals(rs.getString("name"))){
                        name=rs.getString("name");
                        priority=rs.getString("priority");
                        description=rs.getString("description");
                        duration=rs.getString("duration");
                        state=rs.getString("state");
                        hours=rs.getString("hours");
                        projectname=rs.getString("Projects");
                        develop=rs.getString("develop");
                        id= rs.getString("id");
                    }
                }
            }catch(SQLException e){
                System.out.println("no se pudo acceder");
            }
            try {
                String sql = "UPDATE task set Projects='"+projectname+"',name='"
                +name+"',duration='"+duration+"',priority='"
                +priority+"',description='"
                +description+"',state='"
                +state+"',hours='"
                +hours+"',develop='"
                +develop+"',sprint='"
                +idSprint+"' where id='"
                +id+"'";
                PreparedStatement pst=connection.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Se ha añadido la tarea " + name + " al sprint: "+sprint+ " ,con éxito");

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            AddTaskIntoSprint addtask= new AddTaskIntoSprint(project,sprint,developer2);
            addtask.setLocationRelativeTo(null);
            addtask.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_accAddToSprintActionPerformed

    private void canAddToSprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canAddToSprintActionPerformed
        // TODO add your handling code here:
        SelectSprint selec = new SelectSprint(project,developer2);
        selec.setLocationRelativeTo(null);
        selec.setVisible(true);
        dispose();
    }//GEN-LAST:event_canAddToSprintActionPerformed

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
            java.util.logging.Logger.getLogger(AddTaskIntoSprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTaskIntoSprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTaskIntoSprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTaskIntoSprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTaskIntoSprint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accAddToSprint;
    private javax.swing.JLabel addToSprintTasks;
    private javax.swing.JButton canAddToSprint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JList<String> taskListAddToSprint;
    // End of variables declaration//GEN-END:variables
}
