/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exaameen2_josuevidal;

import java.io.Serializable;

/**
 *
 * @author josue
 */
public class Atm implements Serializable {

    private String ubicacion;
    private int id;
    private int creacion;
    private String mantenimiento;
    private static final long SerialVersionUID = 777;

    public Atm(String ubicacion, int id, int creacion, String mantenimiento) {
        this.ubicacion = ubicacion;
        this.id = id;
        this.creacion = creacion;
        this.mantenimiento = mantenimiento;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreacion() {
        return creacion;
    }

    public void setCreacion(int creacion) {
        this.creacion = creacion;
    }

    public String getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(String mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    @Override
    public String toString() {
        return "Atm{" + "ubicacion=" + ubicacion + ", id=" + id + ", creacion=" + creacion + ", mantenimiento=" + mantenimiento + '}';
    }
    

}
