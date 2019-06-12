package org.omilab.services.template.imageannotation.repo;

import org.omilab.services.template.imageannotation.entity.ImageEntity;
import org.omilab.services.template.imageannotation.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Integer> {
    ImageEntity getById(int image);

//    @Query("select i.image_byte from ImageEntity i where i.fk_tag = tag")
//    ImageEntity findImageEntitiesByTag(String tag);
}
