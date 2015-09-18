package com.greg82p.skeleton.endpoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class EchoEndPoint {

	@RequestMapping(value = "/echo", method = RequestMethod.POST)
	@ResponseBody
	public String echo(@RequestBody String request) {

		log.info("request : {}", request);

		return request;
	}

	@RequestMapping(value = "/jsonecho", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String jsonEcho(@RequestBody JsonRequest request) {

		log.info("reqeust : {}", request.toString());

		return request.getMessage();
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	static class JsonRequest {
		String message;
	}
}
