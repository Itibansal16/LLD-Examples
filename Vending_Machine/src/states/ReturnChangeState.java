package states;

import model.Coin;
import model.Note;
import model.Product;
import service.VendingMachine;

public class ReturnChangeState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Please collect the change first...");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please collect the change first...");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please collect the change first...");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please collect the change, product is already dispensed...");
    }

    @Override
    public void returnChange() {
        double change = vendingMachine.getPayment().getTotalPayment() - vendingMachine.getSelectedProduct().getPrice();
        if(change > 0) {
            System.out.println("Change returned: " + change);
        } else {
            System.out.println("No change to return");
        }
        vendingMachine.reset();
    }
}
