package rsmeral.devconf2014.demo;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

@Qualifier
@Target({METHOD,FIELD,PARAMETER,TYPE})
@Retention(RUNTIME)
public @interface Demo {
}
