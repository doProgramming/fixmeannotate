package org.omilab.services.template.imageannotation.repo;

import org.omilab.services.template.imageannotation.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {
     TagEntity getById(String id);
}
