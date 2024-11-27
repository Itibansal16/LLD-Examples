package paymentMethods;

public class CashPayment extends PaymentMethod{
    @Override
    public boolean initiatePayment(int amount) {
        System.out.println("Received Cash amount of Rs " + amount);
        return true;
    }
}
