package org.omilab.services.template.servicea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;


@RestController
public class TestService {

    @GET
    @Path("/test2")
    @Produces("application/json")
    public String test(final List<byte[]> image, List<String> tag){


        return "Hi";
    }
}
