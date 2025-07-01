package entity;

// Importa a interface que define o cálculo de salário
import interfaces.CalculadoraSalario;

public class CalculoEspecialista implements CalculadoraSalario {

	// Implementa o método definido na interface
	// Aplica um bônus de 30% sobre o cálculo normal
	@Override
	public double calcular(double salario, int horas) {
		return (salario*horas)*1.3;
	}

}
