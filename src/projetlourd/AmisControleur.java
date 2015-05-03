package projetlourd;

import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JLabel;


/**
 * Controleur pour AmisPanel
 * 
 * @author francis
 * @author Anthony
 */
class AmisControleur implements MouseListener{
    ObversableAmis oA;
    AmisPanel aP;
    
    /**
     * On fait les liens
     * @param oA
     * @param aP 
     * @author Anthony
     * @author Francis
     */
    AmisControleur(ObversableAmis oA, AmisPanel aP) {
        this.oA = oA;
        this.aP = aP;
    }
    
    /**
     * Action déclenché quand on clique sur le pseudo d'un ami
     * 
     * @param me 
     * @author Francis
     * @author Anthony
     */
    @Override
    public void mouseClicked(java.awt.event.MouseEvent me) {
        for (JLabel jlab : aP.labelAmi) {
            if(jlab == me.getSource()){
                System.out.println("on clique sur " + jlab.getText());
                try {
                    //on créé un nouveau centerPanel qui sera le Profil de l'ami
                    Application.getInstance().remove(Application.getInstance().centerPanel);
                    Application.getInstance().centerPanel = new Profils(jlab.getText());
                    Application.getInstance().centerPanel.setVisible(true);
                    Application.getInstance().add(Application.getInstance().centerPanel, java.awt.BorderLayout.CENTER);
                    Application.getInstance().pack();
                    Application.getInstance().repaint();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent me) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent me) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent me) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent me) {
    }
}
