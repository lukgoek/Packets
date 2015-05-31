
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packets;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

/**
 *
 * @author HbTO
 */
public class NewClient extends javax.swing.JInternalFrame {

    Conexion obj;
    Connection cn;

    public NewClient() {
        initComponents();
        this.repaint();
    }

    private void cleanPanels() {

        txtLastName.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        txtPostalCode.setText("");
        txtCity.setText("");
        txtState.setText("");
        txtCountry.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        txtEmail.setText("");
        txtConfirmEmail.setText("");
        txtRFC.setText("");
        txtPosition.setText("");

        txtLastName.requestFocus();

    }

    private void saveNewClient() {
        System.out.println("contraseña: " + txtPassword.getText());
        //recogemos el email
        String email = txtEmail.getText();
        String companyName = txtCompanyName.getText();
        String rfc = txtRFC.getText();
        String position = txtPosition.getText();

        //si las cajas de email estan basias asignamos null
        if (txtEmail.getText().equals("") && txtConfirmEmail.getText().equals("")) {
            email = "NULL";
        }

        if (txtCompanyName.getText().equals("")) {
            companyName = "NULL";
        }

        if (txtRFC.getText().equals("")) {
            rfc = "NULL";
        }

        if (txtPosition.getText().equals("")) {
            position = "NULL";
        }

        if (txtLastName.getText().equals("") || txtName.getText().equals("") || txtAddress.getText().equals("") || txtPhone.getText().equals("") || txtPostalCode.getText().equals("") || txtCity.getText().equals("") || txtState.getText().equals("") || txtCountry.getText().equals("") || txtName.getText().equals("") || txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtConfirmPassword.getText().equals("")) {
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

        if (txtPassword.getText().equals(txtConfirmPassword.getText())) {
            if (txtEmail.getText().equals(txtConfirmEmail.getText())) {
                if (txtPassword.getText().length() >= 8) {

                    obj = new Conexion();
                    cn = obj.conectar();

                    String sql = "INSERT INTO customers (name, last_name, address, phone, postal_code, city, state, country, degree, email, username, password, company_name, rfc, position) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, MD5(?), ?, ?, ?)";

                    String lastName = txtLastName.getText();
                    String name = txtName.getText();
                    String address = txtAddress.getText();
                    String phone = txtPhone.getText();
                    String postalCode = txtPostalCode.getText();
                    String city = txtCity.getText();
                    String state = txtState.getText();
                    String country = txtCountry.getText();
                    String degree = comboDegree.getSelectedItem().toString();

                    String username = txtUsername.getText();
                    String password = txtPassword.getText();

                    try {
                        PreparedStatement query = cn.prepareStatement(sql);
                        query.setString(1, lastName);
                        query.setString(2, name);
                        query.setString(3, address);
                        query.setString(4, phone);
                        query.setString(5, postalCode);
                        query.setString(6, city);
                        query.setString(7, state);
                        query.setString(8, country);
                        query.setString(9, degree);
                        query.setString(10, email);
                        query.setString(11, username);
                        query.setString(12, password);
                        query.setString(13, companyName);
                        query.setString(14, rfc);
                        query.setString(15, position);
                        query.execute();

                        cleanPanels();

                        JOptionPane.showMessageDialog(rootPane, "Customer data has been saved.");
                    } catch (SQLException ex) {
                        Logger.getLogger(NewClient.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Password too short.");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "The e-mails do not match.");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "The passwords do not match.");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPersonalInformation = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
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
        jLabel12 = new javax.swing.JLabel();
        comboDegree = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmPassword = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        txtConfirmEmail = new javax.swing.JTextField();
        pnlCompanyInformation = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        txtRFC = new javax.swing.JTextField();
        txtCompanyName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("New Customer");
        setPreferredSize(new java.awt.Dimension(704, 587));

        pnlPersonalInformation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        jLabel6.setText("*City:");

        txtLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLastNameKeyTyped(evt);
            }
        });

        jLabel7.setText("*State:");

        jLabel2.setText("*Last Name:");

        jLabel8.setText("*Country:");

        jLabel3.setText("*Name:");

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPostalCodeKeyPressed(evt);
            }
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

        jLabel12.setText("*Degree:");

        comboDegree.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dr.", "Lic.", "Dra.", "QFB." }));

        jLabel13.setText("e-mail:");

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        jLabel14.setText("*Username:");

        jLabel15.setText("*Password:");

        jLabel16.setText("*Confirm Password:");

        jLabel17.setText("Confirm e-mail:");

        javax.swing.GroupLayout pnlPersonalInformationLayout = new javax.swing.GroupLayout(pnlPersonalInformation);
        pnlPersonalInformation.setLayout(pnlPersonalInformationLayout);
        pnlPersonalInformationLayout.setHorizontalGroup(
            pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCountry, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtState, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCity)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail)
                                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                                        .addComponent(comboDegree, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtConfirmEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                    .addComponent(txtConfirmPassword))))
                        .addContainerGap())
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName)
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
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(comboDegree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtConfirmEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCompanyInformation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Company Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        jLabel9.setText("Name:");

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("RFC?:");

        jLabel11.setText("Position:");

        javax.swing.GroupLayout pnlCompanyInformationLayout = new javax.swing.GroupLayout(pnlCompanyInformation);
        pnlCompanyInformation.setLayout(pnlCompanyInformationLayout);
        pnlCompanyInformationLayout.setHorizontalGroup(
            pnlCompanyInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCompanyInformationLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlCompanyInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCompanyInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCompanyInformationLayout.createSequentialGroup()
                        .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPosition, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))
                .addGap(231, 231, 231))
        );
        pnlCompanyInformationLayout.setVerticalGroup(
            pnlCompanyInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCompanyInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCompanyInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCompanyInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCompanyInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCompanyInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save1.png"))); // NOI18N
        btnSave.setText("  Save");
        btnSave.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save2.png"))); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlCompanyInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlPersonalInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPersonalInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(pnlCompanyInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(btnClose)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        saveNewClient();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtPostalCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPostalCodeKeyPressed


    }//GEN-LAST:event_txtPostalCodeKeyPressed

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

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtLastNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastNameKeyTyped
        char campo = evt.getKeyChar();

        if ((campo < 'a' || campo > 'z') && (campo < 'A' || campo > 'Z') && (campo != (char) KeyEvent.VK_BACK_SPACE) && (campo != (char) KeyEvent.VK_SPACE)) {
            evt.consume();

        }
    }//GEN-LAST:event_txtLastNameKeyTyped

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        char campo = evt.getKeyChar();

        if ((campo < 'a' || campo > 'z') && (campo < 'A' || campo > 'Z') && (campo != (char) KeyEvent.VK_BACK_SPACE) && (campo != (char) KeyEvent.VK_SPACE)) {
            evt.consume();

        }
    }//GEN-LAST:event_txtNameKeyTyped

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
        if (phoneSize > 8) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Only five numbers for Phone.");
        }
    }//GEN-LAST:event_txtPhoneKeyTyped

    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        } else {

            return false;

        }
    }

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (isEmail(txtEmail.getText())) {

        } else {
            JOptionPane.showMessageDialog(null, "Incorrect email", "Validate Email", JOptionPane.INFORMATION_MESSAGE);
            txtEmail.requestFocus();

        }
    }//GEN-LAST:event_txtEmailFocusLost

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
            java.util.logging.Logger.getLogger(NewClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox comboDegree;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCompanyInformation;
    public javax.swing.JPanel pnlPersonalInformation;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtConfirmEmail;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    public javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtPostalCode;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
