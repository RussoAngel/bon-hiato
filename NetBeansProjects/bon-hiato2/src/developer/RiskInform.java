/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developer;

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
public class RiskInform extends javax.swing.JFrame {

    /**
     * Creates new form RiskInform
     */
    BD bd = new BD();
    private int id;
    Connection connection = bd.conexion();
    private String develop;
    private String projectna;
    private Identificador identificador;
    public RiskInform() {
        initComponents();
    }
    
    public RiskInform(String developer,String projectname){
        
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from informeriesgo");
            while(rs.next()){
                id=Integer.parseInt(rs.getString("id"));
            }
            identificador = new Identificador(id);
        }catch(SQLException e){
            System.out.println("no se pudo acceder");
        }
        develop=developer;
        projectna=projectname;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleRiskInform = new javax.swing.JTextField();
        scroll1 = new javax.swing.JScrollPane();
        descriptionRiskInform = new javax.swing.JTextArea();
        accRiskInform = new javax.swing.JButton();
        canRiskInform = new javax.swing.JButton();
        riskInformTitle = new javax.swing.JLabel();
        riskInformDescription = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bon-Hiato");

        descriptionRiskInform.setColumns(20);
        descriptionRiskInform.setRows(5);
        scroll1.setViewportView(descriptionRiskInform);

        accRiskInform.setText("Enviar");
        accRiskInform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accRiskInformActionPerformed(evt);
            }
        });

        canRiskInform.setText("Cancelar");
        canRiskInform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canRiskInformActionPerformed(evt);
            }
        });

        riskInformTitle.setText("Título del informe");

        riskInformDescription.setText("Descripción");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(canRiskInform, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(accRiskInform, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(riskInformDescription))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(titleRiskInform, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(riskInformTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(riskInformTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleRiskInform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(riskInformDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(accRiskInform)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(canRiskInform)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accRiskInformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accRiskInformActionPerformed
        // TODO add your handling code here:
        if(titleRiskInform.getText().equals("") || descriptionRiskInform.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.");
        }else{
            try{
                String query = " insert into informeriesgo (id, develop, project, tittle, description)"
                    + " values (?, ?, ?, ?, ?)";
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, identificador.getId());
                preparedStmt.setString(2, develop);
                preparedStmt.setString(3, projectna);
                preparedStmt.setString(4, titleRiskInform.getText());
                preparedStmt.setString(5, descriptionRiskInform.getText());

                // execute the preparedstatement
                preparedStmt.execute();

            }catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null, e);
            }
            Task task2 = new Task(projectna,develop);
            task2.setTitle(projectna);
            task2.setLocationRelativeTo(null);
            task2.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_accRiskInformActionPerformed

    private void canRiskInformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canRiskInformActionPerformed
        // TODO add your handling code here:
        Task task2 = new Task(projectna,develop);
        task2.setTitle(projectna);
        task2.setLocationRelativeTo(null);
        task2.setVisible(true);
        dispose();
    }//GEN-LAST:event_canRiskInformActionPerformed

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
            java.util.logging.Logger.getLogger(RiskInform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RiskInform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RiskInform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RiskInform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RiskInform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accRiskInform;
    private javax.swing.JButton canRiskInform;
    private javax.swing.JTextArea descriptionRiskInform;
    private javax.swing.JLabel riskInformDescription;
    private javax.swing.JLabel riskInformTitle;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JTextField titleRiskInform;
    // End of variables declaration//GEN-END:variables
}
