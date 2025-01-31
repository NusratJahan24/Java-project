import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class PassengerData extends JFrame {

    private Container c;
    private ImageIcon icon;
    private ImageIcon logo;
    private JLabel imgLabel;
    private JTextArea data;
    private JScrollPane scrollPane;
    private JButton saveButton;

    public PassengerData() {

        setTitle("Passenger Data");
        setBounds(300, 90, 1000, 600);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        c = getContentPane();
        c.setLayout(null);

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/Icon.png"));
        this.setIconImage(icon.getImage());

        // Logo
        logo = new ImageIcon(getClass().getResource("/images/passengerdataphoto.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(570, 0, logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel);

        JLabel title = new JLabel("Passenger Data");
        title.setFont(new Font("Segoe UI Black", Font.BOLD, 40));
        title.setForeground(new Color(112, 26, 192));
        title.setSize(500, 50);
        title.setLocation(132, 30);
        c.add(title);

        // Read the text file
        String filePath = "E:\\Airlines Reservation System\\Java passenger\\registration.txt";
        String fileContent = readFile(filePath);

        data = new JTextArea(fileContent);
        data.setFont(new Font("Times New Roman", Font.BOLD, 20));
        data.setBackground(Color.GRAY);
        data.setForeground(Color.WHITE);
        data.setLineWrap(true);
        data.setWrapStyleWord(true);

        scrollPane = new JScrollPane(data);
        scrollPane.setBounds(50, 150, 500, 260);
        c.add(scrollPane);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        backButton.setSize(100, 30);
        backButton.setLocation(50, 450);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ManageData frame = new ManageData();
                frame.setVisible(true);
            }
        });
        c.add(backButton);

        saveButton = new JButton("Save");
        saveButton.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        saveButton.setSize(100, 30);
        saveButton.setLocation(200, 450);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFile(filePath, data.getText());
            }
        });
        c.add(saveButton);

        setVisible(true);
    }

    private String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private void saveFile(String filePath, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(content);
            JOptionPane.showMessageDialog(this, "File saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new PassengerData();
    }
}
