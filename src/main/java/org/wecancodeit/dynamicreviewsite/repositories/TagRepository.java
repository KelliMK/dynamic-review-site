package org.wecancodeit.dynamicreviewsite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wecancodeit.dynamicreviewsite.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
