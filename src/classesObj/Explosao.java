import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Explosao {
	
	private BufferedImage imagem;
	private int x, y;
	private int duração;
	private int animaçãoTotal;
	private int linha;
	private int coluna;
	
	public Explosao(BufferedImage imagem, int x, int y) {
		
		this.imagem = imagem;
		this.x = x;
		this.y = y;
		duração = 40;
		linha = 0;
		coluna = 0;
		animaçãoTotal = 140;
	}
	
	public void atualizar() {
		
		duração--;
		
		//linha = 6 - duração / 10;
		//System.out.println("linha");
		
	}
	
	public void pintar(Graphics2D g) {
		
		g.drawImage(imagem, x, y, x + 50, y + 50, 0, 198 * linha, 198, 198 * linha + 198, null);	
	}
	public boolean acabou() {
		if(duração <= 0)
			return true;
		
		return false;
		
	}
}
