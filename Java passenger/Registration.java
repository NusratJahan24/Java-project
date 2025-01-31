import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.Month;
import java.time.Year;
 
class Registration extends JFrame implements ActionListener {
 
    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel Ticket_type;
    private JRadioButton Economy;
    private JRadioButton Business;
    private ButtonGroup gengp;
    private JLabel dob;
    private JLabel dmy;


    private JComboBox Adults;
    private JComboBox Children;
    private JComboBox Infant;


    private JLabel dobb;
    private JComboBox datee;
    private JComboBox monthh;
    private JComboBox yearr;

    private JLabel add;
    private JTextArea tadd;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JButton login;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
 
    private String Adult[]
        = { "1 seat(2k)", "2 seat(4k)", "3 seat(6k)", "4 seat(8k)", "5 seat(10k)" };
    private String Childrens[]
        = { "(9AM-10AM)", "(11AM-12AM)", "(3PM-5PM)", "(7PM-9PM)" };
    private String Infants[]
        = { "(Dhaka to Chittagong)","(Chittagong to Dhaka)","(Dhaka to Singapore)","(Singapore to Dhaka)" };
 
       private String datess[]
        = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String monthss[]
        = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String yearss[]
        = {  "2023","2024","2025" };


 
   public Registration()
    {
        getContentPane().setBackground(new Color(255, 229, 204));
        ImageIcon image = new ImageIcon("icon1.png");
        setIconImage(image.getImage());

        setTitle("Ticket Choose");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        c = getContentPane();
        c.setLayout(null);
 
        title = new JLabel("BOOK a ticket");
        title.setFont(new Font("Arial Black", Font.BOLD, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        title.setBackground(Color.WHITE);
        c.add(title);
 
        name = new JLabel("Name:");
        name.setFont(new Font("Arial Black", Font.BOLD, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        name.setBackground(Color.WHITE);
        c.add(name);
 
        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        tname.setBackground(Color.WHITE);
        c.add(tname);
 
        mno = new JLabel("Mobile:");
        mno.setFont(new Font("Arial Black", Font.BOLD, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 130);
        mno.setBackground(Color.WHITE);
        c.add(mno);
 
        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(190, 20);
        tmno.setLocation(200, 130);
        tmno.setBackground(Color.WHITE);
        c.add(tmno);
 
        Ticket_type = new JLabel("Choose:");
        Ticket_type.setFont(new Font("Arial Black", Font.BOLD, 18));
        Ticket_type.setSize(100, 20);
        Ticket_type.setLocation(100, 170);
        Ticket_type.setBackground(Color.WHITE);
        c.add(Ticket_type);
 
        Economy = new JRadioButton("Economy");
        Economy.setFont(new Font("Arial", Font.BOLD, 10));
        Economy.setSelected(true);
        Economy.setSize(75, 20);
        Economy.setLocation(200, 170);
        Economy.setBackground(Color.PINK);
        c.add(Economy);
 
        Business = new JRadioButton("Business");
        Business.setFont(new Font("Arial", Font.BOLD, 10));
        Business.setSelected(false);
        Business.setSize(80, 20);
        Business.setLocation(300, 170);
        Business.setBackground(Color.PINK);
        c.add(Business);
 
        gengp = new ButtonGroup();
        gengp.add(Economy);
        gengp.add(Business);

 
 
 
 
        dobb = new JLabel("D/M/YYY");
        dobb.setFont(new Font("Arial Black", Font.BOLD, 20));
        dobb.setSize(100, 20);
        dobb.setLocation(100, 200);
        c.add(dobb);
 
        datee = new JComboBox(datess);
        datee.setFont(new Font("Arial", Font.PLAIN, 15));
        datee.setSize(50, 20);
        datee.setLocation(200, 200);
        c.add(datee);
 
        monthh = new JComboBox(monthss);
        monthh.setFont(new Font("Arial", Font.PLAIN, 15));
        monthh.setSize(60, 20);
        monthh.setLocation(250, 200);
        monthh.setBackground(Color.WHITE);
        c.add(monthh);
 
        yearr = new JComboBox(yearss);
        yearr.setFont(new Font("Arial", Font.PLAIN, 15));
        yearr.setSize(60, 20);
        yearr.setLocation(320, 200);
        c.add(yearr);


 
        dob = new JLabel("Select:");
        dob.setFont(new Font("Arial Black", Font.PLAIN, 20));
        dob.setSize(100, 20);
        dob.setLocation(100, 250);
        c.add(dob);
 
        Adults = new JComboBox(Adult);
        Adults.setFont(new Font("Arial", Font.PLAIN, 15));
        Adults.setSize(90, 20);
        Adults.setLocation(200, 250);
        Adults.setBackground(Color.pink);
        c.add(Adults);
 
        Children = new JComboBox(Childrens);
        Children.setFont(new Font("Arial", Font.PLAIN, 15));
        Children.setSize(110, 20);
        Children.setLocation(250, 250);
        Children.setBackground(Color.pink);
        c.add(Children);
 
        Infant = new JComboBox(Infants);
        Infant.setFont(new Font("Arial", Font.PLAIN, 15));
        Infant.setSize(150, 20);
        Infant.setLocation(350, 250);
        Infant.setBackground(Color.pink);
        c.add(Infant);
 
        add = new JLabel("Current Home Address:-");
        add.setFont(new Font("Arial", Font.ITALIC, 13));
        add.setSize(200, 20);
        add.setLocation(50, 300);
        c.add(add);
 
        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(200, 75);
        tadd.setLocation(200, 300);
        tadd.setLineWrap(true);
        c.add(tadd);
 
        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Agency FB", Font.BOLD, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        c.add(term);
 
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        sub.setBackground(Color.GREEN);
        c.add(sub);
 
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        reset.setBackground(Color.red);
        c.add(reset);
		
		login = new JButton("Back");
        login.setFont(new Font("Arial", Font.PLAIN, 15));
        login.setSize(100, 20);
        login.setLocation(200, 500);
        login.addActionListener(this);
        c.add(login);
 
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);
 
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 530);
    
        c.add(res);
 
        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 150);
        resadd.setLineWrap(true);
      
        c.add(resadd);
       
        setVisible(true);
    }
 
  
	
	
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
            StringBuilder data = new StringBuilder();
            data.append("-------- Passenger Information --------\n");
            data.append("Name: ").append(tname.getText()).append("\n");
            data.append("Mobile: ").append(tmno.getText()).append("\n");
    
            String type = Economy.isSelected() ? "Economy" : "Business";
            data.append("Type: ").append(type).append("\n");
    
            data.append("Seat: ").append(Adults.getSelectedItem()).append("\n");
            data.append("Time: ").append(Children.getSelectedItem()).append("\n");
            data.append("Plane route: ").append(Infant.getSelectedItem()).append("\n");
    
            data.append("D/M/YYYY: ")
                .append(datee.getSelectedItem()).append("/")
                .append(monthh.getSelectedItem()).append("/")
                .append(yearr.getSelectedItem()).append("\n");
    
            data.append("Current Home address: ").append(tadd.getText()).append("\n");
            data.append("-----------------------------------\n");
    
            tout.setText(data.toString());
            tout.setEditable(false);
            res.setText("!!!!!Ticket Book Complete!!!!!!!");
    
            try (FileWriter fw = new FileWriter("registration.txt", true)) {
                fw.write(data.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tadd.setText(def);
            tmno.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
    
            Adults.setSelectedIndex(0);
            Children.setSelectedIndex(0);
            Infant.setSelectedIndex(0);
    
            datee.setSelectedIndex(0);
            monthh.setSelectedIndex(0);
            yearr.setSelectedIndex(0);
    
            resadd.setText(def);
        } else if (e.getSource() == login) {
            new Login();
            this.setVisible(false);
        }
    }
}    
