package ua.edu.lp.sadiploma.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ua.edu.lp.sadiploma.entity.InputData;
import ua.edu.lp.sadiploma.entity.OutputData;

@Repository
public class OutputDataDaoImpl extends GenericDaoImpl<OutputData> implements
		OutputDataDao {

	public List<OutputData> filterOutput(int numberOfNodesFrom,
			int numberOfNodesTo, String comment, Date startTimeFrom,
			Date startTimeTo, Date finishTimeFrom, Date finishTimeTo, String request) {
		if ((request != null) && (request != "")) {
			return executeRequest(request);
		}
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OutputData> query = criteriaBuilder
				.createQuery(OutputData.class);
		Root<OutputData> root = query.from(OutputData.class);
		Join<OutputData, InputData> join = root.join("inputData");
		List<Predicate> conditions = new ArrayList<Predicate>();
		// number of nodes
		if (numberOfNodesFrom > 0) {
			conditions.add(criteriaBuilder.greaterThanOrEqualTo(join
					.<Integer> get("numberOfNodes"), numberOfNodesFrom));
		}
		if (numberOfNodesTo > 0) {
			conditions
					.add(criteriaBuilder.lessThanOrEqualTo(join
							.<Integer> get("numberOfNodes"), numberOfNodesTo));
		}
		// comment
		if ((comment != null) && (comment != "")) {
			conditions.add(criteriaBuilder.equal(join.<String> get("comment"),
					comment));
		}
		// start time
		if (startTimeFrom != null) {
			conditions.add(criteriaBuilder.greaterThanOrEqualTo(
					join.<Date> get("startTimeFrom"),startTimeFrom));
		}
		if (startTimeTo != null) {
			conditions.add(criteriaBuilder.greaterThanOrEqualTo(
					join.<Date> get("startTimeTo"),startTimeTo));
		}
		// finish time
		if (finishTimeFrom != null) {
			conditions.add(criteriaBuilder.greaterThanOrEqualTo(
					join.<Date> get("finishTimeFrom"),finishTimeFrom));
		}
		if (finishTimeTo != null) {
			conditions.add(criteriaBuilder.greaterThanOrEqualTo(
					join.<Date> get("finishTimeTo"),finishTimeTo));
		}

		// TypedQuery<OutputData> query =
		// entityManager.createNamedQuery("OutputData.filter",
		// OutputData.class);
		TypedQuery<OutputData> query2 = entityManager.createQuery(query.select(
				root).where(conditions.toArray(new Predicate[] {})));
		// query.setParameter("numberOfNodesFrom", numberOfNodesFrom);
		// query.setParameter("numberOfNodesTo", numberOfNodesTo);
		// query.setParameter("comment", comment);
		// query.setParameter("startTimeFrom", startTimeFrom);
		// query.setParameter("startTimeTo", startTimeTo);
		// query.setParameter("finishTimeFrom", finishTimeFrom);
		// query.setParameter("finishTimeTo", finishTimeTo);
		return query2.getResultList();
	}

	public List<OutputData> executeRequest(String request) {
		Query query = entityManager
				.createNativeQuery(request, OutputData.class);
		@SuppressWarnings("unchecked")
		List<OutputData> result = query.getResultList();
		return result;
	}

}
