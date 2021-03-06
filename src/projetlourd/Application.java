package projetlourd;

import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * JFrame principale, une partie du code a été générée avec NetBeans
 *
 * @author Anthony
 */
public class Application extends javax.swing.JFrame {

    JFrame editor;
    JPanel centerPanel;
    private static Application _instance; //Application est un Singleton

    /**
     * @author Anthony
     */
    public Application() {
        initComponents();
        centerPanel = new MonProfil();
        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);
        pack();
        repaint();
    }

    /**
     * Le getInstance du singleton _instance
     *
     * @return l'instance d'Application
     * @throws IOException
     * @author Anthony
     */
    public final static Application getInstance() throws IOException {
        if (_instance == null) {
            synchronized (Application.class) {
                if (Application._instance == null) {
                    Application._instance = new Application();
                }
            }
        }
        return _instance;
    }

    /**
     * Code généré par le GUI creator de Netbeans
     *
     * @author Anthony
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        rechercheTextField = new javax.swing.JTextField();
        rechercheComboBox = new javax.swing.JComboBox();
        rechercheButton = new javax.swing.JButton();
        deconnexionButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        footer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Application");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setName("application"); // NOI18N
        setResizable(false);

        header.setMaximumSize(new java.awt.Dimension(500, 90));
        header.setMinimumSize(new java.awt.Dimension(500, 90));

        rechercheTextField.setToolTipText("Rechercher un document");

        rechercheComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Titre", "Auteur" }));

        rechercheButton.setText("Recherche");
        rechercheButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rechercheButtonMouseClicked(evt);
            }
        });

        deconnexionButton.setText("Déconnexion");
        deconnexionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deconnexionButtonMouseClicked(evt);
            }
        });

        jLabel2.setText("Bonjour " + Connexion.PSEUDO);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(deconnexionButton))
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(rechercheTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(rechercheButton))
                    .addComponent(rechercheComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deconnexionButton))
                .addGap(18, 18, 18)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rechercheTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rechercheButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rechercheComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(header, java.awt.BorderLayout.NORTH);

        footer.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setText("Adresse des membres du groupe");
        footer.add(jLabel1);

        getContentPane().add(footer, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Quand on clique sur le bouton de recherche on déclenche les actions de
     * recherche. On change aussi le centerPanel par un RecherchePanel
     *
     * @param evt
     * @author Anthony
     * @author Francis
     */
    private void rechercheButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rechercheButtonMouseClicked
        String toSearch = rechercheTextField.getText();
        String type = (String) rechercheComboBox.getSelectedItem();

        if (toSearch.length() != 0) {
            String recherches = Connexion.GESTIONBD.getRecherche(type, toSearch);

            String[] parties = recherches.split(",");
            String[] parties2;

            List<String[]> lRecherche = new ArrayList<>();

            //on exécute des traitements sur la chaîne retournée par la requête
            for (String party : parties) {
                //chaque ligne est un tableau de chaîne, on a donc une liste de String[]
                parties2 = party.split("-");
                lRecherche.add(parties2);
            }
            this.remove(centerPanel);
            centerPanel = new ResultatRecherche(lRecherche);
            getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);
            pack();
            repaint();
        }
    }//GEN-LAST:event_rechercheButtonMouseClicked

    /**
     * Un clic sur le bouton de déconnexion lancera les actions de déconnexion
     * (fermeture des connections, preparedStatement, etc.)
     *
     * @param evt
     * @author Anthony
     * @author Francis
     */
    private void deconnexionButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deconnexionButtonMouseClicked
        Connexion.GESTIONBD.Close();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

        Connexion connexion = new Connexion();
        connexion.setVisible(true);
    }//GEN-LAST:event_deconnexionButtonMouseClicked

    /**
     * JLabel2 correspond à l'affichage du nom de l'utilisateur.
     * Un clique sur celui-ci changera centerPanel en un MonProfilPanel
     * @param evt 
     * @author Anthony
     */
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.remove(centerPanel);
        centerPanel = new MonProfil();
        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);
        pack();
        repaint();
    }//GEN-LAST:event_jLabel2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deconnexionButton;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton rechercheButton;
    private javax.swing.JComboBox rechercheComboBox;
    private javax.swing.JTextField rechercheTextField;
    // End of variables declaration//GEN-END:variables
}
