import java.util.List;

public class SugarDecorator extends CoffeeDecorator{

    public SugarDecorator(IDrinkable inDrinkable) {
        super(inDrinkable);
    }

    @Override
    public List<String> makeCoffee() {
        return addSugar(this.drinkable.makeCoffee());
    }

    private List<String> addSugar(List<String> inIngredients) {
        inIngredients.add("Sugar");
        return inIngredients;
    }
}
