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
			Date startTimeTo, Date finishTimeFrom, Date finishTimeTo) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<OutputData> query = criteriaBuilder
				.createQuery(OutputData.class);
		Root<OutputData> root = query.from(OutputData.class);
		Join<OutputData, InputData> join = root.join("input_data");
		List<Predicate> conditions = new ArrayList<Predicate>();
		// number of nodes
		if (numberOfNodesFrom > 0) {
			conditions.add(criteriaBuilder.greaterThanOrEqualTo(root
					.<Integer> get("numberOfNodes"), criteriaBuilder.parameter(
					Integer.class, "numberOfNodesFrom")));
		}
		if (numberOfNodesTo > 0) {
			conditions
					.add(criteriaBuilder.lessThanOrEqualTo(root
							.<Integer> get("numberOfNodes"), criteriaBuilder
							.parameter(Integer.class, "numberOfNodesTo")));
		}
		// comment
		if ((comment != null) && (comment != "")) {
			conditions.add(criteriaBuilder.equal(root.<String> get("comment"),
					criteriaBuilder.parameter(String.class, "comment")));
		}
		// start time
		if (startTimeFrom != null) {
			conditions.add(criteriaBuilder.greaterThanOrEqualTo(
					root.<Date> get("startTimeFrom"),
					criteriaBuilder.parameter(Date.class, "startTimeFrom")));
		}
		if (startTimeTo != null) {
			conditions.add(criteriaBuilder.greaterThanOrEqualTo(
					root.<Date> get("startTimeTo"),
					criteriaBuilder.parameter(Date.class, "startTimeTo")));
		}
		// finish time
		if (finishTimeFrom != null) {
			conditions.add(criteriaBuilder.greaterThanOrEqualTo(
					root.<Date> get("finishTimeFrom"),
					criteriaBuilder.parameter(Date.class, "finishTimeFrom")));
		}
		if (finishTimeTo != null) {
			conditions.add(criteriaBuilder.greaterThanOrEqualTo(
					root.<Date> get("finishTimeTo"),
					criteriaBuilder.parameter(Date.class, "finishTimeTo")));
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

	@Override
	public List<OutputData> executeRequest(String request) {
		Query query = entityManager
				.createNativeQuery(request, OutputData.class);
		@SuppressWarnings("unchecked")
		List<OutputData> result = query.getResultList();
		return result;
	}

}
