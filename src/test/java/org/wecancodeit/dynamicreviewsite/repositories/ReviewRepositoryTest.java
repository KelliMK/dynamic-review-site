package org.wecancodeit.dynamicreviewsite.repositories;

import javax.annotation.Resource;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.dynamicreviewsite.model.Review;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.Optional;



@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewRepositoryTest {
		
		@Resource
		ReviewRepository repo;
		
		@Test
		public void shouldReturnAllReviews() {
			//Arrange
			Review review = repo.save(new Review());
			Review review1 = repo.save(new Review());
			
			//Act
			Iterable<Review> result = repo.findAll();
			
			//Assert
			Assert.assertThat(result, hasItems(review));
		}
		@Test
		public void shouldReturnOneReview() {
			//Arrange
			Review review= repo.save(new Review());
			Review review1 = repo.save(new Review());
			
			//Act
			Optional<Review> result = repo.findById(1L);
			
			//Assert
			assertThat(result, hasItems());
		}
		private void assertThat(Optional<Review> result, Matcher<Iterable<Review>> hasItems) {
			// TODO Auto-generated method stub
			
		}
	}

