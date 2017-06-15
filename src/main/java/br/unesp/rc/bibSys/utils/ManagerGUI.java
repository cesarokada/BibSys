package br.unesp.rc.bibSys.utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ManagerGUI {

    public static void centralizar(JFrame frame) {

        Dimension screenSize
                = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(
                (screenSize.width - frame.getWidth()) / 2,
                (screenSize.height - frame.getHeight()) / 2
        );
    }

    public static void centralizar(JDialog frame) {

        Dimension screenSize
                = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(
                (screenSize.width - frame.getWidth()) / 2,
                (screenSize.height - frame.getHeight()) / 2
        );
    }
    
    public static String abrirSeletorArquivo(){
        JFileChooser fileInput = new JFileChooser();
        fileInput.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i= fileInput.showSaveDialog(null);
        File arquivo = fileInput.getSelectedFile();
        
        return arquivo == null ? "" : arquivo.getPath();
    }
}
