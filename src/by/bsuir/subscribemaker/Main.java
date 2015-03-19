package by.bsuir.subscribemaker;

import by.bsuir.subscribemaker.controller.SubscribeMakerController;
import by.bsuir.subscribemaker.entity.Subscribe;
import by.bsuir.subscribemaker.entity.SubscribeType;
import by.bsuir.subscribemaker.logic.SubscribeElementType;
import by.bsuir.subscribemaker.view.SubscribeMakerView;

public class Main {

    public static void main(String[] args) {

        SubscribeMakerController controller = new SubscribeMakerController();
        SubscribeMakerView view = new SubscribeMakerView();
        view.setController(controller);
        Subscribe subscribe = view.createSubscribe();
        view.addElementToSubscribe(subscribe, "Belarus", SubscribeElementType.NEWSPAPER, "REGIONAL", 1000 );
        view.addElementToSubscribe(subscribe, "Planeta", SubscribeElementType.MAGAZINE, "FOR_MEN", 15000 );
        view.addElementToSubscribe(subscribe, "Oriflame", SubscribeElementType.CATALOG, "PERFUMERY", 15000 );
        view.getSubscribePrice(subscribe);
        view.getSubscribeElements(subscribe);
        view.deleteElementFromSubscribeAt(subscribe, 0);
        view.getSubscribeElements(subscribe);
    }
}