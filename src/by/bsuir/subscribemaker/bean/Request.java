package by.bsuir.subscribemaker.bean;

import by.bsuir.subscribemaker.controller.OperationType;
import by.bsuir.subscribemaker.controller.RequestElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valentin on 3/18/2015.
 */
public class Request {
    private Map<RequestElement, Object> parameters = new HashMap<RequestElement, Object>();
    private OperationType operationType;

    public Map<RequestElement, Object> getParameters() {
        return parameters;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public void setParameters(Map<RequestElement, Object> parameters) {
        this.parameters = parameters;
    }
    public void setParameter(RequestElement parameter, Object value) {
        parameters.put(parameter, value);
    }
}
