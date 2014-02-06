package rsmeral.devconf2014.demo.limiter;

import java.lang.reflect.Method;
import java.util.Date;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@RateLimited
public class RateLimitCacher {

    @Inject
    private LimiterCache cache;

    @Inject
    private TwitterRateLimitChecker twitterLimit;

    @AroundInvoke
    public Object limitRate(InvocationContext ctx) throws Exception {
        Method method = ctx.getMethod();
        Date lastExec = cache.getLastExecuted(method);

        int limit = method.getAnnotation(RateLimited.class).value();
        Date now = new Date();

        if (!twitterLimit.isExceeded()
                && (lastExec == null || lastExec.getTime() < now.getTime() - limit * 1000)) {
            Object result = ctx.proceed();
            cache.putObject(method, result, now);
            return result;
        }
        return cache.getValue(method);
    }

}
