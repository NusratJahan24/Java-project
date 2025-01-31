import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManageData extends JFrame {

    private Container c;
    private JButton passengerData;
    private JButton airHostessData;
    private JButton backButton;
    private JButton managerData;
    private ImageIcon logo,icon;
    private JLabel imgLabel;
    

    public ManageData() {

        
        setTitle("Manage Data");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(230, 230, 250));

        

        c = getContentPane();
        c.setLayout(null);

            // Icon
            icon = new ImageIcon(getClass().getResource("/images/Icon.png"));
            this.setIconImage(icon.getImage());

         // Logo
         logo = new ImageIcon(getClass().getResource("/images/managedata.png"));
         imgLabel = new JLabel(logo);
         imgLabel.setBounds(400,0, logo.getIconWidth(), logo.getIconHeight());
         c.add(imgLabel);

         JLabel title = new JLabel("Manage Data");
         title.setFont(new Font("Segoe UI Black", Font.BOLD, 40));
         title.setSize(300, 50);
         title.setLocation(132, 30);
         c.add(title);


        JLabel opt = new JLabel("Choose an option:");
        opt.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        opt.setSize(200, 40);
        opt.setLocation(10, 170);
        c.add(opt);

        passengerData = new JButton("Passenger Data");
        passengerData.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
        passengerData.setSize(200, 40);
        passengerData.setLocation(60, 240);
        passengerData.setForeground(Color.WHITE);
        passengerData.setBackground(new Color(112, 26, 192)); // Add this line to set the background color
        passengerData.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
    
                    setVisible(false);
                    PassengerData frame = new PassengerData();
                    frame.setVisible(true);
                }
            });
        c.add(passengerData);

        airHostessData = new JButton("Air Hostess Data");
        airHostessData.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
        airHostessData.setSize(200, 40);
        airHostessData.setLocation(60, 318);
        airHostessData.setForeground(Color.WHITE);
        airHostessData.setBackground(new Color(75, 71, 240));
        airHostessData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    Airhostdata frame = new Airhostdata();
                    frame.setVisible(true);
            }
        });
        c.add(airHostessData);

        managerData = new JButton("Manager Data");
        managerData.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
        managerData.setSize(200, 40);
        managerData.setLocation(60, 400);
        managerData.setForeground(Color.WHITE);
        managerData.setBackground(new Color(99, 201, 0));
        managerData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ManagerData frame = new ManagerData();
                frame.setVisible(true);
            }
        });
        c.add(managerData);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
        backButton.setSize(100, 35);
        backButton.setLocation(20, 500);
        backButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
       
        dispose(); 
       
        Admin admin = new Admin();
        admin.setVisible(true); // Show the AirHostessInterface window
    }
});
        c.add(backButton); 

        setVisible(true);
    }

    public static void main(String[] args) {
        new ManageData();
    }
}