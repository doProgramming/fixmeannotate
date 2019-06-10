package org.omilab.services.template.imageannotation.service;

import org.omilab.services.template.imageannotation.entity.ImageEntity;
import org.omilab.services.template.imageannotation.mapper.ImageMapper;
import org.omilab.services.template.imageannotation.model.Image;
import org.omilab.services.template.imageannotation.repo.ImageRepository;
import org.omilab.services.template.service.InstanceMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

@Component
public final class ImageServiceImpl implements ImageService{

    @Autowired
    ImageRepository imageRepository;

//    @Autowired
//    ImageMapper imageMapper;

    @Override
    public byte[] annotateImage(int tag) {
        //ImageEntity imageEntity = imageRepository.findImageEntitiesByTag(tag);
        ImageEntity imageEntity = imageRepository.getById(tag);
        Image image = new Image();
        if(imageEntity != null){
//            image = imageMapper.mapToModel(imageEntity);
        }
        byte [] imageByte = SerializationUtils.serialize(image);
        return imageByte;
    }
}
