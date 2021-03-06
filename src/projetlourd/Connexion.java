package projetlourd;

import java.awt.event.WindowEvent;
import java.io.IOException;

import static projetlourd.Connexion.PSEUDO;

/**
 * Fenêtre de connexion
 *
 * @author Anthony
 */
public class Connexion extends javax.swing.JFrame {

    public static String PSEUDO; //le Pseudo de l'utilisateur actuel
    public static GestionBD GESTIONBD; //Pour chaque utilisateur on a un GestionBD

    /**
     * Creates new form Connexion1
     *
     * @author Anthony
     */
    public Connexion() {
        initComponents();
    }

    /**
     * Code generé avec le GUI creator de NetBeans
     *
     * @author Anthony
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(10, 0));
        jLabel4 = new javax.swing.JLabel();
        connexionPseudonyme = new javax.swing.JTextField();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(10, 0));
        jPanel2 = new javax.swing.JPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(10, 0));
        jLabel5 = new javax.swing.JLabel();
        connexionPassword = new javax.swing.JPasswordField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(10, 0));
        jPanel4 = new javax.swing.JPanel();
        ConnexionButton = new javax.swing.JButton();
        inscriptionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Connexion");

        jPanel6.setLayout(new java.awt.GridLayout(6, 3));

        jLabel6.setFont(new java.awt.Font("DejaVu Sans Ultra-Light", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Connexion");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.add(jPanel5);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));
        jPanel6.add(jPanel1);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));
        jPanel3.add(filler4);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Pseudo");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel4);

        connexionPseudonyme.setText("Thierry9000");
        connexionPseudonyme.setName("connexionPseudonyme");
        jPanel3.add(connexionPseudonyme);
        jPanel3.add(filler3);

        jPanel6.add(jPanel3);

        jPanel2.setLayout(new java.awt.GridLayout(1, 1));
        jPanel2.add(filler2);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Password");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel5);

        connexionPassword.setText("Thierry9000");
        jPanel2.add(connexionPassword);
        jPanel2.add(filler1);

        jPanel6.add(jPanel2);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 5, 20));

        ConnexionButton.setText("se connecter");
        ConnexionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    ConnexionButtonMouseClicked(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        jPanel4.add(ConnexionButton);

        inscriptionButton.setText("s'inscrire");
        jPanel4.add(inscriptionButton);

        jPanel6.add(jPanel4);

        getContentPane().add(jPanel6, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Lorsqu'on clique sur le bouton de connexion on déclenche des actions pour
     * connecter l'utilisateur (création d'un GestionBD, vérification de
     * l'identité de l'utilisateur)
     *
     * @param evt
     * @throws IOException
     * @auhor Francis
     * @author Anthony
     */
    private void ConnexionButtonMouseClicked(java.awt.event.MouseEvent evt) throws IOException {//GEN-FIRST:event_ConnexionButtonMouseClicked
        String psd = connexionPseudonyme.getText();
        String pwd = connexionPassword.getText();

        GESTIONBD = new GestionBD();

        boolean connexion = GESTIONBD.Connexion(psd, pwd);

        if (connexion) {
            PSEUDO = psd;

            Application.getInstance().setVisible(true);
            setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE); //on cache la fenêtre de connexion
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)); //on affiche la fenêtre principale
        } else {
            System.out.println("Erreur");
        }
    }//GEN-LAST:event_ConnexionButtonMouseClicked

    /**
     * Main qui lance le programme entier
     * @author Anthony
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
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Connexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConnexionButton;
    private javax.swing.JPasswordField connexionPassword;
    private javax.swing.JTextField connexionPseudonyme;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JButton inscriptionButton;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
