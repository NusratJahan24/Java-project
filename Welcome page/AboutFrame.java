import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutFrame extends JFrame {
    public AboutFrame() {
        super("About");
        this.setSize(600, 400); // Increased size
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); // Center the frame

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);

        JTextArea aboutInfo = new JTextArea();
        aboutInfo.setText("Skyline Airlines\n\n" +
                "Welcome to our Airline Reservation System!\n" +
                "This system allows users to book flights, manage their bookings, and more.\n\n" +
                "Features:\n" +
                "- Book flights with ease\n" +
                "- View flight schedules\n" +
                "- Manage your bookings\n" +
                "- Explore special offers and discounts\n\n" +
                "We strive to provide you with the best travel experience.\n" +
                "Thank you for choosing our airline!\n\n" +
                "© 2024 Airline Reservation System. All rights reserved.\n\n");
        aboutInfo.setEditable(false);
        aboutInfo.setLineWrap(true);
        aboutInfo.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(aboutInfo); // Add the JTextArea to JScrollPane
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                WelcomePage wcp = new WelcomePage();
                wcp.setVisible(true);
            }
        });
        panel.add(backButton, BorderLayout.SOUTH);

        this.add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AboutFrame aboutFrame = new AboutFrame();
            aboutFrame.setVisible(true);
        });
    }
}
