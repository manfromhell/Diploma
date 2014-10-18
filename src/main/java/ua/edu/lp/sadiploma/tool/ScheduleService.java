package ua.edu.lp.sadiploma.tool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleService {
	private ExecutorService executor = Executors.newFixedThreadPool(2);

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Scheduled(fixedDelay = 60000)
	public void checkInputData() {
		log.info("checking inputData from db, delay = 1m");
		
	}

	@Scheduled(fixedDelay = 1000)
	public void calculate() {
		log.info("calculating tree");
		if(executor.isShutdown()) {
			
//			executor.execute(command);
		}
	}

	@Scheduled(fixedDelay = 3000)
	public void checkCurrentStatus() {
		log.info("check buffer status, delay = 3s");
	}
}
