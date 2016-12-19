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

/**
 *
 * @author yonay
 */
public class AddPlanContingencia extends javax.swing.JFrame {

    /**
     * Creates new form AddPlanContingencia
     */
    BD bd = new BD();
    Connection connection = bd.conexion();
    private int id;
    private IdentificadorPlan identificador;
    private int exposicion;
    private String project;
    private String developer2;

    public AddPlanContingencia() {
        initComponents();
    }

    public AddPlanContingencia(String proy, String dev) {
        initComponents();
        project = proy;
        developer2 = dev;
        jLabel1.setText("<Html> Proyecto Actual: "+project+"<br> Ventana Actual: Crear Plan De Contingencia</Html>");
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from contingencia");
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("id"));
            }
            identificador = new IdentificadorPlan(id);
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

        nameAddPlan = new javax.swing.JTextField();
        perdidaAddPlan = new javax.swing.JTextField();
        probabilidadAddPlan = new javax.swing.JTextField();
        scroll = new javax.swing.JScrollPane();
        descriptionAddPlan = new javax.swing.JTextArea();
        addPlanPrevencion = new javax.swing.JLabel();
        addPlanMedida = new javax.swing.JLabel();
        addPlanPerdida = new javax.swing.JLabel();
        addPlanName = new javax.swing.JLabel();
        addPlanProbabilidad = new javax.swing.JLabel();
        addPlanDescription = new javax.swing.JLabel();
        accAddPlan = new javax.swing.JButton();
        canAddPlan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        prevencionAddPlan = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        medidaAddPlan = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bon-Hiato");
        setResizable(false);

        perdidaAddPlan.setText("0");

        probabilidadAddPlan.setText("0");

        descriptionAddPlan.setColumns(20);
        descriptionAddPlan.setRows(5);
        scroll.setViewportView(descriptionAddPlan);

        addPlanPrevencion.setText("Prevención");

        addPlanMedida.setText("Medida");

        addPlanPerdida.setText("Pérdida");

        addPlanName.setText("Nombre");

        addPlanProbabilidad.setText("Probabilidad(0-100%)");

        addPlanDescription.setText("Descripción");

        accAddPlan.setText("Añadir");
        accAddPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accAddPlanActionPerformed(evt);
            }
        });

        canAddPlan.setText("Cancelar");
        canAddPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canAddPlanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("jLabel1");

        prevencionAddPlan.setColumns(20);
        prevencionAddPlan.setRows(5);
        jScrollPane1.setViewportView(prevencionAddPlan);

        medidaAddPlan.setColumns(20);
        medidaAddPlan.setRows(5);
        jScrollPane2.setViewportView(medidaAddPlan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addPlanDescription)
                            .addComponent(nameAddPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addPlanName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(perdidaAddPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(probabilidadAddPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(149, 149, 149))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addPlanMedida))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addPlanPrevencion)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 10, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(accAddPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addPlanPerdida)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addPlanProbabilidad)))
                                .addGap(18, 18, 18)
                                .addComponent(canAddPlan)
                                .addGap(9, 9, 9))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(accAddPlan)
                    .addComponent(canAddPlan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPlanPerdida)
                    .addComponent(addPlanProbabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addPlanName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(perdidaAddPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(probabilidadAddPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameAddPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPlanDescription)
                    .addComponent(addPlanMedida)
                    .addComponent(addPlanPrevencion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void canAddPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canAddPlanActionPerformed
        // TODO add your handling code here:
        SeleccionarPlan selec = new SeleccionarPlan(project, developer2);
        selec.setLocationRelativeTo(null);
        selec.setVisible(true);
        dispose();
    }//GEN-LAST:event_canAddPlanActionPerformed

    private void accAddPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accAddPlanActionPerformed
        // TODO add your handling code here:
        String nombre = nameAddPlan.getText();
        String prevencion = prevencionAddPlan.getText();
        String medida = medidaAddPlan.getText();
        String descripcion = descriptionAddPlan.getText();
        String perdida = perdidaAddPlan.getText();
        String probabilidad = probabilidadAddPlan.getText();
        if (nombre.equals("") || prevencion.equals("") || medida.equals("") || descripcion.equals("")) {
            JOptionPane.showMessageDialog(null, "Se deben rellenar todos los campos.");
        } else if (getProbability() < 0 || getProbability() > 100) {
            JOptionPane.showMessageDialog(null, "La probabilidad debe estar entre 0 y 100");
        } else if (getPerdida() < 0) {
            JOptionPane.showMessageDialog(null, "La pérdida no puede ser negativa");
        } else {
            try {
                exposicion = Integer.parseInt(probabilidad) * Integer.parseInt(perdida);

                String query = " insert into contingencia (id, name, prevencion, description, medida, probabilidad, perdida, exposicion)"
                        + " values (?, ?, ?, ?, ?, ?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, identificador.getId());
                preparedStmt.setString(2, nombre);
                preparedStmt.setString(3, prevencion);
                preparedStmt.setString(4, descripcion);
                preparedStmt.setString(5, medidaAddPlan.getText());
                preparedStmt.setInt(6, Integer.parseInt(probabilidad));
                preparedStmt.setInt(7, Integer.parseInt(perdida));
                preparedStmt.setInt(8, exposicion);
                // execute the preparedstatement
                preparedStmt.execute();
                JOptionPane.showMessageDialog(null, "Se ha creado el plan de contingenia " + nombre + " con éxito");
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            SeleccionarPlan selec = new SeleccionarPlan(project, developer2);
            selec.setLocationRelativeTo(null);
            selec.setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_accAddPlanActionPerformed

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
            java.util.logging.Logger.getLogger(AddPlanContingencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPlanContingencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPlanContingencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPlanContingencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPlanContingencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accAddPlan;
    private javax.swing.JLabel addPlanDescription;
    private javax.swing.JLabel addPlanMedida;
    private javax.swing.JLabel addPlanName;
    private javax.swing.JLabel addPlanPerdida;
    private javax.swing.JLabel addPlanPrevencion;
    private javax.swing.JLabel addPlanProbabilidad;
    private javax.swing.JButton canAddPlan;
    private javax.swing.JTextArea descriptionAddPlan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea medidaAddPlan;
    private javax.swing.JTextField nameAddPlan;
    private javax.swing.JTextField perdidaAddPlan;
    private javax.swing.JTextArea prevencionAddPlan;
    private javax.swing.JTextField probabilidadAddPlan;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

    private int getProbability() {
        return Integer.parseInt(probabilidadAddPlan.getText());
    }

    private int getPerdida() {
        return Integer.parseInt(perdidaAddPlan.getText());
    }
}
