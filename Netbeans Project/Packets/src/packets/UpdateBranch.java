package packets;


import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;


public class UpdateBranch extends javax.swing.JInternalFrame {

    
        Conexion obj;  
        Connection cn;
        
    public UpdateBranch() {
        initComponents();
        
    }
            
    public void updateBranchMethod(){
        
        int ID = Integer.parseInt(txtID.getText());
        int decision = JOptionPane.showConfirmDialog(this, "All information is correct?", "¡Review the information!", JOptionPane.YES_NO_OPTION, 2);
        
        
         if(decision == 0){
        
        
        if(txtPostalCode.getText().length() < 5){
            JOptionPane.showMessageDialog(rootPane, "Postal Code too short.");  
            return;
                   
        }
                 
                    obj = new Conexion();
                    cn =obj.conectar(); 
                    
                
                            String branchName = txtBranchName.getText();
                            String address = txtAddress.getText();
                            String postalCode = txtPostalCode.getText();
                            String city = txtCity.getText();
                            String state = txtState.getText();
                            String country = txtCountry.getText();
                            String phone = txtPhone.getText();

                   String sql ="UPDATE branchs SET branch_name = ?, address = ?, postal_code = ?, city = ?, state = ?, country = ?, phone = ? WHERE id=?";

                   try{

                       PreparedStatement query = cn.prepareStatement(sql);
                             query.setString(1, branchName);
                             query.setString(2, address);
                             query.setString(3, postalCode);
                             query.setString(4, city);
                             query.setString(5, state);
                             query.setString(6, country);
                             query.setString(7, phone);


                        query.setInt(8, ID);
                        query.execute();
                        
                       JOptionPane.showMessageDialog(this, "Branch has been Updated.");
                       cleanPanels();
                   }catch(Exception e){

                   }   
         }
    } 
        
        
    public void editBranch(){
        
        //cleanPanels();
        String ID = txtID.getText();
        
        
        
        String sql ="SELECT branch_name, address, postal_code, city, state, country, phone FROM branchs WHERE id=?";
        
            try {
                
                obj = new Conexion();
                cn =obj.conectar(); 
                 
                PreparedStatement query = cn.prepareStatement(sql);
                query.setString(1, ID);
                ResultSet rs = query.executeQuery();
                
                if(rs.next()){
                    
                    txtBranchName.setText(rs.getString("name"));
                    txtAddress.setText(rs.getString("address"));
                    txtPhone.setText(rs.getString("phone"));
                    txtPostalCode.setText(rs.getString("postal_code"));
                    txtCity.setText(rs.getString("city"));
                    txtState.setText(rs.getString("state"));
                    txtCountry.setText(rs.getString("country"));
                  
                }
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(UpdateBranch.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    private void cleanPanels(){
        
       txtBranchName.setText("");
       txtAddress.setText("");
       txtPhone.setText("");
       txtPostalCode.setText("");
       txtCity.setText("");
       txtState.setText("");
       txtCountry.setText("");
       txtBranchName.requestFocus();
       
    }
    
    
    private void saveNewBranch(){
        
       if(txtBranchName.getText().equals("") || txtAddress.getText().equals("") || txtPostalCode.getText().equals("") || txtCity.getText().equals("") || txtState.getText().equals("") || txtCountry.getText().equals("") || txtPhone.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please, complete all required fields (*).");
            return;
        }
        
        if(txtPostalCode.getText().length() < 5){
            JOptionPane.showMessageDialog(rootPane, "Postal Code too short.");  
            return;
                   
        }
        
       if (txtPhone.getText().length() < 7) {
            JOptionPane.showMessageDialog(rootPane, "Phone too short.");
            return;

        }

                      
                    obj = new Conexion();
                    cn =obj.conectar(); 



                     String sql ="INSERT INTO branchs (nombre_sucursal, direccion, codigo_postal, ciudad, estado, pais, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";


                     String branchName = txtBranchName.getText();
                     String address = txtAddress.getText();
                     String postalCode = txtPostalCode.getText();
                     String city = txtCity.getText();
                     String state = txtState.getText();
                     String country = txtCountry.getText();
                     String phone = txtPhone.getText();
                     
                         try {
                           PreparedStatement consulta = cn.prepareStatement(sql);
                             consulta.setString(1, branchName);
                             consulta.setString(2, address);
                             consulta.setString(3, postalCode);
                             consulta.setString(4, city);
                             consulta.setString(5, state);
                             consulta.setString(6, country);
                             consulta.setString(7, phone);
                             consulta.execute();
                             cleanPanels();


                           JOptionPane.showMessageDialog(rootPane, "Customer data has been saved.");
                         } catch (SQLException ex) {
                           Logger.getLogger(NewClient.class.getName()).log(Level.SEVERE, null, ex);
                         }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPersonalInformation = new javax.swing.JPanel();
        txtBranchName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPostalCode = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCountry = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtState = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnUpdateBranch = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Edit Branch");
        setPreferredSize(new java.awt.Dimension(704, 587));

        pnlPersonalInformation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Replace the old personal information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        jLabel2.setText("*Branch Name:");

        jLabel4.setText("*Address:");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        jLabel5.setText("*Phone:");

        jLabel1.setText("*Postal Code:");

        txtPostalCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPostalCodeKeyTyped(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit1.png"))); // NOI18N
        btnEdit.setText(" Edit");
        btnEdit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit2.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        txtID.setEnabled(false);

        jLabel18.setText("ID:");

        txtCountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCountryKeyTyped(evt);
            }
        });

        txtCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCityKeyTyped(evt);
            }
        });

        txtState.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStateKeyTyped(evt);
            }
        });

        jLabel7.setText("*State:");

        jLabel6.setText("*City:");

        jLabel8.setText("*Country:");

        javax.swing.GroupLayout pnlPersonalInformationLayout = new javax.swing.GroupLayout(pnlPersonalInformation);
        pnlPersonalInformation.setLayout(pnlPersonalInformationLayout);
        pnlPersonalInformationLayout.setHorizontalGroup(
            pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBranchName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPhone))
                                            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPersonalInformationLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60))))))
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                                .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlPersonalInformationLayout.setVerticalGroup(
            pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(2, 2, 2)
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBranchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnUpdateBranch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update1.png"))); // NOI18N
        btnUpdateBranch.setText("  Update");
        btnUpdateBranch.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update2.png"))); // NOI18N
        btnUpdateBranch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnUpdateBranchFocusGained(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlPersonalInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(btnUpdateBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPersonalInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateBranch)
                    .addComponent(btnClose)
                    .addComponent(btnDelete))
<<<<<<< HEAD
                .addContainerGap(31, Short.MAX_VALUE))
=======
                .addContainerGap(30, Short.MAX_VALUE))
>>>>>>> 864c31e75c00c4ec0be0e298e25342b72037e4c4
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPostalCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPostalCodeKeyTyped
         int postalCodeSize = txtPostalCode.getText().length();
        
        System.out.println("char " +evt.getKeyChar());
         
        
       if(evt.getKeyChar() == KeyEvent.VK_DELETE || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_ENTER ||  evt.getKeyChar() == KeyEvent.VK_TAB ||
               evt.getKeyChar() == KeyEvent.VK_0 || evt.getKeyChar() == KeyEvent.VK_1 || evt.getKeyChar() == KeyEvent.VK_2 || evt.getKeyChar() == KeyEvent.VK_3 || evt.getKeyChar() == KeyEvent.VK_4 || evt.getKeyChar() == KeyEvent.VK_5 || evt.getKeyChar() == KeyEvent.VK_6 || evt.getKeyChar() == KeyEvent.VK_7 || evt.getKeyChar() == KeyEvent.VK_8 || evt.getKeyChar() == KeyEvent.VK_9
       || evt.getKeyChar() == KeyEvent.VK_NUMPAD0 || evt.getKeyChar() == KeyEvent.VK_NUMPAD1 || evt.getKeyChar() == KeyEvent.VK_NUMPAD2 || evt.getKeyChar() == KeyEvent.VK_NUMPAD3 || evt.getKeyChar() == KeyEvent.VK_NUMPAD4 || evt.getKeyChar() == KeyEvent.VK_NUMPAD5 || evt.getKeyChar() == KeyEvent.VK_NUMPAD6 || evt.getKeyChar() == KeyEvent.VK_NUMPAD7 || evt.getKeyChar() == KeyEvent.VK_NUMPAD8 || evt.getKeyChar() == KeyEvent.VK_NUMPAD9){
        
       }else{
           evt.consume();
       }
       
       
        System.out.println("tamaño "+postalCodeSize);
        if(postalCodeSize > 4){
           evt.consume();
           JOptionPane.showMessageDialog(rootPane, "Only five numbers for Postal Code."); 
        }
    }//GEN-LAST:event_txtPostalCodeKeyTyped

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        EditBranch objeto = new EditBranch(this, txtID);
        objeto.setVisible(true);
 

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        
        
        if(txtID.getText().equals("")){
           JOptionPane.showConfirmDialog(this, "You need select one customer first. ", "¡DELETE CUSTOMER!", JOptionPane.YES_NO_OPTION, 1); 
        }else{
            int ID = Integer.parseInt(txtID.getText());
            int decision = JOptionPane.showConfirmDialog(this, "Are you sure? Do you want to delete customer with id: "+ID, "¡DELETE CUSTOMER!", JOptionPane.YES_NO_OPTION, 1);


             if(decision == 0){


                String sql ="UPDATE customers SET date_removed = NOW() WHERE id=?";

                try{

                    PreparedStatement query = cn.prepareStatement(sql);
                    query.setInt(1, ID);
                     query.execute();
                    JOptionPane.showMessageDialog(this, "Customer has been removed.");
                    cleanPanels();
                }catch(Exception e){

                }   
             } 
         } 
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtCountryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCountryKeyTyped
        char campo = evt.getKeyChar();

        if ((campo < 'a' || campo > 'z') && (campo < 'A' || campo > 'Z') && (campo != (char) KeyEvent.VK_BACK_SPACE) && (campo != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Only text", "Validate Text", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txtCountryKeyTyped

    private void txtCityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCityKeyTyped
        char campo = evt.getKeyChar();

        if ((campo < 'a' || campo > 'z') && (campo < 'A' || campo > 'Z') && (campo != (char) KeyEvent.VK_BACK_SPACE) && (campo != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Only text", "Validate Text", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txtCityKeyTyped

    private void txtStateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStateKeyTyped
        char campo = evt.getKeyChar();

        if ((campo < 'a' || campo > 'z') && (campo < 'A' || campo > 'Z') && (campo != (char) KeyEvent.VK_BACK_SPACE) && (campo != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Only text", "Validate Text", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txtStateKeyTyped

    private void btnUpdateBranchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnUpdateBranchFocusGained
          updateBranchMethod();
    }//GEN-LAST:event_btnUpdateBranchFocusGained

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
            java.util.logging.Logger.getLogger(UpdateBranch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateBranch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateBranch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateBranch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateBranch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnUpdateBranch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPanel pnlPersonalInformation;
    private javax.swing.JTextArea txtAddress;
    public javax.swing.JTextField txtBranchName;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPostalCode;
    private javax.swing.JTextField txtState;
    // End of variables declaration//GEN-END:variables
}
