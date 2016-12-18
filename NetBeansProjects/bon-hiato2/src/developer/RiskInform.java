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
        develop=developer;
        projectna=projectname;
        initComponents();
        jLabel1.setText("<Html>"+projectna+"/Informe</Html>");
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        riskInformTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        titleRiskInform = new javax.swing.JTextField();
        riskInformDescription = new javax.swing.JLabel();
        scroll1 = new javax.swing.JScrollPane();
        descriptionRiskInform = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        accRiskInform = new javax.swing.JButton();
        canRiskInform = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bon-Hiato");
        getContentPane().setLayout(new java.awt.GridLayout(0, 1));

        riskInformTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        riskInformTitle.setText("Título del informe");
        getContentPane().add(riskInformTitle);

        titleRiskInform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleRiskInformActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(titleRiskInform, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(titleRiskInform, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2);

        riskInformDescription.setText("Descripción");
        getContentPane().add(riskInformDescription);

        scroll1.setPreferredSize(new java.awt.Dimension(400, 102));

        descriptionRiskInform.setColumns(20);
        descriptionRiskInform.setRows(5);
        scroll1.setViewportView(descriptionRiskInform);

        getContentPane().add(scroll1);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(accRiskInform, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(canRiskInform, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(canRiskInform, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accRiskInform, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);

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
                JOptionPane.showMessageDialog(null, "Se ha enviado el informe correctamente");
            }catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null, e);
            }
            Task task2 = new Task(projectna,develop);
            task2.tittle(projectna);
            task2.setLocationRelativeTo(null);
            task2.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_accRiskInformActionPerformed

    private void canRiskInformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canRiskInformActionPerformed
        // TODO add your handling code here:
        Task task2 = new Task(projectna,develop);
        task2.tittle(projectna);
        task2.setLocationRelativeTo(null);
        task2.setVisible(true);
        dispose();
    }//GEN-LAST:event_canRiskInformActionPerformed

    private void titleRiskInformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleRiskInformActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleRiskInformActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel riskInformDescription;
    private javax.swing.JLabel riskInformTitle;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JTextField titleRiskInform;
    // End of variables declaration//GEN-END:variables
}
