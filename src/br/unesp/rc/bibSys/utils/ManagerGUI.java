package br.unesp.rc.bibSys.utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author aluno
 */
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
}
