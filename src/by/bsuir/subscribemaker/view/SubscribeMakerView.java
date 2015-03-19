package by.bsuir.subscribemaker.view;

import by.bsuir.subscribemaker.bean.Request;
import by.bsuir.subscribemaker.bean.Response;
import by.bsuir.subscribemaker.controller.OperationType;
import by.bsuir.subscribemaker.controller.RequestElement;
import by.bsuir.subscribemaker.controller.SubscribeMakerController;
import by.bsuir.subscribemaker.entity.ISubscribable;
import by.bsuir.subscribemaker.entity.Subscribe;
import by.bsuir.subscribemaker.entity.SubscribeType;
import by.bsuir.subscribemaker.logic.SubscribeElementType;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Valentin on 3/18/2015.
 */
public class SubscribeMakerView {
    private SubscribeMakerController controller;
    public Subscribe createSubscribe(){
        Request request = new Request();
        request.setOperationType(OperationType.CREATE_SUBSCRIBE);
        SubscribeMakerController makerController = controller;
        if (makerController!=null)
        {
            Response response = makerController.execute(request);
            Object object = response.getResult(ResponseElements.SUBSCRIBE);
            if(object instanceof Subscribe)
            {
                System.out.println("Subscribe created");
                return (Subscribe)object;
            }
        }
        return null;
    }
    public void addElementToSubscribe(Subscribe subscribe, String name, SubscribeElementType type, String elementType, int price){
        Request request = new Request();
        request.setOperationType(OperationType.ADD_SUBSCRIBE_ELEMENT);
        request.setParameter(RequestElement.ELEMENT_TYPE, type);
        request.setParameter(RequestElement.TYPE, elementType);
        request.setParameter(RequestElement.NAME, name);
        request.setParameter(RequestElement.SUBSCRIBE, subscribe);
        request.setParameter(RequestElement.PRICE, price);
        SubscribeMakerController makerController = controller;
        if (makerController!=null)
        {
            Response response = makerController.execute(request);
            Object object = response.getResult(ResponseElements.STATUS);
            if(object instanceof Boolean && (Boolean)object)
            {
                System.out.println("Element added");
            }
        }

    }
    public void deleteElementFromSubscribeAt(Subscribe subscribe, int index){
        Request request = new Request();
        request.setOperationType(OperationType.REMOVE_SUBSCRIBE_ELEMENT);
        request.setParameter(RequestElement.INDEX, index);
        request.setParameter(RequestElement.SUBSCRIBE, subscribe);
        SubscribeMakerController makerController = controller;
        if (makerController!=null)
        {
            Response response = makerController.execute(request);
            Object object = response.getResult(ResponseElements.STATUS);
            if(object instanceof Boolean && (Boolean)object)
            {
                System.out.println("Element deleted");
            }
        }
    }
    public void getSubscribePrice(Subscribe subscribe){
        Request request = new Request();
        request.setOperationType(OperationType.CALCULATE_PRICE);
        request.setParameter(RequestElement.SUBSCRIBE, subscribe);
        SubscribeMakerController makerController = controller;
        if (makerController!=null)
        {
            Response response = makerController.execute(request);
            Object object = response.getResult(ResponseElements.PRICE);
            if(object instanceof Integer )
            {
                System.out.println("Common price " + ((Integer) object).toString());
            }
        }
    }
    public void getSubscribeElements(Subscribe subscribe){
        Request request = new Request();
        request.setOperationType(OperationType.VIEW_ALL_ELEMENTS);
        request.setParameter(RequestElement.SUBSCRIBE, subscribe);
        SubscribeMakerController makerController = controller;
        if (makerController!=null)
        {
            Response response = makerController.execute(request);
            Object object = response.getResult(ResponseElements.SUBSCRIBE_ELEMENTS);
            if(object instanceof List )
            {
                for (Object obj: (List)object){
                    System.out.println(obj.toString());
                }

            }
        }
    }
    public void setController(SubscribeMakerController controller) {
        this.controller = controller;
    }
}
