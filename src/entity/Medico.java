package entity;

// Importa a interface usada para calcular o salário
import interfaces.CalculadoraSalario;

// A classe Medico herda de Pessoa
public class Medico extends Pessoa  {

	// Atributos do médico
	private String especialidade;
	private Double salarioHoraBase;
	private CalculadoraSalario calculadoraSalario;//utilizando o conceito de interface
	
	// Construtor completo, inicializa todos os atributos
	public Medico(String nome, String cpf,String especialidade,Double salarioHoraBase,CalculadoraSalario calculadoraSalario) {
		super(nome, cpf);
		this.especialidade=especialidade;
		this.salarioHoraBase=salarioHoraBase;
		this.calculadoraSalario=calculadoraSalario;
	}
	
	
	// Método que calcula o salário do médico
	// Calcula o salário usando a lógica passada pela interface CalculadoraSalario
	public double calculaSalario(int horas) { //aqui é passado os valores necessários para calcular o salário
		return calculadoraSalario.calcular(salarioHoraBase,horas);
	}
	
	

	public String getEspecialidade() {
		return especialidade;
	}

	

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Double getSalarioHoraBase() {
		return salarioHoraBase;
	}

	// Sobrescreve o método exibirDetalhes() herdado de Pessoa (Polimorfismo)
	@Override
	public String exibirDetalhes() {
		return ("Médico: "+ getNome() + " Especialidade: " + especialidade +" Cpf: " + getCpf() );
		
	}
	
}
