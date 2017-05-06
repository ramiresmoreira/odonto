package br.edu.ifce.odonto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import br.edu.ifce.odonto.util.ComparadorHorario;

public class Dentista {
	String nome;
	String crm;
	List<String> fones;
	List<Horario> horariosDeAtendimento = new ArrayList<Horario>();
	Agenda agenda = new Agenda();

	public Dentista(String nome, String crm, List<String> fones) {
		this.nome = nome;
		this.crm = crm;
		this.fones = fones;
	}
	
	public void addHorariosDeAtendimento(List<Horario> horarios) {
		horariosDeAtendimento.addAll(horarios);
	}

	public Collection<Horario> getHorariosDeAtendimento() {
		horariosDeAtendimento.sort(new ComparadorHorario());
		return Collections.unmodifiableCollection(horariosDeAtendimento);
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void upadeHorarios(List<Horario> novosHorarios){
		horariosDeAtendimento.clear();
		horariosDeAtendimento.addAll(novosHorarios);
	}
}
