package jcs_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class PomodoroTimer extends JPanel{
	JPanel pomodoroPanel;
	private Timer t;
    private int durationMins = 22;
    private int durationHours;
    private int counter;
    private boolean isRunning;
    private String tempTime;
    
    public PomodoroTimer(ArrayList<Color> pallette) {
    	setBounds(467, 572, 239, 165);
    	setBackground(pallette.get(2));
        setLayout(null);
        
        JLabel lblPomodoroTimer = new JLabel("Pomodoro Technique Timer");
        lblPomodoroTimer.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblPomodoroTimer.setForeground(pallette.get(12));
        lblPomodoroTimer.setBounds(10, 11, 219, 14);
        add(lblPomodoroTimer);
        
        JLabel lblTimer = new JLabel("00:00:00");
        lblTimer.setBackground(new Color(255, 255, 255));
        lblTimer.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblTimer.setForeground(pallette.get(12));
        lblTimer.setBounds(10, 36, 219, 73);
        add(lblTimer);
        
        JButton Start = new JButton("Start session");
        Start.setHorizontalAlignment(SwingConstants.LEADING);
        Start.setIcon(new ImageIcon(ApplicationWindow.class.getResource("/images/playicon.png")));
        Start.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		t = new Timer(1000, new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				counter++;
        				LocalTime time = LocalTime.of(durationHours, durationMins, 0).minusSeconds(counter);
                        lblTimer.setText(time.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                        isRunning = true;
                        if (time == LocalTime.of(0, 0, 0)) {
                        	t.stop();
                        }
        			}
        	});
        		t.start();
        		Start.setVisible(false);
        	}

        });
        Start.setBounds(10, 120, 159, 33);
        add(Start);
        
        JButton Pause = new JButton("Pause session");
        Start.setHorizontalAlignment(SwingConstants.LEADING);
        Pause.setIcon(new ImageIcon(ApplicationWindow.class.getResource("/images/pause.png")));
        Pause.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		t.stop();
        		isRunning = false;
        		Start.setVisible(true);
        	}
        });
        Pause.setBounds(10, 120, 159, 33);
        add(Pause);
        
        JButton Restart = new JButton("");
        Restart.setIcon(new ImageIcon(ApplicationWindow.class.getResource("/images/replay.png")));
        Restart.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (isRunning) {
        			t.stop(); 
        		}
        		
        		try {
        		tempTime = JOptionPane.showInputDialog(null, "Enter timer duration in minutes: ", "Pomodoro Technique", 1);
        		if (Double.parseDouble(tempTime) > 0) counter = 0;
        		durationMins = (int)Math.floor(Integer.parseInt(tempTime) % 60);
        		durationHours = (int)Math.floor(Integer.parseInt(tempTime) / 60);
        		} catch (DateTimeException DTe) {
        			DTe.printStackTrace();
        		} catch (Exception re) {
        			System.out.println("Evaded Runtime Exception: Cancelled JOptionPane Prompt \"Enter Duration in minutes\"");
        		} finally {}
        		
        		Start.setVisible(true);
        	}
        });
        Restart.setBounds(188, 120, 41, 33);
        add(Restart);
    }
}