package org.omilab.services.template.imageannotation.service;

import org.omilab.services.template.imageannotation.model.ImageTO;

public interface ImageService {

    byte[] annotateImage(int tag);

    String saveImage(String tag, byte[] image);

	ImageTO getById(int id);

	void deleteById(int id);

	String updateImage(int id, String tag, byte[] decodeImageBody);
}
