package br.edu.ifce.odonto.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column
	private LocalTime hora;

	@Column
	private LocalDate data;
	
	@Enumerated(EnumType.STRING)
	@Column(name="dia_da_semana")
	private DayOfWeek diaDaSemana;

	public Horario() {
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDiaDaSemana(DayOfWeek diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public DayOfWeek getDiaDaSemana() {
		return diaDaSemana;
	}
}
