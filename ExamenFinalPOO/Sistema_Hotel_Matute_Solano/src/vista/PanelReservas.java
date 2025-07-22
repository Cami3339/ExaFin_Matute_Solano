package vista;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelos.Cliente;
import modelos.Habitacion;
import modelos.Reserva;
import util.ArchivoUtil;

public class PanelReservas extends JPanel {
    private JComboBox<String> cmbClientes;
    private JComboBox<Integer> cmbHabitaciones;
    private JTextField txtFechaInicio, txtFechaFin;
    private JLabel lblTotal;
    private DefaultTableModel modeloTabla;
    private JTable tabla;

    private final String RUTA_RESERVAS = "reservas.txt";
    private final String RUTA_CLIENTES = "clientes.txt";
    private final String RUTA_HABITACIONES = "habitaciones.txt";

    private ArrayList<Reserva> reservas;
    private ArrayList<Cliente> clientes;
    private ArrayList<Habitacion> habitaciones;

    public PanelReservas() {
        setLayout(new BorderLayout());

        reservas = ArchivoUtil.cargar(RUTA_RESERVAS);
        clientes = ArchivoUtil.cargar(RUTA_CLIENTES);
        habitaciones = ArchivoUtil.cargar(RUTA_HABITACIONES);

        Color fondo = new Color(250, 250, 255);
        Color azul = new Color(63, 81, 181);
        Font fuente = new Font("Segoe UI", Font.PLAIN, 14);

        JPanel form = new JPanel(new GridLayout(6, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 40, 10, 40));
        form.setBackground(fondo);

        cmbClientes = new JComboBox<>();
        cmbHabitaciones = new JComboBox<>();
        txtFechaInicio = new JTextField();
        txtFechaFin = new JTextField();
        lblTotal = new JLabel("Total: $0.00");
        JButton btnReservar = new JButton("Reservar");

        for (Component comp : new Component[]{cmbClientes, cmbHabitaciones, txtFechaInicio, txtFechaFin, btnReservar}) {
            comp.setFont(fuente);
        }

        lblTotal.setFont(fuente);
        lblTotal.setForeground(new Color(56, 142, 60)); // verde

        form.add(new JLabel("Cliente:")).setFont(fuente);
        form.add(cmbClientes);
        form.add(new JLabel("Habitación #:")).setFont(fuente);
        form.add(cmbHabitaciones);
        form.add(new JLabel("Fecha inicio (yyyy-mm-dd):")).setFont(fuente);
        form.add(txtFechaInicio);
        form.add(new JLabel("Fecha fin (yyyy-mm-dd):")).setFont(fuente);
        form.add(txtFechaFin);
        form.add(new JLabel(""));
        form.add(lblTotal);
        form.add(new JLabel(""));
        form.add(btnReservar);

        modeloTabla = new DefaultTableModel(new String[]{"Cliente", "Hab#", "Inicio", "Fin", "Total"}, 0);
        tabla = new JTable(modeloTabla);
        tabla.setFont(fuente);
        tabla.setRowHeight(22);
        tabla.getTableHeader().setFont(fuente.deriveFont(Font.BOLD));
        cargarDatosEnCombos();
        cargarTabla();

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        setBackground(fondo);

        btnReservar.setBackground(azul);
        btnReservar.setForeground(Color.WHITE);
        btnReservar.setFocusPainted(false);
        btnReservar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnReservar.addActionListener(e -> reservar());
    }

    private void cargarDatosEnCombos() {
        for (Cliente c : clientes) {
            cmbClientes.addItem(c.getCedula() + " - " + c.getNombre());
        }
        for (Habitacion h : habitaciones) {
            if (h.isDisponible()) {
                cmbHabitaciones.addItem(h.getNumero());
            }
        }
    }

    private void cargarTabla() {
        for (Reserva r : reservas) {
            modeloTabla.addRow(new Object[]{
                r.getCliente().getNombre(),
                r.getHabitacion().getNumero(),
                r.getFechaInicio(),
                r.getFechaFin(),
                "$" + r.calcularTotal()
            });
        }
    }

    private void reservar() {
        try {
            String cedula = cmbClientes.getSelectedItem().toString().split(" - ")[0];
            Cliente cliente = clientes.stream()
                .filter(c -> c.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);

            int numHab = (int) cmbHabitaciones.getSelectedItem();
            Habitacion habitacion = habitaciones.stream()
                .filter(h -> h.getNumero() == numHab)
                .findFirst()
                .orElse(null);

            LocalDate inicio = LocalDate.parse(txtFechaInicio.getText());
            LocalDate fin = LocalDate.parse(txtFechaFin.getText());

            if (inicio.isAfter(fin)) {
                JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser después de la fecha de fin.");
                return;
            }

            for (Reserva r : reservas) {
                if (r.getHabitacion().getNumero() == numHab) {
                    if (!(fin.isBefore(r.getFechaInicio()) || inicio.isAfter(r.getFechaFin()))) {
                        JOptionPane.showMessageDialog(this, "La habitación ya está reservada en ese rango de fechas.");
                        return;
                    }
                }
            }

            Reserva nueva = new Reserva(cliente, habitacion, inicio, fin);
            reservas.add(nueva);
            ArchivoUtil.guardar(RUTA_RESERVAS, reservas);

            modeloTabla.addRow(new Object[]{
                cliente.getNombre(),
                habitacion.getNumero(),
                inicio.toString(),
                fin.toString(),
                "$" + nueva.calcularTotal()
            });

            lblTotal.setText("Total: $" + nueva.calcularTotal());
            limpiarCampos();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: verifique que los campos estén completos y válidos.");
        }
    }

    private void limpiarCampos() {
        txtFechaInicio.setText("");
        txtFechaFin.setText("");
    }
}
