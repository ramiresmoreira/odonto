package br.edu.ifce.odonto.DAO;

import javax.persistence.EntityManager;

import br.edu.ifce.odonto.model.Agendamento;
import br.edu.ifce.odonto.util.JPAUtil;

public class AgendamentoDAO {

	public Agendamento save(Agendamento agendamento){
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		Agendamento agendamentoResult = manager.merge(agendamento);
		manager.getTransaction().commit();
		manager.close();
		return agendamentoResult;
	}

}
