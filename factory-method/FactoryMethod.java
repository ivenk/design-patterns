interface A {
    void doStuff();
}

class AB implements A {
    @Override
    public void doStuff() {
        System.out.println("AB");
    }
}

class AC implements A {
    @Override
    public void doStuff() {
        System.out.println("AC");
    }
}

class Factory {
    public A makeInstance(String something) {
        if (something == null) {
            return new AB();
        }
        return new AC();
    }
}


class FactoryMethod {
    public static void main(String args[]) {

        /**
         * basically the client does not need to know what object gets created and why.
         * He only wants to use the interface A and he provides some parameters to the makeInstance mthod.
         * The factory then decides what object would be a good fit and returns it.
         */
        Factory factory = new Factory();
        A ab = factory.makeInstance(null);
        A ac = factory.makeInstance("not null");
        ab.doStuff();
        ac.doStuff();
    }
}