/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.bibSys.apresentacao;

import br.unesp.rc.bibSys.utils.EditorTexto;
import br.unesp.rc.bibSys.utils.ManagerGUI;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

/**
 *
 * @author Cesar
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        txaDisplay.setEnabled(false);
        ManagerGUI.centralizar(this);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDisplay = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jmiNovo = new javax.swing.JMenuItem();
        jmiAbrir = new javax.swing.JMenuItem();
        jmiSalvar = new javax.swing.JMenuItem();
        jmiPadronizar = new javax.swing.JMenuItem();
        jmiComparar = new javax.swing.JMenuItem();
        jmiConcatenar = new javax.swing.JMenuItem();
        jmiGerarChave = new javax.swing.JMenuItem();
        jmiOrdenar = new javax.swing.JMenuItem();
        jmiSair = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bibsys");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        txaDisplay.setColumns(20);
        txaDisplay.setRows(5);
        jScrollPane1.setViewportView(txaDisplay);

        jMenu2.setText("Arquivo");

        jmiNovo.setText("Novo");
        jmiNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNovoActionPerformed(evt);
            }
        });
        jMenu2.add(jmiNovo);

        jmiAbrir.setText("Abrir");
        jmiAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAbrirActionPerformed(evt);
            }
        });
        jMenu2.add(jmiAbrir);

        jmiSalvar.setText("Salvar");
        jmiSalvar.setToolTipText("");
        jMenu2.add(jmiSalvar);

        jmiPadronizar.setText("Padronizar");
        jmiPadronizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPadronizarActionPerformed(evt);
            }
        });
        jMenu2.add(jmiPadronizar);

        jmiComparar.setText("Comparar");
        jmiComparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCompararActionPerformed(evt);
            }
        });
        jMenu2.add(jmiComparar);

        jmiConcatenar.setText("Concatenar");
        jmiConcatenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConcatenarActionPerformed(evt);
            }
        });
        jMenu2.add(jmiConcatenar);

        jmiGerarChave.setText("Gerar Chave");
        jmiGerarChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGerarChaveActionPerformed(evt);
            }
        });
        jMenu2.add(jmiGerarChave);

        jmiOrdenar.setText("Ordenar");
        jmiOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOrdenarActionPerformed(evt);
            }
        });
        jMenu2.add(jmiOrdenar);

        jmiSair.setText("Sair");
        jmiSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSairActionPerformed(evt);
            }
        });
        jMenu2.add(jmiSair);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ajuda");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Sobre");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jmiSairActionPerformed

    private void jmiConcatenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConcatenarActionPerformed
        JDialog frameComparar = new JDialogComparar(this,true);
        frameComparar.pack();
        frameComparar.setVisible(true);
    }//GEN-LAST:event_jmiConcatenarActionPerformed

    private void jmiPadronizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPadronizarActionPerformed
        // TODO add your handling code here:
        JDialog framePadronizar =new JDialogPadronizar(this,true);
        framePadronizar.pack();
        framePadronizar.setVisible(true);
    }//GEN-LAST:event_jmiPadronizarActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
    
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
            JDialog Sobre= new JDialogSobre(this,true);
        Sobre.pack();
        Sobre.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmiNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNovoActionPerformed

        EditorTexto doc = new EditorTexto(false, "");
    }//GEN-LAST:event_jmiNovoActionPerformed

    private void jmiAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAbrirActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        String path = "";
                
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) 
        {path = chooser.getSelectedFile().toString();
        
        EditorTexto doc = new EditorTexto(true, path);}
    }//GEN-LAST:event_jmiAbrirActionPerformed

    private void jmiCompararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCompararActionPerformed
        JDialog frameComparar = new JDialogComparar(this,true);
        frameComparar.pack();
        frameComparar.setVisible(true);
    }//GEN-LAST:event_jmiCompararActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jmiOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOrdenarActionPerformed
        JDialog frameOrdenar = new JDialogOrdenar(this,true);
        frameOrdenar.pack();
        frameOrdenar.setVisible(true);
    }//GEN-LAST:event_jmiOrdenarActionPerformed

    private void jmiGerarChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGerarChaveActionPerformed
        JDialog frameGerar = new JDialogGerarBibKey(this,true);
        frameGerar.pack();
        frameGerar.setVisible(true);
    }//GEN-LAST:event_jmiGerarChaveActionPerformed

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmiAbrir;
    private javax.swing.JMenuItem jmiComparar;
    private javax.swing.JMenuItem jmiConcatenar;
    private javax.swing.JMenuItem jmiGerarChave;
    private javax.swing.JMenuItem jmiNovo;
    private javax.swing.JMenuItem jmiOrdenar;
    private javax.swing.JMenuItem jmiPadronizar;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenuItem jmiSalvar;
    private javax.swing.JTextArea txaDisplay;
    // End of variables declaration//GEN-END:variables
}
