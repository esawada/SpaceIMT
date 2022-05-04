import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;



public class MainJogo {
			
	public static void main (String[] args) {
		JFrame janela = new JFrame("Space Invanders");
		janela.setSize(1366, 768);
		janela.setUndecorated(false);
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		SpaceInvaders invasãoAlien = new SpaceInvaders();
		invasãoAlien.setBounds(0, 0, 1366, 768);
		
		janela.add(invasãoAlien);
		
		janela.addKeyListener(invasãoAlien);
		
		janela.setVisible(true);
		
		
	}

}
