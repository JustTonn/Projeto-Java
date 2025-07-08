package entity;

import interfaces.Gerenciamento;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Classe responsável por gerenciar os pacientes do sistema//
public class SistemaPaciente implements Gerenciamento {

	//Lista de pacientes 
	private static List <Paciente> pacientes=new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	// Método para incluir paciente manualmente
	@Override
	public void Incluir() {
		System.out.println("\n--- Cadastro de Paciente ---");

        System.out.print("Nome do paciente: ");
        String nome = sc.nextLine();

        System.out.print("CPF do paciente: ");
        String cpf = sc.nextLine();

       System.out.print("Idade do paciente: ");
		int idade = sc.nextInt();
		sc.nextLine(); 

		Paciente paciente = new Paciente(nome, cpf, idade);
		pacientes.add(paciente);


        System.out.println("Paciente cadastrado com sucesso!");
		 
	}

	// Método para cadastrar pacientes automáticamente
	public void IncluirAuto() {
		 pacientes.add(new Paciente("Estevao da Silva", "12", 25));
	     pacientes.add(new Paciente("Thiago Silva", "13", 30));
	     pacientes.add(new Paciente("Cole Palmer", "14", 40));
	     pacientes.add(new Paciente("Artur Kronbauer", "15", 18));
	     pacientes.add(new Paciente("Pedro Costa", "16", 55));
	     pacientes.add(new Paciente("Juliana Geromel", "17", 32));
	     pacientes.add(new Paciente("Lucas Arrascaeta", "18", 28));
		
	}

	// Método para alterar a idade do paciente 
	@Override
	public void Alterar() {
		
		System.out.print("\nDigite o cpf do paciente a ser alterado");
		 String cpf = sc.nextLine();
		 for (Paciente paciente : pacientes) {
			if (paciente.getCpf().equals(cpf)) {
				System.out.print("\nDigite a nova idade do paciente");
				int novaidade=sc.nextInt();
				sc.nextLine();
				paciente.setIdade(novaidade);
				System.out.print("\nIdade alterada com sucesso");
				
			}
		}
		
	}

	// Método para excluir paciente
	@Override
	public void Excluir() {
		
		   System.out.print("Digite o CPF do Paciente que deseja remover: ");
		    String cpf = sc.nextLine();

		    Paciente Removedor = null;
		    for (Paciente paciente : pacientes) {
		        if (paciente.getCpf().equals(cpf)) {
		        	Removedor = paciente;
		            break;
		        }
		    }

		    if (Removedor == null) {
		        System.out.println("Paciente não encontrado para a remoção!");
		    } else {
		        pacientes.remove(Removedor);
		        System.out.println("Paciente removido com sucesso!");
		    }
		
	}

	// Método para listar os pacientes em ordem alfabética
	@Override
	public void Listar() {
		pacientes.sort(Comparator.comparing(Paciente::getNome));
		for (Paciente paciente : pacientes) {
			System.out.println(paciente.exibirDetalhes());
		}
		
	}

	// Método para buscar um paciente por CPF
	@Override
	public void Buscar(String Cpf) {
		for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(Cpf)) {
                System.out.println(paciente.exibirDetalhes());
            }
        }
		
	}
	
	// Método auxiliar que retorna um objeto paciente pelo CPF (usado por outras classes)
	public static Paciente Retorna(String cpf) {
	    for (Paciente paciente : pacientes) {
	        if (paciente.getCpf().equals(cpf)) {
	            return paciente;
	        }
	    }
	    return null;
	}
	
	
}
