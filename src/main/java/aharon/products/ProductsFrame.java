package aharon.products;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ProductsFrame extends JFrame {
    private JLabel[] labels = new JLabel[9];
    private ProductsController controllerP;
    private ProductDetailsController controllerD;

    public ProductsFrame() {

        setTitle("Products");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            add(labels[i]);

            labels[i].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    controllerD.mouseClicked(event);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }

        controllerP = new ProductsController(new ProductsServiceFactory().create(), labels);
        controllerD = new ProductDetailsController();
        controllerP.display();
    }

    public static void main(String[] args) {
        new ProductsFrame().setVisible(true);
    }
}
