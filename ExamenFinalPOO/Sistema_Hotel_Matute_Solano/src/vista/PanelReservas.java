package vista;

import modelos.Cliente;
import modelos.Habitacion;
import modelos.Reserva;
import util.ArchivoUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

        JPanel form = new JPanel(new GridLayout(6, 2));
        cmbClientes = new JComboBox<>();
        cmbHabitaciones = new JComboBox<>();
        txtFechaInicio = new JTextField();
        txtFechaFin = new JTextField();
        lblTotal = new JLabel("Total: $0.00");
        JButton btnReservar = new JButton("Reservar");

        form.add(new JLabel("Cliente:"));
        form.add(cmbClientes);
        form.add(new JLabel("Habitación #:"));
        form.add(cmbHabitaciones);
        form.add(new JLabel("Fecha inicio (yyyy-mm-dd):"));
        form.add(txtFechaInicio);
        form.add(new JLabel("Fecha fin (yyyy-mm-dd):"));
        form.add(txtFechaFin);
        form.add(new JLabel(""));
        form.add(lblTotal);
        form.add(new JLabel(""));
        form.add(btnReservar);

        modeloTabla = new DefaultTableModel(new String[]{"Cliente", "Hab#", "Inicio", "Fin", "Total"}, 0);
        tabla = new JTable(modeloTabla);
        cargarDatosEnCombos();
        cargarTabla();

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

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

    private void cargarTabla

