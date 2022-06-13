package classesObj;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class Explosao {
	
	private BufferedImage imagem;
	private int x, y;
	private int duracao;
	private int linha;
	
	public Explosao(BufferedImage imagem, int x, int y) {
		
		this.imagem = imagem;
		this.x = x;
		this.y = y;
		duracao = 70;
		linha = 0;
	}
	
	public void atualizar() {
		
		duracao--;
		
		linha = 6 - duracao / 10;
		// System.out.println("linha");
		
	}
	
	public void pintar(Graphics2D g) {
		
		g.drawImage(imagem, x, y, x + 50, y + 50, 0, 198 * linha, 198, 198 * linha + 198, null);	
	}
	public boolean acabou() {
		if(duracao <= 0)
			return true;
		
		return false;
		
	}
}
