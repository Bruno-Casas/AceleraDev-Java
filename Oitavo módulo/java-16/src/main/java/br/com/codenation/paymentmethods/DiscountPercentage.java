package br.com.codenation.paymentmethods;

public enum DiscountPercentage {
    CASH(10d),
    DEBIT_CARD(5d),
    CREDIT_CARD(2d),
    TRANSFER(8d);

    private Double priceCover;

    DiscountPercentage(Double discount) {
        this.priceCover = 1 - discount / 100;
    }

    public Double getPriceCover() {
        return priceCover;
    }

}
