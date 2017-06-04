package br.unesp.rc.bibSys.utils;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class EditorTexto extends JFrame implements ActionListener
{
    private JTextArea ta;
    private int count;
    private JMenuBar menuBar;
    private JMenu fileM,editM,viewM;
    private JScrollPane scpane;
    private JMenuItem exitI,cutI,copyI,pasteI,selectI,saveI,loadI,statusI;
    private String pad;
    private JToolBar toolBar;
    
    private String _pathFile = "";


    public EditorTexto(boolean isEditar, String path){
        super("Document");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        count = 0;
        pad = " ";
        ta = new JTextArea(); //textarea
        menuBar = new JMenuBar(); //menubar
        fileM = new JMenu("File"); //file menu
        editM = new JMenu("Edit"); //edit menu
        viewM = new JMenu("View"); //edit menu
        scpane = new JScrollPane(ta); //scrollpane  and add textarea to scrollpane
        exitI = new JMenuItem("Exit");
        cutI = new JMenuItem("Cut");
        copyI = new JMenuItem("Copy");
        pasteI = new JMenuItem("Paste");
        selectI = new JMenuItem("Select All"); //menuitems
        saveI = new JMenuItem("Save"); //menuitems
        loadI = new JMenuItem("Load"); //menuitems
        statusI = new JMenuItem("Status"); //menuitems
        toolBar = new JToolBar();

        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);

        setJMenuBar(menuBar);
        menuBar.add(fileM);
        menuBar.add(editM);
        menuBar.add(viewM);

        fileM.add(saveI);
        fileM.add(loadI);
        fileM.add(exitI);

        editM.add(cutI);
        editM.add(copyI);
        editM.add(pasteI);        
        editM.add(selectI);

        viewM.add(statusI);

        saveI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        loadI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        cutI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        copyI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        pasteI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        selectI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

        pane.add(scpane,BorderLayout.CENTER);
        pane.add(toolBar,BorderLayout.SOUTH);

        saveI.addActionListener(this);
        loadI.addActionListener(this);
        exitI.addActionListener(this);
        cutI.addActionListener(this);
        copyI.addActionListener(this);
        pasteI.addActionListener(this);
        selectI.addActionListener(this);
        statusI.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        EscreverArquivo(isEditar, path);
    }

    private void EscreverArquivo(boolean isEditar, String path) {
        _pathFile = isEditar ? path : "";
        if(isEditar){
            try {
                ta.setText(ArquivosUtils.lerArquivo(_pathFile));
            } catch (IOException ex) {
                Logger.getLogger(EditorTexto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JMenuItem choice = (JMenuItem) e.getSource();
        if (choice == saveI)
        {
            if(_pathFile.equals("")){
                JFileChooser chooser = new JFileChooser();
                if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) 
                    try {
                        _pathFile = ArquivosUtils.escreverArquivo(chooser.getSelectedFile().toString(), ta.getText());
                } catch (IOException ex) {
                    Logger.getLogger(EditorTexto.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    ArquivosUtils.escreverArquivo(_pathFile, ta.getText());
                } catch (IOException ex) {
                    Logger.getLogger(EditorTexto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if (choice == exitI)
            System.exit(0);
        else if (choice == cutI)
        {
            pad = ta.getSelectedText();
            ta.replaceRange("", ta.getSelectionStart(), ta.getSelectionEnd());
        }
        else if (choice == copyI)
            pad = ta.getSelectedText();
        else if (choice == pasteI)
            ta.insert(pad, ta.getCaretPosition());
        else if (choice == selectI)
            ta.selectAll();
        else if (e.getSource() == statusI)
        {
            //not yet implmented
        }
    }
}