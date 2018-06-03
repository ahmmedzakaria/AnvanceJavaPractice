/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import sun.security.x509.CertificateSubjectName;

/**
 *
 * @author Zakakaria
 */
public class Inventory extends javax.swing.JFrame {

    List<Product> products;
    public Inventory() {
        initComponents();
        products=DbController.getAllProduct();
        List<String> names=DbController.getAllProductName();
        cmbNames.setModel(new DefaultComboBoxModel(names.toArray()));
        //cmbNames.setModel(new javax.swing.DefaultComboBoxModel(names.toArray()));
        List<Product> products=DbController.getAllProduct();
        int index=cmbNames.getSelectedIndex();
        cmbNames.insertItemAt("Select One", 0);
        cmbNames.setSelectedIndex(0);
        if(index>0){
            Product p=products.get(index-1);
            txtPname.setText(p.pName);
            txtPurchasePrice.setText(p.pPur);
            txtSealPrice.setText(p.pSale);
            txtPDate.setText(p.pDate);
            txtQty.setText(p.pQty);
        }
        
        
    }

    private void clear(){
        txtPname.setText("");
            txtPurchasePrice.setText("");
            txtSealPrice.setText("");
            txtPDate.setText("");
            txtQty.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbNames = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPos = new javax.swing.JTextField();
        txtPurchasePrice = new javax.swing.JTextField();
        txtSealPrice = new javax.swing.JTextField();
        txtPDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtQty = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Avilable Qty");

        cmbNames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbNames.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNamesItemStateChanged(evt);
            }
        });

        jLabel2.setText("Item Name");

        jLabel3.setText("Purchase Price");

        jLabel4.setText("Purchase/Sale Qty");

        jLabel5.setText("Sale Price");

        jButton1.setText("Purchase");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sale");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPosActionPerformed(evt);
            }
        });

        jLabel7.setText("Product Name");

        jLabel8.setText("date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(118, 118, 118)
                        .addComponent(cmbNames, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPname)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPDate)
                                    .addComponent(txtSealPrice)
                                    .addComponent(txtPurchasePrice)
                                    .addComponent(txtPos)
                                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel7))
                    .addComponent(txtPname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPurchasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSealPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(cmbNames.getSelectedIndex()>0){
            int index=cmbNames.getSelectedIndex();
            Product p=products.get(index-1);
            p.pQty=String.valueOf(Integer.valueOf(p.pQty)+Integer.valueOf(txtPos.getText()));
            DbController.updateQty(p);
            products=DbController.getAllProduct();
            txtQty.setText(products.get(index-1).pQty);
            cmbNames.setSelectedIndex(index);
            JOptionPane.showConfirmDialog(this, "Qunatity Updated for Purchase");
        }else{
        
        Product pro=new Product();
        pro.pId="1";
        pro.pName=txtPname.getText();
        pro.pPur=txtPurchasePrice.getText();
        pro.pSale=txtSealPrice.getText();
        pro.pQty=txtPos.getText();
        pro.pDate=txtPDate.getText();
        DbController.purchaseProduct(pro);
        clear();
        products=DbController.getAllProduct();
        JOptionPane.showConfirmDialog(this, "Product Sved Successfully");
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPosActionPerformed

    private void cmbNamesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNamesItemStateChanged
        //List<Product> products=DbController.getAllProduct();
        int index=cmbNames.getSelectedIndex();
        if(index>0){
            Product p=products.get(index-1);
            txtPname.setText(p.pName);
            txtPurchasePrice.setText(p.pPur);
            txtSealPrice.setText(p.pSale);
            txtPDate.setText(p.pDate);
            txtQty.setText(p.pQty);
        }
    }//GEN-LAST:event_cmbNamesItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(cmbNames.getSelectedIndex()>0){
            int index=cmbNames.getSelectedIndex();
            Product p=products.get(index-1);
            p.pQty=String.valueOf(Integer.valueOf(p.pQty)-Integer.valueOf(txtPos.getText()));
            DbController.updateQty(p);
            products=DbController.getAllProduct();
            txtQty.setText(products.get(index-1).pQty);
            JOptionPane.showConfirmDialog(this, "Qunatity Updated for Sale");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbNames;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtPDate;
    private javax.swing.JTextField txtPname;
    private javax.swing.JTextField txtPos;
    private javax.swing.JTextField txtPurchasePrice;
    private javax.swing.JLabel txtQty;
    private javax.swing.JTextField txtSealPrice;
    // End of variables declaration//GEN-END:variables
}
