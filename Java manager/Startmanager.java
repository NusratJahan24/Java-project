import javax.swing.SwingUtilities;

public class Startmanager {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Manager();
            }
        });
    }
}



