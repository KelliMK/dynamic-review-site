package org.wecancodeit.dynamicreviewsite.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long tagId;
	private String tagName;

	@ManyToMany(mappedBy = "tag")
	private Collection<Review> reviews;

	public Tag(String tagName) {
		this.tagName = tagName;
	}

	public Tag(String tagName, Review review) {
		this.tagName = tagName;
		addReview(review);
	}

	private void addReview(Review review) {
		reviews.add(review);
	}

	public Long getTagId() {
		return tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public Collection<Review> getReviews() {
		return reviews;
	}
}
