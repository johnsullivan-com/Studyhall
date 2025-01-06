package jcs_project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ToDo extends JPanel{

    private JTable toDoList;
    private DefaultTableModel model;
    private JLabel error;
    
    
    public ToDo(ArrayList<Color> pallette) {
    	setBounds(20, 323, 475, 212);
        setLayout(null);
        
        JLabel lblToDoLabel = new JLabel("To-Do List");
        lblToDoLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblToDoLabel.setBounds(0, 0, 121, 21);
        add(lblToDoLabel);
        
        JScrollPane toDoScrollPane = new JScrollPane();
        toDoScrollPane.setBounds(10, 24, 376, 178);
        add(toDoScrollPane);
        
        toDoList = new JTable();
        toDoScrollPane.setViewportView(toDoList);
        int height = 178;
        toDoList.setPreferredSize(new Dimension(370, height));
        
        String[] col1 = {"Name & Desc"};
        model = new DefaultTableModel(null, col1);
        toDoList.setModel(model);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(396, 24, 69, 177);
        buttonPanel.setBackground(pallette.get(2));
        add(buttonPanel);
        buttonPanel.setLayout(null);
        
        JButton btnAdd = new JButton("+");
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnAdd.setBounds(10, 11, 49, 37);
        buttonPanel.add(btnAdd);
        
        error = new JLabel("Maximum rows reached!");
        error.setFont(new Font("Tahoma", Font.BOLD, 10));
        error.setForeground(Color.WHITE);
        error.setBounds(80, 5, 100, 20);
        add(error);
        error.setVisible(false);
        
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toDoList.getRowCount() <= 20) {
                    String tempName = JOptionPane.showInputDialog("Enter name: ");
                    model.addRow(new Object[]{tempName});
                    toDoList.setPreferredSize(new Dimension(15, height + (model.getRowCount() * 8)));

                    if (model.getRowCount() == 20) {
                        error.setVisible(true);
                    }
                }
            }
        });
        
        JButton btnRemove = new JButton("-");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = toDoList.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                }
            }
        });
        btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 28));
        btnRemove.setBounds(10, 53, 49, 37);
        buttonPanel.add(btnRemove);
        
        JButton btnFavorite = new JButton("");
        btnFavorite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	model.moveRow(toDoList.getSelectedRow(), toDoList.getSelectedRow(), 0);

            }
        });
        btnFavorite.setIcon(new ImageIcon(ApplicationWindow.class.getResource("/images/favorite.png")));
        btnFavorite.setBounds(10, 129, 49, 37);
        buttonPanel.add(btnFavorite);
    }
}