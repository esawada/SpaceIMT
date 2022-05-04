import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Nave {
	
	private BufferedImage desenho;
	
	private int x;
	private int velocidade;
	private boolean podeAtirar;
	private int recarregando;
	
	
	public Nave() {
		
		try {
			desenho = ImageIO.read(new File("Imagem/Nave.png"));
		} catch (IOException e) {
			System.out.println("Não foi possivel carregar a imagem");
			e.printStackTrace();
		}
		
		
		x = 640;
		velocidade = 5;
		podeAtirar = true;
		recarregando = 0;
		
	}
	
	public void pintar(Graphics2D g) {
				  //imagem  posX posY     tamX       tamY    //toda a imagem
		g.drawImage(desenho, x, 600, x + 100, 600 + 100, 0, 0, desenho.getWidth(), desenho.getHeight(), null);
	}
	
	public Tiro atirar() {
		podeAtirar = false;
		recarregando = 0;
		Tiro novoTiro = new Tiro(x + 48, 600);
		return novoTiro;
	}
	
	
	public void movimento(int valor) {
		if(valor == 1) {
			x += velocidade;
		}else if (valor == -1 ) {
			x -= velocidade;
		}
		if(recarregando >= 20) {
			podeAtirar = true;
			recarregando = 0;
		}
		recarregando ++;
	}
	public boolean podeAtirar() {
		return podeAtirar;
	}
}
