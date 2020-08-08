package br.com.codenation;

import br.com.codenation.paymentmethods.PriceStrategy;

public class BillingProcessor {

    public Double calculate(Order order) {
        PriceStrategy priceStrategy = order.getPaymentMethod().getPaymentStrategy();

        return priceStrategy.calculate(order.getPrice());
    }

}
