/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
//import com.sun.mail.*;

/**
 *
 * @author Nicolas
 */
public class mailbox_frame extends javax.swing.JFrame {

    //private static String host = "u2.wildness.loc";
    //private String exp = "vilvens@u2.wildness.loc";
    private String mail;
    private String password;
    private Properties prop = System.getProperties();
    private Session sess;
    private Properties p = new Properties();
    private List<File> listFiles;
    private Message [] msg;
    private String filePath;
    private int nbrMsg;
    private boolean newMsg = false;
    private Multipart multipart;

    public mailbox_frame() {
        initComponents();
        filesLabel.setText("");
        this.setLocationRelativeTo(null);

        // première allocation. réallouer après chaque envoie.
        multipart = new MimeMultipart();

        //Lancement du thread timer qui check si nouveau messages.
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                RecepetionMessage();
                if(newMsg)
                    JOptionPane.showMessageDialog(null, "Vous avez des nouveaux messages !");
            }
        };

        Timer timer = new Timer("NewMessage");//create a new Timer

        timer.scheduleAtFixedRate(timerTask, 30, 300000);//5 minutes
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
        connectionButton = new javax.swing.JButton();
        actualisationButton = new javax.swing.JButton();
        mailTabbedPane = new javax.swing.JTabbedPane();
        mailPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mailJT = new javax.swing.JTable();
        newMailTab = new javax.swing.JPanel();
        toLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        objectLabel = new javax.swing.JLabel();
        toTF = new javax.swing.JTextField();
        objectTF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea();
        messageLabel = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        attachButton = new javax.swing.JButton();
        filesLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nbrMessLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nbrNewMessLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        connectionButton.setText("Connexion");
        connectionButton.setFocusable(false);
        connectionButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        connectionButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        connectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(connectionButton);

        actualisationButton.setText("Actualiser");
        actualisationButton.setFocusable(false);
        actualisationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        actualisationButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        actualisationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualisationButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(actualisationButton);

        mailJT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Expéditeur", "Titre", "Date"
            }
        ));
        mailJT.setCellSelectionEnabled(false);
        mailJT.setEnabled(false);
        mailJT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mailJTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(mailJT);

        javax.swing.GroupLayout mailPanelLayout = new javax.swing.GroupLayout(mailPanel);
        mailPanel.setLayout(mailPanelLayout);
        mailPanelLayout.setHorizontalGroup(
            mailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );
        mailPanelLayout.setVerticalGroup(
            mailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mailPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        mailTabbedPane.addTab("Messages reçus", mailPanel);

        toLabel.setText("To :");

        jLabel2.setText("Nouveau message");

        objectLabel.setText("Object :");

        messageTextArea.setColumns(20);
        messageTextArea.setRows(5);
        jScrollPane2.setViewportView(messageTextArea);

        messageLabel.setText("Message :");

        sendButton.setText("Envoyer");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        attachButton.setText("Joindre");
        attachButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachButtonActionPerformed(evt);
            }
        });

        filesLabel.setText("files");

        javax.swing.GroupLayout newMailTabLayout = new javax.swing.GroupLayout(newMailTab);
        newMailTab.setLayout(newMailTabLayout);
        newMailTabLayout.setHorizontalGroup(
            newMailTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newMailTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newMailTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newMailTabLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(newMailTabLayout.createSequentialGroup()
                        .addGroup(newMailTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(objectLabel)
                            .addComponent(toLabel)
                            .addComponent(messageLabel))
                        .addGap(18, 18, 18)
                        .addGroup(newMailTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(newMailTabLayout.createSequentialGroup()
                                .addComponent(attachButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sendButton))
                            .addComponent(toTF)
                            .addComponent(objectTF)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                            .addGroup(newMailTabLayout.createSequentialGroup()
                                .addComponent(filesLabel)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        newMailTabLayout.setVerticalGroup(
            newMailTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newMailTabLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(newMailTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toLabel)
                    .addComponent(toTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newMailTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objectLabel)
                    .addComponent(objectTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newMailTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageLabel)
                    .addComponent(filesLabel))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(newMailTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendButton)
                    .addComponent(attachButton))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        mailTabbedPane.addTab("Nouveau message", newMailTab);

        jLabel1.setText("Boite de réception :");

        nbrMessLabel.setText("0 messages");

        jLabel3.setText("Nouveaux messages :");

        nbrNewMessLabel.setText("0 messages");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(nbrMessLabel)
                    .addComponent(jLabel3)
                    .addComponent(nbrNewMessLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mailTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mailTabbedPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nbrMessLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nbrNewMessLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualisationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualisationButtonActionPerformed
        // TODO add your handling code here:
        RecepetionMessage();
    }//GEN-LAST:event_actualisationButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed

        try
        {
            MimeMessage msg = new MimeMessage (sess);
            msg.setFrom (new InternetAddress(mail));
            msg.setRecipient (Message.RecipientType.TO, new InternetAddress (toTF.getText()));
            msg.setSubject(objectTF.getText());
            //msg.setText (messageTextArea.getText());

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(messageTextArea.getText());
            multipart.addBodyPart(messageBodyPart);

            /** Si message avec pièce jointes alors **/
            if(!filesLabel.getText().equals("")) {

                // Send the complete message parts
                msg.setContent(multipart);
            }

            System.out.println("Envoi du message");
            Transport.send(msg);
            multipart = new MimeMultipart();
            JOptionPane.showMessageDialog(null, "Message envoyé !");
        }
        catch (MessagingException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Errreur sur message : " + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void attachButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachButtonActionPerformed
        attachDialog attach = new attachDialog(this, true, "open");
        attach.setVisible(true);

        filesLabel.setText(filesLabel.getText() + ", " + attach.GetFile().getName());
        //listFiles.add(attach.GetFile());
        filePath = attach.GetFilePath();

        //Ajout de la pièce attaché au message
        BodyPart messageBodyPart = new MimeBodyPart();

        DataSource source = new FileDataSource(filePath);
        try {
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(attach.GetFile().getName());
            multipart.addBodyPart(messageBodyPart);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_attachButtonActionPerformed

    private void connectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionButtonActionPerformed
        loginDialog login = new loginDialog(this, true);
        login.setVisible(true);
        mail = login.getMail();
        password = login.getPassword();
        login.dispose();

        /** PREPARATION ENVOI / RECEPTION MESSAGE**/
        CreateSession();
        JOptionPane.showMessageDialog(null, "Connecté avec succès ! \n Récupération de vos messages en cours ...");
        RecepetionMessage();

    }//GEN-LAST:event_connectionButtonActionPerformed

    private void mailJTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mailJTMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
            int row = mailJT.rowAtPoint(evt.getPoint());
            int mess = msg.length - row - 1;

            readMessage read = new readMessage(this, true, msg[mess]);
            read.setVisible(true);
        }
    }//GEN-LAST:event_mailJTMouseClicked

    private void RecepetionMessage(){

        try
        {
            String user = mail;
            String pwd = password;

            //Obtention d'un objet store
            Store st = sess.getStore("pop3");
            st.connect(propertiesReader.getProperties("SERVERRECEP"), user, pwd); //garder host pour u2

            //Obtention d'un folder
            Folder f = st.getFolder("INBOX");
            f.open(Folder.READ_ONLY);

            //Reception des messages

            msg = f.getMessages();
            nbrMessLabel.setText( f.getMessageCount() + "messages");
            if(nbrMsg < f.getMessageCount())
                newMsg = true;
            else
                newMsg = false;
            nbrMsg = f.getMessageCount();
            nbrNewMessLabel.setText( f.getNewMessageCount() + "messages");
            System.out.println("Liste des messages : ");

            DefaultTableModel model = (DefaultTableModel) mailJT.getModel();
            int j = 0;
            for (int i = msg.length - 1; i >= 220; i--)//msg.length
            {
                //if (msg[i].isMimeType("text/plain"))
                //{
                    //System.out.println("Expéditeur : " + msg[i].getFrom() [0]);
                    //System.out.println("Sujet = " + msg[i].getSubject());
                    //System.out.println("Texte : " + msg[i].getContent());
                    model.insertRow(j,  new Object[]{msg[i].getFrom() [0], msg[i].getSubject(), msg[i].getSentDate()});
                    j++;
                    msg[i].getAllHeaders();
                    //}
            }

            mailJT.setModel(model);
            System.out.println("Fin des messages");
    }
    catch (NoSuchProviderException e)
        {
            System.out.println("Errreur sur provider : " + e.getMessage());
        }
    catch (MessagingException e) {
        System.out.println("Errreur sur message : " + e.getMessage());
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    catch (Exception e)
        {
            System.out.println("Errreur indéterminée : " + e.getMessage());
        }
    }

    private void CreateSession(){

        /** PREPARATION ENVOI / RECEPTION MESSAGE**/
        /*prop.put("mail.smtp.host", host);
        prop.put("mail.pop3.host", host);
        prop.put("mail.disable.top", true);
        sess = Session.getDefaultInstance(prop, null);*/

        prop.put("mail.smtp.host", propertiesReader.getProperties("SERVERENVOIE"));
        prop.put("mail.smtp.port", propertiesReader.getProperties("PORTENVOIE"));
        prop.put("mail.from", mail);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.starttls.required", "true");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.debug", "true");
        prop.put("file.encoding", "iso-8859-1");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");



        //Propriété pour la réception
        prop.put("mail.pop3.host", propertiesReader.getProperties("SERVERRECEP"));
        prop.put("mail.pop3.auth","true");
        prop.put("mail.pop3.port", propertiesReader.getProperties("PORTRECEP"));
        prop.put("mail.pop3.starttls.enable","true");
        prop.put("mail.disable.top", "true");
        prop.put("mail.pop3.disablecapa", "true");
        prop.put("mail.pop3.socketFactory" , propertiesReader.getProperties ("PORTRECEP") );
        prop.put("mail.pop3.socketFactory.class" , "javax.net.ssl.SSLSocketFactory" );

        sess = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication  getPasswordAuthentication() {
                return new PasswordAuthentication(mail, propertiesReader.getProperties("PWD"));}
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mailbox_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mailbox_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mailbox_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mailbox_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mailbox_frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualisationButton;
    private javax.swing.JButton attachButton;
    private javax.swing.JButton connectionButton;
    private javax.swing.JLabel filesLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable mailJT;
    private javax.swing.JPanel mailPanel;
    private javax.swing.JTabbedPane mailTabbedPane;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JTextArea messageTextArea;
    private javax.swing.JLabel nbrMessLabel;
    private javax.swing.JLabel nbrNewMessLabel;
    private javax.swing.JPanel newMailTab;
    private javax.swing.JLabel objectLabel;
    private javax.swing.JTextField objectTF;
    private javax.swing.JButton sendButton;
    private javax.swing.JLabel toLabel;
    private javax.swing.JTextField toTF;
    // End of variables declaration//GEN-END:variables
}
