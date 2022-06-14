package VIEW;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Aba_Options extends JFrame {

	private JPanel Aba_Options;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aba_Options frame = new Aba_Options();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Aba_Options() {
		Image img_Espaco = new ImageIcon(Aba_Options.class.getResource("imgs/Espaço.jpg")).getImage().getScaledInstance(1200,710,Image.SCALE_SMOOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 0, 1100, 740);
		Aba_Options = new JPanel();
		Aba_Options.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Aba_Options);
		Aba_Options.setLayout(null);
		
		JPanel panelSobre = new JPanel();
		panelSobre.setBackground(new Color(0, 0, 0, 0));
		panelSobre.setBounds(10, 10, 380, 133);
		Aba_Options.add(panelSobre);
		panelSobre.setLayout(null);
		
		JLabel lblPerg = new JLabel("?.");
		lblPerg.setForeground(Color.WHITE);
		lblPerg.setFont(new Font("OCR A Extended", Font.PLAIN, 90));
		lblPerg.setBounds(0, 0, 119, 133);
		panelSobre.add(lblPerg);
		
		JLabel lblTxT1 = new JLabel("SOBRE!");
		lblTxT1.setFont(new Font("OCR A Extended", Font.PLAIN, 61));
		lblTxT1.setForeground(Color.WHITE);
		lblTxT1.setBounds(116, 20, 234, 113);
		panelSobre.add(lblTxT1);
		
		JPanel panelJogar = new JPanel();
		panelJogar.setBackground(new Color(0, 0, 0, 0));
		panelJogar.setBounds(545, 10, 531, 133);
		Aba_Options.add(panelJogar);
		panelJogar.setLayout(null);
		
		JLabel lblPerg_2 = new JLabel("?.");
		lblPerg_2.setForeground(Color.WHITE);
		lblPerg_2.setBackground(new Color(0, 0, 0, 0));
		lblPerg_2.setFont(new Font("OCR A Extended", Font.PLAIN, 90));
		lblPerg_2.setBounds(0, 0, 119, 133);
		panelJogar.add(lblPerg_2);
		
		JLabel lblTxt2 = new JLabel("COMO JOGAR!");
		lblTxt2.setForeground(Color.WHITE);
		lblTxt2.setBackground(new Color(0, 0, 0, 0));
		lblTxt2.setFont(new Font("OCR A Extended", Font.PLAIN, 58));
		lblTxt2.setBounds(129, 21, 392, 113);
		panelJogar.add(lblTxt2);
		
		JPanel panelCredito = new JPanel();
		panelCredito.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JOptionPane.showMessageDialog(Aba_Options,
				    "Paulo Eduardo Palauro. RA: 22.01324-5 \n " +
					"Isabella Madureira Sanches. RA: 22.00108-5 \n" +
				    "Pedro Guilherme Luxelane Tolone. RA: 19.02530-0 \n" +
					"Eduardo Takase Sawada RA: 22.00865-9  \n" +
				    "Guilherme Toffanelli Ghenaim RA: 22.00504-8 \n"
				   ,"A plain message",
				    JOptionPane.PLAIN_MESSAGE);
			}
		});
		panelCredito.setBackground(new Color(0, 0, 0, 0));
		panelCredito.setBounds(10, 671, 158, 32);
		Aba_Options.add(panelCredito);
		panelCredito.setLayout(null);
		
		JLabel lblAst = new JLabel("  *");
		lblAst.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		lblAst.setBackground(Color.BLACK);
		lblAst.setForeground(Color.BLUE);
		lblAst.setBounds(0, 0, 45, 32);
		panelCredito.add(lblAst);
		
		JLabel lblCredito = new JLabel("CREDITOS");
		lblCredito.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		lblCredito.setBackground(new Color(0, 0, 0 ,0));
		lblCredito.setForeground(Color.BLUE);
		lblCredito.setBounds(47, 0, 124, 32);
		panelCredito.add(lblCredito);
		
		
		JLabel lblNewLabel = new JLabel("<html>O jogo consiste em acertar perguntas sobre a Linguagem de Programa\u00E7\u00E3o Python!\r\n<br/>\r\n<br/> \r\nQue consiste em varios niveis de dificuldade, comen\u00E7ando das perguntas mais faceis e indo para as mais complicadas!\r\n<br/>\r\n<br/>\r\nPara isso voc\u00EA jogador, ir\u00E1 controlar uma nave e vai atirar na alternativa que achar correta.\r\n\r\n\r\n<br/>\r\n<br/>\r\nCaso acerte a alternativa correta, ir\u00E1 avan\u00E7ar de fase, se errar perdera 1 vida. \r\n<br/>\r\n<br/>\r\nSe perder todas suas vidas o jogo dar\u00E1 GAME OVER!\r\n\r\n</html>", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 0, 0, 0));
		lblNewLabel.setBounds(20, 153, 477, 440);
		Aba_Options.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>\r\nControles do Jogo:\r\n\r\n<br/>\r\n<br/>\r\n<br/>\r\n\r\nSeta Esquerda: Movimenta para Esquerda\r\n\r\n<br/>\r\n<br/>\r\n<br/>\r\n\r\nSeta Direita: Movimenta para Direita\r\n\r\n<br/>\r\n<br/>\r\n<br/>\r\n\r\nBarra de Espa\u00E7o: Atira um projetil\r\n\r\n<br/>\r\n<br/>\r\n<br/>\r\n\r\n\r\n</html>\r\n");
		lblNewLabel_1.setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(545, 153, 531, 440);
		Aba_Options.add(lblNewLabel_1);
		
		JLabel lblEspaco = new JLabel("");
		lblEspaco.setBounds(0, -13, 1096, 734);
		lblEspaco.setIcon(new ImageIcon(img_Espaco));
		Aba_Options.add(lblEspaco);
		
	
	}
}
