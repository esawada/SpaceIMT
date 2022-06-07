package VIEW;

import java.awt.BorderLayout;
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
import javax.swing.JSplitPane;

public class frmOptions extends JFrame {

    private JPanel Aba_Options;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmOptions frame = new frmOptions();
                frame.setVisible(true);
            }
        });
    }

    public frmOptions() {
        Image img_Espaco = new ImageIcon(frmMenu.class
                .getResource("../IMAGEM/Espaço.jpg")).getImage().getScaledInstance(1200, 710, Image.SCALE_SMOOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 0, 1100, 750);
        Aba_Options = new JPanel();
        Aba_Options.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(Aba_Options);
        Aba_Options.setLayout(null);

        JPanel panelSobre = new JPanel();
        panelSobre.setBackground(new Color(0, 0, 0, 0));
        panelSobre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(Aba_Options,
                        "Eggs are not supposed to be green.",
                        "A plain message",
                        JOptionPane.PLAIN_MESSAGE);

            }
        });
        panelSobre.setBounds(10, 10, 531, 133);
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
        panelJogar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(Aba_Options,
                        "Os controles do jogo são: \n \n "
                        + "Seta Direita:   Ir para direita \n"
                        + "Seta Esquerda: Ir para esquerda \n"
                        + "Barra de Espa�o: Atirar \n \n",
                        "Controles",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });
        panelJogar.setBackground(new Color(0, 0, 0, 0));
        panelJogar.setBounds(10, 281, 531, 133);
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
                        "Paulo Eduardo Palauro. RA: 22.01324-5 \n "
                        + "Isabella Madureira Sanches. RA: 22.00108-5 \n"
                        + "Pedro Guilherme Toloni Luxenani . RA:  \n"
                        + "Eduardo Takase Sawada RA: 22.00865-9  \n"
                        + "Guilherme RA: \n",
                         "A plain message",
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
        lblCredito.setBackground(new Color(0, 0, 0, 0));
        lblCredito.setForeground(Color.BLUE);
        lblCredito.setBounds(47, 0, 124, 32);
        panelCredito.add(lblCredito);

        JLabel lblEspaco = new JLabel("");
        lblEspaco.setBounds(0, -13, 1096, 737);
        lblEspaco.setIcon(new ImageIcon(img_Espaco));
        Aba_Options.add(lblEspaco);

    }
}
