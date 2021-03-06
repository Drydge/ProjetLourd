/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetlourd;

/**
 * JPanel pour les profils
 *
 * @author Anthony
 */
public class Profils extends javax.swing.JPanel {

    AmisPanel amisPanel;
    TravailleSurPanel travailleSurPanel;

    private final String name;

    /**
     * Après le initComponents() on ajoute des composants faits "main"pour les
     * amis et les documents
     *
     * @author Anthony
     */
    public Profils(String name) {
        this.setVisible(true);
        this.name = name;
        initComponents();

        ObversableAmis oa = new ObversableAmis(name);

        amisPanel = new AmisPanel(oa);
        amisScrollPane.setViewportView(amisPanel);

        travailleSurPanel = new TravailleSurPanel(name);
        oa.addObserver(amisPanel);
        travailleSurScrollPane.setViewportView(travailleSurPanel);

    }

    /**
     * Code généré pr le GUI creator de Netbeans
     *
     * @author Anthony
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        AmisSelected = new javax.swing.JTabbedPane();
        amisScrollPane = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        demandeAmisTextField = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        demandeAmisButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        travailleSurScrollPane = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setMaximumSize(new java.awt.Dimension(500, 200));
        setMinimumSize(new java.awt.Dimension(500, 200));
        setPreferredSize(new java.awt.Dimension(500, 200));
        setLayout(new java.awt.BorderLayout(15, 0));

        jPanel5.setLayout(new java.awt.BorderLayout());

        AmisSelected.setMinimumSize(new java.awt.Dimension(143, 100));
        AmisSelected.setName(""); // NOI18N
        AmisSelected.setPreferredSize(new java.awt.Dimension(143, 100));

        amisScrollPane.setMaximumSize(new java.awt.Dimension(25, 25));
        amisScrollPane.setName(""); // NOI18N
        AmisSelected.addTab("Amis", amisScrollPane);

        jPanel5.add(AmisSelected, java.awt.BorderLayout.WEST);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

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

        jPanel5.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.addTab("travail sur", travailleSurScrollPane);

        jPanel5.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("vous êtes sur le profil de "+this.name);
        jPanel3.add(jLabel1);

        jPanel5.add(jPanel3, java.awt.BorderLayout.NORTH);

        add(jPanel5, java.awt.BorderLayout.CENTER);
        add(filler2, java.awt.BorderLayout.EAST);
        add(filler3, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * On peut ajouter un amis directement depuis son profil sans avoir à
     * revenir sur MonProfil
     *
     * @param evt
     * @author Anthony
     */
    private void demandeAmisButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_demandeAmisButtonMouseClicked
        String destinataire = demandeAmisTextField.getText();

        if (destinataire.length() != 0) {
            boolean setAmis = Connexion.GESTIONBD.setDemandeAmis(Connexion.PSEUDO, destinataire);

            if (setAmis) {
                demandeAmisTextField.setText("");
            }
        }
    }//GEN-LAST:event_demandeAmisButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane AmisSelected;
    private javax.swing.JScrollPane amisScrollPane;
    private javax.swing.JButton demandeAmisButton;
    private javax.swing.JTextField demandeAmisTextField;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane travailleSurScrollPane;
    // End of variables declaration//GEN-END:variables
}
