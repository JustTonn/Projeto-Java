package entity;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Consulta {
	Medico medico;
	Paciente paciente;
	Date data;
	static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
	public Consulta(Medico medico, Paciente paciente, Date data) {
		super();
		this.medico = medico;
		this.paciente = paciente;
		this.data = data;
	}
	
	
	
	public Medico getMedico() {
		return medico;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public Date getData() {
		return data;
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Medico: "+ medico.getNome() + " Paciente: " + paciente.getNome());
		sb.append("Data:");
		sb.append(sdf.format(data) + "\n");
		
		return sb.toString();
	}
	
	
	
}
