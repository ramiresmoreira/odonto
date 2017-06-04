package br.edu.ifce.odonto.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Paciente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String nome;
	private int idade;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=javax.persistence.CascadeType.ALL)
	@JoinColumn(name="dentista_id")
	Dentista dentista;
	
	public Paciente() {
	}
	
	public Paciente(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}
}
