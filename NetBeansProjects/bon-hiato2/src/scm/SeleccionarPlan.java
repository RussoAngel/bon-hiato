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
public class SeleccionarPlan extends javax.swing.JFrame {

    /**
     * Creates new form SeleccionarPlan
     */
    BD bd = new BD();
    Connection connection = bd.conexion();
    public String proy;
    private String developer2;
    
    List<String> plan = new ArrayList<>();
    
    public SeleccionarPlan() {
        initComponents();
    }
    
   
    public SeleccionarPlan(String project,String dev){
        initComponents();
        proy= project;
        developer2=dev;
        jLabel1.setText("<Html> Proyecto: "+proy+"</Html>");
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from contingencia");
            
            while(rs.next()){
                    plan.add(rs.getString("name"));

            }
            if(plan.size()>0){
                String[] mylist = new String[plan.size()];
                mylist = plan.toArray(mylist);
                planesListSelecPlan.setListData(mylist);
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
        planesListSelecPlan = new javax.swing.JList<>();
        addSelecPlan = new javax.swing.JButton();
        remSelecPlan = new javax.swing.JButton();
        viewSelecPlan = new javax.swing.JButton();
        canSelecPlan = new javax.swing.JButton();
        selecPlanLab = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bon-Hiato");
        setPreferredSize(new java.awt.Dimension(300, 300));
        setResizable(false);

        scroll.setViewportView(planesListSelecPlan);

        addSelecPlan.setText("Añadir");
        addSelecPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSelecPlanActionPerformed(evt);
            }
        });

        remSelecPlan.setText("Eliminar");
        remSelecPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remSelecPlanActionPerformed(evt);
            }
        });

        viewSelecPlan.setText("Visualizar");
        viewSelecPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSelecPlanActionPerformed(evt);
            }
        });

        canSelecPlan.setText("Cancelar");
        canSelecPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canSelecPlanActionPerformed(evt);
            }
        });

        selecPlanLab.setText("Planes de contingencia");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selecPlanLab, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(viewSelecPlan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(remSelecPlan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addSelecPlan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(canSelecPlan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(selecPlanLab)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addSelecPlan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remSelecPlan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewSelecPlan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(canSelecPlan)
                        .addGap(0, 64, Short.MAX_VALUE))
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void remSelecPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remSelecPlanActionPerformed
        // TODO add your handling code here:
        if (planesListSelecPlan.getSelectedValue() != null) {
            int respuesta=JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres eliminar este plan?");
            if(respuesta==0){
                try{
                    String query = " DELETE FROM contingencia WHERE name = ?";

                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, planesListSelecPlan.getSelectedValue());
                preparedStmt.execute();
                }catch(SQLException | HeadlessException e){
                    JOptionPane.showMessageDialog(null, e);
                }
                SeleccionarPlan pr = new SeleccionarPlan(proy,developer2);
                pr.setLocationRelativeTo(null);
                pr.setVisible(true);
                dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un plan");
        }
    }//GEN-LAST:event_remSelecPlanActionPerformed

    private void canSelecPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canSelecPlanActionPerformed
        // TODO add your handling code here:
        Gestion gestion = new Gestion(proy,developer2);
        gestion.setLocationRelativeTo(null);
        gestion.setVisible(true);
        dispose();
    }//GEN-LAST:event_canSelecPlanActionPerformed

    private void addSelecPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSelecPlanActionPerformed
        // TODO add your handling code here:
        AddPlanContingencia add = new AddPlanContingencia(proy,developer2);
        add.setLocationRelativeTo(null);
        add.setVisible(true);
        dispose();
    }//GEN-LAST:event_addSelecPlanActionPerformed

    private void viewSelecPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSelecPlanActionPerformed
        // TODO add your handling code here:
        String contin= planesListSelecPlan.getSelectedValue();
        if(contin == null){
            JOptionPane.showMessageDialog(null, "Seleccione un plan de contingencia.");
        }else{
            VisualizarContingencia v = new VisualizarContingencia(contin,proy,developer2);
            v.setLocationRelativeTo(null);
            v.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_viewSelecPlanActionPerformed

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
            java.util.logging.Logger.getLogger(SeleccionarPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionarPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionarPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionarPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionarPlan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSelecPlan;
    private javax.swing.JButton canSelecPlan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> planesListSelecPlan;
    private javax.swing.JButton remSelecPlan;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JLabel selecPlanLab;
    private javax.swing.JButton viewSelecPlan;
    // End of variables declaration//GEN-END:variables
}
