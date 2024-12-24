package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class RotatingLinePanel extends JPanel {
    private double angle = 0; // Угол вращения
    private final int radius = 200; // Длина отрезка
    private final Point pivot = new Point(400, 300); // Точка вращения
    private Color lineColor = Color.RED; // Начальный цвет линии

    private Timer timer;

    public RotatingLinePanel() {
        setBackground(Color.BLACK);
    }

    public void startAnimation() {
        timer = new Timer(50, e -> {
            angle += Math.PI / 60; // Увеличиваем угол
            if (angle >= 2 * Math.PI) {
                angle = 0;
            }
            lineColor = generateRandomColor(); // Меняем цвет
            repaint();
        });
        timer.start();
    }

    private Color generateRandomColor() {
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        return new Color(red, green, blue);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Вычисляем конечную точку отрезка
        int x2 = (int) (pivot.x + radius * Math.cos(angle));
        int y2 = (int) (pivot.y + radius * Math.sin(angle));

        g2d.setColor(lineColor);
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(new Line2D.Double(pivot.x, pivot.y, x2, y2));
    }
}
