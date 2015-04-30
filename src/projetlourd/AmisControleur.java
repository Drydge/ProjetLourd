/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetlourd;

import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JLabel;


/**
 *
 * @author francis
 */
class AmisControleur implements MouseListener{
    ObversableAmis oA;
    AmisPanel aP;
    
    AmisControleur(ObversableAmis oA, AmisPanel aP) {
        this.oA = oA;
        this.aP = aP;
    }
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent me) {
        for (JLabel jlab : aP.labelAmi) {
            if(jlab == me.getSource()){
                System.out.println("on clique sur " + jlab.getText());
                try {
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
