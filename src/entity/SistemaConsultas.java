package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import interfaces.Gerenciamento;

public class SistemaConsultas implements Gerenciamento {
	private static List <Consulta> consultas=new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	@Override
	public void Incluir() {
		try {
	        System.out.println("----- Cadastro de Consulta -----");

	        // Dados Médico
	        System.out.print("CPF do médico: ");
	        String cpfMedico = sc.nextLine();

	        // Dados Paciente
	        System.out.print("Cpf do paciente: ");
	        String cpfPaciente = sc.nextLine();

	        // Data Consulta
	        System.out.print("Data da consulta (dd/MM/yyyy): ");
	        String datastr = sc.nextLine();
	        Date data = sdf.parse(datastr);

	        // Criar os objetos
	        Medico medico = SistemaMedico.Retorna(cpfMedico);
	        Paciente paciente = SistemaPaciente.Retorna(cpfPaciente);
	        Consulta consulta = new Consulta(medico, paciente, data);
			
			 if (SistemaMedico.Retorna(cpfMedico)==null||SistemaPaciente.Retorna(cpfPaciente)==null ) {
	        	 System.out.println("Erro no Cadastro da Consulta!");
				 
			}
			else{
				consultas.add(consulta);
	        System.out.println("Consulta cadastrada com sucesso!");
			}
	        

	    } catch (Exception e) {
	        System.out.println("Erro ao cadastrar consulta: ");
	    }
		
	}

		
	
	public void IncluirAuto() {
		try {
	        System.out.println("----- Cadastro de Consulta -----");

	        Date data1 = sdf.parse("01/06/2025");
	        Date data2 = sdf.parse("02/06/2025");
	        Date data3 = sdf.parse("03/06/2025");
	        Date data4 = sdf.parse("04/06/2025");
	        Date data5 = sdf.parse("05/06/2025");
	        Date data6 = sdf.parse("06/06/2025");
	        Date data7 = sdf.parse("07/06/2025");

	        // Consulta 1
	        Medico m1 = new Medico("Dr. Everton Oliveira", "60", "Cardiologista");
	        Paciente p1 = new Paciente("Carlinhos ", "61", 45);
	        consultas.add(new Consulta(m1, p1, data1));

	        // Consulta 2
	        Medico m2 = new Medico("Dr. Bruno", "62", "Pediatra");
	        Paciente p2 = new Paciente("Ana Rita", "63", 10);
	        consultas.add(new Consulta(m2, p2, data2));

	        // Consulta 3
	        Medico m3 = new Medico("Dra. GenteBoa", "64", "Dermatologista");
	        Paciente p3 = new Paciente("João Games", "65", 30);
	        consultas.add(new Consulta(m3, p3, data3));

	        // Consulta 4
	        Medico m4 = new Medico("Dr. Hans Chucrute", "66", "Ortopedista");
	        Paciente p4 = new Paciente("José Roberto", "67", 55);
	        consultas.add(new Consulta(m4, p4, data4));

	        // Consulta 5
	        Medico m5 = new Medico("Dra. Ericka", "68", "Neurologista");
	        Paciente p5 = new Paciente("Fernanda Caetano", "69", 19);
	        consultas.add(new Consulta(m5, p5, data5));

	        // Consulta 6
	        Medico m6 = new Medico("Dr. Volpi", "70", "Oftalmologista");
	        Paciente p6 = new Paciente("Larissa Meirelles", "71", 37);
	        consultas.add(new Consulta(m6, p6, data6));

	        // Consulta 7
	        Medico m7 = new Medico("Dr. Hannibal Lecter", "71", "Psiquiatra");
	        Paciente p7 = new Paciente("Will Graham", "72", 28);
	        consultas.add(new Consulta(m7, p7, data7));

	  

	    } catch (Exception e) {
	        System.out.println("Erro ao cadastrar consulta: ");
	    }
		
	}
	

	@Override
	public void Listar() {
		consultas.sort(Comparator.comparing(Consulta::getData));
		for (Consulta consulta : consultas) {
			System.out.println(consulta.toString());
		}
		
	}

	@Override
	public void Excluir() {
		
	    System.out.print("Digite o CPF do paciente da consulta que deseja remover: ");
	    String cpf = sc.nextLine();

	    Consulta Removedor = null;
	    for (Consulta consulta : consultas) {
	        if (consulta.getPaciente().getCpf().equals(cpf)) {
	        	Removedor = consulta;
	            break;
	        }
	    }

	    if (Removedor == null) {
	        System.out.println("Consulta não encontrada!");
	    } else {
	        consultas.remove(Removedor);
	        System.out.println("Consulta removida com sucesso!");
	    }
	}

	@Override
	public void Alterar() {
		 System.out.print("\nDigite o cpf do paciente a ser alterado");
		 String cpf = sc.nextLine();
		 for (Consulta consulta : consultas) {
			if (consulta.getPaciente().getCpf().equals(cpf)) {
				System.out.print("\nDigite o novo nome do paciente");
				String novoNome=sc.nextLine();
				consulta.getPaciente().setNome(novoNome);
				System.out.print("\nNome alterado com sucesso");
				
			}
		}
	}

	@Override
	public void Buscar(String Cpf) {
		for (Consulta consulta : consultas) {
            if (consulta.getPaciente().getCpf().equals(Cpf)) {
                System.out.println(consulta.toString());
            }
        }
		
	}



	

	


	
	
}
