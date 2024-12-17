package service;

import model.Coin;
import model.Note;
import model.Product;
import repo.Inventory;
import states.DispenseState;
import states.IdleState;
import states.ReadyState;
import states.ReturnChangeState;
import states.VendingMachineState;

public class VendingMachine {
    VendingMachineState currentState;
    VendingMachineState idleState;
    VendingMachineState readyState;
    VendingMachineState dispenseState;
    VendingMachineState returnChangeState;
    Inventory inventory;
    private Product selectedProduct;
    Payment payment;

    public VendingMachine() {
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        currentState = idleState;
        selectedProduct = null;
        this.payment = new Payment();
    }

    public void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        currentState.insertNote(note);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void returnChange() {
        currentState.returnChange();
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getReadyState() {
        return readyState;
    }

    public VendingMachineState getDispenseState() {
        return dispenseState;
    }

    public VendingMachineState getReturnChangeState() {
        return returnChangeState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setCurrentState(VendingMachineState currentState) {
        this.currentState = currentState;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
    public void addCoin(Coin coin) {
        this.payment.addCoin(coin);
    }
    public void addNote(Note note) {
        this.payment.addNote(note);
    }
    public void reset() {
        this.selectedProduct = null;
        this.payment.resetPayment();
        this.setCurrentState(this.idleState);
    }

    public Payment getPayment() {
        return payment;
    }
}
