package entity;

import interfaces.CalculadoraSalario;

public class Medico extends Pessoa  {
	private String especialidade;
	private Double salarioHoraBase;
	private CalculadoraSalario calculadoraSalario;//utilizando o conceito de interface
	
	public Medico(String nome, String cpf,String especialidade,Double salarioHoraBase,CalculadoraSalario calculadoraSalario) {
		super(nome, cpf);
		this.especialidade=especialidade;
		this.salarioHoraBase=salarioHoraBase;
		this.calculadoraSalario=calculadoraSalario;
	}
	
	public Medico(String nome, String cpf,String especialidade) {
		super(nome, cpf);
	}
	
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


	@Override
	public String exibirDetalhes() {
		return ("Médico: "+ getNome() + " Especialidade: " + especialidade +" Cpf: " + getCpf() );
		
	}
	
}
