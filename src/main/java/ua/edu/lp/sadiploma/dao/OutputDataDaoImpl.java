package ua.edu.lp.sadiploma.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.edu.lp.sadiploma.entity.OutputData;
@Repository
public class OutputDataDaoImpl extends GenericDaoImpl<OutputData> implements OutputDataDao {
	
	public List<OutputData> filterOutput(int numberOfNodes){
		TypedQuery<OutputData> query = entityManager.createNamedQuery("OutputData.filter", OutputData.class);
		query.setParameter("numberOfNodes", numberOfNodes);
		return query.getResultList();
	}


}
