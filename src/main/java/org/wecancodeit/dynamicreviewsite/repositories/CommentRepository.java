package org.wecancodeit.dynamicreviewsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.dynamicreviewsite.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
