package by.bsuir.subscribemaker.logic;

import by.bsuir.subscribemaker.controller.RequestElement;
import by.bsuir.subscribemaker.entity.ISubscribable;
import by.bsuir.subscribemaker.entity.Subscribe;
import by.bsuir.subscribemaker.entity.SubscribeType;

import java.util.Map;

/**
 * Created by Valentin on 3/18/2015.
 */
public final class SubscribeEditor {
    private SubscribeEditor(){}

    public static void setSubscribeType(Subscribe subscribe, SubscribeType type)
    {
        subscribe.setType(type);
    }
    public static boolean addElementToSubscribe(Subscribe subscribe, Map<RequestElement, Object> params)
    {
        boolean result = false;
        if(params.containsKey(RequestElement.ELEMENT_TYPE)) {
            Object object = params.get(RequestElement.ELEMENT_TYPE);
            if(object instanceof SubscribeElementType){
                ISubscribable element = SubscribeElementFactory.createElement((SubscribeElementType)object);
                if(element!=null){
                    if(SubscribeElementFactory.setElementName(element, params)&& SubscribeElementFactory.setElementPrice(element, params) && SubscribeElementFactory.setElementParams(element, params)) {
                            subscribe.addElement(element);
                            result = true;
                    }
                }
            }
        }
        return result;
    }

    public static void removeElementFromSubscribeAt(Subscribe subscribe, int index)
    {
        subscribe.removeElementAt(index);
    }
    public static int getSubscribePrice(Subscribe subscribe)
    {
        int price = 0;
        for (ISubscribable element: subscribe.getElements()){
            price+= element.getPrice();
        }
        switch (subscribe.getType()) {
            case THREE_MONTH:
                price*=3;
                break;
            case HALF_OF_YEAR:
                price*=6;
                break;
            case YEAR:
                price*=12;
                break;
            case TWO_YEAR:
                price*=24;
                break;
        }
        return price;
    }

    public static Object getSubcribeElements(Subscribe obj) {
        return obj.getElements();
    }
}
