/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetlourd;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 * JPanel qui affiche les résultats d'une recherche
 *
 * @author Anthony
 */
public class ResultatRecherche extends javax.swing.JPanel {

    Object[][] Document;
    private JTable Tableau;

    /**
     * A partir d'une liste lRecherche résultat de l'intéroggation de la base de
     * données on créé le tableau
     *
     * @param lRecherche
     * @author Anthony
     */
    public ResultatRecherche(List<String[]> lRecherche) {
        Document = new Object[lRecherche.size()][6];
        int i = 0;
        for (String[] document : lRecherche) {
            Document[i] = document;
            i++;
        }
        String[] Title = {"id", "titre", "auteur", "lecture", "ecriture", "nombre participants"};
        Tableau = new JTable(Document, Title);
        JScrollPane scroll = new JScrollPane(Tableau);
        Tableau.setFillsViewportHeight(true);
        this.add(scroll);

        /**
         * Ecouteur pour le tableau
         * 
         * @author Francis
         */
        Tableau.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == e.UPDATE) {
                    int col = Tableau.getSelectedColumn();
                    int row = Tableau.getSelectedRow();

                    if (col == 2) {
                        //si on a cliqué dans la colonne amis on change le centerPanel en Profil(amiscliqué)
                        try {
                            Application.getInstance().remove(Application.getInstance().centerPanel);
                            Application.getInstance().centerPanel = new Profils(getString(col, row));
                            Application.getInstance().centerPanel.setVisible(true);
                            Application.getInstance().add(Application.getInstance().centerPanel, java.awt.BorderLayout.CENTER);
                            Application.getInstance().pack();
                            Application.getInstance().repaint();
                        } catch (IOException ex) {
                            Logger.getLogger(ResultatRecherche.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        //Sinon on ouvre un Editeur correspondant au document de la ligne sur laquelle on a cliqué
                        JFrame editor = new Editeur(Document[row][0].toString());
                        editor.setVisible(true);
                    }
                }
            }
        });
    }

    /**
     * Méthode qui permet de récupérer la String dans le tableau
     * 
     * @author Anthony
     * @author Francis
     * @param c numéro de colonne
     * @param r numéro de ligne
     * @return la String correspondant à (c,r)
     */
    public String getString(int c, int r) {
        return Document[r][c].toString();
    }

}
