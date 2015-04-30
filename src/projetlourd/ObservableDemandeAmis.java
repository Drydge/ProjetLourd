/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetlourd;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author francis
 */
public class ObservableDemandeAmis extends Observable{
    List<String> lDemandeAmis;

    public ObservableDemandeAmis(String pseudo) {
        GestionBD gestionBD = Connexion.GESTIONBD;
        String demandeAmis = gestionBD.getDemandeAmis(pseudo);

        String[] parties = demandeAmis.split(",");
        String[] parties2;
        
        lDemandeAmis = new ArrayList<>();

        //même traitement que pour la liste d'amis
        for (String party : parties) {
            parties2 = party.split("-");
            lDemandeAmis.add(parties2[0]);
        }
    }

    public void remove(String name) {
        lDemandeAmis.remove(name);
        setChanged();
        notifyObservers();
    }
}
