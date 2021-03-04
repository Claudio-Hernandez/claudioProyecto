/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclaudiohernandez_programacion2;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

/**
 *
 * @author Claudio Hernandez
 */
public class usuarios {

    private String usuario;
    private String contraseña;
    public JTree archivos = new JTree();
    private boolean adminOno;

    public usuarios() {
    }

    public usuarios(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        

    }
    public DefaultMutableTreeNode mandarNodo (){
    DefaultTreeModel m = (DefaultTreeModel) archivos.getModel();

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) m.getRoot();
        DefaultMutableTreeNode nodoArchivos1 = new DefaultMutableTreeNode(usuario.toString());
        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("Mis Documentos");
        DefaultMutableTreeNode ni = new DefaultMutableTreeNode("Mis Imagenes");
        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("Mi musica");
        DefaultMutableTreeNode n4 = new DefaultMutableTreeNode("Mis mensajes");
        DefaultMutableTreeNode n5 = new DefaultMutableTreeNode("Envio de correo");
        DefaultMutableTreeNode n6 = new DefaultMutableTreeNode("Mi calendario");

        nodoArchivos1.add(n2);
        nodoArchivos1.add(ni);
        nodoArchivos1.add(n6);
       nodoArchivos1.add(n3);
       nodoArchivos1.add(n4);
       nodoArchivos1.add(n5);
       raiz.add(nodoArchivos1);
       return nodoArchivos1;
    
    
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public JTree getArchivos() {
        return archivos;
    }

    public void setArchivos(JTree archivos) {
        this.archivos = archivos;
    }

    public boolean isAdminOno() {
        return adminOno;
    }

    public void setAdminOno(boolean adminOno) {
        this.adminOno = adminOno;
    }

}
