package br.com.codenation.paymentmethods.methods;

import br.com.codenation.paymentmethods.DiscountPercentage;
import br.com.codenation.paymentmethods.PriceStrategy;

public class DebitCardPayment implements PriceStrategy {

	@Override
	public Double calculate(Double price) {
		return price * DiscountPercentage.DEBIT_CARD.getPriceCover();
	}
	
}
