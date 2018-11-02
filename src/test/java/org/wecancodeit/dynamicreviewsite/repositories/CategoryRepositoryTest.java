package org.wecancodeit.dynamicreviewsite.repositories;

import javax.annotation.Resource;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.dynamicreviewsite.model.Category;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.Optional;



@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
		
		@Resource
		CategoryRepository repo;
		
		@Test
		public void shouldReturnAllCategories() {
			//Arrange
			Category category = repo.save(new Category("", "", ""));
			Category category1 = repo.save(new Category("", "", ""));
			
			//Act
			Iterable<Category> result = repo.findAll();
			
			//Assert
			Assert.assertThat(result, hasItems(category));
		}
		@Test
		public void shouldReturnOneCategory() {
			//Arrange
			Category category = repo.save(new Category("", "", ""));
			Category category1 = repo.save(new Category("", "", ""));
			
			//Act
			Optional<Category> result = repo.findById(1L);
			
			//Assert
			assertThat(result, hasItems(category));
		}
		private void assertThat(Optional<Category> result, Matcher<Iterable<Category>> hasItems) {
			// TODO Auto-generated method stub
			
		}
	}

