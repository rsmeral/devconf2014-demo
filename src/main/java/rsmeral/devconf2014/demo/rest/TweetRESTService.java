package rsmeral.devconf2014.demo.rest;

import rsmeral.devconf2014.demo.filter.FilterTerms;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rsmeral.devconf2014.demo.simple.SimpleTweet;

@Path("/tweets")
@RequestScoped
public class TweetRESTService {

    @Inject
    private Instance<List<SimpleTweet>> tweets;

    @Inject
    private FilterTerms filterTerms;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFeed(@QueryParam("filter") String filter) {
        if (filter != null) {
            filterTerms.setList(filter);
        }
        return Response.ok(tweets.get()).header("Access-Control-Allow-Origin", "*").build();
    }

}
