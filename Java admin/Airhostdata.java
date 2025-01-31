import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Airhostdata extends JFrame {

    private Container c;
    private ImageIcon icon;
    private ImageIcon logo;
    private JLabel imgLabel;
    private JTextArea data;
    private String filePath;

    public Airhostdata() {

        setTitle("Air Hostess Data");
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
        logo = new ImageIcon(getClass().getResource("/images/airhostdataphoto.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(570, 0, logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel);

        JLabel title = new JLabel("Air Hostess Data");
        title.setFont(new Font("Segoe UI Black", Font.BOLD, 40));
        title.setForeground(new Color(46, 106, 182));
        title.setSize(500, 50);
        title.setLocation(132, 30);
        c.add(title);

        // Initialize filePath
        filePath = "E:\\Airlines Reservation System\\Java air hostess\\Data\\airhostess_data.txt";

        // Read the text file
        String fileContent = readFile(filePath);

        data = new JTextArea(fileContent);
        data.setFont(new Font("Times New Roman", Font.BOLD, 20));
        data.setSize(500, 260);
        data.setBackground(Color.GRAY);
        data.setForeground(Color.WHITE);
        data.setLocation(50, 150);
        data.setLineWrap(true);
        data.setWrapStyleWord(true);
        c.add(data);

        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        saveButton.setSize(100, 30);
        saveButton.setLocation(170, 450);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveToFile(filePath, data.getText());
                JOptionPane.showMessageDialog(null, "Data saved successfully.");
            }
        });
        c.add(saveButton);

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

    private void saveToFile(String filePath, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
