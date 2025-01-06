package jcs_project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GradeCalculatorPanel extends JPanel {
    private JTable gradesTable;
    private DefaultTableModel model;
    private double finalGrade = -1;

    public GradeCalculatorPanel(ArrayList<Color> pallette) {
        setBounds(20, 535, 421, 221);
        setBackground(pallette.get(4));
        setLayout(null);

        JLabel lblCalculatorLabel = new JLabel("Subject Final Grade Calculator");
        lblCalculatorLabel.setForeground(pallette.get(12));
        lblCalculatorLabel.setFont(new Font("Sylfaen", Font.BOLD, 17));
        lblCalculatorLabel.setBounds(10, 6, 270, 30);
        add(lblCalculatorLabel);

        JScrollPane gradesScroll = new JScrollPane();
        gradesScroll.setBounds(20, 33, 381, 146);
        add(gradesScroll);

        gradesTable = new JTable();
        gradesScroll.setViewportView(gradesTable);
        int height = 168;
        gradesTable.setPreferredSize(new Dimension(15, height));

        String[] col = {"Category name", "% of total", "Current points", "Total points"};
        model = new DefaultTableModel(null, col) {
            	@Override
                public boolean isCellEditable(int row, int column) {
                   return false;
                }
        };
        gradesTable.setModel(model);

        JButton btnHelp = new JButton("?");
        btnHelp.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(btnHelp, "Use the buttons to the right to add/remove rows."
        				+ "\n     >  When removing a row, make sure you are not editing text.        "
        				+ "\n     >  If you are ready to get your final grade, press calculate!      ");
        	}
        });
        btnHelp.setBounds(10, 189, 45, 23);
        add(btnHelp);

        JButton btnCalculate = new JButton("Calculate!");
        btnCalculate.setBounds(307, 189, 94, 23);
        btnCalculate.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		double grade = 0; double sum = 0; double totalWeight = 0; double totalGrade = 0;
        		int i = 0;
        		while (i < model.getRowCount()) {
        			grade = ((double)model.getValueAt(i, 2)) / ((double)model.getValueAt(i, 3));
        			sum += grade * ((double)model.getValueAt(i, 1) / 100);
        			totalWeight += ((double)model.getValueAt(i, 1) / 100);
        		i++;
        		}
        		totalGrade = (sum / totalWeight) * 100;
        		finalGrade = Double.parseDouble(String.format("%.3f", totalGrade));
        		btnCalculate.setText(finalGrade + "%");
        	}
        });
        
        add(btnCalculate);

        JButton btnAdd = new JButton("Add row");
        btnAdd.setBounds(214, 189, 88, 23);
        btnAdd.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		try {
                    String tempName = JOptionPane.showInputDialog("Enter category name: ");
                    double percentOfTotal = Double.parseDouble(JOptionPane.showInputDialog("Enter percent of total (decimals are allowed): "));
                    double  currentPoints = Double.parseDouble(JOptionPane.showInputDialog("Enter current points earned in this category with an integer: "));
                    double totalPoints = Double.parseDouble(JOptionPane.showInputDialog("Enter total possible points in this category with an integer: "));
                    model.addRow(new Object[]{tempName, percentOfTotal, currentPoints, totalPoints});
                    gradesTable.setPreferredSize(new Dimension(15, height + (model.getRowCount() * 8)));
        		} catch (Exception Ue) {
        			System.out.print("Unexpected error in creating row generation.");
        		}
        	}
        });
        add(btnAdd);

        JButton btnRemove = new JButton("Remove row");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = gradesTable.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                }
            }
        });
        btnRemove.setBounds(95, 189, 113, 23);
        add(btnRemove);
    }
}