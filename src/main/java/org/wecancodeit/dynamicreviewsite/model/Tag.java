package org.wecancodeit.dynamicreviewsite.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long tagId;
	private String tagName;

	@JsonIgnore
	@ManyToMany(mappedBy = "tags")
	private Collection<Review> reviews;

	public Tag() {
	}

	public Tag(String tagName) {
		this.tagName = tagName;
	}

	public void addReview(Review review) {
		reviews.add(review);
	}

	public void removeReview(Review review) {
		reviews.remove(review);
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
