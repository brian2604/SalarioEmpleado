package model.dto;

//AQUITODO LO QUE TENGA QUE VER CON EL GUARDADO DE DATOS
public class EmpleadoDTO {
    private String nombre;
    private String documento;
    private String telefono;
    private String tipoEmp;
    private int horas;
    private double salario;
    private double aumento;
    private double total;

    // Constructor
    public EmpleadoDTO(String documento, String nombre, String telefono, String tipoEmp, int horas) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoEmp = tipoEmp;
        this.horas = horas;
    }


    // Getters
    public String getDocumento() { return documento; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getTipoEmp() { return tipoEmp; }
    public int getHoras() { return horas; }
    public double getSalario() { return salario; }
    public double getAumento() { return aumento; }
    public double getTotal() { return total; }

    //setters
    public void setDocumento(String documento) {this.documento = documento;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public void setTipoEmp(String tipoEmp) {this.tipoEmp = tipoEmp;}
    public void setHoras(int horas) {this.horas = horas;}
    public void setSalario(double salario) { this.salario = salario; }
    public void setAumento(double aumento) { this.aumento = aumento; }
    public void setTotal(double total) { this.total = total; }
}

