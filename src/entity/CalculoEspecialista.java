package entity;

import interfaces.CalculadoraSalario;

public class CalculoEspecialista implements CalculadoraSalario {

	@Override
	public double calcular(double salario, int horas) {
		return (salario*horas)*1.3;
	}

}
