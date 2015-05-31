package packets;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import packets.Conexion;
import packets.NewClient;

public class NewBranch extends javax.swing.JInternalFrame {

    Conexion obj;
    Connection cn;

    public NewBranch() {
        initComponents();
    }

    public void cleanPanels() {

        txtBranchName.setText("");
        txtAddress.setText("");
        txtPostalCode.setText("");
        txtCity.setText("");
        txtState.setText("");
        txtCountry.setText("");
        txtPhone.setText("");

        txtBranchName.requestFocus();

    }

    public void saveNewBranch() {

        if (txtBranchName.getText().equals("") || txtAddress.getText().equals("") || txtPostalCode.getText().equals("") || txtCity.getText().equals("") || txtState.getText().equals("") || txtCountry.getText().equals("") || txtPhone.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please, complete all required fields (*).");
            return;
        }

        if (txtPostalCode.getText().length() < 5) {
            JOptionPane.showMessageDialog(rootPane, "Postal Code too short.");
            return;

        }

        if (txtPhone.getText().length() < 7) {
            JOptionPane.showMessageDialog(rootPane, "Phone too short.");
            return;

        }

        obj = new Conexion();
        cn = obj.conectar();

        String sql = "INSERT INTO branchs (branch_name, address, postal_code, city, state, country, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";

        String branchName = txtBranchName.getText();
        String address = txtAddress.getText();
        String postalCode = txtPostalCode.getText();
        String city = txtCity.getText();
        String state = txtState.getText();
        String country = txtCountry.getText();
        String phone = txtPhone.getText();

        try {
            PreparedStatement query = cn.prepareStatement(sql);
            query.setString(1, branchName);
            query.setString(2, address);
            query.setString(3, postalCode);
            query.setString(4, city);
            query.setString(5, state);
            query.setString(6, country);
            query.setString(7, phone);
            query.execute();
            cleanPanels();

            JOptionPane.showMessageDialog(rootPane, "Customer data has been saved.");
        } catch (SQLException ex) {
            Logger.getLogger(NewBranch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPersonalInformation = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtBranchName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPostalCode = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtState = new javax.swing.JTextField();
        txtCountry = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        pnlPersonalInformation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Branch", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        jLabel6.setText("*City:");

        txtBranchName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBranchNameKeyTyped(evt);
            }
        });

        jLabel7.setText("*State:");

        jLabel2.setText("*Branch Name:");

        jLabel8.setText("*Country:");

        jLabel4.setText("*Address:");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        jLabel5.setText("*Phone:");

        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneKeyTyped(evt);
            }
        });

        jLabel1.setText("*Postal Code:");

        txtPostalCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPostalCodeKeyTyped(evt);
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

        txtCountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCountryKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlPersonalInformationLayout = new javax.swing.GroupLayout(pnlPersonalInformation);
        pnlPersonalInformation.setLayout(pnlPersonalInformationLayout);
        pnlPersonalInformationLayout.setHorizontalGroup(
            pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel2))
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                                .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBranchName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addGap(0, 10, Short.MAX_VALUE))))))
        );
        pnlPersonalInformationLayout.setVerticalGroup(
            pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBranchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close1.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close2.png"))); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save1.png"))); // NOI18N
        btnSave.setText("  Save");
        btnSave.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save2.png"))); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(186, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlPersonalInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(31, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(292, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnClose))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlPersonalInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPostalCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPostalCodeKeyTyped
        int postalCodeSize = txtPostalCode.getText().length();

        System.out.println("char " + evt.getKeyChar());

        if (evt.getKeyChar() == KeyEvent.VK_DELETE || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_ENTER || evt.getKeyChar() == KeyEvent.VK_TAB
                || evt.getKeyChar() == KeyEvent.VK_0 || evt.getKeyChar() == KeyEvent.VK_1 || evt.getKeyChar() == KeyEvent.VK_2 || evt.getKeyChar() == KeyEvent.VK_3 || evt.getKeyChar() == KeyEvent.VK_4 || evt.getKeyChar() == KeyEvent.VK_5 || evt.getKeyChar() == KeyEvent.VK_6 || evt.getKeyChar() == KeyEvent.VK_7 || evt.getKeyChar() == KeyEvent.VK_8 || evt.getKeyChar() == KeyEvent.VK_9
                || evt.getKeyChar() == KeyEvent.VK_NUMPAD0 || evt.getKeyChar() == KeyEvent.VK_NUMPAD1 || evt.getKeyChar() == KeyEvent.VK_NUMPAD2 || evt.getKeyChar() == KeyEvent.VK_NUMPAD3 || evt.getKeyChar() == KeyEvent.VK_NUMPAD4 || evt.getKeyChar() == KeyEvent.VK_NUMPAD5 || evt.getKeyChar() == KeyEvent.VK_NUMPAD6 || evt.getKeyChar() == KeyEvent.VK_NUMPAD7 || evt.getKeyChar() == KeyEvent.VK_NUMPAD8 || evt.getKeyChar() == KeyEvent.VK_NUMPAD9) {

        } else {
            evt.consume();
        }

        System.out.println("tamaño " + postalCodeSize);
        if (postalCodeSize > 4) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Only five numbers for Postal Code.");
        }
    }//GEN-LAST:event_txtPostalCodeKeyTyped

    private void txtBranchNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBranchNameKeyTyped
        char campo = evt.getKeyChar();

        if ((campo < 'a' || campo > 'z') && (campo < 'A' || campo > 'Z') && (campo != (char) KeyEvent.VK_BACK_SPACE) && (campo != (char) KeyEvent.VK_SPACE)) {
            evt.consume();

        }
    }//GEN-LAST:event_txtBranchNameKeyTyped

    private void txtCityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCityKeyTyped
        char campo = evt.getKeyChar();

        if ((campo < 'a' || campo > 'z') && (campo < 'A' || campo > 'Z') && (campo != (char) KeyEvent.VK_BACK_SPACE) && (campo != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        
        }
    }//GEN-LAST:event_txtCityKeyTyped

    private void txtStateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStateKeyTyped
        char campo = evt.getKeyChar();

        if ((campo < 'a' || campo > 'z') && (campo < 'A' || campo > 'Z') && (campo != (char) KeyEvent.VK_BACK_SPACE) && (campo != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        
        }
    }//GEN-LAST:event_txtStateKeyTyped

    private void txtCountryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCountryKeyTyped
        char campo = evt.getKeyChar();

        if ((campo < 'a' || campo > 'z') && (campo < 'A' || campo > 'Z') && (campo != (char) KeyEvent.VK_BACK_SPACE) && (campo != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        
        }
    }//GEN-LAST:event_txtCountryKeyTyped

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        saveNewBranch();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyTyped
        int phoneSize = txtPhone.getText().length();

        System.out.println("char " + evt.getKeyChar());

        if (evt.getKeyChar() == KeyEvent.VK_DELETE || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_ENTER || evt.getKeyChar() == KeyEvent.VK_TAB
                || evt.getKeyChar() == KeyEvent.VK_0 || evt.getKeyChar() == KeyEvent.VK_1 || evt.getKeyChar() == KeyEvent.VK_2 || evt.getKeyChar() == KeyEvent.VK_3 || evt.getKeyChar() == KeyEvent.VK_4 || evt.getKeyChar() == KeyEvent.VK_5 || evt.getKeyChar() == KeyEvent.VK_6 || evt.getKeyChar() == KeyEvent.VK_7 || evt.getKeyChar() == KeyEvent.VK_8 || evt.getKeyChar() == KeyEvent.VK_9
                || evt.getKeyChar() == KeyEvent.VK_NUMPAD0 || evt.getKeyChar() == KeyEvent.VK_NUMPAD1 || evt.getKeyChar() == KeyEvent.VK_NUMPAD2 || evt.getKeyChar() == KeyEvent.VK_NUMPAD3 || evt.getKeyChar() == KeyEvent.VK_NUMPAD4 || evt.getKeyChar() == KeyEvent.VK_NUMPAD5 || evt.getKeyChar() == KeyEvent.VK_NUMPAD6 || evt.getKeyChar() == KeyEvent.VK_NUMPAD7 || evt.getKeyChar() == KeyEvent.VK_NUMPAD8 || evt.getKeyChar() == KeyEvent.VK_NUMPAD9) {

        } else {
            evt.consume();
        }

        System.out.println("tamaño " + phoneSize);
        if (phoneSize > 9) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Only nine numbers for Phone.");
        }
    }//GEN-LAST:event_txtPhoneKeyTyped

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
            java.util.logging.Logger.getLogger(NewBranch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewBranch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewBranch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewBranch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewBranch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlPersonalInformation;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtBranchName;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPostalCode;
    private javax.swing.JTextField txtState;
    // End of variables declaration//GEN-END:variables
}
