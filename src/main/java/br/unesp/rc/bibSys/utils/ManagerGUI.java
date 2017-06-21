package br.unesp.rc.bibSys.utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ManagerGUI {
    /**
     * Centraliza o Jframe
     * 
     * @param frame Jframe a ser centralizado
     */
    public static void centralizar(JFrame frame) {

        Dimension screenSize
                = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(
                (screenSize.width - frame.getWidth()) / 2,
                (screenSize.height - frame.getHeight()) / 2
        );
    }
    /**
     * Centraliza o JDialog
     * 
     * @param frame JDialog a ser centralizado
     */
    public static void centralizar(JDialog frame) {

        Dimension screenSize
                = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(
                (screenSize.width - frame.getWidth()) / 2,
                (screenSize.height - frame.getHeight()) / 2
        );
    }
    /**
     * Abre o seletor de arquivos 
     * 
     * @return caminho do arquivc
     */
    public static String abrirSeletorArquivo(){
        JFileChooser fileInput = new JFileChooser();
        fileInput.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i= fileInput.showSaveDialog(null);
        File arquivo = fileInput.getSelectedFile();
        
        return arquivo == null ? "" : arquivo.getPath();
    }
}
