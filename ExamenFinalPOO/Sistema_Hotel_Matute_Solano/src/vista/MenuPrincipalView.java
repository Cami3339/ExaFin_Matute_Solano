package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MenuPrincipalView extends JFrame {
    private JTabbedPane pestañas;

    public MenuPrincipalView() {
        setTitle("🌟 Sistema de Reservas - Hotel 🌟");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Encabezado
        JLabel header = new JLabel("Bienvenido al Sistema de Reservas del Hotel", JLabel.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 22));
        header.setForeground(new Color(33, 45, 62));
        header.setBorder(new EmptyBorder(15, 0, 15, 0));
        header.setOpaque(true);
        header.setBackground(new Color(224, 242, 241));
        add(header, BorderLayout.NORTH);

        pestañas = new JTabbedPane();
        pestañas.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pestañas.setBackground(Color.WHITE);
        pestañas.setForeground(new Color(51, 51, 51));
        pestañas.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

        pestañas.addTab("🧑‍💼 Clientes", new PanelClientes());
        pestañas.addTab("🛏 Habitaciones", new PanelHabitaciones());
        pestañas.addTab("📅 Reservas", new PanelReservas());

        add(pestañas, BorderLayout.CENTER);

        // Pie de página
        JLabel footer = new JLabel("© 2025 HotelSoft. Todos los derechos reservados.", JLabel.CENTER);
        footer.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        footer.setForeground(new Color(100, 100, 100));
        footer.setBorder(new EmptyBorder(10, 0, 10, 0));
        add(footer, BorderLayout.SOUTH);
    }
}
