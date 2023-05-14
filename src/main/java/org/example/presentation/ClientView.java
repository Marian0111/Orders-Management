package org.example.presentation;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
public class ClientView {
    private JLabel titleLBL1 = new JLabel("Client Page");
    private JLabel titleLBL2 = new JLabel("Add Client");
    private JLabel titleLBL3 = new JLabel("Edit Client");
    private JLabel titleLBL4 = new JLabel("Delete Client");
    private JLabel titleLBL5 = new JLabel("Show all Clients");
    private JFrame frame = new JFrame("Client Page");
    private JPanel mainPanel = new JPanel();
    private JPanel insertPanel = new JPanel();
    private JPanel editPanel = new JPanel();
    private JPanel deletePanel = new JPanel();
    private JPanel showAllPanel = new JPanel();
    private JButton insertClientBTN = new JButton("INSERT NEW CLIENT");
    private JButton editClientBTN = new JButton("EDIT A CLIENT");
    private JButton deleteClientBTN = new JButton("DELETE CLIENT");
    private JButton showAllClientsBTN = new JButton("SHOW ALL CLIENTS");
    private JLabel firstNameLBL = new JLabel("First name: ");
    private JLabel lastNameLBL = new JLabel("Last name: ");
    private JLabel addressLBL = new JLabel("Address: ");
    private JLabel emailLBL = new JLabel("email: ");
    private JTextField firstNameTXT = new JTextField();
    private JTextField lastNameTXT = new JTextField();
    private JTextField addressTXT = new JTextField();
    private JTextField emailTXT = new JTextField();
    private JButton insertCBTN = new JButton("INSERT");
    private JButton backBTN1 = new JButton("BACK");
    private JButton backBTN2 = new JButton("BACK");
    private JButton backBTN3 = new JButton("BACK");
    private JButton backBTN4 = new JButton("BACK");
    private JTable table = new JTable();
    private JScrollPane sp = new JScrollPane(table);
    private JLabel firstNameLBL1 = new JLabel("First name: ");
    private JLabel lastNameLBL1 = new JLabel("Last name: ");
    private JLabel addressLBL1 = new JLabel("Address: ");
    private JLabel emailLBL1 = new JLabel("email: ");
    private JTextField firstNameTXT1 = new JTextField();
    private JTextField lastNameTXT1 = new JTextField();
    private JTextField addressTXT1 = new JTextField();
    private JTextField emailTXT1 = new JTextField();
    private JButton editBTN = new JButton("EDIT");
    private JButton selectBTN = new JButton("SELECT");
    private JButton deleteBTN = new JButton("DELETE");
    private Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
    public ClientView(){
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

        insertClientBTN.setBounds((frame.getWidth() - 300) / 2, 200, 300, 50);
        insertClientBTN.setBorder(border);
        mainPanel.add(insertClientBTN);

        editClientBTN.setBounds((frame.getWidth() - 300) / 2, 300, 300, 50);
        editClientBTN.setBorder(border);
        mainPanel.add(editClientBTN);

        deleteClientBTN.setBounds((frame.getWidth() - 300) / 2, 400, 300, 50);
        deleteClientBTN.setBorder(border);
        mainPanel.add(deleteClientBTN);

        showAllClientsBTN.setBounds((frame.getWidth() - 300) / 2, 500, 300, 50);
        showAllClientsBTN.setBorder(border);
        mainPanel.add(showAllClientsBTN);

        mainPanel.setLayout(null);

        //INSERT PANEL
        insertPanel.setBackground(Color.LIGHT_GRAY);

        titleLBL2.setFont(new Font("Calibri", Font.BOLD, 30));
        titleLBL2.setBounds((frame.getWidth() - 300) / 2, 50, 300, 30);
        titleLBL2.setHorizontalAlignment(SwingConstants.CENTER);
        insertPanel.add(titleLBL2);

        firstNameLBL.setFont(new Font("Calibri", Font.BOLD, 20));
        firstNameLBL.setBounds(300, 150, 100, 30);
        firstNameLBL.setHorizontalAlignment(SwingConstants.CENTER);
        insertPanel.add(firstNameLBL);

        lastNameLBL.setFont(new Font("Calibri", Font.BOLD, 20));
        lastNameLBL.setBounds(300, 225, 100, 30);
        lastNameLBL.setHorizontalAlignment(SwingConstants.CENTER);
        insertPanel.add(lastNameLBL);

        addressLBL.setFont(new Font("Calibri", Font.BOLD, 20));
        addressLBL.setBounds(300, 300, 100, 30);
        addressLBL.setHorizontalAlignment(SwingConstants.CENTER);
        insertPanel.add(addressLBL);

        emailLBL.setFont(new Font("Calibri", Font.BOLD, 20));
        emailLBL.setBounds(300, 375, 100, 30);
        emailLBL.setHorizontalAlignment(SwingConstants.CENTER);
        insertPanel.add(emailLBL);

        firstNameTXT.setBounds(500, 150, 300, 30);
        firstNameTXT.setBorder(border);
        insertPanel.add(firstNameTXT);

        lastNameTXT.setBounds(500, 225, 300, 30);
        lastNameTXT.setBorder(border);
        insertPanel.add(lastNameTXT);

        addressTXT.setBounds(500, 300, 300, 30);
        addressTXT.setBorder(border);
        insertPanel.add(addressTXT);

        emailTXT.setBounds(500, 375, 300, 30);
        emailTXT.setBorder(border);
        insertPanel.add(emailTXT);

        insertCBTN.setBounds((frame.getWidth() - 200) / 2, 450, 200, 40);
        insertCBTN.setBorder(border);
        insertPanel.add(insertCBTN);

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

        firstNameLBL1.setFont(new Font("Calibri", Font.BOLD, 20));
        firstNameLBL1.setBounds(100, 550, 100, 30);
        firstNameLBL1.setHorizontalAlignment(SwingConstants.CENTER);
        editPanel.add(firstNameLBL1);

        lastNameLBL1.setFont(new Font("Calibri", Font.BOLD, 20));
        lastNameLBL1.setBounds(100, 600, 100, 30);
        lastNameLBL1.setHorizontalAlignment(SwingConstants.CENTER);
        editPanel.add(lastNameLBL1);

        addressLBL1.setFont(new Font("Calibri", Font.BOLD, 20));
        addressLBL1.setBounds(600, 550, 100, 30);
        addressLBL1.setHorizontalAlignment(SwingConstants.CENTER);
        editPanel.add(addressLBL1);

        emailLBL1.setFont(new Font("Calibri", Font.BOLD, 20));
        emailLBL1.setBounds(600, 600, 100, 30);
        emailLBL1.setHorizontalAlignment(SwingConstants.CENTER);
        editPanel.add(emailLBL1);

        firstNameTXT1.setBounds(200, 550, 300, 30);
        firstNameTXT1.setBorder(border);
        editPanel.add(firstNameTXT1);

        lastNameTXT1.setBounds(200, 600, 300, 30);
        lastNameTXT1.setBorder(border);
        editPanel.add(lastNameTXT1);

        addressTXT1.setBounds(700, 550, 300, 30);
        addressTXT1.setBorder(border);
        editPanel.add(addressTXT1);

        emailTXT1.setBounds(700, 600, 300, 30);
        emailTXT1.setBorder(border);
        editPanel.add(emailTXT1);

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

    public String getFirstNameTXT() {
        return firstNameTXT.getText();
    }
    public String getLastNameTXT() {
        return lastNameTXT.getText();
    }
    public String getAddressTXT() {
        return addressTXT.getText();
    }
    public String getEmailTXT() {
        return emailTXT.getText();
    }
    public String getFirstNameTXT1() {
        return firstNameTXT1.getText();
    }
    public String getLastNameTXT1() {
        return lastNameTXT1.getText();
    }
    public String getAddressTXT1() {
        return addressTXT1.getText();
    }
    public String getEmailTXT1() {
        return emailTXT1.getText();
    }
    public void setFirstNameTXT1(String text){
        firstNameTXT1.setText(text);
    }
    public void setLastNameTXT1(String text){
        lastNameTXT1.setText(text);
    }
    public void setAddressTXT1(String text){
        addressTXT1.setText(text);
    }
    public void setEmailTXT1(String text){
        emailTXT1.setText(text);
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
    public void insertClientListener(ActionListener actionListener) {
        insertClientBTN.addActionListener(actionListener);
    }
    public void editClientListener(ActionListener actionListener) {
        editClientBTN.addActionListener(actionListener);
    }
    public void deleteClientListener(ActionListener actionListener) {
        deleteClientBTN.addActionListener(actionListener);
    }
    public void showAllClientListener(ActionListener actionListener) {
        showAllClientsBTN.addActionListener(actionListener);
    }
    public void insertListener(ActionListener actionListener) {
        insertCBTN.addActionListener(actionListener);
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
