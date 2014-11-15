package ua.edu.lp.sadiploma.service;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ua.edu.lp.sadiploma.entity.InputData;
import ua.edu.lp.sadiploma.tool.Node;
import ua.edu.lp.sadiploma.tool.SAConfig;
import ua.edu.lp.sadiploma.tool.SimAnnealing;

@Component
public class ScheduleService {

	private static final Logger log = LoggerFactory
			.getLogger(ScheduleService.class);
	private ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 600, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1024));

	@Autowired
	private InputDataService inputDataService;

	@Autowired
	private OutputDataService outputDataService;

	@Scheduled(fixedDelay = 60000)
	public void checkInputData() {
		log.info("check db, delay = 15s");
		List<InputData> list = inputDataService.findUnchecked(2);
		if (executor.getActiveCount()<=2) {
			for (InputData data : list) {

				ua.edu.lp.sadiploma.tool.Component component = Node
						.generateTree(data.getParentCode());

				SAConfig config = new SAConfig(data.getInitTemp(),
						data.getAlpha(),
						data.getIterationsPerTemperature(), data.getGapsCoef(),
						data.getRepCoef());

				SimAnnealing simAnnealing = new SimAnnealing(component, data, inputDataService, outputDataService, config);
				executor.execute(simAnnealing);
			}
		}
	}

}
