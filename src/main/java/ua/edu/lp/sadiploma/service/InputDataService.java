package ua.edu.lp.sadiploma.service;

import org.springframework.stereotype.Component;

import ua.edu.lp.sadiploma.entity.InputData;

@Component
public interface InputDataService extends GenericService<InputData> {
	int getNumberOfNodes(String parentCode);
	String getTreeType(double repsCoef, double gapsCoef);
	

}
