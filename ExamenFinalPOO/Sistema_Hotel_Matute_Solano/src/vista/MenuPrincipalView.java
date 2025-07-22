package vista;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalView extends JFrame {
    private JTabbedPane pestañas;

    public MenuPrincipalView() {
        setTitle("Sistema de Reservas - Hotel");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pestañas = new JTabbedPane();
        pestañas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        pestañas.setBackground(new Color(240, 248, 255));

        pestañas.addTab("Clientes", new PanelClientes());
        pestañas.addTab("Habitaciones", new PanelHabitaciones());
        pestañas.addTab("Reservas", new PanelReservas());

        add(pestañas);
    }
}
