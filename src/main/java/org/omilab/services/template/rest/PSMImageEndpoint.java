package org.omilab.services.template.rest;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.omilab.services.template.imageannotation.model.ImageTO;
import org.omilab.services.template.imageannotation.service.ImageService;
import org.omilab.services.template.service.InstanceMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Path("/image")
public class PSMImageEndpoint {

    private final InstanceMgmtService instanceMgmtService;

    @Autowired
    public PSMImageEndpoint(InstanceMgmtService instanceMgmtService) {
        this.instanceMgmtService = instanceMgmtService;
    }


    @Autowired
    ImageService imageService;
    
    @GET
    @Path("/annotate")
    @Produces("application/json")
    public String annotateImage(final @RequestParam("image") String image, final  @RequestParam("tag")String tag ){
        int tag2 = 1;
        imageService.annotateImage(tag2);
        return "test!";
    }
    
    @POST
    @Path("/save")
    @Consumes("application/json")
    public String saveImage(@RequestBody List<ImageTO> image) {
        try {
        	ImageTO imageTO = image.get(0);
            byte[] decodedString = Base64.getDecoder().decode(new String(imageTO.getImage()).getBytes("UTF-8"));
            return imageService.saveImage(imageTO.getTag(), decodedString);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
    
    @GET
    @Path("/image")
    @Produces("application/json")
    public ImageTO getImage(@RequestParam("id") int id) {
    	return imageService.getById(id);
    }
    
    @DELETE
    @Path("/image")
    public void deleteImage(@RequestParam("id") int id) {
    	imageService.deleteById(id);
    }
    
}
