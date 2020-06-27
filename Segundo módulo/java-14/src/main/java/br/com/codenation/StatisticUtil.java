package br.com.codenation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StatisticUtil {

	public static int average(int[] elements) {
		int sum = 0;

		for (int element : elements) {
			sum += element;
		}

		return sum / elements.length;
	}

	public static int mode(int[] elements) {
		Map<Integer, Integer> elementsMap = new HashMap<>();

		for (Integer t : elements) {
			Integer value = elementsMap.get(t);
			elementsMap.put(t, value == null ? 1 : value + 1);
		}

		Entry<Integer, Integer> mode = null;
		for (Entry<Integer, Integer> e : elementsMap.entrySet()) {
			if (mode == null || e.getValue() > mode.getValue())
				mode = e;
		}

		return mode.getKey();
	}

	public static int median(int[] elements) {
		int halfElementsSize = elements.length / 2;

		Arrays.sort(elements);

		if (elements.length % 2 == 0)
			return (elements[halfElementsSize - 1] + elements[halfElementsSize]) / 2;

		return elements[halfElementsSize];
	}
}