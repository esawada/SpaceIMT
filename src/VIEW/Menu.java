package VIEW;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import jogo.MainJogo;

import java.awt.Font;

public class Menu extends JFrame {

	private JPanel contentPane;

	private Image img_Python = new ImageIcon(Menu.class.getResource("imgs/Python.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
	private Image img_Start = new ImageIcon(Menu.class.getResource("imgs/Start.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	private Image img_Profile = new ImageIcon(Menu.class.getResource("imgs/Profile.png")).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	private Image img_Option = new ImageIcon(Menu.class.getResource("imgs/Settings.png")).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	private Image img_Exit = new ImageIcon(Menu.class.getResource("imgs/Exit.png")).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	private Image img_Comeco = new ImageIcon(Menu.class.getResource("imgs/Nave Space.jpg")).getImage().getScaledInstance(1000,750,Image.SCALE_SMOOTH);
	private Image img_Conq = new ImageIcon(Menu.class.getResource("imgs/Conquista.png")).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Menu() {
		setResizable(false);
		setBackground(Color.BLACK);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 1100, 750);
		setUndecorated(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.DARK_GRAY);
		panelMenu.setBounds(0, 0, 268, 713);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblNave = new JLabel("");
		lblNave.setHorizontalAlignment(SwingConstants.CENTER);
		lblNave.setBounds(0, 47, 266, 162);
		lblNave.setIcon(new ImageIcon(img_Python));
		panelMenu.add(lblNave);
		
		
		
		JPanel panelStart = new JPanel();
		panelStart.addMouseListener(new PanelButtonMouseAdapter(panelStart) {
			@Override
			public void mouseClicked (MouseEvent e) {
				//menuClicked(panelComeco);
			}
		});		
		
		panelStart.setBackground(Color.DARK_GRAY);
		panelStart.setBounds(0, 239, 276, 75);
		panelMenu.add(panelStart);
		panelStart.setLayout(null);
		panelStart.addMouseListener(new PanelButtonMouseAdapter(panelStart) {
			@Override
			public void mouseClicked(MouseEvent e) {
					MainJogo main = new MainJogo();
					Menu.this.dispose();
				}
			//}
		});
		
		
			
		
		JLabel lblStart = new JLabel("START");
		lblStart.setForeground(new Color(255, 255, 255));
		lblStart.setFont(new Font("OCR A Extended", Font.PLAIN, 40));
		lblStart.setHorizontalAlignment(SwingConstants.CENTER);
		lblStart.setBounds(74, 26, 120, 28);
		panelStart.add(lblStart);
		
		JLabel lblStartIMG = new JLabel("");
		lblStartIMG.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartIMG.setBounds(10, 10, 54, 55);
		lblStartIMG.setIcon(new ImageIcon(img_Start));
		panelStart.add(lblStartIMG);
		
		JPanel panelProfile = new JPanel();
		panelProfile.addMouseListener(new PanelButtonMouseAdapter(panelProfile) {
			@Override
			public void mouseClicked (MouseEvent e) {
				//if(JOptionPane.showConfirmDialog(null, "Voc� quer fechar o jogo?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {                                                                 
				frmConquista conquista = new frmConquista();
				conquista.setVisible(true);
				
			}
		});		
		panelProfile.setBackground(Color.DARK_GRAY);
		panelProfile.setBounds(0, 344, 286, 71);
		panelMenu.add(panelProfile);
		panelProfile.setLayout(null);
		
		
		JLabel lblProfile = new JLabel("PROFILE");
		lblProfile.setForeground(new Color(255, 255, 255));
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setFont(new Font("OCR A Extended", Font.PLAIN, 40));
		lblProfile.setBounds(54, 10, 212, 43);
		panelProfile.add(lblProfile);
		
		
		JLabel lblProfileIMG = new JLabel("");
		lblProfileIMG.setBounds(10, 10, 54, 55);
		lblProfileIMG.setIcon(new ImageIcon(img_Profile));
		panelProfile.add(lblProfileIMG);
		
		
		JPanel panelOptions = new JPanel();
		panelOptions.addMouseListener(new PanelButtonMouseAdapter(panelOptions) {
			@Override
			public void mouseClicked (MouseEvent e) {
				Aba_Options options = new Aba_Options();
				options.setVisible(true);
				
			}
		});		

		panelOptions.setBackground(Color.DARK_GRAY);
		panelOptions.setBounds(0, 442, 276, 71);
		panelMenu.add(panelOptions);
		panelOptions.setLayout(null);
		
		JLabel lblOption = new JLabel("OPTIONS");
		lblOption.setBackground(new Color(0, 139, 139));
		lblOption.setForeground(new Color(255, 255, 255));
		lblOption.setFont(new Font("OCR A Extended", Font.PLAIN, 40));
		lblOption.setBounds(67, 20, 199, 29);
		panelOptions.add(lblOption);
		
		JLabel lblOptionIMG = new JLabel("");
		lblOptionIMG.setHorizontalAlignment(SwingConstants.CENTER);
		lblOptionIMG.setBounds(11, 10, 54, 55);
		lblOptionIMG.setIcon(new ImageIcon(img_Option));
		panelOptions.add(lblOptionIMG);
		
		JPanel panelExit = new JPanel();
		panelExit.addMouseListener(new PanelButtonMouseAdapter(panelExit) {
			@Override
			public void mouseClicked (MouseEvent e) {
				//menuClicked(panelSair);
			}
		});		
		panelExit.setBackground(Color.DARK_GRAY);
		panelExit.setBounds(0, 640, 286, 81);
		panelMenu.add(panelExit);
		panelExit.setLayout(null);
		panelExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Deseja fechar o jogo?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {                                                                 
					Menu.this.dispose();
					
				}
			}
		});
		
		JLabel lblExit = new JLabel("EXIT");
		lblExit.setForeground(new Color(255, 255, 255));
		lblExit.setFont(new Font("OCR A Extended", Font.PLAIN, 40));
		lblExit.setBounds(80, 20, 111, 30);
		panelExit.add(lblExit);
		
		
		JLabel lblExitIMG = new JLabel("");
		lblExitIMG.setHorizontalAlignment(SwingConstants.CENTER);
		lblExitIMG.setBounds(10, 10, 54, 55);
		lblExitIMG.setIcon(new ImageIcon(img_Exit));
		panelExit.add(lblExitIMG);
		
		JPanel panelRanking = new JPanel();
		panelRanking.addMouseListener(new PanelButtonMouseAdapter(panelRanking) {
			@Override
			public void mouseClicked (MouseEvent e) {
				frmRanking ranking = new frmRanking();
				ranking.setVisible(true);
			}
		});		
		panelRanking.setBackground(Color.DARK_GRAY);
		panelRanking.setBounds(0, 543, 286, 71);
		panelMenu.add(panelRanking);
		panelRanking.setLayout(null);
		
		JLabel lblIMGConq = new JLabel("");
		lblIMGConq.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMGConq.setBounds(0, 0, 72, 71);
		lblIMGConq.setIcon(new ImageIcon(img_Conq));
		panelRanking.add(lblIMGConq);
		
		JLabel lblTXTConq = new JLabel("Ranking");
		lblTXTConq.setFont(new Font("OCR A Extended", Font.PLAIN, 40));
		lblTXTConq.setForeground(new Color(255, 255, 255));
		lblTXTConq.setBounds(72, 10, 192, 51);
		panelRanking.add(lblTXTConq);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(266, -6, 830, 719);
		lblNewLabel.setIcon(new ImageIcon(img_Comeco));
		contentPane.add(lblNewLabel);
	}
	
	public void menuClicked(JPanel panel) {
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(0, 128, 144));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(Color.DARK_GRAY);
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		
	}
}
