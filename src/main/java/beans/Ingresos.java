package beans;

import java.util.Date;

public class Ingresos {

    private Integer idRegistro;
    private String cedula;
    private String fechaLlegada;
    private String fechaSalida;
    private String ciudadOrigen;
    private Integer idHabitacion;

    public Ingresos(Integer idRegistro, String cedula, String fechaLlegada, String fechaSalida, String ciudadOrigen, Integer idHabitacion) {
        this.idRegistro = idRegistro;
        this.cedula = cedula;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.ciudadOrigen = ciudadOrigen;
        this.idHabitacion = idHabitacion;
    }

    public int getIdRegistro() {
        return idRegistro;
    }
    
    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
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
