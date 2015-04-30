/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetlourd;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author francis
 */
class DemandeAmisControleur implements MouseListener {

    ObservableDemandeAmis oDA;
    DemandeAmiPanel dAP;

    DemandeAmisControleur(ObservableDemandeAmis observableDemandeAmis, DemandeAmiPanel dAP) {
        this.oDA = observableDemandeAmis;
        this.dAP = dAP;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        for (JPanel jPane : dAP.panelDemande) {
            Component[] components = jPane.getComponents();
            if (components[3] == me.getSource()) {
                if (((JRadioButton) components[1]).isSelected()) {
                    Connexion.GESTIONBD.setAmis(components[3].getName(), Connexion.PSEUDO);
                }
                Connexion.GESTIONBD.dropDemande(components[3].getName(), Connexion.PSEUDO);
            }
        }
        oDA.notifyObservers();
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
