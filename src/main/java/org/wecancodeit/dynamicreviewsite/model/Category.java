package org.wecancodeit.dynamicreviewsite.model;
 import java.util.Collection;
 import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
 
@Entity
public class Category {
 	@Id
	@GeneratedValue
	private Long id;
	private String categoryName;
	private String categoryImageUrl;
	
 	@Lob
	private String categoryDescription;
	
	@OneToMany(mappedBy="category")
	private Collection<Review> reviews;
	
	public Category() {}
	
	public Category(String categoryName, String categoryDescription, String categoryImageUrl) {
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.categoryImageUrl = categoryImageUrl;
	}
	
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public String getCategoryImageUrl() {
		return categoryImageUrl;
	}
	
	
	public String getCategoryName() {
		return categoryName;
	}
 	public Long getId() {
		return id;
	}
 	public Collection<Review> getReviews() {
		return reviews;
	}
 	@Override
	public String toString() {
		return categoryName;
	}
}