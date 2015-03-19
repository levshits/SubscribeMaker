package by.bsuir.subscribemaker.entity;

import java.util.*;

/**
 * Created by Valentin on 3/18/2015.
 */
public class Subscribe {
    private List<ISubscribable> elements = new LinkedList<ISubscribable>();
    private SubscribeType type = SubscribeType.MONTH;

    public void addElement(ISubscribable element){
        elements.add(element);
    }

    public void removeElement(ISubscribable element){
        elements.remove(element);
    }

    public void setType(SubscribeType type){
        this.type = type;
    }

    public SubscribeType getType(){
        return type;
    }

    public void removeElementAt(int index) {
        if(index < elements.size())
        {
            elements.remove(index);
        }
    }

    public List<ISubscribable> getElements() {
        return elements;
    }
}
