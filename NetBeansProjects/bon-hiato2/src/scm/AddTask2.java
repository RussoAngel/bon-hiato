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
public class AddTask2 extends javax.swing.JFrame {

    /**
     * Creates new form AddTask
     */
    String proj;
    BD bd = new BD();
    Connection connection = bd.conexion();
    private int id;
    private Identificador identificador;
    private String developer2;
    public AddTask2() {
        initComponents();
    }
    public AddTask2(String project,String dev){
        initComponents();
        proj=project;
        developer2=dev;
        jLabel1.setText("<Html> Proyecto Actual: "+proj +"<br> Ventana Actual: Crear Tarea</Html>");
        priority.addItem("0 - Sin prioridad");
        priority.addItem("1 - Poca prioridad");
        priority.addItem("2 - Prioridad media");
        priority.addItem("3 - Alta prioridad");
        state.addItem("0 - sin empezar");
        state.addItem("1 - desarrollo");
        state.addItem("2 - finalizada");
        state.addItem("3 - bloqueada");
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from task");
            while(rs.next()){
                id=Integer.parseInt(rs.getString("id"));
            }
            identificador = new Identificador(id);
        }catch(SQLException e){
            System.out.println("no se pudo acceder");
        }
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from login");
            Developer.addItem("Sin Asignar");
            while(rs.next()){
                if(rs.getString("type").equals("developer") || rs.getString("type").equals("scrumMaster")){
                    Developer.addItem(rs.getString("name"));
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

        addTask2Name = new javax.swing.JLabel();
        nameAddTask2 = new javax.swing.JTextField();
        addTask2Priority = new javax.swing.JLabel();
        addTask2State = new javax.swing.JLabel();
        addTask2Developer = new javax.swing.JLabel();
        addTask2Description = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        descriptionAddTask2 = new javax.swing.JTextArea();
        canAddTask2 = new javax.swing.JButton();
        accAddTask2 = new javax.swing.JButton();
        addTask2Hours = new javax.swing.JLabel();
        hoursAddTask2 = new javax.swing.JTextField();
        state = new javax.swing.JComboBox<>();
        priority = new javax.swing.JComboBox<>();
        Developer = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bon-Hiato");
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);

        addTask2Name.setText("Nombre de la Tarea");

        addTask2Priority.setText("Prioridad");

        addTask2State.setText("Estado");

        addTask2Developer.setText("Desarrollador");

        addTask2Description.setText("Descripción");

        descriptionAddTask2.setColumns(20);
        descriptionAddTask2.setRows(5);
        scroll.setViewportView(descriptionAddTask2);

        canAddTask2.setText("Cancelar");
        canAddTask2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canAddTask2ActionPerformed(evt);
            }
        });

        accAddTask2.setText("Crear");
        accAddTask2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accAddTask2ActionPerformed(evt);
            }
        });

        addTask2Hours.setText("Horas");

        hoursAddTask2.setText("0");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nameAddTask2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(addTask2Name))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(addTask2Priority, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(priority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(59, 59, 59))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Developer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addTask2Description)
                                        .addGap(65, 65, 65))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(addTask2Developer)
                                            .addComponent(accAddTask2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(canAddTask2)
                                    .addComponent(addTask2State, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hoursAddTask2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addTask2Hours)
                                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTask2Name)
                    .addComponent(addTask2Priority)
                    .addComponent(addTask2State))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameAddTask2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTask2Hours)
                    .addComponent(addTask2Developer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hoursAddTask2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTask2Description)
                    .addComponent(Developer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(accAddTask2)
                            .addComponent(canAddTask2))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accAddTask2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accAddTask2ActionPerformed
        // TODO add your handling code here:
        if(nameAddTask2.getText().equals("") || descriptionAddTask2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tiene que indicar el nombre y la descripción.");
        
        }else{
            try{
                String query = " insert into task (id, Projects, name, duration, priority, description, state, hours, develop, sprint)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, identificador.getId());
                preparedStmt.setString(2, proj);
                preparedStmt.setString(3, nameAddTask2.getText());
                preparedStmt.setInt(4, 0);
                preparedStmt.setInt(5, priority.getSelectedIndex());
                preparedStmt.setString(6, descriptionAddTask2.getText());
                preparedStmt.setInt(7, state.getSelectedIndex());
                preparedStmt.setInt(8, Integer.parseInt(hoursAddTask2.getText()));
                preparedStmt.setString(9, String.valueOf(Developer.getSelectedItem()));
                preparedStmt.setString(10, "0");
                // execute the preparedstatement
                preparedStmt.execute();
                JOptionPane.showMessageDialog(null, "La tarea "+nameAddTask2.getText()+" ha sido creada con éxito");

            }catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null, e);
            }
            Gestion ges = new Gestion(proj,developer2);
            ges.setLocationRelativeTo(null);
            ges.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_accAddTask2ActionPerformed

    private void canAddTask2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canAddTask2ActionPerformed
        // TODO add your handling code here:
        Gestion ges = new Gestion(proj,developer2);
        ges.setLocationRelativeTo(null);
        ges.setVisible(true);
        dispose();
    }//GEN-LAST:event_canAddTask2ActionPerformed

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
            java.util.logging.Logger.getLogger(AddTask2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTask2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTask2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTask2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTask2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Developer;
    private javax.swing.JButton accAddTask2;
    private javax.swing.JLabel addTask2Description;
    private javax.swing.JLabel addTask2Developer;
    private javax.swing.JLabel addTask2Hours;
    private javax.swing.JLabel addTask2Name;
    private javax.swing.JLabel addTask2Priority;
    private javax.swing.JLabel addTask2State;
    private javax.swing.JButton canAddTask2;
    private javax.swing.JTextArea descriptionAddTask2;
    private javax.swing.JTextField hoursAddTask2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nameAddTask2;
    private javax.swing.JComboBox<String> priority;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JComboBox<String> state;
    // End of variables declaration//GEN-END:variables


}
