package br.edu.ifce.odonto.util;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class SemanaUtil {
	
	
	public static Map<String, DayOfWeek> getDays(){
		Map<String, DayOfWeek> dias = new HashMap<>();
		dias.put("SEGUNDA-FEIRA", DayOfWeek.MONDAY);
		dias.put("TERÇA-FEIRA", DayOfWeek.TUESDAY);
		dias.put("QUARTA-FEIRA", DayOfWeek.WEDNESDAY);
		dias.put("QUINTA-FEIRA", DayOfWeek.THURSDAY);
		dias.put("SEXTA-FEIRA", DayOfWeek.FRIDAY);
		dias.put("SÁBADO", DayOfWeek.SATURDAY);
		dias.put("DOMINGO", DayOfWeek.SUNDAY);
		return dias;
	}
	
//	public static Map<DayOfWeek, String> getDias(){
//		Map<DayOfWeek, String> diasEmPortugues = new HashMap<>();
//		diasEmPortugues.put(DayOfWeek.MONDAY, "SEGUNDA-FEIRA");
//		diasEmPortugues.put(DayOfWeek.TUESDAY, "TERÇA-FEIRA");
//		diasEmPortugues.put(DayOfWeek.WEDNESDAY, "QUARTA-FEIRA");
//		diasEmPortugues.put(DayOfWeek.THURSDAY, "QUINTA-FEIRA");
//		diasEmPortugues.put(DayOfWeek.FRIDAY, "SEXTA-FEIRA");
//		diasEmPortugues.put(DayOfWeek.SATURDAY, "SÁBADO");
//		diasEmPortugues.put(DayOfWeek.SUNDAY, "DOMINGO");
//		return diasEmPortugues;
//	}
}
