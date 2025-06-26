package entity;

import interfaces.CalculadoraSalario;
import interfaces.Gerenciamento;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Classe responsável por gerenciar os médicos cadastrados no sistema
public class SistemaMedico implements Gerenciamento {

	// Lista de médicos 
	private static List <Medico> medicos=new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	 
	 // Método para incluir um médico manualmente (digitado pelo usuário)
	@Override
	public void Incluir() {
		 System.out.println("\n--- Cadastro de Médico ---");
		    
		    System.out.print("Nome do Médico: ");
		    String nome = sc.nextLine();
		    
		    System.out.print("CPF do Médico: ");
		    String cpf = sc.nextLine();
		    
		    System.out.print("Especialidade do Médico: ");
		    String especialidade = sc.nextLine();
		    
		    System.out.print("Salário por hora do Médico: ");
		    double salarioHora = sc.nextDouble();
		    sc.nextLine(); 
		    
			// Define o tipo de cálculo de salário com base na especialidade
		    CalculadoraSalario calculadora;
		    if (especialidade.equalsIgnoreCase("Generalista")) {
		        calculadora = new CalculoGeneralista();
		    } else {
		        calculadora = new CalculoEspecialista();
		    }
		    
			// Cria o objeto médico e adiciona à lista
		    Medico medico = new Medico(nome, cpf, especialidade, salarioHora, calculadora);
		    medicos.add(medico);
		    
		    System.out.println("Médico cadastrado com sucesso!");
		  
		
	}
	
	 // Método para cadastrar médicos automaticamente (sem digitação) 
	public void IncluirAuto() {
		medicos.add(new Medico("Dr. Everton Oliveira", "1", "Cardiologista", 150.0, new CalculoEspecialista()));
		medicos.add(new Medico("Dr. Thiago Sampaio", "2", "Pediatra", 120.0, new CalculoEspecialista()));
		medicos.add(new Medico("Dr. Vitor Thadeu", "3", "Generalista", 100.0, new CalculoGeneralista()));
		medicos.add(new Medico("Dr. Silas Pereira", "4", "Ortopedista", 180.0, new CalculoEspecialista()));
		medicos.add(new Medico("Dr. Poggers da Silva", "5", "Generalista", 100.0, new CalculoGeneralista()));
		medicos.add(new Medico("Dra. Noggers da Silva", "6", "Neurologista", 200.0, new CalculoEspecialista()));
		medicos.add(new Medico("Dr. Jeguelson Albuquerque", "7", "Generalista", 100.0, new CalculoGeneralista()));
		
	}

	//Método para alterar a especialidade do médico pelo cpf
	@Override
	public void Alterar() {
		 System.out.print("\nDigite o cpf do médico a ser alterado");
		 String cpf = sc.nextLine();
		 for (Medico medico : medicos) {
			if (medico.getCpf().equals(cpf)) {
				System.out.print("\nDigite a nova especialidade do medico");
				String novaEspecialidade=sc.nextLine();
				medico.setEspecialidade(novaEspecialidade);
				System.out.print("\nEspecialidade alterada com sucesso");
				
			}
		}
		
	}

	//Método para excluir um médico pelo cpf
	@Override
	public void Excluir() {
		
		   System.out.print("Digite o CPF do Medico que deseja remover: ");
		    String cpf = sc.nextLine();

		    Medico Removedor = null;
		    for (Medico medico : medicos) {
		        if (medico.getCpf().equals(cpf)) {
		        	Removedor = medico;
		            break;
		        }
		    }

		    if (Removedor == null) {
		        System.out.println("Médico não encontrado para a remoção!");
		    } else {
		        medicos.remove(Removedor);
		        System.out.println("Médico removido com sucesso!");
		    }
		
	}

	//Método para listar todos os médicos, em ordem alfabética
	@Override
	public void Listar() {
		medicos.sort(Comparator.comparing(Medico::getNome));
		for (Medico medico : medicos) {
			System.out.println(medico.exibirDetalhes());
		}
		
	}

	//Método para buscar o médico pelo cpf e exibir seus dados
	@Override
	public void Buscar(String Cpf) {
		for (Medico medico : medicos) {
			if (medico.getCpf().equals(Cpf)) {
				System.out.println(medico.exibirDetalhes());
			}
		}
		
	}
	
	//Método que mostra o salário de um médico conforme as horas trabalhadas
	public void MostraSalario(String Cpf) {
		for (Medico medico : medicos) {
			if (medico.getCpf().equals(Cpf)) {
				System.out.println("Forneça as horas trabalhadas");
				int horas=sc.nextInt();
				sc.nextLine();
				double salario=medico.calculaSalario(horas);
				System.out.println("Salário do Médico "+ medico.getNome()+":" + String.format("R$ %.2f", salario) );
				
			}
		}
	}
	
	// Método auxiliar que retorna um objeto médico pelo CPF (usado por outras classes)
	public static Medico Retorna(String cpf) {
	    for (Medico medico : medicos) {
	        if (medico.getCpf().equals(cpf)) {
	            return medico;
	        }
	    }
	    return null;
	}
	
	

	
	
	
	
	
}
