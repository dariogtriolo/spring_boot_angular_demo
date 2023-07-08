package it.triolodario.twitterdemo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.triolodario.twitterdemo.controller.dto.TweetDTO;
import it.triolodario.twitterdemo.service.TweetService;

@RestController
@RequestMapping("/api")
public class TweetController {

	private final TweetService service;

	TweetController(TweetService service) {
		this.service = service;
	}

	@GetMapping("/v1/tweets")
	List<TweetDTO> findAll() {
		return service.findAll();
	}

	@PostMapping("/v1/tweets")
	ResponseEntity<List<TweetDTO>> saveAll(@RequestBody List<TweetDTO> tweetDTOs) {

		List<TweetDTO> savedTweets = service.saveAll(tweetDTOs);

		return ResponseEntity.created(null).body(savedTweets);
	}

	@GetMapping("/v1/tweets/{id}")
	TweetDTO findById(@PathVariable Long id) {

		return service.findById(id);
	}

	@PutMapping("/v1/tweets/{id}")
	TweetDTO update(@RequestBody TweetDTO tweet, @PathVariable Long id) {

		return service.update(tweet, id);
	}

	@DeleteMapping("/v1/tweets/{id}")
	void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}
}
