package rsmeral.devconf2014.demo;

import rsmeral.devconf2014.demo.hack.AgoravaOAuthHacked;
import rsmeral.devconf2014.demo.limiter.RateLimited;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.agorava.twitter.Twitter;
import org.agorava.twitter.TwitterTimelineService;
import org.agorava.twitter.model.Tweet;

@RequestScoped
@AgoravaOAuthHacked
public class DemoTwitterFeed {

    private static final int NUM_TWEETS = 100;

    @Inject
    @Twitter
    private TwitterTimelineService timeline;
    
    @Produces
    @Demo
    @RateLimited(5)
    public List<Tweet> pollTweets() {
        List<Tweet> tweets = timeline.getMentions(1, NUM_TWEETS);
        return tweets;
    }

}
