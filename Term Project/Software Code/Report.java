/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nirda
 */
public class Report extends javax.swing.JFrame {

    /**
     * Creates new form Report
     */
    public Report() throws SQLException, ClassNotFoundException {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        PanelA = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        changeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelA.setBackground(new java.awt.Color(36, 47, 65));

        myTable.setBackground(new java.awt.Color(36, 47, 65));
        myTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        myTable.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        myTable.setForeground(new java.awt.Color(204, 204, 204));
        myTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(myTable);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("10 Most Recent Updates");

        changeButton.setText("Display");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelALayout = new javax.swing.GroupLayout(PanelA);
        PanelA.setLayout(PanelALayout);
        PanelALayout.setHorizontalGroup(
            PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelALayout.createSequentialGroup()
                .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelALayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelALayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel1))
                    .addGroup(PanelALayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(changeButton)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        PanelALayout.setVerticalGroup(
            PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelALayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(changeButton)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
            makeTable();
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                            

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
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
        
                try {
                    new Report().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
    public void makeTable() throws SQLException, ClassNotFoundException
    {
        String user = Login.getUsername();
        String[] column = {"Date Time", "Temperature", "Humidity","Light Level"};
        Object[][] data = ControlPi.getData();
        
        String[][] dataStr = new String[10][4]; 
        System.out.println(data);
        
        for(int row=0; row<=9; row++)
            {
                for(int col=0; col <= 3; col++)
                {
                    dataStr[row][col] = data[row][col].toString();
                   
                }
            }
        DefaultTableModel model = (DefaultTableModel) myTable.getModel();
        model.setDataVector(dataStr,column);

    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel PanelA;
    private javax.swing.JButton changeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable myTable;
    // End of variables declaration                   
}
