package aharon.products;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ProductDetailsFrame extends JFrame {
    public ProductDetailsFrame(Product product) {
        setTitle(product.title);
        setSize(400, 500);
        setLayout(new BorderLayout());

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());

        try {
            ImageIcon icon = new ImageIcon(ImageIO.read(new URL(product.thumbnail)));
            JLabel imageLabel = new JLabel(icon);
            imagePanel.add(imageLabel, BorderLayout.CENTER);
        } catch (IOException e) {
            imagePanel.add(new JLabel("No image"), BorderLayout.CENTER);
        }

        add(imagePanel, BorderLayout.NORTH);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));

        addField(detailsPanel, "Title: " + product.title);
        addField(detailsPanel, "Description: " + product.description);
        addField(detailsPanel, "Price: $" + product.price);
        addField(detailsPanel, "Category: " + product.category);
        addField(detailsPanel, "Discount: " + product.discountPercentage + "%");
        addField(detailsPanel, "Rating: " + product.rating);
        addField(detailsPanel, "Stock: " + product.stock);
        addField(detailsPanel, "Brand: " + product.brand);
        addField(detailsPanel, "SKU: " + product.sku);
        addField(detailsPanel, "Weight: " + product.weight + "kg");

        if (product.dimensions != null) {
            addField(detailsPanel, "Dimensions (WxHxD): " + product.dimensions.width + " x "
                    + product.dimensions.height + " x " + product.dimensions.depth);
        }

        addField(detailsPanel, "Warranty Info: " + product.warrantyInformation);
        addField(detailsPanel, "Shipping Info: " + product.shippingInformation);
        addField(detailsPanel, "Availability: " + product.availabilityStatus);
        addField(detailsPanel, "Return Policy: " + product.returnPolicy);
        addField(detailsPanel, "Minimum Order: " + product.minimumOrderQuantity);

        if (product.meta != null) {
            addField(detailsPanel, "Created At: " + product.meta.createdAt);
            addField(detailsPanel, "Updated At: " + product.meta.updatedAt);
            addField(detailsPanel, "Barcode: " + product.meta.barcode);
            addField(detailsPanel, "QR Code: " + product.meta.qrCode);
        }

        if (product.reviews != null && !product.reviews.isEmpty()) {
            addField(detailsPanel, "Reviews: ");
            for (Review review : product.reviews) {
                addField(detailsPanel, "Rating: " + review.rating);
                addField(detailsPanel, "Comment: " + review.comment);
                addField(detailsPanel, "Date: " + review.date);
                addField(detailsPanel, "Reviewer: " + review.reviewerName);
                addField(detailsPanel, "Email: " + review.reviewerEmail);
            }
        }

        JScrollPane scrollPane = new JScrollPane(detailsPanel);
        add(scrollPane, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void addField(JPanel panel, String text) {
        panel.add(new JLabel(text));
    }
}

