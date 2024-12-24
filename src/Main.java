import javax.swing.*;
import java.awt.*;
import panels.RotatingLinePanel;    

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Вращающийся отрезок");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());
            
            RotatingLinePanel rotatingLinePanel = new RotatingLinePanel();
            frame.add(rotatingLinePanel, BorderLayout.CENTER);
            
            frame.setVisible(true);
            rotatingLinePanel.startAnimation();
        });
    }
}
