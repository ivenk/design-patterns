import java.util.List;

public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(IDrinkable inDrinkable) {
        super(inDrinkable);
    }

    @Override
    public List<String> makeCoffee() {
        return addMilk(this.drinkable.makeCoffee());
    }

    private List<String> addMilk(List<String> inIngredients) {
        inIngredients.add("Milk");
        return inIngredients;
    }
}
