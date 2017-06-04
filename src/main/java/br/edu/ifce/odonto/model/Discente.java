package br.edu.ifce.odonto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Discente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String nome;
	private int idade;
	
	public Discente() {
	}
	
	public Discente(String nome, int idade) {
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
