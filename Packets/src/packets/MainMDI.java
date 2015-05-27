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
        desktopPane = new javax.swing.JDesktopPane();
        lblBackground = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuCustomer = new javax.swing.JMenu();
        menuNewClient = new javax.swing.JMenuItem();
        menuUpdateCustomer = new javax.swing.JMenuItem();
        menuEmployee = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuVehicle = new javax.swing.JMenu();
        menuNewVehicle = new javax.swing.JMenuItem();
        menuNewLocation = new javax.swing.JMenuItem();
        menuNewTypeVehicle = new javax.swing.JMenuItem();
        menuUpdateVehicle = new javax.swing.JMenuItem();
        menuUpdateTypeVehicle = new javax.swing.JMenuItem();
        deleteMenuItem1 = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        contentMenuItem = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PACKETS.CO");

        lblBackground.setBackground(new java.awt.Color(255, 255, 255));
        lblBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/packets_logo.png"))); // NOI18N
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

        cutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        cutMenuItem.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("New Employee");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        menuEmployee.add(cutMenuItem);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jMenuItem1.setText("New Branch");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuEmployee.add(jMenuItem1);

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

        contentMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        contentMenuItem.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("EXIT");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(contentMenuItem);

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
        obj.setBounds(50, 50, 500, 500);
        
        //tamaño del internal frame
        //obj.setSize(700, 800);
       // obj.setVisible(true);
        
        desktopPane.add(obj);
        obj.show();
    }//GEN-LAST:event_menuNewVehicleActionPerformed

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        NewEmployee obj = new NewEmployee();
        //coordenadas para mostrar
        obj.setBounds(50, 50, 719, 500);
                
        desktopPane.add(obj);
        obj.show();
        
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void menuUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUpdateCustomerActionPerformed
        UpdateCustomer obj = new UpdateCustomer();
        //coordenadas para mostrar
        obj.setBounds(50, 50, 650, 700);
        
        
        obj.setVisible(true);
        
        desktopPane.add(obj);
    }//GEN-LAST:event_menuUpdateCustomerActionPerformed

    private void menuNewLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewLocationActionPerformed
          NewLocation obj = new NewLocation();
        //coordenadas para mostrar
        obj.setBounds(50, 50, 400, 300);
        
        
   
        
        desktopPane.add(obj);
        obj.show();
    }//GEN-LAST:event_menuNewLocationActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       
        NewBranch obj = new NewBranch();
        //coordenadas para mostrar
        obj.setBounds(50, 50, 650, 400);
              
        desktopPane.add(obj);
       
        obj.show();
  
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuNewTypeVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewTypeVehicleActionPerformed
        
        NewTypeVehicle obj = new NewTypeVehicle();
        //coordenadas para mostrar
        obj.setBounds(50, 50, 400, 400);
        
        
    
        
        desktopPane.add(obj);
        obj.show();
    }//GEN-LAST:event_menuNewTypeVehicleActionPerformed

    private void menuUpdateTypeVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUpdateTypeVehicleActionPerformed

        UpdateTypeVehicle obj = new UpdateTypeVehicle();
        //coordenadas para mostrar
        obj.setBounds(50, 50, 500, 500);
        
        //tamaño del internal frame
        //obj.setSize(700, 800);
        
        obj.setVisible(true);
        
        desktopPane.add(obj);
        obj.show();
    }//GEN-LAST:event_menuUpdateTypeVehicleActionPerformed

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_contentMenuItemActionPerformed

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
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem1;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCustomer;
    private javax.swing.JMenu menuEmployee;
    private javax.swing.JMenuItem menuNewClient;
    private javax.swing.JMenuItem menuNewLocation;
    private javax.swing.JMenuItem menuNewTypeVehicle;
    private javax.swing.JMenuItem menuNewVehicle;
    public javax.swing.JMenuItem menuUpdateCustomer;
    private javax.swing.JMenuItem menuUpdateTypeVehicle;
    private javax.swing.JMenuItem menuUpdateVehicle;
    private javax.swing.JMenu menuVehicle;
    // End of variables declaration//GEN-END:variables

}
