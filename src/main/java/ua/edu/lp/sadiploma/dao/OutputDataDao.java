package ua.edu.lp.sadiploma.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import ua.edu.lp.sadiploma.entity.OutputData;
@Component
public interface OutputDataDao extends GenericDao<OutputData> {
	List<OutputData> filterOutput(int numberOfNodesFrom, int numberOfNodesTo, String comment, Date startTimeFrom, Date startTimeTo, Date finishTimeFrom, Date finishTimeTo );
	List<OutputData> executeRequest(String request);

}
