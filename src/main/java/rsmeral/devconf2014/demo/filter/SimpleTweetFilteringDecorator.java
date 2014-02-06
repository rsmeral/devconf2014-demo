package rsmeral.devconf2014.demo.filter;

import java.util.ArrayList;
import java.util.List;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import rsmeral.devconf2014.demo.simple.SimpleTweet;
import rsmeral.devconf2014.demo.simple.SimpleTwitterFeed;

@Decorator
public abstract class SimpleTweetFilteringDecorator implements SimpleTwitterFeed {

    @Inject
    @Delegate
    @Any
    private SimpleTwitterFeed feed;

    @Inject
    private FilterTerms terms;

    @Override
    public List<SimpleTweet> getSimpleTweets() {
        List<SimpleTweet> simpleTweets = feed.getSimpleTweets();
        List<SimpleTweet> filtered = new ArrayList<SimpleTweet>();
        for (SimpleTweet tweet : simpleTweets) {
            if (containsAllTerms(tweet.getText(), terms.getList())) {
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

}
