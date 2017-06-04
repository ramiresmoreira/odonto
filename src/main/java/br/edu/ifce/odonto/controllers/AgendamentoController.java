package br.edu.ifce.odonto.controllers;

import java.util.List;

import com.google.gson.Gson;

import br.edu.ifce.odonto.DAO.AgendamentoDAO;
import br.edu.ifce.odonto.DAO.PacienteDAO;
import br.edu.ifce.odonto.model.Agendamento;
import br.edu.ifce.odonto.model.Intervalo;
import br.edu.ifce.odonto.model.Mensagem;
import br.edu.ifce.odonto.model.Paciente;
import spark.Request;
import spark.Response;

public class AgendamentoController {
	
	private static AgendamentoDAO dao = new AgendamentoDAO();

	public static Mensagem agendar(Request req, Response resp) {
		Agendamento agendamento = new Gson().fromJson(req.body(), Agendamento.class);
		/*
		 * para que o json nao seja muito carregado de informação pode-se enviar
		 * somento o id do dentista e do paciente, e em seguida recuperamos os dados 
		 * no DB atualizamos o agendamento, essa operção é importante, pois evita
		 * que alguns dados sejam sobrescritos, seja por erro ou por má inteção.  
		*/
		Paciente paciente = new PacienteDAO().get(agendamento.getPaciente().getId());
		agendamento.setPaciente(paciente);
		agendamento.setDentista(paciente.getDentista());
		
		dao.save(agendamento);
		return new Mensagem("agendamento relizado com sucesso!", true);
	}

	public static Mensagem getAll(Request req, Response resp) {
		Intervalo intervalo = new Intervalo(req);		
		System.out.println(intervalo.getInicio().getDayOfWeek());
		return new Mensagem(intervalo.toString(), true);
	}

	public static List<Agendamento> getAgendamentosPorPaciente(Request req, Response resp) {
		return dao.getAgendamentosByPaciente(Integer.parseInt(req.params(":id")));
	}

	public static Object getAgendamentosPorDentista(Request req, Response resp) {
		return dao.getAgendamentosByDentista(Integer.parseInt(req.params(":id")));
	}

}
