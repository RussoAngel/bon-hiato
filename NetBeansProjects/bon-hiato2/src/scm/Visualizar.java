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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author yonay
 */
public class Visualizar extends javax.swing.JFrame {

    /**
     * Creates new form Visualizar
     */
    private String project;
    private String sprint;
    BD bd = new BD();
    private String idsprint;
    private String name;
    private String id;
    private String priority;
    private String description;
    private int duration;
    private String state;
    private String hours;
    private String develop;
    private String projectname;
    private String duration2;
    
    Connection connection = bd.conexion();
    
    List<String> tareas = new ArrayList<>();
    private String developer;
    public Visualizar() {
        initComponents();
    }
    public Visualizar(String proj,String spr,String dev){
        initComponents();
        project=proj;
        developer=dev;
        sprint = spr;
        sprintNameVisualizar.setText("<Html>"+project+" /"+sprint+" /VisualizarSprint</Html>");
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from sprint");
            
            while(rs.next()){
                
                if(rs.getString("name").equals(sprint)){
                    idsprint=rs.getString("id");
                }
            }
        }catch(SQLException e){
            System.out.println("no se pudo acceder");
        } 
        
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from task");
            
            while(rs.next()){
                    if(rs.getString("sprint").equals(idsprint)){
                         duration+=Integer.parseInt(rs.getString("duration"));
                    }
                    
                         
            }
            durationVisualizar.setText(String.valueOf(duration));
        }catch(SQLException e){
            System.out.println("no se pudo acceder");
        }
        
        
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from sprint");
            
            while(rs.next()){
                
                if(rs.getString("name").equals(sprint)){
                    
                    fechaIniVisualizar.setText(rs.getString("fechaini"));
                    String[] fechaini=rs.getString("fechaini").split("-");
                    Integer diaini=Integer.parseInt(fechaini[2]);
                    Integer mesini=Integer.parseInt(fechaini[1]);
                    Integer yearini=Integer.parseInt(fechaini[0]);
                    
                    System.out.println(duration);
                    mesini=mesini-1;
                    Calendar calendar = new GregorianCalendar(yearini,mesini,diaini);
                    System.out.println(calendar.getTime());
                    calendar.add(Calendar.DAY_OF_MONTH, duration);
                    System.out.println(calendar.getTime()); 
                    String calendario = String.valueOf(calendar.getTime());
                    String[] calen = calendario.split(" ");
                    String mesnumber="";
                    String mes=calen[1];
                    if(mes.equals("Jan"))mesnumber="01";
                    if(mes.equals("Feb"))mesnumber="02";
                    if(mes.equals("Mar"))mesnumber="03";
                    if(mes.equals("Apr"))mesnumber="04";
                    if(mes.equals("May"))mesnumber="05";
                    if(mes.equals("Jun"))mesnumber="06";
                    if(mes.equals("Jul"))mesnumber="07";
                    if(mes.equals("Aug"))mesnumber="08";
                    if(mes.equals("Sep"))mesnumber="09";
                    if(mes.equals("Oct"))mesnumber="10";
                    if(mes.equals("Nov"))mesnumber="11";
                    if(mes.equals("Dec"))mesnumber="12";
        
                    String calendariofinal = (calen[5] + "-" + mesnumber + "-" +  calen[2]);
                    System.out.println(calendariofinal);
                    fechaFinVisualizar.setText(calendariofinal);
                }
            }
            
        }catch(SQLException e){
            System.out.println("no se pudo acceder");
        }
        
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from task");
            
            while(rs.next()){
                
                if(rs.getString("sprint").equals(idsprint)){
                    tareas.add(rs.getString("name"));
                }
            }
            if(tareas.size()>0){
                String[] mylist = new String[tareas.size()];
                mylist = tareas.toArray(mylist);
                taskListVisualizar.setListData(mylist);
            }
            
        }catch(SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
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

        jLabel8 = new javax.swing.JLabel();
        visualizarFechaIni = new javax.swing.JLabel();
        visualizarFechaFin = new javax.swing.JLabel();
        visualizarDuration = new javax.swing.JLabel();
        fechaIniVisualizar = new javax.swing.JLabel();
        fechaFinVisualizar = new javax.swing.JLabel();
        durationVisualizar = new javax.swing.JLabel();
        canVisualizar = new javax.swing.JButton();
        sprintNameVisualizar = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        taskListVisualizar = new javax.swing.JList<String>();
        remTaskVisualizar = new javax.swing.JButton();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bon-Hiato");

        visualizarFechaIni.setText("Fecha de inicio");

        visualizarFechaFin.setText("Fecha final");

        visualizarDuration.setText("Duración");

        fechaIniVisualizar.setText("jLabel4");

        fechaFinVisualizar.setText("jLabel5");

        durationVisualizar.setText("jLabel6");

        canVisualizar.setText("Salir");
        canVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canVisualizarActionPerformed(evt);
            }
        });

        sprintNameVisualizar.setText("SprintName");

        scroll.setViewportView(taskListVisualizar);

        remTaskVisualizar.setText("Eliminar tarea");
        remTaskVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remTaskVisualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(visualizarFechaIni)
                            .addComponent(fechaIniVisualizar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(116, Short.MAX_VALUE)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(remTaskVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(canVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(fechaFinVisualizar)))
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sprintNameVisualizar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(durationVisualizar)
                            .addComponent(visualizarDuration))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(visualizarFechaFin)
                        .addGap(49, 49, 49))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(sprintNameVisualizar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(visualizarDuration)
                    .addComponent(visualizarFechaFin)
                    .addComponent(visualizarFechaIni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaIniVisualizar)
                    .addComponent(durationVisualizar)
                    .addComponent(fechaFinVisualizar))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(remTaskVisualizar)
                        .addGap(18, 18, 18)
                        .addComponent(canVisualizar))
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void canVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canVisualizarActionPerformed
        // TODO add your handling code here:
        SelectSprint selec = new SelectSprint(project,developer);
        selec.setLocationRelativeTo(null);
        selec.setVisible(true);
        dispose();
    }//GEN-LAST:event_canVisualizarActionPerformed

    private void remTaskVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remTaskVisualizarActionPerformed
        // TODO add your handling code here:
        String task=taskListVisualizar.getSelectedValue();
        
        if(task == null){
            JOptionPane.showMessageDialog(null, "Seleccione una tarea para borrar.");
        }else{
            int respuesta=JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres eliminar esta tarea del sprint?");
            if(respuesta==0){
            try{
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("select * from task");
                while(rs.next()){
                    if(task.equals(rs.getString("name"))){
                        name=rs.getString("name");
                        priority=rs.getString("priority");
                        description=rs.getString("description");
                        duration2=rs.getString("duration");
                        state=rs.getString("state");
                        hours=rs.getString("hours");
                        projectname=rs.getString("Projects");
                        develop=rs.getString("develop");
                        id= rs.getString("id");
                    }
                }
            }catch(SQLException e){
                System.out.println("no se pudo acceder");
            }
            System.out.println(name+" "+priority+" "+description+" "+duration+" "+state+" "+hours+" "+projectname+" "+develop+" "+id);
            try {
                String sql = "UPDATE task set Projects='"+projectname+"',name='"
                +name+"',duration='"+duration+"',priority='"
                +priority+"',description='"
                +description+"',state='"
                +state+"',hours='"
                +hours+"',develop='"
                +develop+"',sprint='"
                +"0"+"' where id='"
                +id+"'";
            PreparedStatement pst=connection.prepareStatement(sql);
            pst.execute();

            } catch (SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null, e);
            }
            Visualizar visualizar= new Visualizar(project,sprint,developer);
            visualizar.setLocationRelativeTo(null);
            visualizar.setVisible(true);
            dispose();
            }
        }
    }//GEN-LAST:event_remTaskVisualizarActionPerformed

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
            java.util.logging.Logger.getLogger(Visualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visualizar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton canVisualizar;
    private javax.swing.JLabel durationVisualizar;
    private javax.swing.JLabel fechaFinVisualizar;
    private javax.swing.JLabel fechaIniVisualizar;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton remTaskVisualizar;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JLabel sprintNameVisualizar;
    private javax.swing.JList<String> taskListVisualizar;
    private javax.swing.JLabel visualizarDuration;
    private javax.swing.JLabel visualizarFechaFin;
    private javax.swing.JLabel visualizarFechaIni;
    // End of variables declaration//GEN-END:variables
}
