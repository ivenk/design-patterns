import java.util.ArrayList;
import java.util.List;

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