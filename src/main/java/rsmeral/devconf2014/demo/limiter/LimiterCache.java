package rsmeral.devconf2014.demo.limiter;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LimiterCache {
    
    private final Map<Method, Date> dates;
    private final Map<Method, Object> objects;

    public LimiterCache() {
        dates = new HashMap<Method, Date>();
        objects = new HashMap<Method, Object>();
    }

    public Date getLastExecuted(Method key) {
        return dates.get(key);
    }
    
    public Object getValue(Method key) {
        return objects.get(key);
    }

    public void putObject(Method key, Object obj, Date date) {
        objects.put(key, obj);
        dates.put(key, date);
    }

    public boolean contains(Method method) {
        return dates.containsKey(method);
    }
    
    
}
