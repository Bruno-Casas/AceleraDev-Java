package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {
	private static final int FIBONACCI_LIMIT = 350;

	public static List<Integer> fibonacci() {
		List<Integer> fibonacciSequence = new ArrayList<>();
		fibonacciSequence.add(0);
		fibonacciSequence.add(1);

		int fibonacciLength;
		int lastFibonacciElement = 0;
		while (lastFibonacciElement < FIBONACCI_LIMIT) {
			fibonacciLength = fibonacciSequence.size();

			lastFibonacciElement = fibonacciSequence.get(fibonacciLength - 1)
					+ fibonacciSequence.get(fibonacciLength - 2);

			fibonacciSequence.add(lastFibonacciElement);
		}

		return fibonacciSequence;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}
}
