package org.omilab.services.template.rest;

import org.omilab.services.template.imageannotation.model.Image;
import org.omilab.services.template.imageannotation.service.ImageService;
import org.omilab.services.template.service.InstanceMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
}
