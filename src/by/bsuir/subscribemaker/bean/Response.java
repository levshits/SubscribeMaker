package by.bsuir.subscribemaker.bean;

import by.bsuir.subscribemaker.view.ResponseElements;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valentin on 3/18/2015.
 */
public class Response {
    private Map<ResponseElements, Object> results = new HashMap<ResponseElements, Object>();

    public Map<ResponseElements, Object> getResult() {
        return results;
    }

    public void setResult(Map<ResponseElements, Object> result) {
        this.results = result;
    }

    public void setResult(ResponseElements type, Object result)
    {
        results.put(type, result);
    }
    public Object getResult(ResponseElements parameter)
    {
        Object result = null;
        if(results.containsKey(parameter)) {
            result = results.get(parameter);
        }
        return result;
    }
}
