package br.com.codenation.paymentmethods.methods;

import br.com.codenation.paymentmethods.DiscountPercentage;
import br.com.codenation.paymentmethods.PriceStrategy;

public class CashPayment implements PriceStrategy{

	@Override
	public Double calculate(Double price) {
		return price * DiscountPercentage.CASH.getPriceCover();
	}
	
}
