/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetlourd;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * JPanel pour les documents sur lequel l'utilisateur travaille
 *
 * @author Anthony
 */
class TravailleSurPanel extends JPanel {

    JLabel labelTravailleSur;

    /**
     * On créé un Panel à partir du Pseudo
     *
     * @param PSEUDO
     * @author Anthony
     */
    TravailleSurPanel(String PSEUDO) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        GestionBD gestionBD = Connexion.GESTIONBD;

        String travailleSur = gestionBD.getTravailleSur(PSEUDO);
        String[] parties = travailleSur.split(",");
        String[] parties2;

        //idem que pour la liste d'amis mais on aura ici une liste de String[] car on envoie le titre du document et son id
        List<String[]> lDoc = new ArrayList<>();
        for (String party : parties) {
            parties2 = party.split("-");
            lDoc.add(parties2);
        }

        for (String[] lDoc1 : lDoc) {
            if (lDoc1.length != 0) {
                labelTravailleSur = new JLabel(lDoc1[1]);
                labelTravailleSur.setName(lDoc1[0]); //le name contient l'IDDocument
                this.add(labelTravailleSur);

                labelTravailleSur.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        LabelTravailleSurMouseClicked(evt);
                    }
                });
            }
        }
    }

    /**
     * Quand on clique sur un JLabel on récupère son nom (qui contient l'id
     * unique) et on créé l'Editeur correspondant
     *
     * @author Anthony
     * @param evt
     */
    private void LabelTravailleSurMouseClicked(MouseEvent evt) {
        JLabel jlab = (JLabel) evt.getComponent();
        JFrame editor = new Editeur(jlab.getName());
        editor.setVisible(true);
    }
}
