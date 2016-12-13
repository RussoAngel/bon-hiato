/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scm;

/**
 *
 * @author yonay
 */
public class Gestion extends javax.swing.JFrame {

    /**
     * Creates new form Gestion
     */
    private String proj;
    private String develop;
    public Gestion() {
        initComponents();
    }
    
    public Gestion(String project,String dev){
        initComponents();
        proj=project;
        develop=dev;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addTaskGestion = new javax.swing.JButton();
        modTaskGestion = new javax.swing.JButton();
        addSprintsGestion = new javax.swing.JButton();
        sprintsGestion = new javax.swing.JButton();
        informesGestion = new javax.swing.JButton();
        planesGestion = new javax.swing.JButton();
        estimarGestion = new javax.swing.JButton();
        addResourcesGestion = new javax.swing.JButton();
        canGestion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bon-Hiato");

        addTaskGestion.setText("Crear Tarea");
        addTaskGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskGestionActionPerformed(evt);
            }
        });

        modTaskGestion.setText("Editar Tarea");
        modTaskGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modTaskGestionActionPerformed(evt);
            }
        });

        addSprintsGestion.setText("Crear Sprint");
        addSprintsGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSprintsGestionActionPerformed(evt);
            }
        });

        sprintsGestion.setText("Visualizar Sprints");
        sprintsGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sprintsGestionActionPerformed(evt);
            }
        });

        informesGestion.setText("Ver Informes");
        informesGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informesGestionActionPerformed(evt);
            }
        });

        planesGestion.setText("Ver Planes de contingencia");
        planesGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planesGestionActionPerformed(evt);
            }
        });

        estimarGestion.setText("Realizar Estimación");
        estimarGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estimarGestionActionPerformed(evt);
            }
        });

        addResourcesGestion.setText("Añadir Recursos");
        addResourcesGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addResourcesGestionActionPerformed(evt);
            }
        });

        canGestion.setText("Cancelar");
        canGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canGestionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(estimarGestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addTaskGestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modTaskGestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addSprintsGestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(planesGestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sprintsGestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addResourcesGestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(informesGestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(canGestion)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canGestion)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTaskGestion)
                    .addComponent(sprintsGestion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modTaskGestion)
                    .addComponent(informesGestion))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addSprintsGestion)
                    .addComponent(planesGestion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estimarGestion)
                    .addComponent(addResourcesGestion))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void informesGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informesGestionActionPerformed
        // TODO add your handling code here:
        SeleccionarInforme select = new SeleccionarInforme(proj,develop);
        select.setLocationRelativeTo(null);
        select.setVisible(true);
        dispose();
    }//GEN-LAST:event_informesGestionActionPerformed

    private void addTaskGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTaskGestionActionPerformed
        // TODO add your handling code here:
        AddTask2 addTask2 = new AddTask2(proj,develop);
        addTask2.setLocationRelativeTo(null);
        addTask2.setVisible(true);
        dispose();
    }//GEN-LAST:event_addTaskGestionActionPerformed

    private void sprintsGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sprintsGestionActionPerformed
        // TODO add your handling code here:
        SelectSprint selectSprint= new SelectSprint(proj,develop);
        selectSprint.setLocationRelativeTo(null);
        selectSprint.setVisible(true);
        dispose();
    }//GEN-LAST:event_sprintsGestionActionPerformed

    private void modTaskGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modTaskGestionActionPerformed
        // TODO add your handling code here:
        SelectTask updateTask = new SelectTask(proj,develop);
        updateTask.setLocationRelativeTo(null);
        updateTask.setVisible(true);
        dispose();
    }//GEN-LAST:event_modTaskGestionActionPerformed

    private void addSprintsGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSprintsGestionActionPerformed
        // TODO add your handling code here:
        CreateSprint createSprint = new CreateSprint(proj,develop);
        createSprint.setLocationRelativeTo(null);
        createSprint.setVisible(true);
        dispose();
                
    }//GEN-LAST:event_addSprintsGestionActionPerformed

    private void estimarGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estimarGestionActionPerformed
        // TODO add your handling code here:
        RealizarStimacion realizarStimacion = new RealizarStimacion(proj,develop);
        realizarStimacion.setLocationRelativeTo(null);
        realizarStimacion.setVisible(true);
        dispose();
    }//GEN-LAST:event_estimarGestionActionPerformed

    private void addResourcesGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addResourcesGestionActionPerformed
        // TODO add your handling code here:
        SelectResource selectResource = new SelectResource(proj,develop);
        selectResource.setLocationRelativeTo(null);
        selectResource.setVisible(true);
        dispose();
    }//GEN-LAST:event_addResourcesGestionActionPerformed

    private void canGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canGestionActionPerformed
        // TODO add your handling code here:
        ScrumMaster sr = new ScrumMaster(develop);
        sr.setLocationRelativeTo(null);
        sr.setVisible(true);
        dispose();
    }//GEN-LAST:event_canGestionActionPerformed

    private void planesGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planesGestionActionPerformed
        // TODO add your handling code here:
        SeleccionarPlan selec = new SeleccionarPlan(proj,develop);
        selec.setLocationRelativeTo(null);
        selec.setVisible(true);
        dispose();
    }//GEN-LAST:event_planesGestionActionPerformed

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
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addResourcesGestion;
    private javax.swing.JButton addSprintsGestion;
    private javax.swing.JButton addTaskGestion;
    private javax.swing.JButton canGestion;
    private javax.swing.JButton estimarGestion;
    private javax.swing.JButton informesGestion;
    private javax.swing.JButton modTaskGestion;
    private javax.swing.JButton planesGestion;
    private javax.swing.JButton sprintsGestion;
    // End of variables declaration//GEN-END:variables
}
