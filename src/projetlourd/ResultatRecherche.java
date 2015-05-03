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
            Document[i] = document;
            i++;
        }
        String[] Title = {"id", "titre", "auteur", "lecture", "ecriture", "nombre participants"};
        Tableau = new JTable(Document, Title);
        JScrollPane scroll = new JScrollPane(Tableau);
        Tableau.setFillsViewportHeight(true);
        this.add(scroll);

        Tableau.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == e.UPDATE) {
                    int col = Tableau.getSelectedColumn();
                    int row = Tableau.getSelectedRow();

                    if (col == 2) {
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
                        JFrame editor = new Editeur(Document[row][0].toString());
                        editor.setVisible(true);
                    }
                }
            }
        });
    }

    String getString(int c, int r) {
        return Document[r][c].toString();
    }

}
