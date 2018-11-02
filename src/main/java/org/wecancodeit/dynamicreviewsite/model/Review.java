package org.wecancodeit.dynamicreviewsite.model;
 
import java.util.Collection;

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
	
	public Collection <Comment> getComments(){
		return comments;
	}
	
	public Review() {}
	
	public Review(String languageName, int yearCreated, String reviewText, Category category, Long userFriendliness, Long usefulness, String reviewImageUrl) {
		this.languageName = languageName;
		this.yearCreated = yearCreated;
		this.reviewText = reviewText;
		this.category = category;
		this.userFriendliness = userFriendliness;
		this.usefulness = usefulness;
		this.reviewImageUrl = reviewImageUrl;
		
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