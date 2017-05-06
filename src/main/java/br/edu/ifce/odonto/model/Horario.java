package br.edu.ifce.odonto.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import br.edu.ifce.odonto.util.SemanaUtil;

public class Horario {

	LocalTime horario;
	DayOfWeek diaDaSemana;

	public Horario(int hora, int minuto, DayOfWeek diaDasemana) {
		horario = LocalTime.of(hora, minuto);
		this.diaDaSemana = diaDasemana;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaDaSemana == null) ? 0 : diaDaSemana.hashCode());
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
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
		if (diaDaSemana != other.diaDaSemana)
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		return true;
	}

	public DayOfWeek getDiaDaSemana() {
		return diaDaSemana;
	}

	public LocalTime getHorario() {
		return horario;
	}

}
