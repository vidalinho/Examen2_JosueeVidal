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
public class AdminAtm implements Serializable {

    private ArrayList<Atm> listaa = new ArrayList();
    private File archivo = null;
    private static final long SerialVersionUID = 777;

    public AdminAtm(String path) {
        archivo = new File(path);
    }

    public ArrayList<Atm> getLista() {
        return listaa;
    }

    public void setLista(ArrayList<Atm> lista) {
        this.listaa = lista;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;

    }

    @Override
    public String toString() {
        return "admin{" + "lista=" + listaa + ", archivo=" + archivo + '}';
    }

    public void setAtm(Atm p) {
        this.listaa.add(p);
    }

    public void cargar() {
        try {
            listaa = new ArrayList();
            Atm temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Atm) objeto.readObject()) != null) {//leeo un archivo binario siempre lanza la exception
                        listaa.add(temp);
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
            for (Atm object : listaa) {
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
