package entity;

public class Paciente extends Pessoa {
	private Integer idade;
	
	
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



	@Override
	public String exibirDetalhes() {
		return "Paciente: "+ getNome() + " Idade: " + idade +" Cpf: " + getCpf() ;
		//Polimorfismo, estou mudando o metodo abstrato para mostrar o nome do paciente, sua idade e seu cpf
		
	}

	
	
	
}
