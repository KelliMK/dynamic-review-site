package org.wecancodeit.dynamicreviewsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.dynamicreviewsite.model.Review;
import org.wecancodeit.dynamicreviewsite.repositories.ReviewRepository;
import org.wecancodeit.dynamicreviewsite.repositories.TagRepository;

@RestController
public class ApiController {

	@Autowired
	TagRepository tagRepo;

	@Autowired
	ReviewRepository reviewRepo;

//	@GetMapping("api/reviews")
//	public Iterable<Review> getReviews() {
//		return reviewRepo.findAll();
//	}

	@GetMapping("/api/reviews/{id}")
	public Review getReview(@PathVariable(value = "id") Long id) {
		return reviewRepo.findById(id).get();
	}
	
	@PostMapping()
}
