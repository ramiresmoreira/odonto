package br.edu.ifce.odonto.controllers;

import java.util.Collection;

import com.google.gson.Gson;

import br.edu.ifce.odonto.DAO.DentistaDAO;
import br.edu.ifce.odonto.DAO.PacienteDAO;
import br.edu.ifce.odonto.model.Dentista;
import br.edu.ifce.odonto.model.Mensagem;
import br.edu.ifce.odonto.model.Paciente;
import spark.Request;
import spark.Response;

public class PacienteController {
	private Mensagem msg;
	private static PacienteDAO dao = new PacienteDAO();

	public Mensagem addUser(Request req, Response resp) throws Exception {

		Paciente paciente = new Gson().fromJson(req.body(), Paciente.class);
		Dentista dentista = new DentistaDAO().get(paciente.getDentista().getId());
		if(dentista == null)
			return new Mensagem("Dentista não encontrado", false);
		if (podeSeCadastrar(paciente)) {
			paciente.setDentista(dentista);
			if (dao.save(paciente))
				msg = new Mensagem("Success: Paciente " + paciente.getNome() + " adicionado com sucesso!",true);
			else
				msg = new Mensagem("Error: O paciente não é elegígel para se cadastar",false);
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
	 * só um exemplo, a verificação abaixo ainda não é uma regra.
	 */
	private static boolean podeSeCadastrar(Paciente paciente) {
		return paciente.getIdade() > 14 && paciente.getIdade() < 24;
	}

}
