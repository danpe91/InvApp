package invapp.presentation;

import invapp.business.LogicProduct;
import invapp.dto.DTOProduct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Welcome extends javax.swing.JFrame {

    public Welcome() {
        setTitle("Inicio");
        setLocationByPlatform(true);
        initComponents();
        // insertProductsFromFile("productos.cvs");
    }

    private void insertProductsFromFile(String fileName) {

        try {

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";
            String data[];
            while (line != null) {

                line = br.readLine();
                if (line == null || line.trim().isEmpty() || line.charAt(0) == '#') {
                    continue;
                } else {
                    data = line.split(",");
                    LogicProduct lp = new LogicProduct();
                    DTOProduct product = new DTOProduct(data[0],
                            data[1], Double.valueOf(data[2]), Integer.valueOf(data[3]));

                    DTOProduct existentProduct = lp.readProductByCode(product.getCode());
                    if (existentProduct == null) {
                        System.out.println("New product: " + product);
                        new LogicProduct().insertProduct(product);
                    }
                }
            }

        } catch (FileNotFoundException fne) {
            fne.printStackTrace();
        } catch (IOException fne) {
            fne.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inventoryButton = new javax.swing.JButton();
        newSaleButton = new javax.swing.JButton();
        reportsButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inventoryButton.setMnemonic('p');
        inventoryButton.setText("Productos");
        inventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventarioButtonActionPerformed(evt);
            }
        });

        newSaleButton.setMnemonic('V');
        newSaleButton.setText("Venta");
        newSaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentaButtonActionPerformed(evt);
            }
        });

        reportsButton.setMnemonic('R');
        reportsButton.setText("Reportes");
        reportsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsButtonActionPerformed(evt);
            }
        });

        exitButton.setMnemonic('s');
        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(reportsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inventoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newSaleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(inventoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newSaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InventarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventarioButtonActionPerformed

        new Inventory().setVisible(true);
    }//GEN-LAST:event_InventarioButtonActionPerformed

    private void VentaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentaButtonActionPerformed

        new NewSale().setVisible(true);
    }//GEN-LAST:event_VentaButtonActionPerformed

    private void reportsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsButtonActionPerformed

        new Reports().setVisible(true);
    }//GEN-LAST:event_reportsButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    public static void main(String... args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Welcome().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JButton inventoryButton;
    private javax.swing.JButton newSaleButton;
    private javax.swing.JButton reportsButton;
    // End of variables declaration//GEN-END:variables
}
