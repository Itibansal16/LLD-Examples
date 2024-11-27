package paymentMethods;

public class CardPayment extends PaymentMethod{
    private String cardNumber;
    private int cvv;

    public CardPayment(String cardNumber, int cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public boolean initiatePayment(int amount) {
        return false;
    }
}
