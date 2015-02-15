import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Point {
    static int W = 400, H = 400, R = 40;
    static double C = 1;
    static Random rand = new Random();

    int x;
    int y;
    int r;
    float alpha;
    long t;

    public Point(int x, int y, int r, float alpha, long t) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.t = t;
        this.alpha = alpha;
    }
    public static Point random() {
        int x = rand.nextInt(W);
        int y = rand.nextInt(H);
        int r = rand.nextInt(R);
        long t = System.currentTimeMillis();

        float alpha = rand.nextFloat() / 2 + 0.5f;
        return new Point(x, y, r, alpha, t);
    }
    public String toString() {
        return "<" + x + "," + y + ">(" + r + ")" + alpha +";";
    }
}

class Canvas extends JComponent {
    int width;
    int height;
    java.util.List<Point> points;

    public Canvas(int width, int height, java.util.List<Point> points) {
        this.width = width;
        this.height = height;
        this.points = points;
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.width, this.height);
    }
    @Override
    public void paint(Graphics _g) {
        Graphics2D g = (Graphics2D)_g;

        RenderingHints hint = new RenderingHints(
             RenderingHints.KEY_ANTIALIASING,
             RenderingHints.VALUE_ANTIALIAS_ON);

        long t = System.currentTimeMillis();

        g.setRenderingHints(hint);

        g.setColor(new Color(100, 100, 100));
        g.fillRect(0, 0, this.width, this.height);

        g.setColor(Color.white);
        for(Point p: this.points) {
            double decay = Math.exp(-Point.C * (t-p.t) / 1000.0);
            g.setColor(new Color(1, 1, 1, (float)decay * p.alpha));
            g.fillOval(p.x, p.y, p.r, p.r);
        }
    }
}

class CreateNew implements ActionListener {
    java.util.List<Point> points;
    Canvas canvas;

    public CreateNew(java.util.List<Point> points, Canvas canvas) {
        this.points = points;
        this.canvas = canvas;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        Point p = Point.random();
        points.add(p);
        canvas.repaint();
    }
}

class Dots extends JFrame {
    public Canvas canvas;

    public Dots(java.util.List<Point> points) {
        JComponent pane = this.getRootPane();
        pane.setLayout(new BorderLayout());

        // FlowLayout
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        pane.add(top, BorderLayout.PAGE_START);

        // JLabel
        JLabel label = new JLabel("Bubble");
        top.add(label);

        JTextField text = new JTextField(30);
        top.add(text);

        // Canvas
        this.canvas = new Canvas(400, 400, points);
        pane.add(this.canvas, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public static void main(String[] args) {
        java.util.List<Point> points = new LinkedList<Point>();
        Dots dots = new Dots(points);

        ActionListener createNew = new CreateNew(points, dots.canvas);
        javax.swing.Timer timer = new javax.swing.Timer(1000, createNew);
        timer.setDelay(100);
        timer.setRepeats(true);
        timer.start();

        dots.setVisible(true);
    }
}
