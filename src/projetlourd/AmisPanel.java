package projetlourd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * JPanel pour afficher les amis
 * 
 * @author Anthony
 * @author Francis
 */
class AmisPanel extends JPanel implements Observer {

    ArrayList<JLabel> labelAmi = new ArrayList<>();
    ObversableAmis observableAmis;

    
    public AmisPanel(ObversableAmis oa) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        observableAmis = oa;
        
        observableAmis.addObserver(this);
        
        for (String lAmi : oa.lAmis) {
            labelAmi.add(new JLabel(lAmi));
            this.add(labelAmi.get(labelAmi.size() - 1));

            AmisControleur aC = new AmisControleur(observableAmis, this);
            
            labelAmi.get(labelAmi.size() - 1).addMouseListener(aC);
        }
    }
    
    @Override
    public void update(Observable o, Object o1) {
        observableAmis.lAmis = ((ObversableAmis) o).lAmis;
        
        int i = 0;
        
        for (JLabel labelAmi1 : labelAmi) {
            labelAmi1.setText(observableAmis.lAmis.get(i));
            i++;
        }
        
        try {
            Application.getInstance().repaint();
        } catch (IOException ex) {
            Logger.getLogger(AmisPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
