package ua.edu.lp.sadiploma.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import ua.edu.lp.sadiploma.entity.OutputData;
@Component
public interface OutputDataService extends GenericService<OutputData> {
	List<OutputData> filterOutput(int numberOfNodesFrom, int numberOfNodesTo, String comment, Date startTimeFrom, Date startTimeTo, Date finishTimeFrom, Date finishTimeTo, String request);
}
