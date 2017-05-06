package br.edu.ifce.odonto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.ifce.odonto.model.Dentista;
import br.edu.ifce.odonto.model.Horario;
import br.edu.ifce.odonto.util.SemanaUtil;

public class DentistaTest {
	public Dentista getDendista() {
		List<String> fones = new ArrayList<String>();
		fones.add("85 9.9875-2834");
		fones.add("85 9.9875-8998");
		fones.add("85 9.9875-4456");
		fones.add("85 9.9875-3457");
		return new Dentista("Karen", "345-456", fones);
	}
	
	public List<Horario> getCincoHorarios() {
		List<Horario> horarios = new ArrayList<Horario>();
		horarios.add(new Horario(8, 00, SemanaUtil.getDays().get("segunda-FEIRA".toUpperCase())));
		horarios.add(new Horario(9, 30, SemanaUtil.getDays().get("QUARTA-FEIRA".toUpperCase())));
		horarios.add(new Horario(9, 00, SemanaUtil.getDays().get("quinta-FEIRA".toUpperCase())));
		horarios.add(new Horario(7, 30, SemanaUtil.getDays().get("SEGUNDA-FEIRA".toUpperCase())));
		horarios.add(new Horario(8, 30, SemanaUtil.getDays().get("SEGUNDA-FEIRA".toUpperCase())));
		return horarios;
	}

	@Test
	public void testaInsercaoDeAgendamentos() {
		Dentista dentista = getDendista();
		List<Horario> horarios = getCincoHorarios();
		dentista.addHorariosDeAtendimento(horarios);
		boolean teste = dentista.getHorariosDeAtendimento().size() == 5;
		Assert.assertTrue(teste);
	}
	
	@Test
	public void testaHorariosInseridos(){
		Dentista dentista = getDendista();
		List<Horario> horarios = getCincoHorarios();
		dentista.addHorariosDeAtendimento(horarios);
		Assert.assertTrue(dentista.getHorariosDeAtendimento().containsAll(horarios));
	}
	
}
