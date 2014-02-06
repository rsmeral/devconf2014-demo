package rsmeral.devconf2014.demo.hack;

import java.util.Properties;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.agorava.api.oauth.Token;
import org.agorava.api.service.OAuthLifeCycleService;
import org.apache.deltaspike.core.api.resourceloader.ExternalResource;

@Interceptor
@AgoravaOAuthHacked
public class AgoravaOAuthHack {

    @Inject
    private OAuthLifeCycleService lifeCycleService;

    @Inject
    @ExternalResource(location = "demo.properties")
    private Properties prop;
    
    @AroundInvoke
    public Object setAccessToken(InvocationContext ctx) throws Exception {
        lifeCycleService.buildSessionFor("Twitter");
        lifeCycleService.getCurrentSession().setAccessToken(new Token(prop.getProperty("accessToken"), prop.getProperty("accessTokenSecret")));
        return ctx.proceed();
    }
}
