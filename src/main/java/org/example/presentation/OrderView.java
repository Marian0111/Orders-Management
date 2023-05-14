package org.example.presentation;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
public class OrderView {
    private JLabel titleLBL1 = new JLabel("Order Page");
    private JLabel titleLBL2 = new JLabel("Add Order");
    private JLabel titleLBL3 = new JLabel("Show all Orders");
    private JFrame frame = new JFrame("Order Page");
    private JPanel mainPanel = new JPanel();
    private JPanel insertPanel = new JPanel();
    private JPanel showAllPanel = new JPanel();
    private JButton insertOrderBTN = new JButton("INSERT NEW ORDER");
    private JButton showAllOrderBTN = new JButton("SHOW ALL ORDERS");
    private JLabel quantityLBL = new JLabel("Quantity: ");
    private JTextField quantityTXT = new JTextField();
    private JButton insertBTN = new JButton("INSERT");
    private JButton backBTN1 = new JButton("BACK");
    private JButton backBTN2 = new JButton("BACK");
    private JTable table1 = new JTable();
    private JScrollPane sp1 = new JScrollPane(table1);
    private JTable table2 = new JTable();
    private JScrollPane sp2 = new JScrollPane(table2);
    private JTable table3 = new JTable();
    private JScrollPane sp3 = new JScrollPane(table3);
    private Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
    public OrderView(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int) (dimension.getWidth() - frame.getWidth()) / 2, (int) (dimension.getHeight() - frame.getHeight()) / 2);

        //MAIN PANEL
        mainPanel.setBackground(Color.LIGHT_GRAY);

        titleLBL1.setFont(new Font("Calibri", Font.BOLD, 30));
        titleLBL1.setBounds((frame.getWidth() - 300) / 2, 50, 300, 30);
        titleLBL1.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLBL1);

        insertOrderBTN.setBounds((frame.getWidth() - 300) / 2, 300, 300, 50);
        insertOrderBTN.setBorder(border);
        mainPanel.add(insertOrderBTN);

        showAllOrderBTN.setBounds((frame.getWidth() - 300) / 2, 400, 300, 50);
        showAllOrderBTN.setBorder(border);
        mainPanel.add(showAllOrderBTN);

        mainPanel.setLayout(null);

        //INSERT PANEL
        insertPanel.setBackground(Color.LIGHT_GRAY);

        titleLBL2.setFont(new Font("Calibri", Font.BOLD, 30));
        titleLBL2.setBounds((frame.getWidth() - 300) / 2, 30, 300, 30);
        titleLBL2.setHorizontalAlignment(SwingConstants.CENTER);
        insertPanel.add(titleLBL2);

        quantityLBL.setFont(new Font("Calibri", Font.BOLD, 20));
        quantityLBL.setBounds(300, 650, 150, 30);
        quantityLBL.setHorizontalAlignment(SwingConstants.CENTER);
        insertPanel.add(quantityLBL);

        quantityTXT.setBounds(500, 650, 300, 30);
        quantityTXT.setBorder(border);
        insertPanel.add(quantityTXT);

        insertBTN.setBounds((frame.getWidth() - 200) / 2, 700, 200, 40);
        insertBTN.setBorder(border);
        insertPanel.add(insertBTN);

        backBTN1.setBounds(1050, 700, 100, 40);
        backBTN1.setBorder(border);
        insertPanel.add(backBTN1);

        insertPanel.setLayout(null);

        //SHOW ALL PANEL
        showAllPanel.setBackground(Color.LIGHT_GRAY);

        titleLBL3.setFont(new Font("Calibri", Font.BOLD, 30));
        titleLBL3.setBounds((frame.getWidth() - 300) / 2, 50, 300, 30);
        titleLBL3.setHorizontalAlignment(SwingConstants.CENTER);
        showAllPanel.add(titleLBL3);

        backBTN2.setBounds(1050, 700, 100, 40);
        backBTN2.setBorder(border);
        showAllPanel.add(backBTN2);

        showAllPanel.setLayout(null);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }

    public String getQuantityTXT() {
        return quantityTXT.getText();
    }

    public void createTable1(DefaultTableModel defaultTableModel){
        table1 = new JTable(defaultTableModel);
        table1.setRowHeight(50);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table1.setFont(new Font("Calibri", 0, 15));
        table1.getTableHeader().setResizingAllowed(false);
        table1.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 20));
        sp1.setViewportView(table1);
        sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp1.setBorder(border);
        sp1.setBounds(50, 75, 1100, 275);
        insertPanel.add(sp1);
    }
    public void createTable2(DefaultTableModel defaultTableModel){
        table2 = new JTable(defaultTableModel);
        table2.setRowHeight(50);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table2.setFont(new Font("Calibri", 0, 15));
        table2.getTableHeader().setResizingAllowed(false);
        table2.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 20));
        sp2.setViewportView(table2);
        sp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp2.setBorder(border);
        sp2.setBounds(50, 360, 1100, 275);
        insertPanel.add(sp2);
    }
    public void createTable3(DefaultTableModel defaultTableModel){
        table3 = new JTable(defaultTableModel);
        table3.setRowHeight(50);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table3.setFont(new Font("Calibri", 0, 15));
        table3.getTableHeader().setResizingAllowed(false);
        table3.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 20));
        sp3.setViewportView(table3);
        sp3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp3.setBorder(border);
        sp3.setBounds((frame.getWidth() - 1100) / 2, 130, 1100, 550);
        showAllPanel.add(sp3);
    }
    public Integer returnClientID(){
        int selectedRow = table1.getSelectedRow();
        if (selectedRow == -1) {
            return -1;
        }
        return Integer.parseInt(table1.getValueAt(selectedRow, 0).toString());
    }
    public Integer returnProductID(){
        int selectedRow = table2.getSelectedRow();
        if (selectedRow == -1) {
            return -1;
        }
        return Integer.parseInt(table2.getValueAt(selectedRow, 0).toString());
    }
    public void insertOrderListener(ActionListener actionListener) {
        insertOrderBTN.addActionListener(actionListener);
    }
    public void showAllOrderListener(ActionListener actionListener) {
        showAllOrderBTN.addActionListener(actionListener);
    }
    public void insertListener(ActionListener actionListener) {
        insertBTN.addActionListener(actionListener);
    }
    public void backListener(ActionListener actionListener) {
        backBTN1.addActionListener(actionListener);
        backBTN2.addActionListener(actionListener);
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(insertPanel, message);
    }
    public void changePanel(int i){
        if(i == 0){
            frame.setContentPane(mainPanel);
        }else if(i == 1){
            frame.setContentPane(insertPanel);
        }else if(i == 2){
            frame.setContentPane(showAllPanel);
        }
        frame.setVisible(true);
    }
}
