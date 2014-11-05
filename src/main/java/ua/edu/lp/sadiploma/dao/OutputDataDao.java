package ua.edu.lp.sadiploma.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import ua.edu.lp.sadiploma.entity.OutputData;
@Component
public interface OutputDataDao extends GenericDao<OutputData> {
	List<OutputData> filterOutput(int numberOfNodes);

}
