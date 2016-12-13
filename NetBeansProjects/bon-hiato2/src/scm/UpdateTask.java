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
import javax.swing.JOptionPane;

/**
 *
 * @author yonay
 */
public class UpdateTask extends javax.swing.JFrame {

    /**
     * Creates new form UpdateTask
     */
    private String task;
    private String project;
    private String duration;
    private String id;
    private String idSprint;
    private String developer2;
    BD bd = new BD();
    Connection connection = bd.conexion();

    public UpdateTask() {
        initComponents();
    }

    public UpdateTask(String projectname, String taskname, String dev) {
        initComponents();
        project = projectname;
        task = taskname;
        developer2 = dev;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from task");

            while (rs.next()) {

                if (rs.getString("name").equals(task) && rs.getString("Projects").equals(project)) {
                    nameUpdateTask.setText(rs.getString("name"));
                    priorityUpdateTask.setText(rs.getString("priority"));
                    descriptionUpdateTask.setText(rs.getString("description"));
                    duration = rs.getString("duration");
                    stateUpdateTask.setText(rs.getString("state"));
                    hoursUpdateTask.setText(rs.getString("hours"));
                    developerUpdateTask.setText(rs.getString("develop"));
                    id = rs.getString("id");
                    idSprint = rs.getString("sprint");
                }
            }

        } catch (SQLException e) {
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

        hoursUpdateTask = new javax.swing.JTextField();
        updateTaskName = new javax.swing.JLabel();
        nameUpdateTask = new javax.swing.JTextField();
        updateTaskPriority = new javax.swing.JLabel();
        updateTaskDescription = new javax.swing.JLabel();
        priorityUpdateTask = new javax.swing.JTextField();
        updateTaskState = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        descriptionUpdateTask = new javax.swing.JTextArea();
        stateUpdateTask = new javax.swing.JTextField();
        canUpdateTask = new javax.swing.JButton();
        updateTaskDeveloper = new javax.swing.JLabel();
        accUpdateTask = new javax.swing.JButton();
        developerUpdateTask = new javax.swing.JTextField();
        updateTaskHours = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scrum master - Actualizar tarea");

        updateTaskName.setText("Nombre de la tarea");
        updateTaskName.setToolTipText("");

        updateTaskPriority.setText("Prioridad (0-5)");

        updateTaskDescription.setText("Descripción");

        updateTaskState.setText("Estado (0-3)");

        descriptionUpdateTask.setColumns(20);
        descriptionUpdateTask.setRows(5);
        scroll.setViewportView(descriptionUpdateTask);

        canUpdateTask.setText("Cancelar");
        canUpdateTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canUpdateTaskActionPerformed(evt);
            }
        });

        updateTaskDeveloper.setText("Desarrollador");

        accUpdateTask.setText("Modificar");
        accUpdateTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accUpdateTaskActionPerformed(evt);
            }
        });

        updateTaskHours.setText("Horas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameUpdateTask, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateTaskName))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(priorityUpdateTask)
                                .addGap(69, 69, 69))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(updateTaskPriority)
                                .addGap(54, 54, 54))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(developerUpdateTask, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateTaskDescription)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateTaskDeveloper)
                            .addComponent(accUpdateTask))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canUpdateTask)
                    .addComponent(hoursUpdateTask, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateTaskHours)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(stateUpdateTask, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateTaskState, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateTaskName)
                    .addComponent(updateTaskPriority)
                    .addComponent(updateTaskState))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameUpdateTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateUpdateTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priorityUpdateTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateTaskHours)
                    .addComponent(updateTaskDeveloper))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(developerUpdateTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hoursUpdateTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateTaskDescription)))
                .addGap(7, 7, 7)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(canUpdateTask)
                    .addComponent(accUpdateTask))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void canUpdateTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canUpdateTaskActionPerformed
        // TODO add your handling code here:
        SelectTask selectTask = new SelectTask(project, developer2);
        selectTask.setLocationRelativeTo(null);
        selectTask.setVisible(true);
        dispose();
    }//GEN-LAST:event_canUpdateTaskActionPerformed

    private void accUpdateTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accUpdateTaskActionPerformed
        // TODO add your handling code here:
        if (nameUpdateTask.getText().equals("") || descriptionUpdateTask.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tiene que indicar el nombre y la descripción.");
        } else if (getPriority() > 5 || getPriority() < 0) {
            JOptionPane.showMessageDialog(null, "Introduzca una prioridad válida");
        } else if (getTaskState() > 3 || getTaskState() < 0) {
            JOptionPane.showMessageDialog(null, "Introduzca un estado válido");
        } else {
            try {
                String sql = "UPDATE task set Projects='" + project + "',name='"
                        + nameUpdateTask.getText() + "',duration='" + duration + "',priority='"
                        + priorityUpdateTask.getText() + "',description='"
                        + descriptionUpdateTask.getText() + "',state='"
                        + stateUpdateTask.getText() + "',hours='"
                        + hoursUpdateTask.getText() + "',develop='"
                        + developerUpdateTask.getText() + "',sprint='"
                        + idSprint + "' where id='"
                        + id + "'";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.execute();

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            SelectTask selectTask = new SelectTask(project, developer2);
            selectTask.setLocationRelativeTo(null);
            selectTask.setVisible(true);
            dispose();
    }//GEN-LAST:event_accUpdateTaskActionPerformed
    }

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
            java.util.logging.Logger.getLogger(UpdateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateTask().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accUpdateTask;
    private javax.swing.JButton canUpdateTask;
    private javax.swing.JTextArea descriptionUpdateTask;
    private javax.swing.JTextField developerUpdateTask;
    private javax.swing.JTextField hoursUpdateTask;
    private javax.swing.JTextField nameUpdateTask;
    private javax.swing.JTextField priorityUpdateTask;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField stateUpdateTask;
    private javax.swing.JLabel updateTaskDescription;
    private javax.swing.JLabel updateTaskDeveloper;
    private javax.swing.JLabel updateTaskHours;
    private javax.swing.JLabel updateTaskName;
    private javax.swing.JLabel updateTaskPriority;
    private javax.swing.JLabel updateTaskState;
    // End of variables declaration//GEN-END:variables

    private int getPriority() {
        return Integer.parseInt(priorityUpdateTask.getText());
    }

    private int getTaskState() {
        return Integer.parseInt(stateUpdateTask.getText());
    }
}
