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
class ObversableAmis extends Observable {

    List<String> lAmis;

    public ObversableAmis(String pseudo) {
        GestionBD gestionBD = Connexion.GESTIONBD;

        String amis = gestionBD.getAmis(Connexion.PSEUDO);

        String[] parties = amis.split(",");
        String[] parties2;

        lAmis = new ArrayList<>();

        //on exécute des traitements sur la chaîne retournée et on ajoute les amis à une liste de String
        for (String party : parties) {
            parties2 = party.split("-");
            lAmis.add(parties2[0]);
        }
    }

    public List<String> getLAmis() {
        return lAmis;
    }

}
