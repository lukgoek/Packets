/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import java.awt.event.KeyEvent;

/**
 *
 * @author genesisaurora
 */
public class UpdateVehicle extends javax.swing.JInternalFrame {

    Conexion obj;  
    Connection cn;
    /**
     * Creates new form UpdateVehicle
     */
    public UpdateVehicle() {
        initComponents();
    }

    public void UpdateVehicle(){
        
         int ID = Integer.parseInt(txtID.getText());
        int decision = JOptionPane.showConfirmDialog(this, "All information is correct?", "¡Review the information!", JOptionPane.YES_NO_OPTION, 2);
    
        
          if(decision == 0){
              
              
               if(txtBrand.getText().equals("") || txtModel.getText().equals("") || txtPlate.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please, complete all required fields (*).");
            return;
        }
    
                obj = new Conexion();
                cn =obj.conectar(); 

        String sql ="UPDATE vehicle SET brand = ?, model = ?, plate = ?, number_vehicle = ?, type_vehicle = ?, driver = ?, status = ? WHERE id = ?";
               
                  String brand = txtBrand.getText();
                  String model = txtModel.getText();
                  String plate = txtPlate.getText();
                  String numbervehicle = txtNumVehicle.getText();
                  String type = comboType.getSelectedItem().toString();
                  String driver = comboDriver.getSelectedItem().toString();
                  String status = btngroupStatus.toString();
                  System.out.println("status "+status);
                 
                     try {
                       PreparedStatement query = cn.prepareStatement(sql);
                         query.setString(1, brand);
                         query.setString(2, model);
                         query.setString(3, plate);
                         query.setString(4, numbervehicle);
                         query.setString(5, type);
                         query.setString(6, driver);
                         query.setString(7, status);
                         
                         
                         query.setInt(8, ID);
                         query.execute();


                             JOptionPane.showMessageDialog(rootPane, "Vehicle data has been saved.");
                             cleanPanels();
                     } catch (SQLException ex) {
                         Logger.getLogger(UpdateVehicle.class.getName()).log(Level.SEVERE, null, ex);
                     }
          }
    }
     public void editVehicle(){
        
        //cleanPanels();
        String ID = txtID.getText();
        
        
        String type = "";
        String driver = "";
        
        String sql ="SELECT brand, model, plate, number_vehicle, type_vehicle, driver, status FROM vehicle WHERE id=?";
        
            try {
                
                obj = new Conexion();
                cn =obj.conectar(); 
                 
                PreparedStatement query = cn.prepareStatement(sql);
                query.setString(1, ID);
                ResultSet rs = query.executeQuery();
                
                if(rs.next()){
                    
                    txtBrand.setText(rs.getString("marca"));
                    txtPlate.setText(rs.getString("placa"));
                    txtModel.setText(rs.getString("modelo"));
                    txtNumVehicle.setText(rs.getString("numero_vehiculo"));
                    
                    type = rs.getString("tipo_vehiculo");
                    
                    int tamañoCombo = comboType.getItemCount();
                    //System.out.println(tamañoCombo);
                    
                  for(int i=0; i<tamañoCombo; i++){
                      
                      String comboContenido = comboType.getItemAt(i).toString();
                      System.out.println(comboContenido);
                      System.out.println(type+" --- "+comboContenido);
                      
                      if(comboContenido.equals(type)){
                          comboType.setSelectedIndex(i);
                                  System.out.println(type+" entro "+comboContenido);
                          break;
                      }
                      
                      
                  }
                    
                    
                    
                }
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(UpdateVehicle.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
      public void cleanPanels(){
        
       txtBrand.setText("");
       txtModel.setText("");
       txtPlate.setText("");
      
     }
       public void saveNewVehicle(){
         
             
         if(txtBrand.getText().equals("") || txtModel.getText().equals("") || txtPlate.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please, complete all required fields (*).");
            return;
        }
    
                obj = new Conexion();
                cn =obj.conectar(); 

        String sql ="INSERT INTO vehicle (brand, model, plate, number_vehicle, type_vehicle, driver, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
               
                  String brand = txtBrand.getText();
                  String model = txtModel.getText();
                  String plate = txtPlate.getText();
                  String numbervehicle = txtNumVehicle.getText();
                  String type = comboType.getSelectedItem().toString();
                  String driver = comboDriver.getSelectedItem().toString();
                  String status = btngroupStatus.toString();
                  System.out.println("status "+status);
                 
                     try {
                       PreparedStatement query = cn.prepareStatement(sql);
                         query.setString(1, brand);
                         query.setString(2, model);
                         query.setString(3, plate);
                         query.setString(4, numbervehicle);
                         query.setString(5, type);
                         query.setString(6, driver);
                         query.setString(7, status);
                         query.execute();
                         
                         cleanPanels();


                             JOptionPane.showMessageDialog(rootPane, "Vehicle data has been saved.");
                     } catch (SQLException ex) {
                         Logger.getLogger(UpdateVehicle.class.getName()).log(Level.SEVERE, null, ex);
                     }
   
         }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngroupStatus = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtModel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPlate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNumVehicle = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboDriver = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        optAvailable = new javax.swing.JRadioButton();
        optBusy = new javax.swing.JRadioButton();
        optDamaged = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        comboType = new javax.swing.JComboBox();
        btnEdit = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        btnUpdateCustomer = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vehicle Description", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        jLabel3.setText("*Model:");

        jLabel4.setText("*Plate:");

        jLabel5.setText("*Number Vehicle:");

        jLabel6.setText("*Driver:");

        jLabel9.setText("*Type: ");

        comboDriver.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gabino Cortez", "Paul Lopez", "Humberto Lugo" }));
        comboDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDriverActionPerformed(evt);
            }
        });

        jLabel10.setText("*Status:");

        btngroupStatus.add(optAvailable);
        optAvailable.setText("Available");

        btngroupStatus.add(optBusy);
        optBusy.setText("Busy");

        btngroupStatus.add(optDamaged);
        optDamaged.setText("Damaged");
        optDamaged.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDamagedActionPerformed(evt);
            }
        });

        jLabel12.setText("*Brand:");

        comboType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Trailer", "Camion", "Camioneta" }));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit1.png"))); // NOI18N
        btnEdit.setText(" Edit");
        btnEdit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit2.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addComponent(jLabel10))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optAvailable)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(comboDriver, 0, 153, Short.MAX_VALUE)
                                        .addGap(19, 19, 19))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNumVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtBrand, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(txtPlate, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(optBusy)
                        .addComponent(optDamaged)))
                .addGap(79, 79, 79))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEdit)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPlate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(optAvailable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(optBusy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(optDamaged)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnUpdateCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update1.png"))); // NOI18N
        btnUpdateCustomer.setText("  Update");
        btnUpdateCustomer.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update2.png"))); // NOI18N
        btnUpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCustomerActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close1.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close2.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close1.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close2.png"))); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnUpdateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateCustomer)
                    .addComponent(btnDelete)
                    .addComponent(btnClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDriverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDriverActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        UpdateVehicle obj = new UpdateVehicle();
        MainMDI MainMDI = new MainMDI();
        obj.setBounds(50, 50, 650, 700);

        obj.setVisible(true);

        MainMDI.add(obj);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCustomerActionPerformed

        UpdateVehicle();
    }//GEN-LAST:event_btnUpdateCustomerActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int ID = Integer.parseInt(txtID.getText());
        int decision = JOptionPane.showConfirmDialog(this, "Are you sure? Do you want to delete customer with id: "+ID, "¡DELETE CUSTOMER!", JOptionPane.YES_NO_OPTION, 1);

        if(decision == 0){

            String sql ="UPDATE vehicle SET removed_date = NOW() WHERE id=?";

            try{

                PreparedStatement query = cn.prepareStatement(sql);
                query.setInt(1, ID);
                query.execute();
                JOptionPane.showMessageDialog(this, "Vehicle has been removed.");
                cleanPanels();
            }catch(Exception e){

            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void optDamagedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDamagedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optDamagedActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateVehicle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnUpdateCustomer;
    private javax.swing.ButtonGroup btngroupStatus;
    private javax.swing.JComboBox comboDriver;
    private javax.swing.JComboBox comboType;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton optAvailable;
    private javax.swing.JRadioButton optBusy;
    private javax.swing.JRadioButton optDamaged;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtNumVehicle;
    private javax.swing.JTextField txtPlate;
    // End of variables declaration//GEN-END:variables
}
