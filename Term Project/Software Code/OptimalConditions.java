/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nirda
 */
public final class OptimalConditions extends javax.swing.JFrame {
    
    String user = Login.getUsername(); //Username of the user. To be used for inputting into the database

    /**
     * Creates new form called OptimalConditions. This form can then
     * be used to input the optimal conditions into the database.
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public OptimalConditions() throws ClassNotFoundException, SQLException {
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
        optimalTemp = new javax.swing.JLabel();
        optimalHumidity = new javax.swing.JLabel();
        optimalLight = new javax.swing.JLabel();
        tempField = new javax.swing.JTextField();
        humidityField = new javax.swing.JTextField();
        lightField = new javax.swing.JTextField();
        tempButton = new javax.swing.JButton();
        humidityButton = new javax.swing.JButton();
        lightButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        watertimeLabel = new javax.swing.JLabel();
        waterintervalLabel = new javax.swing.JLabel();
        watertimeField = new javax.swing.JTextField();
        waterintervalField = new javax.swing.JTextField();
        watertimeButton = new javax.swing.JButton();
        waterintervalButton = new javax.swing.JButton();
        optimalWaterinterval = new javax.swing.JLabel();
        optimalWatertime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelA.setBackground(new java.awt.Color(36, 47, 65));

        optimalConditionsLabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        optimalConditionsLabel.setForeground(new java.awt.Color(204, 204, 204));
        optimalConditionsLabel.setText("Optimal Condtions");

        tempLabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        tempLabel.setForeground(new java.awt.Color(204, 204, 204));
        tempLabel.setText("Temperature (°C) :");

        humidityLabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        humidityLabel.setForeground(new java.awt.Color(204, 204, 204));
        humidityLabel.setText("Humidity:");

        lightLabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lightLabel.setForeground(new java.awt.Color(204, 204, 204));
        lightLabel.setText("Light Level:");

        optimalTemp.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        optimalTemp.setForeground(new java.awt.Color(255, 255, 255));

        optimalHumidity.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        optimalHumidity.setForeground(new java.awt.Color(255, 255, 255));

        optimalLight.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        optimalLight.setForeground(new java.awt.Color(255, 255, 255));

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

        tempButton.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        tempButton.setText("Change");
        tempButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempButtonActionPerformed(evt);
            }
        });

        humidityButton.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        humidityButton.setText("Change");
        humidityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humidityButtonActionPerformed(evt);
            }
        });

        lightButton.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lightButton.setText("Change");
        lightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lightButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        watertimeLabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        watertimeLabel.setForeground(new java.awt.Color(204, 204, 204));
        watertimeLabel.setText("Water time (seconds):");

        waterintervalLabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        waterintervalLabel.setForeground(new java.awt.Color(204, 204, 204));
        waterintervalLabel.setText("Water Interval (seconds):");

        watertimeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watertimeFieldActionPerformed(evt);
            }
        });

        waterintervalField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waterintervalFieldActionPerformed(evt);
            }
        });

        watertimeButton.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        watertimeButton.setText("Change");
        watertimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watertimeButtonActionPerformed(evt);
            }
        });

        waterintervalButton.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        waterintervalButton.setText("Change");
        waterintervalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waterintervalButtonActionPerformed(evt);
            }
        });

        optimalWaterinterval.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        optimalWaterinterval.setForeground(new java.awt.Color(255, 255, 255));

        optimalWatertime.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        optimalWatertime.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelALayout = new javax.swing.GroupLayout(PanelA);
        PanelA.setLayout(PanelALayout);
        PanelALayout.setHorizontalGroup(
            PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelALayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tempLabel)
                    .addComponent(lightLabel)
                    .addComponent(watertimeLabel)
                    .addComponent(waterintervalLabel)
                    .addComponent(humidityLabel))
                .addGap(36, 36, 36)
                .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optimalWaterinterval, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(optimalWatertime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(optimalTemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(optimalHumidity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(optimalLight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lightField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tempField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(watertimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(waterintervalField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(humidityField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(watertimeButton, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tempButton)
                            .addComponent(humidityButton)
                            .addComponent(lightButton)))
                    .addComponent(waterintervalButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(212, 212, 212))
            .addGroup(PanelALayout.createSequentialGroup()
                .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelALayout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(optimalConditionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelALayout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelALayout.setVerticalGroup(
            PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelALayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(optimalConditionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PanelALayout.createSequentialGroup()
                        .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tempButton)
                            .addComponent(tempField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(humidityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(humidityButton)))
                    .addGroup(PanelALayout.createSequentialGroup()
                        .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(optimalTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tempLabel))
                        .addGap(25, 25, 25)
                        .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(humidityLabel)
                            .addComponent(optimalHumidity, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lightLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lightButton)
                        .addComponent(lightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(optimalLight, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelALayout.createSequentialGroup()
                        .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(optimalWaterinterval, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(waterintervalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(waterintervalButton))
                        .addGap(25, 25, 25)
                        .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelALayout.createSequentialGroup()
                                .addComponent(optimalWatertime, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                .addGap(5, 5, 5))
                            .addGroup(PanelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(watertimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(watertimeButton))))
                    .addGroup(PanelALayout.createSequentialGroup()
                        .addComponent(waterintervalLabel)
                        .addGap(25, 25, 25)
                        .addComponent(watertimeLabel)))
                .addGap(41, 41, 41)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
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
    
    /**
     * This method updates optimal temperature in the database when 
     * the change button for the temperature is pressed
     * @param evt 
     */
    private void tempButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {   
            updateTemp();
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(OptimalConditions.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(OptimalConditions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                          

    private void tempFieldActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void humidityFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              

    }                                             

    private void lightFieldActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
    }                                          
    
    /**
     * This method updates optimal humidity in the database when 
     * the change button for the humidity is pressed
     * @param evt 
     */
    private void humidityButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        try {
            updateHumidity();
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(OptimalConditions.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(OptimalConditions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                              
    
    /**
     * This method updates optimal light level in the database when 
     * the change button for the light level is pressed
     * @param evt 
     */
    private void lightButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            updateLight();
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(OptimalConditions.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(OptimalConditions.class.getName()).log(Level.SEVERE, null, ex);
        }

    }                                           
    /**
     * This method allows the user to go back to the main window which
     * displays the current conditions
     * @param evt 
     */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        dispose();
        new MainWindow().setVisible(true);
    }                                          

    private void watertimeFieldActionPerformed(java.awt.event.ActionEvent evt) {                                               
   
    }                                              

    private void waterintervalFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                   

    }                                                  

    /**
     * This method updates optimal watering time in the database when 
     * the change button for the watering time is pressed
     * @param evt 
     */
    private void watertimeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        String user = Login.getUsername();
        
        try {
            String query1 = "UPDATE optimal_conditions set Optimal_WaterTime = '"+ watertimeField.getText() + "' WHERE Username = '"+ user +"';";
            LinkJavaMySQL.insertQuery(query1);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(OptimalConditions.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        optimalWatertime.setText(watertimeField.getText());
        watertimeField.setText("");
        
        Thread object = new Thread(new UpdateWaterTime());
        object.start();
    }                                               

    /**
     * This method updates optimal watering time interval in the database when 
     * the change button for the watering time interval is pressed
     * @param evt 
     */
    private void waterintervalButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        String user = Login.getUsername();
        
        try {
            String query1 = "UPDATE optimal_conditions set Optimal_WaterTimeInterval = '"+ waterintervalField.getText() + "' WHERE Username = '"+ user +"';";
            LinkJavaMySQL.insertQuery(query1);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(OptimalConditions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        optimalWaterinterval.setText(waterintervalField.getText());
        waterintervalField.setText("");
        Thread object = new Thread(new UpdateWaterTime());
        object.start();
    }                                                   
    
    /**
     * This method updates the labels displaying the optimal conditions 
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void updateLabels() throws ClassNotFoundException, SQLException{
        /*
        Below is the query used in the database to acquire the current optimal 
        conditions set in the database
        */
        String query = "SELECT Optimal_Temperature, Optimal_Humidity,Optimal_LightLevel,Optimal_WaterTime,Optimal_WaterTimeInterval FROM optimal_conditions WHERE Username = '"+ user +"';";
        ResultSet rs = LinkJavaMySQL.selectQuery(query);
        Object[] newValues = new Object[5];
        
        while(rs.next()){
            newValues[0] = rs.getFloat("Optimal_Temperature");
            newValues[1] = rs.getFloat("Optimal_Humidity");
            newValues[2] = rs.getInt("Optimal_LightLevel");
            newValues[3] = rs.getInt("Optimal_WaterTime");
            newValues[4] = rs.getInt("Optimal_WaterTimeInterval");
        }
        
        optimalTemp.setText(String.valueOf(newValues[0]));
        optimalHumidity.setText(String.valueOf(newValues[1]));
        optimalLight.setText(String.valueOf(newValues[2])); 
        optimalWatertime.setText(String.valueOf(newValues[3]));
        optimalWaterinterval.setText(String.valueOf(newValues[4]));
    }
    
    /**
     * This method updates the optimal temperature in the database
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void updateTemp() throws ClassNotFoundException, SQLException{
        if(Float.valueOf(tempField.getText()) >= 0){
            String query = "UPDATE optimal_conditions set Optimal_Temperature = '" + tempField.getText() + "' WHERE Username = '"+ user +"';";
            LinkJavaMySQL.insertQuery(query);
            
            // add message to UI when value added and updated 
            optimalTemp.setText(tempField.getText());
            updateLabels();
            tempField.setText("");
        }
    }
    
    /**
     * This method updates the optimal humidity in the database
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void updateHumidity() throws ClassNotFoundException, SQLException{
        if(Float.valueOf(humidityField.getText()) >= 0){
            String query = "UPDATE optimal_conditions set Optimal_Humidity = '" + humidityField.getText() + "' WHERE Username = '"+ user +"';";
            LinkJavaMySQL.insertQuery(query);
            
            // add message to UI when value added and updated 
            optimalHumidity.setText(humidityField.getText());
            updateLabels();
            humidityField.setText("");
        }
    }
    
    /**
     * This method updates the optimal light level in the database
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void updateLight() throws ClassNotFoundException, SQLException{
        if(Float.valueOf(lightField.getText()) >= 0){
            String query = "UPDATE optimal_conditions set Optimal_LightLevel = '" + lightField.getText() + "' WHERE Username = '"+ user +"';";
            LinkJavaMySQL.insertQuery(query);
            
            // add message to UI when value added and updated 
            lightField.setText(lightField.getText());
            updateLabels();
            lightField.setText("");
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException {
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
                try {            
                    new OptimalConditions().setVisible(true);
                } 
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(OptimalConditions.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (SQLException ex) {
                    Logger.getLogger(OptimalConditions.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    private javax.swing.JLabel optimalWaterinterval;
    private javax.swing.JLabel optimalWatertime;
    private javax.swing.JButton tempButton;
    private javax.swing.JTextField tempField;
    private javax.swing.JLabel tempLabel;
    private javax.swing.JButton waterintervalButton;
    private javax.swing.JTextField waterintervalField;
    private javax.swing.JLabel waterintervalLabel;
    private javax.swing.JButton watertimeButton;
    private javax.swing.JTextField watertimeField;
    private javax.swing.JLabel watertimeLabel;
    // End of variables declaration                   
}
