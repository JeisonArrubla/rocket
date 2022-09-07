/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author Jeison
 */
public class Habitaciones {
    
    private Integer id;
    private Integer capacidad;

    public Habitaciones(Integer id, Integer capacidad) {
        this.id = id;
        this.capacidad = capacidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Habitaciones{" + "id=" + id + ", capacidad=" + capacidad + '}';
    }
    
    
    
}
