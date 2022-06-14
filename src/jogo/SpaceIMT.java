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
import javax.swing.JFrame;
import javax.swing.JPanel;

import DAO.ConquistaDAO;
import DAO.QuestaoDAO;
import DAO.UsuarioDAO;
import DTO.ChecarConquistaDTO;
import DTO.ExibirConquistaDTO;
import POJO.Globals;
import VIEW.ADM;
import VIEW.Menu;
import classesObj.Nave;
import classesObj.Questao;
import classesObj.Tiro;
import classesObj.Inimigo;
import classesObj.Explosao;


public class SpaceIMT extends JPanel implements Runnable, KeyListener{
	
	private Font minhaFonte = new Font("Consolas", Font.BOLD, 20); 
	private Font fontePergunta = new Font("Arial", Font.BOLD, 35); 
	private Font fonteAlternativas = new Font("Consolas", Font.PLAIN, 25); 
	private Font fonteFase = new Font("Arial", Font.PLAIN, 50); 
	private Nave nave;
	private int direcao = 0;
	private ArrayList<Tiro> tiros;
	private ArrayList<Inimigo> inimigos;
	private ArrayList<Explosao> explosoes;
	private PlanoDeFundo fundo;
	private boolean ganhou;
	private boolean pausado;

	private float exibindoFase = 2;
	private float FechandoEm = 2; 
	private boolean perdeu;
	private BufferedImage ImagemExplosao;
	private List<String> listaDeAlternativas = new ArrayList<>();
	private Questao questao;
	private int numeroDeQuestoes;
	private int numeroDeQuestoesAtual = 1;
	private List<Integer> listaDificuldade = new ArrayList<>();
	private List<Integer> listaQuestoesJogadas = new ArrayList<>();
	private List<Integer> listaExibirConquistas = new ArrayList<>();
	private int vida;
	private int vidaAtual;
	private int fase;
	private int idUsuario;
	private boolean jogoAcabado = false;
	private boolean exibirFimDeJogo = false;
	private JFrame janela;
	private int streak = 0;
	private double tempo = 0;
	private int repeticoes = 0;
	private boolean tipoUsuario;

	
	public SpaceIMT(int idUsuario, int vida, JFrame janela) {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		this.janela = janela;
		this.idUsuario = idUsuario;
		fase = usuarioDAO.GetFaseByID(idUsuario);
		tipoUsuario = usuarioDAO.GetTipoById(idUsuario);
		nave = new Nave();
		tiros = new ArrayList<Tiro>();
		inimigos = new ArrayList<Inimigo>();
		explosoes = new ArrayList<Explosao>();
		fundo = new PlanoDeFundo();
		ganhou = false; 
		perdeu = false;
		pausado = false;
		questao = new Questao();
		this.vida = vida;
		vidaAtual = vida;
		for (int i = 0; i < 3; i++) listaDificuldade.add(0);
		for (int i = 0; i < fase; i++){
			if (listaDificuldade.size() > 3)
				if (listaDificuldade.get(listaDificuldade.size() - 1) == 2)
					listaDificuldade.add(0);
				else
					listaDificuldade.set(listaDificuldade.size() - 1, listaDificuldade.get(listaDificuldade.size() - 1) + 1);
			else if (listaDificuldade.get(0) == listaDificuldade.get(1) && listaDificuldade.get(0) == listaDificuldade.get(2))
				if (listaDificuldade.get(0) == 2)
					listaDificuldade.add(0);
				else
					listaDificuldade.set(0, listaDificuldade.get(0) + 1);
			else if (listaDificuldade.get(1) == listaDificuldade.get(2))
				listaDificuldade.set(1, listaDificuldade.get(1) + 1);
			else if (listaDificuldade.get(0) == listaDificuldade.get(1))
				listaDificuldade.set(2, listaDificuldade.get(2) + 1);
		}
		numeroDeQuestoes = listaDificuldade.size();
		CriaInimigos(listaDificuldade.get(0));
		Thread LacoDoJogo =  new Thread(this);
		LacoDoJogo.start();
		
	}

	public void CriaInimigos(int dificuldade){

		do{
			listaDeAlternativas = new ArrayList<>();
			questao = QuestaoDAO.getQuestaoAleatoriaByDificuldade(dificuldade);
			listaDeAlternativas = QuestaoDAO.getAltEmbaralhadas(questao);
		} while(listaQuestoesJogadas.contains(questao.getId()));
		listaQuestoesJogadas.add(questao.getId());

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
		}
		
		public void CriaInimigosMenu(){
			
			BufferedImage imagemMenu = null;
			BufferedImage imagemJogarDeNovo = null;
			BufferedImage imagemSair = null;
			
			try {
				imagemMenu = ImageIO.read(new File("imagem/Menu.png"));
				imagemJogarDeNovo = ImageIO.read(new File("imagem/JogarNovamente.png"));
				imagemSair = ImageIO.read(new File("imagem/Sair.png"));
			}catch(IOException e) {
				System.out.println("N�o carregou a imagem");
				e.printStackTrace();
			}
			inimigos.add(new Inimigo(imagemMenu, 333, 50 + 0/10 * 50 + 100, 1, listaDeAlternativas.get(1)));
			inimigos.add(new Inimigo(imagemJogarDeNovo, 666, 50 + 1/10 * 50 + 100, 1, listaDeAlternativas.get(2)));
			inimigos.add(new Inimigo(imagemSair, 999, 50 + 2/10 * 50 + 100, 1, listaDeAlternativas.get(3)));
			inimigos.get(0).setVelocidade(0);
			inimigos.get(1).setVelocidade(0);
			inimigos.get(2).setVelocidade(0);
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
		if(exibindoFase >= 0){
			return;
		}
		if(pausado) {
			nave.setPodeAtirar(false);
			return;
		}
		tempo += 0.016666;
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
					if (jogoAcabado){
						switch (j) {
							case 0: 
								if(tipoUsuario) {
									ADM adm = new ADM(); 
									adm.setVisible(true);
								} else {
									Menu objfrmMenu = new Menu();
									objfrmMenu.setVisible(true);
								}
								janela.dispose();
								break;
							case 1: 
								// System.out.println("JogarDeNovo");
								MainJogo mainjogo = new MainJogo();
								janela.dispose();
								
								break;
							case 2: 
								// System.out.println("Sair");
								System.exit(0);
								break;
						}
					}
						
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

		exibindoFase -= 0.016666f;
		if(exibindoFase >= 0) {
			g.setColor(Color.white);
			g.setFont(fonteFase);
			g.drawString(String.format("FASE %d", fase), 600, 400);
		} else if(exibindoFase <= 0 && exibindoFase >= 0.05f) {
			
		}
			
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
		if(!jogoAcabado) {
			g.setColor(Color.white);
			g.setFont(fontePergunta);
			g.drawString(listaDeAlternativas.get(0), 10 + 0%20 * 200,40 + 0/10 * 50);
			g.setFont(fonteAlternativas);
			g.drawString("A : " + listaDeAlternativas.get(1), 10 + 0%20 * 200, 0/10 * 50 + 75);
			g.drawString("B : " + listaDeAlternativas.get(2), 10 + 0%20 * 200, 0/10 * 50 + 105);
			g.drawString("C : " + listaDeAlternativas.get(3), 10 + 3%20 * 200, 0/10 * 50 + 75);
			g.drawString("D : " + listaDeAlternativas.get(4), 10 + 3%20 * 200, 0/10 * 50 + 105);
			g.drawString(String.format("Questão: %d/%d", numeroDeQuestoesAtual, numeroDeQuestoes), 1150, 700);
			g.drawString(String.format("Vida: %d/%d", vidaAtual, vida), 1150, 670);
			g.drawString(String.format("Streak: %d", streak), 5, 670);
			g.drawString(String.format("Tempo: %f", tempo), 5, 700);
		}	
			ConquistaDAO conquistaDAO = new ConquistaDAO();
			ExibirConquistaDTO exibirconquistaDTO = new ExibirConquistaDTO();
			if(listaExibirConquistas.size() > 0){
				Boolean query = true;
				if(query) {
					query = false;
					exibirconquistaDTO = conquistaDAO.getConquistaById(listaExibirConquistas.get(0));
				}
				repeticoes++;
				g.setColor(Color.white);
				g.setFont(fontePergunta);
				g.drawString(String.format("%s", exibirconquistaDTO.getTitulo()), 600, 660);
				g.setFont(fonteAlternativas);
				g.drawString(String.format("%s", exibirconquistaDTO.getDescricao()), 500, 700);
				if(repeticoes >= 120) {
					repeticoes = 0;
					listaExibirConquistas.remove(0);
				}
			}
		if(ganhou) {
			if(!pausado && !jogoAcabado){
				streak++;
				listaExibirConquistas.addAll(checarConquista(idUsuario, streak, false));
			}
			if(numeroDeQuestoesAtual <= numeroDeQuestoes - 1) {
				numeroDeQuestoesAtual++;
				ganhou = false;
				tiros.removeAll(tiros);
				inimigos.removeAll(inimigos);
				CriaInimigos(listaDificuldade.get(numeroDeQuestoesAtual - 1));
			} else {
				pausado = true;
				if(!jogoAcabado){
					g.setColor(Color.white);
					g.setFont(minhaFonte);
					g.drawString("Você Ganhou!!", 600, 400);
				}
				
				FechandoEm -= 0.016666f;
				if(FechandoEm <= 0) {
					pausado = false;
					if(!jogoAcabado) {
						listaExibirConquistas.addAll(checarConquista(idUsuario, tempo, true));
						tiros.removeAll(tiros);
						inimigos.removeAll(inimigos);	
						CriaInimigosMenu();
						exibirFimDeJogo = true;
						jogoAcabado = true;
						UsuarioDAO.IncrementarFase(idUsuario);
					} else if(exibirFimDeJogo) {
						g.setColor(Color.white);
						g.setFont(fonteAlternativas);
						g.drawString("Menu", 320, 250);
						g.drawString("Jogar Novamente", 600, 250);
						g.drawString("Sair", 995, 250);
					}
				}
			}	
		}
		if (perdeu) {
			if(vidaAtual != 0) vidaAtual--;
			if(vidaAtual == 0) {
				pausado = true;
				if(!jogoAcabado) {
					g.setColor(Color.red);
					g.setFont(minhaFonte);
					g.drawString("Você Perdeu :( !!", 600, 400);
				}
				
				FechandoEm -= 0.016666f;
				if(FechandoEm <= 0) {
					pausado = false;
					if(!jogoAcabado) {
						tiros.removeAll(tiros);
						inimigos.removeAll(inimigos);	
						CriaInimigosMenu();
						jogoAcabado = true;
						exibirFimDeJogo = true;
					} else if(exibirFimDeJogo) {
						g.setColor(Color.white);
						g.setFont(fonteAlternativas);
						g.drawString("Menu", 330, 250);
						g.drawString("Jogar Novamente", 600, 250);
						g.drawString("Sair", 995, 250);
					}
				}
			} else if(numeroDeQuestoes == numeroDeQuestoesAtual) {
				ganhou = true;
				perdeu = false;

			} else {
				numeroDeQuestoesAtual++;
				streak = 0;
				perdeu = false;
				tiros.removeAll(tiros);
				inimigos.removeAll(inimigos);
				CriaInimigos(listaDificuldade.get(numeroDeQuestoesAtual - 1));
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

	private List<Integer> checarConquista(int idUsuario, double dadoConquista, Boolean tipoConquista) {
		ConquistaDAO conquistaDAO = new ConquistaDAO();
		List<ChecarConquistaDTO> listaConquista = new ArrayList<>();
		List<Integer> listaIds = new ArrayList<>();
		listaConquista = conquistaDAO.ListarConquistaUsuarioNaoLiberadas(idUsuario, tipoConquista);
		for (ChecarConquistaDTO conquista : listaConquista) {
			if(tipoConquista && dadoConquista <= conquista.getDadoConquista()){
				conquistaDAO.LiberarConquista(idUsuario, conquista.getIdConquista());
				listaIds.add(conquista.getIdConquista());
			}
			else if(!tipoConquista && dadoConquista >= conquista.getDadoConquista()){
				conquistaDAO.LiberarConquista(idUsuario, conquista.getIdConquista());
				listaIds.add(conquista.getIdConquista());
			}
		}
		return listaIds;
	}
		
		
}
		
