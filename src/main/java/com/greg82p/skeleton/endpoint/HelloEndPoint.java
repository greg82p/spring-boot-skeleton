package com.greg82p.skeleton.endpoint;

import com.greg82p.skeleton.aop.StopWatchExecution;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloEndPoint {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	@StopWatchExecution
	public String hello() {
		return "Hello world!";
	}
}
