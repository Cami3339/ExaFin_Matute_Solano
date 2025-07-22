package vista;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelos.Habitacion;
import modelos.TipoHabitacion;
import util.ArchivoUtil;
public class PanelHabitaciones extends JPanel {
    private JTextField txtNumero;
    private JComboBox<TipoHabitacion> cmbTipo;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private final String RUTA = "habitaciones.txt";
    private ArrayList<Habitacion> lista;
    public PanelHabitaciones() {
        setLayout(new BorderLayout());
        lista = ArchivoUtil.cargar(RUTA);
        JPanel form = new JPanel(new GridLayout(3, 2));
        txtNumero = new JTextField();
        cmbTipo = new JComboBox<>(TipoHabitacion.values());
        JButton btnAgregar = new JButton("Agregar");

        // Agregar componentes al formulario
        form.add(new JLabel("Número:"));
        form.add(txtNumero);
        form.add(new JLabel("Tipo:"));
        form.add(cmbTipo);
        form.add(new JLabel("")); // celda vacía
        form.add(btnAgregar);

        // Crear modelo de tabla y la tabla
        modeloTabla = new DefaultTableModel(new String[]{"Número", "Tipo", "Disponible"}, 0);
        tabla = new JTable(modeloTabla);
        cargarEnTabla(); // Cargar los datos iniciales

        // Agregar componentes al panel principal
        add(form, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // Acción al presionar el botón Agregar
        btnAgregar.addActionListener(e -> agregar());
    }

    /**
     * Agrega una nueva habitación a la lista y actualiza la tabla.
     */
    private void agregar() {
        try {
            int numero = Integer.parseInt(txtNumero.getText().trim());
            TipoHabitacion tipo = (TipoHabitacion) cmbTipo.getSelectedItem();

            // Crear nueva habitación
            Habitacion h = new Habitacion(numero, tipo, true);
            lista.add(h);

            // Guardar en archivo
            ArchivoUtil.guardar(RUTA, lista);

            // Agregar a la tabla visual
            modeloTabla.addRow(new Object[]{numero, tipo, "Sí"});

            // Limpiar campo de texto
            txtNumero.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Número inválido.");
        }
    }

    /**
     * Carga la lista de habitaciones en la tabla visual.
     */
    private void cargarEnTabla() {
        for (Habitacion h : lista) {
            modeloTabla.addRow(new Object[]{
                h.getNumero(),
                h.getTipo(),
                h.isDisponible() ? "Sí" : "No"
            });
        }
    }
}
