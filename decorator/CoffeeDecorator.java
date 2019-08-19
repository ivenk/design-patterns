import java.util.List;

abstract class CoffeeDecorator implements IDrinkable{
    protected IDrinkable drinkable;

    public CoffeeDecorator(IDrinkable inDrinkable) {
        this.drinkable = inDrinkable;
    }

    @Override
    public List<String> makeCoffee() {
        return drinkable.makeCoffee();
    }
}
