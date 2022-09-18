package controller;

import java.util.Date;

public interface IIngresosController {

    public String registrarIngreso(String cedula, Date fechaLlegada, Date fechaSalida, String ciudadOrigen, int idHabitacion);
    
}
