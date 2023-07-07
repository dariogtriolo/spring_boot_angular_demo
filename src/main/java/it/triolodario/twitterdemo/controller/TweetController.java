package it.triolodario.twitterdemo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
//
//	@GetMapping("/v1/tweets/{id}")
//	Tweet findById(@PathVariable Long id) {
//
//		return repository.findById(id).orElseThrow(() -> new TweetNotFoundException(id));
//	}
//
////	@PutMapping("/v1/tweets/{id}")
////	Tweet save(@RequestBody Tweet tweet, @PathVariable Long id) {
//
////		return repository.findById(id).map(t -> {
////			employee.setName(newEmployee.getName());
////			employee.setRole(newEmployee.getRole());
////			return repository.save(employee);
////		}).orElseGet(() -> {
////			newEmployee.setId(id);
////			return repository.save(newEmployee);
////		});
////	}
//
//	@DeleteMapping("/v1/tweets/{id}")
//	void deleteById(@PathVariable Long id) {
//		repository.deleteById(id);
//	}
}
