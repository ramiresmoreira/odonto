package br.edu.ifce.odonto.model;

import java.time.LocalDate;
import java.util.Map;

import spark.Request;

public class Intervalo {
	private LocalDate inicio; //year, month, day
	private LocalDate fim;
	
	
	public Intervalo(Request req) {
		setInicio(req);
		setFim(req);
	}
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(Request req) {
		Map<String, String> map = req.params();
		this.inicio = LocalDate.of(toInt(map.get(":anoi")), toInt(map.get(":mesi")), toInt(map.get(":diai")));
	}
	public LocalDate getFim() {
		return fim;
	}
	public void setFim(Request req) {
		Map<String, String> map = req.params();
		this.fim  = LocalDate.of(toInt(map.get(":anof")), toInt(map.get(":mesf")), toInt(map.get(":diaf")));
	}
	
	private static int toInt(String str) {
		return Integer.parseInt(str);
	}

	
	@Override
	public String toString() {
		return "Intervalo [inicio=" + inicio + ", fim=" + fim + "]";
	}
	
	
	
}
