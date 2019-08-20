import java.util.ArrayList;
import java.util.List;

public class Decorator {
    public static void main(String args[]) {
        IDrinkable coffee = new MilkDecorator(new SugarDecorator(new Coffee()));
        System.out.println(coffee.makeCoffee());
    }
}

// Base class; instances of this class should be modifiable
class Coffee implements IDrinkable {
    List<String> ingredients = new ArrayList<String>();

    @Override
    public List<String> makeCoffee() {
        System.out.println("Making basic coffee");
        ingredients.add("Water");
        ingredients.add("Beans");
        return ingredients;
    }
}

// Base class follows this interface
interface IDrinkable {
    List<String> makeCoffee();
}

// Base Decorator; Will be inherited by all other decorators
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

// Actual decorator; this will modify the base class in a specific way
class MilkDecorator extends CoffeeDecorator {

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

// Actual decorator; this will modify the base class in a specific way
class SugarDecorator extends CoffeeDecorator{

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