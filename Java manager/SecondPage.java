import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SecondPage {
    private Manager manager;
    private JFrame secondFrame;
    private JTextField airplaneNameField;
    private JTextField departureTimeField;
    private JTextField fromField;
    private JTextField toField;
    private JTextField dateField;
    private JTextField maxPassengerField;
    private JTable table;
    private DefaultTableModel model;

    public SecondPage(Manager manager) {
        this.manager = manager;
    }

    public SecondPage() {
       this.manager = new Manager();
    }

    public void createSecondPage() {
        secondFrame = new JFrame("Bangladesh Airlines");
        secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        secondFrame.setSize(800, 600);
        secondFrame.getContentPane().setBackground(Color.orange);

        JLabel titleLabel = new JLabel(" Airlines Manager ", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        titleLabel.setBounds(0, 10, 800, 50);
        secondFrame.getContentPane().add(titleLabel);

        String[] columns = {"Airplane Name", "Departure Time", "From", "To", "Date", "Max Passengers"};
        model = new DefaultTableModel(null, columns);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 320, 600, 300);
        secondFrame.getContentPane().add(scrollPane);

        JLabel airplaneNameLabel = new JLabel("Airplane Name:");
        airplaneNameLabel.setBounds(50, 120, 100, 30);
        secondFrame.getContentPane().add(airplaneNameLabel);
        airplaneNameField = new JTextField();
        airplaneNameField.setBounds(150, 120, 200, 30);
        secondFrame.getContentPane().add(airplaneNameField);

        JLabel departureTimeLabel = new JLabel("Departure Time:");
        departureTimeLabel.setBounds(450, 120, 100, 30);
        secondFrame.getContentPane().add(departureTimeLabel);
        departureTimeField = new JTextField();
        departureTimeField.setBounds(550, 120, 200, 30);
        secondFrame.getContentPane().add(departureTimeField);

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(50, 170, 100, 30);
        secondFrame.getContentPane().add(fromLabel);
        fromField = new JTextField();
        fromField.setBounds(150, 170, 200, 30);
        secondFrame.getContentPane().add(fromField);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(450, 170, 100, 30);
        secondFrame.getContentPane().add(toLabel);
        toField = new JTextField();
        toField.setBounds(550, 170, 200, 30);
        secondFrame.getContentPane().add(toField);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(50, 220, 100, 30);
        secondFrame.getContentPane().add(dateLabel);
        dateField = new JTextField();
        dateField.setBounds(150, 220, 200, 30);
        secondFrame.getContentPane().add(dateField);

        JLabel maxPassengerLabel = new JLabel("Max Passengers:");
        maxPassengerLabel.setBounds(450, 220, 100, 30);
        secondFrame.getContentPane().add(maxPassengerLabel);
        maxPassengerField = new JTextField();
        maxPassengerField.setBounds(550, 220, 200, 30);
        secondFrame.getContentPane().add(maxPassengerField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(700, 320, 100, 30);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addFlight();
            }
        });
        secondFrame.getContentPane().add(addButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(700, 370, 100, 30);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteFlight();
            }
        });
        secondFrame.getContentPane().add(deleteButton);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(700, 420, 100, 30);
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateFlight();
            }
        });
        secondFrame.getContentPane().add(updateButton);

        JButton airhostessButton = new JButton("Airhostess Info");
        airhostessButton.setBackground(new Color(135, 206, 235)); // sky blue color
        airhostessButton.setBounds(660, 500, 150, 30);
        airhostessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                manager.showThirdPage();
            }
        });
        secondFrame.getContentPane().add(airhostessButton);


           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("SecondPage.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,600);
        secondFrame.getContentPane().add(image);

        secondFrame.setLayout(null);
        secondFrame.setVisible(true);
    }

    private void addFlight() {
        String airplaneName = airplaneNameField.getText();
        String departureTime = departureTimeField.getText();
        String from = fromField.getText();
        String to = toField.getText();
        String date = dateField.getText();
        String maxPassengers = maxPassengerField.getText();
    
        if (!airplaneName.isEmpty() && !departureTime.isEmpty() && !from.isEmpty() && !to.isEmpty() && !date.isEmpty() && !maxPassengers.isEmpty()) {
            Object[] newRow = {airplaneName, departureTime, from, to, date, maxPassengers};
            model.addRow(newRow);
    
            // Write data to file
            try {
                FileWriter fw = new FileWriter("flights.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
    
                pw.println("Airplane Name: " + airplaneName);
                pw.println("Departure Time: " + departureTime);
                pw.println("From: " + from);
                pw.println("To: " + to);
                pw.println("Date: " + date);
                pw.println("Max Passengers: " + maxPassengers);
                pw.println(); // Add an empty line to separate flights
    
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    
            airplaneNameField.setText("");
            departureTimeField.setText("");
            fromField.setText("");
            toField.setText("");
            dateField.setText("");
            maxPassengerField.setText("");
        } else {
            JOptionPane.showMessageDialog(secondFrame, "Please fill in all fields.");
        }
    }
    


    private void deleteFlight() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(secondFrame, "Please select a flight to delete.");
        }
    }

    private void updateFlight() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String airplaneName = airplaneNameField.getText();
            String departureTime = departureTimeField.getText();
            String from = fromField.getText();
            String to = toField.getText();
            String date = dateField.getText();
            int maxPassengers = Integer.parseInt(maxPassengerField.getText());

            if (!airplaneName.isEmpty() && !departureTime.isEmpty() && !from.isEmpty() && !to.isEmpty() && !date.isEmpty()) {
                model.setValueAt(airplaneName, selectedRow, 0);
                model.setValueAt(departureTime, selectedRow, 1);
                model.setValueAt(from, selectedRow, 2);
                model.setValueAt(to, selectedRow, 3);
                model.setValueAt(date, selectedRow, 4);
                model.setValueAt(maxPassengers, selectedRow, 5);

                airplaneNameField.setText("");
                departureTimeField.setText("");
                fromField.setText("");
                toField.setText("");
                dateField.setText("");
                maxPassengerField.setText("");
            } else {
                JOptionPane.showMessageDialog(secondFrame, "Please fill in all fields.");
            }
        } else {
            JOptionPane.showMessageDialog(secondFrame, "Please select a flight to update.");
        }
    }
}
