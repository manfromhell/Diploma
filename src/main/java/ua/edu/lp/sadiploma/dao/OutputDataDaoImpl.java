package ua.edu.lp.sadiploma.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.edu.lp.sadiploma.entity.OutputData;
@Repository
public class OutputDataDaoImpl extends GenericDaoImpl<OutputData> implements OutputDataDao {
	
	public List<OutputData> filterOutput(int numberOfNodesFrom, int numberOfNodesTo, String comment, Date startTimeFrom, Date startTimeTo, Date finishTimeFrom, Date finishTimeTo){
		TypedQuery<OutputData> query = entityManager.createNamedQuery("OutputData.filter", OutputData.class);
		query.setParameter("numberOfNodesFrom", numberOfNodesFrom);
		query.setParameter("numberOfNodesTo", numberOfNodesTo);
		query.setParameter("comment", comment);
		query.setParameter("startTimeFrom", startTimeFrom);
		query.setParameter("startTimeTo", startTimeTo);
		query.setParameter("finishTimeFrom", finishTimeFrom);
		query.setParameter("finishTimeTo", finishTimeTo);
		return query.getResultList();
	}

	@Override
	public List<OutputData> executeRequest(String request) {
		Query query = entityManager.createNativeQuery(request, OutputData.class);
		List<OutputData> result = entityManager.createNativeQuery(request, OutputData.class).getResultList();
		return result;
	}


}
