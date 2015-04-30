package projetlourd;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author francis
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
        
        repaint();
    }
}
