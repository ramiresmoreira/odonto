package br.edu.ifce.odonto.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToMany	
	@Cascade(CascadeType.ALL)
	private List<Discente> discentes;
		
	@ManyToMany
	@Cascade(CascadeType.ALL)
	private List<Dentista> dentistas;

	@ManyToMany
	@Cascade(CascadeType.ALL)
	private List<Horario> horarios;
	
	@Transient
	Dentista dentista;
	
	@Transient
	private Discente discente;
	
	@Transient
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

	public Discente getDiscente() {
		return discente;
	}

	public void setDiscente(Discente discente) {
		this.discente = discente;
	}

	public List<Dentista> getDentistas() {
		return dentistas;
	}

	public void setDentistas(List<Dentista> dentistas) {
		this.dentistas = dentistas;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
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
	
	public boolean addDentista(Dentista dentista){
		return dentistas.add(dentista);
	}
	
	public List<Discente> getDiscentes() {
		return discentes;
	}

	public void setDiscentes(List<Discente> discentes) {
		this.discentes = discentes;
	}

	public boolean addDiscente(Discente discente) {
		return discentes.add(discente);
	}

	public Horario getHorario() {
		
		return horario;
	}
	
	public boolean addHorario(Horario horario) {
		return horarios.add(horario);
	}

	@Override
	public String toString() {
		return "Agendamento [discentes=" + discentes + ", dentistas=" + dentistas + ", horarios=" + horarios
				+ ", observacao=" + observacao + "]";
	}

}
