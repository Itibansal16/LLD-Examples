package services;

import dto.parkingSpot.ParkingSpot;
import interfaces.PaymentService;
import paymentMethods.CardPayment;
import paymentMethods.CashPayment;
import paymentMethods.PaymentMethod;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public void acceptCash(int amount) {
        PaymentMethod cashPaymentMethod = new CashPayment();
        cashPaymentMethod.initiatePayment(amount);
    }

    @Override
    public void acceptCreditCard(String cardNumber, int cvv, int amount) {
        PaymentMethod cardPayment = new CardPayment(cardNumber, cvv);
        cardPayment.initiatePayment(amount);
    }
}
