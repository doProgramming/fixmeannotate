package org.omilab.services.template.imageannotation.service;

import org.omilab.services.template.imageannotation.model.Image;

public interface ImageService {

    byte[] annotateImage(int tag);
}
