package org.wecancodeit.dynamicreviewsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.dynamicreviewsite.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
