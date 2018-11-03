package org.wecancodeit.dynamicreviewsite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("unused")
@Entity
public class Comment {
	
	@Id
	@GeneratedValue
	private Long commentId;
	private String username;
	private String content;
	
	@ManyToOne
	private Review review;
	
	public Comment() {}
	
	public Comment(String username, String content, Review review) {
		this.username = username;
		this.content = content;
		this.review = review;
	}
	public Long getCommentId() {
		return commentId;
	}
	public String getUsername() {
		return username;
	}
	public String getContent() {
		return content;
	}
	
}
