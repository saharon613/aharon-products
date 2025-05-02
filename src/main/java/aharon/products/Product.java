package aharon.products;

import java.util.List;

public class Product {
    int id;
    String title;
    String description;
    String category;
    double price;
    double discountPercentage; // was "discount"
    double rating;
    int stock;
    List<String> tags;
    String brand;
    String sku;
    double weight;
    Dimensions dimensions;
    String warrantyInformation;     // was "warranty"
    String shippingInformation;     // was "shipping"
    String availabilityStatus;      // was "availability"
    List<Review> reviews;
    String returnPolicy;
    int minimumOrderQuantity;
    Meta meta;
    List<String> images;
    String thumbnail;
}
