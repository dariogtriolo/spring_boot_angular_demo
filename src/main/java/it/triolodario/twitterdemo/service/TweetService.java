package it.triolodario.twitterdemo.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.triolodario.twitterdemo.controller.dto.TweetDTO;
import it.triolodario.twitterdemo.controller.exception.TweetNotFoundException;
import it.triolodario.twitterdemo.mapper.TweetMapper;
import it.triolodario.twitterdemo.model.Tweet;
import it.triolodario.twitterdemo.repository.TweetRepository;
import jakarta.transaction.Transactional;

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

	@Transactional
	public List<TweetDTO> saveAll(List<TweetDTO> tweetsDTO) {
		log.info("Save all tweets");

		List<Tweet> tweets = new ArrayList<>();

		tweetsDTO.forEach(t -> {
			try {

				tweets.add(TweetMapper.toEntity(t));

			} catch (ParseException e) {

				log.error(e.getMessage());
			}
		});

		return repository.saveAll(tweets).stream().map(TweetMapper::toDTO).toList();
	}

	public TweetDTO findById(Long id) {

		Optional<Tweet> opt = repository.findById(id);

		if (opt.isEmpty()) {

			throw new TweetNotFoundException(id);

		} else {

			return TweetMapper.toDTO(opt.get());

		}
	}

	@Transactional
	public TweetDTO update(TweetDTO tweetDTO, Long id) {

		TweetDTO tweetDTOUpdated = null;

		try {

			Tweet tweetToSave = TweetMapper.toEntity(tweetDTO);
			Optional<Tweet> opt = repository.findById(id);

			if (opt.isEmpty()) {

				throw new TweetNotFoundException(id);

			} else {

				tweetToSave.setId(opt.get().getId());

			}

			tweetDTOUpdated = TweetMapper.toDTO(repository.save(tweetToSave));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return tweetDTOUpdated;
	}

	public void deleteById(Long id) {

		repository.deleteById(id);
	}

}
