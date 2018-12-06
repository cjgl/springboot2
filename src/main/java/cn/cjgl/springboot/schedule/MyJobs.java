package cn.cjgl.springboot.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyJobs {
	private static final Logger log = LoggerFactory.getLogger(MyJobs.class);
	
	@Scheduled(cron = "0 0 1/1 * * ?")
    public void cronJob(){
        log.info("cronJob => cron = 0 0 1/1 * * ?");
    }
	
	@Scheduled(fixedDelay = 60*60*1000)
    public void fixedDelayJob(){
		log.info("fixedDelayJob => fixedDelay = 60*60*1000");
    }

}
