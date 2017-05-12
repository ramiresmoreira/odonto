package br.edu.ifce.odonto.controllers;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifce.odonto.model.Discente;
import spark.Request;
import spark.Response;

public class DiscenteController {
	private String msg;
	private static List<Discente> dao = new ArrayList<>();

	public String addUser(Request req, Response resp) {
		System.out.println(req.session().attribute("token")+"");
		int idade = Integer.parseInt(req.queryParams("idade"));
		Discente discente = new Discente(req.queryParams("nome"), idade);
		boolean result = false;
		if (!dao.contains(discente)) {
			result = dao.add(discente);
			discente.setId(dao.size() );
			System.out.println(discente.getId());
		}
		if (result)
			msg = "Success: Usuário adicionado com sucesso!";
		else
			msg = "Error: Já existe um usuário cadastrado com esse nome";
		System.out.println(dao);
		return msg;
	}

	public Discente get(Request req, Response resp) {
		try{
			return dao.stream().filter(d -> d.getId() == Integer.parseInt(req.params("id"))).findFirst().orElse(null);	
		}catch(NumberFormatException e){
			return null;
		}
	}
	
	public List<Discente> getAll(){
		return dao;
	}
}
