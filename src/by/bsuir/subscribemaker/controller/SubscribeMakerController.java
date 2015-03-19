package by.bsuir.subscribemaker.controller;

import by.bsuir.subscribemaker.bean.Request;
import by.bsuir.subscribemaker.bean.Response;
import by.bsuir.subscribemaker.entity.Subscribe;
import by.bsuir.subscribemaker.entity.SubscribeType;
import by.bsuir.subscribemaker.logic.SubscribeEditor;
import by.bsuir.subscribemaker.logic.SubscribeFactory;
import by.bsuir.subscribemaker.view.ResponseElements;

import java.util.Map;

/**
 * Created by Valentin on 3/18/2015.
 */
public class SubscribeMakerController {

    public Response execute(Request request)
    {
        Response response = null;
        switch (request.getOperationType())
        {
            case CREATE_SUBSCRIBE:
                response = createSubscribe();
                break;
            case CALCULATE_PRICE:
                response = calculatePrice(request.getParameters());
                break;
            case SET_SUBSCRIBE_TYPE:
                response = setSubscribeType(request.getParameters());
                break;
            case VIEW_ALL_ELEMENTS:
                response = viewAllElements(request.getParameters());
                break;
            case ADD_SUBSCRIBE_ELEMENT:
                response = addSubscribeElement(request.getParameters());
                break;
            case REMOVE_SUBSCRIBE_ELEMENT:
                response = removeSubscribeElement(request.getParameters());
                break;
        }
        return response;
    }

    private Response removeSubscribeElement(Map<RequestElement, Object> parameters) {
        Response response = new Response();
        boolean isSuccessfully = false;
        if(parameters.containsKey(RequestElement.SUBSCRIBE) && parameters.containsKey(RequestElement.INDEX)){
            Object subscribe = parameters.get(RequestElement.SUBSCRIBE);
            Object index = parameters.get(RequestElement.INDEX);
            if( subscribe instanceof Subscribe && index instanceof Integer) {
                isSuccessfully = true;
                SubscribeEditor.removeElementFromSubscribeAt((Subscribe) subscribe, (Integer) index);
            }
        }
        response.setResult(ResponseElements.STATUS, isSuccessfully);
        return response;
    }

    private Response addSubscribeElement(Map<RequestElement, Object> parameters) {
        Response response = new Response();
        boolean isSuccessfully = false;
        if(parameters.containsKey(RequestElement.SUBSCRIBE)){
            Object obj = parameters.get(RequestElement.SUBSCRIBE);
            if( obj instanceof Subscribe) {
                isSuccessfully = SubscribeEditor.addElementToSubscribe((Subscribe) obj, parameters);
            }
        }
        response.setResult(ResponseElements.STATUS, isSuccessfully);
        return response;
    }

    private Response viewAllElements(Map<RequestElement, Object> parameters) {
        Response response = new Response();
        boolean isSuccessfully = false;
        if(parameters.containsKey(RequestElement.SUBSCRIBE)){
            Object obj = parameters.get(RequestElement.SUBSCRIBE);
            if( obj instanceof Subscribe) {
                isSuccessfully = true;
                response.setResult(ResponseElements.SUBSCRIBE_ELEMENTS, SubscribeEditor.getSubcribeElements((Subscribe) obj));
            }
        }
        response.setResult(ResponseElements.STATUS, isSuccessfully);
        return response;
    }

    private Response setSubscribeType(Map<RequestElement, Object> parameters) {
        Response response = new Response();
        boolean isSuccessfully = false;
        if(parameters.containsKey(RequestElement.SUBSCRIBE) && parameters.containsKey(RequestElement.SUBSCRIBE_TYPE)){
            Object subscribe = parameters.get(RequestElement.SUBSCRIBE);
            Object type = parameters.get(RequestElement.SUBSCRIBE_TYPE);
            if( subscribe instanceof Subscribe && type instanceof SubscribeType) {
                isSuccessfully = true;
                SubscribeEditor.setSubscribeType((Subscribe) subscribe, (SubscribeType) type);
            }
        }
        response.setResult(ResponseElements.STATUS, isSuccessfully);
        return response;
    }

    private Response calculatePrice(Map<RequestElement, Object> parameters) {
        Response response = new Response();
        boolean isSuccessfully = false;
        if(parameters.containsKey(RequestElement.SUBSCRIBE)){
            Object obj = parameters.get(RequestElement.SUBSCRIBE);
            if( obj instanceof Subscribe) {
                isSuccessfully = true;
                response.setResult(ResponseElements.PRICE, SubscribeEditor.getSubscribePrice((Subscribe) obj));
            }
        }
        response.setResult(ResponseElements.STATUS, isSuccessfully);
        return response;
    }

    private Response createSubscribe() {
        Response response = new Response();
        Subscribe subscribe = SubscribeFactory.createSubscribe();
        response.setResult(ResponseElements.SUBSCRIBE, subscribe);
        return response;
    }
}
