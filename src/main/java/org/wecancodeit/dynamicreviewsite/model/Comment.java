package org.wecancodeit.dynamicreviewsite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String comment;
	
	public Comment() {}
	
	public Comment(String username, String comment, Review review) {
		this.username = username;
		this.comment = comment;
		this.review = review;
	}
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getComment() {
		return comment;
	}
	
	@JsonIgnore
	@ManyToOne
	private Review review;
	
}
