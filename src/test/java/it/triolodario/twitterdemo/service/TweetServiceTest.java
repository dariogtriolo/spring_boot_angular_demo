package it.triolodario.twitterdemo.service;

import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import it.triolodario.twitterdemo.controller.dto.TweetDTO;
import it.triolodario.twitterdemo.model.Tweet;
import it.triolodario.twitterdemo.repository.TweetRepository;

@ExtendWith(MockitoExtension.class)
public class TweetServiceTest {

	@Mock
	private TweetRepository repository;

	@InjectMocks
	private TweetService service;

	@Test
	void TweetServiceSaveAllShouldReturnTweetDTOList() {
		List<TweetDTO> tweetsToSaveDTO = new ArrayList<>();
		tweetsToSaveDTO.add(new TweetDTO("AuthorA", "MessageA", "1688854161"));
		tweetsToSaveDTO.add(new TweetDTO("AuthorB", "MessageB", "1688854161"));

		List<Tweet> tweets = new ArrayList<>();
		tweets.add(new Tweet("AuthorA", "MessageA", Instant.now()));
		tweets.add(new Tweet("AuthorB", "MessageB", Instant.now()));

		when(repository.saveAll(Mockito.anyCollection())).thenReturn(tweets);

		List<TweetDTO> savedTweets = service.saveAll(tweetsToSaveDTO);

		Assertions.assertThat(savedTweets).isNotNull().size().isEqualTo(2);

	}

	@Test
	void TweetServiceGetAllShouldReturnTweetDTOList() {
		List<Tweet> tweets = new ArrayList<>();
		tweets.add(new Tweet("AuthorA", "MessageA", Instant.now()));
		tweets.add(new Tweet("AuthorB", "MessageB", Instant.now()));

		when(repository.findAll()).thenReturn(tweets);

		List<TweetDTO> savedTweets = service.findAll();

		Assertions.assertThat(savedTweets).isNotNull().size().isEqualTo(2);

	}

}
