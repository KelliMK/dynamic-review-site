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
import org.wecancodeit.dynamicreviewsite.repositories.CategoryRepository;
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
	
 	@Test
	public void shouldBeOkWhenAccessingReviews() throws Exception {
 		mockMvc.perform(get("/reviews")).andExpect(status().isOk());
 	}
	@Test
	public void shouldReturnReviewsTemplateWhenAccessingReviews() throws Exception {
	    mockMvc.perform(get("/reviews")).andExpect(view().name("reviews/index"));
	}
	@Test
	public void shouldBeOkWhenAccessingcategory() throws Exception {
		mockMvc.perform(get("/categories")).andExpect(status().isOk());
	}
		    
	@Test
	public void shouldReturnCategoriesTemplateWhenAccessingCategories() throws Exception {		    	
		mockMvc.perform(get("/categories/1")).andExpect(view().name("categories"));		   
	}
 }