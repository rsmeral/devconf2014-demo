package rsmeral.devconf2014.demo.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.apache.deltaspike.core.api.resourceloader.ExternalResource;

@RequestScoped
public class FilterTerms {

    private List<String> terms;

    public FilterTerms() {
        terms = new ArrayList<String>();
    }
    
    @Inject
    public FilterTerms(@ExternalResource(location = "demo.properties") Properties props) {
        terms = new ArrayList<String>();
        terms.addAll(splitTerms(props.getProperty("filter")));
    }

    public List<String> getList() {
        return terms;
    }

    public void setList(String filterString) {
        setList(splitTerms(filterString));
    }

    public void setList(List<String> newList) {
        terms.clear();
        terms.addAll(newList);
    }

    private List<String> splitTerms(String filterString) {
        return Arrays.asList(filterString.replace(" ", "").split(","));
    }
}
