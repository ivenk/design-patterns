import java.util.ArrayList;
import java.util.List;

class Subject {
    List<IObserver> observers = new ArrayList<>();

    private void updateObservers(String event) {
        observers.forEach(observer -> observer.update(event));
    }

    public void doStuff(String event) {
        updateObservers(event);
    }
}

interface IObserver {
    void update(String event);
}