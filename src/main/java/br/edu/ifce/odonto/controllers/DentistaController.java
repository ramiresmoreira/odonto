package br.edu.ifce.odonto.controllers;

import java.util.Collection;

import com.google.gson.Gson;

import br.edu.ifce.odonto.DAO.dentistaDAO;
import br.edu.ifce.odonto.model.Dentista;
import spark.Request;
import spark.Response;

public class DentistaController {
	dentistaDAO dao = new dentistaDAO();
	
	public String addDentista(Request req , Response resp) throws Exception{
		String msg = null;
		Dentista dentista = new Gson().fromJson(req.body(), Dentista.class);
		
		boolean save = dao.save(dentista);
		if(save)
			msg = dentista.toString();
		
		return msg;
	}

	public Collection<Dentista> getAll() {
		
		return dao.getAll();
	}

}
