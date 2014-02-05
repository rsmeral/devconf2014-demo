package rsmeral.devconf2014.demo.rest;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rsmeral.devconf2014.demo.SimpleTweet;

@Path("/tweets")
@RequestScoped
public class TweetRESTService {
    
    @Inject
    private List<SimpleTweet> tweets;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFeed() {
        return Response.ok(tweets).header("Access-Control-Allow-Origin", "*").build();
    }

}
