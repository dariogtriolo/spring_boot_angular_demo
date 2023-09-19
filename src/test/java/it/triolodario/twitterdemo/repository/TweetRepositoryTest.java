package it.triolodario.twitterdemo.repository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import it.triolodario.twitterdemo.model.Tweet;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class TweetRepositoryTest {

	@Autowired
	TweetRepository tweetRepository;

	List<Tweet> tweets = new ArrayList<Tweet>();

	@Test
	public void TweetRepositorySaveAllShouldReturnSavedTweets() {

		// Arrange
		tweets.clear();
		tweets.add(new Tweet("AuthorA", "MessageA", Instant.now()));
		tweets.add(new Tweet("AuthorB", "MessageB", Instant.now()));

		// Act
		List<Tweet> savedTweets = tweetRepository.saveAll(tweets);

		// Assert
		Assertions.assertThat(savedTweets).isNotNull();
		Assertions.assertThat(savedTweets).hasSize(2);

	}

	@Test
	public void TweetRepositoryGetAllShouldReturnAllTweets() {

		final String authorA = "AuthorA";

		// Arrange
		tweets.clear();
		tweets.add(new Tweet(authorA, "MessageA", Instant.now()));
		tweets.add(new Tweet("AuthorB", "MessageB", Instant.now()));

		// Act
		tweetRepository.saveAll(tweets);

		// Assert
		List<Tweet> tweetsList = tweetRepository.findAll();
		Assertions.assertThat(tweetsList).isNotNull();
		Assertions.assertThat(tweetsList).hasSize(2);
		Assertions.assertThat(tweetsList.get(0).getAuthor()).isEqualTo(authorA);

	}
	
	@Test
	public void TweetRepositoryFindByAuthorShouldReturnAllTweetsByAuthor() {

		final String authorC = "AuthorC";

		// Arrange
		tweets.clear();
		tweets.add(new Tweet("authorA", "MessageA", Instant.now()));
		tweets.add(new Tweet("AuthorB", "MessageB", Instant.now()));
		tweets.add(new Tweet(authorC, "Messagec", Instant.now()));

		// Act
		tweetRepository.saveAll(tweets);

		// Assert
		List<Tweet> tweetsList = tweetRepository.findByAuthor(authorC);
		Assertions.assertThat(tweetsList).isNotNull().hasSize(1);
		Assertions.assertThat(tweetsList.get(0).getAuthor()).isEqualTo(authorC);
		Assertions.assertThat(tweetsList.get(0).getMessage()).isEqualTo("Messagec");

	}

}
