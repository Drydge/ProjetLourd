package projetlourd;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author francis
 */
class AmisPanel extends JPanel {

    JLabel labelAmi;

    public AmisPanel(String pseudo) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        GestionBD gestionBD = Connexion.GESTIONBD;

        String amis = gestionBD.getAmis(Connexion.PSEUDO);

        String[] parties = amis.split(",");
        String[] parties2;

        List<String> lAmis = new ArrayList<>();

        //on exécute des traitements sur la chaîne retournée et on ajoute les amis à une liste de String
        for (String party : parties) {
            parties2 = party.split("-");
            lAmis.add(parties2[0]);
        }

        for (String lAmi : lAmis) {
            labelAmi = new JLabel(lAmi);
            this.add(labelAmi);

            labelAmi.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    LabelAmiMouseClicked(evt);
                }
            });
        }

    }

    private void LabelAmiMouseClicked(MouseEvent evt) {
        JLabel jlab = (JLabel) evt.getComponent();
        System.out.println("on clique sur " + jlab.getText());
    }
}
