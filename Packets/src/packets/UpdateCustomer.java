
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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

/**
 *
 * @author HbTO
 */
public class UpdateCustomer extends javax.swing.JInternalFrame {

    
        Conexion obj;  
        Connection cn;
        
    public UpdateCustomer() {
        initComponents();
        updateComboDegree();
    }
    
    
    public void updateComboDegree(){
         obj = new Conexion();
        cn =obj.conectar();
        
        
        comboDegree.removeAllItems();
        
     
        //declaramos la consulta
        String sql ="SELECT descripcion FROM tipo_titulo";
        
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
                datos[0] = rs.getString("descripcion");
                comboDegree.addItem(datos[0]);
            }
        
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
    }
    
    
    public void updateCustomerMethod(){
        
        int ID = Integer.parseInt(txtID.getText());
        int decision = JOptionPane.showConfirmDialog(this, "All information is correct?", "¡Review the information!", JOptionPane.YES_NO_OPTION, 2);
        
        
         if(decision == 0){
             
        String email = txtEmail.getText();
        String companyName = txtCompanyName.getText();
        String rfc = txtRFC.getText();
        String position = txtPosition.getText();
        
        //si las cajas de email estan basias asignamos null
        if(txtEmail.getText().equals("") && txtConfirmEmail.getText().equals("")){
            email = "NULL";
        }
        
        if(txtCompanyName.getText().equals("")){
            companyName = "NULL";
        }
        
        if(txtRFC.getText().equals("")){
            rfc = "NULL";
        }
        
        if(txtPosition.getText().equals("")){
            position = "NULL";
        }
        
        if(txtLastName.getText().equals("") || txtName.getText().equals("") || txtAddress.getText().equals("") || txtPhone.getText().equals("") || txtPostalCode.getText().equals("") || txtCity.getText().equals("") || txtState.getText().equals("") || txtCountry.getText().equals("") || txtName.getText().equals("") || txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtConfirmPassword.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please, complete all required fields (*).");
            return;
        }
        
        if(txtPostalCode.getText().length() < 5){
            JOptionPane.showMessageDialog(rootPane, "Postal Code too short.");  
            return;
                   
        }
        
        
        
        
        if(txtPassword.getText().equals(txtConfirmPassword.getText())){
            if(txtEmail.getText().equals(txtConfirmEmail.getText())){
                if(txtPassword.getText().length() >= 8){
                    
                    obj = new Conexion();
                    cn =obj.conectar(); 
                    
                
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

                   String sql ="UPDATE clientes SET nombre = ?, apellidos = ?, direccion = ?, telefono = ?, codigo_postal = ?, ciudad = ?, estado = ?, pais = ?, titulo = ?, email = ?, nombre_usuario = ?, contraseña = ?, nombre_compañia = ?, rfc = ?, puesto = ? WHERE id=?";

                   try{

                       PreparedStatement query = cn.prepareStatement(sql);
                            query.setString(1, name);
                             query.setString(2, lastName);
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



                        query.setInt(16, ID);
                        query.execute();
                        
                       JOptionPane.showMessageDialog(this, "Customer has been Updated.");
                       cleanPanels();
                   }catch(Exception e){

                   }   
                }else{
                   JOptionPane.showMessageDialog(rootPane, "Password too short."); 
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "The e-mails do not match.");
            }
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "The passwords do not match.");
        }
    } 
        
        
    }

    
    
    public void editCustomer(){
        
        //cleanPanels();
        String ID = txtID.getText();
        
        
        String degree = "";
        
        String sql ="SELECT nombre, apellidos, direccion, telefono, codigo_postal, ciudad, estado, pais, nombre_usuario, email, nombre_compañia, rfc, puesto, titulo FROM clientes WHERE id=?";
        
            try {
                
                obj = new Conexion();
                cn =obj.conectar(); 
                 
                PreparedStatement query = cn.prepareStatement(sql);
                query.setString(1, ID);
                ResultSet rs = query.executeQuery();
                
                if(rs.next()){
                    
                    txtLastName.setText(rs.getString("apellidos"));
                    txtName.setText(rs.getString("nombre"));
                    txtAddress.setText(rs.getString("direccion"));
                    txtPhone.setText(rs.getString("telefono"));
                    txtPostalCode.setText(rs.getString("codigo_postal"));
                    txtCity.setText(rs.getString("ciudad"));
                    txtState.setText(rs.getString("estado"));
                    txtCountry.setText(rs.getString("pais"));
                    txtUsername.setText(rs.getString("nombre_usuario"));
                    
                    txtEmail.setText(rs.getString("email"));
                    
                    txtCompanyName.setText(rs.getString("nombre_compañia"));
                    txtRFC.setText(rs.getString("rfc"));
                    txtPosition.setText(rs.getString("puesto"));
                    
                    degree = rs.getString("titulo");
                    
                    int tamañoCombo = comboDegree.getItemCount();
                    //System.out.println(tamañoCombo);
                    
                  for(int i=0; i<tamañoCombo; i++){
                      
                      String comboContenido = comboDegree.getItemAt(i).toString();
                      System.out.println(comboContenido);
                      System.out.println(degree+" --- "+comboContenido);
                      
                      if(comboContenido.equals(degree)){
                          comboDegree.setSelectedIndex(i);
                                  System.out.println(degree+" entro "+comboContenido);
                          break;
                      }
                      
                      
                  }
                    
                    
                    
                }
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(UpdateCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    private void cleanPanels(){
        
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
    
    
    private void saveNewClient(){
        
        //recogemos el email
        String email = txtEmail.getText();
        String companyName = txtCompanyName.getText();
        String rfc = txtRFC.getText();
        String position = txtPosition.getText();
        
        //si las cajas de email estan basias asignamos null
        if(txtEmail.getText().equals("") && txtConfirmEmail.getText().equals("")){
            email = "NULL";
        }
        
        if(txtCompanyName.getText().equals("")){
            companyName = "NULL";
        }
        
        if(txtRFC.getText().equals("")){
            rfc = "NULL";
        }
        
        if(txtPosition.getText().equals("")){
            position = "NULL";
        }
        
        if(txtLastName.getText().equals("") || txtName.getText().equals("") || txtAddress.getText().equals("") || txtPhone.getText().equals("") || txtPostalCode.getText().equals("") || txtCity.getText().equals("") || txtState.getText().equals("") || txtCountry.getText().equals("") || txtName.getText().equals("") || txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtConfirmPassword.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please, complete all required fields (*).");
            return;
        }
        
        if(txtPostalCode.getText().length() < 5){
            JOptionPane.showMessageDialog(rootPane, "Postal Code too short.");  
            return;
                   
        }
        
        
        
        
        if(txtPassword.getText().equals(txtConfirmPassword.getText())){
            if(txtEmail.getText().equals(txtConfirmEmail.getText())){
                if(txtPassword.getText().length() >= 8){
                   
                       
                      
                    obj = new Conexion();
                    cn =obj.conectar(); 



                     String sql ="INSERT INTO clientes (nombre, apellidos, direccion, telefono, codigo_postal, ciudad, estado, pais, titulo, email, nombre_usuario, contraseña, nombre_compañia, rfc, puesto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, MD5(?), ?, ?, ?)";


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
                           PreparedStatement consulta = cn.prepareStatement(sql);
                             consulta.setString(1, lastName);
                             consulta.setString(2, name);
                             consulta.setString(3, address);
                             consulta.setString(4, phone);
                             consulta.setString(5, postalCode);
                             consulta.setString(6, city);
                             consulta.setString(7, state);
                             consulta.setString(8, country);
                             consulta.setString(9, degree);
                             consulta.setString(10, email);
                             consulta.setString(11, username);
                             consulta.setString(12, password);
                             consulta.setString(13, companyName);
                             consulta.setString(14, rfc);
                             consulta.setString(15, position);
                             consulta.execute();

                             cleanPanels();


                                 JOptionPane.showMessageDialog(rootPane, "Customer data has been saved.");
                         } catch (SQLException ex) {
                             Logger.getLogger(UpdateCustomer.class.getName()).log(Level.SEVERE, null, ex);
                         }
            
                   
                }else{
                   JOptionPane.showMessageDialog(rootPane, "Password too short."); 
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "The e-mails do not match.");
            }
            
        }else{
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
        btnEdit = new javax.swing.JButton();
        btnEdit1 = new javax.swing.JButton();
        pnlCompanyInformation = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        txtRFC = new javax.swing.JTextField();
        txtCompanyName = new javax.swing.JTextField();
        btnUpdateCustomer = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Edit Customer");
        setPreferredSize(new java.awt.Dimension(704, 587));

        pnlPersonalInformation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Replace the old personal information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        jLabel6.setText("*City:");

        jLabel7.setText("*State:");

        jLabel2.setText("*Last Name:");

        jLabel8.setText("*Country:");

        jLabel3.setText("*Name:");

        jLabel4.setText("*Address:");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        jLabel5.setText("*Phone:");

        jLabel1.setText("*Postal Code:");

        txtPostalCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPostalCodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPostalCodeKeyTyped(evt);
            }
        });

        jLabel12.setText("*Degree:");

        jLabel13.setText("e-mail:");

        jLabel14.setText("*Username:");

        jLabel15.setText("*Password:");

        jLabel16.setText("*Confirm Password:");

        jLabel17.setText("Confirm e-mail:");

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
                                    .addComponent(txtConfirmPassword)))
                            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                                        .addComponent(comboDegree, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtEmail))))
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
                                        .addGap(0, 10, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPersonalInformationLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))))))
        );
        pnlPersonalInformationLayout.setVerticalGroup(
            pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnEdit))
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
                            .addComponent(comboDegree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addComponent(txtPosition)))
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

        btnUpdateCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update1.png"))); // NOI18N
        btnUpdateCustomer.setText("  Update");
        btnUpdateCustomer.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update2.png"))); // NOI18N
        btnUpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCustomerActionPerformed(evt);
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
                .addGap(111, 111, 111)
                .addComponent(btnUpdateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlCompanyInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlPersonalInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(pnlPersonalInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(pnlCompanyInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateCustomer)
                    .addComponent(btnClose)
                    .addComponent(btnDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCustomerActionPerformed

        updateCustomerMethod();
    }//GEN-LAST:event_btnUpdateCustomerActionPerformed

    private void txtPostalCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPostalCodeKeyPressed
       

    }//GEN-LAST:event_txtPostalCodeKeyPressed

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
        EditCustomer objeto = new EditCustomer(this, txtID);
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


                String sql ="UPDATE clientes SET fecha_eliminado = NOW() WHERE id=?";

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

    private void btnEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit1ActionPerformed
        NewDegree objeto = new NewDegree();
        objeto.setVisible(true);
    }//GEN-LAST:event_btnEdit1ActionPerformed

    private void btnEdit1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnEdit1FocusGained
        
        updateComboDegree();
    }//GEN-LAST:event_btnEdit1FocusGained

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
            java.util.logging.Logger.getLogger(UpdateCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEdit1;
    private javax.swing.JButton btnUpdateCustomer;
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
