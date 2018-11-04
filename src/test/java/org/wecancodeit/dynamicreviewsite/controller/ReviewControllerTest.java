package org.wecancodeit.dynamicreviewsite.controller;
 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.dynamicreviewsite.model.Category;
import org.wecancodeit.dynamicreviewsite.model.Comment;
import org.wecancodeit.dynamicreviewsite.model.Review;
import org.wecancodeit.dynamicreviewsite.repositories.CategoryRepository;
import org.wecancodeit.dynamicreviewsite.repositories.CommentRepository;
import org.wecancodeit.dynamicreviewsite.repositories.ReviewRepository;
 	
@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {
 	@Autowired
	private MockMvc mockMvc;
 	
 	@MockBean
	private CategoryRepository categoryRepo;
 	
	@MockBean
	private ReviewRepository reviewRepo;
	
	@MockBean
	private CommentRepository commentRepo;
	
 	@Test
	public void shouldBeOkWhenAccessingReviews() throws Exception {
 		mockMvc.perform(get("/reviews")).andExpect(status().isOk());
 	}
	@Test
	public void shouldReturnReviewsTemplateWhenAccessingReviews() throws Exception {
	    mockMvc.perform(get("/reviews")).andExpect(view().name("reviews/index"));
	}
 }