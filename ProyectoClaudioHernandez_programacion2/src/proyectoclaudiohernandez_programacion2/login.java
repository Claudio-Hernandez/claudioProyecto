/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclaudiohernandez_programacion2;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Claudio Hernandez
 */
public class login extends javax.swing.JFrame {

    ArrayList<usuarios> usuarios = new ArrayList();
    public usuarios usuarioActual;
    Dba db = new Dba("./base1.mdb");
    ResultSet rs;
    int NoUsuarios;
    public  int primeravez=0;
    /**
     * Creates new form login
     */
    public login() {

        initComponents();
        
        usuarios.add(new usuarios("claudio", "claudioben10"));
        usuarios.get(0).setAdminOno(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logoWindows = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        contraseñaUsuario = new javax.swing.JTextField();
        usuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        logoWindows.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenesLogin/windows(3).png"))); // NOI18N

        jToggleButton1.setBackground(new java.awt.Color(0, 153, 204));
        jToggleButton1.setText("Iniciar Sesion");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        contraseñaUsuario.setBackground(new java.awt.Color(0, 102, 102));

        usuario.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(jToggleButton1)
                .addGap(219, 219, 219))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 241, Short.MAX_VALUE)
                .addComponent(logoWindows, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(contraseñaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addComponent(usuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(logoWindows)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(contraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton1)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        String u = usuario.getText();
        String c = contraseñaUsuario.getText();

        db.conectar();
        try {
            db.query.execute("select count(*) from alumnos where usuario= '" + u + "' and contraseña='" + c + "'");
            rs = db.query.getResultSet();
            int res = 0;
            while (rs.next()) {
                res = rs.getInt(1);
            }
            if (res == 0) {

                JOptionPane.showMessageDialog(this, "Este usuario no existe, se te creara una cuenta");
                db.query.execute("INSERT INTO alumnos"
                        + " (usuario,contraseña)"
                        + " VALUES ( '" + u + "','" + c + "')");
                db.commit();
                usuarios.add(new usuarios(u, c));
                usuarios.get(usuarios.size() - 1).setAdminOno(false);
                usuarioActual = usuarios.get(usuarios.size() - 1);

                File dir = new File("./z" + "/" + usuarioActual.getUsuario());
                boolean fueCreado = dir.mkdir();
                if (fueCreado) {
                    JOptionPane.showMessageDialog(this,
                            "Directorio Creado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(this,
                            "El directorio no fue creado");
                }
                File dir2 = new File("./z" + "/" + usuarioActual.getUsuario()+"/"+"Mis documentos");
                File dir3 = new File("./z" + "/" + usuarioActual.getUsuario()+"/"+"Mis imagenes");
                File dir4 = new File("./z" + "/" + usuarioActual.getUsuario()+"/"+"Mi musica");
                File dir5 = new File("./z" + "/" + usuarioActual.getUsuario()+"/"+"Mi calendario");
                File dir6 = new File("./z" + "/" + usuarioActual.getUsuario()+"/"+"Mis correos");
                File dir7 = new File("./z" + "/" + usuarioActual.getUsuario()+"/"+"Mis mensajes");
                dir2.mkdir();
                dir3.mkdir();
                dir4.mkdir();
                dir5.mkdir();
                dir6.mkdir();
                dir7.mkdir();
                if (primeravez==0) {
                    escritorio esc = new escritorio();
                esc.setVisible(true);
                this.dispose();
                }else if(primeravez==1){
                    this.dispose();
                }
                

            } else if (res != 0 && u.equals("claudio") && c.equals("claudioben10")) {
                usuarioActual = usuarios.get(0);
                JOptionPane.showMessageDialog(this, "Bienvenido:" + u + "!");
                usuarioActual.setAdminOno(true);
                
                File dir = new File("C:/Users/Claudio Hernandez/OneDrive/Desktop/proyecto/claudioProyecto/ProyectoClaudioHernandez_programacion2/z" + "/" + usuarioActual.getUsuario());
                boolean fueCreado = dir.mkdir();
                File dir2 = new File("./z" + "/" + usuarioActual.getUsuario()+"/"+"Mis documentos");
                File dir3 = new File("./z" + "/" + usuarioActual.getUsuario()+"/"+"Mis imagenes");
                File dir4 = new File("./z" + "/" + usuarioActual.getUsuario()+"/"+"Mi musica");
                File dir5 = new File("./z" + "/" + usuarioActual.getUsuario()+"/"+"Mi calendario");
                File dir6 = new File("./z" + "/" + usuarioActual.getUsuario()+"/"+"Mis correos");
                File dir7 = new File("./z" + "/" + usuarioActual.getUsuario()+"/"+"Mis mensajes");
                dir2.mkdir();
                dir3.mkdir();
                dir4.mkdir();
                dir5.mkdir();
                dir6.mkdir();
                dir7.mkdir();
                if (fueCreado) {
                    JOptionPane.showMessageDialog(this,
                            "Directorio Creado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(this,
                            "El directorio no fue creado");
                }
                if (primeravez==0) {
                    escritorio esc = new escritorio();
                esc.setVisible(true);
                this.dispose();
                }else if(primeravez==1){
                    this.dispose();
                }
                
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();

        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contraseñaUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel logoWindows;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
