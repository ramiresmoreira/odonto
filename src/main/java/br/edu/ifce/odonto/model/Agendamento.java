package br.edu.ifce.odonto.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=javax.persistence.CascadeType.ALL)
	@JoinColumn(name="dentista_id")
	Dentista dentista;
	
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=javax.persistence.CascadeType.ALL)
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=javax.persistence.CascadeType.ALL)
	@JoinColumn(name="horario_id")
	private Horario horario;
	
	private String observacao;
	
	public Agendamento() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Dentista getDentista() {
		return dentista;
	}
	
	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	public Horario getHorario() {
		
		return horario;
	}
	
	public void setHorario(Horario horario) {
		this.horario = horario;
	}



}
