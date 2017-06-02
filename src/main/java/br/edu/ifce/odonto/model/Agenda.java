package br.edu.ifce.odonto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Agenda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	@ManyToMany
	@Cascade(CascadeType.ALL)
	private List<Agendamento> agendamentos = new ArrayList<>();

	@OneToOne
	@Cascade(CascadeType.ALL)
	private Dentista dentista;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}
	
	public Dentista getDentista() {
		return dentista;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
	
	public boolean addAgendamento(Agendamento agendamento){
		return agendamentos.add(agendamento);
	}

	@Override
	public String toString() {
		return "Agenda [id=" + id + ", agendamentos=" + agendamentos + ", dentista=" + dentista + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agendamentos == null) ? 0 : agendamentos.hashCode());
		result = prime * result + ((dentista == null) ? 0 : dentista.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (agendamentos == null) {
			if (other.agendamentos != null)
				return false;
		} else if (!agendamentos.equals(other.agendamentos))
			return false;
		if (dentista == null) {
			if (other.dentista != null)
				return false;
		} else if (!dentista.equals(other.dentista))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
