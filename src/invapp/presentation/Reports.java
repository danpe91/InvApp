package invapp.presentation;

import invapp.business.LogicProduct;
import invapp.business.LogicReport;
import invapp.dto.DTOProduct;
import invapp.dto.DTOSell;
import java.util.Date;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Reports extends javax.swing.JFrame {

    private final String[] months = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",  "Octubre", "Noviembre", "Diciembre" };
    private final int[] daysOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Reports() {
        setTitle("Reportes");
        setLocationByPlatform(true);
        initComponents();
        setLookAndFeel();
        Date date = new Date();
        
        daylyTotalAmountLabel.setText( "$" + 
        llenarTabla(new LogicReport().getDailyReport( date.getDate(),
                                                        date.getMonth() + 1,
                                                        date.getYear() + 1900), dailyReportTable));
        
        monthlyTotalAmountLabel.setText( "$" + 
        llenarTabla(new LogicReport().getMonthlyReport( date.getMonth() + 1,
                                                        date.getYear() + 1900), monthlyReportTable));
        llenarYearsCombo();
        llenarYearsCombo2();
        llenarTablaRelacionDeVentas(new LogicProduct().readInventory());
    }

    private double llenarTabla(List<DTOSell> products, javax.swing.JTable table) {
        
        DefaultTableModel currentModel = 
               (DefaultTableModel) table.getModel();
        Double totalAmount = 0d;
        
        currentModel.getDataVector().removeAllElements();

        for (DTOSell product : products) {
            double amount = product.getProduct().getUnitPrice() * product.getQuantity();
            Object[] row = {
                product.getSellNumber(),
                product.getProduct().getAccesory(),
                product.getProduct().getSize(),
                product.getQuantity(),
                amount,
                product.getDate()
            };
            
            currentModel.addRow(row);
            totalAmount += amount;
        }
        
        for (int i = 0; i < table.getColumnCount(); i++) {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            table.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        
        if(products.isEmpty()) {
            Object[] row = { null, null, null, null };
            currentModel.addRow(row);
            currentModel.removeRow(0);
        }
        
        return totalAmount;
        
    }
    
    private void llenarYearsCombo() {
        
        yearComboBox.removeAllItems();
        for ( int i = new Date().getYear() + 1900; i >= 2000; i--) {
            yearComboBox.addItem(i);
        }
        
        llenarMonthsCombo((int)yearComboBox.getSelectedItem());
    }
    
    private void llenarMonthsCombo(int year) {
        
        monthComboBox.removeAllItems();
        Date date = new Date();
        int limit = (year == date.getYear() + 1900)? date.getMonth() : 11;
        
        for (int i = 0; i <= limit; i++) {
            monthComboBox.addItem(months[i]);
        }
        
        llenarDaysCombo(year, monthComboBox.getSelectedIndex());
    }
    
    private void llenarDaysCombo(int year, int month) {
        
        dayComboBox.removeAllItems();
        
        int leapYear = (year % 4 == 0 && month == 1)? 1 : 0;
        
        for ( int i = 1; i <= daysOfMonths[month] + leapYear; i++)
            dayComboBox.addItem(i);
        
    }
    
    private void llenarYearsCombo2() {
        
        yearComboBox2.removeAllItems();
        for ( int i = new Date().getYear() + 1900; i >= 2000; i--) {
            yearComboBox2.addItem(i);
        }
        
        llenarMonthsCombo2((int)yearComboBox2.getSelectedItem());
    }
    
    private void llenarMonthsCombo2(int year) {
        
        monthComboBox2.removeAllItems();
        Date date = new Date();
        int limit = (year == date.getYear() + 1900)? date.getMonth() : 11;
        
        for (int i = 0; i <= limit; i++) {
            monthComboBox2.addItem(months[i]);
        }
        
    }
    
    private void llenarTablaRelacionDeVentas(List<DTOProduct> products) {
         DefaultTableModel currentModel = 
               (DefaultTableModel) sellsTable.getModel();
        
        currentModel.getDataVector().removeAllElements();

        for (DTOProduct product : products) {
            
            Object[] row = {
                product.getAccesory(),
                product.getStock(),
                product.getSize(),
                product.getSold(),
                product.getUnitPrice() * product.getSold()
            };
            currentModel.addRow(row);
        }
        
        for (int i = 0; i < sellsTable.getColumnCount(); i++) {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            sellsTable.getColumnModel().getColumn(i).setCellRenderer(tcr);
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
        daylyTotalSellsLabel = new javax.swing.JLabel();
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
        monthlyTotalSellsLabel = new javax.swing.JLabel();
        monthlyTotalAmountLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        sellsTable = new javax.swing.JTable();
        startButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        dailyReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Número de Venta", "Descripción", "Talla", "Cantidad", "Monto", "Fecha/Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dailyReportTable);
        dailyReportTable.getColumnModel().getColumn(0).setMinWidth(130);
        dailyReportTable.getColumnModel().getColumn(0).setPreferredWidth(130);
        dailyReportTable.getColumnModel().getColumn(1).setMinWidth(100);
        dailyReportTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        dailyReportTable.getColumnModel().getColumn(1).setMaxWidth(300);

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

        daylyTotalSellsLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        daylyTotalSellsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        daylyTotalSellsLabel.setText("Venta Total");

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
                            .addComponent(daylyTotalSellsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
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
                        .addComponent(daylyTotalSellsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Número de Venta", "Descripción", "Talla", "Cantidad", "Monto", "Fecha/Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(monthlyReportTable);
        monthlyReportTable.getColumnModel().getColumn(0).setMinWidth(130);
        monthlyReportTable.getColumnModel().getColumn(0).setPreferredWidth(130);
        monthlyReportTable.getColumnModel().getColumn(1).setMinWidth(100);
        monthlyReportTable.getColumnModel().getColumn(1).setPreferredWidth(150);

        monthlyTotalSellsLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        monthlyTotalSellsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monthlyTotalSellsLabel.setText("Venta Total");

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
                    .addComponent(monthlyTotalSellsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
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
                        .addComponent(monthlyTotalSellsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(monthlyTotalAmountLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        mainTabbedPane.addTab("Mensual", jPanel3);

        jPanel4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel4ComponentShown(evt);
            }
        });

        sellsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Existencia", "Talla", "Ventas", "Total Vendido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(sellsTable);

        startButton.setMnemonic('i');
        startButton.setText("Inicio");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(385, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Relación de Ventas", jPanel4);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

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

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jPanel4ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel4ComponentShown
        getRootPane().setDefaultButton(startButton);
    }//GEN-LAST:event_jPanel4ComponentShown

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        dispose();
        new Welcome().setVisible(true);
    }//GEN-LAST:event_startButtonActionPerformed

    private void jPanel3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel3ComponentShown
        getRootPane().setDefaultButton(generateMonthlyReportButton);
    }//GEN-LAST:event_jPanel3ComponentShown

    private void generateMonthlyReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateMonthlyReportButtonActionPerformed
        monthlyTotalAmountLabel.setText( "$" +
            llenarTabla(new LogicReport().getMonthlyReport( monthComboBox2.getSelectedIndex() + 1,
                (int)yearComboBox2.getSelectedItem()),
            monthlyReportTable));
    }//GEN-LAST:event_generateMonthlyReportButtonActionPerformed

    private void welcome2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_welcome2ButtonActionPerformed
        dispose();
        new Welcome().setVisible(true);
    }//GEN-LAST:event_welcome2ButtonActionPerformed

    private void yearComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboBox2ActionPerformed
        if(yearComboBox2 != null && yearComboBox2.getItemCount() > 0)
        llenarMonthsCombo2((int)yearComboBox2.getSelectedItem());
    }//GEN-LAST:event_yearComboBox2ActionPerformed

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
        getRootPane().setDefaultButton(generateDailyReportButton);
    }//GEN-LAST:event_jPanel2ComponentShown

    private void welcomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_welcomeButtonActionPerformed
        dispose();
        new Welcome().setVisible(true);
    }//GEN-LAST:event_welcomeButtonActionPerformed

    private void generateDailyReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateDailyReportButtonActionPerformed
        daylyTotalAmountLabel.setText( "$" +
            llenarTabla(new LogicReport().getDailyReport((int)dayComboBox.getSelectedItem(),
                monthComboBox.getSelectedIndex() + 1,
                (int)yearComboBox.getSelectedItem()),
            dailyReportTable));
    }//GEN-LAST:event_generateDailyReportButtonActionPerformed

    private void monthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboBoxActionPerformed
        if(monthComboBox != null && monthComboBox.getItemCount() > 0)
        llenarDaysCombo((int)yearComboBox.getSelectedItem(), monthComboBox.getSelectedIndex());
    }//GEN-LAST:event_monthComboBoxActionPerformed

    private void yearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboBoxActionPerformed
        if(yearComboBox != null && yearComboBox.getItemCount() > 0)
        llenarMonthsCombo((int)yearComboBox.getSelectedItem());
    }//GEN-LAST:event_yearComboBoxActionPerformed

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
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JTable dailyReportTable;
    private javax.swing.JComboBox dayComboBox;
    private javax.swing.JLabel daylyTotalAmountLabel;
    private javax.swing.JLabel daylyTotalSellsLabel;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton generateDailyReportButton;
    private javax.swing.JButton generateMonthlyReportButton;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JComboBox monthComboBox;
    private javax.swing.JComboBox monthComboBox2;
    private javax.swing.JTable monthlyReportTable;
    private javax.swing.JLabel monthlyTotalAmountLabel;
    private javax.swing.JLabel monthlyTotalSellsLabel;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JTable sellsTable;
    private javax.swing.JButton startButton;
    private javax.swing.JButton welcome2Button;
    private javax.swing.JButton welcomeButton;
    private javax.swing.JComboBox yearComboBox;
    private javax.swing.JComboBox yearComboBox2;
    // End of variables declaration//GEN-END:variables
}
