package jcs_project;

import javax.swing.*;
import java.text.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ApplicationWindow {
    private JFrame studyhall;
    private JTable gradesTable;
    private DefaultTableModel model;
    private JPanel headerPanel;
    protected ArrayList<Color> pallette;
    private JLabel lblImage;
    
    public ApplicationWindow(ArrayList<Color> pallette) {
        initialize(pallette);
    }

    private void initialize(ArrayList<Color> pallette) {
        studyhall = new JFrame();
        studyhall.setIconImage(Toolkit.getDefaultToolkit().getImage(ApplicationWindow.class.getResource("/images/studyhall_icon.png")));
        studyhall.setResizable(false);
        studyhall.setTitle("studyhall");
        studyhall.setBounds(400, 100, 750, 820); // 846 height final
        studyhall.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studyhall.getContentPane().setLayout(null);
        studyhall.setVisible(true);
        JPanel header = new JPanel();
	        header.setBounds(1, 1, 744, 762);
	        header.setPreferredSize(new Dimension(744, 1000));
	        header.setLayout(null);
	        studyhall.getContentPane().add(header);
        JScrollPane scrollPane = new JScrollPane(header, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	        scrollPane.setBounds(0, 0, 737, 760);
	        studyhall.getContentPane().add(scrollPane);

	        
        // Section 2: Menu Configuration and Scheme Changing
        JMenuBar menu = new JMenuBar();
        studyhall.setJMenuBar(menu);
        
        Component horizontalStrut = Box.createHorizontalStrut(655);
        menu.add(horizontalStrut);

        JMenu mnSettings = new JMenu("Menu");
        mnSettings.setIcon(new ImageIcon(ApplicationWindow.class.getResource("/images/cogicon.png")));
        menu.add(mnSettings);

        JMenuItem mntmOpenSettings = new JMenuItem("Settings");
        mntmOpenSettings.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			JFrame menu = new JFrame();
    			menu.setIconImage(Toolkit.getDefaultToolkit().getImage(ApplicationWindow.class.getResource("/images/cogicon.png")));
    			menu.setResizable(false);
    			menu.setTitle("settings");
    			menu.setBounds(125, 110, 400, 160); 
    			menu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    			menu.getContentPane().setLayout(null);
    			
    			JPanel menuPanel = new JPanel();
    			menuPanel.setBounds(0, 0, 400, 160);
    			menu.getContentPane().add(menuPanel);
    			menuPanel.setLayout(null);
    			
    			JLabel lblRelease = new JLabel("Release Date: 03 / 28 / 24");
    			lblRelease.setBounds(10, 100, 174, 14);
    			menuPanel.add(lblRelease);
    			lblRelease.setFont(new Font("Tahoma", Font.BOLD, 11));
    			
    			JLabel lblColorScheme = new JLabel("Color Scheme");
    			lblColorScheme.setFont(new Font("Tahoma", Font.BOLD, 11));
    			lblColorScheme.setBounds(10, 11, 115, 14);
    			menuPanel.add(lblColorScheme);
    			menu.setVisible(true);
    			
    			ButtonGroup colorGroup = new ButtonGroup();
    		        JRadioButton btnRose = new JRadioButton("Rose");
    		        btnRose.setBounds(10, 30, 80, 30);
    		        btnRose.addActionListener(new ActionListener() {
    		            @Override
    		            public void actionPerformed(ActionEvent e) {
    		            	ArrayList<Color> actionpallette = Scheme.getRosePallette();
    		                updateUI(actionpallette);
    		            }
    		        });
    		        menuPanel.add(btnRose);
    		        colorGroup.add(btnRose);
    		
    		        JRadioButton btnHazeBlue = new JRadioButton("Haze Blue");
    		        btnHazeBlue.setBounds(115, 30, 80, 30);
    		        btnHazeBlue.addActionListener(new ActionListener() {
    		            @Override
    		            public void actionPerformed(ActionEvent e) {
    		            	ArrayList<Color> actionpallette = Scheme.getHazeBluePallette();
    		                updateUI(actionpallette);
    		            }
    		        });
    		        menuPanel.add(btnHazeBlue);
    		        colorGroup.add(btnHazeBlue);
    		
    		        JRadioButton btnTropical = new JRadioButton("Tropical");
    		        btnTropical.setBounds(225, 30, 80, 30);
    		        btnTropical.addActionListener(new ActionListener() {
    		            @Override
    		            public void actionPerformed(ActionEvent e) {
    		                ArrayList<Color> actionpallette = Scheme.getTropicalPallette();
    		                updateUI(actionpallette);
    		            }
    		        });
    		        menuPanel.add(btnTropical);
    		        colorGroup.add(btnTropical);
    		        
    		        JRadioButton btnCoffee = new JRadioButton("Coffee");
    		        btnCoffee.setBounds(10, 55, 80, 30);
    		        btnCoffee.addActionListener(new ActionListener() {
    		            @Override
    		            public void actionPerformed(ActionEvent e) {
    		            	ArrayList<Color> actionpallette = Scheme.getCoffeePallette();
    		                updateUI(actionpallette);
    		            }
    		        });
    		        menuPanel.add(btnCoffee);
    		        colorGroup.add(btnCoffee);
    		        
    		        JRadioButton btnCoral = new JRadioButton("Coral");
    		        btnCoral.setBounds(115, 55, 80, 30);
    		        btnCoral.addActionListener(new ActionListener() {
    		            @Override
    		            public void actionPerformed(ActionEvent e) {
    		            	ArrayList<Color> actionpallette = Scheme.getCoralPallette();
    		                updateUI(actionpallette);
    		            }
    		        });
    		        menuPanel.add(btnCoral);
    		        colorGroup.add(btnCoral);
    		        
    		        JRadioButton btnCottage = new JRadioButton("Cottage Core");
    		        btnCottage.setBounds(225, 55, 102, 30);
    		        btnCottage.addActionListener(new ActionListener() {
    		            @Override
    		            public void actionPerformed(ActionEvent e) {
    		            	ArrayList<Color> actionpallette = Scheme.getCottagePallette();
    		                updateUI(actionpallette);
    		            }
    		        });
    		        menuPanel.add(btnCottage);
    		        colorGroup.add(btnCottage);

    		}
    	});
        mnSettings.add(mntmOpenSettings);

        
        // Section 3: Contact list panel
        ContactPanel contactPanel = new ContactPanel(pallette);
        	header.add(contactPanel);

        
        // Section 4: To-Do panel
        ToDo list = new ToDo(pallette);
        	header.add(list);
        
        
        // Section 5: Pomodoro timer panel
        PomodoroTimer pomodoroPanel = new PomodoroTimer(pallette);
        	header.add(pomodoroPanel);
        
        
        // Section 6: Grade calculator
        GradeCalculatorPanel grades = new GradeCalculatorPanel(pallette);
        	header.add(grades);
        	

        // Section 7: slight background additions
        JPanel decorationPanel = new JPanel();
	        decorationPanel.setBounds(500, 382, 257, 374);
	        decorationPanel.setBackground(pallette.get(4));
	        header.add(decorationPanel);
	    DecorationPanel dc = new DecorationPanel(pallette);
	    	header.add(dc);
        

        // Section 8: Note-taker
        NotesPanel notes = new NotesPanel(pallette);
        notes.setBounds(157, 748, 549, 241);
        	header.add(notes);
        
        
        // Section 9: Header panel
        headerPanel = new JPanel();
	        headerPanel.setBounds(10, 236, 701, 76);
	        headerPanel.setBackground(pallette.get(3));
	        header.add(headerPanel);
	        headerPanel.setLayout(null);
        JLabel lblTitle = new JLabel("welcome to studyhall.");
	        lblTitle.setBounds(10, 17, 339, 37);
	        lblTitle.setForeground(pallette.get(12));
	        lblTitle.setFont(new Font("Sylfaen", Font.BOLD, 28));
	        headerPanel.add(lblTitle);
        JTextArea motivationalQuotes = new JTextArea();
	        motivationalQuotes.setBounds(10, 45, 687, 31);
	        motivationalQuotes.setForeground(pallette.get(12));
	        motivationalQuotes.setFont(new Font("Sylfaen", Font.PLAIN, 14));
	        motivationalQuotes.setText(MotivationalQuotes.getQuote());
	        motivationalQuotes.setOpaque(false);
	        motivationalQuotes.setEditable(false);
	        headerPanel.add(motivationalQuotes);
        lblImage = new JLabel("");
	        lblImage.setVerticalAlignment(SwingConstants.TOP);
	        lblImage.setBounds(0, 0, 735, 245);
	        lblImage.setIcon(new ImageIcon(ApplicationWindow.class.getResource("/images/Twitter header aesthetic.jpeg")));
	        header.add(lblImage);
    }
    
    private void updateUI(ArrayList<Color> pallette) {
        this.pallette = pallette;
        studyhall.dispose();
        initialize(pallette);
        
    }
}