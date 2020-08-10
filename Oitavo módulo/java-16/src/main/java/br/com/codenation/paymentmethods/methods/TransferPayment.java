package br.com.codenation.paymentmethods.methods;

import br.com.codenation.paymentmethods.DiscountPercentage;
import br.com.codenation.paymentmethods.PriceStrategy;

public class TransferPayment implements PriceStrategy {

	@Override
	public Double calculate(Double price) {
		return price * DiscountPercentage.TRANSFER.getPriceCover();
	}
	
}
