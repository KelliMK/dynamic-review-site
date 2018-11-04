package org.wecancodeit.dynamicreviewsite.controller;

import java.util.Collection;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.dynamicreviewsite.model.Review;
import org.wecancodeit.dynamicreviewsite.model.Tag;
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
	public Collection<Tag> addTag(@PathVariable(value = "id") Long id) {
		return reviewRepo.findById(id).get().getTag();
	}

	@PostMapping("/api/reviews/{id}/tags/add")
	public Collection<Tag> addTag(@PathVariable(value = "id") Long id, @RequestBody String body) throws JSONException {
		System.out.println(body);
		JSONObject json = new JSONObject(body);
		String tagName = json.getString("tagName");
//		System.out.println(tagName);
//		System.out.println(id);
		Review review = reviewRepo.findById(id).get();
		if (tagRepo.findByTagName(tagName) == null) {
			Tag tag = new Tag(tagName, review);
			review.addTag(tag);
			tagRepo.save(tag);
			System.out.println(review.getTag());
		} else {
			Tag tag = tagRepo.findByTagName(tagName);
			tag.addReview(review);
			review.addTag(tag);
			tagRepo.save(tag);
		}
		return review.getTag();
	}



}
