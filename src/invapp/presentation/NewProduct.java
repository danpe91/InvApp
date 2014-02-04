package invapp.presentation;

import invapp.business.LogicProduct;
import invapp.dto.DTOProduct;

public class NewProduct extends javax.swing.JFrame {
    
    private boolean edit;
    
    static {
        setLookAndFeel();
    }
    
    public NewProduct(DTOProduct inv) {
        
        setTitle("Nuevo Producto");
        initComponents();
        setLocationByPlatform(true);
        prepareRadioButtonsSet();
        productTextField.setText(inv.getProduct());
        unitPriceTextField.setText(inv.getUnitPrice().toString());
        unitPriceTextField.setText(inv.getUnitPrice().toString());
        codeTextField.setText(inv.getCode().toString());
        addButton.setText("Guardar");
        edit = true;
    }
    
    public NewProduct() {
        
        setTitle("Nuevo Producto");
        initComponents();
        setLocationByPlatform(true);
        prepareRadioButtonsSet();
        edit = false;
    }
    
    public void insertProduct() {
        
        if (checkEmptyFields()) {
            
            try {
                
                DTOProduct nacc = new DTOProduct();
                
                new LogicProduct().insertProduct(nacc);
                cleanFields();
                
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void cleanFields() {
        
        productTextField.setText("");
        unitPriceTextField.setText("");
        codeTextField.setText("");
    }
    
    public void editAccesory() {
        
        DTOProduct nacc = new DTOProduct();
        
        new LogicProduct().editProduct(nacc);
        cleanFields();
    }
    
    private boolean checkEmptyFields() {
        
        return !(productTextField.getText().isEmpty()
                || unitPriceTextField.getText().isEmpty()
                || codeTextField.getText().isEmpty()
                || (weightRadioButton.isSelected() && quantityRadioButton.isSelected()));
    }
    
    private void prepareRadioButtonsSet() {
        
        buttonGroup.add(weightRadioButton);
        buttonGroup.add(quantityRadioButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        productTextField = new javax.swing.JTextField();
        unitPriceTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();
        weightRadioButton = new javax.swing.JRadioButton();
        quantityRadioButton = new javax.swing.JRadioButton();
        codeLabel = new javax.swing.JLabel();
        codeTextField = new javax.swing.JTextField();
        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Producto");

        jLabel2.setText("Tipo de venta");

        jLabel4.setText("Precio Unitario");

        addButton.setMnemonic('A');
        addButton.setText("Agregar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        salirButton.setMnemonic('s');
        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        weightRadioButton.setText("Por peso");

        quantityRadioButton.setText("Por cantidad");

        codeLabel.setText("Clave");
        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(salirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quantityRadioButton)
                                    .addComponent(weightRadioButton))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(productTextField))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(codeLabel))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(unitPriceTextField)
                            .addComponent(codeTextField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(productTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(weightRadioButton))
                .addGap(2, 2, 2)
                .addComponent(quantityRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(unitPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codeLabel)
                    .addComponent(codeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        getRootPane().setDefaultButton(addButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        
        if (!edit) {
            insertProduct();
        } else {
            editAccesory();
            dispose();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        
        dispose();
    }//GEN-LAST:event_salirButtonActionPerformed
    
    private static void setLookAndFeel() {
        
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
    private javax.swing.JButton addButton;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JTextField codeTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField productTextField;
    private javax.swing.JRadioButton quantityRadioButton;
    private javax.swing.JButton salirButton;
    private javax.swing.JTextField unitPriceTextField;
    private javax.swing.JRadioButton weightRadioButton;
    // End of variables declaration//GEN-END:variables
}
