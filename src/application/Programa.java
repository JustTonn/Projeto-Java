package application;

import java.util.Scanner;

import entity.SistemaConsultas;
import entity.SistemaMedico;
import entity.SistemaPaciente;

public class Programa {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaMedico sistemaMedico = new SistemaMedico();
        SistemaPaciente sistemaPaciente = new SistemaPaciente();
        SistemaConsultas sistemaConsultas = new SistemaConsultas();
        
        // aqui é pra cadastrar os dados automaticamente, professor pediu
        sistemaMedico.IncluirAuto();
        sistemaPaciente.IncluirAuto();
        sistemaConsultas.IncluirAuto();
        
        int opcao;
        do {
            System.out.println("\n===== SISTEMA CLÍNICA MÉDICA =====");
            System.out.println("1. Gerenciamento de Médicos");
            System.out.println("2. Gerenciamento de Pacientes");
            System.out.println("3. Gerenciamento de Consultas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = sc.nextInt();
            sc.nextLine(); 
            
            switch(opcao) {
                case 1:
                    menuMedicos(sc, sistemaMedico);
                    break;
                case 2:
                    menuPacientes(sc, sistemaPaciente);
                    break;
                case 3:
                    menuConsultas(sc, sistemaConsultas);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
        
        sc.close();
    }
    
    private static void menuMedicos(Scanner sc, SistemaMedico sistema) {
        int opcao;
        do {
            System.out.println("\n===== GERENCIAMENTO DE MÉDICOS =====");
            System.out.println("1. Incluir médico");
            System.out.println("2. Alterar médico");
            System.out.println("3. Excluir médico");
            System.out.println("4. Listar médicos");
            System.out.println("5. Buscar médico por CPF");
            System.out.println("6. Mostrar salário do médico");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao) {
                case 1:
                    sistema.Incluir();
                    break;
                case 2:
                    sistema.Alterar();
                    break;
                case 3:
                    sistema.Excluir();
                    break;
                case 4:
                    sistema.Listar();
                    break;
                case 5:
                    System.out.print("Digite o CPF do médico: ");
                    String cpf = sc.nextLine();
                    sistema.Buscar(cpf);
                    break;
                    
                case 6:
                    System.out.print("Digite o CPF do médico: ");
                    cpf = sc.nextLine();
                    sistema.MostraSalario(cpf);
                    break;   
                    
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
    }
    
    private static void menuPacientes(Scanner sc, SistemaPaciente sistema) {
        int opcao;
        do {
            System.out.println("\n===== GERENCIAMENTO DE PACIENTES =====");
            System.out.println("1. Incluir paciente");
            System.out.println("2. Alterar paciente");
            System.out.println("3. Excluir paciente");
            System.out.println("4. Listar pacientes");
            System.out.println("5. Buscar paciente por CPF");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao) {
                case 1:
                    sistema.Incluir();
                    break;
                case 2:
                    sistema.Alterar();
                    break;
                case 3:
                    sistema.Excluir();
                    break;
                case 4:
                    sistema.Listar();
                    break;
                case 5:
                    System.out.print("Digite o CPF do paciente: ");
                    String cpf = sc.nextLine();
                    sistema.Buscar(cpf);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
    }
    
    private static void menuConsultas(Scanner sc, SistemaConsultas sistema) {
        int opcao;
        do {
            System.out.println("\n===== GERENCIAMENTO DE CONSULTAS =====");
            System.out.println("1. Incluir consulta");
            System.out.println("2. Alterar consulta");
            System.out.println("3. Excluir consulta");
            System.out.println("4. Listar consultas");
            System.out.println("5. Buscar consulta por CPF do paciente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao) {
                case 1:
                    sistema.Incluir();
                    break;
                case 2:
                    sistema.Alterar();
                    break;
                case 3:
                    sistema.Excluir();
                    break;
                case 4:
                    sistema.Listar();
                    break;
                case 5:
                    System.out.print("Digite o CPF do paciente: ");
                    String cpf = sc.nextLine();
                    sistema.Buscar(cpf);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
    }
}
