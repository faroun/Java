package ver11;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class myTime extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	private JLabel timeLabel;
	LocalDateTime now;
	DateTimeFormatter customFormatter;
	String formattedDate;
	
    public myTime() 
    {
    	now = LocalDateTime.now();
    	customFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss a");
    	formattedDate = now.format(customFormatter);
        timeLabel = new JLabel(formattedDate);
        Font f1 = new Font("Name",Font.BOLD,60);
        timeLabel.setFont(f1);
        add(timeLabel);

        Timer timer = new Timer(1000, this); 
        
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        timeLabel.setText(LocalDateTime.now().format(customFormatter));
    }
    
    private static void createAndShowGUI() 
    {
        JFrame frame = new JFrame("My Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new myTime());
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
    }
    
    public static void main(String[] args) 
    {
        EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                createAndShowGUI();
            }
        });
    }
}