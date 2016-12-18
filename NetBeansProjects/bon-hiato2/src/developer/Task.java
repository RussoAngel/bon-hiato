/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developer;

import bon.BD;
import bon.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import po.ProductOwner;
import scm.ScrumMaster;
/**
 *
 * @author yonay
 */
public class Task extends javax.swing.JFrame {

    /**
     * Creates new form Task
     */
    BD bd = new BD();
    Connection connection = bd.conexion();
    
    List<String> tareas = new ArrayList<>();
    
    String projectName;
    String developer;
   public Task(){
       initComponents();
   }
    public Task(String task,String develop){
        projectName= task;
        developer=develop;
        initComponents();
        tasksTitle.setText("<Html>"+projectName +"/selectorDeTareas</Html>");
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from task");
            
            while(rs.next()){
                
                System.out.println(rs.getString("develop"));
                System.out.println(developer);
                if(rs.getString("Projects").equals(projectName) && rs.getString("develop").equals(developer)){
                    tareas.add(rs.getString("name"));
                }
            }
            for (String tarea : tareas) {
            System.out.println(tarea);
            }
            String[] mylist = new String[tareas.size()];
            mylist = tareas.toArray(mylist);
            listTasks.setListData(mylist);
            
        }catch(SQLException e){
            System.out.println("no se pudo acceder");
        }
       
            
        
    }
    
    public boolean estaVacio(){
        
        if(tareas.size()==0){
            return true;
        }
        return false;
    }
    public void tittle(String project){
        tasksTitle.setText("<Html>"+project +"/selectorDeTareas</Html>");
        
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        tasksTitle = new javax.swing.JLabel();
        tasksTasks = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        listTasks = new javax.swing.JList<String>();
        jPanel1 = new javax.swing.JPanel();
        modTasks = new javax.swing.JButton();
        canTasks = new javax.swing.JButton();
        infTasks = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bon-Hiato");
        getContentPane().setLayout(new java.awt.GridLayout(0, 1));

        tasksTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tasksTitle.setText("Proyecto Actual");

        tasksTasks.setText("Tareas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tasksTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tasksTasks, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 47, Short.MAX_VALUE)
                .addComponent(tasksTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tasksTasks, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        getContentPane().add(jPanel2);

        scroll.setViewportView(listTasks);

        getContentPane().add(scroll);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        modTasks.setText("Modificar");
        modTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modTasksActionPerformed(evt);
            }
        });
        jPanel1.add(modTasks, new java.awt.GridBagConstraints());

        canTasks.setText("Cancelar");
        canTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canTasksActionPerformed(evt);
            }
        });
        jPanel1.add(canTasks, new java.awt.GridBagConstraints());

        infTasks.setText("Informar");
        infTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infTasksActionPerformed(evt);
            }
        });
        jPanel1.add(infTasks, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modTasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modTasksActionPerformed
        // TODO add your handling code here:
        String tarea = listTasks.getSelectedValue();
        if(!(tarea == null)){
            UpdateTask updateTask = new UpdateTask(tarea,projectName,developer);
            updateTask.setLocationRelativeTo(null);
            updateTask.setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una tarea.");
        }
    }//GEN-LAST:event_modTasksActionPerformed

    private void canTasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canTasksActionPerformed
        // TODO add your handling code here:
        
        
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from login");
            String type="";
            while(rs.next()){    
                if(developer.equals(rs.getString("name"))){
                    type=rs.getString("type");
                }
            }
            if(type.equals("developer")){
                Developer develop = new Developer(developer);
                develop.setLocationRelativeTo(null);
                develop.setVisible(true);
                dispose();
            }else{
                ScrumMaster scr = new ScrumMaster(developer);
                scr.setLocationRelativeTo(null);
                scr.setVisible(true);
                dispose();
            }
            
            
        }catch(SQLException e){
            System.out.println("no se pudo acceder");
        }
    }//GEN-LAST:event_canTasksActionPerformed

    private void infTasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infTasksActionPerformed
        // TODO add your handling code here:
        RiskInform riskInform = new RiskInform(developer,projectName);
        riskInform.setLocationRelativeTo(null);
        riskInform.setVisible(true);
        dispose();
    }//GEN-LAST:event_infTasksActionPerformed

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
            java.util.logging.Logger.getLogger(Task.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Task.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Task.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Task.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Task().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton canTasks;
    private javax.swing.JButton infTasks;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JList<String> listTasks;
    private javax.swing.JButton modTasks;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JLabel tasksTasks;
    private javax.swing.JLabel tasksTitle;
    // End of variables declaration//GEN-END:variables
}
