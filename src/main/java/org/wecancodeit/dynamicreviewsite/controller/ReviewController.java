package org.wecancodeit.dynamicreviewsite.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.dynamicreviewsite.repositories.CommentRepository;
import org.wecancodeit.dynamicreviewsite.repositories.ReviewRepository;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

	@Resource
	ReviewRepository reviewRepo;

	@Autowired
	CommentRepository commentRepo;

	@RequestMapping("")
	public String listReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews/index";
	}

	@RequestMapping("/{id}")
	public String listReview(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("review", reviewRepo.findById(id).get());
		return "reviews/review";
	}

}
