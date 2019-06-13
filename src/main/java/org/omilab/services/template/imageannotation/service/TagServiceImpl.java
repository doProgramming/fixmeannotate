package org.omilab.services.template.imageannotation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.omilab.services.template.imageannotation.entity.TagEntity;
import org.omilab.services.template.imageannotation.model.Tag;
import org.omilab.services.template.imageannotation.repo.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagServiceImpl implements TagService {
	
	@Autowired
	TagRepository tagRepository;

	@Override
	public Tag getById(int id) {
		TagEntity tag = tagRepository.getById(id);
		return convert(tag);
	}
	
	private Tag convert(TagEntity entity) {
		Tag result = new Tag();
		result.setId(entity.getId());
		result.setName(entity.getTag());
		return result;
	}

	@Override
	public Tag getByName(String name) {
		TagEntity tag = tagRepository.getByName(name);
		return convert(tag);
	}

	@Override
	public List<Tag> getAllTags() {
		List<TagEntity> all = tagRepository.findAll();
		return all.stream()
			.map(t -> convert(t))
			.collect(Collectors.toList());
	}

	@Override
	public String updateById(int id, String tag) {
		TagEntity tagEntity = tagRepository.findOne(id);
		tagEntity.setTag(tag);
		tagRepository.save(tagEntity);
		return "Tag " + tag + " was successfully saved in database";
	}

	@Override
	public void delete(int id) {
		tagRepository.delete(id);
	}

	@Override
	public String save(String tag) {
		TagEntity tagEntity = new TagEntity();
		tagEntity.setTag(tag);
		tagRepository.save(tagEntity);
		return "Tag " + tag + " was successfully saved in database";
	}

}
