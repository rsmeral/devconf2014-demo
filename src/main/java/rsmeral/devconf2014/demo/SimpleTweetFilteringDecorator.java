package rsmeral.devconf2014.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import org.apache.deltaspike.core.api.resourceloader.ExternalResource;

@Decorator
public abstract class SimpleTweetFilteringDecorator implements SimpleTwitterFeed {

    @Inject
    @ExternalResource(location = "demo.properties")
    private Properties prop;
    
    @Inject
    @Delegate
    @Any
    private SimpleTwitterFeed feed;

    @Override
    public List<SimpleTweet> getSimpleTweets() {
        List<SimpleTweet> simpleTweets = feed.getSimpleTweets();
        List<SimpleTweet> filtered = new ArrayList<SimpleTweet>();
        for (SimpleTweet tweet : simpleTweets) {
            if (containsAllTerms(tweet.getText(), filterTerms())) {
                filtered.add(tweet);
            }
        }
        return filtered;
    }

    private boolean containsAllTerms(String text, List<String> terms) {
        for (String term : terms) {
            if (!text.toLowerCase().contains(term.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    private List<String> filterTerms() {
        return Arrays.asList(prop.getProperty("filter").split(","));
    }

}
