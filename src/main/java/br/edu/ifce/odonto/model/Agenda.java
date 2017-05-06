package br.edu.ifce.odonto.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Agenda {
	
	private Map<LocalDateTime, Paciente> agendamentos = new HashMap<>();
	
	public void add(LocalDateTime data,Paciente paciente){
		agendamentos.put(data, paciente);
	}
	
	public Map<LocalDateTime, Paciente> getAgendamentos(){
		return agendamentos;
	}
	
	public boolean dataIsDisponivel(LocalDateTime data){
		if(agendamentos.get(data) == null)
			return true;
		return false;
	}
	
//	public int getQuantidadeDeAgendamentos(){
//		return agendamentos.size();
//	}
	
//	@Override
//	public String toString() {
//		if(agendamentos.isEmpty())
//			return agendamentos.toString();
//		String string = agendamentos.toString().replace("{", "").replace("}", "");
//		StringTokenizer tokenizer = new StringTokenizer(string, "T");
//		String data = tokenizer.nextToken();
//		String hora = tokenizer.nextToken().substring(0, 5);
//		tokenizer = new StringTokenizer(data, "-");
//		String ano = tokenizer.nextToken();
//		String mes = tokenizer.nextToken();
//		String dia = tokenizer.nextToken();
//		tokenizer = new StringTokenizer(string, "=");
//		tokenizer.nextToken();
//		String paciente = tokenizer.nextToken();
//
//		return paciente +" as "+hora + " no dia "+ dia+"/"+mes+"/"+ano;
//	}
//	
	

	
}
