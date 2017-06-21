package br.unesp.rc.bibSys.utils;
import br.unesp.rc.bibSys.apresentacao.JDialogComparar;
import br.unesp.rc.bibSys.apresentacao.JDialogSobre;
import br.unesp.rc.bibSys.apresentacao.MainJFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TrayGUI {
public static void tray_manager() {

try {
UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
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
MenuItem sair= new MenuItem("Sair");

//Add components to popup menu



popup.add(abrirItem);
popup.add(novoItem);
popup.addSeparator();
popup.add(compararItem);
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
JOptionPane.showMessageDialog(null,
"This dialog box is run from System Tray");
}
});
sobreItem.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
    JDialog Sobre= new JDialogSobre(null,true);
        Sobre.pack();
        Sobre.setVisible(true);
}
});
novoItem.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
     EditorTexto doc = new EditorTexto(false, "");
}
});
compararItem.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
     JDialog frameComparar = new JDialogComparar(null,true);
        frameComparar.pack();
        frameComparar.setVisible(true);
}
});

abrirItem.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
          
        JFileChooser chooser = new JFileChooser();
        String path = "";
                
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) 
            path = chooser.getSelectedFile().toString();
        
        EditorTexto doc = new EditorTexto(true, path);
}
});

sair.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tray.remove(trayIcon);
System.exit(0);
}
});
}
//Obtain the image URL
protected static Image createImage(String path, String description) {
String imageURL =  path;
if (imageURL == null) {
System.err.println("Resource not found: " + path);
return null;
} else {
return (new ImageIcon(imageURL, description)).getImage();
}
}
}