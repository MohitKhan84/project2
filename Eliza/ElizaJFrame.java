package Eliza;

import java.awt.Color;
import javax.swing.JFrame;

public class ElizaJFrame extends JFrame{
	
	public ElizaJFrame() {
		ElizaJPanel jp = new ElizaJPanel();
		jp.setBackground(Color.LIGHT_GRAY);
		add(jp);
		
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
		setTitle("Hello");
		setResizable(true);
		setVisible(true);
	}

}
