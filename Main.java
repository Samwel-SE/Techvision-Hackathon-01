public class Main{

    public static void main(String[] args) {
        startGUI();
    }

    public static void startGUI() {
        // Start GUI
        MainPanel panel = new MainPanel();
        MainWindow window = new MainWindow(panel);
        
        window.setResizable(false);
        window.setSize(1000, 1000);
        window.setVisible(true);
        
    }


}