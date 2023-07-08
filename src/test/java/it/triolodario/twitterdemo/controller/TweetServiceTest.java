package it.triolodario.twitterdemo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.triolodario.twitterdemo.controller.dto.TweetDTO;
import it.triolodario.twitterdemo.repository.TweetRepository;
import it.triolodario.twitterdemo.service.TweetService;

@SpringBootTest
@AutoConfigureMockMvc
public class TweetServiceTest {

	private List<TweetDTO> tweetsDTO = new ArrayList<TweetDTO>();

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TweetService service;

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	void init() {

		tweetsDTO.add(new TweetDTO(1l, "AAAAA", "MMMMM", "22:07 GMT - 01/01/2021"));
		tweetsDTO.add(new TweetDTO(2l, "BBBBB", "NNNNN", "22:07 GMT - 01/02/2021"));
	}

	@Test
	void shouldCreateTweets() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/v1/tweets").content(objectMapper.writeValueAsString(tweetsDTO))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.status().isCreated());

		List<TweetDTO> tweetsList = service.findAll();
		assertEquals(tweetsList.size(), tweetsDTO.size());
	}

}
