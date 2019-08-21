class Car {
    private String make;
    private String model;
    private int doorNumbers;
    private String color;

    public Car(String inMake, String inModel, int inDoorNumbers, String inColor) {
        this.make = inMake;
        this.model = inModel;
        this.doorNumbers = inDoorNumbers;
        this.color = inColor;
    }
}

interface ICarBuilder {
    void setColor (String inColor);
    void setDoorNumber (int doorNumber);

    Car getResult();
}

class SportsCarBuildDirector {
    private ICarBuilder carBuilder;

    public SportsCarBuildDirector(ICarBuilder inICarBuilder) {
        this.carBuilder = inICarBuilder;
    }

    public void build() {
        carBuilder.setColor("Red");
        carBuilder.setDoorNumber(2);
    }
}

class FerrariBuilder implements ICarBuilder{
    String color;
    int doorNumber;

    @Override
    public void setDoorNumber(int inDoorNumber) {
        this.doorNumber = inDoorNumber;
    }

    @Override
    public void setColor(String inColor) {
        this.color = inColor;
    }

    public Car getResult() {
        return new Car("Ferrari", "488 Spider", this.doorNumber, this.color);
    }
}


class User {

    public static void main(String args[]) {
        ICarBuilder carBuilder = new FerrariBuilder();
        SportsCarBuildDirector director = new SportsCarBuildDirector(carBuilder);

        director.build();
        Car newCar = carBuilder.getResult();
    }
}