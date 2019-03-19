/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

/**
 *
 * @author Gaby
 */
public class empleado {
 private int ID;
 private String nombre;
 private String Direccion;
 private String celular;

    public empleado() {
    }

    public empleado(int ID, String nombre, String Direccion, String celular) {
        this.ID = ID;
        this.nombre = nombre;
        this.Direccion = Direccion;
        this.celular = celular;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "empleado{" + "ID=" + ID + ", nombre=" + nombre + ", Direccion=" + Direccion + ", celular=" + celular + '}';
        }
    }

