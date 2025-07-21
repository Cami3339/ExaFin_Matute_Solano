package vista;

import javax.swing.*;

public class PanelClientes extends JPanel {
    public PanelClientes() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Aquí se mostrarán y gestionarán los clientes."));
        // Aquí se pueden agregar campos, JTable, botones, etc.
    }
}
