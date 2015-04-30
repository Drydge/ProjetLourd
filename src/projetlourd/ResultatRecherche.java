/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetlourd;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author drydge
 */
public class ResultatRecherche extends javax.swing.JPanel {

    Object[][] Document;
    private JTable Tableau;
    /**
     * Creates new form ResultatRecherche
     *
     * @param lRecherche
     */
    public ResultatRecherche(List<String[]> lRecherche) {
        Document = new Object[lRecherche.size()][6];
        int i = 0;
        for (String[] document : lRecherche) {
            Document[i]=document;i++;
        }
        String[] Title={"id","titre","auteur","lecture","ecriture","nombre participants"};
        Tableau = new JTable(Document,Title);
        JScrollPane scroll=new JScrollPane(Tableau);
        Tableau.setFillsViewportHeight(true);
        this.add(scroll);
    }

}
