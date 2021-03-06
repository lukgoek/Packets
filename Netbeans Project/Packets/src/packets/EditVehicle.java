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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author genesisaurora
 */
public class EditVehicle extends javax.swing.JFrame {

   Conexion obj;
    Connection cn;
    UpdateVehicle objeto;
    
    public EditVehicle() {
        initComponents();
        
        updateTable();
    }

     public EditVehicle(UpdateVehicle updateVehicle, JTextField ID) {
        initComponents();
        updateTable();
        //solamente cerramos la ventana no cerreamos la applicacion
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        obj = new Conexion();
        cn = obj.conectar();
        
        this.txtID = ID;
        this.objeto = updateVehicle;
        
    }
     public void updateTable(){
        obj = new Conexion();
        cn =obj.conectar();
        
        
        
        //declaramos la consulta
        String sql ="SELECT id, brand, model, plate, number_vehicle, type_vehicle, driver, status FROM vehicles WHERE removed_date IS NULL";
        
        //modelo de datos para rellenar la tabla (arreglo de informacion)
        DefaultTableModel model = new DefaultTableModel();
        
        //definimos las columnas de nuestra tabla
        model.addColumn("ID");
        model.addColumn("brand");
        model.addColumn("Plate");
        model.addColumn("Model");
        model.addColumn("Number Vehicle");
        model.addColumn("Driver");
        model.addColumn("Status");
                
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
                datos = new String[7];
                
                //.getString(); recoge datos
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("brand");
                datos[2] = rs.getString("plate");
                datos[3] = rs.getString("model");
                datos[4] = rs.getString("number_vehicle");
                datos[5] = rs.getString("driver");
                datos[6] = rs.getString("status");
                
                //agregamos los datos al modelo
                model.addRow(datos);


            }
            
            //agregamos el modelo a la tabla
            tbDataVehicle.setModel(model);
        
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbDataVehicle = new javax.swing.JTable();
        btSendVehicle = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbDataVehicle.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbDataVehicle);

        btSendVehicle.setText("Edit");
        btSendVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSendVehicleActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select one vehicle to edit them");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btSendVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSendVehicle)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(382, 382, 382))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(133, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSendVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSendVehicleActionPerformed
        int rowSelected = tbDataVehicle.getSelectedRow();

        if(rowSelected <= -1){
            JOptionPane.showMessageDialog(rootPane, "You need to select one Vehicle to continue.", "¡ERROR!", 1);
        }else{

            this.dispose();
            String selectedID = tbDataVehicle.getValueAt(rowSelected, 0).toString();
            txtID.setText(selectedID);

            objeto.editVehicle();

            // this.dispose();

        }

    }//GEN-LAST:event_btSendVehicleActionPerformed

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
            java.util.logging.Logger.getLogger(EditVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditVehicle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSendVehicle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDataVehicle;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
