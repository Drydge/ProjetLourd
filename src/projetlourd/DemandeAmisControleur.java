/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetlourd;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

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
        for (JLabel jlab : dAP.labelDemande) {
            if(jlab == me.getSource())
                System.out.println("on clique sur " + jlab.getText());
        }
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
