package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import classesObj.Nave;
import classesObj.Questao;
import classesObj.Tiro;
import classesObj.Inimigo;
import classesObj.Explosao;


public class SpaceInvaders extends JPanel implements Runnable, KeyListener{
	
	private Font minhaFonte = new Font("Consolas", Font.BOLD, 20); 
	private Nave nave;
	private int direcao = 0;
	private ArrayList<Tiro> tiros;
	private ArrayList<Inimigo> inimigos;
	private ArrayList<Explosao> explosoes;
	private PlanoDeFundo fundo;
	private boolean ganhou;
	private boolean selecionado;
	private float FechandoEm = 10; 
	private boolean perdeu;
	private BufferedImage ImagemExplosao;
	private List<String> listaDeAlternativas;
	private Questao questao;
	
	public SpaceInvaders() {
		nave = new Nave();
		tiros = new ArrayList<Tiro>();
		inimigos = new ArrayList<Inimigo>();
		explosoes = new ArrayList<Explosao>();
		fundo = new PlanoDeFundo();
		ganhou = false; 
		perdeu = false;
		selecionado = false;
		questao = new Questao();
		listaDeAlternativas = new ArrayList<>();
		questao = Questao.getQuestaoAleatoriaByDificuldade(0);
		listaDeAlternativas = Questao.getAltEmbaralhadas(questao);
		
		
		BufferedImage imagemInimigoA = null;
		BufferedImage imagemInimigoB = null;
		BufferedImage imagemInimigoC = null;
		BufferedImage imagemInimigoD = null;
		
		try {
			imagemInimigoA = ImageIO.read(new File("imagem/A.png"));
			imagemInimigoB = ImageIO.read(new File("imagem/B.png"));
			imagemInimigoC = ImageIO.read(new File("imagem/C.png"));
			imagemInimigoD = ImageIO.read(new File("imagem/D.png"));
			ImagemExplosao = ImageIO.read(new File("imagem/Explosao.png"));
		}catch(IOException e) {
			System.out.println("N�o carregou a imagem");
			e.printStackTrace();
		}

			inimigos.add(new Inimigo(imagemInimigoA, 10 + 0%20 * 300, 50 + 0/10 * 50 + 100, 1, listaDeAlternativas.get(1)));
			inimigos.add(new Inimigo(imagemInimigoB, 10 + 1%20 * 300, 50 + 1/10 * 50 + 100, 1, listaDeAlternativas.get(2)));
			inimigos.add(new Inimigo(imagemInimigoC, 10 + 2%20 * 300, 50 + 2/10 * 50 + 100, 1, listaDeAlternativas.get(3)));
			inimigos.add(new Inimigo(imagemInimigoD, 10 + 3%20 * 300, 50 + 3/10 * 50 + 100, 1, listaDeAlternativas.get(4)));
		
		Thread LacoDoJogo =  new Thread(this);
		LacoDoJogo.start();
		
	}
	
	
	@Override
	public void run() {
		while (true) {
			
			long tempoInicial = System.currentTimeMillis();
			update();
			repaint();
			
			long tempoFinal = System.currentTimeMillis();
			
			long diferenca = 16 - (tempoFinal - tempoInicial);
			
			if(diferenca >0)
			  dorme(diferenca);
			
		}
	}
	
	private void update() {
		
		// if (inimigos.size() == 0) {
		// 	ganhou = true;
		// }
		nave.movimento(direcao);
		
		for (int i = 0; i < inimigos.size(); i++) {
			inimigos.get(i).atualizar();
			
			if(inimigos.get(i).getY() >= 710 )
				perdeu = true;
		}
		
		for ( int i = 0; i < tiros.size(); i++) {
			tiros.get(i).atualiza();

			
			if(tiros.get(i).destroy()) {
				tiros.remove(i);
				i--;
			}
			else {
				for (int j = 0; j < inimigos.size(); j++) {
					if (tiros.get(i).colideCom(inimigos.get(j))) {
					
						
					explosoes.add(new Explosao(ImagemExplosao,inimigos.get(j).getX(), inimigos.get(j).getY()));
					
					if(inimigos.get(j).getAlterernativa().equals(questao.getAltCorreta()))
						ganhou = true;
					else
						perdeu = true;
					inimigos.remove(j);
					j--; 
					
					tiros.remove(i);
					break;
				}
				
			  }
			}	
			
			
		}
		
		for (int i = 0; i < inimigos.size(); i++) {
			if (inimigos.get(i).getX()<= 0 || inimigos.get(i).getX() >= 1366 - 50){
				for (int j = 0; j < inimigos.size(); j++) {
					inimigos.get(j).trocaDirecao();	
				}
				break;
			}
		}
		
		for (int i = 0; i < explosoes.size(); i++) {
			explosoes.get(i).atualizar();
			
			if (explosoes.get(i).acabou()) {
				explosoes.remove(i);
			}
		}
		
	}
	
	int x = 0;
	public void paintComponent(Graphics g2) {
		super.paintComponent(g2);
		
		
		Graphics2D g = (Graphics2D) g2.create();
		g.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(
				RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		fundo.pinta(g);
		
		for (int i = 0; i < explosoes.size(); i++){
			explosoes.get(i).pintar(g);
		}
		
		//desenha Inimigo
		for (int i = 0; i <inimigos.size(); i++) {
		inimigos.get(i).pintar(g);
		}
		
		
		//desenha nave
		nave.pintar(g);
		
		
		//desenha tiros
		for ( int i = 0; i < tiros.size(); i++) {
			tiros.get(i).pintar(g);
		}

		//desenha alternativas
		g.setColor(Color.white);
		g.setFont(minhaFonte);
		g.drawString(listaDeAlternativas.get(0), 10 + 0%20 * 200,30 + 0/10 * 50);
		g.drawString("A : " + listaDeAlternativas.get(1), 10 + 0%20 * 200, 0/10 * 50 + 60);
		g.drawString("B : " + listaDeAlternativas.get(2), 10 + 0%20 * 200, 0/10 * 50 + 90);
		g.drawString("C : " + listaDeAlternativas.get(3), 10 + 3%20 * 200, 0/10 * 50 + 60);
		g.drawString("D : " + listaDeAlternativas.get(4), 10 + 3%20 * 200, 0/10 * 50 + 90);
			
		if(ganhou) {
			g.setColor(Color.white);
			g.setFont(minhaFonte);
			g.drawString("Você Ganhou!! Fechando em " + FechandoEm + " segundos.", 450, 400);
			
			FechandoEm -= 0.016666f;
			if(FechandoEm <= 0) {
				System.exit(0);
				
			}
			
		}
		if (perdeu) {
			g.setColor(Color.red);
			g.setFont(minhaFonte);
			g.drawString("Você Perdeu :( !! Fechando em " + FechandoEm + " segundos.", 450, 400);
			
			FechandoEm -= 0.016666f;
			if(FechandoEm <= 0) {
				System.exit(0);
			}
		}
		
	}
	
	private void dorme(long duracao) {
		try {
			Thread.sleep(duracao);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			direcao = 1;
		}
		if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			direcao = -1;
		}
		if(e.getKeyCode()== KeyEvent.VK_SPACE && nave.podeAtirar()) {
			tiros.add(nave.atirar());
		}
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			direcao = 0;
		}
		if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			direcao = 0;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		}
		
		
	}
		
