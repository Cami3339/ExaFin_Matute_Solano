package vista;

import modelos.Cliente;
import util.ArchivoUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PanelClientes extends JPanel {
    private JTextField txtCedula, txtNombre, txtApellido, txtTelefono;
    private DefaultTableModel modeloTabla;
    private JTable tablaClientes;
    private final String RUTA = "clientes.txt";
    private ArrayList<Cliente> listaClientes;

    public PanelClientes() {
        setLayout(new BorderLayout());

        listaClientes = ArchivoUtil.cargar(RUTA);

        JPanel formulario = new JPanel(new GridLayout(5, 2));
        txtCedula = new JTextField();
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtTelefono = new JTextField();
        JButton btnAgregar = new JButton("Agregar");

        formulario.add(new JLabel("Cédula:"));
        formulario.add(txtCedula);
        formulario.add(new JLabel("Nombre:"));
        formulario.add(txtNombre);
        formulario.add(new JLabel("Apellido:"));
        formulario.add(txtApellido);
        formulario.add(new JLabel("Teléfono:"));
        formulario.add(txtTelefono);
        formulario.add(new JLabel(""));
        formulario.add(btnAgregar);

        modeloTabla = new DefaultTableModel(new String[]{"Cédula", "Nombre", "Apellido", "Teléfono"}, 0);
        tablaClientes = new JTable(modeloTabla);
        cargarClientesEnTabla();

        add(formulario, BorderLayout.NORTH);
        add(new JScrollPane(tablaClientes), BorderLayout.CENTER);

        btnAgregar.addActionListener(e -> agregarCliente());
    }

    private void agregarCliente() {
        if (txtCedula.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }

        Cliente c = new Cliente(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), txtTelefono.getText());
        listaClientes.add(c);
        ArchivoUtil.guardar(RUTA, listaClientes);
        modeloTabla.addRow(new Object[]{c.getCedula(), c.getNombre(), c.getApellido(), c.getTelefono()});
        limpiarFormulario();
    }

    private void cargarClientesEnTabla() {
        for (Cliente c : listaClientes) {
            modeloTabla.addRow(new Object[]{c.getCedula(), c.getNombre(), c.getApellido(), c.getTelefono()});
        }
    }

    private void limpiarFormulario() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
    }
}
