import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

class Circle {
    public static Random rand = new Random();
    public int x;
    public int y;
    public int r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public static Circle small() {
        return new Circle(rand.nextInt(400), rand.nextInt(400), 10);
    }
    public static Circle medium() {
        return new Circle(rand.nextInt(400), rand.nextInt(400), 30);
    }
    public static Circle large() {
        return new Circle(rand.nextInt(400), rand.nextInt(400), 80);
    }
}

class Model extends ArrayList<Circle> {
}

class Controller {
    static class Small implements ActionListener {
        Model data;
        bubbles app;
        public Small(Model data, bubbles app) {
            this.data = data;
            this.app = app;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Circle c = Circle.small();
            this.data.add(c);
            app.refresh();
        }
    }
    static class Medium implements ActionListener {
        Model data;
        bubbles app;
        public Medium(Model data, bubbles app) {
            this.data = data;
            this.app = app;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Circle c = Circle.medium();
            this.data.add(c);
            app.refresh();
        }
    }
    static class Large implements ActionListener {
        Model data;
        bubbles app;
        public Large(Model data, bubbles app) {
            this.data = data;
            this.app = app;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Circle c = Circle.large();
            this.data.add(c);
            app.refresh();
        }
    }


}

class Canvas extends JComponent {
    private Model circles;

    public Canvas(Model c) {
        this.circles = c;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setRenderingHints(rh);

        g2.clearRect(0, 0, 400, 400);
        g2.setColor(new Color(0.3f, 0.3f, 0.3f, 0.5f));
        for(Circle c: this.circles) {
            g2.fillOval(c.x, c.y, c.r * 2, c.r * 2);
        }
    }
}

public class bubbles extends JFrame {
    JButton small;
    JButton medium;
    JButton large;

    JLabel xLabel;
    JLabel yLabel;

    Canvas canvas;
    Model data;

    public bubbles() {
        // build the component hierarchy
        small = new JButton("SMALL");
        medium = new JButton("MEDIUM");
        large = new JButton("LARGE");

        xLabel = new JLabel("x:");
        yLabel = new JLabel("y:");

        data = new Model();

        canvas = new Canvas(data);

        JPanel top = new JPanel(new FlowLayout());
        JPanel bot = new JPanel(new FlowLayout());

        top.add(small);
        top.add(medium);
        top.add(large);

        bot.add(xLabel);
        bot.add(yLabel);

        this.setLayout(new BorderLayout());
        this.add(top, BorderLayout.PAGE_START);
        this.add(bot, BorderLayout.PAGE_END);
        this.add(canvas, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bubbles");

        // add the controllers
        this.small.addActionListener(new Controller.Small(data, this));
        this.medium.addActionListener(new Controller.Medium(data, this));
        this.large.addActionListener(new Controller.Large(data, this));

    }

    public void refresh() {
        this.canvas.repaint();
        int n = this.data.size();
        Circle c = this.data.get(n-1);
        this.xLabel.setText("x:" + c.x);
        this.yLabel.setText("y:" + c.y);
    }

    public static void main(String[] args) {
        bubbles app = new bubbles();
        app.pack();
        app.setVisible(true);
    }
}
