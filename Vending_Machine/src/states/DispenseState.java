package states;

import model.Coin;
import model.Note;
import model.Product;
import service.VendingMachine;

public class DispenseState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected; Collect your product");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Payment already done; Collect your product");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Payment already done; Collect your product");
    }

    @Override
    public void dispenseProduct() {
        Product product = vendingMachine.getSelectedProduct();
        int quantity = vendingMachine.getInventory().getQuantity(product);
        vendingMachine.getInventory().updateQuantity(product, quantity - 1);
        System.out.println("Product dispensed: " + product);
        vendingMachine.setCurrentState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("Please collect your product first...");
    }
}
