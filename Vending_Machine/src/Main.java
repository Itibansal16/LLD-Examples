import model.Coin;
import model.Note;
import model.Product;
import repo.Inventory;
import service.VendingMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Pepsi", 40.0);
        Product product2 = new Product("Chocolate", 90.0);
        Product product3 = new Product("Frooti", 15.0);

        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.getInventory().addProduct(product1, 3);
        vendingMachine.getInventory().addProduct(product2, 2);
        vendingMachine.getInventory().addProduct(product3, 1);


        vendingMachine.dispenseProduct();
        vendingMachine.selectProduct(product1);
        vendingMachine.insertCoin(Coin.TWENTY);
        vendingMachine.dispenseProduct();
        vendingMachine.insertNote(Note.TWENTY);
        vendingMachine.dispenseProduct();
        vendingMachine.returnChange();
        vendingMachine.returnChange();
    }
}