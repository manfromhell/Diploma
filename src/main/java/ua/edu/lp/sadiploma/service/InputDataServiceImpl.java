package ua.edu.lp.sadiploma.service;

import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.edu.lp.sadiploma.dao.InputDataDao;
import ua.edu.lp.sadiploma.entity.InputData;
@Service
@Transactional
public class InputDataServiceImpl implements InputDataService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private InputDataDao inputDataDao;

	@Override
	public void create(InputData entity) {
		inputDataDao.create(entity);
		
	}

	@Override
	public InputData update(InputData entity) {
		return inputDataDao.update(entity);
	}

	@Override
	public void delete(InputData entity) {
		inputDataDao.delete(entity);
		
	}

	@Override
	public InputData findById(Long id) {
		return inputDataDao.findById(InputData.class, id);
	}

	@Override
	public List<InputData> findAll() {
		return inputDataDao.findAll(InputData.class);
	}

	@Override
	public List<InputData> findUnchecked(Integer count) {
		return inputDataDao.findUnchecked(count,InputData.class);
	}
	
	public int getNumberOfNodes(String parentCode){
		String[] parentCodeArray = parentCode.split("[, /;-]|(, )");
		return parentCodeArray.length;
	}
	
	public String getTreeType(double repsCoef, double gapsCoef){
		//ResourceBundle rb = ResourceBundle.getBundle(baseName)
		if (repsCoef>gapsCoef){
			return "Golomb Trees";
		}
		if (gapsCoef>repsCoef){
			return "Restricted Leech Trees";
		}
		return "Unrestricted Leech Trees";
	}

}
