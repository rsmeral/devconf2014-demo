package rsmeral.devconf2014.demo;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import org.agorava.api.oauth.application.OAuthAppSettings;
import org.agorava.api.oauth.application.OAuthAppSettingsBuilder;
import org.agorava.api.oauth.application.OAuthApplication;
import org.agorava.api.oauth.application.Param;
import org.agorava.twitter.Twitter;

public class Resources {

    @Produces
    @ApplicationScoped
    @Twitter
    @OAuthApplication(params = {
        @Param(name = OAuthAppSettingsBuilder.PREFIX, value = "twitter")}
    )
    public OAuthAppSettings twitterSettings;
}
