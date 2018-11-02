package org.wecancodeit.dynamicreviewsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.dynamicreviewsite.model.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}