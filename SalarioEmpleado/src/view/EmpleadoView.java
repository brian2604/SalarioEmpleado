package view;

import javax.swing.*;

import controller.Coordinador;
import java.awt.event.ItemEvent;

public class EmpleadoView extends JFrame {
    private JTextField txtDocumento, txtNombre, txtTelefono, txtHoras, txtSalario, txtAumento;
    private JComboBox<String> cbTipo;
    private JTextArea output;
    private Coordinador coordinador;

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public EmpleadoView() {
        setTitle("REGISTRO DE SALARIO DE EMPLEADOS");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel l1 = new JLabel("Documento:");
        l1.setBounds(40, 30, 100, 25);
        add(l1);
        txtDocumento = new JTextField();
        txtDocumento.setBounds(150, 30, 250, 25);
        add(txtDocumento);

        JLabel l2 = new JLabel("Nombre:");
        l2.setBounds(40, 70, 100, 25);
        add(l2);
        txtNombre = new JTextField();
        txtNombre.setBounds(150, 70, 250, 25);
        add(txtNombre);

        JLabel l3 = new JLabel("Teléfono:");
        l3.setBounds(40, 110, 100, 25);
        add(l3);
        txtTelefono = new JTextField();
        txtTelefono.setBounds(150, 110, 250, 25);
        add(txtTelefono);

        JLabel l4 = new JLabel("Tipo:");
        l4.setBounds(40, 150, 100, 25);
        add(l4);
        cbTipo = new JComboBox<>(new String[]{"Planta", "Contratista", "Por horas"});
        cbTipo.setBounds(150, 150, 250, 25);
        add(cbTipo);

        JLabel l5 = new JLabel("Horas:");
        l5.setBounds(40, 190, 100, 25);
        add(l5);
        txtHoras = new JTextField();
        txtHoras.setBounds(150, 190, 250, 25);
        add(txtHoras);
        txtHoras.setEnabled(false);

        cbTipo.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String seleccionado = (String) cbTipo.getSelectedItem();
                if ("Por Horas".equalsIgnoreCase(seleccionado)) {
                    txtHoras.setEnabled(true);
                } else {
                    txtHoras.setEnabled(false);
                    txtHoras.setText(""); // Limpiar si no aplica
                }
            }
        });

        JLabel l6 = new JLabel("Salario:");
        l6.setBounds(40, 230, 100, 25);
        add(l6);
        txtSalario = new JTextField();
        txtSalario.setBounds(150, 230, 250, 25);
        txtSalario.setEditable(false);
        add(txtSalario);

        JLabel l7 = new JLabel("Aumento:");
        l7.setBounds(40, 270, 100, 25);
        add(l7);
        txtAumento = new JTextField("0.0");
        txtAumento.setBounds(150, 270, 250, 25);
        txtAumento.setEditable(false);
        add(txtAumento);

        JButton btnProcesar = new JButton("Procesar");
        btnProcesar.setBounds(150, 310, 120, 30);
        btnProcesar.addActionListener(e -> {
            int doc = Integer.parseInt(txtDocumento.getText());
            String nombre = txtNombre.getText();
            String documento = txtDocumento.getText();
            String telefono = txtTelefono.getText();
            String tipoEmpleado = cbTipo.getSelectedItem().toString();
            int horas = txtHoras.isEnabled() && !txtHoras.getText().isEmpty() ?
                    Integer.parseInt(txtHoras.getText()) : 0;
            String resultado = coordinador.registrarEmpleado(documento, nombre, telefono, tipoEmpleado, horas);
            output.setText(resultado);
            String[] partes = resultado.split("\n");
            String salarioStr = partes[2].split(":")[1].trim().replace("$", "");
            String aumentoStr = partes[3].split(":")[1].trim().replace("$", "");
            txtSalario.setText(salarioStr);
            txtAumento.setText(aumentoStr);
        });
        add(btnProcesar);

        output = new JTextArea();
        output.setBounds(450, 30, 300, 400);
        output.setEditable(false);
        add(output);

        setVisible(true);
    }
}