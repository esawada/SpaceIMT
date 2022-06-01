package classesObj;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Inimigo{
	
	private BufferedImage desenho;
	
	private int x;
	private int y;
	private int velocidade;
	private int direcao;
	private String alternativa;
	
	
	public Inimigo(BufferedImage imagem, int inicioX, int inicioY, int direcao, String alternativa){
		
		this.desenho = imagem;
		this.x = inicioX;
		this.y = inicioY;
		this.direcao = direcao;
		this.velocidade = 4;
		this.alternativa = alternativa;
	}

	public void setVelocidade(int velocidade){
		this.velocidade = velocidade;
	}
	
	public void atualizar() {
		
		x += velocidade * direcao;
		
	}
	
	
	
	public void trocaDirecao() {
		 direcao = direcao * -1;
		 y +=40;
	}

	public String getAlterernativa() {
		return alternativa;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	
	public void pintar(Graphics2D g) {
		
		g.drawImage(desenho, x, y, x + 50, y + 50, 0, 0, desenho.getWidth(), desenho.getHeight(), null );
		
	}

	public int getTam() {
		
		return 50;
	}

}