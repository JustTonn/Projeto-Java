package entity;

import interfaces.CalculadoraSalario;

public class CalculoGeneralista implements CalculadoraSalario {

	@Override
	public double calcular(double salario, int horas) {
		return salario*horas;
	}

}
