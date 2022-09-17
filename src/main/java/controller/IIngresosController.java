package controller;

public interface IIngresosController {

    public String registrarIngreso(String cedula, String fechaLlegada, String fechaSalida, String ciudadOrigen, int idHabitacion);
    
}
