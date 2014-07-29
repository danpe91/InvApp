package invapp.presentation;

import invapp.business.LogicProduct;
import invapp.business.LogicSale;
import invapp.dto.DTOProduct;
import invapp.dto.DTOSale;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;

public class NewSale extends javax.swing.JFrame {

    private List<DTOSale> cartList;
    private DTOProduct currentProduct;
    private Integer saleNumber;
    private List<String> barCodes;

    public NewSale() {

        setTitle("Nueva Venta");
        setLocationByPlatform(true);
        saleNumber = new LogicSale().getNewSaleNumber();
        barCodes = new LogicProduct().getListOfCodes();
        initComponents();
        setLookAndFeel();
        cartList = new LinkedList<>();
        cleanFields();
        cartTable.setFocusable(false);

    }

    private void llenarTabla(List<DTOSale> products) {
        DefaultTableModel currentModel
                = (DefaultTableModel) this.cartTable.getModel();
        Double totalCost = 0.0;

        currentModel.getDataVector().removeAllElements();
        try {
            if (products == null || products.isEmpty()) {

                Object[] row = {null, null, null, null};
                currentModel.addRow(row);
                currentModel.removeRow(0);
            } else {

                for (DTOSale product : products) {

                    double total = product.getProduct().getUnitPrice() * product.getQuantity();

                    Object[] row = {
                        product.getProduct().getProduct(),
                        product.getQuantity(),
                        String.format("$%.2f", product.getProduct().getUnitPrice()),
                        String.format("$%.2f", total)
                    };
                    currentModel.addRow(row);
                    totalCost += total;
                }
                totalTextField.setText(String.format("$%.2f", totalCost));
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        newSaleButton = new javax.swing.JButton();
        costTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        totalTextField = new javax.swing.JTextField();
        addToCartButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        codeTextField = new javax.swing.JTextField();
        seekButton = new javax.swing.JButton();
        productTextField = new javax.swing.JTextField();
        removeButton = new javax.swing.JButton();
        quantitySpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        newSaleButton.setMnemonic('v');
        newSaleButton.setText("Vender");
        newSaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSaleButtonActionPerformed(evt);
            }
        });

        costTextField.setEditable(false);

        jLabel1.setText("Producto");

        quantityLabel.setText("Cantidad");

        jLabel3.setText("Costo");

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Costo", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cartTable);

        jLabel4.setFont(new java.awt.Font("Cantarell", 1, 12)); // NOI18N
        jLabel4.setText("Total");

        totalTextField.setEditable(false);
        totalTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        addToCartButton.setMnemonic('a');
        addToCartButton.setText("Agregar");
        addToCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartButtonActionPerformed(evt);
            }
        });

        exitButton.setMnemonic('i');
        exitButton.setText("Inicio");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("Código");

        codeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codeTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codeTextFieldKeyReleased(evt);
            }
        });

        seekButton.setMnemonic('b');
        seekButton.setText("Buscar");
        seekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seekButtonActionPerformed(evt);
            }
        });

        removeButton.setMnemonic('r');
        removeButton.setText("Remover");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(seekButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(codeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(81, 81, 81)
                            .addComponent(totalTextField))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(quantityLabel)
                                .addComponent(jLabel1))
                            .addGap(81, 81, 81)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(costTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                .addComponent(productTextField)
                                .addComponent(quantitySpinner))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(newSaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(addToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(codeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seekButton, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(productTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantityLabel)
                            .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(costTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addToCartButton, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(newSaleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(seekButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newSaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSaleButtonActionPerformed

        double total = 0d;

        for (DTOSale sale : cartList) {

            total += (sale.getProduct().getUnitPrice().doubleValue() * sale.getQuantity().doubleValue());
        }

        new PaymentChange(this, cartList, total).setVisible(true);
    }//GEN-LAST:event_newSaleButtonActionPerformed

    private boolean validateEmptyFields() {

        return !((codeTextField.getText().isEmpty())
                || (productTextField.getText().isEmpty())
                || (((int)quantitySpinner.getValue()) == 0));
    }

    private void addToCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartButtonActionPerformed

        if (validateEmptyFields()) {

            DTOSale sale = new DTOSale();

            sale.setProduct(currentProduct);
            sale.setQuantity((int)quantitySpinner.getValue());
            sale.setSaleNumber(saleNumber);
            cartList.add(sale);

            llenarTabla(cartList);
            cleanFields();
            getRootPane().setDefaultButton(seekButton);
            codeTextField.requestFocus();

        } else {
            if ((((int)quantitySpinner.getValue()) == 0) && !productTextField.getText().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error: cantidad no ingresada.",
                        "Ha ocurrido un error", javax.swing.JOptionPane.ERROR_MESSAGE);
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Error: no se ha seleccionado algun producto.",
                        "Ha ocurrido un error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_addToCartButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed

        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void codeTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeTextFieldKeyReleased

        if (!(evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90 || evt.getKeyCode() > 96 && evt.getKeyCode() <= 122 || evt.getKeyCode() >= 48 && evt.getKeyCode() <= 57)) {
            return;
        }
        if (codeTextField.getText().isEmpty() || barCodes.isEmpty()) {
            return;
        }
        setCodeAndSelectExtraText(codeTextField, getExistingCode(codeTextField.getText(), barCodes));
    }//GEN-LAST:event_codeTextFieldKeyReleased

    private void codeTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            codeTextFieldKeyReleased(evt);
        }
        getRootPane().setDefaultButton(seekButton);
    }//GEN-LAST:event_codeTextFieldKeyPressed

    private void seekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seekButtonActionPerformed

        getRootPane().setDefaultButton(addToCartButton);
        DTOProduct prod = null;
        
        if (codeTextField != null && !codeTextField.getText().isEmpty()) {

            for (String finalCode : barCodes) {
                if (finalCode.equalsIgnoreCase(codeTextField.getText())) {
                    codeTextField.setText(finalCode);
                    prod = new LogicProduct().readProductByCode(finalCode);
                    fillInFields(prod);
                    quantitySpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, prod.getStock().intValue(), 1));
                    quantitySpinner.requestFocus();
                    return;
                }
            }
        }
        cleanFields();
    }//GEN-LAST:event_seekButtonActionPerformed

    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTableMouseClicked

        removeButton.setEnabled(true);
    }//GEN-LAST:event_cartTableMouseClicked

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed

        cartList.remove(cartTable.getSelectedRow());
        llenarTabla(cartList);
        cartTable.clearSelection();
        removeButton.setEnabled(false);
    }//GEN-LAST:event_removeButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private int getPositionInVector(String code, List<String> codes) {

        for (int i = 0; i < codes.size(); i++) {
            try {
                if (code.equalsIgnoreCase(codes.get(i).substring(0, code.length()))) {
                    return i;
                }
            } catch (java.lang.StringIndexOutOfBoundsException e) {

            }
        }

        return -1;
    }

    private String getExistingCode(String code, List<String> codes) {

        int position = getPositionInVector(code, codes);

        return position == -1 ? code : codes.get(position);
    }

    private void setCodeAndSelectExtraText(javax.swing.JTextField field, String newCode) {

        String seekCode = "";
        int currentLength = field.getText().length();
        seekCode = newCode.substring(currentLength, newCode.length());

        if (newCode.isEmpty() || seekCode.isEmpty()) {
            return;
        }

        try {
            field.getDocument().insertString(field.getCaretPosition(), seekCode, null);
        } catch (BadLocationException e) {
        } finally {
            field.select(currentLength, field.getText().length());
        }

    }

    private void fillInFields(DTOProduct product) {

        currentProduct = product;
        productTextField.setText(product.getProduct());
        costTextField.setText(product.getUnitPrice().toString());

    }

    private void cleanFields() {

        codeTextField.setText("");
        currentProduct = null;
        productTextField.setText("");
        quantitySpinner.setModel(new javax.swing.SpinnerNumberModel(1, 0, Integer.MAX_VALUE, 1));
        costTextField.setText("");

    }

    private void setLookAndFeel() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCartButton;
    private javax.swing.JTable cartTable;
    private javax.swing.JTextField codeTextField;
    private javax.swing.JTextField costTextField;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newSaleButton;
    private javax.swing.JTextField productTextField;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton seekButton;
    private javax.swing.JTextField totalTextField;
    // End of variables declaration//GEN-END:variables
}
