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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author genesisaurora
 */
public class NewShipments extends javax.swing.JInternalFrame {

    Conexion obj;
    Connection cn;
    Random rnd = new Random();

    /**
     * Creates new form NewShipments
     */
    public NewShipments() {
        initComponents();
        genarateNumberGuide();

        lapseTime(comboTypeSend.getSelectedIndex());
        

    }
    
    public void lapseTime(int combo){
        Calendar calendarStart;
        Calendar calendarEnd;
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE-dd-MMMM");  
        Date now = new Date();  
        String startDate ="";
        String endDate ="";
        
        if(combo == 0){
            //Expresss
         calendarStart = Calendar.getInstance();
        calendarStart.setTime(now);
        calendarStart.add(Calendar.DAY_OF_WEEK, 0);  
        calendarStart.add(Calendar.DAY_OF_MONTH, 1);
        
         startDate = dateFormat.format(calendarStart.getTime());
       }
        if(combo == 1){
            //Expresss
         calendarStart = Calendar.getInstance();
        calendarStart.setTime(now);
        calendarStart.add(Calendar.DAY_OF_WEEK, 0);  
        calendarStart.add(Calendar.DAY_OF_MONTH, 1);
        
         calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(now);
        calendarEnd.add(Calendar.DAY_OF_WEEK, 0);  
        calendarEnd.add(Calendar.DAY_OF_MONTH, 3);
        
         startDate = dateFormat.format(calendarStart.getTime());
         endDate = " to "+dateFormat.format(calendarEnd.getTime());
       }
        
        if(combo == 2){
            //Expresss
         calendarStart = Calendar.getInstance();
        calendarStart.setTime(now);
        calendarStart.add(Calendar.DAY_OF_WEEK, 0);  
        calendarStart.add(Calendar.DAY_OF_MONTH, 3);
        
         calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(now);
        calendarEnd.add(Calendar.DAY_OF_WEEK, 0);  
        calendarEnd.add(Calendar.DAY_OF_MONTH, 5);
        
         startDate = dateFormat.format(calendarStart.getTime());
         endDate = " to "+dateFormat.format(calendarEnd.getTime());
       }
 
      lblLapseTime.setText("Shipmets arrive aproximatlely \n"+startDate+""+endDate);
    }


    public void cleanPanels(){
        
                  txtNameCustomer.setText("");
                  txtNumberGuide.setText("");
                  txtLastName.setText("");
                  txtEmail.setText("");
                  txtPhone.setText("");
                  txtAddress.setText("");
                  lblCost.setText("");
                  txtNameSender.setText("");
                  txtLastNameSender.setText("");
                  txtPhoneSender.setText("");
                  txtCellPhone.setText("");
                  lblLapseTime.setText("");
       genarateNumberGuide();
       
     }
  
        


    public void selectCustomer() {


        //cleanPanels();
        String ID = txtID.getText();

        String degree = "";

        String sql = "SELECT name, last_name, phone, email FROM customers WHERE id=?";

        try {

            obj = new Conexion();
            cn = obj.conectar();

            PreparedStatement query = cn.prepareStatement(sql);
            query.setString(1, ID);
            ResultSet rs = query.executeQuery();

            if (rs.next()) {

                txtNameCustomer.setText(rs.getString("name"));
                txtLastName.setText(rs.getString("last_name"));
                txtPhone.setText(rs.getString("phone"));
                txtEmail.setText(rs.getString("email"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UpdateCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void saveNewShipments() {

        if (txtLastName.getText().equals("") || txtNameSender.getText().equals("") || txtLastNameSender.getText().equals("") || txtAddress.getText().equals("") || txtPhoneSender.getText().equals("") || txtCellPhone.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please, complete all required fields (*).");
            return;
        }

        if (txtPhoneSender.getText().length() < 7) {
            JOptionPane.showMessageDialog(rootPane, "Phone too short.");
            return;

        }

        if (txtCellPhone.getText().length() < 7) {
            JOptionPane.showMessageDialog(rootPane, "Cell phone too short.");
            return;
        }

        obj = new Conexion();

        cn =obj.conectar(); 
        
        
         String sql ="INSERT INTO shipments (customer, guide_number, last_name, email, phone, type_send, shipments_cost, name_sender, lastname_sender, phone_sender, cellphone, area_destination, lapse_time, location) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
                  String customer = txtNameCustomer.getText();
                  String numberGuide = txtNumberGuide.getText();
                  String lastName = txtLastName.getText();
                  String email = txtEmail.getText();
                  String phone = txtPhone.getText();
                  String typeSend = comboTypeSend.getSelectedItem().toString();
                  String areaDestination = txtAddress.getText();
                  String shipmentCost = lblCost.getText();
                  String nameSender = txtNameSender.getText();
                  String lastNameSender = txtLastNameSender.getText();
                  String phoneSender = txtPhoneSender.getText();
                  String cellphone = txtCellPhone.getText();
                  String lapseTime = lblLapseTime.getText();
                  String location = txtAreaBranch.getText();
    
                 
                  
                    try {
                       PreparedStatement query = cn.prepareStatement(sql);
                         query.setString(1, customer);
                         query.setString(2, numberGuide);
                         query.setString(3, lastName);
                         query.setString(4, email);
                         query.setString(5, phone);
                         query.setString(6, typeSend);
                         query.setString(7, shipmentCost);
                         query.setString(8, nameSender);
                         query.setString(9, lastNameSender);
                         query.setString(10, phoneSender);
                         query.setString(11, cellphone);
                         query.setString(12, areaDestination);
                         query.setString(13, lapseTime);
                         query.setString(14, location);
                         
                         query.execute();
                         
                         cleanPanels();


                             JOptionPane.showMessageDialog(rootPane, "Shipments data has been saved.");
                     } catch (SQLException ex) {
                         Logger.getLogger(NewShipments.class.getName()).log(Level.SEVERE, null, ex);
                     }
                      


    }

    private void genarateNumberGuide() {

        int[] elements = new int[10];
        int n = 0;

        for (int i = 0; i < 10; i++) //generamos 10 números
        {
            n = (int) (rnd.nextDouble() * 100.0); //generamos numeros aleatorios entre 0 y 100
            elements[i] = n; //guardamos el entero obtenido en el array
            elements[i]++;  //le sumamos uno a la posición del array para poder guardar el siguiente número
        }
        String numberGuide = elements[2] + "" + elements[3] + "" + elements[7] + "" + elements[9];

        txtNumberGuide.setText(numberGuide);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNumberGuide = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboTypeSend = new javax.swing.JComboBox();
        btnEdit = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNameCustomer = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNameSender = new javax.swing.JTextField();
        txtLastNameSender = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPhoneSender = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCellPhone = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblLapseTime = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaBranch = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblCost = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Shipments", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Shipments Description", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        jLabel1.setText("Last Name:");

        txtLastName.setEnabled(false);

        jLabel2.setText("Guide Number: ");

        txtNumberGuide.setEnabled(false);
        txtNumberGuide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberGuideActionPerformed(evt);
            }
        });

        jLabel4.setText("Type Send:");

        comboTypeSend.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Express(1 day)", "Normal(1-3 days)", "Basic(3-5 days)" }));
        comboTypeSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTypeSendActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search2.png"))); // NOI18N
        btnEdit.setText("Search");
        btnEdit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit2.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        txtEmail.setEnabled(false);

        jLabel10.setText("Customer:");

        txtNameCustomer.setEnabled(false);

        jLabel11.setText("Phone:");

        txtPhone.setEnabled(false);

        jLabel9.setText("Email:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sender Information", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        jLabel7.setText("Name:");

        jLabel8.setText("Last Name:");

        txtNameSender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameSenderKeyTyped(evt);
            }
        });

        txtLastNameSender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLastNameSenderKeyTyped(evt);
            }
        });

        jLabel3.setText("Phone:");

        txtPhoneSender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneSenderKeyTyped(evt);
            }
        });

        jLabel5.setText("Cellphone:");

        txtCellPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCellPhoneKeyTyped(evt);
            }
        });

        jLabel12.setText("Address:");

        jLabel13.setText("Lapse of Time:");

        lblLapseTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        txtAreaBranch.setColumns(20);
        txtAreaBranch.setRows(5);
        txtAreaBranch.setText("Mazatlan, Sinaloa Branch: Isurgentes");
        txtAreaBranch.setEnabled(false);
        jScrollPane2.setViewportView(txtAreaBranch);

        jLabel6.setText("Location:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtLastNameSender, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNameSender, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCellPhone)
                            .addComponent(txtPhoneSender, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLapseTime, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNameSender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneSender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCellPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtLastNameSender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLapseTime, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel14.setText("Cost:");

        lblCost.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCost, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNameCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNumberGuide, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboTypeSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNumberGuide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(btnEdit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtNameCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboTypeSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCost, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(17, 17, 17))))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(btnClose)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        saveNewShipments();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        SelectCustomer objeto = new SelectCustomer(this, txtID);
        objeto.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtNumberGuideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberGuideActionPerformed

    }//GEN-LAST:event_txtNumberGuideActionPerformed

    private void comboTypeSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTypeSendActionPerformed

        String type = comboTypeSend.getSelectedItem().toString();

        if (type.equals("Normal(1-3 days)")) {
            lblCost.setText("180");
        }

        if (type.equals("Express(1 day)")) {
            lblCost.setText("250");
        }

        if (type.equals("Basic(3-5 days)")) {
            lblCost.setText("120");
        }

        
        lapseTime(comboTypeSend.getSelectedIndex());
        

    }//GEN-LAST:event_comboTypeSendActionPerformed

    private void txtNameSenderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameSenderKeyTyped
        char campo = evt.getKeyChar();

        if ((campo < 'a' || campo > 'z') && (campo < 'A' || campo > 'Z') && (campo != (char) KeyEvent.VK_BACK_SPACE) && (campo != (char) KeyEvent.VK_SPACE)) {
            evt.consume();

        }
    }//GEN-LAST:event_txtNameSenderKeyTyped

    private void txtLastNameSenderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastNameSenderKeyTyped
        char campo = evt.getKeyChar();

        if ((campo < 'a' || campo > 'z') && (campo < 'A' || campo > 'Z') && (campo != (char) KeyEvent.VK_BACK_SPACE) && (campo != (char) KeyEvent.VK_SPACE)) {
            evt.consume();

        }
    }//GEN-LAST:event_txtLastNameSenderKeyTyped

    private void txtPhoneSenderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneSenderKeyTyped
        int phoneSize = txtPhoneSender.getText().length();
        char campo = evt.getKeyChar();

        System.out.println("char " + evt.getKeyChar());

        if (campo < '0' || campo > '9') {
            evt.consume();
        }

        System.out.println("tamaño " + phoneSize);
        if (phoneSize > 9) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Only nine numbers for Phone.");
        }
    }//GEN-LAST:event_txtPhoneSenderKeyTyped

    private void txtCellPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCellPhoneKeyTyped
        int phoneSize = txtCellPhone.getText().length();
        char campo = evt.getKeyChar();

        System.out.println("char " + evt.getKeyChar());

        if (campo < '0' || campo > '9') {
            evt.consume();
        }

        System.out.println("tamaño " + phoneSize);
        if (phoneSize > 13) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Only thirteen numbers for Phone.");
        }
    }//GEN-LAST:event_txtCellPhoneKeyTyped

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
            java.util.logging.Logger.getLogger(NewShipments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewShipments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewShipments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewShipments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewShipments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox comboTypeSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblLapseTime;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextArea txtAreaBranch;
    private javax.swing.JTextField txtCellPhone;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtLastNameSender;
    private javax.swing.JTextField txtNameCustomer;
    private javax.swing.JTextField txtNameSender;
    private javax.swing.JTextField txtNumberGuide;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPhoneSender;
    // End of variables declaration//GEN-END:variables
}
