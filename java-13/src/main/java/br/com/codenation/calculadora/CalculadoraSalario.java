package br.com.codenation.calculadora;

public class CalculadoraSalario {

	public int calcularSalarioLiquido(double salarioBase) {
		if (salarioBase < 1039.0)
			return 0;

		double salarioLiquido = salarioBase;

		//Desconta o INSS.
		salarioLiquido -= calcularInss(salarioBase);
		//Desconta o IRSS.
		salarioLiquido -= calcularIrrf(salarioLiquido);

		return (int) Math.round(salarioLiquido);
	}
	
	private double calcularInss(double salarioBase) {
		double percentual;

		if(salarioBase <= 1500.0)
			percentual = 0.08;
		else if(salarioBase <= 4000.0)
			percentual = 0.09;
		else
			percentual = 0.11;

		return salarioBase * percentual;
	}

	private double calcularIrrf(double salarioBruto) {
		double percentual;
		
		if(salarioBruto <= 3000.0)
			return 0.0;
		else if(salarioBruto <= 6000.0)
			percentual = 0.075;
		else
			percentual = 0.15;

		return salarioBruto * percentual;
	}

}
