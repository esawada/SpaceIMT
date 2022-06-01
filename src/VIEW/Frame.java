
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Frame extends JFrame {

	private JPanel contentPane;

	private Image img_Python = new ImageIcon(Frame.class.getResource("imgs/Python.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
	private Image img_Start = new ImageIcon(Frame.class.getResource("imgs/Start.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	private Image img_Profile = new ImageIcon(Frame.class.getResource("imgs/Profile.png")).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	private Image img_Option = new ImageIcon(Frame.class.getResource("imgs/Settings.png")).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	private Image img_Exit = new ImageIcon(Frame.class.getResource("imgs/Exit.png")).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	private Image img_Comeco = new ImageIcon(Frame.class.getResource("imgs/Nave Space.jpg")).getImage().getScaledInstance(1000,750,Image.SCALE_SMOOTH);
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Frame() {
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
		lblNave.setBounds(10, 47, 266, 162);
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
		panelStart.setBounds(0, 319, 276, 75);
		panelMenu.add(panelStart);
		panelStart.setLayout(null);
		panelStart.addMouseListener(new PanelButtonMouseAdapter(panelStart) {
			@Override
			public void mouseClicked(MouseEvent e) {
					//Space spaceinvaders = new Space
					//space.setVisible(true);
					//Frame.this.dispose();
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
				//if(JOptionPane.showConfirmDialog(null, "Você quer fechar o jogo?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {                                                                 
				Aba_Profile perfil = new Aba_Profile();
				perfil.setVisible(true);
				
			}
		});		
		panelProfile.setBackground(Color.DARK_GRAY);
		panelProfile.setBounds(0, 428, 286, 71);
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
		panelOptions.setBounds(0, 536, 276, 71);
		panelMenu.add(panelOptions);
		panelOptions.setLayout(null);
		
		JLabel lblOption = new JLabel("OPTIONS");
		lblOption.setBackground(new Color(0, 139, 139));
		lblOption.setForeground(new Color(255, 255, 255));
		lblOption.setFont(new Font("OCR A Extended", Font.PLAIN, 40));
		lblOption.setBounds(75, 20, 191, 29);
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
				if(JOptionPane.showConfirmDialog(null, "Você quer fechar o jogo?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {                                                                 
					Frame.this.dispose();
					
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
			panel.setBackground(new Color(47, 79, 79));
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
