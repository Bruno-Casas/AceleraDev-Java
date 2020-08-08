package br.com.codenation.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private static Double SALE_DISCONT = 0.2d;

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the OrderItem value
	 */
	private Double calculateItem(OrderItem item) {
		Optional<Product> opProduct = productRepository.findById(item.getProductId());

		if (opProduct.isEmpty())
			return 0d;

		Product product = opProduct.get();

		Double totalValue = product.getValue() * item.getQuantity();

		if (product.getIsSale())
			return totalValue * (1.0d - SALE_DISCONT);

		return totalValue;
	}

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		return items.stream().mapToDouble(i -> calculateItem(i)).sum();
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream().map(id -> productRepository.findById(id)).filter(Optional::isPresent).map(Optional::get)
				.collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream().mapToDouble(ol -> calculateOrderValue(ol)).sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return productIds.stream().map(id -> productRepository.findById(id).get())
				.collect(Collectors.groupingBy(Product::getIsSale));
	}
}
