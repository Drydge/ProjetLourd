package projetlourd;

/**
 * JPanel pour le profil de l'utilisateur actuel
 *
 * @author Anthony
 */
public class MonProfil extends javax.swing.JPanel {

    AmisPanel amisPanel;
    TravailleSurPanel travailleSurPanel;
    DemandeAmiPanel demandeAmisPanel;

    /**
     * Après le initComponents() on ajoute des composants faits "main" pour les
     * amis, les documents travaillés et les demandes d'amis
     *
     * @author Francis
     * @author Anthony
     */
    public MonProfil() {
        initComponents();

        ObversableAmis oa = new ObversableAmis(Connexion.PSEUDO);

        amisPanel = new AmisPanel(oa);
        amisScrollPane.setViewportView(amisPanel);

        oa.addObserver(amisPanel);

        travailleSurPanel = new TravailleSurPanel(Connexion.PSEUDO);
        travailleSurScrollPane.setViewportView(travailleSurPanel);

        ObservableDemandeAmis oDA = new ObservableDemandeAmis(Connexion.PSEUDO);

        demandeAmisPanel = new DemandeAmiPanel(oDA);
        oDA.addObserver(demandeAmisPanel);
        demandeamisScrollPane.setViewportView(demandeAmisPanel);
    }

    /**
     * Code généré par le GUI creator de Netbeans
     *
     * @author Anthony
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jPanel5 = new javax.swing.JPanel();
        AmisSelected = new javax.swing.JTabbedPane();
        amisScrollPane = new javax.swing.JScrollPane();
        demandeamisScrollPane = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        demandeAmisTextField = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        demandeAmisButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        creerDocumentTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        ecritureComboBox = new javax.swing.JComboBox();
        lectureComboBox = new javax.swing.JComboBox();
        creerDocumentButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        travailleSurScrollPane = new javax.swing.JScrollPane();

        setMinimumSize(new java.awt.Dimension(500, 200));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(500, 200));
        setLayout(new java.awt.BorderLayout(15, 20));
        add(filler3, java.awt.BorderLayout.LINE_END);
        add(filler4, java.awt.BorderLayout.WEST);

        jPanel5.setLayout(new java.awt.BorderLayout());

        AmisSelected.setMinimumSize(new java.awt.Dimension(143, 100));
        AmisSelected.setName(""); // NOI18N
        AmisSelected.setPreferredSize(new java.awt.Dimension(143, 100));

        amisScrollPane.setMaximumSize(new java.awt.Dimension(25, 25));
        amisScrollPane.setName(""); // NOI18N
        AmisSelected.addTab("Mes amis", amisScrollPane);
        AmisSelected.addTab("demande d'amis", demandeamisScrollPane);

        jPanel5.add(AmisSelected, java.awt.BorderLayout.WEST);

        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        demandeAmisTextField.setToolTipText("Entrez ici le pseudonyme de votre potentiel futur ami");
        jPanel2.add(demandeAmisTextField);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));
        jPanel6.add(filler1);

        demandeAmisButton.setText("Envoyer");
        demandeAmisButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                demandeAmisButtonMouseClicked(evt);
            }
        });
        jPanel6.add(demandeAmisButton);

        jPanel2.add(jPanel6);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        creerDocumentTextField.setToolTipText("Entrez ici le titre du document que vous voulez créer");
        jPanel3.add(creerDocumentTextField);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        ecritureComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Public", "Amis", "Utilisateur" }));
        jPanel4.add(ecritureComboBox);

        lectureComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Public", "Amis", "Utilisateur" }));
        jPanel4.add(lectureComboBox);

        creerDocumentButton.setText("Créer !");
        creerDocumentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                creerDocumentButtonMouseClicked(evt);
            }
        });
        jPanel4.add(creerDocumentButton);

        jPanel3.add(jPanel4);

        jPanel1.add(jPanel3);

        jPanel5.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.addTab("travail sur", travailleSurScrollPane);

        jPanel5.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        add(jPanel5, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void demandeAmisButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_demandeAmisButtonMouseClicked
        String destinataire = demandeAmisTextField.getText();

        if (destinataire.length() != 0) {
            boolean setAmis = Connexion.GESTIONBD.setDemandeAmis(Connexion.PSEUDO, destinataire);

            if (setAmis) {
                demandeAmisTextField.setText("");
            }
        }
    }//GEN-LAST:event_demandeAmisButtonMouseClicked

    /**
     * Quand on clique le bouton créer document on déclenche les actions
     * adéquates
     *
     * @param evt
     * @author Anthony
     * @author Francis
     */
    private void creerDocumentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creerDocumentButtonMouseClicked
        String titre = creerDocumentTextField.getText();

        if (titre.length() != 0) {
            String lecture = (String) lectureComboBox.getSelectedItem();
            String ecriture = (String) ecritureComboBox.getSelectedItem();

            Connexion.GESTIONBD.setNouveauDocument(titre, lecture, ecriture, Connexion.PSEUDO);
        }
    }//GEN-LAST:event_creerDocumentButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane AmisSelected;
    private javax.swing.JScrollPane amisScrollPane;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton creerDocumentButton;
    private javax.swing.JTextField creerDocumentTextField;
    private javax.swing.JButton demandeAmisButton;
    private javax.swing.JTextField demandeAmisTextField;
    private javax.swing.JScrollPane demandeamisScrollPane;
    private javax.swing.JComboBox ecritureComboBox;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox lectureComboBox;
    private javax.swing.JScrollPane travailleSurScrollPane;
    // End of variables declaration//GEN-END:variables
}
