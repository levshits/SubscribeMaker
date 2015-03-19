package by.bsuir.subscribemaker.logic;

import by.bsuir.subscribemaker.entity.Subscribe;
import by.bsuir.subscribemaker.entity.SubscribeType;

/**
 * Created by Valentin on 3/18/2015.
 */
public final class SubscribeFactory {
    private SubscribeFactory(){}
    public static Subscribe createSubscribe(){
        return new Subscribe();
    }

}
