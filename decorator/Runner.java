public class Runner {

    public static void main(String args[]) {
        IDrinkable coffee = new MilkDecorator(new SugarDecorator(new Coffee()));
        System.out.println(coffee.makeCoffee());


    }
}
