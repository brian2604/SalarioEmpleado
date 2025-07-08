package controller;

import model.Empleado;
import view.EmpleadoView;

public class Coordinador {

    private Empleado empleado;
    private EmpleadoView empleadoView;

    //get empleado y empleadoView
    public EmpleadoView getEmpleadoView() { return empleadoView; }
    public Empleado getEmpleado() { return empleado; }

    //set empleado y empleadoView

    public void setEmpleado(Empleado empleado) { this.empleado = empleado;}
    public void setEmpleadoView(EmpleadoView empleadoView) { this.empleadoView = empleadoView; }

    public String registrarEmpleado(String documento, String nombre, String telefono, String tipoEmpleado, int horas) {
        return empleado.registrarEmpleado(documento, nombre,telefono,tipoEmpleado,horas);
    }
}