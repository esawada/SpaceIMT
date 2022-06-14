/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

import DAO.ConquistaDAO;
import DTO.ExibirConquistaDTO;
import POJO.Globals;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class frmConquista extends javax.swing.JFrame {
    /**
     * Creates new form frmConquista
     */
    public frmConquista() {
        Globals globals = Globals.getInstance(1);
        ConquistaDAO dao = new ConquistaDAO();
        ArrayList<ExibirConquistaDTO> lista = dao.ListarConquistaUsuario(1);

        initComponents();
        lbConquistas.setText(String.format(lbConquistas.getText(), globals.getNickname()));
        popularTabelaConquista(lista);
    }

    private void popularTabelaConquista(ArrayList<ExibirConquistaDTO> lista) {
        DefaultTableModel model = (DefaultTableModel) conquistaTable.getModel();
        model.setNumRows(0);
        
        for (int x = 0; x < lista.size(); x++) {
            ExibirConquistaDTO conquista = lista.get(x);
            model.addRow(new Object[]{conquista.getTitulo(), conquista.getDescricao()});
            // System.out.println(conquista.getTitulo() + conquista.getDescricao());
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbConquistas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        conquistaTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbConquistas.setFont(new java.awt.Font("Impact", 2, 36)); // NOI18N
        lbConquistas.setForeground(new java.awt.Color(255, 0, 0));
        lbConquistas.setText("%s - CONQUISTAS DESBLOQUEADAS");
        getContentPane().add(lbConquistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 500, 50));

        conquistaTable.setBackground(new java.awt.Color(0, 0, 0));
        conquistaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Titulo", "Descrição"
            }
        ));
        jScrollPane1.setViewportView(conquistaTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 490, 180));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VIEW/perfil.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmConquista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConquista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConquista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConquista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConquista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable conquistaTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbConquistas;
    // End of variables declaration//GEN-END:variables

}
