package org.wecancodeit.dynamicreviewsite.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private Long id;
	private String languageName;
	private int yearCreated;
	private String reviewImageUrl;

	@Lob
	private String reviewText;
	private Long userFriendliness;
	private Long usefulness;

	@ManyToOne
	private Category category;

	@OneToMany(mappedBy = "review")
	private Collection<Comment> comments;

	@ManyToMany
	private Collection<Tag> tag;

	public Collection<Comment> getComments() {
		return comments;
	}

	public Collection<Tag> getTag() {
		return tag;
	}

	public Review() {
	}

	public Review(String languageName, int yearCreated, String reviewText, Category category, Long userFriendliness,
			Long usefulness, String reviewImageUrl, Tag... tag) {
		this.languageName = languageName;
		this.yearCreated = yearCreated;
		this.reviewText = reviewText;
		this.category = category;
		this.userFriendliness = userFriendliness;
		this.usefulness = usefulness;
		this.reviewImageUrl = reviewImageUrl;
		this.tag = new HashSet<>(Arrays.asList(tag));
	}

	public Category getCategory() {
		return category;
	}

	public Long getId() {
		return id;
	}

	public String getLanguageName() {
		return languageName;
	}

	public String getReviewImageUrl() {
		return reviewImageUrl;
	}

	public String getReviewText() {
		return reviewText;
	}

	public Long getUsefulness() {
		return usefulness;
	}

	public Long getUserFriendliness() {
		return userFriendliness;
	}

	public int getYearCreated() {
		return yearCreated;
	}
}