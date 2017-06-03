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
import br.edu.ifce.odonto.model.Intervalo;
import br.edu.ifce.odonto.model.Mensagem;
import br.edu.ifce.odonto.util.JPAUtil;
import spark.Request;
import spark.Response;

public class AgendamentoController {

	public static Mensagem agendar(Request req, Response resp) {
		Agendamento agendamento = new Gson().fromJson(req.body(), Agendamento.class);
		
		
		Integer idDentista = agendamento.getDentista().getId();
		agendamento.setDentistas(new ArrayList<>());
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();

		Dentista dentista = manager.find(Dentista.class, idDentista);

		dentista.getAgenda().addAgendamento(agendamento);
		agendamento.addDentista(dentista);
		Discente discente = agendamento.getDiscente();
		agendamento.setDiscentes(new ArrayList<>());
		agendamento.addDiscente(discente);

		Horario horario = agendamento.getHorario();
		agendamento.setHorarios(new ArrayList<>());
		agendamento.addHorario(horario);
		manager.merge(dentista);
		System.out.println(dentista.getAgenda().getAgendamentos().size());

		manager.getTransaction().commit();

		return new Mensagem("agendamento realizado com sucesso", true);
	}

	public static Mensagem getAll(Request req, Response resp) {
		Intervalo intervalo = new Intervalo(req);		
		System.out.println(intervalo.getInicio().getDayOfWeek());
		return new Mensagem(intervalo.toString(), true);
	}

}
