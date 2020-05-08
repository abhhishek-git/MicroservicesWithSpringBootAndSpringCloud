package com.in28minutes.rest.webservices.restfulwebserviecs.helloworld;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
	Logger logger = LoggerFactory.getLogger(LoggingController.class);
	
	@RequestMapping("/")
	public String index() {
		logger.trace("A TRACE message");
		logger.debug("A DEBUG message");
		logger.info("An INFO message");
		logger.warn("A WARN message");
		logger.error("An ERROR message");
		
		return "Hi... see the logs";
	}
}
