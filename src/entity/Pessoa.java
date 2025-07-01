package entity;

// Classe abstrata que serve como base para tipos de pessoa
public abstract class Pessoa {

	// Atributos de pessoa
	private String nome;
	private String cpf;
	
	// Construtor que inicializa nome e CPF
	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() { //Pega o nome da pessoa
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() { //Pega o cpf da pessoa
		return cpf;
	}
	
	
	public abstract String exibirDetalhes ();//Aqui funcionará o polimorfismo, outras classes chamarão essa função 
	
}
