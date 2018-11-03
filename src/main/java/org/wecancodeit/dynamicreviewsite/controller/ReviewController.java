package org.wecancodeit.dynamicreviewsite.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.dynamicreviewsite.repositories.CategoryRepository;
import org.wecancodeit.dynamicreviewsite.repositories.CommentRepository;
import org.wecancodeit.dynamicreviewsite.repositories.ReviewRepository;
import org.wecancodeit.dynamicreviewsite.model.Comment;

@SuppressWarnings("unused")
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
	public String listReview(@PathVariable(value = "id") Long id,Model model) {
		model.addAttribute("review", reviewRepo.findById(id).get());
		return "reviews/review";
	}
	
	@PostMapping("/reviews/{id}")
	public String addComment(@PathVariable(value = "commentId") Long commentId, String username, String content, Model model) {
		commentRepo.save(new Comment(username, content, reviewRepo.findById(commentId).get()));
		return "redirect:/reviews/{id}";
	}
}
