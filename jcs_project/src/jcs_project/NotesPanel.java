package jcs_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class NotesPanel extends JPanel{
	private String fileName = "notesFile";
	public NotesPanel(ArrayList<Color> pallette) {
		setBounds(183, 748, 523, 241);  
    	setLayout(null);

    	JPanel notesBackdrop = new JPanel();
    	notesBackdrop.setBounds(0, 0, 523, 212);
    	notesBackdrop.setBackground(pallette.get(2));
    	notesBackdrop.setLayout(null);
    	add(notesBackdrop);
    	
    	JLabel lblNotes = new JLabel("Notetaking");
    	lblNotes.setForeground(pallette.get(12));
    	lblNotes.setFont(new Font("Sylfaen", Font.BOLD, 17));
    	lblNotes.setBounds(10, 11, 180, 32);
    	notesBackdrop.add(lblNotes);
    	
    	JScrollPane notesScrollPane = new JScrollPane();
    	notesScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    	notesScrollPane.setBounds(10, 39, 503, 162);
    	notesBackdrop.add(notesScrollPane);
    	
    	JTextArea textArea = new JTextArea();
    	notesScrollPane.setViewportView(textArea);
    	textArea.setLineWrap(true);
    	
    	JButton btnLoadNote = new JButton("Load Note");
    	btnLoadNote.setBounds(0, 218, 107, 23);
    	btnLoadNote.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try (Scanner sc = new Scanner(new File("notesFile"))) {
                    textArea.setText(""); // Clear existing text
                    while (sc.hasNextLine()) {
                        textArea.append(sc.nextLine() + "\n");
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
    		}
    	});
    	add(btnLoadNote);
    	
    	JButton btnSaveNote = new JButton("Save Note");
    	btnSaveNote.setBounds(117, 218, 107, 23);
    	btnSaveNote.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try (PrintWriter writer = new PrintWriter("notesFile")) {
                    writer.print(textArea.getText());
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
    		}
    	});
    	add(btnSaveNote);
	}
}