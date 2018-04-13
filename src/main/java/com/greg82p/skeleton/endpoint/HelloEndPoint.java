package com.greg82p.skeleton.endpoint;

import java.util.concurrent.TimeUnit;

import javax.annotation.PreDestroy;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greg82p.skeleton.aop.StopWatchExecution;

@RestController
@EnableAutoConfiguration
public class HelloEndPoint {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@StopWatchExecution
	public String hello() {
		return "Hello world!";
	}

	@RequestMapping(value = "/delay", method = RequestMethod.GET)
	@StopWatchExecution
	public String delay(@RequestParam(name = "seconds") int seconds) throws InterruptedException {
		TimeUnit.SECONDS.sleep(seconds);

		return "OK";
	}

	@PreDestroy
	public void cleanUp() {
		System.out.println("preDestroy");
	}
}
