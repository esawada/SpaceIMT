package VIEW;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Aba_Profile extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aba_Profile frame = new Aba_Profile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Aba_Profile() {
		
		Image img_Fundo_Profile = new ImageIcon(Aba_Profile.class.getResource("imgs/Fundo_Menu.jpg")).getImage().getScaledInstance(1400,1400,Image.SCALE_SMOOTH);
		Image img_Conquista = new ImageIcon(Aba_Profile.class.getResource("imgs/Conquista.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
		Image img_User = new ImageIcon(Aba_Profile.class.getResource("imgs/Nave.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
		Image img_Atencao = new ImageIcon(Aba_Profile.class.getResource("imgs/Atencao.png")).getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 0, 1200, 714);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelUser = new JPanel();
		panelUser.setBounds(10, 17, 370, 115);
		panelUser.setBackground(new Color(0, 0, 0 ,0));
		contentPane.add(panelUser);
		panelUser.setLayout(null);
		
		JLabel lblProfileIMG = new JLabel("\r\n");
		lblProfileIMG.setBackground(new Color(0, 0, 0 ,0));
		lblProfileIMG.setBounds(0, 0, 103, 115);
		lblProfileIMG.setIcon(new ImageIcon(img_User));
		panelUser.add(lblProfileIMG);
		
		JLabel lblProfileTxT = new JLabel("HELLO, USER\r\n");
		lblProfileTxT.setBackground(new Color(0, 0, 0 ,0));
		lblProfileTxT.setForeground(Color.WHITE);
		lblProfileTxT.setFont(new Font("OCR A Extended", Font.PLAIN, 33));
		lblProfileTxT.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfileTxT.setBounds(113, 0, 257, 115);
		panelUser.add(lblProfileTxT);
		
		JPanel panelConq0 = new JPanel();
		panelConq0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Aba_conquista conquista = new Aba_conquista();
				// conquista.setVisible(true);
				
				//Aba_Options options = new Aba_Options();
				//options.setVisible(true);
			}
		});
		panelConq0.setBounds(538, 10, 606, 122);
		panelConq0.setBackground(new Color(0, 0, 0 ,0));
		contentPane.add(panelConq0);
		panelConq0.setLayout(null);
		
		JLabel lblConq0 = new JLabel("");
		lblConq0.setHorizontalAlignment(SwingConstants.CENTER);
		lblConq0.setIcon(new ImageIcon(img_Atencao));
		lblConq0.setBounds(10, 0, 118, 122);
		lblConq0.setBackground(new Color(0, 0, 0 ,0));
		panelConq0.add(lblConq0);
		
		JLabel lblNewLabel_4 = new JLabel("CONQUISTAS: ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("OCR A Extended", Font.PLAIN, 50));
		lblNewLabel_4.setBounds(108, 10, 488, 112);
		lblNewLabel_4.setBackground(new Color(0, 0, 0 ,0));
		panelConq0.add(lblNewLabel_4);
		
		JLabel lblFundo_Perfil = new JLabel("");
		lblFundo_Perfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblFundo_Perfil.setBounds(0, 0, 1200, 682);
		lblFundo_Perfil.setIcon(new ImageIcon(img_Fundo_Profile));
		
		contentPane.add(lblFundo_Perfil);
		
		
	}
}