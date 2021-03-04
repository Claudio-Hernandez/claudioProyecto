package proyectoclaudiohernandez_programacion2;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class visor extends javax.swing.JFrame {

    ArrayList<ImageIcon> imagenes = new ArrayList();
    public int cont = 0;
    public int alEntrar = 0;

    public visor() {
        initComponents();
        this.setTitle("VISOR");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        imagenTal = new javax.swing.JLabel();
        botonAgregarImagen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        visorTexto = new javax.swing.JTextArea();
        siguiente = new javax.swing.JButton();
        anterior = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesVisor/iconfinder_expand-color-web-25_5014980.png"))); // NOI18N
        jButton3.setBorder(new javax.swing.border.MatteBorder(null));
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 70, 40));

        imagenTal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagenTal.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 0, 204)));
        jPanel1.add(imagenTal, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 380, 280));

        botonAgregarImagen.setBackground(new java.awt.Color(0, 0, 0));
        botonAgregarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoclaudiohernandez_programacion2/imagenes/files(1).png"))); // NOI18N
        botonAgregarImagen.setBorder(new javax.swing.border.MatteBorder(null));
        botonAgregarImagen.setBorderPainted(false);
        botonAgregarImagen.setContentAreaFilled(false);
        botonAgregarImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAgregarImagenMouseClicked(evt);
            }
        });
        jPanel1.add(botonAgregarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 30));

        visorTexto.setBackground(new java.awt.Color(0, 0, 0));
        visorTexto.setColumns(20);
        visorTexto.setForeground(new java.awt.Color(102, 0, 204));
        visorTexto.setRows(5);
        jScrollPane1.setViewportView(visorTexto);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, 260));

        siguiente.setBackground(new java.awt.Color(0, 0, 0));
        siguiente.setForeground(new java.awt.Color(51, 0, 102));
        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesVisor/next.png"))); // NOI18N
        siguiente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 204)));
        siguiente.setBorderPainted(false);
        siguiente.setContentAreaFilled(false);
        siguiente.setEnabled(false);
        siguiente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesVisor/next(1).png"))); // NOI18N
        siguiente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesVisor/next(1).png"))); // NOI18N
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });
        jPanel1.add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 120, 100));

        anterior.setBackground(new java.awt.Color(0, 0, 0));
        anterior.setForeground(new java.awt.Color(51, 0, 102));
        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesVisor/previous.png"))); // NOI18N
        anterior.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 204)));
        anterior.setBorderPainted(false);
        anterior.setContentAreaFilled(false);
        anterior.setEnabled(false);
        anterior.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesVisor/previous(1).png"))); // NOI18N
        anterior.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesVisor/previous(1).png"))); // NOI18N
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        jPanel1.add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 120, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed

        if (cont == imagenes.size() - 1) {

            cont = -1;

        }
        cont++;

        imagenTal.setIcon(imagenes.get(cont));


    }//GEN-LAST:event_siguienteActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        if (cont == 0) {

            cont = imagenes.size();
        }
        cont--;

        imagenTal.setIcon(imagenes.get(cont));


    }//GEN-LAST:event_anteriorActionPerformed

    private void botonAgregarImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAgregarImagenMouseClicked
        FileInputStream entrada = null;
        ObjectInputStream objeto = null;
        File fichero;
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("claudio", "jpg", "png");
        jfc.setFileFilter(filtro);
        int seleccion ;
        try {
            if (alEntrar == 0) {
                if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    fichero = jfc.getSelectedFile();

                    imagenes.add(new ImageIcon(fichero.getPath()));
                    visorTexto.append(fichero.getName() + "\n");

                    imagenTal.setIcon(imagenes.get(0));
                    alEntrar++;

                }
            } else {
                siguiente.setEnabled(true);
                anterior.setEnabled(true);
                if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    fichero = jfc.getSelectedFile();

                    imagenes.add(new ImageIcon(fichero.getPath()));
                    visorTexto.append(fichero.getName() + "\n");

                    imagenTal.setIcon(imagenes.get(0));
                }

            }

        } catch (Exception e) {
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_botonAgregarImagenMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton3MouseClicked

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
                if ("Dark Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(visor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(visor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(visor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(visor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new visor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JButton botonAgregarImagen;
    private javax.swing.JLabel imagenTal;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton siguiente;
    private javax.swing.JTextArea visorTexto;
    // End of variables declaration//GEN-END:variables
}
