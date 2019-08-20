import java.security.InvalidParameterException;

class ConstructorClient {
    Interface inter;

    public ConstructorClient(Interface inInterface) {
        if (inInterface == null) {
            throw new InvalidParameterException("Interface cannot be null");
        }
        this.inter = inInterface;
    }

    public void doStuff() {
        inter.doX();
        inter.doY();
    }
}

class SetterClient {
    Interface inter1;
    Interface inter2;

    public void setInter1(Interface inInter) {
        if (inInter == null) {
            throw new InvalidParameterException("Interface cannot be null");
        }
        this.inter1 = inInter;
    }

    public void setInter2(Interface inInter) {
        if (inInter == null) {
            throw new InvalidParameterException("Interface cannot be null");
        }
        this.inter2 = inInter;
    }

    private void validate() {
        if (inter1 == null) {
            throw new IllegalStateException("Validation failed. Interface not initialised.");
        }
        if (inter2 == null) {
            throw new IllegalStateException("Validation failed. Interface not initialised.");
        }
    }

    public void doStuff() {
        // first we need to validate
        validate();
        inter1.doX();
        inter2.doX();
    }
}

interface Interface {

    void doX();

    void doY();
}


class Service implements Interface {

    @Override
    public void doX() {
        System.out.println("Service does X");
    }

    @Override
    public void doY() {
        System.out.println("Service does Y");
    }
}

class Injector {
    public static void main(String args[]) {
        // Object creation process
        Service service = new Service();
        Service service2 = new Service();

        ConstructorClient constructorClient = new ConstructorClient(service);
        constructorClient.doStuff();

        SetterClient setterClient = new SetterClient();
        setterClient.setInter1(service); // the fist service will also be reused;
        setterClient.setInter2(service2);
        setterClient.doStuff();
    }

}