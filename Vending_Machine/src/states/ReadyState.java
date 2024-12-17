package states;

import model.Coin;
import model.Note;
import model.Product;
import service.VendingMachine;

public class ReadyState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected; " + vendingMachine.getSelectedProduct() + "... Please make payment now...");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("Inserted coin: " + coin.getValue());
        takeAfterPaymentAction();
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        System.out.println("Inserted note: " + note.getValue());
        takeAfterPaymentAction();
    }

    private void takeAfterPaymentAction() {
        System.out.println("Total payment done till now is: " + vendingMachine.getPayment().getTotalPayment());
        if(vendingMachine.getPayment().getTotalPayment() >= vendingMachine.getSelectedProduct().getPrice()) {
            vendingMachine.setCurrentState(vendingMachine.getDispenseState());
        }
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make payment first...");
    }

    @Override
    public void returnChange() {
        System.out.println("No change to return, Please make payment first...");
    }
}
