package br.unesp.rc.bibSys.utils;

import br.unesp.rc.bibSys.apresentacao.JDialogComparar;
import br.unesp.rc.bibSys.apresentacao.JDialogGerarBibKey;
import br.unesp.rc.bibSys.apresentacao.JDialogOrdenar;
import br.unesp.rc.bibSys.apresentacao.JDialogPadronizar;
import br.unesp.rc.bibSys.apresentacao.JDialogSobre;
import br.unesp.rc.bibSys.apresentacao.MainJFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TrayGUI {

    private static MainJFrame frame_p = new MainJFrame();
    private static JDialog Sobre = new JDialogSobre(null, true);
    private static JDialog frameComparar = new JDialogComparar(frame_p, true);
    private static JDialog frameGerarBibKey = new JDialogGerarBibKey(frame_p, true);
    private static JDialog frameOrdenar = new JDialogOrdenar(frame_p, true);
    private static JDialog framePadronizar = new JDialogPadronizar(frame_p, true);
    
    /**
     * Seta o tema do systemTray, trata exceções e chama o mesmo
     */
    public static void tray_manager() {

        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
//Schedule a job for the event-dispatching thread:
//adding TrayIcon.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    /**
     * Cria e mostra o systemTray
     */
    private static void createAndShowGUI() {
//Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon = new TrayIcon(createImage("bulb.gif", "tray icon"));
        final SystemTray tray = SystemTray.getSystemTray();

// Create a popup menu components
        MenuItem sobreItem = new MenuItem("Sobre");
        MenuItem novoItem = new MenuItem("Novo");
        MenuItem abrirItem = new MenuItem("Abrir");
        MenuItem compararItem = new MenuItem("Comparar");
        MenuItem concatenarItem = new MenuItem("Concatenar");
        MenuItem ordenarItem = new MenuItem("Ordenar");
        MenuItem padronizarItem = new MenuItem("Padronizar");
        MenuItem geradorBibKeyItem = new MenuItem("Gerar BibKey");
        MenuItem sair = new MenuItem("Sair");

//Add components to popup menu
        popup.add(abrirItem);
        popup.add(novoItem);
        popup.addSeparator();
        popup.add(compararItem);
        popup.add(concatenarItem);
        popup.add(ordenarItem);
        popup.add(padronizarItem);
        popup.add(geradorBibKeyItem);
        popup.addSeparator();
        popup.add(sobreItem);
        popup.addSeparator();
        popup.add(sair);
        trayIcon.setPopupMenu(popup);
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }
        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame_p.setVisible(true);
                frame_p.toFront();

            }
        });
        sobreItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Sobre.pack();
                Sobre.setVisible(true);
            }
        });
        novoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                EditorTexto doc = new EditorTexto(false, "");
            }
        });
        abrirItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                String path = "";

                if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    path = chooser.getSelectedFile().toString();
                    frame_p.setVisible(true);
                    EditorTexto doc = new EditorTexto(true, path);

                }

            }
        });
        compararItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frameComparar.pack();
                frame_p.setVisible(false);
                frameComparar.setVisible(true);
            }
        });
        
        concatenarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frameComparar.pack();
                frame_p.setVisible(true);
                frameComparar.setVisible(true);
            }
        });
        
        ordenarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frameOrdenar.pack();
                frame_p.setVisible(true);
                frameOrdenar.setVisible(true);
            }
        });
        
        geradorBibKeyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frameGerarBibKey.pack();
                frame_p.setVisible(true);
                frameGerarBibKey.setVisible(true);
            }
        });

        padronizarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                framePadronizar.pack();
                frame_p.setVisible(true);
                framePadronizar.setVisible(true);
            }
        });        

        sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
    }
    /**
     * Retorna o URL da imagem que pode ser impressa na tela
     * @param path
     * @param description
     * @return URL da imagem em questão
     */
    protected static Image createImage(String path, String description) {
        String imageURL = path;
        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}
