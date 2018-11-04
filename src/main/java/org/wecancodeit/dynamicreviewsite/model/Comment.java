package org.wecancodeit.dynamicreviewsite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import org.wecancodeit.dynamicreviewsite.model.Review;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	@Lob
	private String content;
	
	@JsonIgnore
	@ManyToOne
	private Review review;
	
	public Comment() {}
	
	public Comment(String username, String content, Review review) {
		this.username = username;
		this.content = content;
		this.review = review;
	}
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getContent() {
		return content;
	}
	public Review getReview() {
		return review;
	}
	
}
