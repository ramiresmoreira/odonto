package br.edu.ifce.odonto.controllers;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import com.google.gson.Gson;

import br.edu.ifce.odonto.DAO.DentistaDAO;
import br.edu.ifce.odonto.model.Agenda;
import br.edu.ifce.odonto.model.Agendamento;
import br.edu.ifce.odonto.model.Dentista;
import br.edu.ifce.odonto.model.Discente;
import br.edu.ifce.odonto.model.Horario;
import br.edu.ifce.odonto.util.JPAUtil;
import spark.Request;
import spark.Response;

public class AgendamentoController {

	public static String agendar(Request req, Response resp) {
		Agendamento agendamento = new Gson().fromJson(req.body(), Agendamento.class);
		Integer idDentista = agendamento.getDentista().getId();
		agendamento.setDentistas(new ArrayList<>());	
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Dentista dentista = manager.find(Dentista.class, idDentista);
		Agenda agenda = DentistaDAO.getAgenda(dentista);
		
		dentista.setAgenda(agenda);
		agenda.setDentista(dentista);
		
		dentista.getAgenda().addAgendamento(agendamento);
		agendamento.addDentista(dentista);
		Discente discente = agendamento.getDiscente();
		agendamento.setDiscentes(new ArrayList<>());
		agendamento.addDiscente(discente);
		
		Horario horario = agendamento.getHorario();
		agendamento.setHorarios(new ArrayList<>());
		agendamento.addHorario(horario);
		
		System.out.println(agendamento);
	
		manager.merge(dentista);
	
		manager.getTransaction().commit();

		return "impllementando";
	}

}
