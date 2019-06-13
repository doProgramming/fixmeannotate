package org.omilab.services.template.imageannotation.repo;

import org.omilab.services.template.imageannotation.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Integer> {
     TagEntity getById(int id);

     @Query("select t from TagEntity t where t.tag = name")
	 TagEntity getByName(String name);
}
