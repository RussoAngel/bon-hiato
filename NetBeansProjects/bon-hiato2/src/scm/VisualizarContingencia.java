/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scm;

import bon.BD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author yonay
 */
public class VisualizarContingencia extends javax.swing.JFrame {

    /**
     * Creates new form VisualizarContingencia
     */
    BD bd = new BD();
    Connection connection = bd.conexion();
    private String contingencianame;
    private String project;
    private String developer2;
    public VisualizarContingencia() {
        initComponents();
    }
    public VisualizarContingencia(String cont,String proy,String dev){
        contingencianame=cont;
        project=proy;
        developer2=dev;
        initComponents();
        jLabel1.setText("<Html> Proyecto: "+project+"<br> Ventana: Visualizar Plan De Contingencia</Html>");
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from contingencia");
            
            while(rs.next()){
                    if(rs.getString("name").equals(contingencianame)){
                         nameVisualizarContingencia.setText(rs.getString("name"));
                         prevencionVisualizarContingencia.setText(rs.getString("prevencion"));
                         perdidaVisualizarContingencia.setText(rs.getString("perdida"));
                         medidaVisualizarContingencia.setText(rs.getString("medida"));
                         descriptionContingencia.setText(rs.getString("description"));
                         exposicionVisualizarContingencia.setText(rs.getString("exposicion"));
                         probabilidadVisualizarContingencia.setText(rs.getString("probabilidad"));
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

        visualizarContingenciaProbabilidad = new javax.swing.JLabel();
        visualizarContingenciaDescription = new javax.swing.JLabel();
        canVisualizarContingencia = new javax.swing.JButton();
        visualizarContingenciaPrevencion = new javax.swing.JLabel();
        visualizarContingenciaMedida = new javax.swing.JLabel();
        visualizarContingenciaPerdida = new javax.swing.JLabel();
        visualizarContingenciaName = new javax.swing.JLabel();
        nameVisualizarContingencia = new javax.swing.JLabel();
        perdidaVisualizarContingencia = new javax.swing.JLabel();
        probabilidadVisualizarContingencia = new javax.swing.JLabel();
        visualizarContingenciaExposicion = new javax.swing.JLabel();
        exposicionVisualizarContingencia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionContingencia = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        prevencionVisualizarContingencia = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        medidaVisualizarContingencia = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bon-Hiato");
        setPreferredSize(new java.awt.Dimension(800, 450));
        setResizable(false);

        visualizarContingenciaProbabilidad.setText("Probabilidad (%)");

        visualizarContingenciaDescription.setText("Descripción");

        canVisualizarContingencia.setText("Cancelar");
        canVisualizarContingencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canVisualizarContingenciaActionPerformed(evt);
            }
        });

        visualizarContingenciaPrevencion.setText("Método de prevención");

        visualizarContingenciaMedida.setText("Medidas a tomar");

        visualizarContingenciaPerdida.setText("Pérdida (días)");

        visualizarContingenciaName.setText("Nombre Riesgo");

        nameVisualizarContingencia.setText("jLabel7");

        perdidaVisualizarContingencia.setText("jLabel9");

        probabilidadVisualizarContingencia.setText("jLabel11");

        visualizarContingenciaExposicion.setText("Exposición");

        exposicionVisualizarContingencia.setText("jLabel14");

        descriptionContingencia.setEditable(false);
        descriptionContingencia.setColumns(20);
        descriptionContingencia.setRows(5);
        jScrollPane1.setViewportView(descriptionContingencia);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("jLabel1");

        prevencionVisualizarContingencia.setEditable(false);
        prevencionVisualizarContingencia.setColumns(20);
        prevencionVisualizarContingencia.setRows(5);
        jScrollPane2.setViewportView(prevencionVisualizarContingencia);

        medidaVisualizarContingencia.setEditable(false);
        medidaVisualizarContingencia.setColumns(20);
        medidaVisualizarContingencia.setRows(5);
        jScrollPane3.setViewportView(medidaVisualizarContingencia);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canVisualizarContingencia)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(visualizarContingenciaDescription)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(perdidaVisualizarContingencia)
                                    .addComponent(visualizarContingenciaPerdida))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(visualizarContingenciaPrevencion)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(probabilidadVisualizarContingencia)
                                        .addComponent(visualizarContingenciaProbabilidad)
                                        .addComponent(visualizarContingenciaName)
                                        .addComponent(nameVisualizarContingencia)))
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(visualizarContingenciaExposicion)
                                    .addComponent(visualizarContingenciaMedida)
                                    .addComponent(exposicionVisualizarContingencia)))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(visualizarContingenciaName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameVisualizarContingencia)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(visualizarContingenciaPerdida)
                    .addComponent(visualizarContingenciaProbabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(visualizarContingenciaExposicion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(perdidaVisualizarContingencia)
                    .addComponent(probabilidadVisualizarContingencia)
                    .addComponent(exposicionVisualizarContingencia))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(visualizarContingenciaPrevencion)
                    .addComponent(visualizarContingenciaDescription)
                    .addComponent(visualizarContingenciaMedida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(canVisualizarContingencia)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void canVisualizarContingenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canVisualizarContingenciaActionPerformed
        // TODO add your handling code here:
        SeleccionarPlan selec = new SeleccionarPlan(project,developer2);
        selec.setLocationRelativeTo(null);
        selec.setVisible(true);
        dispose();
    }//GEN-LAST:event_canVisualizarContingenciaActionPerformed

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
            java.util.logging.Logger.getLogger(VisualizarContingencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizarContingencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizarContingencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizarContingencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarContingencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton canVisualizarContingencia;
    private javax.swing.JTextArea descriptionContingencia;
    private javax.swing.JLabel exposicionVisualizarContingencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea medidaVisualizarContingencia;
    private javax.swing.JLabel nameVisualizarContingencia;
    private javax.swing.JLabel perdidaVisualizarContingencia;
    private javax.swing.JTextArea prevencionVisualizarContingencia;
    private javax.swing.JLabel probabilidadVisualizarContingencia;
    private javax.swing.JLabel visualizarContingenciaDescription;
    private javax.swing.JLabel visualizarContingenciaExposicion;
    private javax.swing.JLabel visualizarContingenciaMedida;
    private javax.swing.JLabel visualizarContingenciaName;
    private javax.swing.JLabel visualizarContingenciaPerdida;
    private javax.swing.JLabel visualizarContingenciaPrevencion;
    private javax.swing.JLabel visualizarContingenciaProbabilidad;
    // End of variables declaration//GEN-END:variables
}
