class Singleton {

    private static Singleton instance = new Singleton();
    private Singleton(){}

    public static Singleton getInstance() {
        return instance;
    }

}

class LazySingleton {

    private LazySingleton instance;
    private LazySingleton(){}

    public static LazySingleton getInstance() {
        if (this.instance == null) {
            synchronized (LazySingleton.class) {
                if (this.instance == null) {
                    this.instance = new LazySingleton();
                }
            }
        }
        return this.instance;
    }
}