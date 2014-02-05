package rsmeral.devconf2014.demo;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.agorava.twitter.model.Tweet;

public class TweetSimplifier implements SimpleTwitterFeed {

    @Inject
    @Demo
    private List<Tweet> tweets;

    @Override
    @Produces
    public List<SimpleTweet> getSimpleTweets() {
        List<SimpleTweet> result = new ArrayList<SimpleTweet>();
        for (Tweet tweet : tweets) {
            result.add(new SimpleTweet(
                    tweet.getFromUser(),
                    tweet.getCreatedAt(),
                    tweet.getProfileImageUrl(),
                    tweet.getText()));
        }
        return result;
    }

}
