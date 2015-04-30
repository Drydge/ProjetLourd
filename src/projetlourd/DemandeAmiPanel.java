/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetlourd;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author francis
 */
class DemandeAmiPanel extends JPanel implements Observer{

    ArrayList<JPanel> panelDemande = new ArrayList<>();
    ObservableDemandeAmis observableDemandeAmis;

    public DemandeAmiPanel(ObservableDemandeAmis oDA) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        observableDemandeAmis = oDA;
        
        observableDemandeAmis.addObserver(this);
        
        for (String lAmi : oDA.lDemandeAmis) {
            JPanel courant = new JPanel();
            courant.add(new JLabel(lAmi));
            
            JRadioButton accepterButton = new JRadioButton("Accepter");
            JRadioButton refuserButton = new JRadioButton("Refuser");
            
            accepterButton.setName(lAmi + "a");
            refuserButton.setName(lAmi + "r");
            
            JButton envoyerButton = new JButton("Envoyer !");
            envoyerButton.setName(lAmi);
            
            
            ButtonGroup group = new ButtonGroup();
            
            group.add(accepterButton);
            group.add(refuserButton);
            
            courant.add(accepterButton);
            courant.add(refuserButton);
            courant.add(envoyerButton);
            
            panelDemande.add(courant);
            this.add(panelDemande.get(panelDemande.size() - 1));

            DemandeAmisControleur dAC = new DemandeAmisControleur(observableDemandeAmis, this);
            
            envoyerButton.addMouseListener(dAC);
        }
    }

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
