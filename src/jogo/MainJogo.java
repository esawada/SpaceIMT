package jogo;

import java.util.Timer;

import javax.swing.JFrame;

import POJO.Globals;



public class MainJogo {
	
	Timer timer;
	int second;
			
	public static void main (String[] args) {
		
		JFrame janela = new JFrame("Space IMT");
		janela.setSize(1366, 768);
		janela.setUndecorated(false);
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		SpaceIMT invasaoAlien = new SpaceIMT(Globals.getInstance(1).getIdUsuario(), 2, janela);
		invasaoAlien.setBounds(0, 0, 1366, 768);
		
		janela.add(invasaoAlien);
		
		janela.addKeyListener(invasaoAlien);
		
		janela.setVisible(true);
		
	}

	public MainJogo() {

		JFrame janela = new JFrame("Space IMT");
		janela.setSize(1366, 768);
		janela.setUndecorated(false);
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		
		
		SpaceIMT invasaoAlien = new SpaceIMT(Globals.getInstance(1).getIdUsuario(), 2, janela);
		invasaoAlien.setBounds(0, 0, 1366, 768);
		
		janela.add(invasaoAlien);
		
		janela.addKeyListener(invasaoAlien);
		
		janela.setVisible(true);

	}
}