package br.edu.ifce.odonto.controllers;

import java.util.Collection;

import br.edu.ifce.odonto.DAO.DiscenteDAO;
import br.edu.ifce.odonto.model.Discente;
import spark.Request;
import spark.Response;

public class DiscenteController {
	private String msg;
	private static DiscenteDAO dao = new DiscenteDAO();

	public String addUser(Request req, Response resp) throws Exception {
		int idade = Integer.parseInt(req.queryParams("idade"));
		String nome = req.queryParams("nome");
		if (dao.save(new Discente(nome, idade)))
			msg = "Success: Usuário adicionado com sucesso!";
		else
			msg = "Error: Já existe um usuário cadastrado com esse nome";
		return msg;
	}

	public Discente get(Request req, Response resp) {
		return dao.get(Integer.parseInt(req.params(":id")));
	}
	
	public Collection<Discente> getAll(){
		return dao.getAll();
	}
	
}
