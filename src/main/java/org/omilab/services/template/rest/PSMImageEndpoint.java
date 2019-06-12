package org.omilab.services.template.rest;

import java.io.IOException;
import java.util.Base64;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
    public String saveImage(@RequestBody Map<String, String> payload) {
        try {
            byte[] decodedString = Base64.getDecoder().decode(new String(payload.get("image")).getBytes("UTF-8"));
            return imageService.saveImage(payload.get("tag"), decodedString);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
