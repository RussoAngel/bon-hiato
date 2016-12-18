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
public class Ingreso extends javax.swing.JFrame {

    /**
     * Creates new form Ingreso
     */
    private String project;
    BD bd = new BD();
    private float precio=0;
    private float mul=0;
    private String develop;
    Connection connection = bd.conexion();
    List<String> ingresos = new ArrayList<>();
    public Ingreso() {
        initComponents();
    }
    public Ingreso(String proy,String dev){
        initComponents();
        develop=dev;
        project=proy;
        jLabel1.setText("<Html>"+project+"/EstimarIngresos</Html>");
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from ingreso");
            
            while(rs.next()){
                    ingresos.add(rs.getString("name"));

            }
            if(ingresos.size()>0){
                String[] mylist = new String[ingresos.size()];
                mylist = ingresos.toArray(mylist);
                listaDeIngresos.setListData(mylist);
            }
            
        }catch(SQLException e){
            System.out.println("no se pudo acceder");
        }
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from ingreso");
            while(rs.next()){
                
                mul=Float.parseFloat(rs.getString("precio")) * Float.parseFloat(rs.getString("unidad"));
                precio+=mul;
            }
            totalIngreso.setText(String.valueOf(precio) + " €");
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

        ingresoTotal = new javax.swing.JLabel();
        totalIngreso = new javax.swing.JLabel();
        accIngreso = new javax.swing.JButton();
        canIngreso = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDeIngresos = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bon-Hiato");
        setResizable(false);

        ingresoTotal.setText("Ingresos Totales");

        totalIngreso.setText("jLabel2");

        accIngreso.setText("Añadir");
        accIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accIngresoActionPerformed(evt);
            }
        });

        canIngreso.setText("Cancelar");
        canIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canIngresoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("jLabel1");

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listaDeIngresos);

        jLabel2.setText("Seleccionar Ingreso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 146, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ingresoTotal)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                        .addComponent(accIngreso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(totalIngreso)
                                    .addGap(20, 20, 20)))
                            .addComponent(canIngreso)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ingresoTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalIngreso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(accIngreso)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1)
                        .addGap(27, 27, 27)
                        .addComponent(canIngreso))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void canIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canIngresoActionPerformed
        // TODO add your handling code here:
        RealizarStimacion realizarStimacion = new RealizarStimacion(project,develop);
        realizarStimacion.setLocationRelativeTo(null);
        realizarStimacion.setVisible(true);
        dispose();
    }//GEN-LAST:event_canIngresoActionPerformed

    private void accIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accIngresoActionPerformed
        // TODO add your handling code here:
        EstimarIngresos estimarIngresos = new EstimarIngresos(project,develop);
        estimarIngresos.setLocationRelativeTo(null);
        estimarIngresos.setVisible(true);
        dispose();
    }//GEN-LAST:event_accIngresoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (listaDeIngresos.getSelectedValue() != null) {
            int respuesta=JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres eliminar este plan?");
            if(respuesta==0){
                try{
                    String query = " DELETE FROM ingreso WHERE name = ?";

                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, listaDeIngresos.getSelectedValue());
                preparedStmt.execute();
                }catch(SQLException | HeadlessException e){
                    JOptionPane.showMessageDialog(null, e);
                }
                Ingreso pr = new Ingreso(project,develop);
                pr.setLocationRelativeTo(null);
                pr.setVisible(true);
                dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un ingreso");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accIngreso;
    private javax.swing.JButton canIngreso;
    private javax.swing.JLabel ingresoTotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaDeIngresos;
    private javax.swing.JLabel totalIngreso;
    // End of variables declaration//GEN-END:variables
}
