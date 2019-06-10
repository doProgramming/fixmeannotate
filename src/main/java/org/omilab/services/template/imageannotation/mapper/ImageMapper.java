package org.omilab.services.template.imageannotation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.omilab.services.template.imageannotation.entity.ImageEntity;
import org.omilab.services.template.imageannotation.model.Image;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    ImageEntity mapToEntity(Image image);
    @Mapping(source = "id", target = "id")
    Image mapToModel(ImageEntity imageEntity);
}
