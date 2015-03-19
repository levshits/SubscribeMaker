package by.bsuir.subscribemaker.entity;

/**
 * Created by Valentin on 3/18/2015.
 */
public class Newspaper implements ISubscribable {
    private String name;
    private NewspaperType type;
    private int price;

    @Override
    public String toString() {
        return new String("Newspaper " +  name+" "+ type.name()+" " + price);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    public NewspaperType getType() {
        return type;
    }

    public void setType(NewspaperType type) {
        this.type = type;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
