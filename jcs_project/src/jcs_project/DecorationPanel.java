package jcs_project;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DecorationPanel extends JPanel {
	public DecorationPanel(ArrayList<Color> pallette) {
        setBounds(0, 767, 151, 210);
        setLayout(null);
        
        JPanel creditsPanel = new JPanel();
        creditsPanel.setBounds(-10, 11, 147, 156);
        creditsPanel.setBackground(pallette.get(4));
        creditsPanel.setLayout(null);
        add(creditsPanel);
        
        JLabel lblReleaseV = new JLabel("Release v1.0");
        lblReleaseV.setBounds(20, 38, 115, 20);
        lblReleaseV.setForeground(pallette.get(12));
        lblReleaseV.setFont(new Font("Sylfaen", Font.PLAIN, 14));
        creditsPanel.add(lblReleaseV);
        
        JLabel lblByJohnSullivan = new JLabel("by John Sullivan");
        lblByJohnSullivan.setBounds(15, 71, 162, 20);
        lblByJohnSullivan.setForeground(pallette.get(12));
        lblByJohnSullivan.setFont(new Font("Sylfaen", Font.BOLD, 16));
        creditsPanel.add(lblByJohnSullivan);
        
        JLabel lblAndMariusGollwitzer = new JLabel("and Marius");
        lblAndMariusGollwitzer.setBounds(15, 91, 162, 20);
        lblAndMariusGollwitzer.setForeground(pallette.get(12));
        lblAndMariusGollwitzer.setFont(new Font("Sylfaen", Font.BOLD, 16));
        creditsPanel.add(lblAndMariusGollwitzer);
        
        JLabel lblGollwitzer = new JLabel("Gollwitzer");
        lblGollwitzer.setForeground(Color.WHITE);
        lblGollwitzer.setFont(new Font("Sylfaen", Font.BOLD, 16));
        lblGollwitzer.setBounds(15, 111, 162, 20);
        creditsPanel.add(lblGollwitzer);
        
        JLabel lblStudyhall = new JLabel("Studyhall");
        lblStudyhall.setForeground(Color.WHITE);
        lblStudyhall.setFont(new Font("Sylfaen", Font.PLAIN, 20));
        lblStudyhall.setBounds(15, 11, 100, 34);
        creditsPanel.add(lblStudyhall);
        
        JLabel lblGollwitzer_1 = new JLabel("______________");
        lblGollwitzer_1.setForeground(Color.WHITE);
        lblGollwitzer_1.setFont(new Font("Sylfaen", Font.BOLD, 16));
        lblGollwitzer_1.setBounds(15, 45, 125, 20);
        creditsPanel.add(lblGollwitzer_1);
        
        JLabel lblGollwitzer_1_1 = new JLabel("______________");
        lblGollwitzer_1_1.setForeground(Color.WHITE);
        lblGollwitzer_1_1.setFont(new Font("Sylfaen", Font.BOLD, 16));
        lblGollwitzer_1_1.setBounds(15, 125, 125, 20);
        creditsPanel.add(lblGollwitzer_1_1);
	}
}
