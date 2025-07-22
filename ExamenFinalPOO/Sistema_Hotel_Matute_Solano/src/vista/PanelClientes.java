package vista;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import modelos.Cliente;
import util.ArchivoUtil;

public class PanelClientes extends JPanel {
    private JTextField txtCedula, txtNombre, txtApellido, txtTelefono;
    private DefaultTableModel modeloTabla;
    private JTable tablaClientes;
    private final String RUTA = "clientes.txt";
    private ArrayList<Cliente> listaClientes;

    public PanelClientes() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 248, 255)); // Fondo general suave

        listaClientes = ArchivoUtil.cargar(RUTA);

        // Panel del formulario
        JPanel formulario = new JPanel(new GridLayout(5, 2, 10, 10));
        formulario.setBorder(new EmptyBorder(15, 20, 15, 20));
        formulario.setBackground(new Color(224, 255, 255));

        JLabel lblCedula = new JLabel("Cédula:");
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblApellido = new JLabel("Apellido:");
        JLabel lblTelefono = new JLabel("Teléfono:");

        Font fuenteCampos = new Font("Segoe UI", Font.PLAIN, 14);
        lblCedula.setFont(fuenteCampos);
        lblNombre.setFont(fuenteCampos);
        lblApellido.setFont(fuenteCampos);
        lblTelefono.setFont(fuenteCampos);

        txtCedula = new JTextField();
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtTelefono = new JTextField();

        txtCedula.setFont(fuenteCampos);
        txtNombre.setFont(fuenteCampos);
        txtApellido.setFont(fuenteCampos);
        txtTelefono.setFont(fuenteCampos);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBackground(new Color(30, 144, 255));
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setFocusPainted(false);
        btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 14));

        formulario.add(lblCedula);
        formulario.add(txtCedula);
        formulario.add(lblNombre);
        formulario.add(txtNombre);
        formulario.add(lblApellido);
        formulario.add(txtApellido);
        formulario.add(lblTelefono);
        formulario.add(txtTelefono);
        formulario.add(new JLabel("")); // espacio vacío
        formulario.add(btnAgregar);

        // Tabla
        modeloTabla = new DefaultTableModel(new String[]{"Cédula", "Nombre", "Apellido", "Teléfono"}, 0);
        tablaClientes = new JTable(modeloTabla);
        tablaClientes.setFillsViewportHeight(true);
        tablaClientes.setFont(fuenteCampos);
        tablaClientes.setRowHeight(22);
        tablaClientes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tablaClientes.getTableHeader().setBackground(new Color(176, 224, 230));
        tablaClientes.setGridColor(new Color(200, 200, 200));

        JScrollPane scrollPane = new JScrollPane(tablaClientes);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Clientes"));

        // Agregar componentes
        add(formulario, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Evento botón
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
