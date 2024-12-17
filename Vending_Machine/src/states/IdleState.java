package states;

import model.Coin;
import model.Note;
import model.Product;
import service.VendingMachine;

public class IdleState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        if(vendingMachine.getInventory().isAvailable(product)) {
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setCurrentState(vendingMachine.getReadyState());
            System.out.println("Product selected: " + product);
        } else {
            System.out.println("Product not available: " + product);
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select a product first...");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please select a product first...");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product first...");
    }

    @Override
    public void returnChange() {
        System.out.println("No change to return; Please select a product first...");
    }
}
