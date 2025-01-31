import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Startadmin {

    public static void main(String[] args) {

        AdminLogin frame = new AdminLogin();
        frame.setVisible(true);
        JOptionPane.showMessageDialog(frame, "By default, name and password is admin.", "Information", JOptionPane.INFORMATION_MESSAGE);
    }
}
