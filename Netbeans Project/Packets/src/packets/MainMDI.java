/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packets;

/**
 *
 * @author HbTO
 */
public class MainMDI extends javax.swing.JFrame {

    /**
     * Creates new form MainMDI
     */
    public MainMDI() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        desktopPane = new javax.swing.JDesktopPane();
        lblBackground = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuCustomer = new javax.swing.JMenu();
        menuNewClient = new javax.swing.JMenuItem();
        menuUpdateCustomer = new javax.swing.JMenuItem();
        menuEmployee = new javax.swing.JMenu();
        MenuEmployee = new javax.swing.JMenuItem();
        MenuBranch = new javax.swing.JMenuItem();
        MenuUpdateBranch = new javax.swing.JMenuItem();
        MenuUpdateEmployee = new javax.swing.JMenuItem();
        menuVehicle = new javax.swing.JMenu();
        menuNewVehicle = new javax.swing.JMenuItem();
        menuNewLocation = new javax.swing.JMenuItem();
        menuNewTypeVehicle = new javax.swing.JMenuItem();
        menuUpdateVehicle = new javax.swing.JMenuItem();
        menuUpdateTypeVehicle = new javax.swing.JMenuItem();
        deleteMenuItem1 = new javax.swing.JMenuItem();
        menuShipments = new javax.swing.JMenu();
        menuNewShipments = new javax.swing.JMenuItem();
        menuUPdateShipments = new javax.swing.JMenuItem();
        MenuExit1 = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        MenuExit = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem2.setText("jMenuItem2");

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PACKETS.CO");

        desktopPane.setLayout(null);

        lblBackground.setBackground(new java.awt.Color(255, 255, 255));
        lblBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo2.png"))); // NOI18N
        desktopPane.add(lblBackground);
        lblBackground.setBounds(0, 0, 1000, 840);

        menuBar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        menuCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/customer_menu.png"))); // NOI18N
        menuCustomer.setMnemonic('f');
        menuCustomer.setText("Customer Menu");
        menuCustomer.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        menuNewClient.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuNewClient.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        menuNewClient.setMnemonic('o');
        menuNewClient.setText("New Customer");
        menuNewClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewClientActionPerformed(evt);
            }
        });
        menuCustomer.add(menuNewClient);

        menuUpdateCustomer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        menuUpdateCustomer.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        menuUpdateCustomer.setMnemonic('a');
        menuUpdateCustomer.setText("Update Customer");
        menuUpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUpdateCustomerActionPerformed(evt);
            }
        });
        menuCustomer.add(menuUpdateCustomer);

        menuBar.add(menuCustomer);

        menuEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/employees_menu.png"))); // NOI18N
        menuEmployee.setMnemonic('e');
        menuEmployee.setText("Employee & Branch");
        menuEmployee.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        menuEmployee.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/employees_menu2.png"))); // NOI18N

        MenuEmployee.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        MenuEmployee.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        MenuEmployee.setMnemonic('t');
        MenuEmployee.setText("New Employee");
        MenuEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEmployeeActionPerformed(evt);
            }
        });
        menuEmployee.add(MenuEmployee);

        MenuBranch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        MenuBranch.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        MenuBranch.setText("New Branch");
        MenuBranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBranchActionPerformed(evt);
            }
        });
        menuEmployee.add(MenuBranch);

        MenuUpdateBranch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        MenuUpdateBranch.setText("Update Branch");
        MenuUpdateBranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUpdateBranchActionPerformed(evt);
            }
        });
        menuEmployee.add(MenuUpdateBranch);

        MenuUpdateEmployee.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        MenuUpdateEmployee.setText("Update Employee");
        MenuUpdateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUpdateEmployeeActionPerformed(evt);
            }
        });
        menuEmployee.add(MenuUpdateEmployee);

        menuBar.add(menuEmployee);

        menuVehicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/vehicle_menu.png"))); // NOI18N
        menuVehicle.setMnemonic('e');
        menuVehicle.setText("Vehicle");
        menuVehicle.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        menuNewVehicle.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        menuNewVehicle.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        menuNewVehicle.setMnemonic('s');
        menuNewVehicle.setText("New Vehicle");
        menuNewVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewVehicleActionPerformed(evt);
            }
        });
        menuVehicle.add(menuNewVehicle);

        menuNewLocation.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        menuNewLocation.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        menuNewLocation.setMnemonic('t');
        menuNewLocation.setText("New Location");
        menuNewLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewLocationActionPerformed(evt);
            }
        });
        menuVehicle.add(menuNewLocation);

        menuNewTypeVehicle.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        menuNewTypeVehicle.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        menuNewTypeVehicle.setMnemonic('y');
        menuNewTypeVehicle.setText("NewTypeVehicle");
        menuNewTypeVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewTypeVehicleActionPerformed(evt);
            }
        });
        menuVehicle.add(menuNewTypeVehicle);

        menuUpdateVehicle.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        menuUpdateVehicle.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        menuUpdateVehicle.setMnemonic('x');
        menuUpdateVehicle.setText("Update Vehicle");
        menuUpdateVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUpdateVehicleActionPerformed(evt);
            }
        });
        menuVehicle.add(menuUpdateVehicle);

        menuUpdateTypeVehicle.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        menuUpdateTypeVehicle.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        menuUpdateTypeVehicle.setMnemonic('s');
        menuUpdateTypeVehicle.setText("Update Type Vehicle");
        menuUpdateTypeVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUpdateTypeVehicleActionPerformed(evt);
            }
        });
        menuVehicle.add(menuUpdateTypeVehicle);

        deleteMenuItem1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        deleteMenuItem1.setMnemonic('d');
        deleteMenuItem1.setText("Delete");
        menuVehicle.add(deleteMenuItem1);

        menuBar.add(menuVehicle);

        menuShipments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/options_menu.png"))); // NOI18N
        menuShipments.setMnemonic('h');
        menuShipments.setText("Shipments");
        menuShipments.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        menuNewShipments.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuNewShipments.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        menuNewShipments.setText("New Shipments");
        menuNewShipments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewShipmentsActionPerformed(evt);
            }
        });
        menuShipments.add(menuNewShipments);

        menuUPdateShipments.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        menuUPdateShipments.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        menuUPdateShipments.setMnemonic('a');
        menuUPdateShipments.setText("Update Shipments");
        menuUPdateShipments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUPdateShipmentsActionPerformed(evt);
            }
        });
        menuShipments.add(menuUPdateShipments);

        MenuExit1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        MenuExit1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        MenuExit1.setMnemonic('c');
        MenuExit1.setText("EXIT");
        MenuExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuExit1ActionPerformed(evt);
            }
        });
        menuShipments.add(MenuExit1);

        menuBar.add(menuShipments);

        helpMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/options_menu.png"))); // NOI18N
        helpMenu.setMnemonic('h');
        helpMenu.setText("Options");
        helpMenu.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jMenuItem3.setText("Settings");
        helpMenu.add(jMenuItem3);

        aboutMenuItem.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        MenuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        MenuExit.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        MenuExit.setMnemonic('c');
        MenuExit.setText("EXIT");
        MenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuExitActionPerformed(evt);
            }
        });
        helpMenu.add(MenuExit);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuUpdateVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUpdateVehicleActionPerformed
  UpdateVehicle obj = new UpdateVehicle();
        //coordenadas para mostrar
        obj.setBounds(50, 50, 500, 500);
        
        //tamaño del internal frame
        //obj.setSize(700, 800);
      
        
        desktopPane.add(obj);  
        obj.show();
    }//GEN-LAST:event_menuUpdateVehicleActionPerformed

    private void menuNewClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewClientActionPerformed
        NewClient obj = new NewClient();
        //coordenadas para mostrar
        obj.setBounds(50, 50, 650, 700);
        
        
        desktopPane.add(obj);
        obj.show();
    }//GEN-LAST:event_menuNewClientActionPerformed

    private void menuNewVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewVehicleActionPerformed
          NewVehicle obj = new NewVehicle();
        //coordenadas para mostrar
        obj.setBounds(100, 100, 500, 500);
        
        //tamaño del internal frame
        //obj.setSize(700, 800);
       // obj.setVisible(true);
        
        desktopPane.add(obj);
        obj.show();
    }//GEN-LAST:event_menuNewVehicleActionPerformed

    private void MenuEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEmployeeActionPerformed
        NewEmployee obj = new NewEmployee();
        //coordenadas para mostrar
        obj.setBounds(50, 50, 719, 500);
                
        desktopPane.add(obj);
        obj.show();
        
    }//GEN-LAST:event_MenuEmployeeActionPerformed

    private void menuUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUpdateCustomerActionPerformed
        UpdateCustomer obj = new UpdateCustomer();
        //coordenadas para mostrar
        obj.setBounds(50, 50, 650, 700);
        
        desktopPane.add(obj);
        obj.show();
    }//GEN-LAST:event_menuUpdateCustomerActionPerformed

    private void menuNewLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewLocationActionPerformed
          NewLocation obj = new NewLocation();
        //coordenadas para mostrar
        obj.setBounds(100, 100, 400, 300);
        
        
   
        
        desktopPane.add(obj);
        obj.show();
    }//GEN-LAST:event_menuNewLocationActionPerformed

    private void MenuBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBranchActionPerformed
       
        NewBranch obj = new NewBranch();
        //coordenadas para mostrar
        obj.setBounds(50, 50, 650, 400);
              
        desktopPane.add(obj);
       
        obj.show();
  
    }//GEN-LAST:event_MenuBranchActionPerformed

    private void menuNewTypeVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewTypeVehicleActionPerformed
        
        NewTypeVehicle obj = new NewTypeVehicle();
        //coordenadas para mostrar
        obj.setVisible(true);
        
        obj.setLocationRelativeTo(null);
        
  
    }//GEN-LAST:event_menuNewTypeVehicleActionPerformed

    private void menuUpdateTypeVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUpdateTypeVehicleActionPerformed

        UpdateTypeVehicle obj = new UpdateTypeVehicle();
        //coordenadas para mostrar
        obj.setBounds(50, 50, 550, 550);
        
        //tamaño del internal frame
        //obj.setSize(700, 800);
        
        desktopPane.add(obj);
        obj.show();
    }//GEN-LAST:event_menuUpdateTypeVehicleActionPerformed

    private void MenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuExitActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_MenuExitActionPerformed

    private void MenuUpdateBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUpdateBranchActionPerformed
      
        UpdateBranch obj = new UpdateBranch();
        //coordenadas para mostrar
        obj.setBounds(50, 50, 650, 500);
        

       // obj.setVisible(true);

        
        desktopPane.add(obj);
        obj.show();
    }//GEN-LAST:event_MenuUpdateBranchActionPerformed

    private void MenuExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuExit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuExit1ActionPerformed

    private void menuNewShipmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewShipmentsActionPerformed
         NewShipments obj = new NewShipments();
        //coordenadas para mostrar
        obj.setBounds(50, 50, 580, 550);
              
        desktopPane.add(obj);
       
        obj.show();
    }//GEN-LAST:event_menuNewShipmentsActionPerformed

    private void menuUPdateShipmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUPdateShipmentsActionPerformed
        
         UpdateShipments obj = new UpdateShipments();
        //coordenadas para mostrar
        obj.setBounds(50, 50, 650, 400);
        

       // obj.setVisible(true);

        
        desktopPane.add(obj);
        obj.show();
    }//GEN-LAST:event_menuUPdateShipmentsActionPerformed

    private void MenuUpdateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUpdateEmployeeActionPerformed
        UpdateEmployee obj = new UpdateEmployee();
        //coordenadas para mostrar
        obj.setBounds(50, 50, 719, 500);
                
        desktopPane.add(obj);
        obj.show();
        
    }//GEN-LAST:event_MenuUpdateEmployeeActionPerformed

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
            java.util.logging.Logger.getLogger(MainMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMDI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuBranch;
    private javax.swing.JMenuItem MenuEmployee;
    private javax.swing.JMenuItem MenuExit;
    private javax.swing.JMenuItem MenuExit1;
    private javax.swing.JMenuItem MenuUpdateBranch;
    private javax.swing.JMenuItem MenuUpdateEmployee;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem1;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCustomer;
    private javax.swing.JMenu menuEmployee;
    private javax.swing.JMenuItem menuNewClient;
    private javax.swing.JMenuItem menuNewLocation;
    private javax.swing.JMenuItem menuNewShipments;
    private javax.swing.JMenuItem menuNewTypeVehicle;
    private javax.swing.JMenuItem menuNewVehicle;
    private javax.swing.JMenu menuShipments;
    private javax.swing.JMenuItem menuUPdateShipments;
    public javax.swing.JMenuItem menuUpdateCustomer;
    private javax.swing.JMenuItem menuUpdateTypeVehicle;
    private javax.swing.JMenuItem menuUpdateVehicle;
    private javax.swing.JMenu menuVehicle;
    // End of variables declaration//GEN-END:variables

}
