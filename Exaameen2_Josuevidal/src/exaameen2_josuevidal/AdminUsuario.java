/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exaameen2_josuevidal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author josue
 */
public class AdminUsuario implements Serializable {

    private ArrayList<Usuario> lista = new ArrayList();
    private File archivo = null;
    private static final long SerialVersionUID = 777;

    public AdminUsuario(String path) {
        archivo = new File(path);
    }

    public ArrayList<Usuario> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Usuario> lista) {
        this.lista = lista;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;

    }

    @Override
    public String toString() {
        return "admin{" + "lista=" + lista + ", archivo=" + archivo + '}';
    }

    public void setUsuario(Usuario p) {
        this.lista.add(p);
    }

    public void cargar() {
        try {
            lista = new ArrayList();
            Usuario temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Usuario) objeto.readObject()) != null) {//leeo un archivo binario siempre lanza la exception
                        lista.add(temp);
                    }
                } catch (Exception e) {
                }
                objeto.close();
                entrada.close();
            }
        } catch (Exception e) {
        }

    }//fin de cargar archivo

    public void escribir() {
        FileOutputStream fo = null;
        ObjectOutputStream oo = null;
        try {
            fo = new FileOutputStream(archivo);
            oo = new ObjectOutputStream(fo);
            for (Usuario object : lista) {
                oo.writeObject(object);

            }
            oo.flush();
        } catch (Exception e) {
        } finally {
            try {
                fo.close();
                oo.close();
            } catch (Exception e) {
            }

        }

    }
}
