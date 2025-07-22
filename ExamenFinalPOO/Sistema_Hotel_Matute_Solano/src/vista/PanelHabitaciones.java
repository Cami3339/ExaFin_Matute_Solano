package vista;

import modelo.Habitacion;
import modelo.TipoHabitacion;
import util.ArchivoUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

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

        form.add(new JLabel("Número:"));
        form.add(txtNumero);
        form.add(new JLabel("Tipo:"));
        form.add(cmbTipo);
        form.add(new JLabel(""));
        form.add(btnAgregar);

        modeloTabla = new DefaultTableModel(new String[]{"Número", "Tipo", "Disponible"}, 0);
        tabla = new JTable(modeloTabla);
        cargarEnTabla();

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        btnAgregar.addActionListener(e -> agregar());
    }

    private void agregar() {
        try {
            int numero = Integer.parseInt(txtNumero.getText());
            TipoHabitacion tipo = (TipoHabitacion) cmbTipo.getSelectedItem();
            Habitacion h = new Habitacion(numero, tipo, true);
            lista.add(h);
            ArchivoUtil.guardar(RUTA, lista);
            modeloTabla.addRow(new Object[]{numero, tipo, "Sí"});
            txtNumero.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Número inválido.");
        }
    }

    private void cargarEnTabla() {
        for (Habitacion h : lista) {
            modeloTabla.addRow(new Object[]{h.getNumero(), h.getTipo(), h.isDisponible() ? "Sí" : "No"});
        }
    }
}
