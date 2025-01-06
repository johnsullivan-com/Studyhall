package jcs_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Driver {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList<Color> pallette = Scheme.getCoffeePallette();
					ApplicationWindow window = new ApplicationWindow(pallette);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}