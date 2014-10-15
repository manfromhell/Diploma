package ua.edu.lp.sadiploma.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleService {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Scheduled(fixedDelay = 60000)
	public void checkInputData() {
		log.info("check db, delay = 1m");
		
	}

	@Scheduled(fixedDelay = 3000)
	public void checkCurrentStatus() {
		log.info("check buffer status, delay = 3s");
	}
}
