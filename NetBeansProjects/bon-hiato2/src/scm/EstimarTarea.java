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
public class EstimarTarea extends javax.swing.JFrame {

    /**
     * Creates new form EstimarTarea
     */
    private String project;
    private String taskname;
    private String id;
    private String idSprint;
    private String developer2;
    BD bd = new BD();
    Connection connection = bd.conexion();
    public EstimarTarea() {
        initComponents();
    }
    public EstimarTarea(String proy,String sel,String dev){
        project=proy;
        taskname=sel;
        developer2=dev;
        initComponents();
        
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from task");
            
            while(rs.next()){
                
                if(rs.getString("name").equals(taskname) && rs.getString("Projects").equals(project)){
                    nameEstimarTarea.setText(rs.getString("name"));
                    priorityEstimarTarea.setText(rs.getString("priority"));
                    descriptionEstimarTarea.setText(rs.getString("description"));
                    durationEstimarTarea.setText(rs.getString("duration"));
                    stateEstimarTarea.setText(rs.getString("state"));
                    hoursEstimarTarea.setText(rs.getString("hours"));
                    developerEstimarTarea.setText(rs.getString("develop"));
                    id= rs.getString("id");
                    idSprint=rs.getString("sprint");
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

        estimarTareaName = new javax.swing.JLabel();
        canEstimarTarea = new javax.swing.JButton();
        accEstimarTarea = new javax.swing.JButton();
        estimarTareaPriority = new javax.swing.JLabel();
        estimarTareaHours = new javax.swing.JLabel();
        estimarTareaState = new javax.swing.JLabel();
        estimarTareaDeveloper = new javax.swing.JLabel();
        estimarTareaDescription = new javax.swing.JLabel();
        estimarTareaDuration = new javax.swing.JLabel();
        durationEstimarTarea = new javax.swing.JTextField();
        nameEstimarTarea = new javax.swing.JLabel();
        priorityEstimarTarea = new javax.swing.JLabel();
        stateEstimarTarea = new javax.swing.JLabel();
        hoursEstimarTarea = new javax.swing.JLabel();
        developerEstimarTarea = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        descriptionEstimarTarea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scrum master - Estimar tarea");

        estimarTareaName.setText("Nombre de la tarea");

        canEstimarTarea.setText("Cancelar");
        canEstimarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canEstimarTareaActionPerformed(evt);
            }
        });

        accEstimarTarea.setText("Estimar");
        accEstimarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accEstimarTareaActionPerformed(evt);
            }
        });

        estimarTareaPriority.setText("Prioridad");

        estimarTareaHours.setText("Horas");

        estimarTareaState.setText("State");

        estimarTareaDeveloper.setText("Desarrollador");

        estimarTareaDescription.setText("Descripción");

        estimarTareaDuration.setText("Duración");

        durationEstimarTarea.setText("0");

        nameEstimarTarea.setText("jLabel8");

        priorityEstimarTarea.setText("jLabel9");

        stateEstimarTarea.setText("jLabel10");

        hoursEstimarTarea.setText("jLabel11");

        developerEstimarTarea.setText("jLabel12");

        descriptionEstimarTarea.setColumns(20);
        descriptionEstimarTarea.setRows(5);
        scroll.setViewportView(descriptionEstimarTarea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(estimarTareaDeveloper)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(estimarTareaDescription))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(estimarTareaName)
                                    .addComponent(nameEstimarTarea))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(priorityEstimarTarea)
                                    .addComponent(estimarTareaPriority, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(69, 69, 69))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(accEstimarTarea)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(developerEstimarTarea)
                                        .addComponent(estimarTareaDuration))
                                    .addComponent(durationEstimarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canEstimarTarea)
                    .addComponent(estimarTareaState, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateEstimarTarea)
                    .addComponent(estimarTareaHours)
                    .addComponent(hoursEstimarTarea))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estimarTareaName)
                    .addComponent(estimarTareaPriority)
                    .addComponent(estimarTareaState))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameEstimarTarea)
                    .addComponent(priorityEstimarTarea)
                    .addComponent(stateEstimarTarea))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estimarTareaHours)
                    .addComponent(estimarTareaDeveloper)
                    .addComponent(estimarTareaDescription))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(developerEstimarTarea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estimarTareaDuration)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(durationEstimarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(hoursEstimarTarea)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accEstimarTarea)
                    .addComponent(canEstimarTarea))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void canEstimarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canEstimarTareaActionPerformed
        // TODO add your handling code here:
        SeleccionarTareaParaEstimar seleccionarTareaParaEstimar = new SeleccionarTareaParaEstimar(project,developer2);
        seleccionarTareaParaEstimar.setLocationRelativeTo(null);
        seleccionarTareaParaEstimar.setVisible(true);
        dispose();
    }//GEN-LAST:event_canEstimarTareaActionPerformed

    private void accEstimarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accEstimarTareaActionPerformed
        // TODO add your handling code here:
        if (Integer.parseInt(hoursEstimarTarea.getText())< 0) {
            JOptionPane.showMessageDialog(null, "Las horas deben ser mayor que cero");
        }else{        
    
        try {
            String sql = "UPDATE task set Projects='"+project+"',name='"
            +nameEstimarTarea.getText()+"',duration='"+durationEstimarTarea.getText()+"',priority='"
            +priorityEstimarTarea.getText()+"',description='"
            +descriptionEstimarTarea.getText()+"',state='"
            +stateEstimarTarea.getText()+"',hours='"
            +hoursEstimarTarea.getText()+"',develop='"
            +developerEstimarTarea.getText()+"',sprint='"
            +idSprint+"' where id='"
            +id+"'";
            PreparedStatement pst=connection.prepareStatement(sql);
            pst.execute();
                
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        SeleccionarTareaParaEstimar seleccionarTareaParaEstimar = new SeleccionarTareaParaEstimar(project,developer2);
        seleccionarTareaParaEstimar.setLocationRelativeTo(null);
        seleccionarTareaParaEstimar.setVisible(true);
        dispose();
        }
    }//GEN-LAST:event_accEstimarTareaActionPerformed

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
            java.util.logging.Logger.getLogger(EstimarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstimarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstimarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstimarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstimarTarea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accEstimarTarea;
    private javax.swing.JButton canEstimarTarea;
    private javax.swing.JTextArea descriptionEstimarTarea;
    private javax.swing.JLabel developerEstimarTarea;
    private javax.swing.JTextField durationEstimarTarea;
    private javax.swing.JLabel estimarTareaDescription;
    private javax.swing.JLabel estimarTareaDeveloper;
    private javax.swing.JLabel estimarTareaDuration;
    private javax.swing.JLabel estimarTareaHours;
    private javax.swing.JLabel estimarTareaName;
    private javax.swing.JLabel estimarTareaPriority;
    private javax.swing.JLabel estimarTareaState;
    private javax.swing.JLabel hoursEstimarTarea;
    private javax.swing.JLabel nameEstimarTarea;
    private javax.swing.JLabel priorityEstimarTarea;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JLabel stateEstimarTarea;
    // End of variables declaration//GEN-END:variables
}
