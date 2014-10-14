package invapp.presentation;

import invapp.business.LogicSale;
import invapp.dto.DTOSale;
import java.awt.Component;
import java.util.List;

public class PaymentChange extends javax.swing.JFrame {

    private double moneyGiven;
    private final double total;
    private final List<DTOSale> cartList;
    private final javax.swing.JFrame parent;
    
    public PaymentChange(Component c, List<DTOSale> cartList, Double total) {

        setTitle("Pago");
        setLocationRelativeTo(c);
        initComponents();
        setLookAndFeel();
        totalLabel.setText(String.format("$%.2f", total));
        moneyChangeLabel.setText(String.format("$%.2f", 0d));
        this.cartList = cartList;
        this.total = total;
        this.parent = (javax.swing.JFrame)c;
        getRootPane().setDefaultButton(acceptButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        moneyGivenTextField = new javax.swing.JTextField();
        acceptButton = new javax.swing.JButton();
        changeButton = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        moneyChangeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Total");

        jLabel2.setText("Recibo");

        jLabel3.setText("Cambio");

        moneyGivenTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                moneyGivenTextFieldKeyReleased(evt);
            }
        });

        acceptButton.setMnemonic('a');
        acceptButton.setText("Aceptar");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        changeButton.setMnemonic('c');
        changeButton.setText("Cancelar");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        totalLabel.setText("total");

        moneyChangeLabel.setText("cambio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(moneyGivenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalLabel)
                            .addComponent(moneyChangeLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(totalLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(moneyGivenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(moneyChangeLabel))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void moneyGivenTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moneyGivenTextFieldKeyReleased

        String moneyGivenString = moneyGivenTextField.getText();
        

        try {
            moneyGiven = ((moneyGivenString.isEmpty())
                    ? (0d)
                    : (Double.valueOf(moneyGivenString)));
        } catch (java.lang.NumberFormatException e) {
            moneyGiven = 0d;
        }

        Double moneyChange = moneyGiven - total;
        moneyChangeLabel.setText(String.format("$%.2f", moneyChange));

    }//GEN-LAST:event_moneyGivenTextFieldKeyReleased

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        
        new LogicSale().insertSales(cartList);
        // new LogicSale().printData(cartList, total, moneyGiven);

        parent.dispose();
        dispose();
        new NewSale().setVisible(true);
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        
        dispose();
    }//GEN-LAST:event_changeButtonActionPerformed

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
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton changeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel moneyChangeLabel;
    private javax.swing.JTextField moneyGivenTextField;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
