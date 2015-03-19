package by.bsuir.subscribemaker.entity;

/**
 * Created by Valentin on 3/18/2015.
 */
public class Magazine implements ISubscribable {
    private String name;
    private MagazineType type;
    private int price;

    public String toString() {
        return new String("Magazine "+ name+" "+ type.name()+" " + price);
    }
    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    public MagazineType getType() {
        return type;
    }

    public void setType(MagazineType type) {
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
