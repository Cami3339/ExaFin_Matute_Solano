package vista;

import javax.swing.*;

public class MenuPrincipalView extends JFrame {
    private JTabbedPane pestañas;

    public MenuPrincipalView() {
        setTitle("Sistema de Reservas - Hotel");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pestañas = new JTabbedPane();

        pestañas.addTab("Clientes", new PanelClientes());
        pestañas.addTab("Habitaciones", new PanelHabitaciones());
        pestañas.addTab("Reservas", new PanelReservas());

        add(pestañas);
    }
}
