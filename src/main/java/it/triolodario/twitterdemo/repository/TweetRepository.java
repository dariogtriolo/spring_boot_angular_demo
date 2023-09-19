package it.triolodario.twitterdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.triolodario.twitterdemo.model.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
	
	List<Tweet> findByAuthor(String author);

}
