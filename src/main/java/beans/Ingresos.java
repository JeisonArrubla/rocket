package beans;

import java.util.Date;

public class Ingresos {
    
    private String cedula;
    private Date fechaLlegada;
    private Date fechaSalida;
    private String ciudadOrigen;
    private Integer idHabitacion;

    public Ingresos(String cedula, Date fechaLlegada, Date fechaSalida, String ciudadOrigen, Integer idHabitacion) {
        this.cedula = cedula;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.ciudadOrigen = ciudadOrigen;
        this.idHabitacion = idHabitacion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    @Override
    public String toString() {
        return "Ingresos{" + "cedula=" + cedula + ", fechaLlegada=" + fechaLlegada + ", fechaSalida=" + fechaSalida + ", ciudadOrigen=" + ciudadOrigen + ", idHabitacion=" + idHabitacion + '}';
    }

}
