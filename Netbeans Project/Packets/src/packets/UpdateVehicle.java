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
import java.sql.Statement;

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
    
    public void updateComboTypeVehicle(){
         obj = new Conexion();
        cn =obj.conectar();
        
        
        comboTypeVehicle.removeAllItems();
        
     
        //declaramos la consulta
        String sql ="SELECT capacity_weight, type FROM type_vehicles";
        
        String []datos;
   
        try{
            //Objeto statement es una consulta preparada
            //se obtiene de la conexion
            Statement consulta = cn.createStatement();  
            //resultSet objeto que pèrmite recorrer las filas en una consulta
            ResultSet rs = consulta.executeQuery(sql);
        
            //.next() manda al siguiente registro (devuelve true si tiene informacion)
            while(rs.next()){
                //asignamos tamaño al arreglo
                datos = new String[8];
                
                //.getString(); recoge datos
                datos[1] = rs.getString("capacity_weight");
                datos[2] = rs.getString("type");
                comboTypeVehicle.addItem(datos[0]);
            }
        
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
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

        String sql ="UPDATE vehicles SET brand = ?, model = ?, plate = ?, number_vehicle = ?, type_vehicle = ?, driver = ?, status = ? WHERE id = ?";
               
                  String brand = txtBrand.getText();
                  String model = txtModel.getText();
                  String plate = txtPlate.getText();
                  String numbervehicle = txtNumVehicle.getText();
                  String type = comboTypeVehicle.getSelectedItem().toString();
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
        
        String sql ="SELECT brand, model, plate, number_vehicle, type_vehicle, driver, status FROM vehicles WHERE id=?";
        
            try {
                
                obj = new Conexion();
                cn =obj.conectar(); 
                 
                PreparedStatement query = cn.prepareStatement(sql);
                query.setString(1, ID);
                ResultSet rs = query.executeQuery();
                
                if(rs.next()){
                    
                    txtBrand.setText(rs.getString("brand"));
                    txtPlate.setText(rs.getString("plate"));
                    txtModel.setText(rs.getString("model"));
                    txtNumVehicle.setText(rs.getString("number_vehicle"));
                    
                    type = rs.getString("type_vehicle");
                    
                    int tamañoCombo = comboTypeVehicle.getItemCount();
                    //System.out.println(tamañoCombo);
                    
                  for(int i=0; i<tamañoCombo; i++){
                      
                      String comboContenido = comboTypeVehicle.getItemAt(i).toString();
                      System.out.println(comboContenido);
                      System.out.println(type+" --- "+comboContenido);
                      
                      if(comboContenido.equals(type)){
                          comboTypeVehicle.setSelectedIndex(i);
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

        String sql ="INSERT INTO vehicles (brand, model, plate, number_vehicle, type_vehicle, driver, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
               
                  String brand = txtBrand.getText();
                  String model = txtModel.getText();
                  String plate = txtPlate.getText();
                  String numbervehicle = txtNumVehicle.getText();
                  String type = comboTypeVehicle.getSelectedItem().toString();
                  String driver = comboDriver.getSelectedItem().toString();
                  String status = comboStatus.getSelectedItem().toString();
                 
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
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        comboTypeVehicle = new javax.swing.JComboBox();
        btnEdit = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        btnEdit1 = new javax.swing.JButton();
        comboStatus = new javax.swing.JComboBox();
        btnUpdateVehicle = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit Vehicle", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N
        setClosable(true);
        setIconifiable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Replace the old vehicle information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

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

        jLabel12.setText("*Brand:");

        comboTypeVehicle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Camion 3 axes", "Camion 4 axes", "Camion 6 axes", "Van" }));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit1.png"))); // NOI18N
        btnEdit.setText(" Edit");
        btnEdit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit2.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnEdit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit1.png"))); // NOI18N
        btnEdit1.setText(" Edit");
        btnEdit1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit2.png"))); // NOI18N
        btnEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit1ActionPerformed(evt);
            }
        });
        btnEdit1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnEdit1FocusGained(evt);
            }
        });

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Busy", "Damaged" }));

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
                                .addComponent(comboTypeVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                            .addComponent(comboTypeVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        btnUpdateVehicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update1.png"))); // NOI18N
        btnUpdateVehicle.setText("  Update");
        btnUpdateVehicle.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update2.png"))); // NOI18N
        btnUpdateVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateVehicleActionPerformed(evt);
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

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete1.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete2.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnUpdateVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUpdateVehicle)
                        .addComponent(btnClose))
                    .addComponent(btnDelete))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDriverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDriverActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
         EditVehicle objeto = new EditVehicle(this, txtID);
        objeto.setVisible(true);
        objeto.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateVehicleActionPerformed

        UpdateVehicle();
    }//GEN-LAST:event_btnUpdateVehicleActionPerformed

    private void btnEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit1ActionPerformed
               NewTypeVehicle objeto = new NewTypeVehicle();
               objeto.setVisible(true);
    }//GEN-LAST:event_btnEdit1ActionPerformed

    private void btnEdit1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnEdit1FocusGained
        updateComboTypeVehicle();
    }//GEN-LAST:event_btnEdit1FocusGained

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        if(txtID.getText().equals("")){
            JOptionPane.showConfirmDialog(this, "You need select one vehicle first. ", "¡DELETE VEHICLE!", JOptionPane.YES_NO_OPTION, 1);
        }else{
            int ID = Integer.parseInt(txtID.getText());
            int decision = JOptionPane.showConfirmDialog(this, "Are you sure? Do you want to delete vehicle with id: "+ID, "¡DELETE VEHICLE!", JOptionPane.YES_NO_OPTION, 1);

            if(decision == 0){

                String sql ="UPDATE vehicles SET removed_date = NOW() WHERE id=?";

                try{

                    PreparedStatement query = cn.prepareStatement(sql);
                    query.setInt(1, ID);
                    query.execute();
                    JOptionPane.showMessageDialog(this, "Vehicle has been removed.");
                    cleanPanels();
                }catch(Exception e){

                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
    private javax.swing.JButton btnEdit1;
    private javax.swing.JButton btnUpdateVehicle;
    private javax.swing.ButtonGroup btngroupStatus;
    private javax.swing.JComboBox comboDriver;
    private javax.swing.JComboBox comboStatus;
    private javax.swing.JComboBox comboTypeVehicle;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtNumVehicle;
    private javax.swing.JTextField txtPlate;
    // End of variables declaration//GEN-END:variables
}
