package entity;

// A classe Paciente herda de Pessoa
public class Paciente extends Pessoa {

	// Atributo do paciente
	private Integer idade;
	
	// Construtor que recebe nome, CPF e idade do paciente
	public Paciente(String nome, String cpf,Integer idade) {
		super(nome, cpf); //Herdando nome e cpf da classe abstrata Pessoa :)
		this.idade=idade;
	}
	
	

	public Integer getIdade() {
		return idade;
	}



	public void setIdade(Integer idade) {
		this.idade = idade;
	}


	// Sobrescreve o método exibirDetalhes() herdado da classe Pessoa
	@Override
	public String exibirDetalhes() {
		return "Paciente: "+ getNome() + " Idade: " + idade +" Cpf: " + getCpf() ;
		//Polimorfismo, estou mudando o metodo abstrato para mostrar o nome do paciente, sua idade e seu cpf
		
	}

	
	
	
}
