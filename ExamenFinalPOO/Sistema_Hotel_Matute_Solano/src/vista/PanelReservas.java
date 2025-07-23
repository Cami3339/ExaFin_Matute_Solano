package vista; // El panel pertenece al paquete de vistas de la aplicación.

import java.awt.*; // Layouts, componentes visuales y cursores.
import java.time.LocalDate; // Fechas modernas (Java 8+).
import java.util.ArrayList; // Lista dinámica para manejar reservas, clientes, habitaciones.
import javax.swing.*; // Componentes Swing.
import javax.swing.table.DefaultTableModel; // Modelo para tablas (JTable).

import modelos.Cliente; // Modelo Cliente.
import modelos.Habitacion; // Modelo Habitación.
import modelos.Reserva; // Modelo Reserva.
import util.ArchivoUtil; // Utilidad para cargar/guardar objetos desde/archivo.

public class PanelReservas extends JPanel {
    // Componentes de la interfaz
    private JComboBox<String> cmbClientes;
    private JComboBox<Integer> cmbHabitaciones;
    private JTextField txtFechaInicio, txtFechaFin;
    private JLabel lblTotal;
    private DefaultTableModel modeloTabla;
    private JTable tabla;

    // Archivos persistentes
    private final String RUTA_RESERVAS = "reservas.txt";
    private final String RUTA_CLIENTES = "clientes.txt";
    private final String RUTA_HABITACIONES = "habitaciones.txt";

    // Listas cargadas desde archivo
    private ArrayList<Reserva> reservas;
    private ArrayList<Cliente> clientes;
    private ArrayList<Habitacion> habitaciones;

    public PanelReservas() {
        setLayout(new BorderLayout()); // Layout principal

        // Carga las listas desde archivo
        reservas = ArchivoUtil.cargar(RUTA_RESERVAS);
        clientes = ArchivoUtil.cargar(RUTA_CLIENTES);
        habitaciones = ArchivoUtil.cargar(RUTA_HABITACIONES);

        // Colores y fuente general
        Color fondo = new Color(250, 250, 255);
        Color azul = new Color(63, 81, 181);
        Font fuente = new Font("Segoe UI", Font.PLAIN, 14);

        // ----- Formulario de reserva -----
        JPanel form = new JPanel(new GridLayout(6, 2, 10, 10)); // 6 filas, 2 columnas, padding
        form.setBorder(BorderFactory.createEmptyBorder(20, 40, 10, 40)); // Márgenes
        form.setBackground(fondo);

        // Componentes del formulario
        cmbClientes = new JComboBox<>();
        cmbHabitaciones = new JComboBox<>();
        txtFechaInicio = new JTextField();
        txtFechaFin = new JTextField();
        lblTotal = new JLabel("Total: $0.00");
        JButton btnReservar = new JButton("Reservar");

        // Estiliza los componentes
        for (Component comp : new Component[]{cmbClientes, cmbHabitaciones, txtFechaInicio, txtFechaFin, btnReservar}) {
            comp.setFont(fuente);
        }

        lblTotal.setFont(fuente);
        lblTotal.setForeground(new Color(56, 142, 60)); // Verde para resaltar el total

        // Agrega campos al formulario
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

        // ----- Tabla de reservas -----
        modeloTabla = new DefaultTableModel(new String[]{"Cliente", "Hab#", "Inicio", "Fin", "Total"}, 0);
        tabla = new JTable(modeloTabla);
        tabla.setFont(fuente);
        tabla.setRowHeight(22);
        tabla.getTableHeader().setFont(fuente.deriveFont(Font.BOLD)); // Títulos de columna

        // ----- Lógica inicial -----
        cargarDatosEnCombos(); // Llena combo de clientes y habitaciones
        cargarTabla(); // Muestra las reservas ya existentes

        // Añade los componentes al panel principal
        add(form, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        setBackground(fondo);

        // Estilo del botón
        btnReservar.setBackground(azul);
        btnReservar.setForeground(Color.WHITE);
        btnReservar.setFocusPainted(false);
        btnReservar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Acción del botón
        btnReservar.addActionListener(e -> reservar());
    }

    /**
     * Llena los combo boxes con datos cargados.
     */
    private void cargarDatosEnCombos() {
        for (Cliente c : clientes) {
            cmbClientes.addItem(c.getCedula() + " - " + c.getNombre());
        }
        for (Habitacion h : habitaciones) {
            if (h.isDisponible()) {
                cmbHabitaciones.addItem(h.getNumero()); // Solo habitaciones disponibles
            }
        }
    }

    /**
     * Carga la lista de reservas en la tabla visual.
     */
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

    /**
     * Lógica para crear una nueva reserva.
     */
    private void reservar() {
        try {
            // Obtiene la cédula del cliente seleccionada
            String cedula = cmbClientes.getSelectedItem().toString().split(" - ")[0];
            Cliente cliente = clientes.stream()
                .filter(c -> c.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);

            // Obtiene habitación por número
            int numHab = (int) cmbHabitaciones.getSelectedItem();
            Habitacion habitacion = habitaciones.stream()
                .filter(h -> h.getNumero() == numHab)
                .findFirst()
                .orElse(null);

            // Parsea las fechas ingresadas
            LocalDate inicio = LocalDate.parse(txtFechaInicio.getText());
            LocalDate fin = LocalDate.parse(txtFechaFin.getText());

            // Valida que la fecha de inicio no sea posterior
            if (inicio.isAfter(fin)) {
                JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser después de la fecha de fin.");
                return;
            }

            // Verifica si la habitación ya está reservada en ese rango
            for (Reserva r : reservas) {
                if (r.getHabitacion().getNumero() == numHab) {
                    boolean hayIntersección = !(fin.isBefore(r.getFechaInicio()) || inicio.isAfter(r.getFechaFin()));
                    if (hayIntersección) {
                        JOptionPane.showMessageDialog(this, "La habitación ya está reservada en ese rango de fechas.");
                        return;
                    }
                }
            }

            // Crea y guarda la nueva reserva
            Reserva nueva = new Reserva(cliente, habitacion, inicio, fin);
            reservas.add(nueva);
            ArchivoUtil.guardar(RUTA_RESERVAS, reservas);

            // Actualiza tabla visual
            modeloTabla.addRow(new Object[]{
                cliente.getNombre(),
                habitacion.getNumero(),
                inicio.toString(),
                fin.toString(),
                "$" + nueva.calcularTotal()
            });

            // Actualiza total y limpia campos
            lblTotal.setText("Total: $" + nueva.calcularTotal());
            limpiarCampos();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: verifique que los campos estén completos y válidos.");
        }
    }

    /**
     * Limpia los campos de fecha después de reservar.
     */
    private void limpiarCampos() {
        txtFechaInicio.setText("");
        txtFechaFin.setText("");
    }
}

