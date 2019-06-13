package org.omilab.services.template.imageannotation.service;

import java.util.Base64;

import org.omilab.services.template.imageannotation.entity.ImageEntity;
import org.omilab.services.template.imageannotation.entity.TagEntity;
import org.omilab.services.template.imageannotation.model.Image;
import org.omilab.services.template.imageannotation.model.ImageTO;
import org.omilab.services.template.imageannotation.repo.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    @Override
    public String saveImage(String tagContent, byte[] image) {
    	TagEntity tag = new TagEntity();
    	tag.setTag(tagContent);
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setTag(tag);
        imageEntity.setImage(image);

        imageRepository.save(imageEntity);
        return "Image with tag " + tag + " was successfully saved in database.";
    }

	@Override
	public ImageTO getById(int id) {
		ImageEntity image = imageRepository.getById(id);
		ImageTO imageTO = new ImageTO();
		String encoded = Base64.getEncoder().encodeToString(image.getImage());
		imageTO.setImage(encoded);
		imageTO.setTag(image.getTag().getTag());
		return imageTO;
	}

	@Override
	public void deleteById(int id) {
		imageRepository.delete(id);;
	}

	@Override
	public String updateImage(int id, String tag, byte[] imageBody) {
		ImageEntity image = imageRepository.getById(id);
		TagEntity tagEntity = image.getTag();
		tagEntity.setTag(tag);
		image.setImage(imageBody);
		imageRepository.save(image);
		return "Image with tag " + tag + " was successfully saved in database.";
	}
}
