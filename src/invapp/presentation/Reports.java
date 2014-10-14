package invapp.presentation;

import invapp.business.LogicReport;
import invapp.dto.DTOSale;
import java.util.Date;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Reports extends javax.swing.JFrame {

    private final String[] months = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private final int[] daysOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Reports() {
        setTitle("Reportes");
        setLocationByPlatform(true);
        initComponents();
        setLookAndFeel();
        Date date = new Date();

        double daylyAmount = llenarTabla(new LogicReport().getDailyReport(date.getDate(),
                date.getMonth() + 1,
                date.getYear() + 1900), dailyReportTable);
        double monthlyAmount = llenarTabla(new LogicReport().getMonthlyReport(date.getMonth() + 1,
                date.getYear() + 1900), monthlyReportTable);

        daylyTotalAmountLabel.setText(String.format("$ %.2f", daylyAmount));
        monthlyTotalAmountLabel.setText(String.format("$ %.2f", monthlyAmount));

        llenarYearsCombo();
        llenarYearsCombo2();
    }

    private double llenarTabla(List<DTOSale> products, javax.swing.JTable table) {

        DefaultTableModel currentModel
                = (DefaultTableModel) table.getModel();
        Double totalAmount = 0d;

        currentModel.getDataVector().removeAllElements();

        for (DTOSale product : products) {
            double amount = product.getProduct().getUnitPrice() * product.getQuantity();
            Object[] row = {
                product.getSaleNumber().toString(),
                product.getProduct().getProduct(),
                product.getQuantity(),
                String.format("$%.2f", amount),
                product.getDate()
            };

            currentModel.addRow(row);
            totalAmount += amount;
        }

        for (int i = 0;
                i < table.getColumnCount();
                i++) {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            table.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        DefaultTableCellRenderer tcrRight = new DefaultTableCellRenderer();

        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        tcrRight.setHorizontalAlignment(SwingConstants.RIGHT);

        table.getColumnModel()
                .getColumn(1).setCellRenderer(tcr);
        table.getColumnModel()
                .getColumn(2).setCellRenderer(tcrRight);
        table.getColumnModel()
                .getColumn(3).setCellRenderer(tcrRight);

        if (products.isEmpty()) {
            Object[] row = {null, null, null, null};
            currentModel.addRow(row);
            currentModel.removeRow(0);
        }

        return totalAmount;

    }

    private void llenarYearsCombo() {

        yearComboBox.removeAllItems();
        for (int i = new Date().getYear() + 1900; i >= 2000; i--) {
            yearComboBox.addItem(i);
        }

        llenarMonthsCombo((int) yearComboBox.getSelectedItem());
    }

    private void llenarMonthsCombo(int year) {

        monthComboBox.removeAllItems();
        Date date = new Date();
        int limit = (year == date.getYear() + 1900) ? date.getMonth() : 11;

        for (int i = 0; i <= limit; i++) {
            monthComboBox.addItem(months[i]);
        }

        monthComboBox.setSelectedIndex(limit);
        llenarDaysCombo(year, monthComboBox.getSelectedIndex());
    }

    private void llenarDaysCombo(int year, int month) {

        dayComboBox.removeAllItems();

        int leapYear = (year % 4 == 0 && month == 1) ? 1 : 0;
        int currentDay = new Date().getDate();
        int limit = ((currentDay < daysOfMonths[month])?(currentDay):(daysOfMonths[month]));
                
        for (int i = 1; i <= limit + leapYear; i++) {
            dayComboBox.addItem(i);
        }

        dayComboBox.setSelectedIndex(limit - 1);
    }

    private void llenarYearsCombo2() {

        yearComboBox2.removeAllItems();
        for (int i = new Date().getYear() + 1900; i >= 2000; i--) {
            yearComboBox2.addItem(i);
        }

        llenarMonthsCombo2((int) yearComboBox2.getSelectedItem());
    }

    private void llenarMonthsCombo2(int year) {

        monthComboBox2.removeAllItems();
        Date date = new Date();
        int limit = (year == date.getYear() + 1900) ? date.getMonth() : 11;

        for (int i = 0; i <= limit; i++) {
            monthComboBox2.addItem(months[i]);
        }

        monthComboBox2.setSelectedIndex(limit);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dailyReportTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox();
        monthComboBox = new javax.swing.JComboBox();
        dayComboBox = new javax.swing.JComboBox();
        generateDailyReportButton = new javax.swing.JButton();
        welcomeButton = new javax.swing.JButton();
        daylyTotalSalesLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        daylyTotalAmountLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        yearComboBox2 = new javax.swing.JComboBox();
        monthComboBox2 = new javax.swing.JComboBox();
        welcome2Button = new javax.swing.JButton();
        generateMonthlyReportButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        monthlyReportTable = new javax.swing.JTable();
        monthlyTotalSalesLabel = new javax.swing.JLabel();
        monthlyTotalAmountLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        dailyReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Número de Venta", "Producto", "Cantidad", "Monto", "Fecha/Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dailyReportTable);
        if (dailyReportTable.getColumnModel().getColumnCount() > 0) {
            dailyReportTable.getColumnModel().getColumn(0).setMinWidth(40);
            dailyReportTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            dailyReportTable.getColumnModel().getColumn(1).setMinWidth(100);
            dailyReportTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            dailyReportTable.getColumnModel().getColumn(1).setMaxWidth(300);
            dailyReportTable.getColumnModel().getColumn(2).setPreferredWidth(40);
            dailyReportTable.getColumnModel().getColumn(3).setPreferredWidth(40);
            dailyReportTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jLabel1.setText("Año");

        jLabel2.setText("Mes");

        jLabel3.setText("Día");

        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        yearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboBoxActionPerformed(evt);
            }
        });

        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        monthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboBoxActionPerformed(evt);
            }
        });

        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        generateDailyReportButton.setMnemonic('g');
        generateDailyReportButton.setText("Generar");
        generateDailyReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateDailyReportButtonActionPerformed(evt);
            }
        });

        welcomeButton.setMnemonic('i');
        welcomeButton.setText("Inicio");
        welcomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                welcomeButtonActionPerformed(evt);
            }
        });

        daylyTotalSalesLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        daylyTotalSalesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        daylyTotalSalesLabel.setText("Venta Total");

        daylyTotalAmountLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        daylyTotalAmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        daylyTotalAmountLabel.setText("jLabel7");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yearComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dayComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(monthComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(welcomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(generateDailyReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(daylyTotalSalesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(daylyTotalAmountLabel)
                                .addGap(82, 82, 82)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(generateDailyReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(welcomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(daylyTotalSalesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(daylyTotalAmountLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        mainTabbedPane.addTab("Diario", jPanel2);

        jPanel3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel3ComponentShown(evt);
            }
        });

        jLabel4.setText("Año");

        jLabel5.setText("Mes");

        yearComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        yearComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboBox2ActionPerformed(evt);
            }
        });

        monthComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        welcome2Button.setMnemonic('i');
        welcome2Button.setText("Inicio");
        welcome2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                welcome2ButtonActionPerformed(evt);
            }
        });

        generateMonthlyReportButton.setMnemonic('g');
        generateMonthlyReportButton.setText("Generar");
        generateMonthlyReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateMonthlyReportButtonActionPerformed(evt);
            }
        });

        monthlyReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Número de Venta", "Producto", "Cantidad", "Monto", "Fecha/Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(monthlyReportTable);
        if (monthlyReportTable.getColumnModel().getColumnCount() > 0) {
            monthlyReportTable.getColumnModel().getColumn(0).setMinWidth(40);
            monthlyReportTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            monthlyReportTable.getColumnModel().getColumn(2).setPreferredWidth(40);
            monthlyReportTable.getColumnModel().getColumn(3).setPreferredWidth(40);
            monthlyReportTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        monthlyTotalSalesLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        monthlyTotalSalesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monthlyTotalSalesLabel.setText("Venta Total");

        monthlyTotalAmountLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        monthlyTotalAmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monthlyTotalAmountLabel.setText("jLabel7");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yearComboBox2, 0, 164, Short.MAX_VALUE)
                                    .addComponent(monthComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(welcome2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(generateMonthlyReportButton, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))))
                    .addComponent(monthlyTotalSalesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(monthlyTotalAmountLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(yearComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(generateMonthlyReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(welcome2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addComponent(monthlyTotalSalesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(monthlyTotalAmountLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        mainTabbedPane.addTab("Mensual", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel3ComponentShown
        getRootPane().setDefaultButton(generateMonthlyReportButton);
    }//GEN-LAST:event_jPanel3ComponentShown

    private void generateMonthlyReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateMonthlyReportButtonActionPerformed

        double monthlyTotalAmount;
        monthlyTotalAmount = llenarTabla(new LogicReport().getMonthlyReport(monthComboBox2.getSelectedIndex() + 1,
                (int) yearComboBox2.getSelectedItem()),
                monthlyReportTable);
        
        monthlyTotalAmountLabel.setText(String.format("$ %.2f", monthlyTotalAmount));
    }//GEN-LAST:event_generateMonthlyReportButtonActionPerformed

    private void welcome2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_welcome2ButtonActionPerformed
        dispose();
    }//GEN-LAST:event_welcome2ButtonActionPerformed

    private void yearComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboBox2ActionPerformed
        if (yearComboBox2 != null && yearComboBox2.getItemCount() > 0) {
            llenarMonthsCombo2((int) yearComboBox2.getSelectedItem());
        }
    }//GEN-LAST:event_yearComboBox2ActionPerformed

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
        getRootPane().setDefaultButton(generateDailyReportButton);
    }//GEN-LAST:event_jPanel2ComponentShown

    private void welcomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_welcomeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_welcomeButtonActionPerformed

    private void generateDailyReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateDailyReportButtonActionPerformed

        double daylyTotalAmount;
        daylyTotalAmount = llenarTabla(new LogicReport().getDailyReport((int) dayComboBox.getSelectedItem(),
                monthComboBox.getSelectedIndex() + 1,
                (int) yearComboBox.getSelectedItem()),
                dailyReportTable);

        daylyTotalAmountLabel.setText(String.format("$ %.2f", daylyTotalAmount));
    }//GEN-LAST:event_generateDailyReportButtonActionPerformed

    private void monthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboBoxActionPerformed
        if (monthComboBox != null && monthComboBox.getItemCount() > 0) {
            llenarDaysCombo((int) yearComboBox.getSelectedItem(), monthComboBox.getSelectedIndex());
        }
    }//GEN-LAST:event_monthComboBoxActionPerformed

    private void yearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboBoxActionPerformed
        if (yearComboBox != null && yearComboBox.getItemCount() > 0) {
            llenarMonthsCombo((int) yearComboBox.getSelectedItem());
        }
    }//GEN-LAST:event_yearComboBoxActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

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
    private javax.swing.JTable dailyReportTable;
    private javax.swing.JComboBox dayComboBox;
    private javax.swing.JLabel daylyTotalAmountLabel;
    private javax.swing.JLabel daylyTotalSalesLabel;
    private javax.swing.JButton generateDailyReportButton;
    private javax.swing.JButton generateMonthlyReportButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JComboBox monthComboBox;
    private javax.swing.JComboBox monthComboBox2;
    private javax.swing.JTable monthlyReportTable;
    private javax.swing.JLabel monthlyTotalAmountLabel;
    private javax.swing.JLabel monthlyTotalSalesLabel;
    private javax.swing.JButton welcome2Button;
    private javax.swing.JButton welcomeButton;
    private javax.swing.JComboBox yearComboBox;
    private javax.swing.JComboBox yearComboBox2;
    // End of variables declaration//GEN-END:variables
}
