package aharon.products;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class ProductDetailsController
{
    public void mouseClicked(MouseEvent event) {
        JLabel label = (JLabel) event.getSource();
        Product product = (Product) label.getClientProperty("product");

        if (product != null) {
            ProductDetailsFrame detailsFrame = new ProductDetailsFrame(product);
            detailsFrame.setVisible(true);
        }
    }
}
