package states;

import model.Coin;
import model.Note;
import model.Product;

public interface VendingMachineState {
    void selectProduct(Product product);

    void insertCoin(Coin coin);

    void insertNote(Note note);

    void dispenseProduct();

    void returnChange();
}
