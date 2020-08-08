package com.challenge.desafio;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

public class CalculadorDeClasses implements Calculavel {

	@Override
	public BigDecimal somar(Object obj) {
		return accumulate(Somar.class, obj);
	}

	@Override
	public BigDecimal subtrair(Object obj) {
		return accumulate(Subtrair.class, obj);
	}

	@Override
	public BigDecimal totalizar(Object obj) {
		return somar(obj).subtract(subtrair(obj));
	}

	private BigDecimal accumulate(Class<? extends Annotation> annotation, Object obj) {
		BigDecimal result = BigDecimal.ZERO;

		for (Field field : obj.getClass().getDeclaredFields()) {
			if (isValidField(field, annotation)) {
				try {
					field.setAccessible(true);
					result = result.add((BigDecimal) field.get(obj));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	private boolean isValidField(Field field, Class<? extends Annotation> annotation) {
		if (field.getType().isAssignableFrom(BigDecimal.class))
			if (field.isAnnotationPresent(annotation))
				return true;

		return false;
	}
}
