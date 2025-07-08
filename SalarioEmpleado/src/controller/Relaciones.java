package controller;

import model.Empleado;
import view.EmpleadoView;

public class Relaciones {
    public void iniciar() {

        //instanciar (crear objetos)
        EmpleadoView empleadoView = new EmpleadoView();
        Coordinador coordinador = new Coordinador();
        Empleado empleado = new Empleado();

        //relaciones entre clases
        empleadoView.setCoordinador(coordinador);
        empleado.setCoordinador(coordinador);
        empleadoView.setVisible(true);

        //sets a coordinador
        coordinador.setEmpleado(empleado);
        coordinador.setEmpleadoView(empleadoView);
    }
}
