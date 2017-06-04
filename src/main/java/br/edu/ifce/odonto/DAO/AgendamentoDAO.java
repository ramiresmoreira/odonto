package br.edu.ifce.odonto.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	public List<Agendamento> getAgendamentosByPaciente(int pacienteID) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		String queryString = "SELECT a.dentista.nome ,a.paciente.nome ,a.observacao, a.horario FROM Agendamento a where a.paciente = :pPaciente";
		Query query = em.createQuery(queryString);
		query.setParameter("pPaciente", new PacienteDAO().get(pacienteID));
		em.getTransaction().commit();
		List<Agendamento> resultList = query.getResultList();
		em.close();
		return resultList;
	}

}
