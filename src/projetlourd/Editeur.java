package projetlourd;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;

/**
 * JFrame permettant l'édition des documents
 *
 * @author Anthony
 */
public class Editeur extends javax.swing.JFrame {

    String id;

    /**
     * Constructeur qui permet d'aller récupérer le texte du document sur le
     * serveur
     *
     * @param id IDDocument du document
     */
    public Editeur(String id) {
        this.id = id;
        initComponents();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);

        String result = Connexion.GESTIONBD.getDocument(id);

        String[] parties = result.split(",");

        parties = parties[0].split("-");

        String titre = parties[0];
        String chemin = parties[1];
        String lecture = parties[2];
        String auteur = parties[4];

        this.setTitle(titre);

        String fic = "";

        boolean amis = Connexion.GESTIONBD.sontAmis(Connexion.PSEUDO, auteur);

        if (lecture.equals("Public") || (lecture.equals("Amis") && amis) || Connexion.PSEUDO.equals(auteur)) {
            //si le Document est "public" alors pas de soucis
            //si la lecture du Document est réservé aux amis on regarde si l'auteur et l'utilisateur sont amis
            //si l'utilisateur est l'auteur du Document alors pas de soucis
            try {
                //on créé cet objet qui permettra de creer des fichiers ou des dossiers mais aussi de les lire
                ChannelSftp sftp = (ChannelSftp) GestionBD.getSession().openChannel("sftp");
                sftp.connect(); //on se connecte

                InputStream streamFic = sftp.get(chemin); //on récupère le fichier id à l'adresse ~/session/Projet/auteur
                BufferedReader bufferFic = new BufferedReader(new InputStreamReader(streamFic)); //on créé un BufferReader sur l'InputStream

                String line;

                //on récupère le contenu du fichier
                while ((line = bufferFic.readLine()) != null) {
                    fic += line + "\n";
                }

                //on ferme ce dont a plus besoin
                streamFic.close();
                sftp.disconnect();

            } catch (JSchException | SftpException ex) {
                Logger.getLogger(Document.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Editeur.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //on traite les cas ou l'utilisateur ne peut pas lire le Document
            if (lecture.equals("Amis")) {
                fic = "Ce document n'est visible que par les amis de " + auteur + " et vous n'êtes pas encore amis,"
                        + " n'hésitez pas à lui envoyer une demande d'amis !";
            }
            if (lecture.equals("Utilisateur")) {
                fic = "Ce document n'est visible que par " + auteur;
            }
        }

        this.Fichier.setText(fic);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        etat = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Fichier = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        save = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jToolBar1.setRollover(true);
        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        etat.setText("Edition");
        getContentPane().add(etat, java.awt.BorderLayout.PAGE_END);

        Fichier.setMinimumSize(new java.awt.Dimension(800, 600));
        jScrollPane2.setViewportView(Fichier);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        save.setText("Save");
        save.setMinimumSize(new java.awt.Dimension(0, 60));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jMenu1.add(save);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane Fichier;
    private javax.swing.JLabel etat;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem save;
    // End of variables declaration//GEN-END:variables
}
