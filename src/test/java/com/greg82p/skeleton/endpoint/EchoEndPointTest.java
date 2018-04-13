package com.greg82p.skeleton.endpoint;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.greg82p.skeleton.config.CoreConfig;
import com.greg82p.skeleton.config.MvcConfig;

@RunWith(SpringRunner.class)
@WebMvcTest(EchoEndPoint.class)
public class EchoEndPointTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void test_echoEndPoint() throws Exception {
		// Given

		// When
		ResultActions resultActions = mvc.perform(post("/echo").content("hello"));

		// Then
		MvcResult result = resultActions.andExpect(status().isOk()).andReturn();
		assertThat(result.getResponse().getContentAsString(), is("hello"));
	}

	@Test
	public void test_jsonEcho() throws Exception {
		// Given

		EchoEndPoint.JsonRequest jsonRequest = new EchoEndPoint.JsonRequest("message");
		String request = new Gson().toJson(jsonRequest);

		// When
		ResultActions resultActions = mvc.perform(post("/jsonecho")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(request));

		// Then
		MvcResult result = resultActions.andExpect(status().isOk()).andReturn();
		assertThat(result.getResponse().getContentAsString(), is("message"));
	}
}
