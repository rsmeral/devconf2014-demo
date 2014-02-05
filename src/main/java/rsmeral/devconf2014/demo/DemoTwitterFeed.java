package rsmeral.devconf2014.demo;

import java.util.List;
import java.util.Properties;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.agorava.api.oauth.Token;
import org.agorava.api.service.OAuthLifeCycleService;
import org.agorava.twitter.Twitter;
import org.agorava.twitter.TwitterTimelineService;
import org.agorava.twitter.model.Tweet;
import org.apache.deltaspike.core.api.resourceloader.ExternalResource;

public class DemoTwitterFeed {

    private static final int NUM_TWEETS = 100;

    @Inject
    private OAuthLifeCycleService lifeCycleService;

    @Inject
    @ExternalResource(location = "demo.properties")
    private Properties prop;

    @Inject
    @Twitter
    private TwitterTimelineService timeline;
    
    @Produces
    @Demo
    public List<Tweet> pollTweets() {
        lifeCycleService.buildSessionFor("Twitter");
        lifeCycleService.getCurrentSession().setAccessToken(new Token(prop.getProperty("accessToken"), prop.getProperty("accessTokenSecret")));
        List<Tweet> tweets = timeline.getUserTimeline(prop.getProperty("user"), 1, NUM_TWEETS);
        return tweets;
    }

}
