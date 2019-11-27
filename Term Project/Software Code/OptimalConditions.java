/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gem;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nirda
 */
public final class OptimalConditions extends javax.swing.JFrame {

    /**
     * Creates new form OptimalConditions
     */
    public OptimalConditions() {
        initComponents();
        updateLabels();
        
        
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
        optimalConditionsLabel = new javax.swing.JLabel();
        tempLabel = new javax.swing.JLabel();
        humidityLabel = new javax.swing.JLabel();
        lightLabel = new javax.swing.JLabel();
        waterLabel = new javax.swing.JLabel();
        optimalTemp = new javax.swing.JLabel();
        optimalHumidity = new javax.swing.JLabel();
        optimalLight = new javax.swing.JLabel();
        optimalWater = new javax.swing.JLabel();
        tempField = new javax.swing.JTextField();
        humidityField = new javax.swing.JTextField();
        lightField = new javax.swing.JTextField();
        waterField = new javax.swing.JTextField();
        tempButton = new javax.swing.JButton();
        humidityButton = new javax.swing.JButton();
        lightButton = new javax.swing.JButton();
        waterButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        optimalConditionsLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        optimalConditionsLabel.setText("Optimal Condtions");

        tempLabel.setText("Temperature (°C) :");

        humidityLabel.setText("Humidity:");

        lightLabel.setText("Hours of Light: ");

        waterLabel.setText("Amount Watered (mL):");

        tempField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempFieldActionPerformed(evt);
            }
        });

        humidityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humidityFieldActionPerformed(evt);
            }
        });

        lightField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lightFieldActionPerformed(evt);
            }
        });

        tempButton.setText("Change");
        tempButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempButtonActionPerformed(evt);
            }
        });

        humidityButton.setText("Change");
        humidityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humidityButtonActionPerformed(evt);
            }
        });

        lightButton.setText("Change");
        lightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lightButtonActionPerformed(evt);
            }
        });

        waterButton.setText("Change");
        waterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waterButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelALayout = new javax.swing.GroupLayout(PanelA);
        PanelA.setLayout(PanelALayout);
        PanelALayout.setHorizontalGroup(
            PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelALayout.createSequentialGroup()
                .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelALayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(waterLabel)
                            .addComponent(humidityLabel)
                            .addComponent(tempLabel)
                            .addComponent(lightLabel))
                        .addGap(36, 36, 36)
                        .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lightField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(humidityField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelALayout.createSequentialGroup()
                                .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(optimalWater, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelALayout.createSequentialGroup()
                                        .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(optimalHumidity)
                                            .addComponent(optimalTemp))
                                        .addGap(57, 57, 57))
                                    .addComponent(optimalLight, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addComponent(tempField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(waterField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(160, 160, 160)
                        .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tempButton)
                            .addComponent(humidityButton)
                            .addComponent(lightButton)
                            .addComponent(waterButton)))
                    .addGroup(PanelALayout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(optimalConditionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelALayout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addComponent(backButton)))
                .addGap(220, 220, 220))
        );
        PanelALayout.setVerticalGroup(
            PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelALayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(optimalConditionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tempLabel)
                    .addComponent(optimalTemp)
                    .addComponent(tempField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tempButton))
                .addGap(19, 19, 19)
                .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(humidityLabel)
                    .addComponent(optimalHumidity)
                    .addComponent(humidityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(humidityButton))
                .addGap(28, 28, 28)
                .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optimalLight, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lightLabel)
                        .addComponent(lightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lightButton)))
                .addGap(24, 24, 24)
                .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(waterLabel)
                    .addComponent(optimalWater)
                    .addComponent(waterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(waterButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(62, 62, 62))
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

    private void tempButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        updateTemp();   
    }                                          

    private void tempFieldActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void humidityFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              

    }                                             

    private void lightFieldActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void humidityButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        updateHumidity();
    }                                              

    private void lightButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        updateLight();

    }                                           

    private void waterButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        updateWater();
    }                                           

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        dispose();
        new Main().setVisible(true);
    }                                          

    public void updateLabels()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gem","root","Nirda21!ali");
            Statement st = con.createStatement();
            
            ResultSet rs1 = st.executeQuery("SELECT temp FROM optimal");
            while(rs1.next())
            {
                optimalTemp.setText(rs1.getString("temp"));
            }
            
            ResultSet rs2 = st.executeQuery("SELECT humidity FROM optimal");
            while(rs2.next())
            {
                optimalHumidity.setText(rs2.getString("humidity"));
            }
            
            ResultSet rs3 = st.executeQuery("SELECT light FROM optimal");
            while(rs3.next())
            {
                optimalLight.setText(rs3.getString("light"));
            }
            
            ResultSet rs4 = st.executeQuery("SELECT water FROM optimal");
            while(rs4.next())
            {
                optimalWater.setText(rs4.getString("water"));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateTemp()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gem","root","Nirda21!ali");
            Statement st = con.createStatement();
        
            if(Double.valueOf(tempField.getText()) >= 0)
            {
                st.executeUpdate("UPDATE optimal set temp = '" + tempField.getText() + "' where id=1");
                // add message to UI when value added and updated 
                optimalTemp.setText(tempField.getText());
                updateLabels();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OptimalConditions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateHumidity()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gem","root","Nirda21!ali");
            Statement st = con.createStatement();
            
            if(Double.valueOf(humidityField.getText()) >= 0.0)
            {
                st.executeUpdate("UPDATE optimal set humidity = '" + humidityField.getText() + "' where id=1");
                optimalHumidity.setText(humidityField.getText());
                updateLabels();
            }
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OptimalConditions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateLight()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gem","root","Nirda21!ali");
            Statement st = con.createStatement();
            
            if(Integer.valueOf(lightField.getText()) >= 0)
            {
                st.executeUpdate("UPDATE optimal set light = '" + lightField.getText() + "' where id=1");
                optimalLight.setText(lightField.getText());
                updateLabels();
            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OptimalConditions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateWater()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gem","root","Nirda21!ali");
            Statement st = con.createStatement();
            
        
            if(Integer.valueOf(waterField.getText()) >= 0)
            {
                st.executeUpdate("UPDATE optimal set water = '" + waterField.getText() + "' where id=1");
                optimalWater.setText(waterField.getText());
                updateLabels();
            }
            
            } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OptimalConditions.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(OptimalConditions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptimalConditions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptimalConditions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptimalConditions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptimalConditions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel PanelA;
    private javax.swing.JButton backButton;
    private javax.swing.JButton humidityButton;
    private javax.swing.JTextField humidityField;
    private javax.swing.JLabel humidityLabel;
    private javax.swing.JButton lightButton;
    private javax.swing.JTextField lightField;
    private javax.swing.JLabel lightLabel;
    private javax.swing.JLabel optimalConditionsLabel;
    private javax.swing.JLabel optimalHumidity;
    private javax.swing.JLabel optimalLight;
    private javax.swing.JLabel optimalTemp;
    private javax.swing.JLabel optimalWater;
    private javax.swing.JButton tempButton;
    private javax.swing.JTextField tempField;
    private javax.swing.JLabel tempLabel;
    private javax.swing.JButton waterButton;
    private javax.swing.JTextField waterField;
    private javax.swing.JLabel waterLabel;
    // End of variables declaration                   
}
