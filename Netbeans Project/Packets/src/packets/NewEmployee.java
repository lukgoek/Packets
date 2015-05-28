package packets;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author fimaz
 */
public class NewEmployee extends javax.swing.JInternalFrame {

    Conexion obj;
    Connection cn;

    public NewEmployee() {
        initComponents();
        
        updateComboBrachs();
        
        updateComboTypeEmployee();
    }

    public void cleanPanels() {

        txtLastName.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        txtPostalCode.setText("");
        txtEmail.setText("");
        txtConfirmEmail.setText("");

        txtLastName.requestFocus();

    }
    
    public void updateComboTypeEmployee(){
         obj = new Conexion();
         cn =obj.conectar();
        
        
        comboTypeEmployee.removeAllItems();
        
     
        //declaramos la consulta
        String sql ="SELECT description FROM type_employee";
        
        String []datos;
   
        try{
            //Objeto statement es una consulta preparada
            //se obtiene de la conexion
            Statement query = cn.createStatement();  
            //resultSet objeto que pèrmite recorrer las filas en una consulta
            ResultSet rs = query.executeQuery(sql);
        
            //.next() manda al siguiente registro (devuelve true si tiene informacion)
            while(rs.next()){
                //asignamos tamaño al arreglo
                datos = new String[8];
                
                //.getString(); recoge datos
                datos[0] = rs.getString("description");
                comboTypeEmployee.addItem(datos[0]);
            }
        
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
    }
    
    public void updateComboBrachs(){
         obj = new Conexion();
         cn =obj.conectar();
        
        
        comboBranch.removeAllItems();
        
     
        //declaramos la consulta
        String sql ="SELECT branch_name FROM branchs";
        
        String []datos;
   
        try{
            //Objeto statement es una consulta preparada
            //se obtiene de la conexion
            Statement query = cn.createStatement();  
            //resultSet objeto que pèrmite recorrer las filas en una consulta
            ResultSet rs = query.executeQuery(sql);
        
            //.next() manda al siguiente registro (devuelve true si tiene informacion)
            while(rs.next()){
                //asignamos tamaño al arreglo
                datos = new String[1];
                
                //.getString(); recoge datos
                datos[0] = rs.getString("branch_name");
                comboBranch.addItem(datos[0]);
            }
        
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
    }

    
    public void saveNewEmployee() {

        //recogemos el email
        String email = txtEmail.getText();

        //si las cajas de email estan basias asignamos null
        //esta valida que sean iguales a vacias y si son vacias agrega NULL
        if (txtEmail.getText().equals("") && txtConfirmEmail.getText().equals("")) {
            email = "NULL";
        }

        if (txtLastName.getText().equals("") || txtName.getText().equals("") || txtAddress.getText().equals("") || txtPhone.getText().equals("") || txtPostalCode.getText().equals("")) {
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

        //y esta valida que sean igual por ejemplo weroJOto = weroJOto
        if (txtEmail.getText().equals(txtConfirmEmail.getText())) {

            //estaba entrando en conflictos con el return
            //va asi we despues de la validacion de email
            obj = new Conexion();
            cn = obj.conectar();

            String sql = "INSERT INTO employees (last_name, name, address, phone, postal_code, branch, type_employee,email, sex) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            String lastName = txtLastName.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String phone = txtPhone.getText();
            String postalCode = txtPostalCode.getText();
            String sex = comboSex.getSelectedItem().toString();
            String branch = comboBranch.getSelectedItem().toString();
            String typeEmployee = comboTypeEmployee.getSelectedItem().toString();

            try {
                PreparedStatement query = cn.prepareStatement(sql);

                query.setString(1, lastName);
                query.setString(2, name);
                query.setString(3, address);
                query.setString(4, phone);
                query.setString(5, postalCode);
                query.setString(6, branch);
                query.setString(7, typeEmployee);
                query.setString(8, email);
                query.setString(9, sex);
                query.execute();
                cleanPanels();

                JOptionPane.showMessageDialog(rootPane, "Employee data has been saved.");
            } catch (SQLException ex) {
                Logger.getLogger(NewEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "The e-mails do not match.");
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

        pnlPersonalInformation = new javax.swing.JPanel();
        txtLastName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPostalCode = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        comboSex = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        txtConfirmEmail = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        comboTypeEmployee = new javax.swing.JComboBox();
        btnEditDrivers = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        comboBranch = new javax.swing.JComboBox();
        btnEditBranch = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        pnlPersonalInformation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Employee", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        txtLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLastNameKeyTyped(evt);
            }
        });

        jLabel2.setText("*Last Name:");

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPostalCodeKeyTyped(evt);
            }
        });

        jLabel12.setText("*Sex:");

        comboSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        jLabel13.setText("*E-mail:");

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        jLabel17.setText("Confirm e-mail:");

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit1.png"))); // NOI18N
        btnEdit.setText(" Edit");
        btnEdit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit2.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee"));

        comboTypeEmployee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Drivers", "Secretary", "Manager", " " }));

        btnEditDrivers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit1.png"))); // NOI18N
        btnEditDrivers.setText(" Edit");
        btnEditDrivers.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit2.png"))); // NOI18N
        btnEditDrivers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDriversActionPerformed(evt);
            }
        });
        btnEditDrivers.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnEditDriversFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboTypeEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditDrivers)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(comboTypeEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnEditDrivers))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Branchs"));

        comboBranch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mazatlàn", "Culiacán", "Guadalajara" }));

        btnEditBranch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit1.png"))); // NOI18N
        btnEditBranch.setText("Edit");
        btnEditBranch.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit2.png"))); // NOI18N
        btnEditBranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBranchActionPerformed(evt);
            }
        });
        btnEditBranch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnEditBranchFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditBranch)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(comboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnEditBranch))
        );

        javax.swing.GroupLayout pnlPersonalInformationLayout = new javax.swing.GroupLayout(pnlPersonalInformation);
        pnlPersonalInformation.setLayout(pnlPersonalInformationLayout);
        pnlPersonalInformationLayout.setHorizontalGroup(
            pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPersonalInformationLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtConfirmEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 318, Short.MAX_VALUE))
            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(comboSex, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPersonalInformationLayout.setVerticalGroup(
            pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnEdit)))
                .addGap(18, 18, 18)
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(37, 37, 37)
                        .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfirmEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(comboSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlPersonalInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlPersonalInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnClose))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        saveNewEmployee();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        UpdateCustomer obj = new UpdateCustomer();
        MainMDI MainMDI = new MainMDI();
        obj.setBounds(50, 50, 650, 700);

        obj.setVisible(true);

        MainMDI.add(obj);
    }//GEN-LAST:event_btnEditActionPerformed


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

    private void txtLastNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastNameKeyTyped
        char campo = evt.getKeyChar();

        if ((campo < 'a' || campo > 'z') && (campo < 'A' || campo > 'Z') && (campo != (char) KeyEvent.VK_BACK_SPACE) && (campo != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Only text", "Validate Text", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txtLastNameKeyTyped

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        char campo = evt.getKeyChar();

        if ((campo < 'a' || campo > 'z') && (campo < 'A' || campo > 'Z') && (campo != (char) KeyEvent.VK_BACK_SPACE) && (campo != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Only text", "Validate Text", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyTyped
           int phoneSize = txtPhone.getText().length();
        
        System.out.println("char " +evt.getKeyChar());
         
        
       if(evt.getKeyChar() == KeyEvent.VK_DELETE || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_ENTER ||  evt.getKeyChar() == KeyEvent.VK_TAB ||
               evt.getKeyChar() == KeyEvent.VK_0 || evt.getKeyChar() == KeyEvent.VK_1 || evt.getKeyChar() == KeyEvent.VK_2 || evt.getKeyChar() == KeyEvent.VK_3 || evt.getKeyChar() == KeyEvent.VK_4 || evt.getKeyChar() == KeyEvent.VK_5 || evt.getKeyChar() == KeyEvent.VK_6 || evt.getKeyChar() == KeyEvent.VK_7 || evt.getKeyChar() == KeyEvent.VK_8 || evt.getKeyChar() == KeyEvent.VK_9
       || evt.getKeyChar() == KeyEvent.VK_NUMPAD0 || evt.getKeyChar() == KeyEvent.VK_NUMPAD1 || evt.getKeyChar() == KeyEvent.VK_NUMPAD2 || evt.getKeyChar() == KeyEvent.VK_NUMPAD3 || evt.getKeyChar() == KeyEvent.VK_NUMPAD4 || evt.getKeyChar() == KeyEvent.VK_NUMPAD5 || evt.getKeyChar() == KeyEvent.VK_NUMPAD6 || evt.getKeyChar() == KeyEvent.VK_NUMPAD7 || evt.getKeyChar() == KeyEvent.VK_NUMPAD8 || evt.getKeyChar() == KeyEvent.VK_NUMPAD9){
        
       }else{
           evt.consume();
       }
       
       
        System.out.println("tamaño "+phoneSize);
        if(phoneSize > 4){
           evt.consume();
           JOptionPane.showMessageDialog(rootPane, "Only five numbers for Phone."); 
        }  
    }//GEN-LAST:event_txtPhoneKeyTyped

    private void btnEditDriversActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDriversActionPerformed
        NewTypeEmployee objeto = new NewTypeEmployee();
        objeto.setVisible(true);
    }//GEN-LAST:event_btnEditDriversActionPerformed

    private void btnEditDriversFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnEditDriversFocusGained
        updateComboTypeEmployee();
    }//GEN-LAST:event_btnEditDriversFocusGained

    private void btnEditBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBranchActionPerformed
        NewTypeBranch objeto = new NewTypeBranch();
        objeto.setVisible(true);
    }//GEN-LAST:event_btnEditBranchActionPerformed

    private void btnEditBranchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnEditBranchFocusGained
     
    }//GEN-LAST:event_btnEditBranchFocusGained

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
            java.util.logging.Logger.getLogger(NewEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEditBranch;
    private javax.swing.JButton btnEditDrivers;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox comboBranch;
    private javax.swing.JComboBox comboSex;
    private javax.swing.JComboBox comboTypeEmployee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPanel pnlPersonalInformation;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtConfirmEmail;
    private javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPostalCode;
    // End of variables declaration//GEN-END:variables
}
