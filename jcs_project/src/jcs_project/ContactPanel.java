package jcs_project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ContactPanel extends JPanel {
    private JTable contactTable;
    private DefaultTableModel model;
    private JLabel error;
    private JLabel contactLabel;

    public ContactPanel(ArrayList<Color> pallette) {
        setBounds(524, 302, 182, 259);
        setBackground(pallette.get(2));
        setLayout(null);
        
        contactLabel = new JLabel("Contacts");
        contactLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        contactLabel.setForeground(pallette.get(12));
        contactLabel.setBounds(5, 5, 100, 20);
        add(contactLabel);

        JScrollPane contactScroll = new JScrollPane();
        contactScroll.setBounds(10, 30, 160, 180);
        add(contactScroll);

        contactTable = new JTable();
        contactScroll.setViewportView(contactTable);
        int height = 168;
        contactTable.setPreferredSize(new Dimension(15, height));

        String[] col = {"Name", "Phone", "Email"};
        model = new DefaultTableModel(null, col);
        contactTable.setModel(model);
        
        error = new JLabel("Maximum rows reached!");
        error.setFont(new Font("Tahoma", Font.BOLD, 10));
        error.setForeground(pallette.get(12));
        error.setBounds(80, 5, 100, 20);
        add(error);
        error.setVisible(false);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getRowCount() <= 20) {
                    String tempName = JOptionPane.showInputDialog(null, "Enter name: ", "Creating contact...", 3);
                    String tempPhone = JOptionPane.showInputDialog(null, "Enter number: ", "Creating contact...", 3);
                    String tempEmail = JOptionPane.showInputDialog(null, "Enter email: ", "Creating contact...", 3);
                    
                    model.addRow(new Object[]{tempName, tempPhone, tempEmail});
                    contactTable.setPreferredSize(new Dimension(15, height + (model.getRowCount() * 8)));

                    if (model.getRowCount() == 20) {
                        error.setVisible(true);
                    }
                }
            }
        });
        btnAdd.setBounds(10, 220, 64, 30);
        add(btnAdd);

        JButton btnRemove = new JButton("Delete");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = contactTable.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                }
                
                
                // Serialize here
            }
        });
        btnRemove.setBounds(80, 220, 84, 30);
        add(btnRemove);
    }
}
