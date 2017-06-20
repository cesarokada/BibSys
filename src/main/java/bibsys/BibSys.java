package bibsys;

import br.unesp.rc.bibSys.apresentacao.MainJFrame;
import br.unesp.rc.bibSys.apresentacao.Splash;
import br.unesp.rc.bibSys.utils.TrayGUI;
import static br.unesp.rc.bibSys.utils.TrayGUI.tray_manager;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import javax.swing.JFrame;

public class BibSys {

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new Splash();
      frame.pack();
        frame.setVisible(true);
       Thread.sleep(5000);
       frame.dispose();
       
        frame.setVisible(false);
         TrayGUI.tray_manager();
        JFrame frame_p = new MainJFrame();
       frame_p.pack();
       frame_p.setVisible(true);
    }
    
}
