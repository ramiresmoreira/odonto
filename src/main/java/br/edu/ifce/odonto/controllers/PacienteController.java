package br.edu.ifce.odonto.controllers;

import java.util.Collection;

import com.google.gson.Gson;

import br.edu.ifce.odonto.DAO.PacienteDAO;
import br.edu.ifce.odonto.model.Paciente;
import spark.Request;
import spark.Response;

public class PacienteController {
	private String msg;
	private static PacienteDAO dao = new PacienteDAO();

	public String addUser(Request req, Response resp) throws Exception {

		Paciente paciente = new Gson().fromJson(req.body(), Paciente.class);
		if (podeSeCadastrar(paciente)) {
			if (dao.save(paciente))
				msg = "Success: Paciente " + paciente.getNome() + " adicionado com sucesso!";
			else
				msg = "Erro: Paciente não é elegígel para se cadastar";
		}
		return msg;
	}

	public Paciente get(Request req, Response resp) {
		return dao.get(Integer.parseInt(req.params(":id")));
	}

	public Collection<Paciente> getAll() {
		return dao.getAll();
	}

	/**
	 * Verifica a elegibilidade do paciente.
	 */
	private static boolean podeSeCadastrar(Paciente paciente) {
		return paciente.getIdade() > 14 && paciente.getIdade() < 24;
	}

}
