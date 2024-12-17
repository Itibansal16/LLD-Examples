package repo;

import model.Product;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Product, Integer> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, products.getOrDefault(product, 0) + quantity);
    }
    public void removeProduct(Product product) {
        products.remove(product);
    }
    public void updateQuantity(Product product, int quantity) {
        products.put(product, quantity);
    }
    public int getQuantity(Product product) {
        return products.getOrDefault(product, 0);
    }

    public boolean isAvailable(Product product) {
        return getQuantity(product) > 0;
    }
}
