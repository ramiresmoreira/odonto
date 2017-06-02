package br.edu.ifce.odonto;

import static org.junit.Assert.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifce.odonto.controllers.AgendamentoController;
import br.edu.ifce.odonto.model.Dentista;
import br.edu.ifce.odonto.model.Horario;
import br.edu.ifce.odonto.model.Paciente;
import br.edu.ifce.odonto.util.*;

public class AgendamentoTest {

//	private Paciente paciente;
//	private List<Horario> horarios;
//	private Dentista dentista;
//
//	@Before
//	public void getDendista() {
//		List<String> fones = new ArrayList<String>();
//		fones.add("85 9.9875-2834");
//		fones.add("85 9.9875-8998");
//		fones.add("85 9.9875-4456");
//		fones.add("85 9.9875-3457");
//		this.dentista =  new Dentista("Karen", "345-456", fones);
//	}
//
//	@Before
//	public void getCincoHorarios() {
//		horarios = new ArrayList<Horario>();
//		horarios.add(new Horario(8, 00, SemanaUtil.getDays().get("segunda-FEIRA".toUpperCase())));
//		horarios.add(new Horario(9, 30, SemanaUtil.getDays().get("QUARTA-FEIRA".toUpperCase())));
//		horarios.add(new Horario(9, 00, SemanaUtil.getDays().get("quinta-FEIRA".toUpperCase())));
//		horarios.add(new Horario(7, 30, SemanaUtil.getDays().get("SEGUNDA-FEIRA".toUpperCase())));
//		horarios.add(new Horario(8, 30, SemanaUtil.getDays().get("SEGUNDA-FEIRA".toUpperCase())));
//	}
//
//	@Test
//	public void testaInsercaoDeAgendamentos() {
//		dentista.addHorariosDeAtendimento(horarios);
//		assertTrue(dentista.getHorariosDeAtendimento().size() == 5);
//	}
//
//	@Test
//	public void testaAtualizacaoDeHorariosAgendamento() {
//		dentista.addHorariosDeAtendimento(horarios);
//		horarios.remove(new Horario(7, 30, DayOfWeek.MONDAY));
//		dentista.upadeHorarios(horarios);
//		assertTrue(dentista.getHorariosDeAtendimento().size() == 4);
//	}
//
//	@Test
//	public void testaAgendamento() {
//		dentista.addHorariosDeAtendimento(horarios);
//		paciente = new Paciente("Ramires", dentista);
//		LocalDate data = LocalDate.of(2017, 5, 1);
//		Agendamento.agendar(paciente, data, new Horario(8, 30, data.getDayOfWeek()));
//		assertTrue(dentista.getAgenda().getAgendamentos().size() == 1);
//	}
//
//	@Test
//	public void naoDeveAgendarDuasVezesNoMesmoHorario() {
//		dentista.addHorariosDeAtendimento(horarios);
//		paciente = new Paciente("Ramires", dentista);
//		Paciente paciente2 = new Paciente("Joao", dentista);
//		LocalDate data = LocalDate.of(2017, 5, 1);
//		Horario horario = new Horario(7, 30, data.getDayOfWeek());
//		Agendamento.agendar(paciente, data, horario);
//		Agendamento.agendar(paciente2, data, horario);
//		assertTrue(dentista.getAgenda().getAgendamentos().size() == 1);
//		assertTrue(dentista.getAgenda().getAgendamentos().
//				get(Agendamento.transformToDateTime(data, horario)).equals(paciente));
//	}
}
