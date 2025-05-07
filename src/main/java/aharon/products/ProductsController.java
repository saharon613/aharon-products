package aharon.products;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;

public class ProductsController {
    private ProductsService service;
    private JLabel[] imageLabels;

    public ProductsController(ProductsService service, JLabel[] imageLabels) {
        this.imageLabels = imageLabels;
        this.service = service;
        listener();
    }

    private void listener() {
        for (JLabel label : imageLabels) {
            label.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    JLabel sourceLabel = (JLabel) event.getSource();
                    Product product = (Product) sourceLabel.getClientProperty("product");

                    if (product != null) {
                        ProductDetailsFrame detailsFrame = new ProductDetailsFrame(product);
                        detailsFrame.setVisible(true);
                    }
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
    }

    public void display() {
        ProductsResponse products = service.getProducts()
                .blockingGet();

        for (int i = 0; i < imageLabels.length; i++) {
            Product product = products.products[i];
            try {
                imageLabels[i].putClientProperty("product", product);
                URL url = new URL(product.thumbnail);
                Image image = ImageIO.read(url);
                ImageIcon imageIcon = new ImageIcon(image);
                imageLabels[i].setIcon(imageIcon);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
