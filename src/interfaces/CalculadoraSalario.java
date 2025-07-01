package interfaces;

// Interface que define um contrato para o cálculo de salário
public interface CalculadoraSalario {

	// Recebe o salário por hora e a quantidade de horas trabalhadas
	public double calcular(double salario,int horas);
}
