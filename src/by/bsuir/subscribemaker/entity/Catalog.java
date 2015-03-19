package by.bsuir.subscribemaker.entity;

/**
 * Created by Valentin on 3/18/2015.
 */
public class Catalog implements ISubscribable {
    private String name;
    private CatalogType type;
    private int price;

    public String toString() {
        return new String("Catalog " + name+" "+ type.name()+" " + price);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    public CatalogType getType() {
        return type;
    }

    public void setType(CatalogType type) {
        this.type = type;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }
}
