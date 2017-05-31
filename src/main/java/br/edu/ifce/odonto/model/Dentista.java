package br.edu.ifce.odonto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.edu.ifce.odonto.util.ComparadorHorario;

@Entity
public class Dentista {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	Integer id;
	String nome;
	String crm;
	
	@ElementCollection
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	List<String> fones;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	List<Horario> horariosDeAtendimento = new ArrayList<Horario>();
	
	@Transient
	Agenda agenda = new Agenda();
	
	
	public Dentista() {
		// TODO Auto-generated constructor stub
	}

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

	public Integer getId() {
		return id;
	}	

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public List<String> getFones() {
		return fones;
	}

	public void setFones(List<String> fones) {
		this.fones = fones;
	}
	
	public void setHorariosDeAtendimento(List<Horario> horariosDeAtendimento) {
		this.horariosDeAtendimento = horariosDeAtendimento;
	}
	

	@Override
	public String toString() {
		return "Dentista [id=" + id + ", nome=" + nome + ", crm=" + crm + ", fones=" + fones
				+ ", horariosDeAtendimento=" + horariosDeAtendimento + "]";
	}

	
}
