package br.edu.ifce.odonto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Horario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private int hora;
	private int minuto;
	private String diaDaSemana;
	

	public Horario() {
		// TODO Auto-generated constructor stub
	}

	public Horario(int hora, int minuto, String diaDaSemana) {
		this.hora = hora;
		this.minuto = minuto;
		this.diaDaSemana = diaDaSemana;
		
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public String getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(String diaDasemana) {
		this.diaDaSemana = diaDasemana;
	}

	@Override
	public String toString() {
		return "Horario [hora=" + hora + ", minuto=" + minuto + ", diaDasemana=" + diaDaSemana + "]";
	}
	
}
