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
