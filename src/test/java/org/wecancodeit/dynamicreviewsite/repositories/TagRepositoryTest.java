package org.wecancodeit.dynamicreviewsite.repositories;

import javax.swing.text.html.HTML.Tag;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TagRepositoryTest {

	@Autowired
	TagRepository tagRepo;

	@Test
	public void canInsertTag() {
		Tag tag = new Tag();

	}
}
