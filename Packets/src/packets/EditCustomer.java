/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HbTO
 */
public class EditCustomer extends javax.swing.JFrame {

    Conexion obj;
    Connection cn;
    UpdateCustomer objeto;
    
    public EditCustomer() {
        initComponents();
        updateTable();
    }

    public EditCustomer(UpdateCustomer updateCustomer, JTextField ID) {
        initComponents();
        updateTable();
        //solamente cerramos la ventana no cerreamos la applicacion
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        obj = new Conexion();
        cn = obj.conectar();
        
        this.txtID = ID;
        this.objeto = updateCustomer;
        
    }
    
    
    public void updateTable(){
        obj = new Conexion();
        cn =obj.conectar();
        
        
        
        //declaramos la consulta
        String sql ="SELECT id, nombre, apellidos, direccion, telefono, codigo_postal, ciudad, estado, pais, titulo, email, nombre_usuario, nombre_compañia, rfc, puesto FROM clientes WHERE fecha_eliminado IS NULL";
        
        //modelo de datos para rellenar la tabla (arreglo de informacion)
        DefaultTableModel model = new DefaultTableModel();
        
        //definimos las columnas de nuestra tabla
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Last name");
        model.addColumn("Address");
        model.addColumn("Phone number");
        model.addColumn("Postal code");
        model.addColumn("City");
        model.addColumn("State");
        model.addColumn("Country");
        model.addColumn("Degree");
        model.addColumn("e-mail");
        model.addColumn("Username");
        model.addColumn("Company name");
        model.addColumn("RFC");
        model.addColumn("Position");
        
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
                datos = new String[14];
                
                //.getString(); recoge datos
                datos[0] = rs.getString("ID");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("apellidos");
                datos[3] = rs.getString("direccion");
                datos[4] = rs.getString("telefono");
                datos[5] = rs.getString("ciudad");
                datos[6] = rs.getString("estado");
                datos[7] = rs.getString("pais");
                datos[8] = rs.getString("titulo");
                datos[9] = rs.getString("email");
                datos[10] = rs.getString("nombre_usuario");
                datos[11] = rs.getString("nombre_compañia");
                datos[12] = rs.getString("rfc");
                datos[13] = rs.getString("puesto");
                //agregamos los datos al modelo
                model.addRow(datos);


            }
            
            //agregamos el modelo a la tabla
            tbDataCustomer.setModel(model);
        
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbDataCustomer = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btSendCustomer = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Customer");

        tbDataCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbDataCustomer);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select one customer to edit them");

        btSendCustomer.setText("Edit");
        btSendCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSendCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btSendCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSendCustomer)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSendCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSendCustomerActionPerformed
       int rowSelected = tbDataCustomer.getSelectedRow();
       
       if(rowSelected <= -1){
           JOptionPane.showMessageDialog(rootPane, "You need to select one customer to continue.", "¡ERROR!", 1);
       }else{
           
        
        
        this.dispose();
           String selectedID = tbDataCustomer.getValueAt(rowSelected, 0).toString();
           txtID.setText(selectedID);
        
           objeto.editCustomer();
          
          
           
           
           
          // this.dispose();
           
       }
       
       
    }//GEN-LAST:event_btSendCustomerActionPerformed

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
            java.util.logging.Logger.getLogger(EditCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSendCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDataCustomer;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
