package by.bsuir.subscribemaker.logic;

import by.bsuir.subscribemaker.controller.RequestElement;
import by.bsuir.subscribemaker.entity.*;

import java.util.Map;

/**
 * Created by Valentin on 3/18/2015.
 */
public final class SubscribeElementFactory {
    private  SubscribeElementFactory(){}

    public static ISubscribable createElement(SubscribeElementType type){
        ISubscribable element = null;
        switch (type){
            case MAGAZINE:
                element = new Magazine();
                break;
            case CATALOG:
                element = new Catalog();
                break;
            case NEWSPAPER:
                element=new Newspaper();
                break;
        }
        return element;
    }

    public static boolean setElementParams(ISubscribable element, Map<RequestElement, Object> params) {
        boolean result = false;
        if(element instanceof Magazine){
            result = setMagazineParams((Magazine)element, params);}
        else if(element instanceof Newspaper){
            result = setNewspaperParams((Newspaper) element, params);}
        else if(element instanceof Catalog){
            result = setCatalogParams((Catalog) element, params);}
        return result;

    }

    private static boolean setCatalogParams(Catalog element, Map<RequestElement, Object> params) {
        boolean result = false;
        if(params.containsKey(RequestElement.TYPE))
        {
            Object object = params.get(RequestElement.TYPE);
            if(object instanceof String)
            {
                try {
                    element.setType(CatalogType.valueOf((String)object));
                    result = true;
                }catch (IllegalArgumentException e)
                {

                }
            }
        }
        return result;
    }

    private static boolean setNewspaperParams(Newspaper element, Map<RequestElement, Object> params) {
        boolean result = false;
        if(params.containsKey(RequestElement.TYPE))
        {
            Object object = params.get(RequestElement.TYPE);
            if(object instanceof String)
            {
                try {
                    element.setType(NewspaperType.valueOf((String)object));
                    result = true;
                }catch (IllegalArgumentException e)
                {

                }
            }
        }
        return result;

    }

    private static boolean setMagazineParams(Magazine element, Map<RequestElement, Object> params) {
        boolean result = false;
        if(params.containsKey(RequestElement.TYPE))
        {
            Object object = params.get(RequestElement.TYPE);
            if(object instanceof String)
            {
                try {
                    element.setType(MagazineType.valueOf((String)object));
                    result = true;
                }catch (IllegalArgumentException e)
                {

                }

            }
        }
        return result;
    }

    public static boolean setElementName(ISubscribable element, Map<RequestElement, Object> params) {
        boolean result = false;
        if(params.containsKey(RequestElement.NAME))
        {
            Object object = params.get(RequestElement.NAME);
            if(object instanceof String)
            {
                element.setName((String) object);
                result = true;
            }
        }
        return result;
    }
    public static boolean setElementPrice(ISubscribable element, Map<RequestElement, Object> params) {
        boolean result = false;
        if(params.containsKey(RequestElement.PRICE))
        {
            Object object = params.get(RequestElement.PRICE);
            if(object instanceof Integer)
            {
                element.setPrice((Integer) object);
                result = true;
            }
        }
        return result;
    }
}
