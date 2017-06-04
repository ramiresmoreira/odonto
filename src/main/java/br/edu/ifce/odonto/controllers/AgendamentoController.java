package br.edu.ifce.odonto.controllers;

import com.google.gson.Gson;

import br.edu.ifce.odonto.DAO.AgendamentoDAO;
import br.edu.ifce.odonto.DAO.DentistaDAO;
import br.edu.ifce.odonto.DAO.DiscenteDAO;
import br.edu.ifce.odonto.model.Agendamento;
import br.edu.ifce.odonto.model.Dentista;
import br.edu.ifce.odonto.model.Discente;
import br.edu.ifce.odonto.model.Intervalo;
import br.edu.ifce.odonto.model.Mensagem;
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
		Dentista dentista = new DentistaDAO().get(agendamento.getDentista().getId()); 
		Discente discente = new DiscenteDAO().get(agendamento.getDiscente().getId());
		agendamento.setDiscente(discente);
		agendamento.setDentista(dentista);
		
		dao.save(agendamento);
		return new Mensagem("agendamento relizado com sucesso!", true);
	}

	public static Mensagem getAll(Request req, Response resp) {
		Intervalo intervalo = new Intervalo(req);		
		System.out.println(intervalo.getInicio().getDayOfWeek());
		return new Mensagem(intervalo.toString(), true);
	}

}
