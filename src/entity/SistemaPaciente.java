package entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import interfaces.Gerenciamento;

public class SistemaPaciente implements Gerenciamento {
	private static List <Paciente> pacientes=new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	
	@Override
	public void Incluir() {
		 
		
	}
	public void IncluirAuto() {
		 pacientes.add(new Paciente("Everton Oliveira", "12", 25));
	     pacientes.add(new Paciente("Maria Silva", "13", 30));
	     pacientes.add(new Paciente("Thiago Sampaio", "14", 40));
	     pacientes.add(new Paciente("Vitor Thadeu", "15", 18));
	     pacientes.add(new Paciente("Pedro Costa", "16", 55));
	     pacientes.add(new Paciente("Juliana Geromel", "17", 32));
	     pacientes.add(new Paciente("Lucas Arrascaeta", "18", 28));
		
	}

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
		        System.out.println("Consulta não encontrada para a remoção!");
		    } else {
		        pacientes.remove(Removedor);
		        System.out.println("Consulta removida com sucesso!");
		    }
		
	}

	@Override
	public void Listar() {
		pacientes.sort(Comparator.comparing(Paciente::getNome));
		for (Paciente paciente : pacientes) {
			System.out.println(paciente.exibirDetalhes());
		}
		
	}

	@Override
	public void Buscar(String Cpf) {
		for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(Cpf)) {
                System.out.println(paciente.exibirDetalhes());
            }
        }
		
	}
	
	public static Paciente Retorna(String cpf) {
	    for (Paciente paciente : pacientes) {
	        if (paciente.getCpf().equals(cpf)) {
	            return paciente;
	        }
	    }
	    return null;
	}
	
	
}
