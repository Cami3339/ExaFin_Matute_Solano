package vista;

import javax.swing.*;

public class PanelHabitaciones extends JPanel {
    public PanelHabitaciones() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Aquí se mostrarán y gestionarán las habitaciones."));
    }
}
