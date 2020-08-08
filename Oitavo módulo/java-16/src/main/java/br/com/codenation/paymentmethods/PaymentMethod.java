package br.com.codenation.paymentmethods;

import br.com.codenation.paymentmethods.methods.CashPayment;
import br.com.codenation.paymentmethods.methods.CreditCardPayment;
import br.com.codenation.paymentmethods.methods.DebitCardPayment;
import br.com.codenation.paymentmethods.methods.TransferPayment;

public enum PaymentMethod {
    
    CASH(new CashPayment()),
    DEBIT_CARD(new DebitCardPayment()),
    CREDIT_CARD(new CreditCardPayment()),
    TRANSFER(new TransferPayment());

    private PriceStrategy priceStrategy;

    PaymentMethod(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public PriceStrategy getPaymentStrategy() {
        return priceStrategy;
    }

}
