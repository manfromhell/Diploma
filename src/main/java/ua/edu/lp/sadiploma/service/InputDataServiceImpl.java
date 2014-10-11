package ua.edu.lp.sadiploma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.lp.sadiploma.dao.InputDataDao;
import ua.edu.lp.sadiploma.entity.InputData;
@Service
public class InputDataServiceImpl implements InputDataService {
	
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

}
