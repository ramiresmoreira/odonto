package br.edu.ifce.odonto.controllers;

import java.util.Collection;

import com.google.gson.Gson;

import br.edu.ifce.odonto.DAO.DentistaDAO;
import br.edu.ifce.odonto.model.Dentista;
import br.edu.ifce.odonto.util.GsonUtil;
import spark.Request;
import spark.Response;

public class DentistaController {
	DentistaDAO dao = new DentistaDAO();
	
	public String addDentista(Request req , Response resp) throws Exception{
		String msg = null;
		
		Gson gson = GsonUtil.getGson();
		
		Dentista dentista = gson.fromJson(req.body(), Dentista.class);
		
		boolean save = dao.save(dentista);
		if(save)
			msg = dentista.toString();
		
		return msg;
	}

	public Collection<Dentista> getAll() {
		
		return dao.getAll();
	}

}
