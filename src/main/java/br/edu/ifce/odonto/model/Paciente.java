package br.edu.ifce.odonto.model;

public class Paciente {

	private Dentista dentista;
	private String nome;

	public Paciente(String nome, Dentista pDentista) {
		this.nome = nome;
		this.dentista = pDentista;
	}
	
	public Dentista getDentista() {
		return this.dentista;
	}
	

}
