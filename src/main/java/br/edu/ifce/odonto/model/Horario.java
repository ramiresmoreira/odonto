package br.edu.ifce.odonto.model;

import java.time.LocalDate;

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
	private int dia;
	private int mes;
	private int ano;

	private String diaDaSemana;
	

	public Horario() {
		// TODO Auto-generated constructor stub
	}

	public Horario(int hora, int minuto, String diaDaSemana) {
		this.hora = hora;
		this.minuto = minuto;
		this.diaDaSemana = diaDaSemana;
	}
	
	public LocalDate getData() {
		return LocalDate.of(ano, mes, dia);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaDaSemana == null) ? 0 : diaDaSemana.hashCode());
		result = prime * result + hora;
		result = prime * result + minuto;
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
		Horario other = (Horario) obj;
		if (diaDaSemana == null) {
			if (other.diaDaSemana != null)
				return false;
		} else if (!diaDaSemana.equals(other.diaDaSemana))
			return false;
		if (hora != other.hora)
			return false;
		if (minuto != other.minuto)
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
}
