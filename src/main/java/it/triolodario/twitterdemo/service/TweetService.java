package it.triolodario.twitterdemo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.triolodario.twitterdemo.controller.dto.TweetDTO;
import it.triolodario.twitterdemo.mapper.TweetMapper;
import it.triolodario.twitterdemo.model.Tweet;
import it.triolodario.twitterdemo.repository.TweetRepository;

@Service
public class TweetService {

	private static final Logger log = LoggerFactory.getLogger(TweetService.class);

	private final TweetRepository repository;

	TweetService(TweetRepository repository) {
		this.repository = repository;
	}

	public List<TweetDTO> findAll() {
		log.info("Find all tweets");

		return repository.findAll().stream().map(TweetMapper::toDTO).toList();
	}

	public List<TweetDTO> saveAll(List<TweetDTO> tweetsDTO) {
		log.info("Save all tweets");

		
		List<Tweet> savedTweets = repository.saveAll(tweetsDTO.stream().map(TweetMapper::toEntity).toList());
		
		return savedTweets.stream().map(TweetMapper::toDTO).toList();
	}

}
