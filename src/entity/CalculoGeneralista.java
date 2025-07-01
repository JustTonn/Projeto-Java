package entity;

// Importa a interface que define o cálculo de salário
import interfaces.CalculadoraSalario;

public class CalculoGeneralista implements CalculadoraSalario {

	// Implementa o método definido na interface
	@Override
	public double calcular(double salario, int horas) {
		return salario*horas;
	}

}
