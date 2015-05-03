package projetlourd;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Controleur pour les demande d'amis
 *
 * @author Francis
 */
class DemandeAmisControleur implements MouseListener {

    ObservableDemandeAmis oDA;
    DemandeAmiPanel dAP;

    DemandeAmisControleur(ObservableDemandeAmis observableDemandeAmis, DemandeAmiPanel dAP) {
        this.oDA = observableDemandeAmis;
        this.dAP = dAP;
    }

    /**
     * Quand on clique sur envoyer on déclenche les actions dans la base de
     * données
     *
     * @param me
     * @author Francis
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        for (JPanel jPane : dAP.panelDemande) {
            Component[] components = jPane.getComponents();
            if (components[3] == me.getSource()) {
                if (((JRadioButton) components[1]).isSelected()) {
                    Connexion.GESTIONBD.setAmis(components[3].getName(), Connexion.PSEUDO);
                }
                Connexion.GESTIONBD.dropDemande(components[3].getName(), Connexion.PSEUDO);

                oDA.remove(components[3].getName()); //on enelève le JPanel pour lequel on a répondu
            }
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
