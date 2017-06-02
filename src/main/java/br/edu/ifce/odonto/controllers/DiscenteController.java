package br.edu.ifce.odonto.controllers;

import java.util.Collection;

import com.google.gson.Gson;

import br.edu.ifce.odonto.DAO.DiscenteDAO;
import br.edu.ifce.odonto.model.Discente;
import spark.Request;
import spark.Response;

public class DiscenteController {
	private String msg;
	private static DiscenteDAO dao = new DiscenteDAO();

	public String addUser(Request req, Response resp) throws Exception {
		msg = "discente não é elegígel para se cadastar";
		Discente discente = new Gson().fromJson(req.body(), Discente.class);
		if (podeSeCadastrar(discente)) {
			if (dao.save(discente))
				msg = "Success: Usuário " + discente.getNome() + " adicionado com sucesso!";
			else
				msg = "Error: Já existe um usuário cadastrado com esse nome";
		}
		return msg;
	}

	public Discente get(Request req, Response resp) {
		return dao.get(Integer.parseInt(req.params(":id")));
	}

	public Collection<Discente> getAll() {
		return dao.getAll();
	}

	/**
	 * Verifica a elegibilidade do discente.
	 */
	private static boolean podeSeCadastrar(Discente discente) {
		return discente.getIdade() > 14 && discente.getIdade() < 24;
	}

}
