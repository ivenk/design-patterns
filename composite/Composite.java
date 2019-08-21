import java.util.ArrayList;
import java.util.List;

class Composite implements Component {
    List<Component> components = new ArrayList<>();

    public void doStuff() {
        components.forEach(component -> component.doStuff());
    }

    public void add(Component inComponent) {
        components.add(inComponent);
    }
    // also maybe remove, update ...
}

interface Component {
    void doStuff();
}

class Leaf implements Component{
    private String message;

    public Leaf(String inMessage) {
        this.message = inMessage;
    }

    @Override
    public void doStuff() {
        System.out.println(this.message);
    }
}

class Client {
    private Component component;

    public Client(Component inComponent) {
        this.component = inComponent;
    }

    public void doStuff(){
        component.doStuff();
    }

    public static void main(String args[]) {
        // some setup done somewhere else
        Leaf l1 = new Leaf("A");
        Composite composite = new Composite();

        composite.add(l1);
        composite.add(new Leaf("B"));
        composite.add(new Leaf("C"));

        // client using the composite
        Client client = new Client(composite);
        client.doStuff();

        // client using single leaf
        Client client2 = new Client(l1);
        client2.doStuff();

        // Client does not know how many elements are in the composite or if he even uses a composite (for proper implementation of the pattern he should be working on a composite)
    }

}