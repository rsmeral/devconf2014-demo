package rsmeral.devconf2014.demo.limiter;

import javax.inject.Inject;
import org.agorava.twitter.Twitter;
import org.agorava.twitter.TwitterUserService;
import rsmeral.devconf2014.demo.hack.AgoravaOAuthHacked;

@AgoravaOAuthHacked
public class TwitterRateLimitChecker {
    
    @Inject
    @Twitter
    private TwitterUserService user;
    
    public boolean isExceeded() {
        // doesn't work due to AGOVA-74
        // return user.getRateLimitStatus().getRemainingHits() <= 0;
        return false;
    }
}
