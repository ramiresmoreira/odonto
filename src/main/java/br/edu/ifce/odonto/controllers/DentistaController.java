package br.edu.ifce.odonto.controllers;

import java.util.Collection;

import com.google.gson.Gson;

import br.edu.ifce.odonto.DAO.DentistaDAO;
import br.edu.ifce.odonto.model.Dentista;
import br.edu.ifce.odonto.model.Mensagem;
import br.edu.ifce.odonto.util.GsonUtil;
import spark.Request;
import spark.Response;

public class DentistaController {
	private DentistaDAO dao = new DentistaDAO();
	private Gson gson = GsonUtil.getGson();
	
	public Mensagem addDentista(Request req , Response resp) throws Exception{
		Dentista dentista = gson.fromJson(req.body(), Dentista.class);
		return salvar(dentista);
	}

	private Mensagem salvar(Dentista dentista) throws Exception {
		Mensagem msg;
		boolean save = dao.save(dentista);
		if(save)
			msg = new Mensagem("Dentista addcionado com sucesso!", save);
		else
			msg = new Mensagem("Erro ao tentar cadastrar o Dentista", !save);
		return msg;
	}

	public Collection<Dentista> getAll() {
		return dao.getAll();
	}

	public Dentista get(Request req, Response resp) throws InterruptedException {
		 return dao.get(Integer.parseInt(req.params(":id")));
	}

}
