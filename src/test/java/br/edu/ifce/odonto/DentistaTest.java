package br.edu.ifce.odonto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.ifce.odonto.model.Dentista;
import br.edu.ifce.odonto.model.Horario;
import br.edu.ifce.odonto.util.SemanaUtil;

public class DentistaTest {
	
	private Dentista dentista;
	private List<Horario> horarios;

	@Before
	public void criaDentista() {
		List<String> fones = new ArrayList<String>();
		fones.add("85 9.9875-2834");
		fones.add("85 9.9875-8998");
		fones.add("85 9.9875-4456");
		fones.add("85 9.9875-3457");
		this.dentista = new Dentista("Karen", "345-456", fones);
	}
	
	@Before
	public void criaHorariosDeAtendimento() {
		horarios = new ArrayList<Horario>();
		horarios.add(new Horario(8, 00, SemanaUtil.getDays().get("segunda-FEIRA".toUpperCase())));
		horarios.add(new Horario(9, 30, SemanaUtil.getDays().get("QUARTA-FEIRA".toUpperCase())));
		horarios.add(new Horario(9, 00, SemanaUtil.getDays().get("quinta-FEIRA".toUpperCase())));
		horarios.add(new Horario(7, 30, SemanaUtil.getDays().get("SEGUNDA-FEIRA".toUpperCase())));
		horarios.add(new Horario(8, 30, SemanaUtil.getDays().get("SEGUNDA-FEIRA".toUpperCase())));
	}

	@Test
	public void testaInsercaoDeAgendamentos() {
		dentista.addHorariosDeAtendimento(horarios);
		Assert.assertEquals(5, dentista.getHorariosDeAtendimento().size());
	}
	
	@Test
	public void testaHorariosInseridos(){
		dentista.addHorariosDeAtendimento(horarios);
		Assert.assertTrue(dentista.getHorariosDeAtendimento().containsAll(horarios));
	}
	
}
