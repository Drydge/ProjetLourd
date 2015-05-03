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
 * Un observable pour les demandes d'amis
 *
 * @author Francis
 * @author Anthony
 */
public class ObservableDemandeAmis extends Observable {

    List<String> lDemandeAmis;

    /**
     * On rempli la liste des demande d'amis avec les demande d'amis de pseudo
     *
     * @param pseudo
     * @author Francis
     * @author Anthony
     */
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

    /**
     * Quand on répond à une demande d'ami on la supprime de la BDD donc aussi
     * de la liste
     *
     * @param name
     * @author Francis
     * @author Anthony
     */
    public void remove(String name) {
        lDemandeAmis.remove(name);
        setChanged();
        notifyObservers();
    }
}
