package br.edu.ifce.odonto.controllers;

public class Agendamento {

//	public static void agendar(Paciente paciente, LocalDate data, Horario horario) throws IndexOutOfBoundsException{
//		LocalDateTime dateTime = transformToDateTime(data, horario);
//		Dentista dentista = paciente.getDentista();
//		Agenda agendaDentista = dentista.getAgenda();
//		Collection<Horario> horariosDeAtendimento = dentista.getHorariosDeAtendimento();
//		
//		if (horariosDeAtendimento.contains(horario))
//			if (agendaDentista.dataIsDisponivel(dateTime))
//				agendaDentista.add(dateTime, paciente);
//	}
//
//	public static LocalDateTime transformToDateTime(LocalDate data, Horario horario) {
//		return LocalDateTime.of(data.getYear(), data.getMonth(), data.getDayOfMonth(), horario.getHorario().getHour(),
//				horario.getHorario().getMinute());
//	}
}
