package org.omilab.services.template.imageannotation.service;

import java.util.List;

import org.omilab.services.template.imageannotation.model.Tag;

public interface TagService {

	Tag getById(int id);

	Tag getByName(String name);

	List<Tag> getAllTags();

	String updateById(int id, String tag);

	void delete(int id);

	String save(String tag);

}
