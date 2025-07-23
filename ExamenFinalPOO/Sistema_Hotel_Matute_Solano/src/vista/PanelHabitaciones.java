package vista; // Esta clase forma parte del paquete de vistas (interfaz gráfica).

import java.awt.*; // Importa componentes gráficos y layouts.
import java.util.ArrayList; // Para trabajar con listas dinámicas.
import javax.swing.*; // Importa todos los componentes Swing.
import javax.swing.table.DefaultTableModel; // Modelo de tabla para JTable.
import modelos.Habitacion; // Clase Habitacion (modelo).
import modelos.TipoHabitacion; // Enum TipoHabitacion.
import util.ArchivoUtil; // Clase utilitaria para guardar/cargar archivos.

public class PanelHabitaciones extends JPanel { // Clase que representa el panel de gestión de habitaciones.
    private JTextField txtNumero; // Campo para ingresar el número de habitación.
    private JComboBox<TipoHabitacion> cmbTipo; // ComboBox para seleccionar el tipo de habitación.
    private DefaultTableModel modeloTabla; // Modelo para la tabla.
    private JTable tabla; // Tabla para mostrar las habitaciones.
    private final String RUTA = "habitaciones.txt"; // Ruta donde se guardan los datos.
    private ArrayList<Habitacion> lista; // Lista de habitaciones en memoria.

    public PanelHabitaciones() {
        setLayout(new BorderLayout()); // Layout principal del panel.
        lista = ArchivoUtil.cargar(RUTA); // Carga las habitaciones desde archivo.

        // ---------- Formulario para ingresar datos ----------
        JPanel form = new JPanel(new GridLayout(3, 2)); // Formulario con 3 filas y 2 columnas.
        txtNumero = new JTextField(); // Campo de texto para el número de habitación.
        cmbTipo = new JComboBox<>(TipoHabitacion.values()); // Combo con todos los tipos del enum TipoHabitacion.
        JButton btnAgregar = new JButton("Agregar"); // Botón para agregar una nueva habitación.

        // Agrega etiquetas y campos al formulario
        form.add(new JLabel("Número:")); // Etiqueta
        form.add(txtNumero); // Campo de texto
        form.add(new JLabel("Tipo:")); // Etiqueta
        form.add(cmbTipo); // ComboBox
        form.add(new JLabel("")); // Espacio vacío
        form.add(btnAgregar); // Botón

        // ---------- Tabla para mostrar habitaciones ----------
        modeloTabla = new DefaultTableModel(new String[]{"Número", "Tipo", "Disponible"}, 0); // Columnas.
        tabla = new JTable(modeloTabla); // Crea la tabla.
        cargarEnTabla(); // Carga los datos existentes en la tabla.

        // Agrega los componentes al panel principal
        add(form, BorderLayout.NORTH); // Formulario en la parte superior.
        add(new JScrollPane(tabla), BorderLayout.CENTER); // Tabla en el centro con scroll.

        // Acción cuando se presiona el botón "Agregar"
        btnAgregar.addActionListener(e -> agregar()); // Llama al método agregar().
    }

    /**
     * Método que se ejecuta al presionar el botón "Agregar".
     * Crea una nueva habitación, la guarda y la muestra en la tabla.
     */
    private void agregar() {
        try {
            // Intenta convertir el texto del número en entero
            int numero = Integer.parseInt(txtNumero.getText().trim());
            TipoHabitacion tipo = (TipoHabitacion) cmbTipo.getSelectedItem(); // Obtiene el tipo seleccionado

            // Crea un nuevo objeto habitación, por defecto disponible (true)
            Habitacion h = new Habitacion(numero, tipo, true);

            lista.add(h); // Agrega a la lista en memoria
            ArchivoUtil.guardar(RUTA, lista); // Guarda la lista actualizada en el archivo

            // Agrega la nueva habitación a la tabla visual
            modeloTabla.addRow(new Object[]{numero, tipo, "Sí"});

            // Limpia el campo de número
            txtNumero.setText("");
        } catch (NumberFormatException e) {
            // Si el número no es válido, muestra un mensaje
            JOptionPane.showMessageDialog(this, "Número inválido.");
        }
    }

    /**
     * Carga las habitaciones desde la lista en memoria a la tabla.
     */
    private void cargarEnTabla() {
        for (Habitacion h : lista) {
            modeloTabla.addRow(new Object[]{
                h.getNumero(),
                h.getTipo(),
                h.isDisponible() ? "Sí" : "No" // Muestra "Sí" si está disponible, "No" si no.
            });
        }
    }
}

