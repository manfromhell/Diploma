package ua.edu.lp.sadiploma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.edu.lp.sadiploma.dao.OutputDataDao;
import ua.edu.lp.sadiploma.entity.OutputData;

@Service
@Transactional
public class OutputDataServiceImpl implements OutputDataService {

	@Autowired
	private OutputDataDao outputDataDao;

	@Override
	public void create(OutputData entity) {
		outputDataDao.create(entity);

	}

	@Override
	public OutputData update(OutputData entity) {
		return outputDataDao.update(entity);
	}

	@Override
	public void delete(OutputData entity) {
		outputDataDao.delete(entity);

	}

	@Override
	public OutputData findById(Long id) {
		return outputDataDao.findById(OutputData.class, id);
	}

	@Override
	public List<OutputData> findAll() {
		return outputDataDao.findAll(OutputData.class);
	}

	@Override
	public List<OutputData> findUnchecked(Integer count) {
		return outputDataDao.findUnchecked(count, OutputData.class);
	}

	@Override
	public List<OutputData> filterOutput(int numberOfNodes) {
		return outputDataDao.filterOutput(numberOfNodes);
	}

}
