package org.omilab.services.template.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.omilab.services.template.imageannotation.model.Tag;
import org.omilab.services.template.imageannotation.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Path("/tag")
public class PSMTagEndpoint {
	@Autowired
	TagService tagService;
	
	@GET
	@Path("/byId")
	public Tag getTag(@RequestParam("id") int id) {
		return tagService.getById(id);
	}
	
	@GET
	@Path("/byName")
	public Tag getTag(@RequestParam("name") String name) {
		return tagService.getByName(name);
	}
	
	@GET
	@Path("/all")
	public List<Tag> getAllTags() {
		return tagService.getAllTags();
	}
	
	@POST
	@Path("/update")
	public String updateById(@RequestParam("id") int id, @RequestParam("tag") String tag) {
		return tagService.updateById(id, tag);
	}
	
	@DELETE
	@Path("/delete")
	public void delete(@RequestParam("id") int id) {
		tagService.delete(id);
	}
	
	@POST
	@Path("/save")
	public String save(@RequestParam("tag") String tag) {
		return tagService.save(tag);
	}
}
