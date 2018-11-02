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
import org.wecancodeit.dynamicreviewsite.repositories.CommentRepository;
import org.wecancodeit.dynamicreviewsite.repositories.ReviewRepository;

public class CommentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ReviewRepository reviewRepo;
	@MockBean
	private CommentRepository commentRepo;
	
	@Test
	public void shouldBeOkayWhenAccessingComment() throws Exception {
		mockMvc.perform(get("/comments")).andExpect(status().isOk());
	}
}
