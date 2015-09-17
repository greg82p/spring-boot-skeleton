package com.greg82p.skeleton.endpoint;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class HelloEndPoint {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String echo() {
		return "Hello world!";
	}
}
