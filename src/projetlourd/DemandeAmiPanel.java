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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author francis
 */
class DemandeAmiPanel extends JPanel implements Observer{

    ArrayList<JLabel> labelDemande = new ArrayList<>();
    ObservableDemandeAmis observableDemandeAmis;

    public DemandeAmiPanel(ObservableDemandeAmis oDA) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        observableDemandeAmis = oDA;
        
        observableDemandeAmis.addObserver(this);
        
        for (String lAmi : oDA.lDemandeAmis) {
            labelDemande.add(new JLabel(lAmi));
            this.add(labelDemande.get(labelDemande.size() - 1));

            DemandeAmisControleur dAC = new DemandeAmisControleur(observableDemandeAmis, this);
            
            labelDemande.get(labelDemande.size() - 1).addMouseListener(dAC);
        }
    }

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
