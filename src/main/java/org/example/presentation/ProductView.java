package org.example.presentation;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
public class ProductView {
    private JLabel titleLBL1 = new JLabel("Product Page");
    private JLabel titleLBL2 = new JLabel("Add Product");
    private JLabel titleLBL3 = new JLabel("Edit Product");
    private JLabel titleLBL4 = new JLabel("Delete Product");
    private JLabel titleLBL5 = new JLabel("Show all Products");
    private JFrame frame = new JFrame("Product Page");
    private JPanel mainPanel = new JPanel();
    private JPanel insertPanel = new JPanel();
    private JPanel editPanel = new JPanel();
    private JPanel deletePanel = new JPanel();
    private JPanel showAllPanel = new JPanel();
    private JButton insertProductBTN = new JButton("INSERT NEW PRODUCT");
    private JButton editProductBTN = new JButton("EDIT A PRODUCT");
    private JButton deleteProductBTN = new JButton("DELETE PRODUCT");
    private JButton showAllProductBTN = new JButton("SHOW ALL PRODUCTS");
    private JLabel nameLBL = new JLabel("Product name: ");
    private JLabel priceLBL = new JLabel("Price: ");
    private JLabel stockLBL = new JLabel("Stock: ");
    private JTextField nameTXT = new JTextField();
    private JTextField priceTXT = new JTextField();
    private JTextField stockTXT = new JTextField();
    private JButton insertBTN = new JButton("INSERT");
    private JButton backBTN1 = new JButton("BACK");
    private JButton backBTN2 = new JButton("BACK");
    private JButton backBTN3 = new JButton("BACK");
    private JButton backBTN4 = new JButton("BACK");
    private JTable table = new JTable();
    private JScrollPane sp = new JScrollPane(table);
    private JLabel nameLBL1 = new JLabel("Product name: ");
    private JLabel priceLBL1 = new JLabel("Price: ");
    private JLabel stockLBL1 = new JLabel("Stock: ");
    private JTextField nameTXT1 = new JTextField();
    private JTextField priceTXT1 = new JTextField();
    private JTextField stockTXT1 = new JTextField();
    private JButton editBTN = new JButton("EDIT");
    private JButton selectBTN = new JButton("SELECT");
    private JButton deleteBTN = new JButton("DELETE");
    private Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
    public ProductView(){
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

        insertProductBTN.setBounds((frame.getWidth() - 300) / 2, 200, 300, 50);
        insertProductBTN.setBorder(border);
        mainPanel.add(insertProductBTN);

        editProductBTN.setBounds((frame.getWidth() - 300) / 2, 300, 300, 50);
        editProductBTN.setBorder(border);
        mainPanel.add(editProductBTN);

        deleteProductBTN.setBounds((frame.getWidth() - 300) / 2, 400, 300, 50);
        deleteProductBTN.setBorder(border);
        mainPanel.add(deleteProductBTN);

        showAllProductBTN.setBounds((frame.getWidth() - 300) / 2, 500, 300, 50);
        showAllProductBTN.setBorder(border);
        mainPanel.add(showAllProductBTN);

        mainPanel.setLayout(null);

        //INSERT PANEL
        insertPanel.setBackground(Color.LIGHT_GRAY);

        titleLBL2.setFont(new Font("Calibri", Font.BOLD, 30));
        titleLBL2.setBounds((frame.getWidth() - 300) / 2, 50, 300, 30);
        titleLBL2.setHorizontalAlignment(SwingConstants.CENTER);
        insertPanel.add(titleLBL2);

        nameLBL.setFont(new Font("Calibri", Font.BOLD, 20));
        nameLBL.setBounds(300, 150, 150, 30);
        nameLBL.setHorizontalAlignment(SwingConstants.CENTER);
        insertPanel.add(nameLBL);

        priceLBL.setFont(new Font("Calibri", Font.BOLD, 20));
        priceLBL.setBounds(300, 225, 100, 30);
        priceLBL.setHorizontalAlignment(SwingConstants.CENTER);
        insertPanel.add(priceLBL);

        stockLBL.setFont(new Font("Calibri", Font.BOLD, 20));
        stockLBL.setBounds(300, 300, 100, 30);
        stockLBL.setHorizontalAlignment(SwingConstants.CENTER);
        insertPanel.add(stockLBL);

        nameTXT.setBounds(500, 150, 300, 30);
        nameTXT.setBorder(border);
        insertPanel.add(nameTXT);

        priceTXT.setBounds(500, 225, 300, 30);
        priceTXT.setBorder(border);
        insertPanel.add(priceTXT);

        stockTXT.setBounds(500, 300, 300, 30);
        stockTXT.setBorder(border);
        insertPanel.add(stockTXT);

        insertBTN.setBounds((frame.getWidth() - 200) / 2, 400, 200, 40);
        insertBTN.setBorder(border);
        insertPanel.add(insertBTN);

        backBTN1.setBounds(1050, 700, 100, 40);
        backBTN1.setBorder(border);
        insertPanel.add(backBTN1);

        insertPanel.setLayout(null);

        //EDIT PANEL
        editPanel.setBackground(Color.LIGHT_GRAY);

        titleLBL3.setFont(new Font("Calibri", Font.BOLD, 30));
        titleLBL3.setBounds((frame.getWidth() - 300) / 2, 50, 300, 30);
        titleLBL3.setHorizontalAlignment(SwingConstants.CENTER);
        editPanel.add(titleLBL3);

        nameLBL1.setFont(new Font("Calibri", Font.BOLD, 20));
        nameLBL1.setBounds(100, 550, 150, 30);
        nameLBL1.setHorizontalAlignment(SwingConstants.CENTER);
        editPanel.add(nameLBL1);

        priceLBL1.setFont(new Font("Calibri", Font.BOLD, 20));
        priceLBL1.setBounds(100, 600, 100, 30);
        priceLBL1.setHorizontalAlignment(SwingConstants.CENTER);
        editPanel.add(priceLBL1);

        stockLBL1.setFont(new Font("Calibri", Font.BOLD, 20));
        stockLBL1.setBounds(600, 550, 100, 30);
        stockLBL1.setHorizontalAlignment(SwingConstants.CENTER);
        editPanel.add(stockLBL1);


        nameTXT1.setBounds(250, 550, 300, 30);
        nameTXT1.setBorder(border);
        editPanel.add(nameTXT1);

        priceTXT1.setBounds(250, 600, 300, 30);
        priceTXT1.setBorder(border);
        editPanel.add(priceTXT1);

        stockTXT1.setBounds(700, 550, 300, 30);
        stockTXT1.setBorder(border);
        editPanel.add(stockTXT1);

        selectBTN.setBounds(425, 650, 150, 40);
        selectBTN.setBorder(border);
        editPanel.add(selectBTN);

        editBTN.setBounds(625, 650, 150, 40);
        editBTN.setBorder(border);
        editPanel.add(editBTN);

        backBTN2.setBounds(1050, 700, 100, 40);
        backBTN2.setBorder(border);
        editPanel.add(backBTN2);

        editPanel.setLayout(null);

        //DELETE PANEL
        deletePanel.setBackground(Color.LIGHT_GRAY);

        titleLBL4.setFont(new Font("Calibri", Font.BOLD, 30));
        titleLBL4.setBounds((frame.getWidth() - 300) / 2, 50, 300, 30);
        titleLBL4.setHorizontalAlignment(SwingConstants.CENTER);
        deletePanel.add(titleLBL4);

        deleteBTN.setBounds((frame.getWidth() - 200) / 2, 650, 200, 40);
        deleteBTN.setBorder(border);
        deletePanel.add(deleteBTN);

        backBTN3.setBounds(1050, 700, 100, 40);
        backBTN3.setBorder(border);
        deletePanel.add(backBTN3);

        deletePanel.setLayout(null);

        //SHOW ALL PANEL
        showAllPanel.setBackground(Color.LIGHT_GRAY);

        titleLBL5.setFont(new Font("Calibri", Font.BOLD, 30));
        titleLBL5.setBounds((frame.getWidth() - 300) / 2, 50, 300, 30);
        titleLBL5.setHorizontalAlignment(SwingConstants.CENTER);
        showAllPanel.add(titleLBL5);

        backBTN4.setBounds(1050, 700, 100, 40);
        backBTN4.setBorder(border);
        showAllPanel.add(backBTN4);

        showAllPanel.setLayout(null);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }

    public String getNameTXT() {
        return nameTXT.getText();
    }
    public String getPriceTXT() {
        return priceTXT.getText();
    }
    public String getStockTXT() {
        return stockTXT.getText();
    }
    public String getNameTXT1() {
        return nameTXT1.getText();
    }
    public String getPriceTXT1() {
        return priceTXT1.getText();
    }
    public String getStockTXT1() {
        return stockTXT1.getText();
    }
    public void setNameTXT1(String text){
        nameTXT1.setText(text);
    }
    public void setPriceTXT1(String text){
        priceTXT1.setText(text);
    }
    public void setStockTXT1(String text){
        stockTXT1.setText(text);
    }

    public void createTable(DefaultTableModel defaultTableModel){
        table = new JTable(defaultTableModel);
        table.setRowHeight(50);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setFont(new Font("Calibri", 0, 15));
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 20));
    }
    public void changeScrollPanel(int i){

        if(i == 1){
            sp.setViewportView(table);
            sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            sp.setBorder(border);
            sp.setBounds((frame.getWidth() - 1100) / 2, 130, 1100, 400);
            editPanel.add(sp);
        } else if(i == 2){
            sp.setViewportView(table);
            sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            sp.setBorder(border);
            sp.setBounds((frame.getWidth() - 1100) / 2, 130, 1100, 500);
            deletePanel.add(sp);
        } else if(i == 3){
            sp.setViewportView(table);
            sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            sp.setBorder(border);
            sp.setBounds((frame.getWidth() - 1100) / 2, 130, 1100, 550);
            showAllPanel.add(sp);
        }
    }
    public Integer returnID(){
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            return -1;
        }
        return Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
    }
    public void insertProductListener(ActionListener actionListener) {
        insertProductBTN.addActionListener(actionListener);
    }
    public void editProductListener(ActionListener actionListener) {
        editProductBTN.addActionListener(actionListener);
    }
    public void deleteProductListener(ActionListener actionListener) {
        deleteProductBTN.addActionListener(actionListener);
    }
    public void showAllProductListener(ActionListener actionListener) {
        showAllProductBTN.addActionListener(actionListener);
    }
    public void insertListener(ActionListener actionListener) {
        insertBTN.addActionListener(actionListener);
    }
    public void editListener(ActionListener actionListener) {
        editBTN.addActionListener(actionListener);
    }
    public void selectListener(ActionListener actionListener) {
        selectBTN.addActionListener(actionListener);
    }
    public void deleteListener(ActionListener actionListener) {
        deleteBTN.addActionListener(actionListener);
    }
    public void backListener(ActionListener actionListener) {
        backBTN1.addActionListener(actionListener);
        backBTN2.addActionListener(actionListener);
        backBTN3.addActionListener(actionListener);
        backBTN4.addActionListener(actionListener);
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
            frame.setContentPane(editPanel);
        }else if(i == 3){
            frame.setContentPane(deletePanel);
        }else if(i == 4){
            frame.setContentPane(showAllPanel);
        }
        frame.setVisible(true);
    }
}
