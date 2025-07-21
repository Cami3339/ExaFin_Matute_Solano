package vista;

import javax.swing.*;

public class PanelReservas extends JPanel {
    public PanelReservas() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Aquí se mostrarán y gestionarán las reservas."));
    }
}
