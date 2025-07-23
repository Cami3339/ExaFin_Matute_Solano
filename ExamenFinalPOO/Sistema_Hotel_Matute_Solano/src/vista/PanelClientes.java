package vista; // Pertenece al paquete de vistas (interfaz gráfica del usuario).

import java.awt.*; // Importa componentes AWT como Layouts y Color.
import java.util.ArrayList; // Para usar listas dinámicas.
import javax.swing.*; // Para componentes gráficos de Swing.
import javax.swing.border.EmptyBorder; // Para márgenes interiores vacíos.
import javax.swing.table.DefaultTableModel; // Para manejar el modelo de la tabla.
import modelos.Cliente; // Clase Cliente, contiene datos como cédula, nombre, etc.
import util.ArchivoUtil; // Clase utilitaria para guardar y cargar archivos.

public class PanelClientes extends JPanel { // Panel que representa la sección de clientes en la interfaz gráfica.
    // Campos de texto para capturar información del cliente
    private JTextField txtCedula, txtNombre, txtApellido, txtTelefono;

    // Modelo de la tabla para mostrar datos de clientes
    private DefaultTableModel modeloTabla;
    private JTable tablaClientes;

    // Ruta del archivo donde se guardan los clientes
    private final String RUTA = "clientes.txt";

    // Lista que contiene los clientes cargados desde archivo
    private ArrayList<Cliente> listaClientes;

    public PanelClientes() {
        setLayout(new BorderLayout()); // Layout principal del panel.
        setBackground(new Color(240, 248, 255)); // Color de fondo claro.

        listaClientes = ArchivoUtil.cargar(RUTA); // Carga los datos de clientes desde el archivo de texto.

        // -------- Panel de formulario para ingresar datos --------
        JPanel formulario = new JPanel(new GridLayout(5, 2, 10, 10)); // 5 filas, 2 columnas, espacios de 10px.
        formulario.setBorder(new EmptyBorder(15, 20, 15, 20)); // Márgenes alrededor.
        formulario.setBackground(new Color(224, 255, 255)); // Fondo pastel.

        // Etiquetas de cada campo
        JLabel lblCedula = new JLabel("Cédula:");
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblApellido = new JLabel("Apellido:");
        JLabel lblTelefono = new JLabel("Teléfono:");

        // Fuente común para las etiquetas
        Font fuenteCampos = new Font("Segoe UI", Font.PLAIN, 14);
        lblCedula.setFont(fuenteCampos);
        lblNombre.setFont(fuenteCampos);
        lblApellido.setFont(fuenteCampos);
        lblTelefono.setFont(fuenteCampos);

        // Campos de texto
        txtCedula = new JTextField();
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtTelefono = new JTextField();

        // Aplica fuente a los campos de texto
        txtCedula.setFont(fuenteCampos);
        txtNombre.setFont(fuenteCampos);
        txtApellido.setFont(fuenteCampos);
        txtTelefono.setFont(fuenteCampos);

        // Botón para agregar cliente
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBackground(new Color(30, 144, 255)); // Color azul fuerte.
        btnAgregar.setForeground(Color.WHITE); // Texto blanco.
        btnAgregar.setFocusPainted(false); // Sin borde de selección al hacer clic.
        btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 14));

        // Agrega los componentes al formulario (ordenados)
        formulario.add(lblCedula);
        formulario.add(txtCedula);
        formulario.add(lblNombre);
        formulario.add(txtNombre);
        formulario.add(lblApellido);
        formulario.add(txtApellido);
        formulario.add(lblTelefono);
        formulario.add(txtTelefono);
        formulario.add(new JLabel("")); // Espacio vacío.
        formulario.add(btnAgregar); // Botón en la última celda.

        // -------- Tabla para mostrar lista de clientes --------
        modeloTabla = new DefaultTableModel(new String[]{"Cédula", "Nombre", "Apellido", "Teléfono"}, 0); // Columnas.
        tablaClientes = new JTable(modeloTabla); // Crea la tabla.
        tablaClientes.setFillsViewportHeight(true); // Ajuste visual.
        tablaClientes.setFont(fuenteCampos); // Fuente.
        tablaClientes.setRowHeight(22); // Altura de filas.
        tablaClientes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14)); // Fuente del encabezado.
        tablaClientes.getTableHeader().setBackground(new Color(176, 224, 230)); // Fondo del encabezado.
        tablaClientes.setGridColor(new Color(200, 200, 200)); // Color de líneas de la tabla.

        // Scroll para la tabla
        JScrollPane scrollPane = new JScrollPane(tablaClientes);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Clientes")); // Título para el borde.

        // Agrega los paneles al panel principal
        add(formulario, BorderLayout.NORTH); // Formulario en la parte superior.
        add(scrollPane, BorderLayout.CENTER); // Tabla en el centro.

        // Acción del botón Agregar
        btnAgregar.addActionListener(e -> agregarCliente()); // Llama al método cuando se hace clic.
    }

    // Método para agregar un cliente nuevo
    private void agregarCliente() {
        // Verifica que los campos obligatorios no estén vacíos
        if (txtCedula.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios."); // Muestra mensaje de advertencia.
            return;
        }

        // Crea un nuevo objeto Cliente con los datos ingresados
        Cliente c = new Cliente(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), txtTelefono.getText());

        listaClientes.add(c); // Lo agrega a la lista en memoria.
        ArchivoUtil.guardar(RUTA, listaClientes); // Guarda toda la lista en el archivo.

        // Agrega una nueva fila a la tabla con los datos del cliente
        modeloTabla.addRow(new Object[]{c.getCedula(), c.getNombre(), c.getApellido(), c.getTelefono()});

        limpiarFormulario(); // Limpia los campos del formulario.
    }

    // Método para cargar clientes existentes en la tabla (no usado aquí directamente)
    private void cargarClientesEnTabla() {
        for (Cliente c : listaClientes) {
            modeloTabla.addRow(new Object[]{c.getCedula(), c.getNombre(), c.getApellido(), c.getTelefono()});
        }
    }

    // Limpia los campos del formulario después de guardar
    private void limpiarFormulario() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
    }
}
