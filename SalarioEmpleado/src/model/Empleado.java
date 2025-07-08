package model;
/*AQUI LA LOGICA, OPERACIONES BLA BLA BLA*/
import model.dao.EmpleadoDAO;
import model.dto.EmpleadoDTO;
import controller.Coordinador;


public class Empleado {

    private EmpleadoDTO dto;
    private Coordinador coordinador;

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public double calcularSalario() {
        switch (dto.getTipoEmp().toLowerCase()) {
            case "planta":
                return 800000;
            case "contratista":
                return 600000;
            case "por horas":
                return dto.getHoras()*20000;
            default:
                return 0;
        }
    }

    public double calcularAumento() {
        double salario = calcularSalario();
        switch (dto.getTipoEmp().toLowerCase()) {
            case "planta":
                return salario * 0.15;
            case "contratista":
                return salario * 0.10;
            case "por horas":
                return salario * 0.5;
            default:
                return 0;
        }
    }


    public String registrarEmpleado(String documento, String nombre, String telefono, String tipoEmpleado, int horas) {
        EmpleadoDAO dao = new EmpleadoDAO();
        this.dto = new EmpleadoDTO(documento, nombre, telefono, tipoEmpleado, horas);
        double salario = calcularSalario();
        double aumento = calcularAumento();
        double total = salario + aumento;

        dto.setSalario(salario);
        dto.setAumento(aumento);
        dto.setTotal(total);

        dao.registrarEmpleado(dto);

        return "Empleado: " + nombre +
                "\nTipo: " + tipoEmpleado +
                "\nSalario base: " + salario +
                "\nAumento: " + aumento +
                "\nTotal a pagar: " + total;
    }
}